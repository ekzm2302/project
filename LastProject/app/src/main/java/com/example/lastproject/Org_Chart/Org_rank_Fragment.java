package com.example.lastproject.Org_Chart;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.conn.CommonMethod;
import com.example.lastproject.MainActivity;
import com.example.lastproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class Org_rank_Fragment extends Fragment {

    RecyclerView recyclerview;
    ArrayList<OrgVO> list;
    MainActivity activity;
    EditText text_search;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_org_rank_, container, false);


        recyclerview =v.findViewById(R.id.recv_org_rank);

        text_search = v.findViewById(R.id.text_search);
        text_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_search.length() >=0){
                    new CommonMethod().setParams("keyword",text_search.getText().toString()).sendPost("org_all_r.org",(isResult, data) -> {
                        list = new Gson().fromJson(data, new TypeToken<ArrayList<OrgVO>>(){}.getType());
                        recyclerview.setAdapter(new Org_all_adapter(getLayoutInflater(),list,activity));
                        recyclerview.setLayoutManager(CommonMethod.getVManager(getContext()));
                    });
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /*리사이클러뷰 - 조직도 목록 보여주기*/
        new CommonMethod().sendPost("org_rank.org",(isResult, data) -> {
            list = new Gson().fromJson(data, new TypeToken<ArrayList<OrgVO>>(){}.getType());
            recyclerview.setAdapter(new Org_all_adapter(getLayoutInflater(),list,activity));
            recyclerview.setLayoutManager(CommonMethod.getVManager(getContext()));
        });

        return v;
    }
}