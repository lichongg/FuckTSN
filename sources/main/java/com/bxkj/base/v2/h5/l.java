package com.bxkj.base.v2.h5;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bxkj.base.v2.base.ProgressDialogFragment;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.base.v2.common.utils.d0;
import com.bxkj.base.v2.h5.l;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private FragmentActivity f17067a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private WebView f17068b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.base.v2.h5.GPSJS$getLocation$1", f = "GPSJS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f17069a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.base.v2.h5.l$a$a, reason: collision with other inner class name */
        public static final class C0192a implements d0 {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ l f17071a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ProgressDialogFragment f17072b;

            C0192a(l lVar, ProgressDialogFragment progressDialogFragment) {
                this.f17071a = lVar;
                this.f17072b = progressDialogFragment;
            }

            @Override // com.bxkj.base.v2.common.utils.d0
            public void a(double d6, double d7) {
                com.orhanobut.logger.j.d("getLocationCallBack('" + d6 + "','" + d7 + "')", new Object[0]);
                this.f17071a.b().loadUrl("javascript:stuSignStatus('" + d6 + "','" + d7 + "')");
                this.f17071a.b().loadUrl("javascript:getLocationCallBack('" + d6 + "','" + d7 + "')");
                this.f17072b.dismiss();
            }

            @Override // com.bxkj.base.v2.common.utils.d0
            public void b(Integer num, String str) {
                this.f17072b.dismiss();
                ContextExtKt.q(this.f17071a.a(), "获取定位失败，错误码【" + num + "】错误信息【" + str + "】");
            }
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 i(l lVar) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(null, 1, null);
            FragmentManager supportFragmentManager = lVar.a().getSupportFragmentManager();
            g0.o(supportFragmentManager, "getSupportFragmentManager(...)");
            progressDialogFragment.e(supportFragmentManager, "正在获取定位", true);
            com.bxkj.base.v2.common.utils.c.f16886a.b(new C0192a(lVar, progressDialogFragment));
            return n1.f44123a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return l.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f17069a == 0) {
                kotlin.g0.n(obj);
                FragmentActivity a6 = l.this.a();
                final l lVar = l.this;
                b0.D(a6, new Function0() { // from class: com.bxkj.base.v2.h5.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        n1 i6;
                        i6 = l.a.i(l.this);
                        return i6;
                    }
                });
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @JavascriptInterface
    public final void getLocation() {
        com.orhanobut.logger.j.d("开始获取GPS点名位置", new Object[0]);
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(a()), g1.e(), null, new a(null), 2, null);
    }

    public l(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        g0.p(mActivity, "mActivity");
        g0.p(mWebView, "mWebView");
        this.f17067a = mActivity;
        this.f17068b = mWebView;
    }

    @NotNull
    public FragmentActivity a() {
        return this.f17067a;
    }

    @NotNull
    public WebView b() {
        return this.f17068b;
    }

    public void c(@NotNull FragmentActivity fragmentActivity) {
        g0.p(fragmentActivity, "<set-?>");
        this.f17067a = fragmentActivity;
    }

    public void d(@NotNull WebView webView) {
        g0.p(webView, "<set-?>");
        this.f17068b = webView;
    }
}
