package com.bxkj.student.home.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SystemMessageListActivity extends BaseActivity {
    private RecyclerView W;
    private SmartRefreshLayout X;
    private List<Map<String, Object>> Y;
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f17889a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private int f17890b0 = 12;

    /* renamed from: c0, reason: collision with root package name */
    private int f17891c0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131299164, u.O(stringObjectMap, "title"));
            ((ImageView) holder.h(R.id.iv_not_read)).setVisibility(u.O(stringObjectMap, "isread").equals("0") ? 0 : 4);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements e {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            SystemMessageListActivity.this.f17889a0 = 1;
            SystemMessageListActivity.this.s0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = SystemMessageListActivity.this.f17891c0 / SystemMessageListActivity.this.f17890b0;
            int i7 = SystemMessageListActivity.this.f17889a0;
            if (SystemMessageListActivity.this.f17891c0 % SystemMessageListActivity.this.f17890b0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                SystemMessageListActivity.this.X.Q();
                SystemMessageListActivity.this.g0("没有了");
            } else {
                SystemMessageListActivity.this.f17889a0++;
                SystemMessageListActivity.this.s0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SystemMessageListActivity.this.f17891c0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (SystemMessageListActivity.this.f17889a0 == 1) {
                SystemMessageListActivity.this.Y = list;
            } else {
                SystemMessageListActivity.this.Y.addAll(list);
            }
            SystemMessageListActivity.this.Z.g(SystemMessageListActivity.this.Y);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            SystemMessageListActivity.this.X.Y();
            SystemMessageListActivity.this.X.Q();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            Intent intent = new Intent(((BaseActivity) SystemMessageListActivity.this).T, (Class<?>) H5DetailActivity.class);
            intent.putExtra("title", u.O((Map) SystemMessageListActivity.this.Z.getItem(position), "title"));
            intent.putExtra("url", u.O((Map) SystemMessageListActivity.this.Z.getItem(position), "url"));
            SystemMessageListActivity.this.startActivity(intent);
            ((Map) SystemMessageListActivity.this.Z.getItem(position)).put("isread", "1");
            SystemMessageListActivity.this.Z.notifyItemChanged(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).l1(LoginUser.getLoginUser().getUserId(), "0", this.f17889a0, this.f17890b0)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_notice, this.Y);
        this.Z = aVar;
        this.W.setAdapter(aVar);
        this.X.D(new b());
        this.X.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("通知消息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_notify;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (RecyclerView) findViewById(2131298351);
        this.X = (SmartRefreshLayout) findViewById(2131298353);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
