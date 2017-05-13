package com.abhnin.pincodelocator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by csid 3 on 5/12/2017.
 */

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private Context context;
    private List<StateData> my_data;

    public StateAdapter(Context context, List<StateData> my_data) {
        this.context = context;
        this.my_data = my_data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        System.out.println(position );
        holder.description.setText(my_data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView description;



        public ViewHolder(View itemView) {
            super(itemView);
            description = (TextView) itemView.findViewById(R.id.description);

        }
    }

    public void setFilter(List<StateData> newList){

       /* List<ActionPointData> newListNew = new ArrayList<>();
        newListNew.addAll(newList);*/

        my_data = newList;
        notifyDataSetChanged();

    }

}
