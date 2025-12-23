package com.bxkj.student.run.punchcard;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RecordListFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private EmptyRecyclerView f20429j;

    /* renamed from: l, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20431l;

    /* renamed from: m, reason: collision with root package name */
    private SmartRefreshLayout f20432m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f20433n;

    /* renamed from: s, reason: collision with root package name */
    private String f20438s;

    /* renamed from: k, reason: collision with root package name */
    private List<Map<String, Object>> f20430k = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    private String f20434o = "all";

    /* renamed from: p, reason: collision with root package name */
    private int f20435p = 1;

    /* renamed from: q, reason: collision with root package name */
    private int f20436q = 15;

    /* renamed from: r, reason: collision with root package name */
    private int f20437r = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298991, String.valueOf(holder.f() + 1));
            if ("all".equals(RecordListFragment.this.f20434o)) {
                holder.J(2131298881, JsonParse.getString(stringObjectMap, "machineName"));
                holder.J(R.id.tv_time_count, JsonParse.getString(stringObjectMap, "state"));
                holder.J(2131299113, JsonParse.getString(stringObjectMap, "weekNum"));
                holder.J(R.id.tv_end_time, JsonParse.getString(stringObjectMap, "punchDay") + "\u3000" + JsonParse.getString(stringObjectMap, "punchTime"));
                holder.K(R.id.tv_time_count, RecordListFragment.this.getResources().getColor(2131099739));
                return;
            }
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.J(R.id.tv_week, JsonParse.getString(stringObjectMap, "weekNum"));
            holder.J(R.id.tv_time_count, JsonParse.getString(stringObjectMap, "machineName"));
            holder.J(2131299113, JsonParse.getString(stringObjectMap, "punchDay"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements e {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            RecordListFragment.this.f20435p = 1;
            RecordListFragment.this.Y();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = RecordListFragment.this.f20437r / RecordListFragment.this.f20436q;
            int i7 = RecordListFragment.this.f20435p;
            if (RecordListFragment.this.f20437r % RecordListFragment.this.f20436q != 0) {
                i6++;
            }
            if (i7 >= i6) {
                RecordListFragment.this.f20432m.Q();
                RecordListFragment.this.n("没有了");
            } else {
                RecordListFragment.this.f20435p++;
                RecordListFragment.this.Y();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseFragment) RecordListFragment.this).f1096g).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RecordListFragment.this.f20437r = JsonParse.getInt(data, "total");
            if (RecordListFragment.this.f20435p == 1) {
                RecordListFragment.this.f20430k.clear();
            }
            RecordListFragment.this.f20430k.addAll(JsonParse.getList(data, "data"));
            RecordListFragment.this.f20431l.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (RecordListFragment.this.f20432m != null && RecordListFragment.this.f20432m.x()) {
                RecordListFragment.this.f20432m.Y();
            }
            if (RecordListFragment.this.f20432m != null && RecordListFragment.this.f20432m.isLoading()) {
                RecordListFragment.this.f20432m.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        Http.with(this.f1096g).setObservable("all".equals(this.f20434o) ? ((e0.a) Http.getApiService(e0.a.class)).s1(LoginUser.getLoginUser().getAccount(), this.f20438s, this.f20435p, this.f20436q) : ((e0.a) Http.getApiService(e0.a.class)).E0(LoginUser.getLoginUser().getAccount(), this.f20438s, this.f20435p, this.f20436q)).hideLoadingDialog().hideOtherStatusMessage().setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        int i6;
        if (getArguments() != null) {
            if (getArguments().containsKey("type")) {
                this.f20434o = getArguments().getString("type");
            }
            if (getArguments().containsKey("termId")) {
                this.f20438s = getArguments().getString("termId");
            }
        }
        if ("all".equals(this.f20434o)) {
            i6 = R.layout.item_for_punchcard_recorder_list;
        } else {
            i6 = R.layout.item_for_effective_recorder_list;
        }
        this.f20429j.setLayoutManager(new LinearLayoutManager(this.f1096g));
        a aVar = new a(this.f1096g, i6, this.f20430k);
        this.f20431l = aVar;
        this.f20429j.setAdapter(aVar);
        this.f20433n.setText("暂无打卡数据，赶快去打卡吧！");
        this.f20429j.setEmptyView(this.f20433n);
        this.f20432m.D(new b());
        this.f20432m.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f20429j = (EmptyRecyclerView) c(2131298351);
        this.f20432m = (SmartRefreshLayout) c(2131298352);
        this.f20433n = (TextView) c(2131298892);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131493640;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
