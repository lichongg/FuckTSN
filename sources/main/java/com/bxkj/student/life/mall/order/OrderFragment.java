package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
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
import com.bxkj.student.life.mall.order.a;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class OrderFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private SmartRefreshLayout f19328j;

    /* renamed from: k, reason: collision with root package name */
    private EmptyRecyclerView f19329k;

    /* renamed from: m, reason: collision with root package name */
    private int f19331m;

    /* renamed from: n, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19332n;

    /* renamed from: o, reason: collision with root package name */
    private com.bxkj.student.life.mall.order.a f19333o;

    /* renamed from: l, reason: collision with root package name */
    private List<Map<String, Object>> f19330l = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    private int f19334p = 1;

    /* renamed from: q, reason: collision with root package name */
    private int f19335q = 15;

    /* renamed from: r, reason: collision with root package name */
    private int f19336r = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$a$a, reason: collision with other inner class name */
        class C0254a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
            C0254a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
                holder.t(2131297182, JsonParse.getString(stringObjectMap, "showImg"), R.mipmap.icon_smal, R.mipmap.icon_smal);
                holder.J(2131298986, JsonParse.getString(stringObjectMap, "commName"));
                holder.J(2131299047, "￥" + JsonParse.getMoney(stringObjectMap, "commPrize"));
                holder.J(2131298848, "x" + JsonParse.getInt(stringObjectMap, "commNum"));
                holder.J(R.id.tv_model, JsonParse.getString(stringObjectMap, "modelName"));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewHolder f19339a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Map f19340b;

            b(final ViewHolder val$holder, final Map val$stringObjectMap) {
                this.f19339a = val$holder;
                this.f19340b = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                OrderFragment.this.f19333o.d(this.f19339a.g(R.id.bt_left), JsonParse.getString(this.f19340b, "id"), JsonParse.getString(this.f19340b, "orderNum"), JsonParse.getDouble(this.f19340b, "totalPrize"));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class c implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewHolder f19342a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Map f19343b;

            c(final ViewHolder val$holder, final Map val$stringObjectMap) {
                this.f19342a = val$holder;
                this.f19343b = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                OrderFragment.this.f19333o.d(this.f19342a.g(R.id.bt_right), JsonParse.getString(this.f19343b, "id"), JsonParse.getString(this.f19343b, "orderNum"), JsonParse.getDouble(this.f19343b, "totalPrize"));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_order_no, JsonParse.getString(stringObjectMap, "orderNum"));
            holder.J(R.id.tv_order_status, JsonParse.getString(stringObjectMap, "state"));
            holder.J(R.id.tv_total_number, "共" + JsonParse.getString(stringObjectMap, "commTotalNum") + "件商品");
            StringBuilder sb = new StringBuilder();
            sb.append("合计：￥");
            sb.append(JsonParse.getMoney(stringObjectMap, "totalPrize"));
            holder.J(R.id.tv_total_price, sb.toString());
            double d6 = JsonParse.getDouble(stringObjectMap, "postFee");
            holder.N(R.id.tv_post_price, d6 != 0.0d);
            if (d6 != 0.0d) {
                holder.J(R.id.tv_post_price, "(含运费￥" + new DecimalFormat("0.00").format(d6) + ")");
            }
            ListView listView = (ListView) holder.h(R.id.lv_goods);
            listView.setEnabled(false);
            listView.setPressed(false);
            listView.setClickable(false);
            listView.setAdapter((ListAdapter) new C0254a(this.f1138e, R.layout.item_for_order_goods_list, JsonParse.getList(stringObjectMap, "commArr")));
            int i6 = JsonParse.getInt(stringObjectMap, "orderMode");
            if (i6 == 1) {
                holder.N(R.id.bt_left, true);
                holder.N(R.id.bt_right, true);
                holder.J(R.id.bt_left, "取消订单");
                holder.J(R.id.bt_right, "立即付款");
            } else if (i6 == 2) {
                holder.N(R.id.bt_left, false);
                holder.N(R.id.bt_right, true);
                holder.J(R.id.bt_right, "申请退款");
            } else if (i6 == 3) {
                holder.N(R.id.bt_left, true);
                holder.N(R.id.bt_right, true);
                holder.J(R.id.bt_left, "查看物流");
                holder.J(R.id.bt_right, "确认收货");
            } else if (i6 == 4) {
                holder.N(R.id.bt_left, false);
                holder.N(R.id.bt_right, true);
                holder.J(R.id.bt_right, "删除订单");
            } else if (i6 == 5) {
                holder.N(R.id.bt_left, false);
                holder.N(R.id.bt_right, true);
                holder.J(R.id.bt_right, "删除订单");
            } else if (i6 == 6) {
                holder.N(R.id.bt_left, false);
                holder.N(R.id.bt_right, true);
                holder.J(R.id.bt_right, "删除订单");
            } else {
                holder.N(R.id.bt_left, false);
                holder.N(R.id.bt_right, false);
            }
            holder.w(R.id.bt_left, new b(holder, stringObjectMap));
            holder.w(R.id.bt_right, new c(holder, stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            OrderFragment.this.startActivity(new Intent(((BaseFragment) OrderFragment.this).f1096g, (Class<?>) OrderDetailActivity.class).putExtra("orderId", JsonParse.getString((Map) OrderFragment.this.f19332n.getItem(position), "id")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements a.e {
        c() {
        }

        @Override // com.bxkj.student.life.mall.order.a.e
        public void a() {
            OrderFragment.this.a0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements n2.e {
        d() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            OrderFragment.this.f19334p = 1;
            OrderFragment.this.Y();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = OrderFragment.this.f19336r / OrderFragment.this.f19335q;
            int i7 = OrderFragment.this.f19334p;
            if (OrderFragment.this.f19336r % OrderFragment.this.f19335q != 0) {
                i6++;
            }
            if (i7 >= i6) {
                OrderFragment.this.f19328j.Q();
                OrderFragment.this.n("没有了");
            } else {
                OrderFragment.this.f19334p++;
                OrderFragment.this.Y();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OrderFragment.this.f19336r = JsonParse.getInt(data, "total");
            if (OrderFragment.this.f19334p == 1) {
                OrderFragment.this.f19330l.clear();
            }
            OrderFragment.this.f19330l.addAll(JsonParse.getList(data, "data"));
            OrderFragment.this.f19332n.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (OrderFragment.this.f19328j != null && OrderFragment.this.f19328j.x()) {
                OrderFragment.this.f19328j.Y();
            }
            if (OrderFragment.this.f19328j != null && OrderFragment.this.f19328j.isLoading()) {
                OrderFragment.this.f19328j.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        String valueOf = String.valueOf(this.f19331m);
        if (this.f19331m == 0) {
            valueOf = "";
        }
        Http.with(this.f1096g).hideLoadingDialog().setObservable(((g) Http.getApiService(g.class)).k(valueOf, LoginUser.getLoginUser().getOpenId(), this.f19334p, this.f19335q)).setDataListener(new e());
    }

    private void Z() {
        this.f19328j.D(new d());
    }

    public void a0() {
        this.f19328j.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f19332n.k(new b());
        this.f19333o.s(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        this.f19333o = new com.bxkj.student.life.mall.order.a(this.f1096g);
        if (getArguments().containsKey("index")) {
            this.f19331m = getArguments().getInt("index");
        }
        this.f19329k.setLayoutManager(new LinearLayoutManager(this.f1096g));
        a aVar = new a(this.f1096g, R.layout.item_for_order_list, this.f19330l);
        this.f19332n = aVar;
        this.f19329k.setAdapter(aVar);
        this.f19329k.setEmptyView(c(2131298892));
        Z();
        a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19328j = (SmartRefreshLayout) c(2131298352);
        this.f19329k = (EmptyRecyclerView) c(2131298351);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131493640;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
