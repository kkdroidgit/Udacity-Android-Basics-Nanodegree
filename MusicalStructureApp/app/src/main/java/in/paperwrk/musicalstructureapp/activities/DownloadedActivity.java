package in.paperwrk.musicalstructureapp.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.musicalstructureapp.R;

public class DownloadedActivity extends AppCompatActivity {

    @BindView(R.id.loading_indicator)
    LottieAnimationView lottieAnimationView;
    @BindView(R.id.error)
    ImageView imageView;
    @BindView(R.id.info_text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloaded);

        ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lottieAnimationView.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
            }
        },3600);

    }
}
