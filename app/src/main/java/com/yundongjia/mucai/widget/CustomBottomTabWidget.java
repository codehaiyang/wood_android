package com.yundongjia.mucai.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.yundongjia.mucai.R;
import com.yundongjia.mucai.adapter.TabPagerAdapter;
import com.yundongjia.mucai.base.BaseFragment;

import java.util.List;

/**
 * @author daxiong
 */
public class CustomBottomTabWidget extends LinearLayout {

    private static final String TAG = "CustomBottomTabWidget";

    @BindView(R.id.view_page)
    ViewPager mViewPager;
    @BindView(R.id.ll_menu_home)
    LinearLayout mLlMenuHome;
    @BindView(R.id.ll_menu_service)
    LinearLayout mLlMenuService;
    @BindView(R.id.ll_menu_square)
    LinearLayout mLlMenuSquare;
    @BindView(R.id.ll_menu_my)
    LinearLayout mLlMenuMy;

    private FragmentManager mFragmentManager;
    private List<BaseFragment> mFragmentList;

    public CustomBottomTabWidget(Context context) {
        this(context,null,0);
    }

    public CustomBottomTabWidget(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomBottomTabWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.widget_custom_bottom_tab, this);
        ButterKnife.bind(view);

        //默认选中首页
        selectTab(MenuTab.HOME);
    }

    public void init(FragmentManager fm, List<BaseFragment> fragmentList) {
        mFragmentManager = fm;
        mFragmentList = fragmentList;
        initViewPager();
    }

    /**
     * 初始化导航
     */
    private void initViewPager() {
        TabPagerAdapter adapter = new TabPagerAdapter(mFragmentManager,mFragmentList);
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        selectTab(MenuTab.HOME);
                        break;
                    case 1:
                        selectTab(MenuTab.SERVICE);
                        break;
                    case 2:
                        selectTab(MenuTab.SQUARE);
                        break;
                    case 3:
                        selectTab(MenuTab.MY);
                        break;
                        default:
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 点击事件集合
     */
    @OnClick({R.id.ll_menu_home, R.id.ll_menu_service, R.id.ll_menu_square, R.id.ll_menu_my})
    public void onViewClicked(View view) {
        // 使ViewPager跟随tab点击事件滑动
        switch (view.getId()) {
            case R.id.ll_menu_home:
                selectTab(MenuTab.HOME);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.ll_menu_service:
                selectTab(MenuTab.SERVICE);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.ll_menu_square:
                selectTab(MenuTab.SQUARE);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.ll_menu_my:
                selectTab(MenuTab.MY);
                mViewPager.setCurrentItem(3);
                break;
            default:

        }
    }

    /**
     * 选择tab的选择状态
     * @param tab 需要选择的标签
     */
    public void selectTab(MenuTab tab){

        // 先将所有tab取消选中，再单独设置要选中的tab
        unCheckedAll();

        switch (tab){
            case HOME:
                mLlMenuHome.setActivated(true);
                break;
            case SERVICE:
                mLlMenuService.setActivated(true);
                break;
            case SQUARE:
                mLlMenuSquare.setActivated(true);
                break;
            case MY:
                mLlMenuMy.setActivated(true);
                break;
                default:
        }
    }

    private void unCheckedAll() {
        mLlMenuHome.setActivated(false);
        mLlMenuService.setActivated(false);
        mLlMenuSquare.setActivated(false);
        mLlMenuMy.setActivated(false);
    }


    /**
     * tab的枚举类型
     */
    public enum MenuTab {
        // 主页
        HOME,
        // 服务
        SERVICE,
        // 广场
        SQUARE,
        // 我的
        MY,
    }

}
