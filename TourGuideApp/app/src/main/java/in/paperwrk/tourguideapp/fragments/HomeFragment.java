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
import in.paperwrk.tourguideapp.adapter.CustomAdapter;
import in.paperwrk.tourguideapp.model.ModelClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public HomeFragment() {
        // Required empty public constructor
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

        loadData();
        return view;
    }

    private void loadData(){
        ArrayList<ModelClass> mArrayList = new ArrayList<>();

        mArrayList.add(new ModelClass(getString(R.string.name1)));
        mArrayList.add(new ModelClass(getString(R.string.name2)));
        mArrayList.add(new ModelClass(getString(R.string.name3)));
        mArrayList.add(new ModelClass(getString(R.string.name4)));
        mArrayList.add(new ModelClass(getString(R.string.name5)));
        mArrayList.add(new ModelClass(getString(R.string.name6)));
        mArrayList.add(new ModelClass(getString(R.string.name7)));
        mArrayList.add(new ModelClass(getString(R.string.name8)));
        mArrayList.add(new ModelClass(getString(R.string.name9)));
        mArrayList.add(new ModelClass(getString(R.string.name10)));
        mArrayList.add(new ModelClass(getString(R.string.name11)));
        mArrayList.add(new ModelClass(getString(R.string.name12)));
        mArrayList.add(new ModelClass(getString(R.string.name13)));
        mArrayList.add(new ModelClass(getString(R.string.name14)));
        mArrayList.add(new ModelClass(getString(R.string.name15)));

        CustomAdapter adapter = new CustomAdapter(mArrayList);
        mRecyclerView.setAdapter(adapter);
    }
}