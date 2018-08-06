package javarank.com.dreamjournalui.home.ui.fragment;

import android.animation.Animator;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import javarank.com.dreamjournalui.R;
import javarank.com.dreamjournalui.home.ui.activity.HomeActivity;

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
    protected void showNotification() {

        RemoteViews contentView = new RemoteViews(getContext().getPackageName(), R.layout.notification_small);
        contentView.setImageViewResource(R.id.image, R.drawable.app_icon);
        contentView.setTextViewText(R.id.title, "Custom notification");
        contentView.setTextViewText(R.id.text, "This is a custom layout");

        Intent intent = HomeActivity.newIntent(getContext());
        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getContext(), "channel_id");

        notificationBuilder.setContent(contentView);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setSmallIcon(R.drawable.push_icon);
        notificationBuilder.setColor(ContextCompat.getColor(getContext(), R.color.black));

        notificationBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        notificationBuilder.setContentIntent(pendingIntent);

        Notification notification = notificationBuilder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;

        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());/**/
    }
}
