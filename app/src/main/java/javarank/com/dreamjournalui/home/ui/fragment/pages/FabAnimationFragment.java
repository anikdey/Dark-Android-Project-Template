package javarank.com.dreamjournalui.home.ui.fragment.pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
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

public class FabAnimationFragment extends BasePageFragment implements SheetLayout.OnFabAnimationEndListener {
    public static final String TAG = FabAnimationFragment.class.getSimpleName();

    private static final int REQUEST_CODE = 1;

    @BindView(R.id.scroll_position_text_view)
    TextView scrollPositionTextView;

    @BindView(R.id.bottom_sheet)
    SheetLayout mSheetLayout;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.triangle)
    TriangularIndicator mCustomView;

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

        final int[] res = {R.drawable.ic_android_black_24dp,
                R.drawable.ic_archive_black_24dp,
                R.drawable.ic_audiotrack_black_24dp,
                R.drawable.ic_backup_black_24dp,
                R.drawable.ic_bluetooth_audio_black_24dp};

        mCustomView.setResources(res);

        mCustomView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                float section = (int) Math.floor(event.getX() * (res.length) / mCustomView.getWidth());

                Log.d("Touch event value", "" + section);
                return false;
            }
        });

    }

    @OnClick(R.id.fab)
    void onFabClick() {
        mSheetLayout.expandFab();
    }

    @Override
    public void onFabAnimationEnd() {
        mSheetLayout.contractFab();
        //Intent intent = new Intent(getContext(), SplashScreenActivity.class);
        //startActivityForResult(intent, REQUEST_CODE);
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