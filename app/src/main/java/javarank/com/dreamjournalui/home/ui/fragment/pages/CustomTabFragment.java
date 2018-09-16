package javarank.com.dreamjournalui.home.ui.fragment.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shuvam.triangleindicator.TriangularIndicator;
import butterknife.BindView;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.FifthSectionFragment;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.FirstSectionFragment;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.FourthSectionFragment;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.SecondSectionFragment;
import javarank.com.dreamjournalui.home.ui.fragment.tabs.ThirdSectionFragment;

public class CustomTabFragment extends BasePageFragment {
    public static final String TAG = CustomTabFragment.class.getSimpleName();

    @BindView(R.id.scroll_position_text_view)
    TextView scrollPositionTextView;
    @BindView(R.id.triangle)
    TriangularIndicator mCustomView;

    private FirstSectionFragment firstSectionFragment;
    private SecondSectionFragment secondSectionFragment;
    private ThirdSectionFragment thirdSectionFragment;
    private FourthSectionFragment fourthSectionFragment;
    private FifthSectionFragment fifthSectionFragment;

    public static CustomTabFragment newInstance() {
        CustomTabFragment fragment = new CustomTabFragment();
        return fragment;
    }

    @Override
    public void updatePagePosition(int currentPosition, int totalPages) {
        scrollPositionTextView.setText("" + (currentPosition + 1) + " of " + totalPages);
    }

    @Override
    protected void init() {
        final int[] res = {R.drawable.ic_android_black_24dp, R.drawable.ic_archive_black_24dp, R.drawable.ic_audiotrack_black_24dp, R.drawable.ic_backup_black_24dp, R.drawable.ic_bluetooth_audio_black_24dp};

        createSectionFragments();
        setUpFirstSection();

        mCustomView.setResources(res);
        mCustomView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float section = (int) Math.floor(event.getX() * (res.length) / mCustomView.getWidth());
                if( section == 0 ) {
                    setUpFirstSection();
                } else if( section == 1 ) {
                    setUpSecondSection();
                } else if( section == 2 ) {
                    setUpThirdSection();
                } else if( section == 3 ) {
                    setUpFourthSection();
                } else if( section == 4 ) {
                    setUpFifthSection();
                }
                return false;
            }
        });
    }

    private void createSectionFragments() {
        firstSectionFragment = FirstSectionFragment.getInstance();
        secondSectionFragment = SecondSectionFragment.getInstance();
        thirdSectionFragment = ThirdSectionFragment.getInstance();
        fourthSectionFragment = FourthSectionFragment.getInstance();
        fifthSectionFragment = FifthSectionFragment.getInstance();
    }

    private void setUpFirstSection() {
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, firstSectionFragment, FirstSectionFragment.TAG).commit();
    }

    private void setUpSecondSection() {
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, secondSectionFragment, SecondSectionFragment.TAG).commit();
    }

    private void setUpThirdSection() {
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, thirdSectionFragment, ThirdSectionFragment.TAG).commit();
    }

    private void setUpFourthSection() {
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, fourthSectionFragment, FourthSectionFragment.TAG).commit();
    }

    private void setUpFifthSection() {
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, fifthSectionFragment, FifthSectionFragment.TAG).commit();
    }


    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_tab, container, false);
    }

}