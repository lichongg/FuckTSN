package com.bxkj.student;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.u;
import com.bxkj.base.util.v;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.common.versionupdate.a;
import com.bxkj.student.home.message.MessageActivity;
import com.bxkj.student.main.HomeFragment;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.personal.MyQRCodeActivity;
import com.bxkj.student.personal.bind.BindWechatQQActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.personal.password.UpdatePasswordActivity;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.umeng.socialize.UMShareAPI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MainActivity extends BaseActivity {
    private RadioGroup F0;
    private ImageView H0;
    private int J0;
    private Fragment X;
    private cn.bluemobi.dylan.base.adapter.a Y;
    private Fragment Z;

    /* renamed from: a0, reason: collision with root package name */
    private v.c f17625a0;

    /* renamed from: b0, reason: collision with root package name */
    private iOSTwoButtonDialog f17626b0;

    /* renamed from: c0, reason: collision with root package name */
    public Dialog f17627c0;

    /* renamed from: k0, reason: collision with root package name */
    private FrameLayout f17628k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f17629p0;
    private int W = 0;
    private List<Fragment> G0 = new ArrayList();
    private int I0 = 0;
    private boolean K0 = false;
    private long L0 = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            com.bxkj.student.personal.login.c.c();
            MainActivity.this.startActivity(new Intent(((BaseActivity) MainActivity.this).T, (Class<?>) LoginActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements a.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.common.versionupdate.a f17631a;

        b(final com.bxkj.student.common.versionupdate.a val$versionUpdate) {
            this.f17631a = val$versionUpdate;
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction) {
            MainActivity.this.K0 = true;
            if (hasNewVersion) {
                MainActivity.this.f17627c0 = this.f17631a.d(versionName, downLoadUrl, instruction);
            }
            MainActivity.this.A0();
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void b() {
            MainActivity.this.K0 = false;
            MainActivity.this.A0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            MainActivity.this.v0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                LoginUser.getLoginUser().setSchoolName(JsonParse.getString(data, "schName"));
                LoginUser.getLoginUser().setServerUrl(JsonParse.getString(data, "urlSite"));
                LoginUser.getLoginUser().setIsOpenEncry(JsonParse.getString(data, "isOpenEncry"));
                LoginUser.getLoginUser().setAppId(JsonParse.getString(data, "openId"));
                LoginUser.getLoginUser().setSysType(JsonParse.getInt(data, "sysType"));
                LoginUser.getLoginUser().setIsOpenKeep(JsonParse.getInt(data, "isOpenKeep"));
                LoginUser.getLoginUser().setIsOpenLive(JsonParse.getInt(data, "isOpenLive", 1));
                LoginUser.getLoginUser().setOldToNewH5(JsonParse.getString(data, "oldToNewH5"));
                Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
                new HashSet().add(LoginUser.getLoginUser().getSchoolName());
                if (LoginUser.getLoginUser().getSysType() == 2) {
                    MainActivity.this.startActivity(new Intent(((BaseActivity) MainActivity.this).T, (Class<?>) H5AppActivity.class).putExtra("title", LoginUser.getLoginUser().getSchoolName()).putExtra("url", LoginUser.getLoginUser().getServerUrl()));
                    MainActivity.this.finish();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            MainActivity.this.z0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            MainActivity.this.B0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setLogin(false);
            MainActivity.this.G0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "collectPhoto"));
            if (JsonParse.getString(data, "weixinId").isEmpty() && JsonParse.getString(data, "qqId").isEmpty()) {
                MainActivity.this.startActivity(new Intent(((BaseActivity) MainActivity.this).T, (Class<?>) BindWechatQQActivity.class));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MainActivity.this.W = JsonParse.getInt(data, "data");
            MainActivity.this.J0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }
    }

    private void K0() {
        for (int i6 = 0; i6 < this.G0.size(); i6++) {
            Fragment fragment = this.G0.get(i6);
            if (i6 == this.I0) {
                if (fragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
                } else {
                    getSupportFragmentManager().beginTransaction().add(2131298030, fragment, String.valueOf(i6)).commitAllowingStateLoss();
                }
            } else if (fragment.isAdded()) {
                getSupportFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        d0(false);
    }

    private String C0() {
        try {
            return this.T.getPackageManager().getPackageInfo(this.T.getPackageName(), 0).versionName;
        } catch (Exception e6) {
            e6.printStackTrace();
            return "1.0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        u.b(this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(RadioGroup radioGroup, int i6) {
        this.J0 = i6;
        this.I0 = radioGroup.indexOfChild(radioGroup.findViewById(i6));
        K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        startActivity(new Intent(this.T, (Class<?>) UpdatePasswordActivity.class).putExtra("msg", getString(R.string.update_password_msg)));
    }

    private void H0() {
        this.J0 = this.F0.getChildAt(0).getId();
        this.F0.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.f
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i6) {
                MainActivity.this.F0(radioGroup, i6);
            }
        });
    }

    private void I0() {
        this.F0.getChildAt(1).setVisibility(LoginUser.getLoginUser().getIsOpenLive() == 1 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        if (this.W > 0) {
            this.H0.setVisibility(0);
        } else {
            this.H0.setVisibility(8);
        }
    }

    private void s0() {
        Http.with(this.T).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((x.f) Http.getApiService(x.f.class)).h(Integer.valueOf(Integer.parseInt(LoginUser.getLoginUser().getSchoolId())), 1, com.bxkj.base.v2.common.utils.f.f16889a.d(this.T), x0(), y0(), LoginUser.getLoginUser().getUserId(), C0())).setDataListener(new g());
    }

    private String t0(String s5) {
        if (s5 == null || s5.length() == 0) {
            return "";
        }
        char charAt = s5.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return s5;
        }
        return Character.toUpperCase(charAt) + s5.substring(1);
    }

    private void w0() {
        com.bxkj.student.common.versionupdate.a aVar = new com.bxkj.student.common.versionupdate.a(this.T);
        aVar.b(new b(aVar));
    }

    private String x0() {
        return t0(Build.MANUFACTURER);
    }

    private String y0() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? t0(str2) : str2;
    }

    public void A0() {
        Http.with(this.T).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((x.f) Http.getApiService(x.f.class)).e(LoginUser.getLoginUser().getSchoolId())).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f17628k0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (!c0.b.f1042a.c(this.T)) {
            iOSOneButtonDialog message = new iOSOneButtonDialog(this.T).setMessage("系统内部错误，错误码【1001】");
            message.setClickAutoCancel(false);
            message.setCancelable(false);
            message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.D0(view);
                }
            });
            message.show();
        }
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        if (aVar.a().r() == 1 && !aVar.a().p()) {
            final iOSOneButtonDialog message2 = new iOSOneButtonDialog(this.T).setMessage(aVar.a().s());
            message2.setClickAutoCancel(false);
            message2.setCancelable(false);
            message2.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.k0(iOSOneButtonDialog.this, view);
                }
            });
            message2.show();
        }
        u0();
        this.G0.add(this.Z);
        this.G0.add(this.X);
        H0();
        K0();
        try {
            s0();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        w0();
        if (u.a(this.T)) {
            return;
        }
        new iOSTwoButtonDialog(this.T).setMessage("为了能够让你不错过重要的通知消息,强烈建议你开始允许推送通知功能").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.i
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                MainActivity.this.E0();
            }
        }).setLeftButtonText("不了").setRightButtonText("去开启").show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("currentIndex")) {
                this.I0 = savedInstanceState.getInt("currentIndex");
            }
            this.Z = getSupportFragmentManager().findFragmentByTag("0");
            this.X = getSupportFragmentManager().findFragmentByTag("2");
        }
        if (this.Z == null) {
            this.Z = new HomeFragment();
        }
        if (this.X == null) {
            this.X = new MyFragment();
        }
        this.F0 = (RadioGroup) findViewById(2131298361);
        this.f17629p0 = (TextView) findViewById(2131299164);
        this.H0 = (ImageView) findViewById(R.id.iv_red_dot);
        this.f17628k0 = (FrameLayout) findViewById(R.id.fm_message);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        iOSTwoButtonDialog iostwobuttondialog = this.f17626b0;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f17626b0.dismiss();
        }
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentIndex", this.I0);
        super.onSaveInstanceState(outState);
    }

    public void z0() {
        Http.with(this.T).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).Z(LoginUser.getLoginUser().getUserId(), "0")).setDataListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        finish();
    }

    public static /* synthetic */ void k0(iOSOneButtonDialog iosonebuttondialog, View view) {
        iosonebuttondialog.dismiss();
        com.bxkj.base.v2.data.b.f16998d.a().n0(true);
    }

    private void u0() {
        long currentTimeMillis = System.currentTimeMillis() - LoginUser.getLoginUser().getLastLoginTime();
        if (LoginUser.getLoginUser().isLogin() && currentTimeMillis > 2592000000L) {
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.T);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setCanceledOnTouchOutside(false);
            iosonebuttondialog.setButtonOnClickListener(new a());
            iosonebuttondialog.setMessage("登录过期,请重新登录").show();
        }
    }

    public void B0() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).j1()).setDataListener(new e());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_main;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this.T).onActivityResult(requestCode, resultCode, data);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void s0() {
        if (System.currentTimeMillis() - this.L0 > 2000) {
            g0("再按一次退出程序");
            this.L0 = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (!LoginUser.getLoginUser().isLogin()) {
            startActivity(new Intent(this.T, (Class<?>) LoginActivity.class));
        }
        switch (v5.getId()) {
            case R.id.fm_message /* 2131297004 */:
                startActivity(new Intent(this.T, (Class<?>) MessageActivity.class));
                break;
            case R.id.fm_qrcode /* 2131297005 */:
                startActivity(new Intent(this.T, (Class<?>) MyQRCodeActivity.class));
                break;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (!this.K0) {
            w0();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f17629p0.setText(LoginUser.getLoginUser().getSchoolName());
    }

    public void v0() {
        if (!LoginUser.getLoginUser().isLogin()) {
            return;
        }
        Http.with(this.T).hideLoadingDialog().hideFailMessage().hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).L(LoginUser.getLoginUser().getAccount())).setDataListener(new d());
    }
}
