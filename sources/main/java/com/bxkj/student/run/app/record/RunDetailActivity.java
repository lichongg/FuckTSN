package com.bxkj.student.run.app.record;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.vm.RunVM;
import com.google.android.material.tabs.TabLayout;
import com.umeng.socialize.UMShareAPI;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunDetailActivity extends BaseActivity {
    private TabLayout W;
    private TraceDetailFragment X;
    private RunVM Y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f19971a;

        a(final Bundle val$args) {
            this.f19971a = val$args;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            this.f19971a.putString("latLngTimeSpeed", JsonParse.getString(data, "gitudeLatitude"));
            this.f19971a.putString("speed", JsonParse.getString(data, "avgspeed"));
            this.f19971a.putString("peisu", JsonParse.getString(data, "speed"));
            this.f19971a.putString("time", JsonParse.getString(data, "sportTime"));
            this.f19971a.putString("distance", JsonParse.getString(data, "sportRange"));
            this.f19971a.putString("okPointList", JsonParse.getString(data, "okPointList"));
            this.f19971a.putString("step", JsonParse.getString(data, "stepNumbers"));
            this.f19971a.putString("geoFence", JsonParse.getString(data, "geofence"));
            this.f19971a.putString("punchCoordinate", JsonParse.getString(data, "punchCoordinate"));
            RunDetailActivity.this.k0(this.f19971a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(Bundle args) {
        ArrayList arrayList = new ArrayList();
        this.X = new TraceDetailFragment();
        StepDetailFragment stepDetailFragment = new StepDetailFragment();
        this.X.setArguments(args);
        stepDetailFragment.setArguments(args);
        arrayList.add(this.X);
        arrayList.add(stepDetailFragment);
        new cn.bluemobi.dylan.base.adapter.b(getSupportFragmentManager(), arrayList, 2131298030, this.W);
        if (getIntent().hasExtra("runType") && getIntent().getIntExtra("runType", 2) == 0) {
            this.W.getTabAt(1).select();
        }
    }

    private void l0() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 m0(Bundle bundle, List list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        RunDb runDb = (RunDb) list.get(0);
        if (runDb != null) {
            bundle.putString("step", runDb.getStepList());
        }
        k0(bundle);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0() {
        TraceDetailFragment traceDetailFragment = this.X;
        if (traceDetailFragment != null) {
            traceDetailFragment.q0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.Y = (RunVM) new ViewModelProvider(this).get(RunVM.class);
        l0();
        final Bundle bundle = new Bundle();
        if (getIntent().hasExtra("sportRecordId")) {
            String stringExtra = getIntent().getStringExtra("sportRecordId");
            bundle.putString("sportRecordId", stringExtra);
            Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).m(stringExtra)).setDataListener(new a(bundle));
            return;
        }
        if (!getIntent().hasExtra("latLngTimeSpeed")) {
            if (getIntent().hasExtra("runDataDbId")) {
                bundle.putString("runDataDbId", getIntent().getStringExtra("runDataDbId"));
                this.Y.w(getIntent().getStringExtra("runDataDbId"), new Function1() { // from class: com.bxkj.student.run.app.record.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 m02;
                        m02 = RunDetailActivity.this.m0(bundle, (List) obj);
                        return m02;
                    }
                });
                return;
            }
            return;
        }
        bundle.putString("latLngTimeSpeed", getIntent().getStringExtra("latLngTimeSpeed"));
        bundle.putString("speed", getIntent().getStringExtra("speed"));
        bundle.putString("peisu", getIntent().getStringExtra("peisu"));
        bundle.putString("time", getIntent().getStringExtra("time"));
        bundle.putString("distance", getIntent().getStringExtra("distance"));
        bundle.putString("okPointList", getIntent().getStringExtra("okPointList"));
        bundle.putString("step", getIntent().getStringExtra("step"));
        bundle.putString("geoFence", getIntent().getStringExtra("geoFence"));
        k0(bundle);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("跑步详情");
        c0("分享", new BaseActivity.c() { // from class: com.bxkj.student.run.app.record.j
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                RunDetailActivity.this.n0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_run_details;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TabLayout) findViewById(R.id.tb);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this.T).onActivityResult(requestCode, resultCode, data);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
