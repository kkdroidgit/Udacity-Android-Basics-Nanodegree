package in.paperwrk.newsapp.utils;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import in.paperwrk.newsapp.model.NewsData;

public class CustomLoader extends AsyncTaskLoader<List<NewsData>> {

    public CustomLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<NewsData> loadInBackground() {
        List<NewsData> newsData = null;
        try {
            URL url = QueryUtils.formURL();
            String jsonResponse = QueryUtils.makeHttpRequest(url);
            newsData = QueryUtils.parseJsonResponse(jsonResponse);
        } catch (IOException e) {
            Log.e("Log", "Error  ", e);
        }
        return newsData;
    }
}