package com.bxkj.place.apply;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.place.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SchoolDistrictActivity extends BaseActivity {
    private Spinner W;
    private RecyclerView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f17540a0;

    /* renamed from: b0, reason: collision with root package name */
    private List<Map<String, Object>> f17541b0 = new ArrayList();

    /* renamed from: c0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17542c0;

    /* renamed from: k0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f17543k0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.s(R.id.imageView, JsonParse.getString(stringObjectMap, "picture"));
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        c() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            SchoolDistrictActivity schoolDistrictActivity = SchoolDistrictActivity.this;
            schoolDistrictActivity.startActivity(schoolDistrictActivity.getIntent().setClass(((BaseActivity) SchoolDistrictActivity.this).T, PlaceListActivity.class).putExtra("id", u.O((Map) SchoolDistrictActivity.this.f17542c0.getItem(position), "id")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SchoolDistrictActivity schoolDistrictActivity = SchoolDistrictActivity.this;
            schoolDistrictActivity.r0(JsonParse.getString((Map) schoolDistrictActivity.f17543k0.getItem(position), "id"));
            SchoolDistrictActivity.this.Y.setText("校区地址：" + JsonParse.getString((Map) SchoolDistrictActivity.this.f17543k0.getItem(position), "address"));
            SchoolDistrictActivity.this.Z.setText("联系人\u3000：" + JsonParse.getString((Map) SchoolDistrictActivity.this.f17543k0.getItem(position), "linkUser"));
            SchoolDistrictActivity.this.f17540a0.setText("联系电话：" + JsonParse.getString((Map) SchoolDistrictActivity.this.f17543k0.getItem(position), "phoneNum"));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SchoolDistrictActivity.this.Q().setVisibility(0);
            SchoolDistrictActivity.this.f17541b0 = (List) data.get("data");
            SchoolDistrictActivity.this.f17543k0.c(SchoolDistrictActivity.this.f17541b0);
            for (int i6 = 0; i6 < SchoolDistrictActivity.this.f17541b0.size(); i6++) {
                if ("1".equals(JsonParse.getString((Map) SchoolDistrictActivity.this.f17541b0.get(i6), "isDefault"))) {
                    SchoolDistrictActivity.this.W.setSelection(i6);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SchoolDistrictActivity.this.f17542c0.g((List) data.get("data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(String campusId) {
        Http.with(this.T).setObservable(((d0.b) Http.getApiService(d0.b.class)).h(campusId)).setDataListener(new f());
    }

    private void s0() {
        Http.with(this.T).setObservable(((d0.b) Http.getApiService(d0.b.class)).b()).setDataListener(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f17542c0.k(new c());
        this.W.setOnItemSelectedListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_school_district;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        a aVar = new a(this.T, R.layout.item_for_school_district_list, this.f17541b0);
        this.f17543k0 = aVar;
        this.W.setAdapter((SpinnerAdapter) aVar);
        this.X.setLayoutManager(new GridLayoutManager(this.T, 4, 1, false));
        b bVar = new b(this.T, R.layout.item_for_sport_typeu, this.f17541b0);
        this.f17542c0 = bVar;
        this.X.setAdapter(bVar);
        s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("选择项目");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (Spinner) findViewById(R.id.spinner);
        this.X = (RecyclerView) findViewById(R.id.recyclerView);
        this.Y = (TextView) findViewById(R.id.tv_address);
        this.Z = (TextView) findViewById(R.id.tv_user);
        this.f17540a0 = (TextView) findViewById(R.id.tv_phone);
        Q().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
