package com.bxkj.competition.signup.pay;

import android.content.Intent;
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
import cn.bluemobi.dylan.pay.AliPay;
import cn.bluemobi.dylan.pay.PayListener;
import cn.bluemobi.dylan.pay.WeChatPay;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.bxkj.competition.signup.CompetitionDetailActivity;
import com.bxkj.competition.signup.CostProjectListActivity;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.text.DecimalFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CompetitionPayActivity extends BaseActivity {
    private double F0;
    private double G0;
    private double H0;
    private PayListener I0 = new c();
    private TextView W;
    private Button X;
    private LinearLayout Y;
    private LinearLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private CheckBox f17467a0;

    /* renamed from: b0, reason: collision with root package name */
    private CheckBox f17468b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f17469c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f17470k0;

    /* renamed from: p0, reason: collision with root package name */
    private double f17471p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionPayActivity.this.l0(JsonParse.getString(data, "data"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String string = JsonParse.getString(data, "appid");
            String string2 = JsonParse.getString(data, "partnerid");
            String string3 = JsonParse.getString(data, "prepayid");
            String string4 = JsonParse.getString(data, "noncestr");
            String string5 = JsonParse.getString(data, WiseOpenHianalyticsData.UNION_PACKAGE);
            String string6 = JsonParse.getString(data, "timestamp");
            String string7 = JsonParse.getString(data, "sign");
            JsonParse.getString(data, "attach");
            new WeChatPay(((BaseActivity) CompetitionPayActivity.this).T).setPayLisitener(CompetitionPayActivity.this.I0).pay(string, string2, string3, string5, string4, string6, string7, "App");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements PayListener {
        c() {
        }

        public void a() {
            CompetitionPayActivity.this.g0("取消支付");
        }

        public void b() {
            CompetitionPayActivity.this.g0("支付失败");
        }

        public void c() {
            CompetitionPayActivity.this.g0("支付成功");
            CompetitionPayActivity.this.startActivity(new Intent(((BaseActivity) CompetitionPayActivity.this).T, (Class<?>) CompetePaySuccessActivity.class));
            try {
                cn.bluemobi.dylan.base.utils.a.n().getActivity(CompetitionDetailActivity.class).finish();
                cn.bluemobi.dylan.base.utils.a.n().getActivity(CostProjectListActivity.class).finish();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            CompetitionPayActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(String orderInfo) {
        new AliPay(this).pay(orderInfo).setPayLisitener(this.I0);
    }

    private void m0() {
        Http.with(this.T).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).u(this.f17469c0, LoginUser.getLoginUser().getUserId(), this.f17470k0, this.F0, this.G0, this.H0, this.f17471p0)).setDataListener(new a());
    }

    private void n0() {
        Http.with(this.T).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).w(this.f17469c0, LoginUser.getLoginUser().getUserId(), this.f17470k0, this.F0, this.G0, this.H0, this.f17471p0)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_competition_payment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("订单支付");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (Button) findViewById(R.id.bt_pay);
        this.W = (TextView) findViewById(R.id.tv_money);
        this.Y = (LinearLayout) findViewById(R.id.rl_alipay);
        this.Z = (LinearLayout) findViewById(R.id.rl_wechatpay);
        this.f17467a0 = (CheckBox) findViewById(R.id.cb_alipay);
        this.f17468b0 = (CheckBox) findViewById(R.id.cb_wecahtpay);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("competitionId")) {
            this.f17469c0 = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra("itemIds")) {
            this.f17470k0 = getIntent().getStringExtra("itemIds");
        }
        if (getIntent().hasExtra("insuranceFee")) {
            this.F0 = getIntent().getDoubleExtra("insuranceFee", 0.0d);
        }
        if (getIntent().hasExtra("competitionFee")) {
            this.G0 = getIntent().getDoubleExtra("competitionFee", 0.0d);
        }
        if (getIntent().hasExtra("totalPrice")) {
            this.H0 = getIntent().getDoubleExtra("totalPrice", 0.0d);
        }
        if (getIntent().hasExtra("payPrize")) {
            this.f17471p0 = getIntent().getDoubleExtra("payPrize", 0.0d);
        }
        this.W.setText(new DecimalFormat("￥0.00").format(this.f17471p0));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id == R.id.rl_alipay) {
            this.f17468b0.setChecked(false);
            this.f17467a0.setChecked(true);
            return;
        }
        if (id == R.id.rl_wechatpay) {
            this.f17467a0.setChecked(false);
            this.f17468b0.setChecked(true);
        } else if (id == R.id.bt_pay) {
            if (this.f17467a0.isChecked()) {
                m0();
            } else if (this.f17468b0.isChecked()) {
                n0();
            }
        }
    }
}
