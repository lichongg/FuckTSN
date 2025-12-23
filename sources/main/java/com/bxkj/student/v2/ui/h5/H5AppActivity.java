package com.bxkj.student.v2.ui.h5;

import android.content.Intent;
import android.net.Uri;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.data.b;
import com.bxkj.base.v2.h5.m;
import com.bxkj.student.databinding.AcV2H5AppBinding;
import com.bxkj.student.v2.ui.h5.js.JS;
import com.bxkj.student.v2.vm.h5.H5VM;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.orhanobut.logger.j;
import com.umeng.socialize.UMShareAPI;
import defpackage.H5BaseWebChromeClient;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nH5AppActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 H5AppActivity.kt\ncom/bxkj/student/v2/ui/h5/H5AppActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n1#2:128\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class H5AppActivity extends BaseActivity<AcV2H5AppBinding, H5VM> {

    @Nullable
    private String U;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21397a;

        a(Function1 function) {
            g0.p(function, "function");
            this.f21397a = function;
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
            return this.f21397a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21397a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 g(H5AppActivity h5AppActivity, String it) {
        g0.p(it, "it");
        h5AppActivity.L().setTitle(it);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 h(H5AppActivity h5AppActivity, Map map) {
        String str = h5AppActivity.U;
        if (str != null) {
            h5AppActivity.L().smartWebView.j(str);
        }
        return n1.f44123a;
    }

    private final void N(WebView webView) {
        Object systemService = H().getSystemService("window");
        g0.n(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        int width = ((WindowManager) systemService).getDefaultDisplay().getWidth();
        if (width > 650) {
            webView.setInitialScale(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME);
            return;
        }
        if (width > 520) {
            webView.setInitialScale(160);
            return;
        }
        if (width > 450) {
            webView.setInitialScale(140);
        } else if (width > 300) {
            webView.setInitialScale(120);
        } else {
            webView.setInitialScale(100);
        }
    }

    public final void M() {
        L().smartWebView.l();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i6, int i7, @Nullable Intent intent) {
        super.onActivityResult(i6, i7, intent);
        UMShareAPI.get(this).onActivityResult(i6, i7, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void s0() {
        if (L().smartWebView.getWebView().canGoBack()) {
            L().smartWebView.getWebView().goBack();
        } else {
            if (getIntent().hasExtra("needUpdatePasswordStatus") && g0.g(getIntent().getStringExtra("needUpdatePasswordStatus"), "1")) {
                return;
            }
            super.s0();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        t();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        D().D().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.h5.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 h6;
                h6 = H5AppActivity.h(H5AppActivity.this, (Map) obj);
                return h6;
            }
        }));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        String str;
        L().setMActivity(this);
        if (getIntent().hasExtra("title")) {
            str = getIntent().getStringExtra("title");
        } else {
            str = "首页";
        }
        String str2 = "";
        if (getIntent().hasExtra("url")) {
            String stringExtra = getIntent().getStringExtra("url");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.U = stringExtra;
        }
        j.d("smartWebView.intentUrl=" + this.U, new Object[0]);
        L().setTitle(str);
        SmartWebView smartWebView = L().smartWebView;
        FragmentActivity r5 = r();
        g0.m(smartWebView);
        smartWebView.setWebViewClient(new m(r5, smartWebView));
        smartWebView.setWebChromeClient(new H5BaseWebChromeClient(r(), smartWebView, new Function1() { // from class: com.bxkj.student.v2.ui.h5.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 g6;
                g6 = H5AppActivity.g(H5AppActivity.this, (String) obj);
                return g6;
            }
        }));
        WebView webView = smartWebView.getWebView();
        N(webView);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setMixedContentMode(0);
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        webView.addJavascriptInterface(new JS(r(), L().smartWebView.getWebView()), "tsn");
        if (getIntent().hasExtra("username")) {
            b.a aVar = com.bxkj.base.v2.data.b.f16998d;
            com.bxkj.base.v2.data.b a6 = aVar.a();
            String stringExtra2 = getIntent().getStringExtra("username");
            if (stringExtra2 != null) {
                str2 = stringExtra2;
            }
            a6.W0(str2);
            String str3 = this.U;
            if (str3 != null) {
                aVar.a().M0(String.valueOf(Uri.parse(str3).getQueryParameter("school")));
                D().X();
                return;
            }
            return;
        }
        String str4 = this.U;
        if (str4 != null) {
            L().smartWebView.j(str4);
        }
    }
}
