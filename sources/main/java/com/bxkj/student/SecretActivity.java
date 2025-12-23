package com.bxkj.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.personal.login.LoginActivity;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SecretActivity extends BaseActivity {
    List<String> W = new ArrayList();

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.add("e56b888b-b2fc-32c8-83da-7eb52687835a");
        this.W.add("0801e54a-a7ca-336a-b609-ca6ac126952b");
        this.W.add("28523735-bfaf-3bc2-aa09-7e98b083b790");
        this.W.add("6c3141fb-0c80-3d6f-805d-63381dd5c59e");
        this.W.add("b1f4540e-210e-38c9-be3e-3bdb68eaa485");
        this.W.add("2a4965bb-5f90-38aa-887c-18b2b7d47a04");
        this.W.add("c9f0a9cd-f563-35fa-a3b8-b440228f1f44");
        this.W.add("6b53cbf2-d6c8-3ee9-8909-d90f2eefb9e9");
        if (!this.W.contains(com.bxkj.base.v2.common.utils.f.f16889a.d(this.T))) {
            g0("你想干什么？");
            finish();
            return;
        }
        if (getIntent().hasExtra("school_name") && getIntent().hasExtra("school_url") && getIntent().hasExtra("school_id")) {
            String stringExtra = getIntent().getStringExtra("school_name");
            String stringExtra2 = getIntent().getStringExtra("school_url");
            String stringExtra3 = getIntent().getStringExtra("school_id");
            LoginUser.getLoginUser().setSchoolName(stringExtra);
            LoginUser.getLoginUser().setServerUrl(stringExtra2);
            LoginUser.getLoginUser().setSchoolId(stringExtra3);
            if (getIntent().hasExtra("openId")) {
                LoginUser.getLoginUser().setAppId(getIntent().getStringExtra("openId"));
            }
            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
        }
        if (getIntent().hasExtra("userId") && getIntent().hasExtra(CommonNetImpl.NAME) && getIntent().hasExtra("userNum")) {
            String stringExtra4 = getIntent().getStringExtra("userId");
            String stringExtra5 = getIntent().getStringExtra(CommonNetImpl.NAME);
            String stringExtra6 = getIntent().getStringExtra("userNum");
            LoginUser.getLoginUser().setLogin(true);
            LoginUser.getLoginUser().setUserId(stringExtra4);
            LoginUser.getLoginUser().setRealName(stringExtra5);
            LoginUser.getLoginUser().setAccount(stringExtra6);
            this.T.startActivity(new Intent(this.T, (Class<?>) MainActivity.class));
        } else {
            this.T.startActivity(new Intent(this.T, (Class<?>) LoginActivity.class));
        }
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_secret;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
