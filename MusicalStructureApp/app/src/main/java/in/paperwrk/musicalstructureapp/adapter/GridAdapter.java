package in.paperwrk.musicalstructureapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.paperwrk.musicalstructureapp.R;
import in.paperwrk.musicalstructureapp.model.Song;

public class GridAdapter extends ArrayAdapter<Song> {

    public GridAdapter(@NonNull Context context, ArrayList<Song> list) {
        super(context, 0,list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.album_row,parent,false);
        }

        Song song = getItem(position);
        assert song != null;

        ImageView image = view.findViewById(R.id.album_image);
        Picasso.get().load(song.getThumbnail()).into(image);

        TextView category_name = view.findViewById(R.id.album_title);
        category_name.setText(song.getSongName());
        return view;
    }
}