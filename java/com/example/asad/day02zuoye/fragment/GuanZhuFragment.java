package com.example.asad.day02zuoye.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asad.day02zuoye.R;
import com.example.asad.day02zuoye.bean.BannerClass;
import com.example.asad.day02zuoye.bean.LiShiPersonClass;
import com.example.asad.day02zuoye.bean.MeiShiClass;
import com.example.asad.day02zuoye.m.MShiXian;
import com.example.asad.day02zuoye.p.PShiXian;
import com.example.asad.day02zuoye.v.ViewInterFace;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuanZhuFragment extends Fragment implements ViewInterFace{


    private View view;
    private RecyclerView mRecyl;
    private ArrayList<String> bannerlist;
    private PShiXian pShiXian;
    private GuanZhuAdapter zhuAdapter;
    private ArrayList<MeiShiClass.DataBean> meishilist;
    private ArrayList<LiShiPersonClass.ResultBean> littlelist;
    private LittleAdapter littleAdapter;

    public GuanZhuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_guan_zhu, container, false);
        pShiXian = new PShiXian(new MShiXian(), this);
        initView(inflate);
        bannerlist = new ArrayList<>();
        meishilist = new ArrayList<>();
        littlelist = new ArrayList<>();
        littleAdapter = new LittleAdapter(getContext(), littlelist);
        zhuAdapter = new GuanZhuAdapter(meishilist,bannerlist,getContext(),littleAdapter,littlelist);
        mRecyl.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyl.setAdapter(zhuAdapter);
        pShiXian.getData();
        pShiXian.getMeiShiData();
        pShiXian.getLiShiData();
        return inflate;
    }

    private void initView(View inflate) {
        mRecyl = (RecyclerView) inflate.findViewById(R.id.recyl);
    }

    @Override
    public void OnBannerChenGon(BannerClass bannerClass) {
        List<BannerClass.DataBean> data = bannerClass.getData();
        for (BannerClass.DataBean  a:data ) {
            bannerlist.add(a.getImagePath());
        }
    }

    @Override
    public void OnBannerShiBai(String no) {
        Log.i("banner解析", "OnBannerShiBai: "+no);
    }

    @Override
    public void OnMeiShiChenGon(MeiShiClass meiShiClass) {
        meishilist.addAll(meiShiClass.getData());
        zhuAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnMeiShiShiBai(String no) {
        Log.i("美食接口解析", "OnMeiShiShiBai: "+no);
    }

    @Override
    public void OnLiShiChenGon(LiShiPersonClass meiShiClass) {
        List<LiShiPersonClass.ResultBean> result = meiShiClass.getResult();
        for (LiShiPersonClass.ResultBean  a:result ) {
            Log.i("小布局错误信息", "OnLIShiShiBai: "+a.getPic());
        }
        littlelist.addAll(meiShiClass.getResult());
        littleAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnLIShiShiBai(String no) {
        Log.i("小布局错误信息", "OnLIShiShiBai: "+no);
    }
}
