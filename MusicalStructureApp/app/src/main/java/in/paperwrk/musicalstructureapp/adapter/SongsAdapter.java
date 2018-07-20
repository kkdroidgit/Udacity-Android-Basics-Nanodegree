package in.paperwrk.musicalstructureapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.musicalstructureapp.activities.PlaySongActivity;
import in.paperwrk.musicalstructureapp.R;
import in.paperwrk.musicalstructureapp.model.Song;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    private ArrayList<Song> arrayList;

    public SongsAdapter(ArrayList<Song> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Song song = arrayList.get(position);
        holder.txtSongName.setText(song.getSongName());
        holder.textSongArtist.setText(song.getSongArtistName());
        Picasso.get().load(song.getThumbnail()).into(holder.songThumbnail);

        holder.txtSongName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(),PlaySongActivity.class));
            }
        });

        holder.songOverflowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        Context mContext;
        @BindView(R.id.songName) TextView txtSongName;
        @BindView(R.id.songArtist) TextView textSongArtist;
        @BindView(R.id.thumbnail) ImageView songThumbnail;
        @BindView(R.id.song_overflow_button) ImageButton songOverflowButton;


        ViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            ButterKnife.bind(this,itemView);
        }
    }

    private void showPopup(View v){
        PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_actions, popupMenu.getMenu());
        popupMenu.show();
    }
}