package com.bxkj.student.run.app.set;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.b0;
import com.bxkj.student.R;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.set.brandset.HUAWEISetFragment;
import com.bxkj.student.run.app.set.brandset.MeizuFragment;
import com.bxkj.student.run.app.set.brandset.OPPOSetFragment;
import com.bxkj.student.run.app.set.brandset.OtherSetFramgment;
import com.bxkj.student.run.app.set.brandset.VivoSetFragment;
import com.bxkj.student.run.app.set.brandset.XiaomiSetFragment;
import com.bxkj.student.v2.common.utils.q;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunPermissionSetActivity extends BaseActivity {
    private Button W;
    private TextView X;
    private LinearLayout Y;
    private Button Z;

    /* renamed from: a0, reason: collision with root package name */
    private CheckBox f20036a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CountDownTimer {
        a(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            RunPermissionSetActivity.this.Z.setEnabled(true);
            RunPermissionSetActivity.this.Z.setText("开始跑步");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            RunPermissionSetActivity.this.Z.setText("开始跑步(" + (millisUntilFinished / 1000) + "秒)");
        }
    }

    private void m0() {
        Button button = this.W;
        q.a aVar = q.f20918a;
        button.setEnabled(!aVar.b());
        this.W.setText(aVar.b() ? "权限已开启" : "一键自动开启");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        q.f20918a.e(this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, this.T.getPackageName(), null));
    }

    private void q0() {
        new iOSOneButtonDialog(this.T).setMessage(getString(R.string.not_support_fast_set_please_self_set)).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunPermissionSetActivity.this.p0(view);
            }
        }).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setVisibility(com.bxkj.base.v2.data.b.f16998d.a().b0() == 1 ? 0 : 8);
        this.W.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunPermissionSetActivity.this.n0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("运动权限设置");
        e0(ContextCompat.getColor(this, 2131099737));
    }

    private void l0(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.fl_bottom, fragment);
        beginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        LoginUser.getLoginUser().setCheckIgnoreRunSet(this.f20036a0.isChecked());
        startActivity(new Intent(this.T, (Class<?>) StartRunActivity.class));
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_run_permission_set;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        RunPermissionSetActivity runPermissionSetActivity;
        if (getIntent().hasExtra("isShowBottom") && getIntent().getBooleanExtra("isShowBottom", false)) {
            this.Y.setVisibility(0);
            runPermissionSetActivity = this;
            runPermissionSetActivity.new a(master.flame.danmaku.danmaku.model.android.d.f50003r, 1000L).start();
            runPermissionSetActivity.Z.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunPermissionSetActivity.this.o0(view);
                }
            });
        } else {
            runPermissionSetActivity = this;
        }
        String d6 = b0.d();
        runPermissionSetActivity.X.setText("您的手机品牌：" + d6);
        if (d6.equals("Xiaomi")) {
            l0(new XiaomiSetFragment());
        } else if (d6.equals("HUAWEI")) {
            l0(new HUAWEISetFragment());
        } else if (d6.equals("OPPO")) {
            l0(new OPPOSetFragment());
        } else if (d6.equals("Vivo")) {
            l0(new VivoSetFragment());
        } else if (d6.equals("Meizu")) {
            l0(new MeizuFragment());
        } else {
            l0(new OtherSetFramgment());
        }
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (Button) findViewById(R.id.bt_fast_set);
        this.X = (TextView) findViewById(R.id.tv_brand);
        this.Y = (LinearLayout) findViewById(2131298015);
        this.Z = (Button) findViewById(R.id.bt_start);
        this.f20036a0 = (CheckBox) findViewById(R.id.cb_ignore);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
