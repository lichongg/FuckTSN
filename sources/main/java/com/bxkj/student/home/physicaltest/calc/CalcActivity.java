package com.bxkj.student.home.physicaltest.calc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.student.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CalcActivity extends BaseActivity {
    private EditText F0;
    private TextView G0;
    private EditText H0;
    private TextView I0;
    private EditText J0;
    private Button K0;
    private EditText W;
    private RadioGroup X;
    private RadioGroup Y;
    private RadioButton Z;

    /* renamed from: a0, reason: collision with root package name */
    private EditText f17938a0;

    /* renamed from: b0, reason: collision with root package name */
    private EditText f17939b0;

    /* renamed from: c0, reason: collision with root package name */
    private EditText f17940c0;

    /* renamed from: k0, reason: collision with root package name */
    private EditText f17941k0;

    /* renamed from: p0, reason: collision with root package name */
    private EditText f17942p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == 2131298346) {
                CalcActivity.this.G0.setText("1000米");
                CalcActivity.this.I0.setText("引体向上");
            } else {
                CalcActivity.this.G0.setText("800米");
                CalcActivity.this.I0.setText("仰卧起坐");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HashMap hashMap = new HashMap(data);
            SeralizableMap seralizableMap = new SeralizableMap();
            seralizableMap.setMap(hashMap);
            CalcActivity.this.startActivity(new Intent(((BaseActivity) CalcActivity.this).T, (Class<?>) CalcResultActivity.class).putExtra(CommonNetImpl.SM, seralizableMap));
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CalcActivity.this).T).setMessage(msg).show();
        }
    }

    private void l0() {
        this.W.getText().toString().getClass();
        String str = this.X.getCheckedRadioButtonId() == this.X.getChildAt(0).getId() ? "1" : "2";
        RadioGroup radioGroup = this.Y;
        String trim = ((RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString().trim();
        String trim2 = this.f17938a0.getText().toString().trim();
        String trim3 = this.f17939b0.getText().toString().trim();
        String trim4 = this.f17940c0.getText().toString().trim();
        String trim5 = this.f17941k0.getText().toString().trim();
        String trim6 = this.f17942p0.getText().toString().trim();
        String trim7 = this.F0.getText().toString().trim();
        String trim8 = this.H0.getText().toString().trim();
        String trim9 = this.J0.getText().toString().trim();
        if (TextUtils.isEmpty(trim2) && TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim4) && TextUtils.isEmpty(trim5) && TextUtils.isEmpty(trim6) && TextUtils.isEmpty(trim7) && TextUtils.isEmpty(trim8) && TextUtils.isEmpty(trim9)) {
            new iOSOneButtonDialog(this.T).setMessage("请至少输入一项").show();
            return;
        }
        if (!TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim2)) {
            new iOSOneButtonDialog(this.T).setMessage("请输入身高").show();
        } else if (TextUtils.isEmpty(trim2) || !TextUtils.isEmpty(trim3)) {
            Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).K0(str, trim, trim2, trim3, trim4, trim5, trim6, trim7, trim8, trim9)).setDataListener(new b());
        } else {
            new iOSOneButtonDialog(this.T).setMessage("请输入体重").show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnCheckedChangeListener(new a());
        this.K0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("体测计算器");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_physical_testing_calc;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(R.id.et_name);
        this.X = (RadioGroup) findViewById(R.id.rg_sex);
        this.Z = (RadioButton) findViewById(R.id.rb_mail);
        this.f17938a0 = (EditText) findViewById(R.id.et_height);
        this.f17939b0 = (EditText) findViewById(R.id.et_weight);
        this.f17940c0 = (EditText) findViewById(R.id.et_vital_capacity);
        this.f17941k0 = (EditText) findViewById(R.id.et_standing_long_jump);
        this.f17942p0 = (EditText) findViewById(R.id.et_sitting_body_flexion);
        this.F0 = (EditText) findViewById(R.id.et_50);
        this.G0 = (TextView) findViewById(R.id.tv_800_or_1000);
        this.H0 = (EditText) findViewById(R.id.et_800_or_1000);
        this.I0 = (TextView) findViewById(R.id.tv_pull_or_sit);
        this.J0 = (EditText) findViewById(R.id.et_pull_or_sit);
        this.K0 = (Button) findViewById(2131296623);
        this.Y = (RadioGroup) findViewById(R.id.rg_grade);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296623) {
            return;
        }
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }
}
