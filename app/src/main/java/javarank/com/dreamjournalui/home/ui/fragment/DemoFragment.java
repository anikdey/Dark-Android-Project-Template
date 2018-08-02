package javarank.com.dreamjournalui.home.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.common.base.fragment.BaseSupportFragment;

public class DemoFragment extends BasePageFragment {

    @BindView(R.id.dream_recall_button)
    Button dreamRecallButton;
    @BindView(R.id.skip_guide_button)
    Button skipGuideButton;
    @BindView(R.id.scroll_position_text_view)
    TextView scrollPositionTextView;

    @Override
    protected void init() {
        startButtonAnimation();
    }


    private void startButtonAnimation() {
        dreamRecallButton.setY(-10000);
        skipGuideButton.setY(-10000);

        dreamRecallButton.animate().translationY(10000).setDuration(1500);
    }

    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo, container, false);
    }

    @Override
    public void updatePagePosition(int currentPosition, int totalPages) {
        scrollPositionTextView.setText(""+(currentPosition+1)+" of "+totalPages);
    }
}
