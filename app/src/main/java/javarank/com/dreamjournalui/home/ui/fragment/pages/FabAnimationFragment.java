package javarank.com.dreamjournalui.home.ui.fragment.pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.github.fabtransitionactivity.SheetLayout;
import com.shuvam.triangleindicator.TriangularIndicator;

import butterknife.BindView;
import butterknife.OnClick;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.home.ui.adapter.TabPagerAdapter;
import javarank.com.dreamjournalui.home.ui.adapter.ViewPagerAdapter;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.FillFragment;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.FirstSectionFragment;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.ProfileFragment;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.SecondSectionFragment;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.ThirdSectionFragment;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.UndoFragment;

public class FabAnimationFragment extends BasePageFragment implements SheetLayout.OnFabAnimationEndListener {
    public static final String TAG = FabAnimationFragment.class.getSimpleName();

    private static final int REQUEST_CODE = 1;

    @BindView(R.id.scroll_position_text_view)
    TextView scrollPositionTextView;
    @BindView(R.id.bottom_sheet)
    SheetLayout mSheetLayout;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    TabPagerAdapter adapter;

    public static FabAnimationFragment newInstance() {
        FabAnimationFragment fragment = new FabAnimationFragment();
        return fragment;
    }

    @Override
    public void updatePagePosition(int currentPosition, int totalPages) {
        scrollPositionTextView.setText("" + (currentPosition + 1) + " of " + totalPages);
    }

    @Override
    protected void init() {
        mSheetLayout.setFab(mFab);
        mSheetLayout.setFabAnimationEndListener(this);
        setUpViewPager();
    }

    private void setUpViewPager() {
        adapter = new TabPagerAdapter(getChildFragmentManager(), getContext());
        adapter.addFragment(UndoFragment.getInstance(), getString(R.string.undo), R.drawable.baseline_undo_black_24);
        adapter.addFragment(FillFragment.getInstance(), getString(R.string.fill), R.drawable.baseline_format_color_fill_black_24);
        adapter.addFragment(ProfileFragment.getInstance(), getString(R.string.profile), R.drawable.baseline_account_circle_black_24);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        highLightCurrentTab(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void highLightCurrentTab(int position) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(adapter.getTabView(i));
        }
        TabLayout.Tab tab = tabLayout.getTabAt(position);
        assert tab != null;
        tab.setCustomView(null);
        tab.setCustomView(adapter.getSelectedTabView(position));
    }


    @OnClick(R.id.fab)
    void onFabClick() {
        mSheetLayout.expandFab();
    }

    @Override
    public void onFabAnimationEnd() {
        mSheetLayout.contractFab();
        //TODO you can start your activity here....
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            mSheetLayout.contractFab();
        }
    }

    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fab_animation, container, false);
    }

}