package com.bxkj.student.personal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class HelpCenterListActivity extends BaseActivity {
    private RecyclerView W;
    private SmartRefreshLayout X;
    private List<Map<String, Object>> Y;
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    protected int f19545a0 = 10;

    /* renamed from: b0, reason: collision with root package name */
    protected int f19546b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    protected int f19547c0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.N(R.id.iv_not_read, false);
            holder.N(R.id.tv_label, false);
            holder.J(2131299164, (holder.f() + 1) + "、" + u.O(stringObjectMap, "helpTitle"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            Intent intent = new Intent(((BaseActivity) HelpCenterListActivity.this).T, (Class<?>) H5DetailActivity.class);
            intent.putExtra("title", u.O((Map) HelpCenterListActivity.this.Z.getItem(position), "helpTitle"));
            intent.putExtra("content", u.O((Map) HelpCenterListActivity.this.Z.getItem(position), "helpContent"));
            HelpCenterListActivity.this.startActivity(intent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements e {
        c() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            HelpCenterListActivity helpCenterListActivity = HelpCenterListActivity.this;
            helpCenterListActivity.f19546b0 = 1;
            helpCenterListActivity.n0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            HelpCenterListActivity helpCenterListActivity = HelpCenterListActivity.this;
            int i6 = helpCenterListActivity.f19547c0;
            int i7 = helpCenterListActivity.f19545a0;
            int i8 = i6 / i7;
            int i9 = helpCenterListActivity.f19546b0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                helpCenterListActivity.X.Q();
                Toast.makeText(((BaseActivity) HelpCenterListActivity.this).T, "没有了", 0).show();
            } else {
                helpCenterListActivity.f19546b0 = i9 + 1;
                helpCenterListActivity.n0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HelpCenterListActivity.this.f19547c0 = Integer.parseInt(u.O(data, "total"));
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            HelpCenterListActivity helpCenterListActivity = HelpCenterListActivity.this;
            if (helpCenterListActivity.f19546b0 == 1) {
                helpCenterListActivity.Y = list;
            } else {
                helpCenterListActivity.Y.addAll(list);
            }
            HelpCenterListActivity.this.Z.g(HelpCenterListActivity.this.Y);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            HelpCenterListActivity.this.X.Y();
            HelpCenterListActivity.this.X.Q();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.W.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_notice, this.Y);
        this.Z = aVar;
        this.W.setAdapter(aVar);
        o0();
        this.X.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("帮助中心");
    }

    public void n0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).S(2, this.f19546b0, this.f19545a0)).setDataListener(new d());
    }

    public void o0() {
        this.X.D(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131492999;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (RecyclerView) findViewById(2131298351);
        this.X = (SmartRefreshLayout) findViewById(2131298352);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
