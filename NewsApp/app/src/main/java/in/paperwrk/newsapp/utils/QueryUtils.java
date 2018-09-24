package in.paperwrk.newsapp.utils;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import in.paperwrk.newsapp.model.NewsData;

public class QueryUtils {

    private static final String REQ_URL = "http://content.guardianapis.com/search";
    private static final String QUERY_API_KEY = "api-key";
    private static final String QUERY_PARAM = "q";
    private static final String QUERY_THUMBNAIL = "show-fields";
    private static final String QUERY_AUTHOR = "show-tags";
    private static final String API_KEY = "06126a28-dd8e-4161-921a-92b92cd705fb";
    private static final String THUMBNAIL_VALUE = "thumbnail";
    private static final String AUTHOR_VALUE = "contributor";

    static URL formURL() {

        Uri.Builder builder = Uri.parse(REQ_URL).buildUpon();
        builder.appendQueryParameter(QUERY_PARAM, "android")
                .appendQueryParameter(QUERY_THUMBNAIL, THUMBNAIL_VALUE)
                .appendQueryParameter(QUERY_AUTHOR, AUTHOR_VALUE)
                .appendQueryParameter(QUERY_API_KEY, API_KEY);

        String stringUrl = builder.toString();
        try {
            return new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("Log", "Error creating URL", e);
            return null;
        }
    }

    static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null){
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e("log", "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("log", "HTTP error: ", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    static List<NewsData> parseJsonResponse(String response) {
        ArrayList<NewsData> newsList = new ArrayList<>();
        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONObject jsonResults = jsonResponse.getJSONObject("response");
            JSONArray resultsArray = jsonResults.getJSONArray("results");

            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject resultJSON = resultsArray.getJSONObject(i);
                String webTitle = resultJSON.optString("webTitle");
                String section = resultJSON.optString("sectionName");
                String link = resultJSON.optString("webUrl");
                String date = resultJSON.optString("webPublicationDate");
                JSONArray tagsArray = resultJSON.optJSONArray("tags");

                String writer = "";
                if (tagsArray!= null && tagsArray.length() > 0) {
                    JSONObject firstObject = (JSONObject) tagsArray.get(0);
                    writer = firstObject.optString("webTitle");
                }

                String thumbnailURL = "";
                JSONObject fields = resultJSON.optJSONObject("fields");
                if (fields != null){
                    thumbnailURL = fields.optString("thumbnail");
                }

                newsList.add(new NewsData(webTitle,date, link, writer,section, thumbnailURL));
            }
        } catch (JSONException e) {
            Log.e("Log", "Error in JSON response", e);
        }
        return newsList;
    }

    public static String formatParsedDate(String publishDate) {
        String formattedDate = "";
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        try {
            Date date = inputFormat.parse(publishDate);
            formattedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
}