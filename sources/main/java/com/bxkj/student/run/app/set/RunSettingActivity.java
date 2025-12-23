package com.bxkj.student.run.app.set;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunSettingActivity extends BaseActivity {
    private LinearLayout W;
    private LinearLayout X;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        startActivity(new Intent(this.T, (Class<?>) RunPermissionSetActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        startActivity(new Intent(this.T, (Class<?>) RunFrequencySetActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunSettingActivity.this.j0(view);
            }
        });
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunSettingActivity.this.k0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("跑步设置");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_run_setting;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (LinearLayout) findViewById(R.id.ll_permission_set);
        this.X = (LinearLayout) findViewById(R.id.ll_frequency_set);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
