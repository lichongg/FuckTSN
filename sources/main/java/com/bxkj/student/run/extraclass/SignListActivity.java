package com.bxkj.student.run.extraclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SignListActivity extends BaseActivity {
    private RadioGroup W;
    private String X;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0() {
        startActivity(new Intent(this.T, (Class<?>) SignTypeActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("场馆打卡记录");
        c0("扫码签到", new BaseActivity.c() { // from class: com.bxkj.student.run.extraclass.a
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                SignListActivity.this.i0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_recorder_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("termId")) {
            this.X = getIntent().getStringExtra("termId");
        }
        ArrayList arrayList = new ArrayList();
        SignListFragment signListFragment = new SignListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", "effective");
        bundle.putString("termId", this.X);
        signListFragment.setArguments(bundle);
        arrayList.add(signListFragment);
        SignListFragment signListFragment2 = new SignListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "all");
        bundle2.putString("termId", this.X);
        signListFragment2.setArguments(bundle2);
        arrayList.add(signListFragment2);
        new cn.bluemobi.dylan.base.adapter.a(getSupportFragmentManager(), arrayList, 2131298030, this.W);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (RadioGroup) findViewById(2131298361);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
