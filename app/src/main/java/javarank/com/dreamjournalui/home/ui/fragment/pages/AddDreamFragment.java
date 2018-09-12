package javarank.com.dreamjournalui.home.ui.fragment.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import javarank.com.dreamjournalui.R;

public class AddDreamFragment extends BasePageFragment {
    public static final String TAG = AddDreamFragment.class.getSimpleName();

    @BindView(R.id.scroll_position_text_view)
    TextView scrollPositionTextView;

    public static AddDreamFragment getInstance() {
        AddDreamFragment fragment = new AddDreamFragment();
        return fragment;
    }

    @Override
    public void updatePagePosition(int currentPosition, int totalPages) {
        scrollPositionTextView.setText("" + (currentPosition + 1) + " of " + totalPages);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_dream, container, false);
    }
}
