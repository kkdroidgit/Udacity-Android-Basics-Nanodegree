package in.paperwrk.singlescreenapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cunoraz.gifview.library.GifView;

public class MainActivity extends AppCompatActivity {

    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init views
        Button follow_button = findViewById(R.id.btn_follow);
        GifView location_view = findViewById(R.id.gif_location);
        TextView phone_text = findViewById(R.id.phone_number);
        TextView mailing_address = findViewById(R.id.tv_mail);


        phone_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+1666777888";
                intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);            }
        });

        mailing_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"support@lavish.com"});
                startActivity(Intent.createChooser(intent,"Send Mail ..."));
            }
        });

        location_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(" 1120 N Street, Sacramento, California"));
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });


        follow_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/lavishforchange");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.instagram.android");
                try{
                    startActivity(intent);
                }
                catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/lavishforchange")));
                }
            }
        });


    }








}

