package com.bxkj.student.life.mall.collect;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.life.mall.GoodsDetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CollectGoodsFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private SearchView f19284j;

    /* renamed from: k, reason: collision with root package name */
    private SmartRefreshLayout f19285k;

    /* renamed from: l, reason: collision with root package name */
    private EmptyRecyclerView f19286l;

    /* renamed from: m, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19287m;

    /* renamed from: o, reason: collision with root package name */
    private String f19289o;

    /* renamed from: s, reason: collision with root package name */
    private String f19293s;

    /* renamed from: n, reason: collision with root package name */
    private List<Map<String, Object>> f19288n = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    private int f19290p = 1;

    /* renamed from: q, reason: collision with root package name */
    private int f19291q = 15;

    /* renamed from: r, reason: collision with root package name */
    private int f19292r = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0251a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19295a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewHolder f19296b;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$a$a, reason: collision with other inner class name */
            class C0252a implements iOSTwoButtonDialog.RightButtonOnClick {

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$a$a$a, reason: collision with other inner class name */
                class C0253a extends HttpCallBack {
                    C0253a() {
                    }

                    @Override // cn.bluemobi.dylan.http.HttpResponse
                    public void netOnSuccess(Map<String, Object> data) {
                        CollectGoodsFragment.this.f19288n.remove(ViewOnClickListenerC0251a.this.f19295a);
                        CollectGoodsFragment.this.f19287m.notifyItemRemoved(ViewOnClickListenerC0251a.this.f19296b.f());
                    }
                }

                C0252a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    Http.with(((CommonAdapter) a.this).f1138e).setObservable(((g) Http.getApiService(g.class)).i(JsonParse.getString(ViewOnClickListenerC0251a.this.f19295a, "commId"), LoginUser.getLoginUser().getOpenId())).setDataListener(new C0253a());
                }
            }

            ViewOnClickListenerC0251a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f19295a = val$stringObjectMap;
                this.f19296b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                new iOSTwoButtonDialog(((CommonAdapter) a.this).f1138e).setMessage("确定要删除吗？").setRightButtonOnClickListener(new C0252a()).show();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19300a;

            b(final Map val$stringObjectMap) {
                this.f19300a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                CollectGoodsFragment.this.startActivity(new Intent(((CommonAdapter) a.this).f1138e, (Class<?>) GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString(this.f19300a, "commId")));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.t(2131297182, JsonParse.getString(stringObjectMap, "showImg"), 2131689689, 2131689689);
            holder.J(2131299047, "￥" + JsonParse.getString(stringObjectMap, "showPrize"));
            holder.w(R.id.bt_delete, new ViewOnClickListenerC0251a(stringObjectMap, holder));
            holder.w(2131298030, new b(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements SearchView.OnQueryTextListener {
        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String newText) {
            return false;
        }

        b() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String query) {
            CollectGoodsFragment.this.f19293s = query;
            CollectGoodsFragment.this.f19285k.F();
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        c() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            CollectGoodsFragment.this.startActivity(new Intent(((BaseFragment) CollectGoodsFragment.this).f1096g, (Class<?>) GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) CollectGoodsFragment.this.f19287m.getItem(position), "commId")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements n2.e {
        d() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            CollectGoodsFragment.this.f19290p = 1;
            CollectGoodsFragment.this.a0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = CollectGoodsFragment.this.f19292r / CollectGoodsFragment.this.f19291q;
            int i7 = CollectGoodsFragment.this.f19290p;
            if (CollectGoodsFragment.this.f19292r % CollectGoodsFragment.this.f19291q != 0) {
                i6++;
            }
            if (i7 >= i6) {
                CollectGoodsFragment.this.f19285k.Q();
                CollectGoodsFragment.this.n("没有了");
            } else {
                CollectGoodsFragment.this.f19290p++;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CollectGoodsFragment.this.f19292r = JsonParse.getInt(data, "total");
            if (CollectGoodsFragment.this.f19290p == 1) {
                CollectGoodsFragment.this.f19288n.clear();
            }
            CollectGoodsFragment.this.f19288n.addAll(JsonParse.getList(data, "data"));
            CollectGoodsFragment.this.f19287m.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (CollectGoodsFragment.this.f19285k != null && CollectGoodsFragment.this.f19285k.x()) {
                CollectGoodsFragment.this.f19285k.Y();
            }
            if (CollectGoodsFragment.this.f19285k != null && CollectGoodsFragment.this.f19285k.isLoading()) {
                CollectGoodsFragment.this.f19285k.Q();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements iOSTwoButtonDialog.RightButtonOnClick {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                CollectGoodsFragment.this.f19287m.notifyItemRangeRemoved(0, CollectGoodsFragment.this.f19288n.size());
                CollectGoodsFragment.this.f19288n.clear();
            }
        }

        f() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(((BaseFragment) CollectGoodsFragment.this).f1096g).setObservable(((g) Http.getApiService(g.class)).C(LoginUser.getLoginUser().getOpenId())).setDataListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        Http.with(this.f1096g).hideLoadingDialog().setObservable(((g) Http.getApiService(g.class)).o(this.f19293s, LoginUser.getLoginUser().getOpenId(), this.f19290p, this.f19291q)).setDataListener(new e());
    }

    private void b0() {
        this.f19285k.D(new d());
    }

    public void Z() {
        new iOSTwoButtonDialog(this.f1096g).setMessage("确定要清空所有商品吗？").setRightButtonOnClickListener(new f()).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f19284j.setOnQueryTextListener(new b());
        this.f19287m.k(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        this.f19286l.setLayoutManager(new LinearLayoutManager(this.f1096g));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1096g, 2130772096));
        layoutAnimationController.setOrder(0);
        this.f19286l.setLayoutAnimation(layoutAnimationController);
        this.f19286l.addItemDecoration(new DividerItemDecoration(this.f1096g, 1));
        a aVar = new a(this.f1096g, R.layout.item_for_collect_goods_list, this.f19288n);
        this.f19287m = aVar;
        this.f19286l.setAdapter(aVar);
        this.f19286l.setEmptyView(c(2131298892));
        this.f19285k.F();
        b0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19285k = (SmartRefreshLayout) c(2131298353);
        this.f19286l = (EmptyRecyclerView) c(R.id.rv_goods_list);
        this.f19284j = (SearchView) c(R.id.search);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.ac_search_goods;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
