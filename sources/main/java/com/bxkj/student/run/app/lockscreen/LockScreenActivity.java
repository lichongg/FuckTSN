package com.bxkj.student.run.app.lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.l;
import com.bxkj.student.run.app.RunBroadcastActionType;
import com.bxkj.student.run.app.lockscreen.SwipeBackLayout;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.romainpiel.shimmer.ShimmerTextView;
import com.romainpiel.shimmer.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LockScreenActivity extends BaseActivity {
    private ShimmerTextView F0;
    private b G0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19876a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f19877b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19878c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f19879k0;

    /* renamed from: p0, reason: collision with root package name */
    private BroadcastReceiver f19880p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunBroadcastActionType.NOTIFY_RUN_DATA)) {
                if (intent.hasExtra("distance")) {
                    LockScreenActivity.this.Z.setText(intent.getStringExtra("distance"));
                }
                if (intent.hasExtra("speed")) {
                    LockScreenActivity.this.f19876a0.setText(intent.getStringExtra("speed"));
                }
                if (intent.hasExtra("peisu")) {
                    LockScreenActivity.this.f19877b0.setText(intent.getStringExtra("peisu"));
                }
                if (intent.hasExtra("time")) {
                    LockScreenActivity.this.f19878c0.setText(intent.getStringExtra("time"));
                    return;
                }
                return;
            }
            if (intent.getAction().equals(RunBroadcastActionType.UPDATE_STEP)) {
                if (intent.hasExtra("stepCount")) {
                    LockScreenActivity.this.f19879k0.setText(String.valueOf(intent.getIntExtra("stepCount", 0)));
                }
            } else {
                if (intent.getAction().equals(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION)) {
                    if (intent.hasExtra(CrashHianalyticsData.MESSAGE)) {
                        LockScreenActivity.this.Y.setText(intent.getStringExtra(CrashHianalyticsData.MESSAGE));
                        return;
                    }
                    return;
                }
                if (intent.getAction().equals(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION)) {
                    LockScreenActivity.this.Y.setText("");
                } else if (intent.getAction().equals(RunBroadcastActionType.RUN_DEBUG_INFO) && intent.hasExtra("msg")) {
                    LockScreenActivity.this.X.setText(intent.getStringExtra("msg"));
                }
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        d0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f19880p0;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f19880p0 = null;
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.G0.h();
        super.onStop();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected void N() {
        getWindow().addFlags(4194304);
        getWindow().addFlags(524288);
        super.N();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_lockmain;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Intent intent = getIntent();
        if (intent.hasExtra("distance")) {
            this.Z.setText(intent.getStringExtra("distance"));
        }
        if (intent.hasExtra("speed")) {
            this.f19876a0.setText(intent.getStringExtra("speed"));
        }
        if (intent.hasExtra("peisu")) {
            this.f19877b0.setText(intent.getStringExtra("peisu"));
        }
        if (intent.hasExtra("time")) {
            this.f19878c0.setText(intent.getStringExtra("time"));
        }
        if (intent.hasExtra("stepCount")) {
            this.f19879k0.setText(String.valueOf(intent.getIntExtra("stepCount", 0)));
        }
        if (intent.hasExtra("lastPauseMessage")) {
            this.Y.setText(intent.getStringExtra("lastPauseMessage"));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RunBroadcastActionType.NOTIFY_RUN_DATA);
        intentFilter.addAction(RunBroadcastActionType.UPDATE_STEP);
        intentFilter.addAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
        intentFilter.addAction(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION);
        intentFilter.addAction(RunBroadcastActionType.RUN_DEBUG_INFO);
        a aVar = new a();
        this.f19880p0 = aVar;
        registerReceiver(aVar, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        try {
            findViewById(R.id.swipeback).getRootView().getRootView().setBackgroundResource(R.mipmap.login_bg);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        l.d(this);
        this.F0 = (ShimmerTextView) findViewById(R.id.lockmain_shimmer);
        this.G0 = new b();
        ((SwipeBackLayout) findViewById(R.id.swipeback)).setSwipeBackListener(new SwipeBackLayout.b(this));
        this.X = (TextView) findViewById(R.id.tv_debug_info);
        this.Y = (TextView) findViewById(R.id.tv_face_status);
        this.W = (TextView) findViewById(2131298779);
        this.Z = (TextView) findViewById(2131298881);
        this.f19876a0 = (TextView) findViewById(R.id.tv_speed);
        this.f19877b0 = (TextView) findViewById(R.id.tv_peisu);
        this.f19878c0 = (TextView) findViewById(2131299158);
        this.f19879k0 = (TextView) findViewById(2131299117);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int keyCode2 = event.getKeyCode();
        if (keyCode2 == 4 || keyCode2 == 82) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.G0.t(this.F0);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
