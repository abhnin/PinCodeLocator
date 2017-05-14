package com.abhnin.pincodelocator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sony on 5/14/2017.
 */

public class PinCodeAdapter extends RecyclerView.Adapter<PinCodeAdapter.ViewHolder> {

    private Context context;
    private List<PinCodeData> my_data;

    public PinCodeAdapter(Context context, List<PinCodeData> my_data) {
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
        holder.locality.setText(my_data.get(position).getLocality() + " - "+my_data.get(position).getPin());
    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView locality;



        public ViewHolder(View itemView) {
            super(itemView);
            locality = (TextView) itemView.findViewById(R.id.description);

        }
    }
}
