package com.bxkj.student.life.secondhand;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.a;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;
import x.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyBuyGoodsActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private FloatingActionButton Y;
    private FloatingActionButton Z;

    /* renamed from: a0, reason: collision with root package name */
    private FloatingActionButton f19396a0;

    /* renamed from: b0, reason: collision with root package name */
    private FloatingActionButton f19397b0;

    /* renamed from: c0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19398c0;

    /* renamed from: k0, reason: collision with root package name */
    private List<Map<String, Object>> f19399k0 = new ArrayList();

    /* renamed from: p0, reason: collision with root package name */
    private int f19400p0 = 1;
    private int F0 = 10;
    private int G0 = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.secondhand.MyBuyGoodsActivity$a$a, reason: collision with other inner class name */
        class C0260a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0260a(Context context, int layoutId, List datas) {
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
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String str;
            int color;
            holder.N(2131299116, true);
            holder.J(2131299116, JsonParse.getString(stringObjectMap, NotificationCompat.CATEGORY_STATUS));
            holder.J(2131298946, JsonParse.getString(stringObjectMap, SocialConstants.PARAM_COMMENT));
            holder.J(2131299158, "时间：" + JsonParse.getString(stringObjectMap, "publishTime"));
            if (JsonParse.getInt(stringObjectMap, "buyOrSell") == 1) {
                str = "卖";
            } else {
                str = "买";
            }
            holder.J(R.id.tv_buy_type, str);
            if (JsonParse.getInt(stringObjectMap, "buyOrSell") == 1) {
                color = ContextCompat.getColor(this.f1138e, 2131099719);
            } else {
                color = ContextCompat.getColor(this.f1138e, 2131099714);
            }
            holder.k(R.id.tv_buy_type, color);
            GridView gridView = (GridView) holder.h(R.id.gv_img);
            gridView.setEnabled(false);
            gridView.setPressed(false);
            gridView.setClickable(false);
            gridView.setAdapter((ListAdapter) new C0260a(this.f1138e, R.layout.item_for_lost_img, JsonParse.getList(stringObjectMap, SocialConstants.PARAM_IMG_URL, String.class)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements a.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f19404a;

            a(final int val$position) {
                this.f19404a = val$position;
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                MyBuyGoodsActivity.this.startActivity(new Intent(((BaseActivity) MyBuyGoodsActivity.this).T, (Class<?>) BuyDetailActivity.class).putExtra("noticeId", JsonParse.getString((Map) MyBuyGoodsActivity.this.f19398c0.getItem(this.f19404a), "id")).putExtra("buyType", JsonParse.getInt((Map) MyBuyGoodsActivity.this.f19398c0.getItem(this.f19404a), "buyOrSell")));
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, final int position) {
            new com.bxkj.base.auth.a(((BaseActivity) MyBuyGoodsActivity.this).T).i(new a(position)).b(MyBuyGoodsActivity.this.getSupportFragmentManager(), 1);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements e {
        c() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            MyBuyGoodsActivity.this.f19400p0 = 1;
            MyBuyGoodsActivity.this.s0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = MyBuyGoodsActivity.this.G0 / MyBuyGoodsActivity.this.F0;
            int i7 = MyBuyGoodsActivity.this.f19400p0;
            if (MyBuyGoodsActivity.this.G0 % MyBuyGoodsActivity.this.F0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                MyBuyGoodsActivity.this.W.Q();
                MyBuyGoodsActivity.this.g0("没有了");
            } else {
                MyBuyGoodsActivity.this.f19400p0++;
                MyBuyGoodsActivity.this.s0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyBuyGoodsActivity.this.G0 = JsonParse.getInt(data, "total");
            if (MyBuyGoodsActivity.this.f19400p0 == 1) {
                MyBuyGoodsActivity.this.f19399k0.clear();
            }
            MyBuyGoodsActivity.this.f19399k0.addAll(JsonParse.getList(data, "data"));
            MyBuyGoodsActivity.this.f19398c0.notifyDataSetChanged();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyBuyGoodsActivity.this.W != null && MyBuyGoodsActivity.this.W.x()) {
                MyBuyGoodsActivity.this.W.Y();
            }
            if (MyBuyGoodsActivity.this.W != null && MyBuyGoodsActivity.this.W.isLoading()) {
                MyBuyGoodsActivity.this.W.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((i) Http.getApiService(i.class)).c(LoginUser.getLoginUser().getOpenId(), this.f19400p0, this.F0)).setDataListener(new d());
    }

    private void t0() {
        this.W.D(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f19398c0.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        this.X.addItemDecoration(new DividerItemDecoration(this.T, 1));
        a aVar = new a(this.T, R.layout.item_for_sencond_hand, this.f19399k0);
        this.f19398c0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(findViewById(2131298892));
        t0();
        u0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的发布");
    }

    public void u0() {
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.fm_lost_goods_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298353);
        this.X = (EmptyRecyclerView) findViewById(R.id.rv_goods_list);
        this.Y = (FloatingActionButton) findViewById(2131296965);
        this.Z = (FloatingActionButton) findViewById(R.id.fab_lost);
        this.f19396a0 = (FloatingActionButton) findViewById(R.id.fab_pick);
        this.f19397b0 = (FloatingActionButton) findViewById(R.id.fab_my);
        this.Y.setVisibility(8);
        this.Z.setVisibility(8);
        this.f19396a0.setVisibility(8);
        this.f19397b0.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        v5.getId();
    }
}
