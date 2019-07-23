package com.battistradadeveloper.yasmotor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    List<DataModel> dataModelArrayList;

    public RecycleAdapter(List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView name,email,type,number,sum;
//        ImageView hapus;

        public Myholder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name1);
            email = itemView.findViewById(R.id.email1);
            type = itemView.findViewById(R.id.tipekendaraan1);
            number = itemView.findViewById(R.id.nokendaraan1);
            sum = itemView.findViewById(R.id.nominal1);

        }
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,null);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        DataModel dataModel=dataModelArrayList.get(position);
        holder.name.setText(dataModel.getName());
        holder.email.setText(dataModel.getEmail());
        holder.type.setText(dataModel.getType());
        holder.number.setText(dataModel.getNumber());
        holder.sum.setText(dataModel.getSum());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}
