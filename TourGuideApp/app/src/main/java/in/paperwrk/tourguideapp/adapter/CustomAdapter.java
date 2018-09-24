package in.paperwrk.tourguideapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.paperwrk.tourguideapp.R;
import in.paperwrk.tourguideapp.model.ModelClass;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private ArrayList<ModelClass> arrayList;

    public CustomAdapter(ArrayList<ModelClass> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        ModelClass modelClass = arrayList.get(position);
        holder.textView.setText(modelClass.getNames());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        Context context;
        @BindView(R.id.title)
        TextView textView;

        ViewHolder(View itemView){
            super(itemView);
            context = itemView.getContext();
            ButterKnife.bind(this,itemView);
        }
    }
}