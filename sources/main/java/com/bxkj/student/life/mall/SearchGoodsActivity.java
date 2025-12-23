package com.bxkj.student.life.mall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SearchGoodsActivity extends BaseActivity {
    private String F0;
    private SearchView W;
    private SmartRefreshLayout X;
    private RecyclerView Y;
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: b0, reason: collision with root package name */
    private String f19234b0;

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f19233a0 = new ArrayList();

    /* renamed from: c0, reason: collision with root package name */
    private int f19235c0 = 1;

    /* renamed from: k0, reason: collision with root package name */
    private int f19236k0 = 15;

    /* renamed from: p0, reason: collision with root package name */
    private int f19237p0 = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchGoodsActivity.this.W.clearFocus();
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
            holder.t(2131297182, JsonParse.getString(stringObjectMap, "showImg"), 2131689689, 2131689689);
            holder.J(2131299047, "￥" + JsonParse.getMoney(stringObjectMap, "showPrize"));
            holder.J(R.id.tv_stock, "库存：" + JsonParse.getString(stringObjectMap, "stock"));
            holder.J(2131298997, "销量：" + JsonParse.getString(stringObjectMap, "saleNum"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements SearchView.OnQueryTextListener {
        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String newText) {
            return false;
        }

        c() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String query) {
            SearchGoodsActivity.this.F0 = query;
            SearchGoodsActivity.this.X.F();
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            SearchGoodsActivity.this.startActivity(new Intent(((BaseActivity) SearchGoodsActivity.this).T, (Class<?>) GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) SearchGoodsActivity.this.Z.getItem(position), "id")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements n2.e {
        e() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            SearchGoodsActivity.this.f19235c0 = 1;
            SearchGoodsActivity.this.t0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = SearchGoodsActivity.this.f19237p0 / SearchGoodsActivity.this.f19236k0;
            int i7 = SearchGoodsActivity.this.f19235c0;
            if (SearchGoodsActivity.this.f19237p0 % SearchGoodsActivity.this.f19236k0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                SearchGoodsActivity.this.X.Q();
                SearchGoodsActivity.this.g0("没有了");
            } else {
                SearchGoodsActivity.this.f19235c0++;
                SearchGoodsActivity.this.t0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SearchGoodsActivity.this.f19237p0 = JsonParse.getInt(data, "total");
            if (SearchGoodsActivity.this.f19235c0 == 1) {
                SearchGoodsActivity.this.f19233a0.clear();
            }
            SearchGoodsActivity.this.f19233a0.addAll(JsonParse.getList(data, "data"));
            SearchGoodsActivity.this.Z.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (SearchGoodsActivity.this.X != null && SearchGoodsActivity.this.X.x()) {
                SearchGoodsActivity.this.X.Y();
            }
            if (SearchGoodsActivity.this.X != null && SearchGoodsActivity.this.X.isLoading()) {
                SearchGoodsActivity.this.X.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((g) Http.getApiService(g.class)).j(this.f19234b0, this.F0, this.f19235c0, this.f19236k0)).setDataListener(new f());
    }

    private void u0() {
        this.X.D(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnQueryTextListener(new c());
        this.Z.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.Y.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.Y.setLayoutAnimation(layoutAnimationController);
        this.Y.addItemDecoration(new DividerItemDecoration(this.T, 1));
        b bVar = new b(this.T, R.layout.item_for_goods_list, this.f19233a0);
        this.Z = bVar;
        this.Y.setAdapter(bVar);
        this.X.F();
        u0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("全部商品");
        if (getIntent().hasExtra("typeName")) {
            setTitle(getIntent().getStringExtra("typeName"));
        }
        if (getIntent().hasExtra("typeId")) {
            this.f19234b0 = getIntent().getStringExtra("typeId");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_search_goods;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (SmartRefreshLayout) findViewById(2131298353);
        this.Y = (RecyclerView) findViewById(R.id.rv_goods_list);
        SearchView searchView = (SearchView) findViewById(R.id.search);
        this.W = searchView;
        searchView.post(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
