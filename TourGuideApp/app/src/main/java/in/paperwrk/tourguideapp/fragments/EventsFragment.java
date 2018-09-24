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
import in.paperwrk.tourguideapp.adapter.EventAdapter;
import in.paperwrk.tourguideapp.model.ModelClass;

public class EventsFragment extends Fragment {

    @BindView(R.id.events_rv)
    RecyclerView mRecyclerView;

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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

        mArrayList.add(new ModelClass(getString(R.string.event1)));
        mArrayList.add(new ModelClass(getString(R.string.event2)));
        mArrayList.add(new ModelClass(getString(R.string.event3)));
        mArrayList.add(new ModelClass(getString(R.string.event4)));
        mArrayList.add(new ModelClass(getString(R.string.event5)));
        mArrayList.add(new ModelClass(getString(R.string.event6)));
        mArrayList.add(new ModelClass(getString(R.string.event7)));
        mArrayList.add(new ModelClass(getString(R.string.event_8)));
        mArrayList.add(new ModelClass(getString(R.string.event9)));
        mArrayList.add(new ModelClass(getString(R.string.event_10)));
        mArrayList.add(new ModelClass(getString(R.string.event_11)));


        EventAdapter adapter = new EventAdapter(mArrayList);
        mRecyclerView.setAdapter(adapter);
    }
}