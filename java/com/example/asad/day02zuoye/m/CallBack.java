package com.example.asad.day02zuoye.m;

import com.example.asad.day02zuoye.bean.BannerClass;
import com.example.asad.day02zuoye.bean.LiShiPersonClass;
import com.example.asad.day02zuoye.bean.MeiShiClass;

/**
 * Created by 13768 on 2019/5/30.
 */

public interface CallBack {
    void OnBannerChenGon(BannerClass bannerClass);
    void OnBannerShiBai(String no);

    void OnMeiShiChenGon(MeiShiClass meiShiClass);
    void OnMeiShiShiBai(String no);

    void OnLiShiChenGon(LiShiPersonClass meiShiClass);
    void OnLIShiShiBai(String no);
}
