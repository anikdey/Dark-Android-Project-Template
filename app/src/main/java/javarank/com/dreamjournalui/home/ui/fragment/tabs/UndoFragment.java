package javarank.com.dreamjournalui.home.ui.fragment.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.common.base.fragment.BaseSupportFragment;

public class UndoFragment extends BaseSupportFragment {
    public static final String TAG = UndoFragment.class.getSimpleName();

    public static UndoFragment getInstance() {
        UndoFragment fragment = new UndoFragment();
        return fragment;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_undo, container, false);
    }
}