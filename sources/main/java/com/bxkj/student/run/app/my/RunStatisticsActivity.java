package com.bxkj.student.run.app.my;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunStatisticsActivity extends BaseActivity {
    private TabLayout W;
    private Map<String, Object> X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunStatisticsActivity.this.X = data;
            ArrayList arrayList = new ArrayList();
            RunStaticsFragment runStaticsFragment = new RunStaticsFragment();
            Bundle bundle = new Bundle();
            List list = JsonParse.getList(RunStatisticsActivity.this.X, "week", Float.class);
            float[] fArr = new float[list.size()];
            for (int i6 = 0; i6 < list.size(); i6++) {
                fArr[i6] = ((Float) list.get(i6)).floatValue();
            }
            bundle.putInt("type", 1);
            bundle.putFloatArray("listData", fArr);
            runStaticsFragment.setArguments(bundle);
            arrayList.add(runStaticsFragment);
            RunStaticsFragment runStaticsFragment2 = new RunStaticsFragment();
            Bundle bundle2 = new Bundle();
            List list2 = JsonParse.getList(RunStatisticsActivity.this.X, "month", Float.class);
            float[] fArr2 = new float[list2.size()];
            for (int i7 = 0; i7 < list2.size(); i7++) {
                fArr2[i7] = ((Float) list2.get(i7)).floatValue();
            }
            bundle2.putInt("type", 2);
            bundle2.putFloatArray("listData", fArr2);
            runStaticsFragment2.setArguments(bundle2);
            arrayList.add(runStaticsFragment2);
            RunStaticsFragment runStaticsFragment3 = new RunStaticsFragment();
            Bundle bundle3 = new Bundle();
            List list3 = JsonParse.getList(RunStatisticsActivity.this.X, "sysTerm", Float.class);
            float[] fArr3 = new float[list3.size()];
            for (int i8 = 0; i8 < list3.size(); i8++) {
                fArr3[i8] = ((Float) list3.get(i8)).floatValue();
            }
            bundle3.putInt("type", 3);
            bundle3.putFloatArray("listData", fArr3);
            runStaticsFragment3.setArguments(bundle3);
            arrayList.add(runStaticsFragment3);
            new cn.bluemobi.dylan.base.adapter.b(RunStatisticsActivity.this.getSupportFragmentManager(), arrayList, 2131298030, RunStatisticsActivity.this.W);
        }
    }

    private void k0() {
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).j(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("跑步统计");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_run_statistics;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TabLayout) findViewById(R.id.tb_type);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
