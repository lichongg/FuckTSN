package com.bxkj.student.life.mall.order;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.text.DecimalFormat;
import java.util.Map;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class OrderPayActivity extends BaseActivity {
    private TextView W;
    private Button X;
    private LinearLayout Y;
    private LinearLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private CheckBox f19349a0;

    /* renamed from: b0, reason: collision with root package name */
    private CheckBox f19350b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f19351c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f19352k0;

    /* renamed from: p0, reason: collision with root package name */
    private double f19353p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            JsonParse.getString(data, "appid");
            JsonParse.getString(data, "partnerid");
            JsonParse.getString(data, "prepayid");
            JsonParse.getString(data, "noncestr");
            JsonParse.getString(data, WiseOpenHianalyticsData.UNION_PACKAGE);
            JsonParse.getString(data, "timestamp");
            JsonParse.getString(data, "sign");
        }
    }

    private void h0() {
        Http.with(this.T).setObservable(((g) Http.getApiService(g.class)).b(this.f19351c0)).setDataListener(new a());
    }

    private void i0() {
        Http.with(this.T).setObservable(((g) Http.getApiService(g.class)).m(this.f19351c0)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("订单支付");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_payment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("orderId")) {
            this.f19351c0 = getIntent().getStringExtra("orderId");
        }
        if (getIntent().hasExtra("orderNo")) {
            this.f19352k0 = getIntent().getStringExtra("orderNo");
        }
        if (getIntent().hasExtra("payPrice")) {
            this.f19353p0 = getIntent().getDoubleExtra("payPrice", 100.0d);
        }
        this.W.setText(new DecimalFormat("￥0.00").format(this.f19353p0));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (Button) findViewById(2131296626);
        this.W = (TextView) findViewById(2131298980);
        this.Y = (LinearLayout) findViewById(2131298381);
        this.Z = (LinearLayout) findViewById(2131298410);
        this.f19349a0 = (CheckBox) findViewById(2131296717);
        this.f19350b0 = (CheckBox) findViewById(2131296724);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id != 2131296626) {
            if (id != 2131298381) {
                if (id == 2131298410) {
                    this.f19349a0.setChecked(false);
                    this.f19350b0.setChecked(true);
                    return;
                }
                return;
            }
            this.f19350b0.setChecked(false);
            this.f19349a0.setChecked(true);
            return;
        }
        if (this.f19349a0.isChecked()) {
            h0();
        } else if (this.f19350b0.isChecked()) {
            i0();
        }
    }
}
