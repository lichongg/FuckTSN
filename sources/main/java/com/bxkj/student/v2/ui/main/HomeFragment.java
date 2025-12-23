package com.bxkj.student.v2.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.common.view.CycleViewPager;
import com.bxkj.base.v2.data.UserType;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V2ItemForHomeMenuBinding;
import com.bxkj.student.databinding.V2MainTabHomeFragmentBinding;
import com.bxkj.student.v2.common.utils.w;
import com.bxkj.student.v2.ui.h5.js.JS;
import com.bxkj.student.v2.vm.MainViewModel;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHomeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeFragment.kt\ncom/bxkj/student/v2/ui/main/HomeFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,167:1\n1#2:168\n1563#3:169\n1634#3,3:170\n774#3:173\n865#3,2:174\n1869#3,2:176\n*S KotlinDebug\n*F\n+ 1 HomeFragment.kt\ncom/bxkj/student/v2/ui/main/HomeFragment\n*L\n67#1:169\n67#1:170,3\n119#1:173\n119#1:174,2\n119#1:176,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class HomeFragment extends BaseFragment<V2MainTabHomeFragmentBinding, MainViewModel> {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private List<Map<String, Object>> f21477l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> f21478m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21479a;

        a(Function1 function) {
            g0.p(function, "function");
            this.f21479a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof b0)) {
                return g0.g(getFunctionDelegate(), ((b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final n<?> getFunctionDelegate() {
            return this.f21479a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21479a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(HomeFragment homeFragment, List list) {
        homeFragment.f21477l.clear();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (g0.g(c0.f16887a.t((Map) obj, "isShow"), "1")) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                homeFragment.f21477l.add((Map) it.next());
            }
        }
        if ((com.bxkj.base.v2.data.b.f16998d.a().T() == UserType.STUDENT ? homeFragment : null) != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(CommonNetImpl.NAME, "更多");
            linkedHashMap.put("icon", Integer.valueOf(R.mipmap.v2_home_menu_more));
            linkedHashMap.put("isEnabled", 1);
            linkedHashMap.put("isLogin", Boolean.FALSE);
            linkedHashMap.put("mkey", "app_home_menu_more");
            homeFragment.f21477l.add(linkedHashMap);
        }
        BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> baseAdapter = homeFragment.f21478m;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 m(HomeFragment homeFragment, String str) {
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        g0.m(str);
        String a6 = iVar.a(str);
        com.orhanobut.logger.j.d("加载首页咨询地址：" + a6, new Object[0]);
        homeFragment.L().smartWebView.j("about:blank");
        homeFragment.L().smartWebView.j(a6);
        return n1.f44123a;
    }

    public final void O(@Nullable BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> baseAdapter) {
        this.f21478m = baseAdapter;
    }

    public final void P(@NotNull List<Map<String, Object>> list) {
        g0.p(list, "<set-?>");
        this.f21477l = list;
    }

    @Nullable
    public final BaseAdapter<Map<String, Object>, V2ItemForHomeMenuBinding> i() {
        return this.f21478m;
    }

    @NotNull
    public final List<Map<String, Object>> j() {
        return this.f21477l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void M(HomeFragment homeFragment, List list, String str, int i6, View view) {
        HomeFragment homeFragment2;
        MainViewModel D = homeFragment.D();
        c0 c0Var = c0.f16887a;
        D.F(c0Var.t((Map) list.get(i6), "id"));
        String t5 = c0Var.t((Map) list.get(i6), "bannerType");
        switch (t5.hashCode()) {
            case 49:
                if (t5.equals("1")) {
                    if (!TextUtils.isEmpty(c0Var.t((Map) list.get(i6), "linkUrl"))) {
                        homeFragment2 = homeFragment;
                    } else {
                        homeFragment2 = null;
                    }
                    if (homeFragment2 != null) {
                        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
                        FragmentActivity r5 = homeFragment.r();
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put(CommonNetImpl.NAME, c0Var.t((Map) list.get(i6), "articleTitle"));
                        linkedHashMap.put("linkUrl", c0Var.t((Map) list.get(i6), "linkUrl"));
                        n1 n1Var = n1.f44123a;
                        iVar.b(r5, linkedHashMap);
                        break;
                    }
                }
                break;
            case 50:
                if (t5.equals("2")) {
                    String t6 = c0Var.t((Map) list.get(i6), "appletId");
                    homeFragment.D().F(c0Var.t((Map) list.get(i6), "id"));
                    w.f20952a.a(homeFragment.H(), t6, c0Var.t((Map) list.get(i6), "appletPath"));
                    break;
                }
                break;
            case 51:
                if (t5.equals("3")) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("openApp.jdMobile://virtual?params={\"category\":\"jump\",\"des\":\"productDetail\",\"skuId\":\"" + c0Var.t((Map) list.get(i6), "jdPath") + "\",\"sourceType\":\"JSHOP_SOURCE_TYPE\",\"sourceValue\":\"JSHOP_SOURCE_VALUE\"}"));
                        intent.addFlags(268435456);
                        homeFragment.startActivity(intent);
                        break;
                    } catch (Exception unused) {
                        return;
                    }
                }
                break;
        }
    }

    private final void k() {
        SmartWebView smartWebView = L().smartWebView;
        FragmentActivity r5 = r();
        g0.m(smartWebView);
        smartWebView.setWebViewClient(new com.bxkj.base.v2.h5.m(r5, smartWebView));
        WebView webView = smartWebView.getWebView();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setMixedContentMode(0);
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        webView.addJavascriptInterface(new JS(r(), L().smartWebView.getWebView()), "tsn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 n(final HomeFragment homeFragment, final List list) {
        g0.m(list);
        List list2 = list;
        ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(c0.f16887a.t((Map) it.next(), "imageHttpUrl"));
        }
        if (list.size() <= 1) {
            homeFragment.L().cpAd.setWheel(false);
        }
        homeFragment.L().cpAd.w(arrayList, new CycleViewPager.c() { // from class: com.bxkj.student.v2.ui.main.h
            @Override // com.bxkj.base.v2.common.view.CycleViewPager.c
            public final void onImageClick(String str, int i6, View view) {
                HomeFragment.M(HomeFragment.this, list, str, i6, view);
            }
        });
        return n1.f44123a;
    }

    public final void N() {
        HomeFragment homeFragment;
        HomeFragment homeFragment2;
        HomeFragment homeFragment3 = null;
        if (b()) {
            homeFragment = this;
        } else {
            homeFragment = null;
        }
        if (homeFragment != null) {
            if (!this.f21477l.isEmpty()) {
                homeFragment = null;
            }
            if (homeFragment != null) {
                D().S();
            }
        }
        if (b()) {
            homeFragment2 = this;
        } else {
            homeFragment2 = null;
        }
        if (homeFragment2 != null) {
            List<Map<String, Object>> value = D().N().getValue();
            if (value != null && value.isEmpty()) {
                homeFragment3 = homeFragment2;
            }
            if (homeFragment3 != null) {
                D().M();
            }
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        D().N().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.main.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 n6;
                n6 = HomeFragment.n(HomeFragment.this, (List) obj);
                return n6;
            }
        }));
        D().T().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.main.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 l6;
                l6 = HomeFragment.l(HomeFragment.this, (List) obj);
                return l6;
            }
        }));
        D().U().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.main.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 m6;
                m6 = HomeFragment.m(HomeFragment.this, (String) obj);
                return m6;
            }
        }));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        d(r());
        k();
        D().M();
        L().cpAd.B(R.drawable.v2_dot_white, R.drawable.v2_dot_gey);
        L().cpAd.setDelay(AVMDLDataLoader.KeyIsLiveSetLoaderType);
        this.f21478m = new HomeFragment$initUiData$1(this, this.f21477l);
        L().rvMenu.setAdapter(this.f21478m);
    }
}
