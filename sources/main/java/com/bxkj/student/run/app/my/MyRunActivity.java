package com.bxkj.student.run.app.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.set.RunSettingActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyRunActivity extends BaseActivity {
    private LinearLayout W;
    private LinearLayout X;
    private LinearLayout Y;
    private LinearLayout Z;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        startActivity(new Intent(this.T, (Class<?>) RunRecorderListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        startActivity(new Intent(this.T, (Class<?>) RunSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        startActivity(new Intent(this.T, (Class<?>) RunRankActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        startActivity(new Intent(this.T, (Class<?>) RunStatisticsActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.l0(view);
            }
        });
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.m0(view);
            }
        });
        this.Y.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.n0(view);
            }
        });
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.o0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的跑步");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_my_run;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (LinearLayout) findViewById(R.id.ll_run_record);
        this.X = (LinearLayout) findViewById(R.id.ll_run_statistics);
        this.Y = (LinearLayout) findViewById(R.id.ll_run_rank);
        this.Z = (LinearLayout) findViewById(R.id.ll_run_set);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
