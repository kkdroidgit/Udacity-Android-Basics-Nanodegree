package in.paperwrk.tourguideapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.tourguideapp.R;
import in.paperwrk.tourguideapp.adapter.ShopAdapter;
import in.paperwrk.tourguideapp.model.ModelClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {

    @BindView(R.id.events_rv)
    RecyclerView mRecyclerView;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this,view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        loadData();
        return view;
    }

    private void loadData(){
        ArrayList<ModelClass> mArrayList = new ArrayList<>();
        mArrayList.add(new ModelClass(getString(R.string.shop1)));
        mArrayList.add(new ModelClass(getString(R.string.shop2)));
        mArrayList.add(new ModelClass(getString(R.string.shop3)));
        mArrayList.add(new ModelClass(getString(R.string.shop4)));
        mArrayList.add(new ModelClass(getString(R.string.shop5)));
        mArrayList.add(new ModelClass(getString(R.string.shop6)));
        mArrayList.add(new ModelClass(getString(R.string.shop7)));
        mArrayList.add(new ModelClass(getString(R.string.shop8)));
        mArrayList.add(new ModelClass(getString(R.string.shop9)));
        mArrayList.add(new ModelClass(getString(R.string.shop10)));
        ShopAdapter adapter = new ShopAdapter(mArrayList);
        mRecyclerView.setAdapter(adapter);
    }
}