package javarank.com.dreamjournalui.home.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.home.ui.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        if( savedInstanceState == null ) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, HomeFragment.newInstance(), HomeFragment.TAG).commit();
        }
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }
}