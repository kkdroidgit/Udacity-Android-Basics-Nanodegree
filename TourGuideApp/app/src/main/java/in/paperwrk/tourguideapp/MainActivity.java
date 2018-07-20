package in.paperwrk.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    private AccountHeader headerResult = null;

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final IProfile profile = new ProfileDrawerItem().withName("sample")
                .withEmail("sample");

        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                //.withHeaderBackground(R.drawable.header)
                .addProfiles(profile)
                .withSavedInstance(savedInstanceState)
                .build();

        createNavDrawer(savedInstanceState, toolbar);

        if(savedInstanceState == null){
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content, new HomeFragment()).commit();
        }

    }

    private void createNavDrawer(Bundle savedInstanceState, Toolbar toolbar) {
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.home)
                                .withIcon(R.drawable.ic_home_black_24dp).withIdentifier(1).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.recents)
                                .withIcon(R.drawable.ic_recents_black_24dp).withIdentifier(2).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.top_charts)
                                .withIcon(R.drawable.ic_star_black_24dp).withIdentifier(3).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.releases)
                                .withIcon(R.drawable.ic_new_releases_black_24dp).withIdentifier(4).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.albums)
                                .withIcon(R.drawable.ic_library_music_black_24dp).withIdentifier(5).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.stations)
                                .withIcon(R.drawable.ic_wifi_tethering_black_24dp).withIdentifier(6).withSelectable(false),

                        new DividerDrawerItem(),
                        new SwitchDrawerItem().withName(R.string.down_only).withIdentifier(7),
                        new PrimaryDrawerItem().withName(R.string.settings),
                        new PrimaryDrawerItem().withName(R.string.hpf)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null){
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 5){
                                intent = new Intent(MainActivity.this,AlbumsActivity.class);
                            }
                            else if(drawerItem.getIdentifier() == 7){
                                intent = new Intent(MainActivity.this,DownloadedActivity.class);
                            }
                            if (intent != null){
                                startActivity(intent);
                            }
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
    }

}
