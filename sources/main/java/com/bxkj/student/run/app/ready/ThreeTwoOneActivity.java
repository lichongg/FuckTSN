package com.bxkj.student.run.app.ready;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.bxkj.student.run.app.RunningActivity;
import com.orhanobut.logger.j;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ThreeTwoOneActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private TextView f19956a;

    /* renamed from: b, reason: collision with root package name */
    private int f19957b = 4;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            Intent intent = ThreeTwoOneActivity.this.getIntent();
            intent.setClass(ThreeTwoOneActivity.this, RunningActivity.class);
            ThreeTwoOneActivity.this.startActivity(intent);
            ThreeTwoOneActivity.this.overridePendingTransition(2130771987, 2130771986);
            ThreeTwoOneActivity.this.finish();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            super.onAnimationRepeat(animation);
            ThreeTwoOneActivity threeTwoOneActivity = ThreeTwoOneActivity.this;
            threeTwoOneActivity.f19957b--;
            j.c("count=" + ThreeTwoOneActivity.this.f19957b);
            if (ThreeTwoOneActivity.this.f19957b == 0) {
                ThreeTwoOneActivity.this.f19956a.setText("GO");
            } else {
                ThreeTwoOneActivity.this.f19956a.setText(String.valueOf(ThreeTwoOneActivity.this.f19957b));
            }
        }
    }

    static {
        StubApp.interface11(16718);
    }

    private void d() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f19956a, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.setRepeatCount(4);
        ofPropertyValuesHolder.start();
        ofPropertyValuesHolder.addListener(new a());
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
