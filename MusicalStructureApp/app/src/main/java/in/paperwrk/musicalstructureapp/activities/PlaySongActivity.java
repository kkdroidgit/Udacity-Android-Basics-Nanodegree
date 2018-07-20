package in.paperwrk.musicalstructureapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.musicalstructureapp.R;

public class PlaySongActivity extends AppCompatActivity {

    @BindView(R.id.playSong) ImageView imageView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.animationView)
    LottieAnimationView lottieAnimationView;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying){
                    imageView.setImageResource(R.drawable.ic_pause_black_24dp);
                    isPlaying = true;
                    lottieAnimationView.playAnimation();
                }
                else {
                    imageView.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    isPlaying = false;
                    lottieAnimationView.cancelAnimation();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_player_activity, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}