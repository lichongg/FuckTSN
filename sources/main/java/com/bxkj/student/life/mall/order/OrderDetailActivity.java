package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
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
import com.bxkj.student.life.mall.GoodsDetailActivity;
import com.bxkj.student.life.mall.order.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class OrderDetailActivity extends BaseActivity {
    private TextView F0;
    private TextView G0;
    private CardView H0;
    private TextView I0;
    private Button J0;
    private Button K0;
    private List<Map<String, Object>> L0 = new ArrayList();
    private String M0;
    private Map<String, Object> N0;
    private CommonAdapter<Map<String, Object>> O0;
    private Map<String, Object> P0;
    private ScrollView W;
    private RecyclerView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19315a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f19316b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19317c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f19318k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f19319p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.t(2131297182, JsonParse.getString(stringObjectMap, "showImg"), R.mipmap.icon_smal, R.mipmap.icon_smal);
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "commName"));
            holder.J(2131299047, "￥" + JsonParse.getMoney(stringObjectMap, "commPrize"));
            holder.J(2131298848, "x" + JsonParse.getInt(stringObjectMap, "commNum"));
            holder.J(R.id.tv_model, JsonParse.getString(stringObjectMap, "modelName"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements a.e {
        b() {
        }

        @Override // com.bxkj.student.life.mall.order.a.e
        public void a() {
            OrderDetailActivity.this.q0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.life.mall.order.a f19322a;

        c(final com.bxkj.student.life.mall.order.a val$orderButtonOnClick) {
            this.f19322a = val$orderButtonOnClick;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            this.f19322a.d(OrderDetailActivity.this.J0.getText().toString().trim(), JsonParse.getString(OrderDetailActivity.this.N0, "id"), JsonParse.getString(OrderDetailActivity.this.N0, "orderNum"), JsonParse.getDouble(OrderDetailActivity.this.N0, "totalPrize"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.life.mall.order.a f19324a;

        d(final com.bxkj.student.life.mall.order.a val$orderButtonOnClick) {
            this.f19324a = val$orderButtonOnClick;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            this.f19324a.d(OrderDetailActivity.this.K0.getText().toString().trim(), JsonParse.getString(OrderDetailActivity.this.N0, "id"), JsonParse.getString(OrderDetailActivity.this.N0, "orderNum"), JsonParse.getDouble(OrderDetailActivity.this.N0, "totalPrize"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            OrderDetailActivity.this.startActivity(new Intent(((BaseActivity) OrderDetailActivity.this).T, (Class<?>) GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) OrderDetailActivity.this.O0.getItem(position), "commId")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OrderDetailActivity.this.N0 = data;
            OrderDetailActivity.this.W.setVisibility(0);
            OrderDetailActivity.this.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        Http.with(this.T).setObservable(((g) Http.getApiService(g.class)).f(this.M0)).setDataListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.Y.setText(JsonParse.getString(this.N0, "state"));
        this.Z.setText(JsonParse.getString(this.N0, "orderNum"));
        this.f19315a0.setText(JsonParse.getString(this.N0, "createTime"));
        this.f19316b0.setText(JsonParse.getString(this.N0, "receiverName"));
        this.f19317c0.setText(JsonParse.getString(this.N0, "receiverPhone"));
        this.f19318k0.setText(JsonParse.getString(this.N0, "address"));
        List<Map<String, Object>> list = JsonParse.getList(this.N0, "commArr");
        this.L0 = list;
        this.O0.g(list);
        String string = JsonParse.getString(this.N0, "memo");
        if (!TextUtils.isEmpty(string)) {
            this.H0.setVisibility(0);
            this.I0.setText(string);
        }
        this.f19319p0.setText("￥" + JsonParse.getMoney(this.N0, "commPrize"));
        this.F0.setText("￥" + JsonParse.getMoney(this.N0, "postFee"));
        this.G0.setText("￥" + JsonParse.getMoney(this.N0, "totalPrize"));
        int i6 = JsonParse.getInt(this.N0, "orderMode");
        if (i6 == 1) {
            this.J0.setVisibility(0);
            this.K0.setVisibility(0);
            this.J0.setText("取消订单");
            this.K0.setText("立即付款");
            return;
        }
        if (i6 == 2) {
            this.J0.setVisibility(8);
            this.K0.setVisibility(0);
            this.K0.setText("申请退款");
            return;
        }
        if (i6 == 3) {
            this.J0.setVisibility(0);
            this.K0.setVisibility(0);
            this.J0.setText("查看物流");
            this.K0.setText("确认收货");
            return;
        }
        if (i6 == 4) {
            this.J0.setVisibility(8);
            this.K0.setVisibility(0);
            this.K0.setText("删除订单");
        } else if (i6 == 5) {
            this.J0.setVisibility(8);
            this.K0.setVisibility(0);
            this.K0.setText("删除订单");
        } else if (i6 != 6) {
            this.J0.setVisibility(8);
            this.K0.setVisibility(8);
        } else {
            this.J0.setVisibility(8);
            this.K0.setVisibility(0);
            this.K0.setText("删除订单");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        com.bxkj.student.life.mall.order.a aVar = new com.bxkj.student.life.mall.order.a(this.T);
        aVar.s(new b());
        this.J0.setOnClickListener(new c(aVar));
        this.K0.setOnClickListener(new d(aVar));
        this.O0.k(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("订单详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_order_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("orderId")) {
            this.M0 = getIntent().getStringExtra("orderId");
        }
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_order_goods_list, this.L0);
        this.O0 = aVar;
        this.X.setAdapter(aVar);
        this.X.addItemDecoration(new DividerItemDecoration(this.T, 1));
        q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (RecyclerView) findViewById(R.id.rv_goods_list);
        this.W = (ScrollView) findViewById(2131298453);
        this.Y = (TextView) findViewById(R.id.tv_order_status);
        this.Z = (TextView) findViewById(R.id.tv_order_no);
        this.f19315a0 = (TextView) findViewById(R.id.tv_order_time);
        this.f19319p0 = (TextView) findViewById(R.id.tv_goods_price);
        this.F0 = (TextView) findViewById(R.id.tv_post_price);
        this.G0 = (TextView) findViewById(R.id.tv_total_price);
        this.f19316b0 = (TextView) findViewById(2131298986);
        this.f19317c0 = (TextView) findViewById(2131299035);
        this.f19318k0 = (TextView) findViewById(2131298773);
        this.I0 = (TextView) findViewById(R.id.tv_note);
        this.J0 = (Button) findViewById(R.id.bt_left);
        this.K0 = (Button) findViewById(R.id.bt_right);
        this.H0 = (CardView) findViewById(R.id.cardView_note);
        this.W.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
