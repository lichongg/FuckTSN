package com.bxkj.student.life.mall.address;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AddAddressActivity extends BaseActivity {
    private String F0;
    private String G0;
    private String H0;
    private final int I0 = 170;
    private EditText W;
    private EditText X;
    private EditText Y;
    private EditText Z;

    /* renamed from: a0, reason: collision with root package name */
    private Button f19244a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f19245b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f19246c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f19247k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f19248p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyAddressListActivity myAddressListActivity = (MyAddressListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MyAddressListActivity.class);
            if (myAddressListActivity != null) {
                myAddressListActivity.u0();
            }
            if (TextUtils.isEmpty(AddAddressActivity.this.f19245b0)) {
                AddAddressActivity.this.g0("添加成功");
            } else {
                AddAddressActivity.this.g0("修改成功");
            }
            AddAddressActivity.this.finish();
        }
    }

    private void i0() {
        String trim = this.W.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            g0(this.W.getHint());
            return;
        }
        String trim2 = this.X.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            g0(this.X.getHint());
            return;
        }
        if (trim2.length() < 11) {
            g0("请输入正确的手机号码");
            return;
        }
        if (TextUtils.isEmpty(this.Y.getText().toString().trim())) {
            g0(this.Y.getHint());
            return;
        }
        String trim3 = this.Z.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            g0(this.Z.getHint());
        } else {
            Http.with(this.T).setObservable(((g) Http.getApiService(g.class)).y(this.f19245b0, LoginUser.getLoginUser().getOpenId(), this.G0, trim3, trim, trim2)).setDataListener(new a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnClickListener(this);
        this.f19244a0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("添加收货地址");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_add_address;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("addressId")) {
            this.f19245b0 = getIntent().getStringExtra("addressId");
            setTitle("编辑收货地址");
        } else {
            setTitle("添加收货地址");
        }
        if (getIntent().hasExtra(CommonNetImpl.NAME)) {
            this.W.setText(getIntent().getStringExtra(CommonNetImpl.NAME));
        }
        if (getIntent().hasExtra("phone")) {
            this.X.setText(getIntent().getStringExtra("phone"));
        }
        if (getIntent().hasExtra(DistrictSearchQuery.KEYWORDS_CITY)) {
            this.Y.setText(getIntent().getStringExtra(DistrictSearchQuery.KEYWORDS_CITY));
        }
        if (getIntent().hasExtra("areaId")) {
            this.G0 = getIntent().getStringExtra("areaId");
        }
        if (getIntent().hasExtra("address")) {
            this.Z.setText(getIntent().getStringExtra("address"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.Y = (EditText) findViewById(R.id.et_city);
        this.W = (EditText) findViewById(R.id.et_name);
        this.X = (EditText) findViewById(2131296941);
        this.Y = (EditText) findViewById(R.id.et_city);
        this.Z = (EditText) findViewById(R.id.et_address);
        this.f19244a0 = (Button) findViewById(2131296581);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && data != null && requestCode == 170) {
            this.f19246c0 = data.getStringExtra("provinceId");
            this.f19247k0 = data.getStringExtra("provinceName");
            this.f19248p0 = data.getStringExtra("cityId");
            this.F0 = data.getStringExtra("cityName");
            this.G0 = data.getStringExtra("areaId");
            this.H0 = data.getStringExtra("areaName");
            this.Y.setText(this.f19247k0 + this.F0 + this.H0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id != 2131296581) {
            if (id != 2131296928) {
                return;
            }
            startActivityForResult(new Intent(this.T, (Class<?>) ChooseCityActivity.class), 170);
            return;
        }
        i0();
    }
}
