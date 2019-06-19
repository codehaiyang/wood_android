package com.yundongjia.mucai.adapter;

import com.yundongjia.mucai.base.BaseFragment;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @author daxiong
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    private final FragmentManager fm;
    private List<BaseFragment> mFragments;

    public TabPagerAdapter(@NonNull FragmentManager fm, List<BaseFragment> mFragments) {
        super(fm);
        this.fm = fm;
        this.mFragments = mFragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }


    @Override
    public int getCount() {
        return mFragments.size();
    }

}
