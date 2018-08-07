package javarank.com.dreamjournalui.home.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import javarank.com.dreamjournalui.home.ui.fragment.pages.BasePageFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public <P extends BasePageFragment> void addFragment(P fragment, String title) {
        fragments.add(fragment);
        titles.add(title);
    }

    public BasePageFragment getCurrentFragment(int position) {
        return (BasePageFragment) fragments.get(position);
    }

}