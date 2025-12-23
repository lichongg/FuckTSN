package com.bxkj.student.life.mall;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.a;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class GoodsListFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView f19195j;

    /* renamed from: k, reason: collision with root package name */
    private SmartRefreshLayout f19196k;

    /* renamed from: l, reason: collision with root package name */
    private EmptyRecyclerView f19197l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f19198m;

    /* renamed from: n, reason: collision with root package name */
    private FloatingActionButton f19199n;

    /* renamed from: o, reason: collision with root package name */
    private FrameLayout f19200o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f19201p;

    /* renamed from: s, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19204s;

    /* renamed from: u, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19206u;

    /* renamed from: q, reason: collision with root package name */
    private List<Map<String, Object>> f19202q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    private List<Map<String, Object>> f19203r = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    private int f19205t = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f19207v = 1;

    /* renamed from: w, reason: collision with root package name */
    private int f19208w = 15;

    /* renamed from: x, reason: collision with root package name */
    private int f19209x = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i6 = JsonParse.getInt(data, "data");
            if (i6 > 0) {
                GoodsListFragment.this.f19201p.setVisibility(0);
            } else {
                GoodsListFragment.this.f19201p.setVisibility(8);
            }
            GoodsListFragment.this.f19201p.setText(String.valueOf(i6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.q(R.id.iv, holder.f() == GoodsListFragment.this.f19205t ? GoodsListFragment.this.getResources().getDrawable(2131231950) : null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
            a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(ViewHolder holder, final Map<String, Object> stringObjectMap) {
                holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
                holder.t(2131297182, JsonParse.getString(stringObjectMap, "showImg"), 2131689689, 2131689689);
                holder.J(2131299047, "￥" + JsonParse.getMoney(stringObjectMap, "showPrize"));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ cn.bluemobi.dylan.base.adapter.common.abslistview.a f19214a;

            b(final cn.bluemobi.dylan.base.adapter.common.abslistview.a val$adapter) {
                this.f19214a = val$adapter;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GoodsListFragment.this.startActivity(new Intent(((CommonAdapter) c.this).f1138e, (Class<?>) GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) this.f19214a.getItem(position), "id")));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$c$c, reason: collision with other inner class name */
        class ViewOnClickListenerC0246c implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19216a;

            ViewOnClickListenerC0246c(final Map val$stringObjectMap) {
                this.f19216a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                GoodsListFragment.this.startActivity(new Intent(((CommonAdapter) c.this).f1138e, (Class<?>) SearchGoodsActivity.class).putExtra("typeId", JsonParse.getString(this.f19216a, "id")).putExtra("typeName", JsonParse.getString(this.f19216a, "typeName")));
            }
        }

        c(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_classify_name, JsonParse.getString(stringObjectMap, "typeName"));
            List<Map<String, Object>> list = JsonParse.getList(stringObjectMap, "goods");
            GridView gridView = (GridView) holder.h(R.id.gv_goods);
            a aVar = new a(this.f1138e, R.layout.item_for_mall_home_goods, list);
            gridView.setAdapter((ListAdapter) aVar);
            gridView.setOnItemClickListener(new b(aVar));
            holder.w(R.id.ll_classify2, new ViewOnClickListenerC0246c(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements n2.e {
        d() {
        }

        @Override // n2.d
        public void a(m2.h refreshlayout) {
            GoodsListFragment.this.f19207v = 1;
            if (GoodsListFragment.this.f19204s.getItemCount() == 0) {
                GoodsListFragment.this.h0();
            } else {
                GoodsListFragment.this.g0();
            }
        }

        @Override // n2.b
        public void f(m2.h refreshlayout) {
            int i6 = GoodsListFragment.this.f19209x / GoodsListFragment.this.f19208w;
            int i7 = GoodsListFragment.this.f19207v;
            if (GoodsListFragment.this.f19209x % GoodsListFragment.this.f19208w != 0) {
                i6++;
            }
            if (i7 >= i6) {
                GoodsListFragment.this.f19196k.Q();
                GoodsListFragment.this.n("没有了");
            } else {
                GoodsListFragment.this.f19207v++;
                GoodsListFragment.this.g0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            GoodsListFragment.this.f19204s.notifyItemChanged(GoodsListFragment.this.f19205t);
            GoodsListFragment.this.f19205t = position;
            GoodsListFragment.this.f19204s.notifyItemChanged(GoodsListFragment.this.f19205t);
            GoodsListFragment.this.f19196k.F();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            GoodsListFragment.this.startActivity(new Intent(((BaseFragment) GoodsListFragment.this).f1096g, (Class<?>) CartActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements View.OnClickListener {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements a.g {
            a() {
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                GoodsListFragment.this.startActivity(new Intent(((BaseFragment) GoodsListFragment.this).f1096g, (Class<?>) CartActivity.class));
            }
        }

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            new com.bxkj.base.auth.a(((BaseFragment) GoodsListFragment.this).f1096g).i(new a()).b(GoodsListFragment.this.getChildFragmentManager(), 0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        h() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i extends HttpCallBack {
        i() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            GoodsListFragment.this.f19203r.clear();
            GoodsListFragment.this.f19203r.addAll(JsonParse.getList(data, "data"));
            GoodsListFragment.this.f19204s.notifyItemRangeInserted(0, GoodsListFragment.this.f19203r.size());
            GoodsListFragment.this.f19196k.F();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (GoodsListFragment.this.f19196k != null && GoodsListFragment.this.f19196k.x()) {
                GoodsListFragment.this.f19196k.Y();
            }
            if (GoodsListFragment.this.f19196k != null && GoodsListFragment.this.f19196k.isLoading()) {
                GoodsListFragment.this.f19196k.Q();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j extends HttpCallBack {
        j() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            GoodsListFragment.this.f19209x = JsonParse.getInt(data, "total");
            if (GoodsListFragment.this.f19207v == 1) {
                GoodsListFragment.this.f19202q.clear();
            }
            GoodsListFragment.this.f19202q.addAll(JsonParse.getList(data, "data"));
            GoodsListFragment.this.f19206u.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (GoodsListFragment.this.f19196k != null && GoodsListFragment.this.f19196k.x()) {
                GoodsListFragment.this.f19196k.Y();
            }
            if (GoodsListFragment.this.f19196k != null && GoodsListFragment.this.f19196k.isLoading()) {
                GoodsListFragment.this.f19196k.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        CommonAdapter<Map<String, Object>> commonAdapter = this.f19204s;
        if (commonAdapter != null) {
            int itemCount = commonAdapter.getItemCount();
            int i6 = this.f19205t;
            if (itemCount <= i6) {
                return;
            }
            Http.with(this.f1096g).hideLoadingDialog().setObservable(((x.g) Http.getApiService(x.g.class)).a(JsonParse.getString(this.f19204s.getItem(i6), "id"), this.f19207v, this.f19208w)).setDataListener(new j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        Http.with(this.f1096g).setObservable(((x.g) Http.getApiService(x.g.class)).q()).setDataListener(new i());
    }

    private void i0() {
        this.f19196k.D(new d());
    }

    private void j0() {
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1096g, 2130772096));
        layoutAnimationController.setOrder(0);
        this.f19197l.setLayoutAnimation(layoutAnimationController);
        this.f19206u = new c(this.f1096g, R.layout.item_for_goods_classify2, this.f19202q);
        this.f19197l.setLayoutManager(new LinearLayoutManager(this.f1096g));
        this.f19197l.setAdapter(this.f19206u);
        this.f19197l.setEmptyView(this.f19198m);
    }

    private void k0() {
        this.f19195j.setLayoutManager(new LinearLayoutManager(this.f1096g));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1096g, 2130772096));
        layoutAnimationController.setOrder(0);
        this.f19195j.setLayoutAnimation(layoutAnimationController);
        this.f19195j.addItemDecoration(new DividerItemDecoration(this.f1096g, 1));
        b bVar = new b(this.f1096g, R.layout.item_for_video_type_list, this.f19203r);
        this.f19204s = bVar;
        this.f19195j.setAdapter(bVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f19204s.k(new e());
        this.f19199n.setOnClickListener(new f());
        this.f19200o.setOnClickListener(new g());
        this.f19206u.k(new h());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        k0();
        j0();
        h0();
        i0();
        f0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19195j = (RecyclerView) c(R.id.rv_type);
        this.f19196k = (SmartRefreshLayout) c(2131298353);
        this.f19197l = (EmptyRecyclerView) c(R.id.rv_goods_list);
        this.f19198m = (TextView) c(2131298892);
        this.f19199n = (FloatingActionButton) c(R.id.fab);
        this.f19200o = (FrameLayout) c(R.id.fl_cart);
        this.f19201p = (TextView) c(2131298848);
    }

    public void f0() {
        if (LoginUser.getLoginUser().isLogin() && LoginUser.getLoginUser().isAuthorizationInMall()) {
            Http.with(this.f1096g).hideLoadingDialog().hideSuccessMessage().hideFailMessage().hideOtherStatusMessage().setObservable(((x.g) Http.getApiService(x.g.class)).n(LoginUser.getLoginUser().getOpenId())).setDataListener(new a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_goods_list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
