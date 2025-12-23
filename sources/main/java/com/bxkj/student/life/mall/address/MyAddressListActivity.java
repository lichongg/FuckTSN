package com.bxkj.student.life.mall.address;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyAddressListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private Button Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private int f19258a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private int f19259b0 = 15;

    /* renamed from: c0, reason: collision with root package name */
    private int f19260c0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19261k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f19262p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0247a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19264a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f19265b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f19266c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f19267d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f19268e;

            ViewOnClickListenerC0247a(final Map val$stringObjectMap, final String val$name, final String val$phone, final String val$city, final String val$address) {
                this.f19264a = val$stringObjectMap;
                this.f19265b = val$name;
                this.f19266c = val$phone;
                this.f19267d = val$city;
                this.f19268e = val$address;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                MyAddressListActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1138e, (Class<?>) AddAddressActivity.class).putExtra("addressId", JsonParse.getString(this.f19264a, "id")).putExtra(CommonNetImpl.NAME, this.f19265b).putExtra("phone", this.f19266c).putExtra(DistrictSearchQuery.KEYWORDS_CITY, this.f19267d).putExtra("areaId", JsonParse.getString(this.f19264a, "cityId")).putExtra("address", this.f19268e));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19270a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewHolder f19271b;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$b$a, reason: collision with other inner class name */
            class C0248a implements iOSTwoButtonDialog.RightButtonOnClick {

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$b$a$a, reason: collision with other inner class name */
                class C0249a extends HttpCallBack {
                    C0249a() {
                    }

                    @Override // cn.bluemobi.dylan.http.HttpResponse
                    public void netOnSuccess(Map<String, Object> data) {
                        a.this.d().remove(b.this.f19270a);
                        b bVar = b.this;
                        a.this.notifyItemRemoved(bVar.f19271b.f());
                    }
                }

                C0248a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    Http.with(((CommonAdapter) a.this).f1138e).setObservable(((g) Http.getApiService(g.class)).u(JsonParse.getString(b.this.f19270a, "id"))).setDataListener(new C0249a());
                }
            }

            b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f19270a = val$stringObjectMap;
                this.f19271b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                new iOSTwoButtonDialog(((CommonAdapter) a.this).f1138e).setMessage("确定要删除吗？").setRightButtonOnClickListener(new C0248a()).show();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class c implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewHolder f19275a;

            c(final ViewHolder val$holder) {
                this.f19275a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                MyAddressListActivity.this.v0(this.f19275a.f());
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class d implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19277a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$d$a, reason: collision with other inner class name */
            class C0250a extends HttpCallBack {
                C0250a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    for (Map map : MyAddressListActivity.this.Z) {
                        if (d.this.f19277a.equals(map)) {
                            map.put("firstFlag", 1);
                        } else {
                            map.put("firstFlag", 0);
                        }
                    }
                    a.this.notifyDataSetChanged();
                }
            }

            d(final Map val$stringObjectMap) {
                this.f19277a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                Http.with(((CommonAdapter) a.this).f1138e).setObservable(((g) Http.getApiService(g.class)).B(JsonParse.getString(this.f19277a, "id"))).setDataListener(new C0250a());
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "receiverName");
            holder.J(2131298986, string);
            String string2 = JsonParse.getString(stringObjectMap, "receiverPhone");
            holder.J(2131299035, string2);
            String string3 = JsonParse.getString(stringObjectMap, "provenceStr");
            String string4 = JsonParse.getString(stringObjectMap, "detailAddress");
            holder.J(2131298773, string3 + string4);
            holder.w(R.id.iv_edit, new ViewOnClickListenerC0247a(stringObjectMap, string, string2, string3, string4));
            holder.w(R.id.iv_delete, new b(stringObjectMap, holder));
            if (TextUtils.isEmpty(MyAddressListActivity.this.f19262p0)) {
                holder.J(R.id.cb_default, "设为默认地址");
                holder.N(R.id.tv_is_default, false);
                holder.m(R.id.cb_default, "1".equals(JsonParse.getString(stringObjectMap, "firstFlag")));
                holder.w(R.id.ll_set_default, new d(stringObjectMap));
                return;
            }
            holder.J(R.id.cb_default, "选择该地址");
            holder.N(R.id.tv_is_default, true);
            holder.N(R.id.tv_is_default, "1".equals(JsonParse.getString(stringObjectMap, "firstFlag")));
            holder.m(R.id.cb_default, MyAddressListActivity.this.f19262p0.equals(JsonParse.getString(stringObjectMap, "id")));
            holder.w(R.id.ll_set_default, new c(holder));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            MyAddressListActivity.this.v0(position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements e {
        c() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            MyAddressListActivity.this.f19258a0 = 1;
            MyAddressListActivity.this.s0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = MyAddressListActivity.this.f19260c0 / MyAddressListActivity.this.f19259b0;
            int i7 = MyAddressListActivity.this.f19258a0;
            if (MyAddressListActivity.this.f19260c0 % MyAddressListActivity.this.f19259b0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                MyAddressListActivity.this.W.Q();
                MyAddressListActivity.this.g0("没有了");
            } else {
                MyAddressListActivity.this.f19258a0++;
                MyAddressListActivity.this.s0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyAddressListActivity.this.f19260c0 = JsonParse.getInt(data, "total");
            if (MyAddressListActivity.this.f19258a0 == 1) {
                MyAddressListActivity.this.Z.clear();
            }
            MyAddressListActivity.this.Z.addAll(JsonParse.getList(data, "data"));
            MyAddressListActivity.this.f19261k0.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyAddressListActivity.this.W != null && MyAddressListActivity.this.W.x()) {
                MyAddressListActivity.this.W.Y();
            }
            if (MyAddressListActivity.this.W != null && MyAddressListActivity.this.W.isLoading()) {
                MyAddressListActivity.this.W.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((g) Http.getApiService(g.class)).s(LoginUser.getLoginUser().getOpenId(), this.f19258a0, this.f19259b0)).setDataListener(new d());
    }

    private void t0() {
        this.W.D(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int position) {
        Intent intent = new Intent();
        intent.putExtra("id", JsonParse.getString(this.f19261k0.getItem(position), "id"));
        intent.putExtra("receiverName", JsonParse.getString(this.f19261k0.getItem(position), "receiverName"));
        intent.putExtra("receiverPhone", JsonParse.getString(this.f19261k0.getItem(position), "receiverPhone"));
        intent.putExtra("detailAddress", JsonParse.getString(this.f19261k0.getItem(position), "provenceStr") + JsonParse.getString(this.f19261k0.getItem(position), "detailAddress"));
        setResult(-1, intent);
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnClickListener(this);
        if (TextUtils.isEmpty(this.f19262p0)) {
            return;
        }
        this.f19261k0.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("收货地址");
    }

    public void u0() {
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_address_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("addressId")) {
            this.f19262p0 = getIntent().getStringExtra("addressId");
        }
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_address, this.Z);
        this.f19261k0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(findViewById(2131298892));
        t0();
        u0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298353);
        this.X = (EmptyRecyclerView) findViewById(R.id.rv_address);
        this.Y = (Button) findViewById(2131296581);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296581) {
            return;
        }
        startActivity(new Intent(this.T, (Class<?>) AddAddressActivity.class));
    }
}
