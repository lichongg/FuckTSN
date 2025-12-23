package com.bxkj.student.v2.ui.main;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.student.databinding.V2MainTabH5FragmentBinding;
import com.bxkj.student.v2.ui.h5.js.JS;
import com.bxkj.student.v2.vm.MainViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.text.u;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nH5Fragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 H5Fragment.kt\ncom/bxkj/student/v2/ui/main/H5Fragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class H5Fragment extends BaseFragment<V2MainTabH5FragmentBinding, MainViewModel> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends JS {

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ SmartWebView f21474l;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.ui.main.H5Fragment$initWebView$1$1$1$finish$1", f = "H5Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bxkj.student.v2.ui.main.H5Fragment$a$a, reason: collision with other inner class name */
        static final class C0294a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f21475a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ SmartWebView f21476b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0294a(SmartWebView smartWebView, kotlin.coroutines.e<? super C0294a> eVar) {
                super(2, eVar);
                this.f21476b = smartWebView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new C0294a(this.f21476b, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((C0294a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f21475a == 0) {
                    g0.n(obj);
                    this.f21476b.l();
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SmartWebView smartWebView, FragmentActivity fragmentActivity, WebView webView) {
            super(fragmentActivity, webView);
            this.f21474l = smartWebView;
        }

        @Override // com.bxkj.student.v2.ui.h5.js.JS
        @JavascriptInterface
        public void finish() {
            kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(H5Fragment.this), g1.e(), null, new C0294a(this.f21474l, null), 2, null);
        }
    }

    private final void e() {
        SmartWebView smartWebView = L().smartWebView;
        FragmentActivity r5 = r();
        kotlin.jvm.internal.g0.m(smartWebView);
        smartWebView.setWebViewClient(new com.bxkj.base.v2.h5.m(r5, smartWebView));
        smartWebView.setWebChromeClient(new defpackage.a(q()));
        WebView webView = smartWebView.getWebView();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setMixedContentMode(0);
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        webView.addJavascriptInterface(new a(smartWebView, r(), L().smartWebView.getWebView()), "tsn");
    }

    public final void f() {
        H5Fragment h5Fragment;
        H5Fragment h5Fragment2 = null;
        if (b()) {
            h5Fragment = this;
        } else {
            h5Fragment = null;
        }
        if (h5Fragment != null) {
            if (com.bxkj.base.v2.data.b.f16998d.a().Y()) {
                h5Fragment2 = h5Fragment;
            }
            if (h5Fragment2 != null) {
                L().smartWebView.getWebView().reload();
            }
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        String string;
        String string2;
        String string3;
        e();
        d(r());
        Bundle arguments = getArguments();
        Bundle bundle = null;
        if (arguments != null) {
            if (!arguments.containsKey("title")) {
                arguments = null;
            }
            if (arguments != null && (string3 = arguments.getString("title")) != null) {
                L().tvTitle.setText(string3);
            }
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            if (!arguments2.containsKey("isShowH5Title")) {
                arguments2 = null;
            }
            if (arguments2 != null && (string2 = arguments2.getString("isShowH5Title")) != null) {
                if (!kotlin.jvm.internal.g0.g(string2, "0")) {
                    string2 = null;
                }
                if (string2 != null) {
                    L().tvTitle.setVisibility(8);
                }
            }
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            if (arguments3.containsKey("url")) {
                bundle = arguments3;
            }
            if (bundle != null && (string = bundle.getString("url")) != null) {
                com.orhanobut.logger.j.d("H5Fragment：url=" + string, new Object[0]);
                L().smartWebView.j(u.x2(string, "${school}", com.bxkj.base.v2.data.b.f16998d.a().J(), false, 4, null));
            }
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
