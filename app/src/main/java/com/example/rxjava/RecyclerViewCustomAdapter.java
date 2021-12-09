package com.example.rxjava;

import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewCustomAdapter extends RecyclerView.Adapter<RecyclerViewCustomAdapter.RVCustomAdapterMyViewHOlder> {

    private final List<String> stringValues = new ArrayList<>();


    @NonNull
    @Override
    public RVCustomAdapterMyViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
      RVCustomAdapterMyViewHOlder myViewHOlder = new RVCustomAdapterMyViewHOlder(view);

      return myViewHOlder;


    }

    @Override
    public void onBindViewHolder(@NonNull RVCustomAdapterMyViewHOlder holder, int position) {
        holder.txtName.setText(stringValues.get(position));

    }

    @Override
    public int getItemCount() {
        return stringValues.size();
    }

   public void addStringToList (String value){
        stringValues.add(value);
        notifyItemInserted(stringValues.size() - 1);
    }

    public class RVCustomAdapterMyViewHOlder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtName)
        TextView txtName;

        public RVCustomAdapterMyViewHOlder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
