package com.bxkj.student.life.secondhand;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.a;
import com.bxkj.student.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import x.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SecondHandListFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private SmartRefreshLayout f19416j;

    /* renamed from: k, reason: collision with root package name */
    private EmptyRecyclerView f19417k;

    /* renamed from: l, reason: collision with root package name */
    private FloatingActionButton f19418l;

    /* renamed from: m, reason: collision with root package name */
    private FloatingActionButton f19419m;

    /* renamed from: n, reason: collision with root package name */
    private FloatingActionButton f19420n;

    /* renamed from: o, reason: collision with root package name */
    private FloatingActionButton f19421o;

    /* renamed from: p, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19422p;

    /* renamed from: q, reason: collision with root package name */
    private List<Map<String, Object>> f19423q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    private int f19424r = 1;

    /* renamed from: s, reason: collision with root package name */
    private int f19425s = 15;

    /* renamed from: t, reason: collision with root package name */
    private int f19426t = 0;

    /* renamed from: u, reason: collision with root package name */
    private final int f19427u = 80;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$a$a, reason: collision with other inner class name */
        class C0261a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0261a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(ViewHolder holder, String s5) {
                holder.t(R.id.iv_img, s5, 2131689689, 2131689689);
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298946, JsonParse.getString(stringObjectMap, SocialConstants.PARAM_COMMENT));
            holder.J(2131299158, "时间：" + JsonParse.getString(stringObjectMap, "publishTime"));
            holder.J(2131299047, "价格：" + JsonParse.getString(stringObjectMap, "price"));
            holder.J(R.id.tv_buy_type, JsonParse.getInt(stringObjectMap, "buyOrSell") == 1 ? "卖" : "买");
            holder.k(R.id.tv_buy_type, JsonParse.getInt(stringObjectMap, "buyOrSell") == 1 ? ContextCompat.getColor(this.f1138e, 2131099719) : ContextCompat.getColor(this.f1138e, 2131099714));
            GridView gridView = (GridView) holder.h(R.id.gv_img);
            gridView.setEnabled(false);
            gridView.setPressed(false);
            gridView.setClickable(false);
            gridView.setAdapter((ListAdapter) new C0261a(this.f1138e, R.layout.item_for_lost_img, JsonParse.getList(stringObjectMap, SocialConstants.PARAM_IMG_URL, String.class)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements a.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f19431a;

            a(final int val$position) {
                this.f19431a = val$position;
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1096g, (Class<?>) BuyDetailActivity.class).putExtra("noticeId", JsonParse.getString((Map) SecondHandListFragment.this.f19422p.getItem(this.f19431a), "id")).putExtra("buyType", JsonParse.getInt((Map) SecondHandListFragment.this.f19422p.getItem(this.f19431a), "buyOrSell")));
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, final int position) {
            new com.bxkj.base.auth.a(((BaseFragment) SecondHandListFragment.this).f1096g).i(new a(position)).b(SecondHandListFragment.this.getChildFragmentManager(), 2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements a.g {
        c() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1096g, (Class<?>) PublishBuyActivity.class).putExtra("type", 0));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements a.g {
        d() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1096g, (Class<?>) PublishBuyActivity.class).putExtra("type", 1));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements a.g {
        e() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1096g, (Class<?>) MyBuyGoodsActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements n2.e {
        f() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            SecondHandListFragment.this.f19424r = 1;
            SecondHandListFragment.this.c0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = SecondHandListFragment.this.f19426t / SecondHandListFragment.this.f19425s;
            int i7 = SecondHandListFragment.this.f19424r;
            if (SecondHandListFragment.this.f19426t % SecondHandListFragment.this.f19425s != 0) {
                i6++;
            }
            if (i7 >= i6) {
                SecondHandListFragment.this.f19416j.Q();
                SecondHandListFragment.this.n("没有了");
            } else {
                SecondHandListFragment.this.f19424r++;
                SecondHandListFragment.this.c0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SecondHandListFragment.this.f19426t = JsonParse.getInt(data, "total");
            if (SecondHandListFragment.this.f19424r == 1) {
                SecondHandListFragment.this.f19423q.clear();
            }
            SecondHandListFragment.this.f19423q.addAll(JsonParse.getList(data, "data"));
            SecondHandListFragment.this.f19422p.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (SecondHandListFragment.this.f19416j != null && SecondHandListFragment.this.f19416j.x()) {
                SecondHandListFragment.this.f19416j.Y();
            }
            if (SecondHandListFragment.this.f19416j != null && SecondHandListFragment.this.f19416j.isLoading()) {
                SecondHandListFragment.this.f19416j.Q();
            }
        }
    }

    private void b0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19418l, "rotation", 45.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f19421o, "translationY", -u.a(240.0f, this.f1096g), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f19419m, "translationY", -u.a(160.0f, this.f1096g), 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f19420n, "translationY", -u.a(80.0f, this.f1096g), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        Http.with(this.f1096g).hideLoadingDialog().setObservable(((i) Http.getApiService(i.class)).d(this.f19424r, this.f19425s)).setDataListener(new g());
    }

    private void d0() {
        this.f19416j.D(new f());
    }

    private void e0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19418l, "rotation", 0.0f, 45.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f19421o, "translationY", 0.0f, -u.a(240.0f, this.f1096g));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f19419m, "translationY", 0.0f, -u.a(160.0f, this.f1096g));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f19420n, "translationY", 0.0f, -u.a(80.0f, this.f1096g));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f19418l.setOnClickListener(this);
        this.f19419m.setOnClickListener(this);
        this.f19420n.setOnClickListener(this);
        this.f19421o.setOnClickListener(this);
        this.f19422p.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        this.f19417k.setLayoutManager(new LinearLayoutManager(this.f1096g));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1096g, 2130772096));
        layoutAnimationController.setOrder(0);
        this.f19417k.setLayoutAnimation(layoutAnimationController);
        this.f19417k.addItemDecoration(new DividerItemDecoration(this.f1096g, 1));
        a aVar = new a(this.f1096g, R.layout.item_for_sencond_hand, this.f19423q);
        this.f19422p = aVar;
        this.f19417k.setAdapter(aVar);
        this.f19417k.setEmptyView(c(2131298892));
        d0();
        f0();
    }

    public void f0() {
        this.f19416j.F();
    }

    public Bitmap g0(String text, float textSize, int textColor) {
        Paint paint = new Paint(1);
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.LEFT);
        float f6 = -paint.ascent();
        Bitmap createBitmap = Bitmap.createBitmap((int) (paint.measureText(text) + 0.0f), (int) (paint.descent() + f6 + 0.0f), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawText(text, 0.0f, f6, paint);
        return createBitmap;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19416j = (SmartRefreshLayout) c(2131298353);
        this.f19417k = (EmptyRecyclerView) c(R.id.rv_goods_list);
        this.f19418l = (FloatingActionButton) c(2131296965);
        this.f19419m = (FloatingActionButton) c(R.id.fab_lost);
        this.f19420n = (FloatingActionButton) c(R.id.fab_pick);
        this.f19421o = (FloatingActionButton) c(R.id.fab_my);
        this.f19419m.setImageBitmap(g0("买", 40.0f, -1));
        this.f19420n.setImageBitmap(g0("卖", 40.0f, -1));
        this.f19421o.setImageBitmap(g0("我的", 40.0f, -1));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_lost_goods_list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        switch (v5.getId()) {
            case 2131296965:
                if (this.f19418l.getTag() == null) {
                    e0();
                    this.f19418l.setTag("open");
                    break;
                } else {
                    b0();
                    this.f19418l.setTag(null);
                    break;
                }
            case R.id.fab_lost /* 2131296966 */:
                new com.bxkj.base.auth.a(this.f1096g).i(new c()).b(getChildFragmentManager(), 2);
                break;
            case R.id.fab_my /* 2131296967 */:
                new com.bxkj.base.auth.a(this.f1096g).i(new e()).b(getChildFragmentManager(), 2);
                break;
            case R.id.fab_pick /* 2131296968 */:
                new com.bxkj.base.auth.a(this.f1096g).i(new d()).b(getChildFragmentManager(), 2);
                break;
        }
    }
}
