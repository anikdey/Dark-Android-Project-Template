package javarank.com.dreamjournalui.home.ui.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.home.ui.fragment.pages.BasePageFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();
    private final List<Integer> iconList = new ArrayList<>();
    private Context context;

    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
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

    public void addFragment(Fragment fragment, String title, int resId) {
        fragments.add(fragment);
        titles.add(title);
        iconList.add(resId);
    }

    public BasePageFragment getCurrentFragment(int position) {
        return (BasePageFragment) fragments.get(position);
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tabTextView = view.findViewById(R.id.tabTextView);
        tabTextView.setText(titles.get(position));
        ImageView tabImageView = view.findViewById(R.id.tabImageView);
        tabImageView.setImageResource(iconList.get(position));
        return view;
    }

    public View getSelectedTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tabTextView = view.findViewById(R.id.tabTextView);
        tabTextView.setText(titles.get(position));
        tabTextView.setTextColor(ContextCompat.getColor(context, R.color.white));
        ImageView tabImageView = view.findViewById(R.id.tabImageView);
        tabImageView.setImageResource(iconList.get(position));
        tabImageView.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_ATOP);
        return view;
    }

}