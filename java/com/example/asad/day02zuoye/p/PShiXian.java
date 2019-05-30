package com.example.asad.day02zuoye.p;

import com.example.asad.day02zuoye.bean.BannerClass;
import com.example.asad.day02zuoye.bean.LiShiPersonClass;
import com.example.asad.day02zuoye.bean.MeiShiClass;
import com.example.asad.day02zuoye.m.CallBack;
import com.example.asad.day02zuoye.m.MShiXian;
import com.example.asad.day02zuoye.v.ViewInterFace;

/**
 * Created by 13768 on 2019/5/30.
 */

public class PShiXian implements PInterFace,CallBack{
    private MShiXian mShiXian;

    public PShiXian(MShiXian mShiXian, ViewInterFace viewInterFace) {
        this.mShiXian = mShiXian;
        this.viewInterFace = viewInterFace;
    }

    private ViewInterFace viewInterFace;
    @Override
    public void getData() {
        if (mShiXian!=null) {
            mShiXian.getBannerData(this);
        }
    }

    @Override
    public void getMeiShiData() {
        if (mShiXian!=null) {
            mShiXian.getMeiShiData(this);
        }
    }

    @Override
    public void getLiShiData() {
        if (mShiXian!=null) {
            mShiXian.getLiShiData(this);
        }
    }

    @Override
    public void OnBannerChenGon(BannerClass bannerClass) {
        if (viewInterFace!=null) {
            viewInterFace.OnBannerChenGon(bannerClass);
        }
    }

    @Override
    public void OnBannerShiBai(String no) {
        if (viewInterFace!=null) {
            viewInterFace.OnBannerShiBai(no);
        }
    }

    @Override
    public void OnMeiShiChenGon(MeiShiClass meiShiClass) {
        if (viewInterFace!=null) {
            viewInterFace.OnMeiShiChenGon(meiShiClass);
        }
    }

    @Override
    public void OnMeiShiShiBai(String no) {
        if (viewInterFace!=null) {
            viewInterFace.OnMeiShiShiBai(no);
        }
    }

    @Override
    public void OnLiShiChenGon(LiShiPersonClass meiShiClass) {
        if (viewInterFace!=null) {
            viewInterFace.OnLiShiChenGon(meiShiClass);
        }
    }

    @Override
    public void OnLIShiShiBai(String no) {
        if (viewInterFace!=null) {
            viewInterFace.OnLIShiShiBai(no);
        }
    }
}
