package in.paperwrk.tourguideapp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.paperwrk.tourguideapp.fragments.EventsFragment;
import in.paperwrk.tourguideapp.fragments.HomeFragment;
import in.paperwrk.tourguideapp.fragments.PlaceFragment;
import in.paperwrk.tourguideapp.fragments.ShopFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(Context context,FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new PlaceFragment();
            case 2:
                return new EventsFragment();
            default:
                return new ShopFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Places";
            case 1:
                return "Restaurants";
            case 2:
                return "Events";
            default:
                return "Shop";
        }
    }
}