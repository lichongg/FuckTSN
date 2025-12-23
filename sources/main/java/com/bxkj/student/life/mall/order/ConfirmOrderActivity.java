package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.student.R;
import com.bxkj.student.life.mall.CartActivity;
import com.bxkj.student.life.mall.address.MyAddressListActivity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ConfirmOrderActivity extends BaseActivity {
    private TextView F0;
    private EditText G0;
    private Button H0;
    private Map<String, Object> I0;
    private List<Map<String, Object>> J0;
    private double K0;
    private double L0;
    private String M0;
    private final int N0 = 170;
    private LinearLayout W;
    private LinearLayout X;
    private RecyclerView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19308a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f19309b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19310c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f19311k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f19312p0;

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
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ConfirmOrderActivity.this.startActivity(new Intent(((BaseActivity) ConfirmOrderActivity.this).T, (Class<?>) OrderPayActivity.class).putExtra("orderId", JsonParse.getString(data, "orderId")).putExtra("orderNo", JsonParse.getString(data, "orderNum")).putExtra("payPrice", JsonParse.getDouble(data, "prize")));
            CartActivity cartActivity = (CartActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(CartActivity.class);
            if (cartActivity != null) {
                cartActivity.F0();
            }
            ConfirmOrderActivity.this.finish();
        }
    }

    private void i0() {
        String str;
        Map<String, Object> map = this.I0;
        if (map == null || map.size() <= 0) {
            g0("请选择地址");
            return;
        }
        if (TextUtils.isEmpty(this.M0)) {
            ArrayList<Map> arrayList = new ArrayList();
            arrayList.addAll(this.J0);
            try {
                for (Map map2 : arrayList) {
                    map2.remove("commName");
                    map2.remove("commPrize");
                    map2.remove("showImg");
                    map2.remove("modelName");
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            str = JSON.toJSONString(arrayList);
        } else {
            str = null;
        }
        Http.with(this.T).setObservable(((g) Http.getApiService(g.class)).A(this.M0, JsonParse.getString(this.I0, "id"), this.G0.getText().toString().trim(), str)).setDataListener(new b());
    }

    private void j0() {
        Map<String, Object> map = this.I0;
        if (map == null || map.size() <= 0) {
            this.X.setVisibility(8);
            this.W.setVisibility(0);
            return;
        }
        this.X.setVisibility(0);
        this.W.setVisibility(8);
        this.Z.setText(JsonParse.getString(this.I0, "receiverName"));
        this.f19308a0.setText(JsonParse.getString(this.I0, "receiverPhone"));
        this.f19309b0.setText(JsonParse.getString(this.I0, "detailAddress"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.H0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("确认订单");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_confirm_order;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("map")) {
            Map<String, Object> map = ((SeralizableMap) getIntent().getSerializableExtra("map")).getMap();
            this.I0 = JsonParse.getMap(map, "address");
            this.J0 = JsonParse.getList(map, "goodsList");
            this.K0 = JsonParse.getDouble(map, "goodsPrice");
            this.L0 = JsonParse.getDouble(map, "postFee");
            this.M0 = JsonParse.getString(map, "ids");
        }
        j0();
        this.Y.setLayoutManager(new LinearLayoutManager(this.T));
        this.Y.setAdapter(new a(this.T, R.layout.item_for_order_goods_list, this.J0));
        this.Y.addItemDecoration(new DividerItemDecoration(this.T, 1));
        this.f19310c0.setText("￥" + new DecimalFormat("0.00").format(this.K0));
        this.f19311k0.setText("￥" + new DecimalFormat("0.00").format(this.L0));
        this.f19312p0.setText("￥" + new DecimalFormat("0.00").format(this.K0 + this.L0));
        this.F0.setText("实付款：￥" + new DecimalFormat("0.00").format(this.K0 + this.L0));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (LinearLayout) findViewById(R.id.ll_choose_address);
        this.X = (LinearLayout) findViewById(R.id.ll_address);
        this.Y = (RecyclerView) findViewById(R.id.rv_goods_list);
        this.H0 = (Button) findViewById(2131296599);
        this.f19310c0 = (TextView) findViewById(R.id.tv_goods_price);
        this.f19311k0 = (TextView) findViewById(R.id.tv_post_price);
        this.f19312p0 = (TextView) findViewById(R.id.tv_total_price);
        this.F0 = (TextView) findViewById(R.id.tv_pay_price);
        this.Z = (TextView) findViewById(2131298986);
        this.f19308a0 = (TextView) findViewById(2131299035);
        this.f19309b0 = (TextView) findViewById(2131298773);
        this.G0 = (EditText) findViewById(R.id.et_note);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && data != null && requestCode == 170) {
            this.I0.put("id", data.getStringExtra("id"));
            this.I0.put("receiverName", data.getStringExtra("receiverName"));
            this.I0.put("receiverPhone", data.getStringExtra("receiverPhone"));
            this.I0.put("detailAddress", data.getStringExtra("detailAddress"));
            j0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id != 2131296599) {
            String str = "-1";
            if (id != 2131298012) {
                if (id != 2131298022) {
                    return;
                }
                Intent intent = new Intent(this.T, (Class<?>) MyAddressListActivity.class);
                if (!JsonParse.getString(this.I0, "id").isEmpty()) {
                    str = JsonParse.getString(this.I0, "id");
                }
                startActivityForResult(intent.putExtra("addressId", str), 170);
                return;
            }
            Intent intent2 = new Intent(this.T, (Class<?>) MyAddressListActivity.class);
            if (!JsonParse.getString(this.I0, "id").isEmpty()) {
                str = JsonParse.getString(this.I0, "id");
            }
            startActivityForResult(intent2.putExtra("addressId", str), 170);
            return;
        }
        i0();
    }
}
