package com.bxkj.student.home.teaching.resultfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
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

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ViewTermActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Z;
    private List<Map<String, Object>> Y = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    protected int f18947a0 = 10;

    /* renamed from: b0, reason: collision with root package name */
    protected int f18948b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    protected int f18949c0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298861, "学期：" + JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.J(2131298991, JsonParse.getString(stringObjectMap, "sysUserUserNum"));
            holder.J(2131299116, JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131299093, JsonParse.getString(stringObjectMap, "score"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            ViewTermActivity.this.startActivity(new Intent(((BaseActivity) ViewTermActivity.this).T, (Class<?>) AllScoreForTeamActivity.class).putExtra("stuName", JsonParse.getString((Map) ViewTermActivity.this.Z.getItem(position), "sysUserName")).putExtra("stuNum", JsonParse.getString((Map) ViewTermActivity.this.Z.getItem(position), "sysUserUserNum")).putExtra("stuTeamScoreId", JsonParse.getString((Map) ViewTermActivity.this.Z.getItem(position), "id")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements e {
        c() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            viewTermActivity.f18948b0 = 1;
            viewTermActivity.l0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            int i6 = viewTermActivity.f18949c0;
            int i7 = viewTermActivity.f18947a0;
            int i8 = i6 / i7;
            int i9 = viewTermActivity.f18948b0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                viewTermActivity.W.Q();
                Toast.makeText(((BaseActivity) ViewTermActivity.this).T, "没有了", 0).show();
            } else {
                viewTermActivity.f18948b0 = i9 + 1;
                viewTermActivity.l0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewTermActivity.this.f18949c0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d6 = ViewTermActivity.this.Z.d();
            if (ViewTermActivity.this.f18948b0 != 1) {
                d6.addAll(list);
                list = d6;
            }
            ViewTermActivity.this.Z.g(list);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewTermActivity.this.W.Y();
            ViewTermActivity.this.W.Q();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T, 1, false));
        a aVar = new a(this.T, R.layout.item_for_term_score_list, this.Y);
        this.Z = aVar;
        this.X.setAdapter(aVar);
        m0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("查看学期总分");
    }

    public void l0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).M(LoginUser.getLoginUser().getUserId(), this.f18948b0, this.f18947a0)).setDataListener(new d());
    }

    public void m0() {
        this.W.D(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131492999;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (RecyclerView) findViewById(2131298351);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
