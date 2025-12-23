package com.bxkj.student.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.R;
import com.bxkj.student.life.info.InfoAdapter;
import com.bxkj.student.life.lost.LostHomeActivity;
import com.bxkj.student.life.mall.MallHomeActivity;
import com.bxkj.student.life.secondhand.SecondHandHomeActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LifeFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private SmartRefreshLayout f19474j;

    /* renamed from: k, reason: collision with root package name */
    private RecyclerView f19475k;

    /* renamed from: l, reason: collision with root package name */
    private RecyclerView f19476l;

    /* renamed from: m, reason: collision with root package name */
    private RadioGroup f19477m;

    /* renamed from: n, reason: collision with root package name */
    private ViewFlipper f19478n;

    /* renamed from: o, reason: collision with root package name */
    private List<Map<String, Object>> f19479o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    private CommonAdapter f19480p;

    /* renamed from: q, reason: collision with root package name */
    private int f19481q;

    /* renamed from: r, reason: collision with root package name */
    private GridLayoutManager f19482r;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            ((LinearLayout) holder.h(2131298068)).setLayoutParams(new GridLayoutManager.LayoutParams(LifeFragment.this.f19481q / 5, -2));
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.r(2131297155, JsonParse.getInt(stringObjectMap, "icon"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                LifeFragment.this.f19477m.check(LifeFragment.this.f19477m.getChildAt(LifeFragment.this.f19482r.findFirstCompletelyVisibleItemPosition() / 8).getId());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        c() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            String string = JsonParse.getString((Map) LifeFragment.this.f19479o.get(position), CommonNetImpl.NAME);
            if ("二手".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1096g, (Class<?>) SecondHandHomeActivity.class));
                return;
            }
            if ("失物寻物".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1096g, (Class<?>) LostHomeActivity.class));
            } else if ("商城".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1096g, (Class<?>) MallHomeActivity.class));
            } else if ("信用卡".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1096g, (Class<?>) H5DetailActivity.class).putExtra("title", "信用卡").putExtra("url", "https://creditcard.cmbc.com.cn/wsv2/?enstr=mSlA1zunTrPHh1CNz0K26zHw9V4feo2mlV1iATEE7Om%2fRx%2bHsklTDhmmcRO8Spw%2fVNOSkibHiNRP4zHyQCMkYWagHJgFtpZReRk3CXCdInmujzIcAVgLR2YbcigxNezwK98LyuBxEd6v9lR6pXeUYFmHqWtkAkYnClJ3qMsNz%2fg1rumE1ZWWqvLhQvudXiusJphdDwavqBkDd5zkNBX5NjwSNUdkp39ETXOSUvw1%2fFkFhSi%2f5NEuBauZCSWLx2eblhb4dhkfmk3gCyxuIGmKBl4FMYVUPtz10QxgfcJSfODLI0nyOvZwP8C81spE1BHd1u%2bxf7QdhQawfkIzwOUs9Q%3d%3d"));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements n2.d {
        d() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            LifeFragment.this.a0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            LifeFragment.this.f19476l.setLayoutManager(new LinearLayoutManager(((BaseFragment) LifeFragment.this).f1096g));
            LifeFragment.this.f19476l.setAdapter(new InfoAdapter(((BaseFragment) LifeFragment.this).f1096g, list));
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (LifeFragment.this.f19474j != null && LifeFragment.this.f19474j.x()) {
                LifeFragment.this.f19474j.Y();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends CommonAdapter<Map<String, Object>> {
        f(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
        }
    }

    private void d0() {
        for (int i6 = 0; i6 < 5; i6++) {
            this.f19478n.addView(View.inflate(this.f1096g, R.layout.item_for_life_center_ad, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        Http.with(this.f1096g).hideLoadingDialog().setObservable(((x.c) Http.getApiService(x.c.class)).b(10, 1)).setDataListener(new e());
    }

    private void b0() {
        this.f19474j.v(false);
        this.f19474j.p(new d());
    }

    private void c0() {
        this.f19476l.setLayoutManager(new GridLayoutManager(this.f1096g, 2));
        this.f19476l.setAdapter(new f(this.f1096g, R.layout.item_for_goods, this.f19479o));
        this.f19476l.addItemDecoration(new DividerItemDecoration(this.f1096g, 0));
        this.f19476l.addItemDecoration(new DividerItemDecoration(this.f1096g, 1));
    }

    private void e0() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "资讯");
        arrayMap.put("icon", Integer.valueOf(R.mipmap.icon_info));
        this.f19479o.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(CommonNetImpl.NAME, "商城");
        arrayMap2.put("icon", Integer.valueOf(R.mipmap.icon_mall));
        this.f19479o.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put(CommonNetImpl.NAME, "二手");
        arrayMap3.put("icon", Integer.valueOf(R.mipmap.icon_pick));
        this.f19479o.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put(CommonNetImpl.NAME, "跑腿");
        arrayMap4.put("icon", Integer.valueOf(R.mipmap.icon_runner));
        this.f19479o.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put(CommonNetImpl.NAME, "失物寻物");
        arrayMap5.put("icon", Integer.valueOf(R.mipmap.icon_buy));
        this.f19479o.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put(CommonNetImpl.NAME, "招聘求职");
        arrayMap6.put("icon", Integer.valueOf(R.mipmap.icon_job));
        this.f19479o.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put(CommonNetImpl.NAME, "捐赠寄卖");
        arrayMap7.put("icon", Integer.valueOf(R.mipmap.icon_arts));
        this.f19479o.add(arrayMap7);
        ArrayMap arrayMap8 = new ArrayMap();
        arrayMap8.put(CommonNetImpl.NAME, "直播");
        arrayMap8.put("icon", Integer.valueOf(R.mipmap.icon_live));
        this.f19479o.add(arrayMap8);
        ArrayMap arrayMap9 = new ArrayMap();
        arrayMap9.put(CommonNetImpl.NAME, "信用卡");
        arrayMap9.put("icon", Integer.valueOf(R.mipmap.icon_recharge));
        this.f19479o.add(arrayMap9);
        ArrayMap arrayMap10 = new ArrayMap();
        arrayMap10.put(CommonNetImpl.NAME, "圈子");
        arrayMap10.put("icon", Integer.valueOf(R.mipmap.icon_circle));
        this.f19479o.add(arrayMap10);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f1096g, 2, 0, false);
        this.f19482r = gridLayoutManager;
        this.f19475k.setLayoutManager(gridLayoutManager);
        a aVar = new a(this.f1096g, R.layout.item_for_life_menu, this.f19479o);
        this.f19480p = aVar;
        this.f19475k.setAdapter(aVar);
        int i6 = 0;
        while (true) {
            if (i6 >= (this.f19480p.getItemCount() / 10) + (this.f19480p.getItemCount() % 10 == 0 ? 0 : 1)) {
                RadioGroup radioGroup = this.f19477m;
                radioGroup.check(radioGroup.getChildAt(0).getId());
                this.f19475k.addOnScrollListener(new b());
                return;
            }
            RadioButton radioButton = new RadioButton(this.f1096g);
            radioButton.setButtonDrawable(R.drawable.rb_dot);
            radioButton.setClickable(false);
            radioButton.setFocusable(false);
            radioButton.setFocusableInTouchMode(false);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(u.a(5.0f, this.f1096g), u.a(5.0f, this.f1096g));
            layoutParams.rightMargin = u.a(5.0f, this.f1096g);
            radioButton.setLayoutParams(layoutParams);
            this.f19477m.addView(radioButton);
            i6++;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f19480p.k(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        e0();
        d0();
        b0();
        this.f19474j.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19474j = (SmartRefreshLayout) c(R.id.smartRefresh);
        this.f19475k = (RecyclerView) c(R.id.rv_menu);
        this.f19477m = (RadioGroup) c(R.id.rg_dots);
        this.f19478n = (ViewFlipper) c(2131299252);
        this.f19476l = (RecyclerView) c(R.id.rv_bottom);
        this.f19481q = u.K(this.f1096g)[0];
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_life;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
