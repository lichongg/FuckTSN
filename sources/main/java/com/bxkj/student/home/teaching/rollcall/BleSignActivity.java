package com.bxkj.student.home.teaching.rollcall;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.work.WorkRequest;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.WaveView;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.rollcall.BleSignActivity;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.scan.b;
import com.orhanobut.logger.j;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.Nullable;
import t.b;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class BleSignActivity extends BaseActivity {

    @Nullable
    private String W;

    @Nullable
    private String X;

    @Nullable
    private String Y;

    @Nullable
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private WaveView f18954a0;

    /* renamed from: b0, reason: collision with root package name */
    @Nullable
    private LoadingDialog f18955b0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int i6, String msg) {
            g0.p(msg, "msg");
            super.netOnOtherStatus(i6, msg);
            iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).T).setMessage(msg);
            final BleSignActivity bleSignActivity = BleSignActivity.this;
            message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BleSignActivity.a.b(BleSignActivity.this, view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, ? extends Object> data) {
            g0.p(data, "data");
            BleSignActivity.this.W = JsonParse.getString(data, "Identify");
            BleSignActivity.this.X = JsonParse.getString(data, "teachingClockingin");
            BleSignActivity.this.Y = JsonParse.getString(data, "stuTeacherCurriculum");
            BleSignActivity.this.Z = JsonParse.getString(data, "weekNum");
            BleSignActivity.this.u0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(BleSignActivity bleSignActivity, View view) {
            bleSignActivity.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements b.a {
        b() {
        }

        @Override // t.b.a
        public void b(String[] permission) {
            g0.p(permission, "permission");
            new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).T).setMessage("您拒绝了蓝牙定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
        }

        @Override // t.b.a
        public void c(String[] permission) {
            g0.p(permission, "permission");
            new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).T).setMessage("您拒绝了蓝牙和定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
        }

        @Override // t.b.a
        public void a() {
            com.clj.fastble.a.v().G(BleSignActivity.this.getApplication());
            com.clj.fastble.a.v().l(true).f0(1, 5000L).d0(5000);
            BleSignActivity.this.t0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c implements b.a {
        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (i6 == -1) {
                BleSignActivity.this.v0();
            }
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends e1.i {
        @Override // e1.j
        public void a(boolean z5) {
            Dialog show;
            j.d("onScanStarted", new Object[0]);
            LoadingDialog r02 = BleSignActivity.this.r0();
            if (r02 != null && (show = r02.show("正在搜索蓝牙...")) != null) {
                show.show();
            }
            WaveView waveView = BleSignActivity.this.f18954a0;
            if (waveView == null) {
                g0.S("waveView");
                waveView = null;
            }
            waveView.k();
        }

        d() {
        }

        @Override // e1.j
        public void b(BleDevice bleDevice) {
            g0.p(bleDevice, "bleDevice");
            j.d("onScanning:" + bleDevice.d() + "-" + bleDevice.c(), new Object[0]);
            WaveView waveView = BleSignActivity.this.f18954a0;
            if (waveView == null) {
                g0.S("waveView");
                waveView = null;
            }
            waveView.l();
            LoadingDialog r02 = BleSignActivity.this.r0();
            if (r02 != null) {
                r02.dismiss();
            }
            com.clj.fastble.a.v().a();
            BleSignActivity.this.x0();
        }

        @Override // e1.i
        public void c(BleDevice bleDevice) {
            g0.p(bleDevice, "bleDevice");
            j.d("onLeScan:" + bleDevice.d() + "-" + bleDevice.c(), new Object[0]);
        }

        @Override // e1.i
        public void d(List<? extends BleDevice> scanResultList) {
            g0.p(scanResultList, "scanResultList");
            j.d("onScanFinished:" + scanResultList, new Object[0]);
            WaveView waveView = BleSignActivity.this.f18954a0;
            WaveView waveView2 = null;
            if (waveView == null) {
                g0.S("waveView");
                waveView = null;
            }
            if (waveView.i()) {
                j.d("搜索结束提示", new Object[0]);
                WaveView waveView3 = BleSignActivity.this.f18954a0;
                if (waveView3 == null) {
                    g0.S("waveView");
                } else {
                    waveView2 = waveView3;
                }
                waveView2.l();
                LoadingDialog r02 = BleSignActivity.this.r0();
                if (r02 != null) {
                    r02.dismiss();
                }
                if (scanResultList.isEmpty()) {
                    iOSTwoButtonDialog message = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).T).setMessage("未搜索到蓝牙信息，签到失败，是否重试？");
                    final BleSignActivity bleSignActivity = BleSignActivity.this;
                    iOSTwoButtonDialog leftButtonOnClickListener = message.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.b
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                        public final void buttonLeftOnClick() {
                            BleSignActivity.d.g(BleSignActivity.this);
                        }
                    });
                    final BleSignActivity bleSignActivity2 = BleSignActivity.this;
                    leftButtonOnClickListener.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.c
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                        public final void buttonRightOnClick() {
                            BleSignActivity.d.h(BleSignActivity.this);
                        }
                    }).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(BleSignActivity bleSignActivity) {
            bleSignActivity.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(BleSignActivity bleSignActivity) {
            bleSignActivity.t0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
            if (i6 != 4 || keyEvent == null || keyEvent.getAction() != 0) {
                return false;
            }
            iOSTwoButtonDialog rightButtonText = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).T).setMessage("正在扫描教师蓝牙签到，是否退出？").setLeftButtonText("继续签到").setRightButtonText("取消签到");
            final BleSignActivity bleSignActivity = BleSignActivity.this;
            rightButtonText.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.d
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    BleSignActivity.e.b(BleSignActivity.this);
                }
            }).show();
            return true;
        }

        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(BleSignActivity bleSignActivity) {
            bleSignActivity.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            g0.p(ex, "ex");
            super.netOnFailure(ex);
            try {
                iOSTwoButtonDialog message = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).T).setMessage("签到失败，是否重试？");
                final BleSignActivity bleSignActivity = BleSignActivity.this;
                message.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.g
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        BleSignActivity.f.d(BleSignActivity.this);
                    }
                }).show();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int i6, String msg) {
            g0.p(msg, "msg");
            try {
                iOSTwoButtonDialog message = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).T).setMessage("签到失败，是否重试？");
                final BleSignActivity bleSignActivity = BleSignActivity.this;
                message.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.e
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        BleSignActivity.f.e(BleSignActivity.this);
                    }
                }).show();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, ? extends Object> data) {
            g0.p(data, "data");
            try {
                iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).T).setMessage("签到成功");
                final BleSignActivity bleSignActivity = BleSignActivity.this;
                message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BleSignActivity.f.f(BleSignActivity.this, view);
                    }
                }).show();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(BleSignActivity bleSignActivity) {
            bleSignActivity.x0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(BleSignActivity bleSignActivity) {
            bleSignActivity.x0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(BleSignActivity bleSignActivity, View view) {
            bleSignActivity.finish();
        }
    }

    private final String s0() {
        return Settings.Secure.getString(this.T.getContentResolver(), "bluetooth_address");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).S0(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        com.clj.fastble.a.v().H(new b.a().g(new UUID[]{UUID.fromString(this.W)}).f(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).b());
        this.f18955b0 = new LoadingDialog(this.T);
        com.clj.fastble.a.v().Y(new d());
        LoadingDialog loadingDialog = this.f18955b0;
        if (loadingDialog != null) {
            loadingDialog.setOnKeyListener(new e());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        FragmentActivity mActivity = this.U;
        g0.o(mActivity, "mActivity");
        new t.b(mActivity).c("android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", com.kuaishou.weapon.p0.g.f36048h, com.kuaishou.weapon.p0.g.f36047g).d(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("上课签到");
    }

    @Nullable
    public final LoadingDialog r0() {
        return this.f18955b0;
    }

    public final void w0(@Nullable LoadingDialog loadingDialog) {
        this.f18955b0 = loadingDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        if (com.clj.fastble.a.v().L()) {
            new u.b(this).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE")).c(new c());
        } else {
            new iOSOneButtonDialog(this.T).setMessage("您的手机不支持蓝牙签到,请联系老师手动签到").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0() {
        Http.with(this.T).setLoadingMessage("正在签到...").setObservable(((e0.a) Http.getApiService(e0.a.class)).D1(this.X, this.Y, this.Z, s0(), LoginUser.getLoginUser().getSchoolId())).setDataListener(new f());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_sign;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(@Nullable Bundle bundle) {
        View findViewById = findViewById(R.id.waveView);
        g0.o(findViewById, "findViewById(...)");
        WaveView waveView = (WaveView) findViewById;
        this.f18954a0 = waveView;
        WaveView waveView2 = null;
        if (waveView == null) {
            g0.S("waveView");
            waveView = null;
        }
        waveView.setStyle(Paint.Style.FILL);
        WaveView waveView3 = this.f18954a0;
        if (waveView3 == null) {
            g0.S("waveView");
        } else {
            waveView2 = waveView3;
        }
        waveView2.setColor(ContextCompat.getColor(this.T, 2131099714));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.clj.fastble.a v5;
        super.onDestroy();
        LoadingDialog loadingDialog = this.f18955b0;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        WaveView waveView = this.f18954a0;
        if (waveView == null) {
            g0.S("waveView");
            waveView = null;
        }
        waveView.l();
        if (com.clj.fastble.a.v().C() == BleScanState.STATE_SCANNING && (v5 = com.clj.fastble.a.v()) != null) {
            v5.a();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
