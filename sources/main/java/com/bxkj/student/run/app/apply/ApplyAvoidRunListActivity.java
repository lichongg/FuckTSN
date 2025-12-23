package com.bxkj.student.run.app.apply;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyAvoidRunListActivity extends BaseActivity {
    private List<Map<String, Object>> W = new ArrayList();
    private EmptyRecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;
    private SmartRefreshLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19770a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "userName"));
            holder.J(R.id.tv_team, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.J(2131299116, JsonParse.getString(stringObjectMap, "avoidRunningState"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyAvoidRunListActivity.this.W = JsonParse.getList(data, "data");
            ApplyAvoidRunListActivity.this.Y.g(ApplyAvoidRunListActivity.this.W);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(ViewGroup viewGroup, View view, Object obj, int i6) {
        startActivity(new Intent(this.T, (Class<?>) ApplyAvoidRunDetailActivity.class).putExtra("id", JsonParse.getString(this.Y.getItem(i6), "id")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0() {
        startActivity(new Intent(this.T, (Class<?>) ApplyAvoidRunActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.run.app.apply.c
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                ApplyAvoidRunListActivity.this.n0(viewGroup, view, obj, i6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_apply_mc_list, this.W);
        this.Y = aVar;
        this.X.setAdapter(aVar);
        this.f19770a0.setText("暂无申请数据,点击右上角+号申请免跑");
        this.X.setEmptyView(this.f19770a0);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("申请免跑列表");
        a0(2131231169, new BaseActivity.c() { // from class: com.bxkj.student.run.app.apply.d
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                ApplyAvoidRunListActivity.this.o0();
            }
        });
    }

    public void m0() {
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).i(LoginUser.getLoginUser().getUserId(), 1, 100)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493640;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.f19770a0 = (TextView) findViewById(2131298892);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById(2131298352);
        this.Z = smartRefreshLayout;
        smartRefreshLayout.h0(false);
        this.Z.v(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
