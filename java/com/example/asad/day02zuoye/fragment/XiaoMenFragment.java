package com.example.asad.day02zuoye.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asad.day02zuoye.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class XiaoMenFragment extends Fragment {


    public XiaoMenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xiao_men, container, false);
    }

}
