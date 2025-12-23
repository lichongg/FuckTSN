package com.bxkj.student.personal.sign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.Map;
import x.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SignInActivity extends BaseActivity {
    private TextView W;
    private Button X;
    private CycleViewPager Y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            SignInActivity.this.startActivity(new Intent(((BaseActivity) SignInActivity.this).T, (Class<?>) SignRecordListActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignInActivity.this.Q().setVisibility(0);
            SignInActivity.this.W.setText("我的积分：" + JsonParse.getString(data, "sumIntegral"));
            boolean z5 = JsonParse.getBoolean(data, "isSign");
            SignInActivity.this.X.setEnabled(z5 ^ true);
            if (z5) {
                SignInActivity.this.X.setText("今日已签到");
            } else {
                SignInActivity.this.X.setText("立即签到");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignInActivity.this.S();
            new iOSOneButtonDialog(((BaseActivity) SignInActivity.this).T).setCenterCustomView(R.layout.dialog_sign_success).show();
        }
    }

    private void l0() {
        Http.with(this.T).hideSuccessMessage().setObservable(((f) Http.getApiService(f.class)).i(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getAccount())).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Http.with(this.T).setObservable(((f) Http.getApiService(f.class)).u(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getRealName())).setDataListener(new b());
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        this.Y.setData(arrayList, null);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("签到领积分");
        e0(ContextCompat.getColor(this, 2131099737));
        c0("记录", new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_sign_in;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(2131299093);
        this.X = (Button) findViewById(R.id.bt_signs);
        this.Y = (CycleViewPager) findViewById(2131296829);
        Q().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296644) {
            return;
        }
        l0();
    }
}
