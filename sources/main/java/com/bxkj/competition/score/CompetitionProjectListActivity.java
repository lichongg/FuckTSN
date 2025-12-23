package com.bxkj.competition.score;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
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
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.bxkj.competition.score.student.StudentScoreListActivity;
import com.bxkj.competition.score.teacher.AddScoreMenuActivity;
import com.bxkj.competition.score.teacher.FieldScoreListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CompetitionProjectListActivity extends BaseActivity {
    private CommonAdapter<Map<String, Object>> F0;
    private String G0;
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f17304a0;

    /* renamed from: b0, reason: collision with root package name */
    private List<Map<String, Object>> f17305b0 = new ArrayList();

    /* renamed from: c0, reason: collision with root package name */
    private List<Map<String, Object>> f17306c0 = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    private List<Map<String, Object>> f17307k0 = new ArrayList();

    /* renamed from: p0, reason: collision with root package name */
    private List<Map<String, Object>> f17308p0 = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements n2.d {
        a() {
        }

        @Override // n2.d
        public void a(m2.h refreshlayout) {
            CompetitionProjectListActivity.this.E0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "sportItem"));
            holder.J(R.id.tv_group, JsonParse.getString(stringObjectMap, "groupName"));
            holder.J(R.id.tv_progress, JsonParse.getString(stringObjectMap, "gameForm"));
            int i6 = R.id.tv_type;
            StringBuilder sb = new StringBuilder();
            sb.append("分组：");
            sb.append(TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "group")) ? "未分组" : JsonParse.getString(stringObjectMap, "group"));
            holder.J(i6, sb.toString());
            holder.J(R.id.tv_time, JsonParse.getString(stringObjectMap, "sportCompetitionDateName") + JsonParse.getString(stringObjectMap, "competitionTime"));
            holder.J(R.id.tv_type2, JsonParse.getString(stringObjectMap, "type").equals("1") ? "径赛" : "田赛");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f17308p0 = JsonParse.getList(data, "data");
            CompetitionProjectListActivity.this.F0.g(CompetitionProjectListActivity.this.f17308p0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CompetitionProjectListActivity.this.W.Y();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            if (LoginUser.getLoginUser().getUserType() == 2) {
                if (JsonParse.getString((Map) CompetitionProjectListActivity.this.F0.getItem(position), "type").equals("1")) {
                    CompetitionProjectListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionProjectListActivity.this).T, (Class<?>) AddScoreMenuActivity.class).putExtra("scheduleId", JsonParse.getString((Map) CompetitionProjectListActivity.this.F0.getItem(position), "id")));
                    return;
                } else {
                    CompetitionProjectListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionProjectListActivity.this).T, (Class<?>) FieldScoreListActivity.class).putExtra("scheduleId", JsonParse.getString((Map) CompetitionProjectListActivity.this.F0.getItem(position), "id")));
                    return;
                }
            }
            CompetitionProjectListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionProjectListActivity.this).T, (Class<?>) StudentScoreListActivity.class).putExtra("scheduleId", JsonParse.getString((Map) CompetitionProjectListActivity.this.F0.getItem(position), "id")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f17305b0 = JsonParse.getList(data, "data");
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", "-1");
            hashMap.put(CommonNetImpl.NAME, "全部时间");
            CompetitionProjectListActivity.this.f17305b0.add(0, hashMap);
            CompetitionProjectListActivity competitionProjectListActivity = CompetitionProjectListActivity.this;
            competitionProjectListActivity.K0(competitionProjectListActivity.Y, "请选择时间", CompetitionProjectListActivity.this.f17305b0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f17306c0 = JsonParse.getList(data, "data");
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", "-1");
            hashMap.put(CommonNetImpl.NAME, "全部分组");
            CompetitionProjectListActivity.this.f17306c0.add(0, hashMap);
            CompetitionProjectListActivity competitionProjectListActivity = CompetitionProjectListActivity.this;
            competitionProjectListActivity.K0(competitionProjectListActivity.Z, "请选择组别", CompetitionProjectListActivity.this.f17306c0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f17307k0 = JsonParse.getList(data, "data");
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", "-1");
            hashMap.put(CommonNetImpl.NAME, "全部项目");
            CompetitionProjectListActivity.this.f17307k0.add(0, hashMap);
            CompetitionProjectListActivity competitionProjectListActivity = CompetitionProjectListActivity.this;
            competitionProjectListActivity.K0(competitionProjectListActivity.f17304a0, "请选择项目", CompetitionProjectListActivity.this.f17307k0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f17316a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f17317b;

        h(final TextView val$dataList, final List val$tv) {
            this.f17316a = val$dataList;
            this.f17317b = val$tv;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            this.f17316a.setText(u.O((Map) this.f17317b.get(which), CommonNetImpl.NAME));
            this.f17316a.setTag(u.O((Map) this.f17317b.get(which), "id"));
            if (this.f17316a.getId() == CompetitionProjectListActivity.this.Z.getId()) {
                CompetitionProjectListActivity.this.f17304a0.setText("全部项目");
                CompetitionProjectListActivity.this.f17304a0.setTag("-1");
            }
            CompetitionProjectListActivity.this.W.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        Http.with(this.T).hideOtherStatusMessage().hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).v(this.G0, this.Z.getTag().toString().equals("-1") ? null : this.Z.getTag(), this.f17304a0.getTag().toString().equals("-1") ? null : this.f17304a0.getTag(), this.Y.getTag().toString().equals("-1") ? null : this.Y.getTag())).setDataListener(new c());
    }

    private void F0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).x(this.G0)).setDataListener(new e());
    }

    private void G0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).t(this.G0)).setDataListener(new f());
    }

    private void H0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).o(this.Z.getTag().toString())).setDataListener(new g());
    }

    private void I0() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        b bVar = new b(this.T, R.layout.item_for_addscore_project_list, this.f17308p0);
        this.F0 = bVar;
        this.X.setAdapter(bVar);
        this.X.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void J0() {
        this.W.p(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f17304a0.setOnClickListener(this);
        this.F0.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_addscore_project_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("竞赛项目列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.X = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.Y = (TextView) findViewById(R.id.tv_time);
        this.Z = (TextView) findViewById(R.id.tv_group);
        this.f17304a0 = (TextView) findViewById(R.id.tv_project);
    }

    public int h0(float size, Context context) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        return (int) ((size * r0.density) + 0.5d);
    }

    private void D0(Dialog dialog, int color) {
        View findViewById = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (findViewById != null) {
            findViewById.setBackgroundColor(color);
        }
    }

    public void K0(final TextView tv2, final String title, final List<Map<String, Object>> dataList) {
        String[] strArr = new String[dataList.size()];
        for (int i6 = 0; i6 < dataList.size(); i6++) {
            strArr[i6] = u.O(dataList.get(i6), CommonNetImpl.NAME);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.T);
        View inflate = LayoutInflater.from(this.T).inflate(R.layout.dialog_title, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tvTitle)).setText(title);
        builder.setCustomTitle(inflate);
        builder.setItems(strArr, new h(tv2, dataList));
        AlertDialog create = builder.create();
        create.getListView().setDivider(new ColorDrawable(Color.parseColor("#999999")));
        create.getListView().setDividerHeight(h0(0.5f, this.T));
        create.show();
        D0(create, Color.parseColor("#8e8b8b"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("competitionId")) {
            this.G0 = getIntent().getStringExtra("competitionId");
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("id", "-1");
        hashMap.put(CommonNetImpl.NAME, "全部项目");
        this.f17307k0.add(hashMap);
        J0();
        I0();
        this.W.h0(true);
        this.W.v(false);
        this.W.F();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() == this.Y.getId()) {
            List<Map<String, Object>> list = this.f17305b0;
            if (list != null && list.size() != 0) {
                K0(this.Y, "请选择组别", this.f17305b0);
                return;
            } else {
                F0();
                return;
            }
        }
        if (v5.getId() == this.Z.getId()) {
            List<Map<String, Object>> list2 = this.f17306c0;
            if (list2 != null && list2.size() != 0) {
                K0(this.Z, "请选择组别", this.f17306c0);
                return;
            } else {
                G0();
                return;
            }
        }
        if (v5.getId() == this.f17304a0.getId()) {
            if (this.Z.getTag() != null && !this.Z.getTag().toString().equals("-1")) {
                H0();
            } else {
                new iOSOneButtonDialog(this.T).setMessage("请先选择组别").show();
            }
        }
    }
}
