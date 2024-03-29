package com.codeslayers.hack.travelcheap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by mukulsoftwap on 9/23/2016.
 */
public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    // recyclerview adapter
    private Context context;
    private ArrayList<Step> data;

    public RecyclerView_Adapter(Context context, ArrayList<Step> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final Step model = data.get(position);
        RecyclerViewHolder mainHolder = holder;// holder
        mainHolder.distance.setText(model.getDistance()+"");
        mainHolder.duration.setText(model.getDuration()+"");
        mainHolder.fare.setText((int) model.getFare()+"");
        mainHolder.mode.setText(model.getMode()+"");
        if(model.getMode().contains("Walking")){
            mainHolder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.walking));
        }else if(model.getMode().contains("Bus")){
            mainHolder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.bus));
        }else if(model.getMode().contains("Metro")){
            mainHolder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.metro));
        }
        if(position%2==0){
            mainHolder.image2.setImageDrawable(context.getResources().getDrawable(R.drawable.one));
        }else{
            mainHolder.image2.setImageDrawable(context.getResources().getDrawable(R.drawable.two));
        }

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.fareview, viewGroup, false);
        RecyclerViewHolder listHolder = new RecyclerViewHolder(mainGroup);
        return listHolder;
    }
}