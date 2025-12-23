package com.bxkj.student.home.teaching.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class BookingActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;

    /* renamed from: a0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18059a0;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private int f18060b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    private int f18061c0 = 15;

    /* renamed from: k0, reason: collision with root package name */
    private int f18062k0 = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv11, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.J(R.id.tv21, JsonParse.getString(stringObjectMap, "orderDate"));
            holder.J(R.id.tv31, JsonParse.getString(stringObjectMap, "activeDate"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements e {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            BookingActivity.this.f18060b0 = 1;
            BookingActivity.this.r0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = BookingActivity.this.f18062k0 / BookingActivity.this.f18061c0;
            int i7 = BookingActivity.this.f18060b0;
            if (BookingActivity.this.f18062k0 % BookingActivity.this.f18061c0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                BookingActivity.this.W.Q();
                BookingActivity.this.g0("没有了");
            } else {
                BookingActivity.this.f18060b0++;
                BookingActivity.this.r0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingActivity.this.Z = JsonParse.getList(data, "data");
            BookingActivity.this.f18059a0.g(BookingActivity.this.Z);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (BookingActivity.this.W != null && BookingActivity.this.W.x()) {
                BookingActivity.this.W.Y();
            }
            if (BookingActivity.this.W != null && BookingActivity.this.W.isLoading()) {
                BookingActivity.this.W.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).w0(LoginUser.getLoginUser().getUserId(), this.f18060b0, this.f18061c0)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(ViewGroup viewGroup, View view, Object obj, int i6) {
        startActivity(new Intent(this.T, (Class<?>) BookingDetailActivity.class).putExtra("id", JsonParse.getString(this.f18059a0.getItem(i6), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.D(new b());
        this.W.F();
        this.f18059a0.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.activity.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                BookingActivity.this.s0(viewGroup, view, obj, i6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_booking_activity, this.Z);
        this.f18059a0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(this.Y);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("预约活动列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131492999;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.Y = (TextView) findViewById(2131298892);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
