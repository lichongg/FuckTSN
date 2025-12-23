package com.bxkj.student.home.teaching.rollcall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.student.R;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SignActivity extends BaseActivity {
    private Button W;
    private String X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            new iOSOneButtonDialog(((BaseActivity) SignActivity.this).T).setMessage("签到成功").show();
        }
    }

    private void k0() {
        Http.with(this.T).hideSuccessMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).j0(this.X)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignActivity.this.j0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("上课签到");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_teach_sigin;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.X = getIntent().getStringExtra("id");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (Button) findViewById(R.id.bt_in);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
