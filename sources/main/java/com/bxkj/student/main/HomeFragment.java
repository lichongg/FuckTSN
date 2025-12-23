package com.bxkj.student.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.R;
import com.orhanobut.logger.j;
import com.qq.e.comm.constants.Constants;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m2.h;
import okhttp3.ResponseBody;
import rx.l;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class HomeFragment extends BaseFragment {

    /* renamed from: k, reason: collision with root package name */
    private SmartRefreshLayout f19457k;

    /* renamed from: l, reason: collision with root package name */
    private ViewFlipper f19458l;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f19459m;

    /* renamed from: n, reason: collision with root package name */
    private CycleViewPager f19460n;

    /* renamed from: o, reason: collision with root package name */
    private RecyclerView f19461o;

    /* renamed from: q, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19463q;

    /* renamed from: j, reason: collision with root package name */
    private final String f19456j = "groupType";

    /* renamed from: p, reason: collision with root package name */
    private List<Map<String, Object>> f19462p = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.r(2131297155, HomeFragment.this.Y(JsonParse.getString(stringObjectMap, "icon")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HomeFragment.this.b0(JsonParse.getList(data, "data"));
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (HomeFragment.this.f19457k != null && HomeFragment.this.f19457k.x()) {
                HomeFragment.this.f19457k.Y();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19467a;

            a(final Map val$stringObjectMap) {
                this.f19467a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                Intent intent = new Intent(((BaseFragment) HomeFragment.this).f1096g, (Class<?>) H5DetailActivity.class);
                intent.putExtra("title", u.O(this.f19467a, "title"));
                intent.putExtra("url", u.O(this.f19467a, "url"));
                HomeFragment.this.startActivity(intent);
            }
        }

        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HomeFragment.this.f19458l.removeAllViews();
            for (Map map : (List) data.get("data")) {
                View inflate = View.inflate(((BaseFragment) HomeFragment.this).f1096g, R.layout.item_notice, null);
                TextView textView = (TextView) inflate.findViewById(2131299164);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_not_read);
                int i6 = 8;
                inflate.findViewById(2131297100).setVisibility(8);
                textView.setText(u.O(map, "title"));
                if (u.O(map, "isread").equals("0")) {
                    i6 = 0;
                }
                imageView.setVisibility(i6);
                inflate.setOnClickListener(new a(map));
                HomeFragment.this.f19458l.addView(inflate);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            new com.bxkj.student.home.d(HomeFragment.this.getActivity(), JsonParse.getString((Map) HomeFragment.this.f19463q.getItem(position), "icon"), JsonParse.getString((Map) HomeFragment.this.f19463q.getItem(position), CommonNetImpl.NAME)).f();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements n2.d {
        e() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            HomeFragment.this.W();
            HomeFragment.this.X();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements CycleViewPager.ImageCycleViewListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f19471a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends l<ResponseBody> {
            a() {
            }

            @Override // rx.f
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public void onNext(ResponseBody responseBody) {
                j.c("onNext=" + responseBody.toString());
            }

            @Override // rx.f
            public void onCompleted() {
                j.c("onCompleted");
            }

            @Override // rx.f
            public void onError(Throwable e6) {
                e6.printStackTrace();
                j.c("Throwable");
            }
        }

        f(final List val$ads) {
            this.f19471a = val$ads;
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewListener
        public void onImageClick(String url, int position, View imageView) {
            List list = this.f19471a;
            if (list == null || list.size() <= position) {
                return;
            }
            Intent intent = new Intent(((BaseFragment) HomeFragment.this).f1096g, (Class<?>) H5DetailActivity.class);
            intent.putExtra("url", JsonParse.getString((Map) this.f19471a.get(position), Constants.KEYS.EXPOSED_CLICK_URL_KEY));
            intent.putExtra("title", JsonParse.getString((Map) this.f19471a.get(position), "titleName"));
            HomeFragment.this.startActivity(intent);
            ((x.f) Http.getApiService(x.f.class)).v(JsonParse.getString((Map) this.f19471a.get(0), "id"), LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId()).w5(rx.schedulers.c.e()).I3(rx.android.schedulers.a.b()).r5(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Http.with(this.f1096g).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).r0()).setDataListener(new b());
    }

    private void a0() {
        this.f19457k.v(false);
        this.f19457k.p(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(final List<Map<String, Object>> ads) {
        ArrayList arrayList = new ArrayList();
        if (ads != null && ads.size() != 0) {
            Iterator<Map<String, Object>> it = ads.iterator();
            while (it.hasNext()) {
                arrayList.add(JsonParse.getString(it.next(), "announcementUrl"));
            }
            this.f19460n.setData(arrayList, new f(ads));
        }
        this.f19460n.setIndicators(2131231120, 2131231121);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f19463q.k(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (!LoginUser.getLoginUser().isLogin()) {
            this.f19458l.removeAllViews();
            return;
        }
        com.bxkj.student.common.jpush.a.f17746a.d(LoginUser.getLoginUser().getSchoolId() + "_" + LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().isLogin());
        Http.with(this.f1096g).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).l1(LoginUser.getLoginUser().getUserId(), "0", 1, 10)).setDataListener(new c());
    }

    public int Y(String imageName) {
        int identifier = getResources().getIdentifier(imageName, ResIdentify.RES_TYPE_MIPMAP, this.f1096g.getPackageName());
        if (imageName.equals("ic_home_word")) {
            return getResources().getIdentifier(imageName, ResIdentify.RES_TYPE_DRAWABLE, this.f1096g.getPackageName());
        }
        return identifier;
    }

    public void Z() {
        this.f19462p = com.bxkj.student.home.a.b().c();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "更多");
        arrayMap.put("icon", "icon_more2");
        arrayMap.put("type", 2);
        arrayMap.put("groupType", -1);
        this.f19462p.add(arrayMap);
        this.f19463q.g(this.f19462p);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        try {
            W();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f19459m.setLayoutManager(new GridLayoutManager(this.f1096g, 4));
        a aVar = new a(this.f1096g, R.layout.item_for_home_menu, this.f19462p);
        this.f19463q = aVar;
        this.f19459m.setAdapter(aVar);
        Z();
        a0();
        X();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19458l = (ViewFlipper) c(2131299252);
        this.f19457k = (SmartRefreshLayout) c(2131298353);
        this.f19459m = (RecyclerView) c(2131298351);
        this.f19460n = (CycleViewPager) c(2131296829);
        this.f19461o = (RecyclerView) c(R.id.rv_info);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1096g, 2130772096));
        layoutAnimationController.setOrder(0);
        this.f19459m.setLayoutAnimation(layoutAnimationController);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_home;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f19458l.stopFlipping();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        X();
        this.f19458l.startFlipping();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
