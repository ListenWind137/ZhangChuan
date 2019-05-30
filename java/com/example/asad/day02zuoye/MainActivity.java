package com.example.asad.day02zuoye;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.asad.day02zuoye.fragment.GuanZhuFragment;
import com.example.asad.day02zuoye.fragment.XiaoMenFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTbl;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        final String[] title={"校门","关注"};
        fragments = new ArrayList<>();
        fragments.add(new GuanZhuFragment());
        fragments.add(new XiaoMenFragment());
        mVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
        mTbl.setupWithViewPager(mVp);
    }

    private void initView() {
        mTbl = (TabLayout) findViewById(R.id.tbl);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
