package com.bxkj.student.personal.password.forget;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.l;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class InputNumberActivity extends BaseActivity {
    private EditText W;
    private Button X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            InputNumberActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19664a;

        b(final String val$number) {
            this.f19664a = val$number;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InputNumberActivity.this.startActivity(new Intent(((BaseActivity) InputNumberActivity.this).T, (Class<?>) SelectClassmateActivity.class).putExtra("userNumber", this.f19664a).putExtra("classmate", JSON.toJSONString(JsonParse.getList(data, "data"))));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        d0(false);
    }

    private void k0() {
        String trim = this.W.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.T).setMessage("请输入要找回密码的学号").show();
        } else {
            Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).p1(trim)).setDataListener(new b(trim));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputNumberActivity.this.j0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_input_number;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(R.id.et_account);
        this.X = (Button) findViewById(R.id.bt_next);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb);
        ((TextView) findViewById(2131299164)).setText("输入要找回密码的学号");
        toolbar.setNavigationIcon(2131231200);
        toolbar.setNavigationOnClickListener(new a());
        try {
            toolbar.getRootView().getRootView().setBackgroundResource(R.mipmap.login_bg);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        l.d(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
