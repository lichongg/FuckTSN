package com.bxkj.competition.newsletter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
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
import com.bxkj.competition.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class NewsLetterListActivity extends BaseActivity {
    private String F0;
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private Button Z;

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f17284a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private int f17285b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    private int f17286c0 = 1;

    /* renamed from: k0, reason: collision with root package name */
    private int f17287k0 = 10;

    /* renamed from: p0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17288p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            NewsLetterListActivity.this.f17286c0 = 1;
            NewsLetterListActivity.this.t0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = NewsLetterListActivity.this.f17285b0 / NewsLetterListActivity.this.f17287k0;
            int i7 = NewsLetterListActivity.this.f17286c0;
            if (NewsLetterListActivity.this.f17285b0 % NewsLetterListActivity.this.f17287k0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                NewsLetterListActivity.this.W.Q();
                NewsLetterListActivity.this.g0("没有了");
            } else {
                NewsLetterListActivity.m0(NewsLetterListActivity.this);
                NewsLetterListActivity.this.t0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "content"));
            holder.J(R.id.tv_status, JsonParse.getString(stringObjectMap, "auditState"));
            holder.J(R.id.tv_time, JsonParse.getString(stringObjectMap, "publishDate"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            NewsLetterListActivity.this.f17285b0 = JsonParse.getInt(data, "total");
            List list = (List) data.get("data");
            if (NewsLetterListActivity.this.f17286c0 == 1) {
                NewsLetterListActivity.this.f17284a0 = list;
            } else {
                NewsLetterListActivity.this.f17284a0.addAll(list);
            }
            NewsLetterListActivity.this.f17288p0.g(NewsLetterListActivity.this.f17284a0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            NewsLetterListActivity.this.W.Y();
            NewsLetterListActivity.this.W.Q();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            NewsLetterListActivity.this.startActivity(new Intent(((BaseActivity) NewsLetterListActivity.this).T, (Class<?>) PostActivity.class).putExtra("content", JsonParse.getString((Map) NewsLetterListActivity.this.f17288p0.getItem(position), "content")));
        }
    }

    static /* synthetic */ int m0(NewsLetterListActivity newsLetterListActivity) {
        int i6 = newsLetterListActivity.f17286c0;
        newsLetterListActivity.f17286c0 = i6 + 1;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).q(this.F0, LoginUser.getLoginUser().getUserId(), this.f17286c0, this.f17287k0)).setDataListener(new c());
    }

    private void u0() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.T, R.layout.item_for_newsletter, this.f17284a0);
        this.f17288p0 = bVar;
        this.X.setAdapter(bVar);
        this.X.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void v0() {
        this.W.D(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f17288p0.k(new d());
        this.Z.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_my_newsletter_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的通讯稿");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.X = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.Y = (TextView) findViewById(R.id.tv_emptyView);
        this.Z = (Button) findViewById(R.id.bt_post);
    }

    public void w0() {
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("competitionId")) {
            this.F0 = getIntent().getStringExtra("competitionId");
        }
        v0();
        u0();
        this.W.F();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() == R.id.bt_post) {
            startActivity(new Intent(this.T, (Class<?>) PostActivity.class).putExtra("competitionId", this.F0));
        }
    }
}
