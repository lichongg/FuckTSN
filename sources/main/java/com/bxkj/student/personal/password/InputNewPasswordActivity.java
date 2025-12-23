package com.bxkj.student.personal.password;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.x;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.l;
import com.bxkj.student.personal.login.LoginActivity;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class InputNewPasswordActivity extends BaseActivity {
    private TextView W;
    private EditText X;
    private EditText Y;
    private Button Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f19651a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            InputNewPasswordActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                cn.bluemobi.dylan.base.utils.a.n().j();
                InputNewPasswordActivity.this.startActivity(new Intent(((BaseActivity) InputNewPasswordActivity.this).T, (Class<?>) LoginActivity.class));
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) InputNewPasswordActivity.this).T).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setLogin(false);
            iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(((BaseActivity) InputNewPasswordActivity.this).T).setMessage("密码重置成功，请登录").setButtonOnClickListener(new a());
            buttonOnClickListener.setCancelable(false);
            buttonOnClickListener.show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        d0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        String str;
        String trim = this.X.getText().toString().trim();
        String trim2 = this.Y.getText().toString().trim();
        if (trim.isEmpty()) {
            g0("请输入新密码");
            return;
        }
        if (trim2.isEmpty()) {
            g0("请再次输入新密码");
            return;
        }
        if (!trim.equals(trim2)) {
            g0("两次输入密码不一致");
            return;
        }
        try {
            str = new x().a(trim);
        } catch (Exception e6) {
            new iOSOneButtonDialog(this.T).setMessage("设置新密码异常，请联系管理员").show();
            e6.printStackTrace();
            str = null;
        }
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).w1(this.f19651a0, str)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_input_new_password;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra(CommonNetImpl.NAME)) {
            this.f19651a0 = getIntent().getStringExtra("userNum");
            String stringExtra = getIntent().getStringExtra(CommonNetImpl.NAME);
            this.W.setText(this.f19651a0 + "--" + stringExtra);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_account);
        this.X = (EditText) findViewById(R.id.et_password);
        this.Y = (EditText) findViewById(R.id.et_password_agn);
        this.Z = (Button) findViewById(R.id.bt_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb);
        ((TextView) findViewById(2131299164)).setText("设置新密码");
        toolbar.setNavigationIcon(2131231200);
        toolbar.setNavigationOnClickListener(new a());
        try {
            toolbar.getRootView().getRootView().setBackgroundResource(R.mipmap.login_bg);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        l.d(this);
    }
}
