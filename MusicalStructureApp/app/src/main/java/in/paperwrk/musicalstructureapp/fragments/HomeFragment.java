package in.paperwrk.musicalstructureapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.musicalstructureapp.R;
import in.paperwrk.musicalstructureapp.adapter.SongsAdapter;
import in.paperwrk.musicalstructureapp.model.Song;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.songs_list) RecyclerView mRecyclerView;

    String names[] = new String[20];
    String artistNames[] = new String[20];
    int covers[] = new int[20];
    private static int COUNTER = 19;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this,view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (int i=0; i <= COUNTER; i++){
            names[i] = getString(R.string.text_start) + i;
        }
        for (int i=0; i< COUNTER; i++){
            artistNames[i] = getString(R.string.text_artist) + i;
        }
        for (int i=0; i< COUNTER; i++){
            covers[i] = R.drawable.song_image;
        }
        loadData();
    }

    private void loadData(){
        ArrayList<Song> mArrayList = new ArrayList<>();
        for(int i=0; i<COUNTER; i++){
            mArrayList.add(new Song(names[i],artistNames[i],covers[i]));
        }
        SongsAdapter songsAdapter = new SongsAdapter(mArrayList);
        mRecyclerView.setAdapter(songsAdapter);
    }
}