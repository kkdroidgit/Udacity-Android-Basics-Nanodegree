package in.paperwrk.musicalstructureapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.musicalstructureapp.R;
import in.paperwrk.musicalstructureapp.model.Song;
import in.paperwrk.musicalstructureapp.adapter.GridAdapter;

public class AlbumsActivity extends AppCompatActivity {

    @BindView(R.id.grid_view) GridView mGridView;
    private ArrayList<Song> mArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        ButterKnife.bind(this);
        if (mArrayList.size() == 0){
            loadGrid();
        }
        GridAdapter adapter = new GridAdapter(getBaseContext() ,mArrayList);
        mGridView.setAdapter(adapter);
    }

    public void loadGrid(){
        mArrayList.add(new Song(getString(R.string.songOne), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songTwo), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songThree), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songFour), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songFive), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songSix), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songSeven), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songEight), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songNine), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songTen), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songEleven), R.drawable.cover));
        mArrayList.add(new Song(getString(R.string.songTwelve), R.drawable.cover));
    }
}
