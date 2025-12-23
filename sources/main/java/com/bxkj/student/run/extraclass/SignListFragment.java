package com.bxkj.student.run.extraclass;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
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
public class SignListFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private EmptyRecyclerView f20412j;

    /* renamed from: l, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20414l;

    /* renamed from: m, reason: collision with root package name */
    private SmartRefreshLayout f20415m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f20416n;

    /* renamed from: s, reason: collision with root package name */
    private String f20421s;

    /* renamed from: k, reason: collision with root package name */
    private List<Map<String, Object>> f20413k = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    private String f20417o = "all";

    /* renamed from: p, reason: collision with root package name */
    private int f20418p = 1;

    /* renamed from: q, reason: collision with root package name */
    private int f20419q = 15;

    /* renamed from: r, reason: collision with root package name */
    private int f20420r = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298991, String.valueOf(holder.f() + 1));
            holder.N(2131297100, false);
            if ("all".equals(SignListFragment.this.f20417o)) {
                holder.J(2131298881, JsonParse.getString(stringObjectMap, "punchDay"));
                holder.J(R.id.tv_time_count, JsonParse.getString(stringObjectMap, "punchTime"));
                holder.J(2131299113, JsonParse.getString(stringObjectMap, "type"));
                holder.J(R.id.tv_end_time, JsonParse.getString(stringObjectMap, NotificationCompat.CATEGORY_STATUS));
                holder.K(R.id.tv_end_time, ContextCompat.getColor(this.f1138e, 2131099739));
                return;
            }
            holder.J(2131298881, JsonParse.getString(stringObjectMap, "punchOnTime"));
            holder.J(R.id.tv_time_count, JsonParse.getString(stringObjectMap, "punchOffTime"));
            holder.J(2131299113, JsonParse.getString(stringObjectMap, "punchDay"));
            holder.J(R.id.tv_end_time, JsonParse.getString(stringObjectMap, "timeLength"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements e {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            SignListFragment.this.f20418p = 1;
            SignListFragment.this.Y();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = SignListFragment.this.f20420r / SignListFragment.this.f20419q;
            int i7 = SignListFragment.this.f20418p;
            if (SignListFragment.this.f20420r % SignListFragment.this.f20419q != 0) {
                i6++;
            }
            if (i7 >= i6) {
                SignListFragment.this.f20415m.Q();
                SignListFragment.this.n("没有了");
            } else {
                SignListFragment.this.f20418p++;
                SignListFragment.this.Y();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseFragment) SignListFragment.this).f1096g).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignListFragment.this.f20420r = JsonParse.getInt(data, "total");
            if (SignListFragment.this.f20418p == 1) {
                SignListFragment.this.f20413k.clear();
            }
            SignListFragment.this.f20413k.addAll(JsonParse.getList(data, "data"));
            SignListFragment.this.f20414l.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (SignListFragment.this.f20415m != null && SignListFragment.this.f20415m.x()) {
                SignListFragment.this.f20415m.Y();
            }
            if (SignListFragment.this.f20415m != null && SignListFragment.this.f20415m.isLoading()) {
                SignListFragment.this.f20415m.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        Http.with(this.f1096g).setObservable("all".equals(this.f20417o) ? ((e0.a) Http.getApiService(e0.a.class)).k(LoginUser.getLoginUser().getUserId(), this.f20421s, this.f20418p, this.f20419q) : ((e0.a) Http.getApiService(e0.a.class)).s0(LoginUser.getLoginUser().getUserId(), this.f20421s, this.f20418p, this.f20419q)).hideLoadingDialog().hideOtherStatusMessage().setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        if (getArguments() != null) {
            if (getArguments().containsKey("type")) {
                this.f20417o = getArguments().getString("type");
            }
            if (getArguments().containsKey("termId")) {
                this.f20421s = getArguments().getString("termId");
            }
        }
        this.f20412j.setLayoutManager(new LinearLayoutManager(this.f1096g));
        a aVar = new a(this.f1096g, R.layout.item_for_cg_sign_recorder_list, this.f20413k);
        this.f20414l = aVar;
        this.f20412j.setAdapter(aVar);
        this.f20416n.setText("暂无打卡数据，赶快去打卡吧！");
        this.f20412j.setEmptyView(this.f20416n);
        this.f20415m.D(new b());
        this.f20415m.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f20412j = (EmptyRecyclerView) c(2131298351);
        this.f20415m = (SmartRefreshLayout) c(2131298352);
        this.f20416n = (TextView) c(2131298892);
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
