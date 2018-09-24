package in.paperwrk.tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.tourguideapp.adapter.FragmentAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.myPager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        viewPager.setAdapter(new FragmentAdapter(this, getSupportFragmentManager()));
        tableLayout.setupWithViewPager(viewPager);
    }

}