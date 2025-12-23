package com.bxkj.student.run.punchcard;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.a;
import com.bxkj.student.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RecorderListActivity extends BaseActivity {
    private RadioGroup W;
    private String X;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("刷脸统计");
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
        RecordListFragment recordListFragment = new RecordListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", "effective");
        bundle.putString("termId", this.X);
        recordListFragment.setArguments(bundle);
        arrayList.add(recordListFragment);
        RecordListFragment recordListFragment2 = new RecordListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "all");
        bundle2.putString("termId", this.X);
        recordListFragment2.setArguments(bundle2);
        arrayList.add(recordListFragment2);
        new a(getSupportFragmentManager(), arrayList, 2131298030, this.W);
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
