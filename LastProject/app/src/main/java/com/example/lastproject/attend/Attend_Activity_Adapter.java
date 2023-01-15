package com.example.lastproject.attend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastproject.R;
import com.example.lastproject.al.AlVO;

import java.util.ArrayList;

public class Attend_Activity_Adapter extends RecyclerView.Adapter<Attend_Activity_Adapter.ViewHolder> {

    public Attend_Activity_Adapter(LayoutInflater inflater, ArrayList<AlVO> al_list, AttendActivity attendActivity) {
        this.inflater = inflater;
        this.al_list = al_list;
    }

    LayoutInflater inflater;
    ArrayList<AlVO> al_list;
    AttendActivity attendActivity;





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_attend_apply,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
    h.apply_result.setText(al_list.get(i).getAl_status());
    h.apply_date.setText(al_list.get(i).getAl_reg_date());
    h.apply_what.setText(al_list.get(i).getAl_reason());


    }

    @Override
    public int getItemCount() {
        return al_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView apply_result,   apply_what, apply_date , detail;
       ImageView check;

        public ViewHolder(@NonNull View v) {
            super(v);
            apply_result = v.findViewById(R.id.apply_result);
            apply_what = v.findViewById(R.id.apply_what);
            apply_date = v.findViewById(R.id.apply_date);
            detail = v.findViewById(R.id.detail);
            check = v.findViewById(R.id.check);
        }
    }
}
