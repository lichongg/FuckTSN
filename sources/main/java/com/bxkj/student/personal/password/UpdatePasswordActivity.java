package com.bxkj.student.personal.password;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.x;
import com.bxkj.base.util.y;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.l;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class UpdatePasswordActivity extends BaseActivity {
    private LinearLayout W;
    private LinearLayout X;
    private TextView Y;
    private EditText Z;

    /* renamed from: a0, reason: collision with root package name */
    private EditText f19655a0;

    /* renamed from: b0, reason: collision with root package name */
    private EditText f19656b0;

    /* renamed from: c0, reason: collision with root package name */
    private EditText f19657c0;

    /* renamed from: k0, reason: collision with root package name */
    private Button f19658k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f19659p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            UpdatePasswordActivity.this.finish();
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
                UpdatePasswordActivity.this.startActivity(new Intent(((BaseActivity) UpdatePasswordActivity.this).T, (Class<?>) LoginActivity.class));
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) UpdatePasswordActivity.this).T).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setLogin(false);
            iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(((BaseActivity) UpdatePasswordActivity.this).T).setMessage("密码修改成功，请重新登录").setButtonOnClickListener(new a());
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
        this.f19658k0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.f19659p0.setText("学号：" + LoginUser.getLoginUser().getAccount());
        String realName = LoginUser.getLoginUser().getRealName();
        if (!TextUtils.isEmpty(realName)) {
            if (realName.length() <= 4) {
                int intValue = y.a(realName.length(), 1).get(0).intValue() - 1;
                StringBuilder sb = new StringBuilder();
                for (int i6 = 0; i6 < realName.toCharArray().length; i6++) {
                    if (i6 == intValue) {
                        sb.append(realName.charAt(i6));
                    } else {
                        sb.append("*");
                    }
                }
                this.Y.setText("姓名：" + ((Object) sb));
            } else {
                this.Y.setText("姓名：" + realName);
                this.f19657c0.setText(realName);
                this.X.setVisibility(8);
            }
        }
        if (getIntent().hasExtra("msg")) {
            new iOSOneButtonDialog(this.T).setMessage(getIntent().getStringExtra("msg")).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        String str;
        String trim = this.Z.getText().toString().trim();
        String trim2 = this.f19655a0.getText().toString().trim();
        String trim3 = this.f19656b0.getText().toString().trim();
        String trim4 = this.f19657c0.getText().toString().trim();
        if (trim4.isEmpty()) {
            g0("请输入真实姓名");
            return;
        }
        if (!trim4.equals(LoginUser.getLoginUser().getRealName())) {
            g0("请输入正确的姓名");
            return;
        }
        if (trim.isEmpty()) {
            g0("请输入旧密码");
            return;
        }
        if (trim2.isEmpty()) {
            g0("请输入新密码");
            return;
        }
        if (trim3.isEmpty()) {
            g0("请再次输入新密码");
            return;
        }
        if (!trim2.equals(trim3)) {
            g0("两次输入密码不一致");
            return;
        }
        String str2 = null;
        try {
            str = new x().a(trim);
            try {
                str2 = new x().a(trim2);
            } catch (Exception e6) {
                e = e6;
                new iOSOneButtonDialog(this.T).setMessage("修改密码异常，请联系管理员").show();
                e.printStackTrace();
                Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).V0(LoginUser.getLoginUser().getUserId(), str, str2)).setDataListener(new b());
            }
        } catch (Exception e7) {
            e = e7;
            str = null;
        }
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).V0(LoginUser.getLoginUser().getUserId(), str, str2)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_update_password;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (LinearLayout) findViewById(R.id.ll_name);
        this.Y = (TextView) findViewById(2131298986);
        this.Z = (EditText) findViewById(R.id.et_old_password);
        this.f19655a0 = (EditText) findViewById(R.id.et_password);
        this.f19656b0 = (EditText) findViewById(R.id.et_password_agn);
        this.f19657c0 = (EditText) findViewById(R.id.et_confirm_name);
        this.f19658k0 = (Button) findViewById(R.id.bt_complete);
        this.f19659p0 = (TextView) findViewById(R.id.tv_account);
        this.X = (LinearLayout) findViewById(R.id.ll_confirm_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb);
        ((TextView) findViewById(2131299164)).setText("修改密码");
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
