package com.bxkj.student.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;
import com.bxkj.student.personal.password.UpdatePasswordActivity;
import com.bxkj.student.personal.password.forget.FindPasswordTypeActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SafeSetActivity extends BaseActivity {
    private TextView W;
    private TextView X;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("安全设置");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_safe_set;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_update_password);
        this.X = (TextView) findViewById(R.id.tv_forget_password);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id != 2131298915) {
            if (id != 2131299174) {
                return;
            }
            startActivity(new Intent(this.T, (Class<?>) UpdatePasswordActivity.class));
            return;
        }
        startActivity(new Intent(this.T, (Class<?>) FindPasswordTypeActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }
}
