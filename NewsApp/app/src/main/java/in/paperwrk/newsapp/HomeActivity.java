package in.paperwrk.newsapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.thefinestartist.finestwebview.FinestWebView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.newsapp.adapter.NewsAdapter;
import in.paperwrk.newsapp.model.NewsData;
import in.paperwrk.newsapp.utils.CustomLoader;

public class HomeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsData>> {

    private NewsAdapter newsAdapter;
    @BindView(R.id.custom_loader)
    LottieAnimationView loadingIndicator;

    @BindView(R.id.list_news) ListView listView;
    @BindView(R.id.error_tv) TextView errorMessageTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        newsAdapter = new NewsAdapter(this);
        listView.setAdapter(newsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                NewsData currentFeedNews = newsAdapter.getItem(position);
                Uri feedNewsUri = Uri.parse(currentFeedNews.getNewsLink());
                new FinestWebView.Builder(HomeActivity.this).show(feedNewsUri.toString());
            }
        });

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (manager != null) {
            networkInfo = manager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()) {
            int LOADER_ID = 0;
            getSupportLoaderManager().initLoader(LOADER_ID, null, this);
        } else {
            loadingIndicator.setVisibility(View.GONE);
            errorMessageTV.setText(R.string.interneterrormessages);
        }
    }

    @NonNull
    @Override
    public Loader<List<NewsData>> onCreateLoader(int id, Bundle args) {
        return new CustomLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<NewsData>> loader, List<NewsData> data) {
        if (data != null) {
            loadingIndicator.setVisibility(View.GONE);
            newsAdapter.setNotifyOnChange(false);
            newsAdapter.clear();
            newsAdapter.setNotifyOnChange(true);
            newsAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<NewsData>> loader) {
    }
}