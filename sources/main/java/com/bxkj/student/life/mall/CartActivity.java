package com.bxkj.student.life.mall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.common.view.NumberButton;
import com.bxkj.student.life.mall.order.ConfirmOrderActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CartActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19129a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f19130b0;

    /* renamed from: c0, reason: collision with root package name */
    private CheckBox f19131c0;

    /* renamed from: k0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19132k0;

    /* renamed from: p0, reason: collision with root package name */
    private List<Map<String, Object>> f19133p0 = new ArrayList();
    private Map<String, Object> F0 = new HashMap();
    private String G0 = "编辑";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            if (CartActivity.this.G0.equals("编辑")) {
                CartActivity.this.G0 = "完成";
                CartActivity.this.Y.setVisibility(8);
                CartActivity.this.Z.setVisibility(8);
                CartActivity.this.f19129a0.setVisibility(8);
                CartActivity.this.f19130b0.setText("删除");
            } else {
                CartActivity.this.G0 = "编辑";
                CartActivity.this.Y.setVisibility(0);
                CartActivity.this.Z.setVisibility(0);
                CartActivity.this.f19129a0.setVisibility(0);
                CartActivity.this.f19130b0.setText("结算");
            }
            CartActivity.this.G0();
            CartActivity.this.invalidateOptionsMenu();
            CartActivity.this.f19132k0.notifyDataSetChanged();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements NumberButton.OnWarnListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewHolder f19136a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Map f19137b;

            a(final ViewHolder val$holder, final Map val$stringObjectMap) {
                this.f19136a = val$holder;
                this.f19137b = val$stringObjectMap;
            }

            @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
            public void onNumberChanged(int number) {
                CartActivity.this.C0(this.f19136a.f(), JsonParse.getString(this.f19137b, "id"), String.valueOf(number));
            }

            @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
            public void onWarningForBuyMax(int max) {
            }

            @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
            public void onWarningForInventory(int inventory) {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.mall.CartActivity$b$b, reason: collision with other inner class name */
        class ViewOnClickListenerC0243b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f19139a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f19140b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ ViewHolder f19141c;

            ViewOnClickListenerC0243b(final String val$id, final boolean val$finalIsCheck, final ViewHolder val$holder) {
                this.f19139a = val$id;
                this.f19140b = val$finalIsCheck;
                this.f19141c = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                CartActivity.this.F0.put(this.f19139a, Boolean.valueOf(!this.f19140b));
                b.this.notifyItemChanged(this.f19141c.f());
                CartActivity.this.B0();
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.t(R.id.iv_pic, JsonParse.getString(stringObjectMap, "showImg"), R.mipmap.icon_smal, R.mipmap.icon_smal);
            if ("1".equals(JsonParse.getString(stringObjectMap, "downState"))) {
                holder.K(2131298986, CartActivity.this.getResources().getColor(2131099732));
                holder.J(2131299047, "该商品已下架");
            } else {
                holder.K(2131298986, CartActivity.this.getResources().getColor(2131099731));
                holder.J(2131299047, "￥" + JsonParse.getMoney(stringObjectMap, "commPrize"));
            }
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "commName"));
            holder.J(R.id.tv_model, JsonParse.getString(stringObjectMap, "modelName"));
            holder.J(2131298848, "x" + JsonParse.getString(stringObjectMap, "commNum"));
            if (CartActivity.this.G0.equals("编辑")) {
                holder.N(2131298848, true);
                holder.N(2131298253, false);
            } else {
                holder.N(2131298848, false);
                holder.N(2131298253, true);
            }
            NumberButton numberButton = (NumberButton) holder.h(2131298253);
            numberButton.setCurrentNumber(JsonParse.getInt(stringObjectMap, "commNum"));
            numberButton.setOnWarnListener(new a(holder, stringObjectMap));
            String string = JsonParse.getString(stringObjectMap, "id");
            boolean z5 = CartActivity.this.F0.containsKey(string) ? JsonParse.getBoolean(CartActivity.this.F0, string) : false;
            holder.m(R.id.cb_all, z5);
            holder.w(R.id.cb_all, new ViewOnClickListenerC0243b(string, z5, holder));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements n2.e {
        c() {
        }

        @Override // n2.d
        public void a(m2.h refreshlayout) {
            CartActivity.this.D0();
        }

        @Override // n2.b
        public void f(m2.h refreshlayout) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            CartActivity.this.startActivity(new Intent(((BaseActivity) CartActivity.this).T, (Class<?>) GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) CartActivity.this.f19132k0.getItem(position), "commId")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CartActivity.this.f19133p0 = JsonParse.getList(data, "data");
            CartActivity.this.f19132k0.g(CartActivity.this.f19133p0);
            CartActivity.this.E0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (CartActivity.this.W != null && CartActivity.this.W.x()) {
                CartActivity.this.W.Y();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19146a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19147b;

        f(final int val$position, final String val$cartNumber) {
            this.f19146a = val$position;
            this.f19147b = val$cartNumber;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((Map) CartActivity.this.f19132k0.getItem(this.f19146a)).put("commNum", this.f19147b);
            CartActivity.this.f19132k0.notifyItemChanged(this.f19146a);
            CartActivity.this.E0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends HttpCallBack {
        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i6 = 0;
            while (i6 < CartActivity.this.f19133p0.size()) {
                Map map = (Map) CartActivity.this.f19133p0.get(i6);
                String string = JsonParse.getString(map, "id");
                if (CartActivity.this.F0.containsKey(string) ? JsonParse.getBoolean(CartActivity.this.F0, string) : false) {
                    CartActivity.this.f19133p0.remove(map);
                    CartActivity.this.f19132k0.notifyItemRemoved(i6);
                    i6--;
                }
                i6++;
            }
            GoodsListFragment goodsListFragment = (GoodsListFragment) cn.bluemobi.dylan.base.utils.a.n().o(GoodsListFragment.class);
            if (goodsListFragment != null) {
                goodsListFragment.f0();
            }
        }

        g() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h extends HttpCallBack {
        h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                HashMap hashMap = new HashMap(3);
                HashMap hashMap2 = new HashMap(3);
                hashMap2.putAll(JsonParse.getMap(data, "address"));
                hashMap.put("address", hashMap2);
                hashMap.put("goodsList", JsonParse.getList(data, "comms"));
                hashMap.put("postFee", Double.valueOf(JsonParse.getDouble(data, "postFee")));
                hashMap.put("goodsPrice", Double.valueOf(JsonParse.getDouble(data, "totalPrize")));
                hashMap.put("ids", JsonParse.getString(data, "ids"));
                SeralizableMap seralizableMap = new SeralizableMap();
                seralizableMap.setMap(hashMap);
                CartActivity.this.startActivity(new Intent(((BaseActivity) CartActivity.this).T, (Class<?>) ConfirmOrderActivity.class).putExtra("map", seralizableMap));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CartActivity.this).T).setMessage(msg).show();
            CartActivity.this.D0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        int i6 = 0;
        for (int i7 = 0; i7 < this.f19133p0.size(); i7++) {
            String string = JsonParse.getString(this.f19133p0.get(i7), "id");
            if (this.F0.containsKey(string) ? JsonParse.getBoolean(this.F0, string) : false) {
                i6++;
            }
        }
        this.f19131c0.setChecked(i6 == this.f19133p0.size());
        E0();
    }

    private void A0() {
        Iterator<Map<String, Object>> it = this.f19133p0.iterator();
        while (it.hasNext()) {
            this.F0.put(JsonParse.getString(it.next(), "id"), Boolean.valueOf(this.f19131c0.isChecked()));
        }
        this.f19132k0.notifyDataSetChanged();
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(final int position, String cartId, final String cartNumber) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap(2);
        hashMap.put("id", cartId);
        hashMap.put("commNum", cartNumber);
        arrayList.add(hashMap);
        Http.with(this.T).setObservable(((x.g) Http.getApiService(x.g.class)).v(JSON.toJSONString(arrayList))).setDataListener(new f(position, cartNumber));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((x.g) Http.getApiService(x.g.class)).E(LoginUser.getLoginUser().getOpenId())).setDataListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        BigDecimal bigDecimal = new BigDecimal(0);
        for (Map<String, Object> map : this.f19133p0) {
            String string = JsonParse.getString(map, "id");
            if (this.F0.containsKey(string) ? JsonParse.getBoolean(this.F0, string) : false) {
                bigDecimal = bigDecimal.add(new BigDecimal(JsonParse.getDouble(map, "commPrize")).multiply(new BigDecimal(JsonParse.getInt(map, "commNum"))));
            }
        }
        this.f19129a0.setText(new DecimalFormat("0.00").format(bigDecimal.setScale(2, 4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        c0(this.G0, new a());
    }

    private void H0() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map<String, Object>> it = this.f19133p0.iterator();
        while (it.hasNext()) {
            String string = JsonParse.getString(it.next(), "id");
            if (this.F0.containsKey(string) ? JsonParse.getBoolean(this.F0, string) : false) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(string);
            }
        }
        if (TextUtils.isEmpty(sb)) {
            g0("请选择商品进行结算");
        } else {
            Http.with(this.T).hideOtherStatusMessage().setObservable(((x.g) Http.getApiService(x.g.class)).p(LoginUser.getLoginUser().getOpenId(), sb.toString())).setDataListener(new h());
        }
    }

    private void delete() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map<String, Object>> it = this.f19133p0.iterator();
        while (it.hasNext()) {
            String string = JsonParse.getString(it.next(), "id");
            if (this.F0.containsKey(string) ? JsonParse.getBoolean(this.F0, string) : false) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(string);
            }
        }
        if (TextUtils.isEmpty(sb)) {
            g0("请选择商品进行删除");
        } else {
            Http.with(this.T).setObservable(((x.g) Http.getApiService(x.g.class)).w(sb.toString())).setDataListener(new g());
        }
    }

    public void F0() {
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f19130b0.setOnClickListener(this);
        this.f19131c0.setOnClickListener(this);
        this.f19132k0.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        this.X.addItemDecoration(new DividerItemDecoration(this.T, 1));
        b bVar = new b(this.T, R.layout.item_for_shopping_cart_goods_number, this.f19133p0);
        this.f19132k0 = bVar;
        this.X.setAdapter(bVar);
        this.X.setEmptyView(findViewById(2131298892));
        this.W.v(false);
        this.W.D(new c());
        F0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("购物车");
        G0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_cart_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (EmptyRecyclerView) findViewById(2131298421);
        this.Z = (TextView) findViewById(2131298848);
        this.Y = (TextView) findViewById(R.id.tv_count_hint);
        this.f19129a0 = (TextView) findViewById(2131299047);
        this.f19130b0 = (Button) findViewById(R.id.bt_next);
        this.f19131c0 = (CheckBox) findViewById(R.id.cb_all);
        this.W = (SmartRefreshLayout) findViewById(2131298353);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id != 2131296622) {
            if (id != 2131296718) {
                return;
            }
            A0();
        } else if (this.f19130b0.getText().toString().trim().equals("删除")) {
            delete();
        } else {
            H0();
        }
    }
}
