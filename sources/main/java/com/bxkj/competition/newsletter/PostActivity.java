package com.bxkj.competition.newsletter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.bxkj.competition.b;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PostActivity extends BaseActivity {
    private EditText W;
    private Button X;
    private String Y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((NewsLetterListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(NewsLetterListActivity.class)).w0();
            PostActivity.this.finish();
        }
    }

    private void h0() {
        String trim = this.W.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            g0("请输入内容");
        } else {
            Http.with(this.T).setObservable(((b) Http.getApiService(b.class)).y(this.Y, LoginUser.getLoginUser().getUserId(), trim)).setDataListener(new a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_post_newletter;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("发布通讯稿");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(R.id.et_content);
        this.X = (Button) findViewById(R.id.bt_commit);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("competitionId")) {
            this.Y = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra("content")) {
            this.W.setText(getIntent().getStringExtra("content"));
            this.W.setFocusable(false);
            this.W.setFocusableInTouchMode(false);
            this.X.setVisibility(8);
            setTitle("我的通讯稿");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() == R.id.bt_commit) {
            h0();
        }
    }
}
