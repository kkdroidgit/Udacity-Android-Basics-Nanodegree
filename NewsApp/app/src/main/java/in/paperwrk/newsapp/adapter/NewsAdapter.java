package in.paperwrk.newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.paperwrk.newsapp.model.NewsData;
import in.paperwrk.newsapp.utils.QueryUtils;
import in.paperwrk.newsapp.R;

public class NewsAdapter extends ArrayAdapter<NewsData> {

    public NewsAdapter(Context context) {
        super(context, -1, new ArrayList<NewsData>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView
                    = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView title = convertView.findViewById(R.id.title_news);
        TextView author = convertView.findViewById(R.id.writer_news);
        TextView date = convertView.findViewById(R.id.date);
        TextView section = convertView.findViewById(R.id.news_section);
        ImageView logo = convertView.findViewById(R.id.newsIcon);

        NewsData currentNews = getItem(position);
        title.setText(currentNews.getNewsTitle());
        if (currentNews.getNewsWriter() != null){
            author.setText(currentNews.getNewsWriter());
        }

        section.setText(currentNews.getSection());

        if (currentNews.getThumbnail() != null){
            Picasso.get()
                    .load(currentNews.getThumbnail())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(logo);
        }

        String formattedDate = QueryUtils.formatParsedDate(currentNews.getNewsDate());
        date.setText(formattedDate);
        return convertView;
    }
}