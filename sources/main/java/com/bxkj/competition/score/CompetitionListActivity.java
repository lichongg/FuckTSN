package com.bxkj.competition.score;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CompetitionListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private int Z = 1;

    /* renamed from: a0, reason: collision with root package name */
    private int f17294a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private int f17295b0 = 10;

    /* renamed from: c0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17296c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f17297k0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            CompetitionListActivity.this.f17294a0 = 1;
            CompetitionListActivity.this.u0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = CompetitionListActivity.this.Z / CompetitionListActivity.this.f17295b0;
            int i7 = CompetitionListActivity.this.f17294a0;
            if (CompetitionListActivity.this.Z % CompetitionListActivity.this.f17295b0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                CompetitionListActivity.this.W.Q();
                CompetitionListActivity.this.g0("没有了");
            } else {
                CompetitionListActivity.m0(CompetitionListActivity.this);
                CompetitionListActivity.this.u0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ImageView f17300a;

            a(final ImageView val$iv_image) {
                this.f17300a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f17300a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f17300a.getWidth();
                this.f17300a.getHeight();
                return true;
            }
        }

        b(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i6 = R.id.iv_image;
            ImageView imageView = (ImageView) holder.h(i6);
            imageView.getViewTreeObserver().addOnPreDrawListener(new a(imageView));
            holder.s(i6, JsonParse.getString(stringObjectMap, "majorImg"));
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.J(R.id.tv_location, JsonParse.getString(stringObjectMap, "address"));
            holder.J(R.id.tv_time, JsonParse.getString(stringObjectMap, "startDate"));
            int i7 = R.id.tv_day;
            holder.J(i7, "" + JsonParse.getString(stringObjectMap, "diffCurrDay"));
            holder.N(i7, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "diffCurrDay")) ^ true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionListActivity.this.Z = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (CompetitionListActivity.this.f17294a0 == 1) {
                CompetitionListActivity.this.Y = list;
            } else {
                CompetitionListActivity.this.Y.addAll(list);
            }
            CompetitionListActivity.this.f17296c0.g(CompetitionListActivity.this.Y);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CompetitionListActivity.this.W.Y();
            CompetitionListActivity.this.W.Q();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            if (JsonParse.getInt((Map) CompetitionListActivity.this.f17296c0.getItem(position), "hasCompetitions") == 1) {
                CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).T, (Class<?>) CompetitionListActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompetitionListActivity.this.f17296c0.getItem(position), "id")));
            } else {
                CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).T, (Class<?>) CompetitionProjectListActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompetitionListActivity.this.f17296c0.getItem(position), "id")));
            }
        }
    }

    static /* synthetic */ int m0(CompetitionListActivity competitionListActivity) {
        int i6 = competitionListActivity.f17294a0;
        competitionListActivity.f17294a0 = i6 + 1;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).g(this.f17297k0, this.f17294a0, this.f17295b0)).setDataListener(new c());
    }

    private void v0() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.T, R.layout.item_for_competition_list, this.Y);
        this.f17296c0 = bVar;
        this.X.setAdapter(bVar);
        this.X.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void w0() {
        this.W.D(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f17296c0.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_pub_recycle;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("竞赛列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.X = (EmptyRecyclerView) findViewById(R.id.recyclerView);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("competitionId")) {
            this.f17297k0 = getIntent().getStringExtra("competitionId");
        }
        w0();
        v0();
        this.W.F();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
