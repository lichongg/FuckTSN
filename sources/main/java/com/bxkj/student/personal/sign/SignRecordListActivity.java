package com.bxkj.student.personal.sign;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;
import x.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SignRecordListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19681a0;

    /* renamed from: b0, reason: collision with root package name */
    private com.bxkj.student.life.mall.order.a f19682b0;
    private List<Map<String, Object>> Y = new ArrayList();

    /* renamed from: c0, reason: collision with root package name */
    private int f19683c0 = 1;

    /* renamed from: k0, reason: collision with root package name */
    private int f19684k0 = 15;

    /* renamed from: p0, reason: collision with root package name */
    private int f19685p0 = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, "积分+" + JsonParse.getString(stringObjectMap, "integral"));
            holder.J(2131299158, JsonParse.getString(stringObjectMap, "integralDate"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements e {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            SignRecordListActivity.this.f19683c0 = 1;
            SignRecordListActivity.this.q0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = SignRecordListActivity.this.f19685p0 / SignRecordListActivity.this.f19684k0;
            int i7 = SignRecordListActivity.this.f19683c0;
            if (SignRecordListActivity.this.f19685p0 % SignRecordListActivity.this.f19684k0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                SignRecordListActivity.this.W.Q();
                SignRecordListActivity.this.g0("没有了");
            } else {
                SignRecordListActivity.this.f19683c0++;
                SignRecordListActivity.this.q0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignRecordListActivity.this.f19685p0 = JsonParse.getInt(data, "total");
            if (SignRecordListActivity.this.f19683c0 == 1) {
                SignRecordListActivity.this.Y.clear();
            }
            SignRecordListActivity.this.Y.addAll(JsonParse.getList(data, "data"));
            SignRecordListActivity.this.f19681a0.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (SignRecordListActivity.this.W != null && SignRecordListActivity.this.W.x()) {
                SignRecordListActivity.this.W.Y();
            }
            if (SignRecordListActivity.this.W != null && SignRecordListActivity.this.W.isLoading()) {
                SignRecordListActivity.this.W.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((f) Http.getApiService(f.class)).m(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getAccount(), this.f19683c0, this.f19684k0)).setDataListener(new c());
    }

    private void r0() {
        this.W.D(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_sign_record_list, this.Y);
        this.f19681a0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(findViewById(2131298892));
        r0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("签到记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493640;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
