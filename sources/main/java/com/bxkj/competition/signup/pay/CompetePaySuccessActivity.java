package com.bxkj.competition.signup.pay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.competition.R;
import com.bxkj.competition.signup.my.MyCompetitionListActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CompetePaySuccessActivity extends BaseActivity {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            CompetePaySuccessActivity.this.startActivity(new Intent(((BaseActivity) CompetePaySuccessActivity.this).T, (Class<?>) MyCompetitionListActivity.class));
            CompetePaySuccessActivity.this.finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_pay_success;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Button button = (Button) findViewById(R.id.bt_order);
        button.setText("查看报名");
        button.setOnClickListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("支付结果");
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
