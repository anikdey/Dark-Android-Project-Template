package javarank.com.dreamjournalui.home.ui.fragment.pages;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import javarank.com.dreamjournalui.R;

public class GettingStartedFragment extends BasePageFragment {

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
        dreamRecallButton.setY(100);
        skipGuideButton.setY(100);
        dreamRecallButton.animate().translationY(-40).setDuration(500).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                skipGuideButton.animate().translationY(-40).setDuration(500);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_getting_started, container, false);
    }

    @Override
    public void updatePagePosition(int currentPosition, int totalPages) {
        scrollPositionTextView.setText(""+(currentPosition+1)+" of "+totalPages);
    }

    @OnClick(R.id.skip_guide_button)
    protected void onSkipGuideButtonClick() {
        showMessage(getString(R.string.todo));
    }

    @OnClick(R.id.dream_recall_button)
    protected void onDreamRecallButtonClick() {
        showMessage(getString(R.string.todo));
    }
}