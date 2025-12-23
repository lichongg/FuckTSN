package com.bxkj.student.run.app.record;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.b0;
import com.bxkj.student.R;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.vm.RunVM;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.analytics.AnalyticsConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunRecorderListActivity extends BaseActivity {
    private List<Map<String, Object>> F0 = new ArrayList();
    protected int G0 = 10;
    protected int H0 = 1;
    protected int I0 = 1;
    private int J0 = 2;
    private TabLayout.Tab K0;
    private TabLayout.Tab L0;
    private TabLayout.Tab M0;
    private TabLayout.OnTabSelectedListener N0;
    private SimpleDateFormat O0;
    private RunVM P0;
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19973a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f19974b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19975c0;

    /* renamed from: k0, reason: collision with root package name */
    private CardView f19976k0;

    /* renamed from: p0, reason: collision with root package name */
    private TabLayout f19977p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.run.app.record.RunRecorderListActivity$a$a, reason: collision with other inner class name */
        class C0269a implements Function1<List<RunDb>, n1> {
            C0269a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public n1 invoke(List<RunDb> runDbs) {
                if (runDbs == null || runDbs.size() <= 0) {
                    return null;
                }
                a.this.y(runDbs.get(0));
                return null;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b extends HttpCallBack {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RunDb f19980a;

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }

            b(final RunDb val$runDataDB) {
                this.f19980a = val$runDataDB;
            }

            private void a(String msg) {
                RunRecorderListActivity.this.P0.v(this.f19980a.getIdentify());
                RunRecorderListActivity.this.W.F();
                StartRunActivity startRunActivity = (StartRunActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(StartRunActivity.class);
                if (startRunActivity != null) {
                    startRunActivity.n1();
                }
                new iOSOneButtonDialog(((CommonAdapter) a.this).f1138e).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnFailure(Throwable e6) {
                if (e6 instanceof SocketTimeoutException) {
                    new iOSOneButtonDialog(((CommonAdapter) a.this).f1138e).setMessage("上传超时,请检查网络后重试").setOneButtonText("确定").show();
                    return;
                }
                StringWriter stringWriter = new StringWriter();
                e6.printStackTrace(new PrintWriter(stringWriter));
                stringWriter.toString();
                StringBuilder sb = new StringBuilder("上传失败,请稍后再试");
                sb.append(e6.getMessage());
                new iOSOneButtonDialog(((CommonAdapter) a.this).f1138e).setMessage(sb).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data, String msg) {
                super.netOnSuccess(data, msg);
                a(msg);
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                if (status == 202) {
                    a(msg);
                } else {
                    new iOSOneButtonDialog(((CommonAdapter) a.this).f1138e).setMessage(msg).show();
                }
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccessServerError(int code, String errorMessage) {
                super.netOnSuccessServerError(code, errorMessage);
                new iOSOneButtonDialog(((CommonAdapter) a.this).f1138e).setMessage("上传异常,错误码：【" + code + "】,错误信息：" + errorMessage + ",请稍后再试！").show();
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        private int v(String step) {
            if (TextUtils.isEmpty(step)) {
                return 0;
            }
            List arrayList = new ArrayList();
            try {
                if (JSON.parse(step) instanceof JSONArray) {
                    arrayList = JSON.parseArray(step, Integer.class);
                } else {
                    String[] split = step.split(",");
                    if (split.length > 0) {
                        for (String str : split) {
                            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                        }
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                String[] split2 = step.split(",");
                if (split2.length > 0) {
                    for (String str2 : split2) {
                        if (str2 == null || "null".equalsIgnoreCase(str2)) {
                            arrayList.add(0);
                        } else {
                            try {
                                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                            } catch (NumberFormatException e7) {
                                e7.printStackTrace();
                            }
                        }
                    }
                }
            }
            if (arrayList == null || arrayList.size() == 0) {
                return 0;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                i6 += ((Integer) arrayList.get(i7)).intValue();
            }
            return i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Map map, View view) {
            RunRecorderListActivity.this.P0.w(JsonParse.getString(map, "id"), new C0269a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(Map map, View view) {
            RunRecorderListActivity.this.startActivity(new Intent(this.f1138e, (Class<?>) AppealActivity.class).putExtra("id", JsonParse.getString(map, "id")));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y(RunDb runDataDB) {
            long parseLong = Long.parseLong(runDataDB.getCountTime());
            double parseFloat = Float.parseFloat(runDataDB.getDistance());
            Http.with(this.f1138e).setLoadingMessage("正在上传...").hideSuccessMessage().setTimeout(3L, TimeUnit.MINUTES).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).l(LoginUser.getLoginUser().getUserId(), Integer.parseInt(runDataDB.getSportsType()), Long.parseLong(runDataDB.getStartTime()), Long.parseLong(runDataDB.getEndTime()), TextUtils.isEmpty(runDataDB.getLatLngList()) ? null : runDataDB.getLatLngList(), runDataDB.getIdentify(), com.bxkj.student.run.app.utils.i.g(parseLong), com.bxkj.student.run.app.utils.i.d(parseFloat), com.bxkj.student.run.app.utils.i.a(parseFloat, parseLong), com.bxkj.student.run.app.utils.i.b(parseFloat, parseLong), TextUtils.isEmpty(runDataDB.getPassLatLngList()) ? null : runDataDB.getPassLatLngList(), b0.d(), b0.e(), "Android", b0.c(), b0.h(this.f1138e), JSON.toJSONString(runDataDB.getStepList()), runDataDB.isFaceOut(), TextUtils.isEmpty(runDataDB.getPassLatLngList()) ? null : runDataDB.getPassLatLngList(), Integer.valueOf(Integer.parseInt(runDataDB.getUploadType())), null)).setDataListener(new b(runDataDB));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String str;
            int i6;
            holder.J(2131298991, String.valueOf(holder.f() + 1));
            holder.J(2131298881, JsonParse.getString(stringObjectMap, "sportRange"));
            holder.J(R.id.tv_time_count, JsonParse.getString(stringObjectMap, "sportTime"));
            holder.J(2131299113, JsonParse.getString(stringObjectMap, AnalyticsConfig.RTD_START_TIME));
            holder.J(2131299116, JsonParse.getString(stringObjectMap, "remark"));
            holder.J(R.id.tv_step_count, String.valueOf(v(JsonParse.getString(stringObjectMap, "stepNumbers"))));
            String string = JsonParse.getString(stringObjectMap, "uploadType");
            if (TextUtils.isEmpty(string)) {
                str = "";
            } else {
                str = "上传方式：" + string;
            }
            holder.J(R.id.tv_upload_type, str);
            String string2 = JsonParse.getString(stringObjectMap, "sportStatus");
            CardView cardView = (CardView) holder.h(2131296684);
            if ("-1".equalsIgnoreCase(string2)) {
                holder.J(R.id.bt_appeal, "上传");
                holder.N(R.id.bt_appeal, true);
                holder.n(R.id.bt_appeal, true);
                holder.w(R.id.bt_appeal, new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunRecorderListActivity.a.this.w(stringObjectMap, view);
                    }
                });
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.f1138e, 2131100550));
                i6 = R.mipmap.icon_local;
            } else if ("1".equals(string2)) {
                holder.N(R.id.bt_appeal, false);
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.f1138e, 2131099737));
                i6 = R.drawable.round_blue;
            } else {
                holder.N(R.id.bt_appeal, true);
                holder.J(R.id.bt_appeal, "我要申诉");
                holder.n(R.id.bt_appeal, JsonParse.getBoolean(stringObjectMap, "enable"));
                holder.J(R.id.bt_appeal, JsonParse.getString(stringObjectMap, "va"));
                holder.w(R.id.bt_appeal, new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunRecorderListActivity.a.this.x(stringObjectMap, view);
                    }
                });
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.f1138e, 2131099737));
                i6 = R.drawable.red_round;
            }
            holder.l(R.id.status, i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements n2.e {
        b() {
        }

        @Override // n2.d
        public void a(m2.h refreshlayout) {
            RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
            runRecorderListActivity.H0 = 1;
            runRecorderListActivity.F0(false);
        }

        @Override // n2.b
        public void f(m2.h refreshlayout) {
            RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
            int i6 = runRecorderListActivity.I0;
            int i7 = runRecorderListActivity.G0;
            int i8 = i6 / i7;
            int i9 = runRecorderListActivity.H0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                runRecorderListActivity.W.Q();
                Toast.makeText(((BaseActivity) RunRecorderListActivity.this).T, "没有了", 0).show();
            } else {
                runRecorderListActivity.H0 = i9 + 1;
                runRecorderListActivity.F0(false);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "isShowMorningRun") == 1 && RunRecorderListActivity.this.K0 == null) {
                RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
                runRecorderListActivity.K0 = runRecorderListActivity.f19977p0.newTab().setTag(1).setText(RunRecorderListActivity.this.getString(R.string.morning_run));
                RunRecorderListActivity.this.f19977p0.addTab(RunRecorderListActivity.this.K0);
                RunRecorderListActivity.this.f19977p0.setVisibility(0);
            }
            if (JsonParse.getInt(data, "isShowSunRun") == 1 && RunRecorderListActivity.this.L0 == null) {
                RunRecorderListActivity runRecorderListActivity2 = RunRecorderListActivity.this;
                runRecorderListActivity2.L0 = runRecorderListActivity2.f19977p0.newTab().setTag(2).setText(RunRecorderListActivity.this.getString(R.string.sunshine_run));
                RunRecorderListActivity.this.f19977p0.addTab(RunRecorderListActivity.this.L0);
                RunRecorderListActivity.this.f19977p0.setVisibility(0);
            }
            if (JsonParse.getInt(data, "isShowFreedom") == 1 && RunRecorderListActivity.this.M0 == null) {
                RunRecorderListActivity runRecorderListActivity3 = RunRecorderListActivity.this;
                runRecorderListActivity3.M0 = runRecorderListActivity3.f19977p0.newTab().setTag(3).setText(RunRecorderListActivity.this.getString(R.string.free_run));
                RunRecorderListActivity.this.f19977p0.addTab(RunRecorderListActivity.this.M0);
                RunRecorderListActivity.this.f19977p0.setVisibility(0);
            }
            for (int i6 = 0; i6 < RunRecorderListActivity.this.f19977p0.getTabCount(); i6++) {
                if (Integer.parseInt(RunRecorderListActivity.this.f19977p0.getTabAt(i6).getTag().toString()) == RunRecorderListActivity.this.J0) {
                    RunRecorderListActivity.this.f19977p0.getTabAt(i6).select();
                }
            }
            RunRecorderListActivity.this.f19977p0.addOnTabSelectedListener(RunRecorderListActivity.this.N0);
            RunRecorderListActivity.this.f19976k0.setVisibility(0);
            RunRecorderListActivity.this.I0 = Integer.parseInt(u.O(data, "total"));
            RunRecorderListActivity.this.f19973a0.setText(JsonParse.getString(data, "count"));
            RunRecorderListActivity.this.f19974b0.setText(JsonParse.getString(data, "succeed"));
            RunRecorderListActivity.this.f19975c0.setText(JsonParse.getString(data, "noSucceed"));
            RunRecorderListActivity.this.f19973a0.setText(String.valueOf(JsonParse.getInt(data, "total")));
            List list = (List) data.get("data");
            RunRecorderListActivity runRecorderListActivity4 = RunRecorderListActivity.this;
            if (runRecorderListActivity4.H0 == 1) {
                runRecorderListActivity4.F0 = list;
                RunRecorderListActivity.this.G0();
            } else {
                runRecorderListActivity4.F0.addAll(list);
            }
            RunRecorderListActivity.this.Y.g(RunRecorderListActivity.this.F0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            RunRecorderListActivity.this.W.B(0);
            RunRecorderListActivity.this.W.S(0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements Function1<List<RunDb>, n1> {
        d() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n1 invoke(List<RunDb> runDbs) {
            if (runDbs == null || runDbs.size() <= 0) {
                return null;
            }
            for (RunDb runDb : runDbs) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", runDb.getIdentify());
                hashMap.put("sportStatus", "-1");
                hashMap.put(AnalyticsConfig.RTD_START_TIME, RunRecorderListActivity.this.O0.format(Long.valueOf(Long.parseLong(runDb.getStartTime()))));
                hashMap.put("sportRange", com.bxkj.student.run.app.utils.i.d(Double.parseDouble(runDb.getDistance())) + "KM");
                hashMap.put("sportTime", com.bxkj.student.run.app.utils.i.g(Long.parseLong(runDb.getCountTime())));
                hashMap.put("stepNumbers", runDb.getStepList());
                hashMap.put("remark", "该条跑步记录在本地暂存,请尽快上传");
                if (RunRecorderListActivity.this.F0 == null) {
                    RunRecorderListActivity.this.F0 = new ArrayList();
                }
                RunRecorderListActivity.this.F0.add(0, hashMap);
                RunRecorderListActivity.this.Y.g(RunRecorderListActivity.this.F0);
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements TabLayout.OnTabSelectedListener {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            RunRecorderListActivity.this.J0 = Integer.parseInt(tab.getTag().toString());
            RunRecorderListActivity.this.f19976k0.setVisibility(8);
            if (RunRecorderListActivity.this.F0 != null) {
                RunRecorderListActivity.this.F0.clear();
            }
            RunRecorderListActivity.this.Y.notifyItemRangeRemoved(0, RunRecorderListActivity.this.Y.getItemCount());
            RunRecorderListActivity.this.Y.g(RunRecorderListActivity.this.F0);
            RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
            runRecorderListActivity.H0 = 1;
            runRecorderListActivity.F0(true);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static String E0(long recordingTime) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j6 = recordingTime / 3600;
        if (j6 > 9) {
            sb = new StringBuilder();
            sb.append(j6);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(j6);
        }
        String sb4 = sb.toString();
        long j7 = recordingTime % 3600;
        long j8 = j7 / 60;
        if (j8 > 9) {
            sb2 = new StringBuilder();
            sb2.append(j8);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(j8);
        }
        String sb5 = sb2.toString();
        long j9 = j7 % 60;
        if (j9 > 9) {
            sb3 = new StringBuilder();
            sb3.append(j9);
            sb3.append("");
        } else {
            sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(j9);
        }
        return sb4 + ":" + sb5 + ":" + sb3.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.P0.y(this.J0, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(ViewGroup viewGroup, View view, Object obj, int i6) {
        if (!"-1".equalsIgnoreCase(JsonParse.getString(this.Y.getItem(i6), "sportStatus"))) {
            startActivity(new Intent(this.T, (Class<?>) RunDetailActivity.class).putExtra("sportRecordId", JsonParse.getString(this.Y.getItem(i6), "id")));
        } else {
            startActivity(new Intent(this.T, (Class<?>) RunDetailActivity.class).putExtra("runDataDbId", JsonParse.getString(this.Y.getItem(i6), "id")));
        }
    }

    public void F0(boolean showLoadingDialog) {
        Http.with(this.T).setShowLoadingDialog(showLoadingDialog).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).g(LoginUser.getLoginUser().getUserId(), this.J0, this.H0, this.G0)).setDataListener(new c());
    }

    public void H0() {
        this.W.D(new b());
    }

    public void J0() {
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.N0 = new e();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.P0 = (RunVM) new ViewModelProvider(this).get(RunVM.class);
        if (getIntent().hasExtra("runType")) {
            this.J0 = getIntent().getIntExtra("runType", 2);
        }
        this.O0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_run_recorder_list, this.F0);
        this.Y = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(this.Z);
        this.Y.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.run.app.record.k
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                RunRecorderListActivity.this.I0(viewGroup, view, obj, i6);
            }
        });
        H0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("跑步记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_run_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.f19973a0 = (TextView) findViewById(2131298848);
        this.f19974b0 = (TextView) findViewById(R.id.tv_yes);
        this.f19975c0 = (TextView) findViewById(2131298991);
        this.f19977p0 = (TabLayout) findViewById(R.id.tl_run_type);
        this.f19976k0 = (CardView) findViewById(2131296688);
        this.Z = (TextView) findViewById(2131298892);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
