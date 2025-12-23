package com.bxkj.student.personal.password.forget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FindPasswordTypeActivity extends BaseActivity {
    private LinearLayout W;
    private LinearLayout X;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        startActivity(new Intent(this.T, (Class<?>) InputNumberActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindPasswordTypeActivity.this.i0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("选择找回密码方式");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_find_password_type;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (LinearLayout) findViewById(R.id.ll_by_phone);
        this.X = (LinearLayout) findViewById(R.id.ll_by_id_and_classmate);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
