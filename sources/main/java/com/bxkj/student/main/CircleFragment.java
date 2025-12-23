package com.bxkj.student.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.circle.CircleDetailActivity;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CircleFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private SmartRefreshLayout f19440j;

    /* renamed from: k, reason: collision with root package name */
    private EmptyRecyclerView f19441k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f19442l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f19443m;

    /* renamed from: n, reason: collision with root package name */
    private TabLayout f19444n;

    /* renamed from: o, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19445o;

    /* renamed from: p, reason: collision with root package name */
    private List<Map<String, Object>> f19446p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private int f19447q = 10;

    /* renamed from: r, reason: collision with root package name */
    private int f19448r = 1;

    /* renamed from: s, reason: collision with root package name */
    private int f19449s = 0;

    /* renamed from: t, reason: collision with root package name */
    private String f19450t;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, "姓名：" + JsonParse.getString(stringObjectMap, "sysStudentName"));
            holder.J(R.id.tv_lesson, "课程：" + JsonParse.getString(stringObjectMap, "teacherCurriculumName"));
            holder.J(R.id.tv_teacher, "教师：" + JsonParse.getString(stringObjectMap, "sysTeacherName"));
            holder.J(2131298996, "票数：" + JsonParse.getString(stringObjectMap, "votesTotalNumber"));
            holder.J(2131299062, "排名：" + JsonParse.getString(stringObjectMap, "rank"));
            holder.t(2131297148, JsonParse.getString(stringObjectMap, "sysStudentImage"), 2131689689, 2131689689);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements TabLayout.OnTabSelectedListener {
            a() {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                CircleFragment.this.f19448r = 1;
                CircleFragment.this.f19450t = tab.getText().toString();
                CircleFragment.this.c0();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CircleFragment.this.f19444n.setVisibility(0);
            CircleFragment.this.f19444n.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
            List list = JsonParse.getList(data, "data", String.class);
            CircleFragment.this.f19444n.removeAllTabs();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CircleFragment.this.f19444n.addTab(CircleFragment.this.f19444n.newTab().setText((String) it.next()));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements n2.e {
        c() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            CircleFragment.this.f19448r = 1;
            CircleFragment.this.c0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = CircleFragment.this.f19449s / CircleFragment.this.f19447q;
            int i7 = CircleFragment.this.f19448r;
            if (CircleFragment.this.f19449s % CircleFragment.this.f19447q != 0) {
                i6++;
            }
            if (i7 >= i6) {
                CircleFragment.this.f19440j.Q();
                Toast.makeText(((BaseFragment) CircleFragment.this).f1096g, "没有了", 0).show();
            } else {
                CircleFragment.this.f19448r++;
                CircleFragment.this.c0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            if (TextUtils.isEmpty(msg) || "null".equalsIgnoreCase(msg)) {
                CircleFragment.this.f19443m.setVisibility(8);
            } else {
                CircleFragment.this.f19443m.setText(msg);
            }
        }

        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (CircleFragment.this.f19440j != null && CircleFragment.this.f19440j.x()) {
                CircleFragment.this.f19440j.Y();
            }
            if (CircleFragment.this.f19440j != null && CircleFragment.this.f19440j.isLoading()) {
                CircleFragment.this.f19440j.Q();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CircleFragment.this.f19449s = JsonParse.getInt(data, "total");
            if (CircleFragment.this.f19449s > 0) {
                CircleFragment.this.f19443m.setVisibility(0);
            }
            if (CircleFragment.this.f19448r == 1) {
                CircleFragment.this.f19446p.clear();
            }
            CircleFragment.this.f19446p.addAll(JsonParse.getList(data, "data"));
            CircleFragment.this.f19445o.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(ViewGroup viewGroup, View view, Object obj, int i6) {
        startActivity(new Intent(this.f1096g, (Class<?>) CircleDetailActivity.class).putExtra("learnSelectionWorkId", JsonParse.getString(this.f19445o.getItem(i6), "id")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void g0(boolean isLogin) {
        if (!isLogin) {
            this.f19443m.setVisibility(8);
            this.f19446p.clear();
            this.f19445o.notifyDataSetChanged();
        } else if ("79".equalsIgnoreCase(LoginUser.getLoginUser().getSchoolId()) || "130".equalsIgnoreCase(LoginUser.getLoginUser().getSchoolId())) {
            Http.with(this.f1096g).setObservable(((e0.a) Http.getApiService(e0.a.class)).x0()).setDataListener(new b());
        } else {
            this.f19444n.setVisibility(8);
            this.f19440j.F();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f19445o.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.main.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                CircleFragment.this.f0(viewGroup, view, obj, i6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        this.f19441k.setLayoutManager(new LinearLayoutManager(this.f1096g));
        a aVar = new a(this.f1096g, R.layout.item_for_circle, this.f19446p);
        this.f19445o = aVar;
        this.f19441k.setAdapter(aVar);
        this.f19441k.setEmptyView(this.f19442l);
        e0();
        d0();
        g0(LoginUser.getLoginUser().isLogin());
    }

    public void e0() {
        this.f19440j.D(new c());
    }

    public void i0() {
        this.f19440j.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (!LoginUser.getLoginUser().isLogin()) {
            SmartRefreshLayout smartRefreshLayout = this.f19440j;
            if (smartRefreshLayout != null && smartRefreshLayout.x()) {
                this.f19440j.Y();
            }
            SmartRefreshLayout smartRefreshLayout2 = this.f19440j;
            if (smartRefreshLayout2 != null && smartRefreshLayout2.isLoading()) {
                this.f19440j.Q();
                return;
            }
            return;
        }
        Http.with(this.f1096g).hideLoadingDialog().hideSuccessMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).r1(this.f19448r, this.f19447q, this.f19450t)).setDataListener(new d());
    }

    private void d0() {
        LoginUser.getLoginUser().addLoginListener(new LoginUser.LoginListener() { // from class: com.bxkj.student.main.b
            @Override // com.bxkj.base.user.LoginUser.LoginListener
            public final void loginStatusChange(boolean z5) {
                CircleFragment.this.g0(z5);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19440j = (SmartRefreshLayout) c(2131298352);
        this.f19441k = (EmptyRecyclerView) c(2131298351);
        this.f19442l = (TextView) c(2131298892);
        this.f19443m = (TextView) c(2131298879);
        this.f19444n = (TabLayout) c(R.id.tb_type);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_circle;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
