package com.yundongjia.mucai.activity;

import com.yundongjia.mucai.R;
import com.yundongjia.mucai.base.BaseActivity;
import com.yundongjia.mucai.base.BaseFragment;
import com.yundongjia.mucai.fragment.HomeFagment;
import com.yundongjia.mucai.fragment.MineFragment;
import com.yundongjia.mucai.fragment.ServiceFragment;
import com.yundongjia.mucai.fragment.SquareFragment;
import com.yundongjia.mucai.widget.CustomBottomTabWidget;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * @author daxiong
 */
public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.tab_widget)
    CustomBottomTabWidget mTabWidget;

    private MainActivity mContext;
    private List<BaseFragment> mFragments;

    @Override
    protected void initView() {

        mContext = this;

        mFragments = new ArrayList<>();
        mFragments.add(new HomeFagment());
        mFragments.add(new ServiceFragment());
        mFragments.add(new SquareFragment());
        mFragments.add(new MineFragment());

        mTabWidget.init(getSupportFragmentManager(),mFragments);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
