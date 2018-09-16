package javarank.com.dreamjournalui.home.ui.fragment.pages;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.common.util.CommonUtil;

public class SecondFragment extends BasePageFragment {

    @BindView(R.id.scroll_position_text_view)
    TextView scrollPositionTextView;
    @BindView(R.id.what_happened_edit_text)
    EditText whatHappenedEditText;
    @BindView(R.id.count_text_view)
    TextView wordCountTextView;

    @Override
    protected void init() {
        setUpWordCount(0);
        //CommonUtil.setTextWatcherToShowMaximumLimitReachedMessage(whatHappenedEditText, getResources().getInteger(R.integer.max_limit_10));
        setUpTextWatcher();
    }

    private void setUpTextWatcher() {
        whatHappenedEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( s.length() >= getResources().getInteger(R.integer.max_limit_10) ) {
                    Toast.makeText(getContext(), getContext().getString(R.string.maximum_character_limit_reached), Toast.LENGTH_SHORT).show();
                }
                setUpWordCount(count);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setUpWordCount(int words) {
        wordCountTextView.setText(String.format(getString(R.string.word_count), words, getResources().getInteger(R.integer.max_limit_10)));
    }

    @OnClick(R.id.save_dream_button)
    protected void onSaveDreamButtonClick() {
        showMessage(getString(R.string.todo));
    }

    @OnClick(R.id.recording_image_view)
    protected void onRecordingImageViewClick() {
        showMessage(getString(R.string.todo));
    }

    @OnClick(R.id.add_photo_image_view)
    protected void onAddPhotoImageViewClick() {
        showMessage(getString(R.string.todo));
    }

    @Override
    protected void onCreateComponent() {

    }

    @Override
    protected View getRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void updatePagePosition(int currentPosition, int totalPages) {
        scrollPositionTextView.setText(""+(currentPosition+1)+" of "+totalPages);
    }
}
