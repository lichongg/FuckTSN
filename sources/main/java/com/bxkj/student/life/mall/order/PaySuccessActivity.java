package com.bxkj.student.life.mall.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PaySuccessActivity extends BaseActivity {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19356a;

        a(final String val$orderId) {
            this.f19356a = val$orderId;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            PaySuccessActivity.this.startActivity(new Intent(((BaseActivity) PaySuccessActivity.this).T, (Class<?>) OrderDetailActivity.class).putExtra("orderId", this.f19356a));
            PaySuccessActivity.this.finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("支付结果");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_runner_pay_success;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("orderId")) {
            ((Button) findViewById(2131296624)).setOnClickListener(new a(getIntent().getStringExtra("orderId")));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
