package com.bxkj.student.personal.customer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ContactCustomerServiceActivity extends BaseActivity {
    private EditText W;
    private EditText X;
    private EditText Y;
    private Button Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19616a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19617b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19618c;

        a(final String val$name, final String val$number, final String val$phone) {
            this.f19616a = val$name;
            this.f19617b = val$number;
            this.f19618c = val$phone;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setTempUserId(JsonParse.getString(data, "id"));
            LoginUser.getLoginUser().setTempUserName(this.f19616a);
            LoginUser.getLoginUser().setTempUserNumber(this.f19617b);
            LoginUser.getLoginUser().setTempUserPhone(this.f19618c);
            ContactCustomerServiceActivity.this.startActivity(new Intent(((BaseActivity) ContactCustomerServiceActivity.this).T, (Class<?>) ContactCustomerActivity.class));
            ContactCustomerServiceActivity.this.finish();
        }
    }

    private void j0() {
        String trim = this.W.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.T).setMessage(this.W.getHint().toString()).show();
            return;
        }
        String trim2 = this.X.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            new iOSOneButtonDialog(this.T).setMessage(this.X.getHint().toString()).show();
            return;
        }
        String trim3 = this.Y.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            new iOSOneButtonDialog(this.T).setMessage(this.Y.getHint().toString()).show();
        } else if (trim3.length() != 11) {
            new iOSOneButtonDialog(this.T).setMessage("请输入正确的手机号码").show();
        } else {
            Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).e1(trim2, trim, trim3)).setDataListener(new a(trim, trim2, trim3));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.customer.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactCustomerServiceActivity.this.k0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("请输入联系方式");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        j0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_contact_customer;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(R.id.et_name);
        this.X = (EditText) findViewById(2131296937);
        this.Y = (EditText) findViewById(2131296941);
        this.Z = (Button) findViewById(R.id.bt_contact_customer);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
