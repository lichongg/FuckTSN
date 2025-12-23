package com.bxkj.student.home.teaching.learning.my;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.m;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyIntegralListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private int f18699a0 = 20;

    /* renamed from: b0, reason: collision with root package name */
    private int f18700b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    private int f18701c0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private CommonAdapter f18702k0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "title"));
            holder.J(2131299158, JsonParse.getString(stringObjectMap, "integral"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements n2.e {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            MyIntegralListActivity.this.f18700b0 = 1;
            MyIntegralListActivity.this.q0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = MyIntegralListActivity.this.f18701c0 / MyIntegralListActivity.this.f18699a0;
            int i7 = MyIntegralListActivity.this.f18700b0;
            if (MyIntegralListActivity.this.f18701c0 % MyIntegralListActivity.this.f18699a0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                MyIntegralListActivity.this.W.Q();
                MyIntegralListActivity.this.g0("没有了");
            } else {
                MyIntegralListActivity.this.f18700b0++;
                MyIntegralListActivity.this.q0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyIntegralListActivity.this.f18701c0 = JsonParse.getInt(data, "total");
            if (MyIntegralListActivity.this.f18700b0 == 1) {
                MyIntegralListActivity.this.Z.clear();
            }
            MyIntegralListActivity.this.Z.addAll(JsonParse.getList(data, "data"));
            MyIntegralListActivity.this.f18702k0.g(MyIntegralListActivity.this.Z);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyIntegralListActivity.this.W != null && MyIntegralListActivity.this.W.x()) {
                MyIntegralListActivity.this.W.Y();
            }
            if (MyIntegralListActivity.this.W != null && MyIntegralListActivity.this.W.isLoading()) {
                MyIntegralListActivity.this.W.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((m) Http.getApiService(m.class)).d(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("resultType"), Integer.valueOf(this.f18699a0), Integer.valueOf(this.f18700b0))).setDataListener(new c());
    }

    private void r0() {
        this.W.D(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_sign_record_list, this.Z);
        this.f18702k0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(this.Y);
        r0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的积分");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493640;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.Y = (TextView) findViewById(2131298892);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
