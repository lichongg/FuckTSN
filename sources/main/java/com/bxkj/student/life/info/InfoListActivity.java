package com.bxkj.student.life.info;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class InfoListActivity extends BaseActivity {
    private MultiItemCommonAdapter<Map<String, Object>> F0;
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private TabLayout Z;

    /* renamed from: p0, reason: collision with root package name */
    private List<Map<String, Object>> f19050p0;

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f19046a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private int f19047b0 = 10;

    /* renamed from: c0, reason: collision with root package name */
    private int f19048c0 = 1;

    /* renamed from: k0, reason: collision with root package name */
    private int f19049k0 = 0;
    private boolean G0 = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            InfoListActivity.this.f19048c0 = 1;
            if (InfoListActivity.this.G0) {
                InfoListActivity.this.v0();
            } else {
                InfoListActivity.this.w0();
            }
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = InfoListActivity.this.f19049k0 / InfoListActivity.this.f19047b0;
            int i7 = InfoListActivity.this.f19048c0;
            if (InfoListActivity.this.f19049k0 % InfoListActivity.this.f19047b0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                InfoListActivity.this.W.Q();
                InfoListActivity.this.g0("没有了");
                return;
            }
            InfoListActivity.this.f19048c0++;
            if (InfoListActivity.this.G0) {
                InfoListActivity.this.v0();
            } else {
                InfoListActivity.this.w0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements TabLayout.OnTabSelectedListener {
        b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            InfoListActivity.this.G0 = true;
            InfoListActivity.this.W.F();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InfoListActivity.this.f19050p0 = JsonParse.getList(data, "typeList");
            InfoListActivity.this.y0();
            InfoListActivity.this.f19049k0 = JsonParse.getInt(data, "total");
            if (InfoListActivity.this.f19048c0 == 1) {
                InfoListActivity.this.f19046a0.clear();
            }
            InfoListActivity.this.f19046a0.addAll(JsonParse.getList(data, "inforList"));
            InfoListActivity.this.F0.g(InfoListActivity.this.f19046a0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (InfoListActivity.this.W != null && InfoListActivity.this.W.x()) {
                InfoListActivity.this.W.Y();
            }
            if (InfoListActivity.this.W != null && InfoListActivity.this.W.isLoading()) {
                InfoListActivity.this.W.Q();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InfoListActivity.this.f19049k0 = JsonParse.getInt(data, "total");
            if (InfoListActivity.this.f19048c0 == 1) {
                InfoListActivity.this.f19046a0.clear();
            }
            InfoListActivity.this.f19046a0.addAll(JsonParse.getList(data, "data"));
            InfoListActivity.this.F0.g(InfoListActivity.this.f19046a0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (InfoListActivity.this.W != null && InfoListActivity.this.W.x()) {
                InfoListActivity.this.W.Y();
            }
            if (InfoListActivity.this.W != null && InfoListActivity.this.W.isLoading()) {
                InfoListActivity.this.W.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((x.c) Http.getApiService(x.c.class)).a(Integer.valueOf(this.f19047b0), Integer.valueOf(this.f19048c0), JsonParse.getString(this.f19050p0.get(this.Z.getSelectedTabPosition()), "id"))).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((x.c) Http.getApiService(x.c.class)).d(Integer.valueOf(this.f19047b0), Integer.valueOf(this.f19048c0))).setDataListener(new c());
    }

    private void x0() {
        this.W.D(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.Z.removeAllTabs();
        List<Map<String, Object>> list = this.f19050p0;
        if (list == null) {
            return;
        }
        for (Map<String, Object> map : list) {
            TabLayout tabLayout = this.Z;
            tabLayout.addTab(tabLayout.newTab().setText(JsonParse.getString(map, "inforType")));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        InfoAdapter infoAdapter = new InfoAdapter(this.T, this.f19046a0);
        this.F0 = infoAdapter;
        this.X.setAdapter(infoAdapter);
        this.X.setEmptyView(this.Y);
        x0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_info_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle(getString(R.string.app_info));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298353);
        this.X = (EmptyRecyclerView) findViewById(R.id.rv_goods_list);
        this.Y = (TextView) findViewById(2131298892);
        this.Z = (TabLayout) findViewById(R.id.tb);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
