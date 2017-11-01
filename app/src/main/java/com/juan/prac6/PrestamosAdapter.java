package com.juan.prac6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by juan on 25/10/17.
 */

public class PrestamosAdapter extends RecyclerView.Adapter<PrestamosAdapter.PrestamosViewHolder>{

    Context context;
    private ArrayList<User> userList;

    public PrestamosAdapter(Context context, ArrayList<User> userList) {

        this.context= context;
        this.userList= userList;
    }

    @Override
    public PrestamosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        PrestamosViewHolder contactosViewHolder= new PrestamosViewHolder(itemView);

        return contactosViewHolder;
    }

    @Override
    public void onBindViewHolder(PrestamosViewHolder holder, int position) {
        User item= userList.get(position);
        holder.bindPrestamos(item,context);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class PrestamosViewHolder extends RecyclerView.ViewHolder{

        private TextView tId, tNomlib, tPhone, tName;

        public PrestamosViewHolder(View itemView) {
            super(itemView);
            tId = itemView.findViewById(R.id.tID);
            tNomlib = itemView.findViewById(R.id.tNameLib);
            tPhone = itemView.findViewById(R.id.tPhone);
            tName = itemView.findViewById(R.id.tNombre);
        }
        public void bindPrestamos(User user, Context context){
            tId.setText(user.getUid());
            tName.setText(user.getName());
            tNomlib.setText(user.getNameB());
            tPhone.setText(user.getPhone());
        }
    }
}
