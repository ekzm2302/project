package com.example.lastproject.ea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastproject.MainActivity;
import com.example.lastproject.R;
import com.example.lastproject.common.Common;

import java.util.ArrayList;

public class EaRecentListAdapter extends RecyclerView.Adapter<EaRecentListAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<EaVO> list;
    MainActivity activity ;

    public EaRecentListAdapter(LayoutInflater inflater, ArrayList<EaVO> list, MainActivity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_ea_recentlist,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.tv_title.setText(list.get(i).getEa_title());
        h.tv_name_date.setText(Common.loginInfo.getEmp_name()+" | " + list.get(i).getEa_date());
        h.tv_process.setText(list.get(i).getEa_status());
    }

    @Override
    public int getItemCount() {
        return list.size()>=10 ? 10 : list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_name_date, tv_process;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_title = v.findViewById(R.id.tv_title);
            tv_name_date = v.findViewById(R.id.tv_name_date);
            tv_process = v.findViewById(R.id.tv_process);
        }
    }
}