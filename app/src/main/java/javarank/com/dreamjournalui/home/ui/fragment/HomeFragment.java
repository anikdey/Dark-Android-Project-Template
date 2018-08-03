package javarank.com.dreamjournalui.home.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.common.base.fragment.BaseSupportFragment;
import javarank.com.dreamjournalui.home.ui.adapter.ViewPagerAdapter;

public class HomeFragment extends BaseSupportFragment {
    public static final String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private ViewPagerAdapter adapter;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    protected void init() {
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new GettingStartedFragment(), "Demo 1");
        adapter.addFragment(new GettingStartedFragment(), "Demo 2");
        adapter.addFragment(new GettingStartedFragment(), "Demo 3");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());

        setUpViewPagerChangeListener();
    }

    private void setUpViewPagerChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                adapter.getCurrentFragment(position).updatePagePosition(position, adapter.getCount());

            }

            @Override
            public void onPageSelected(int position) {
                adapter.getCurrentFragment(position).updatePagePosition(position, adapter.getCount());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}