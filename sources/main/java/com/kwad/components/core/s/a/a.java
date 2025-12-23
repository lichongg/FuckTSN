package com.kwad.components.core.s.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.b.a;
import com.kwad.components.core.c.f;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.n;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.components.core.m.b<b> {
    private static final ConcurrentMap<Integer, Map<String, Object>> Ym = new ConcurrentHashMap();
    private static final AtomicInteger Yn = new AtomicInteger(1);
    private StyleTemplate Yf;
    private String Yg;
    private boolean Yh;
    private n Yi;
    private k Yj;
    private com.kwad.components.core.s.b.b Yk;
    private int Yl;
    private AdResultData mAdResultData;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.b.a mTitleBarHelper;

    public static void a(int i6, String str, Object obj) {
        ConcurrentMap<Integer, Map<String, Object>> concurrentMap = Ym;
        Map<String, Object> map = concurrentMap.get(Integer.valueOf(i6));
        if (map == null) {
            map = new HashMap<>();
            concurrentMap.put(Integer.valueOf(i6), map);
        }
        map.put(str, obj);
    }

    private Object aF(String str) {
        return o(this.Yl, str);
    }

    private static void aZ(int i6) {
        Map<String, Object> map = Ym.get(Integer.valueOf(i6));
        if (map != null) {
            map.clear();
        }
    }

    private static Object o(int i6, String str) {
        Map<String, Object> map = Ym.get(Integer.valueOf(i6));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @InvokeBy(invokerClass = c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        c.a(FeedDownloadActivity.class, a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.m.b
    /* renamed from: sO, reason: merged with bridge method [inline-methods] */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.a(this.mAdResultData);
        bVar.Yf = this.Yf;
        bVar.mRootContainer = this.mRootContainer;
        bVar.Yi = this.Yi;
        bVar.Yj = this.Yj;
        return bVar;
    }

    public static int sP() {
        return Yn.incrementAndGet();
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return R.layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "TKActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_tk_root_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_js_container);
        if (!this.Yh && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams);
        }
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0605a() { // from class: com.kwad.components.core.s.a.a.1
            @Override // com.kwad.components.core.b.a.InterfaceC0605a
            public final void x(View view) {
                a.this.finish();
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0605a
            public final void y(View view) {
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(this.Yg));
        this.mTitleBarHelper.aj(false);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.s.b.b bVar = this.Yk;
        if (bVar == null || !bVar.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.m.b
    public Presenter onCreatePresenter() {
        if (this.Yf != null) {
            return new com.kwad.components.core.s.b.a();
        }
        if (this.Yk == null) {
            this.Yk = new com.kwad.components.core.s.b.b();
        }
        return this.Yk;
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        this.Yl = getIntent().getIntExtra("tk_id", 0);
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        k kVar = (k) aF("tk_view_holder");
        if (TextUtils.isEmpty(stringExtra) && kVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(new JSONObject(stringExtra));
                this.Yf = styleTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return false;
            }
        }
        if (kVar != null) {
            this.Yj = kVar;
        }
        int intExtra = getIntent().getIntExtra("ad_result_cache_idx", 0);
        AdResultData d6 = f.ol().d(intExtra, true);
        this.mAdResultData = d6;
        if (intExtra > 0 && d6 == null) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.Yh = getIntent().getBooleanExtra("show_navigationBar", true);
        this.Yg = getIntent().getStringExtra("title");
        this.Yi = (n) aF("native_intent");
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            aZ(this.Yl);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
