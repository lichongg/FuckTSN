package com.bxkj.student.personal.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.x;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.l;
import com.bxkj.student.personal.bind.WechatQQBindAccountActivity;
import com.bxkj.student.personal.password.forget.FindPasswordTypeActivity;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.orhanobut.logger.j;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LoginActivity extends BaseActivity {
    private FrameLayout F0;
    private CheckBox G0;
    private TextView H0;
    private TextView I0;
    private LinearLayout J0;
    UMAuthListener K0 = new d();
    private Toolbar W;
    private TextView X;
    private EditText Y;
    private EditText Z;

    /* renamed from: a0, reason: collision with root package name */
    private Button f19634a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f19635b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19636c0;

    /* renamed from: k0, reason: collision with root package name */
    private Button f19637k0;

    /* renamed from: p0, reason: collision with root package name */
    private Button f19638p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            LoginActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f19640a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements iOSTwoButtonDialog.RightButtonOnClick {
            a() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(false);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.personal.login.LoginActivity$b$b, reason: collision with other inner class name */
        class C0263b implements iOSTwoButtonDialog.RightButtonOnClick {
            C0263b() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(true);
            }
        }

        b(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f19640a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f19640a.show();
            String trim = ((EditText) this.f19640a.findViewById(R.id.et_password)).getText().toString().trim();
            if (trim.isEmpty()) {
                LoginActivity.this.g0("密码不能为空");
                return;
            }
            try {
                this.f19640a.dismiss();
                if (!"396436".equals(trim)) {
                    new iOSOneButtonDialog(((BaseActivity) LoginActivity.this).T).setMessage("密码错误，请联系管理员").show();
                } else if (LoginUser.getLoginUser().isOpenModel()) {
                    new iOSTwoButtonDialog(((BaseActivity) LoginActivity.this).T).setMessage("确定关闭开发者模式？").setRightButtonOnClickListener(new a()).show();
                } else {
                    new iOSTwoButtonDialog(((BaseActivity) LoginActivity.this).T).setMessage("确定打开开发者模式？").setRightButtonOnClickListener(new C0263b()).show();
                }
            } catch (Exception e6) {
                new iOSOneButtonDialog(((BaseActivity) LoginActivity.this).T).setMessage("验证密码异常，请联系管理员").show();
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            com.bxkj.student.personal.login.c.b(((BaseActivity) LoginActivity.this).U, data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements UMAuthListener {
        d() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(((BaseActivity) LoginActivity.this).T, "您取消了登录", 1).show();
            LoginActivity.this.f19637k0.setEnabled(true);
            LoginActivity.this.f19638p0.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            j.c("platform=" + platform.name());
            j.c("data=" + data);
            String str = platform == SHARE_MEDIA.WEIXIN ? "1" : "0";
            data.put("login_type", str);
            LoginActivity.this.D0(str, data);
            LoginActivity.this.f19637k0.setEnabled(true);
            LoginActivity.this.f19638p0.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA platform, int action, Throwable t5) {
            j.c(t5.getMessage());
            j.c("action=" + action);
            Toast.makeText(((BaseActivity) LoginActivity.this).T, "登录失败,请稍后再试", 1).show();
            LoginActivity.this.f19637k0.setEnabled(true);
            LoginActivity.this.f19638p0.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA platform) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f19646a;

        e(final Map val$data) {
            this.f19646a = val$data;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            com.bxkj.student.personal.login.c.b(((BaseActivity) LoginActivity.this).U, data);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            LoginActivity.this.f19637k0.setEnabled(true);
            LoginActivity.this.f19638p0.setEnabled(true);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 201) {
                LoginActivity.this.startActivity(new Intent(((BaseActivity) LoginActivity.this).T, (Class<?>) WechatQQBindAccountActivity.class).putExtra("openid", (String) this.f19646a.get("openid")).putExtra(CommonNetImpl.NAME, (String) this.f19646a.get(CommonNetImpl.NAME)).putExtra("iconurl", (String) this.f19646a.get("iconurl")).putExtra("login_type", (String) this.f19646a.get("login_type")));
            } else {
                new iOSOneButtonDialog(((BaseActivity) LoginActivity.this).T).setMessage(msg).show();
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        d0(false);
    }

    private void A0() {
        String trim = this.Y.getText().toString().trim();
        String trim2 = this.Z.getText().toString().trim();
        if (trim.isEmpty()) {
            new iOSOneButtonDialog(this.T).setMessage("请输入账号").show();
            return;
        }
        if (trim2.isEmpty()) {
            new iOSOneButtonDialog(this.T).setMessage("请输入密码").show();
            return;
        }
        if (!this.G0.isChecked()) {
            new iOSOneButtonDialog(this.T).setMessage("请勾选同意用户协议").show();
            return;
        }
        try {
            Http.with(this.T).setLoadingMessage("正在登录").setObservable(((e0.a) Http.getApiService(e0.a.class)).r(trim, new x().a(trim2))).setDataListener(new c());
        } catch (Exception e6) {
            new iOSOneButtonDialog(this.T).setMessage("登录异常，请联系管理员").show();
            e6.printStackTrace();
        }
    }

    private void B0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.T);
        iostwobuttondialog.setMessage("开发者模式专供开发者调试使用，请谨慎开启！开关开发者模式需要验证你的身份，请输入密码进行验证").setCenterCustomView(R.layout.dialog_confim_password).setRightButtonOnClickListener(new b(iostwobuttondialog)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(String type, Map<String, String> data) {
        j.c("data=" + data);
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).R(type, data.get("openid"))).setDataListener(new e(data));
    }

    private void x0() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + this.F0.getTag().toString())));
        } catch (Exception unused) {
            new iOSOneButtonDialog(this.T).setMessage("请先安装QQ！").show();
        }
    }

    public void C0(String qq) {
        this.F0.setTag(qq);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.H0.setOnClickListener(this);
        this.f19634a0.setOnClickListener(this);
        this.f19635b0.setOnClickListener(this);
        this.f19637k0.setOnClickListener(this);
        this.f19638p0.setOnClickListener(this);
        this.f19636c0.setOnClickListener(this);
        this.F0.setOnClickListener(this);
        findViewById(2131297182).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bxkj.student.personal.login.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean y02;
                y02 = LoginActivity.this.y0(view);
                return y02;
            }
        });
        this.I0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.Y.setText(LoginUser.getLoginUser().getAccount());
        this.H0.getPaint().setFlags(8);
        this.H0.getPaint().setAntiAlias(true);
    }

    private void w0() {
        this.J0 = (LinearLayout) findViewById(R.id.ll_account_login);
        this.I0 = (TextView) findViewById(R.id.tv_switch_account);
        this.Y = (EditText) findViewById(R.id.et_account);
        this.Z = (EditText) findViewById(R.id.et_password);
        this.f19634a0 = (Button) findViewById(R.id.bt_login);
        this.f19635b0 = (TextView) findViewById(R.id.tv_forget_password);
        this.f19636c0 = (TextView) findViewById(R.id.tv_switch_school);
        this.f19637k0 = (Button) findViewById(R.id.bt_wechat_login);
        this.f19638p0 = (Button) findViewById(R.id.bt_qq_login);
        this.F0 = (FrameLayout) findViewById(R.id.ll_contact_customer);
        this.W = (Toolbar) findViewById(R.id.tb);
        this.X = (TextView) findViewById(2131299164);
        this.G0 = (CheckBox) findViewById(2131296716);
        this.H0 = (TextView) findViewById(R.id.tv_agree);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean y0(View view) {
        B0();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(iOSTwoButtonDialog iostwobuttondialog) {
        LoginUser.getLoginUser().setAgreement(true);
        this.G0.setChecked(true);
        iostwobuttondialog.dismiss();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_login;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(16);
        w0();
        try {
            this.W.getRootView().getRootView().setBackgroundResource(R.mipmap.login_bg);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        l.d(this);
        this.X.setText(LoginUser.getLoginUser().getSchoolName());
        this.W.setNavigationIcon(2131231200);
        this.W.setNavigationOnClickListener(new a());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        switch (v5.getId()) {
            case R.id.bt_login /* 2131296617 */:
                A0();
                break;
            case R.id.bt_qq_login /* 2131296631 */:
                if (!this.G0.isChecked()) {
                    new iOSOneButtonDialog(this.T).setMessage("请勾选同意用户协议").show();
                    break;
                } else {
                    UMShareAPI uMShareAPI = UMShareAPI.get(this.T);
                    SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                    if (!uMShareAPI.isInstall(this, share_media)) {
                        g0("您还未安装QQ或QQ版本过低");
                        break;
                    } else {
                        this.f19638p0.setEnabled(false);
                        UMShareAPI.get(this.T).getPlatformInfo(this, share_media, this.K0);
                        break;
                    }
                }
            case R.id.bt_wechat_login /* 2131296656 */:
                UMShareAPI uMShareAPI2 = UMShareAPI.get(this.T);
                SHARE_MEDIA share_media2 = SHARE_MEDIA.WEIXIN;
                if (!uMShareAPI2.isInstall(this, share_media2)) {
                    g0("您还未安装微信或微信版本过低");
                    break;
                } else if (!this.G0.isChecked()) {
                    new iOSOneButtonDialog(this.T).setMessage("请勾选同意用户协议").show();
                    break;
                } else {
                    this.f19637k0.setEnabled(false);
                    UMShareAPI.get(this.T).getPlatformInfo(this, share_media2, this.K0);
                    break;
                }
            case R.id.ll_contact_customer /* 2131298027 */:
                x0();
                break;
            case R.id.tv_agree /* 2131298774 */:
                final iOSTwoButtonDialog rightButtonText = new iOSTwoButtonDialog(this.T).setTitle("用户协议").setCenterCustomView(2131492946).setLeftButtonText("仅浏览").setRightButtonText("同意");
                ((SmartWebView) rightButtonText.findViewById(2131298538)).j("https://www.boxkj.com/resources/user_agreement_info.html");
                rightButtonText.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.personal.login.b
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        LoginActivity.this.z0(rightButtonText);
                    }
                });
                rightButtonText.show();
                break;
            case R.id.tv_forget_password /* 2131298915 */:
                startActivity(new Intent(this.T, (Class<?>) FindPasswordTypeActivity.class));
                break;
            case R.id.tv_switch_account /* 2131299135 */:
                if (this.J0.getVisibility() == 0) {
                    this.J0.setVisibility(8);
                    break;
                } else {
                    this.J0.setVisibility(0);
                    break;
                }
            case R.id.tv_switch_school /* 2131299136 */:
                startActivity(new Intent(this.T, (Class<?>) SelectSchoolV2Activity.class));
                break;
        }
    }
}
