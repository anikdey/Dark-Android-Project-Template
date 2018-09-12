package javarank.com.dreamjournalui.common.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import javarank.com.dreamjournalui.R;

public class CommonUtil {

    public static void setTextWatcherToShowMaximumLimitReachedMessage(final EditText editText, final int maxLimit) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( s.length() >= maxLimit ) {
                    Toast.makeText(editText.getContext(), editText.getContext().getString(R.string.maximum_character_limit_reached), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
