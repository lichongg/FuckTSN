package com.bxkj.student.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.study.VideoPlayActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class StudyFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView f19513j;

    /* renamed from: k, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19514k;

    /* renamed from: l, reason: collision with root package name */
    private List<Map<String, Object>> f19515l;

    /* renamed from: m, reason: collision with root package name */
    private SmartRefreshLayout f19516m;

    /* renamed from: n, reason: collision with root package name */
    private RecyclerView f19517n;

    /* renamed from: o, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19518o;

    /* renamed from: p, reason: collision with root package name */
    private List<Map<String, Object>> f19519p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private int f19520q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f19521r = 1;

    /* renamed from: s, reason: collision with root package name */
    private int f19522s = 10;

    /* renamed from: t, reason: collision with root package name */
    private int f19523t = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.N(R.id.iv_zan, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME).equals("推荐"));
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.q(R.id.iv, holder.f() == StudyFragment.this.f19520q ? StudyFragment.this.getResources().getDrawable(2131231950) : null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "title"));
            holder.J(R.id.tv_play_num, JsonParse.getString(stringObjectMap, "playNum"));
            holder.J(2131299158, JsonParse.getString(stringObjectMap, "uploadDate"));
            holder.t(2131297182, JsonParse.getString(stringObjectMap, "coverImg"), R.mipmap.icon_play2, R.mipmap.icon_play2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements n2.e {
        c() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            StudyFragment.this.f19521r = 1;
            if (StudyFragment.this.f19519p.isEmpty()) {
                StudyFragment.this.f0();
            } else {
                StudyFragment.this.e0();
            }
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = StudyFragment.this.f19523t / StudyFragment.this.f19522s;
            int i7 = StudyFragment.this.f19521r;
            if (StudyFragment.this.f19523t % StudyFragment.this.f19522s != 0) {
                i6++;
            }
            if (i7 >= i6) {
                StudyFragment.this.f19516m.Q();
                StudyFragment.this.n("没有了");
            } else {
                StudyFragment.this.f19521r++;
                StudyFragment.this.e0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StudyFragment.this.f19515l = JsonParse.getList(data, "data");
            StudyFragment.this.h0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (StudyFragment.this.f19516m.x()) {
                StudyFragment.this.f19516m.Y();
            }
            if (StudyFragment.this.f19516m.isLoading()) {
                StudyFragment.this.f19516m.Q();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StudyFragment.this.f19523t = JsonParse.getInt(data, "total");
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            if (StudyFragment.this.f19521r == 1) {
                StudyFragment.this.f19519p = list;
            } else {
                StudyFragment.this.f19519p.addAll(list);
            }
            StudyFragment.this.f19518o.g(StudyFragment.this.f19519p);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            StudyFragment.this.f19516m.Y();
            StudyFragment.this.f19516m.Q();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        f() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            StudyFragment.this.f19514k.notifyItemChanged(StudyFragment.this.f19520q);
            StudyFragment.this.f19520q = position;
            StudyFragment.this.f19514k.notifyItemChanged(StudyFragment.this.f19520q);
            StudyFragment.this.f19516m.F();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        g() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            StudyFragment.this.startActivity(new Intent(((BaseFragment) StudyFragment.this).f1096g, (Class<?>) VideoPlayActivity.class).putExtra("videoId", JsonParse.getString((Map) StudyFragment.this.f19518o.getItem(position), "id")).putExtra("videoName", JsonParse.getString((Map) StudyFragment.this.f19518o.getItem(position), "title")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        if (this.f19514k.getItemCount() > 0) {
            Http.with(this.f1096g).hideLoadingDialog().setObservable(((x.f) Http.getApiService(x.f.class)).q(LoginUser.getLoginUser().getSchoolId(), "", JsonParse.getString(this.f19514k.getItem(this.f19520q), "id"), this.f19521r, this.f19522s)).setDataListener(new e());
        } else {
            this.f19516m.Y();
            this.f19516m.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        Http.with(this.f1096g).hideLoadingDialog().setObservable(((x.f) Http.getApiService(x.f.class)).d(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId())).setDataListener(new d());
    }

    private void g0() {
        this.f19516m.D(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        HashMap hashMap = new HashMap(10);
        hashMap.put("id", "groom");
        hashMap.put(CommonNetImpl.NAME, "推荐");
        this.f19515l.add(0, hashMap);
        this.f19514k.g(this.f19515l);
        e0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f19514k.k(new f());
        this.f19518o.k(new g());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        this.f19513j.setLayoutManager(new LinearLayoutManager(this.f1096g));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1096g, 2130772096));
        layoutAnimationController.setOrder(0);
        this.f19513j.setLayoutAnimation(layoutAnimationController);
        this.f19513j.addItemDecoration(new DividerItemDecoration(this.f1096g, 1));
        a aVar = new a(this.f1096g, R.layout.item_for_video_type_list, this.f19515l);
        this.f19514k = aVar;
        this.f19513j.setAdapter(aVar);
        this.f19517n.setLayoutManager(new LinearLayoutManager(this.f1096g));
        LayoutAnimationController layoutAnimationController2 = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1096g, 2130772096));
        layoutAnimationController2.setOrder(0);
        this.f19517n.setLayoutAnimation(layoutAnimationController2);
        b bVar = new b(this.f1096g, R.layout.item_for_video_list, this.f19519p);
        this.f19518o = bVar;
        this.f19517n.setAdapter(bVar);
        g0();
        f0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19513j = (RecyclerView) c(R.id.rv_type);
        this.f19517n = (RecyclerView) c(R.id.rv_video_list);
        this.f19516m = (SmartRefreshLayout) c(2131298353);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_discover;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
