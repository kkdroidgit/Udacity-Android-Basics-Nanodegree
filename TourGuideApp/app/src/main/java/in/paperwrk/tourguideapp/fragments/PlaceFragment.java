package in.paperwrk.tourguideapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.tourguideapp.R;
import in.paperwrk.tourguideapp.adapter.GridAdapter;
import in.paperwrk.tourguideapp.adapter.Restaurants;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends Fragment {

    @BindView(R.id.gridView)
    GridView gridView;

    private ArrayList<Restaurants> arrayList = new ArrayList<>();

    public PlaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_place, container, false);

        ButterKnife.bind(this,view);

        if (arrayList.size() == 0){
            loadGrid();
        }
        GridAdapter adapter = new GridAdapter(view.getContext() ,arrayList);
        gridView.setAdapter(adapter);
        return view;
    }

    public void loadGrid(){
        arrayList.add(new Restaurants(getString(R.string.rest1)));
        arrayList.add(new Restaurants(getString(R.string.rest2)));
        arrayList.add(new Restaurants(getString(R.string.rest3)));
        arrayList.add(new Restaurants(getString(R.string.rest4)));
        arrayList.add(new Restaurants(getString(R.string.rest5)));
        arrayList.add(new Restaurants(getString(R.string.rest6)));
        arrayList.add(new Restaurants(getString(R.string.rest7)));
        arrayList.add(new Restaurants(getString(R.string.rest8)));
    }
}