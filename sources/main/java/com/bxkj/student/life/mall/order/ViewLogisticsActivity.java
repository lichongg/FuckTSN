package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ViewLogisticsActivity extends BaseActivity {
    private RecyclerView W;
    private List<Map<String, Object>> X = new ArrayList();
    private String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19358a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f19359b0;

    /* renamed from: c0, reason: collision with root package name */
    private LinearLayout f19360c0;

    /* renamed from: k0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19361k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f19362p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            if (holder.f() == 0) {
                holder.r(R.id.iv_dot, R.mipmap.red_dot);
                holder.K(2131298946, ViewLogisticsActivity.this.getResources().getColor(2131099731));
                holder.K(2131299158, ViewLogisticsActivity.this.getResources().getColor(2131099731));
            } else {
                holder.r(R.id.iv_dot, R.mipmap.gray_dot);
                holder.K(2131298946, ViewLogisticsActivity.this.getResources().getColor(2131099821));
                holder.K(2131299158, ViewLogisticsActivity.this.getResources().getColor(2131099821));
            }
            holder.J(2131298946, JsonParse.getString(stringObjectMap, "AcceptStation"));
            holder.J(2131299158, JsonParse.getString(stringObjectMap, "AcceptTime"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLogisticsActivity.this.f19360c0.setVisibility(0);
            ViewLogisticsActivity.this.f19358a0.setText("物流公司：" + JsonParse.getString(data, "ShipperName"));
            ViewLogisticsActivity.this.f19359b0.setText("物流单号：" + JsonParse.getString(data, "LogisticCode"));
            ViewLogisticsActivity.this.X = JsonParse.getList(data, "Traces");
            if (ViewLogisticsActivity.this.X == null || ViewLogisticsActivity.this.X.size() == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("AcceptStation", "暂无物流信息");
                ViewLogisticsActivity.this.X.add(hashMap);
            }
            Collections.reverse(ViewLogisticsActivity.this.X);
            ViewLogisticsActivity.this.f19361k0.g(ViewLogisticsActivity.this.X);
        }
    }

    private void n0() {
        Http.with(this.T).setObservable(((g) Http.getApiService(g.class)).l(this.f19362p0)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("查看物流");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_view_logistics;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("orderId")) {
            this.f19362p0 = getIntent().getStringExtra("orderId");
        }
        if (getIntent().hasExtra("shipping_id")) {
            this.Y = getIntent().getStringExtra("shipping_id");
        }
        if (getIntent().hasExtra("invoice_no")) {
            this.Z = getIntent().getStringExtra("invoice_no");
        }
        n0();
        for (int i6 = 0; i6 < 4; i6++) {
            this.X.add(new HashMap());
        }
        this.f19361k0 = new a(this.T, R.layout.item_for_logistics, this.X);
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        this.W.setAdapter(this.f19361k0);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (RecyclerView) findViewById(2131298096);
        this.f19358a0 = (TextView) findViewById(2131298986);
        this.f19359b0 = (TextView) findViewById(2131298991);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131298068);
        this.f19360c0 = linearLayout;
        linearLayout.setVisibility(4);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
