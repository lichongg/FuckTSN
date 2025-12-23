package defpackage;

import android.R;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.common.utils.j0;
import com.bxkj.base.v2.common.utils.u;
import com.bxkj.base.v2.view.a;
import com.orhanobut.logger.j;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import master.flame.danmaku.danmaku.parser.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class H5BaseWebChromeClient extends SmartWebView.b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final FragmentActivity f5a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private SmartWebView f6b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private Function1<? super String, n1> f7c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final FrameLayout.LayoutParams f8d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private View f9e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private FrameLayout f10f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private WebChromeClient.CustomViewCallback f11g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class FullscreenHolder extends FrameLayout {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FullscreenHolder(@NotNull Context ctx) {
            super(ctx);
            g0.p(ctx, "ctx");
            setBackgroundColor(ctx.getResources().getColor(R.color.black));
        }

        @Override // android.view.View
        public boolean onTouchEvent(@NotNull MotionEvent evt) {
            g0.p(evt, "evt");
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements a.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f13b;

        a(String str) {
            this.f13b = str;
        }

        @Override // com.bxkj.base.v2.view.a.b
        public void onMenuClick(String str) {
            j0.f16904a.d(H5BaseWebChromeClient.this.f5a, this.f13b);
        }
    }

    private final void l() {
        j.d("关闭视频全屏-》hideCustomView", new Object[0]);
        if (this.f9e == null) {
            return;
        }
        x(true);
        View decorView = this.f5a.getWindow().getDecorView();
        g0.n(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
        ((FrameLayout) decorView).removeView(this.f10f);
        this.f10f = null;
        this.f9e = null;
        WebChromeClient.CustomViewCallback customViewCallback = this.f11g;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.f5a.setRequestedOrientation(-1);
        this.f6b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(H5BaseWebChromeClient h5BaseWebChromeClient, View view, int i6, KeyEvent keyEvent) {
        if (i6 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        if (h5BaseWebChromeClient.f9e != null) {
            h5BaseWebChromeClient.l();
        } else if (h5BaseWebChromeClient.f6b.getWebView().canGoBack()) {
            h5BaseWebChromeClient.f6b.getWebView().goBack();
        } else {
            h5BaseWebChromeClient.f5a.finish();
        }
        return true;
    }

    private final void y(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        j.d("打开视频全屏-》showCustomView", new Object[0]);
        if (this.f9e != null) {
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            return;
        }
        View decorView = this.f5a.getWindow().getDecorView();
        g0.n(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
        FullscreenHolder fullscreenHolder = new FullscreenHolder(this.f5a);
        this.f10f = fullscreenHolder;
        fullscreenHolder.addView(view, this.f8d);
        ((FrameLayout) decorView).addView(this.f10f, this.f8d);
        this.f9e = view;
        x(false);
        this.f5a.setRequestedOrientation(0);
        this.f11g = customViewCallback;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        j.d("关闭视频全屏-》onHideCustomView", new Object[0]);
        l();
    }

    public final void openFileChooser(@NotNull final ValueCallback<Uri> valueCallback) {
        g0.p(valueCallback, "valueCallback");
        u.f16942a.C(this.f5a, new Function1() { // from class: d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 o5;
                o5 = H5BaseWebChromeClient.o(valueCallback, (File) obj);
                return o5;
            }
        });
    }

    public H5BaseWebChromeClient(@NotNull FragmentActivity mActivity, @NotNull SmartWebView smartWebView, @NotNull Function1<? super String, n1> onReceivedTitleCallback) {
        g0.p(mActivity, "mActivity");
        g0.p(smartWebView, "smartWebView");
        g0.p(onReceivedTitleCallback, "onReceivedTitleCallback");
        this.f5a = mActivity;
        this.f6b = smartWebView;
        this.f7c = onReceivedTitleCallback;
        r();
        t();
        this.f8d = new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 m(ValueCallback valueCallback, File file) {
        if (file == null) {
            valueCallback.onReceiveValue(null);
        } else {
            Uri fromFile = Uri.fromFile(file);
            g0.o(fromFile, "fromFile(...)");
            valueCallback.onReceiveValue(new Uri[]{fromFile});
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 n(ValueCallback valueCallback, File file) {
        if (file == null) {
            valueCallback.onReceiveValue(null);
        } else {
            Uri fromFile = Uri.fromFile(file);
            g0.o(fromFile, "fromFile(...)");
            valueCallback.onReceiveValue(new Uri[]{fromFile});
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 o(ValueCallback valueCallback, File file) {
        if (file == null) {
            valueCallback.onReceiveValue(null);
        } else {
            valueCallback.onReceiveValue(Uri.fromFile(file));
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 p(ValueCallback valueCallback, File file) {
        if (file == null) {
            valueCallback.onReceiveValue(null);
        } else {
            valueCallback.onReceiveValue(Uri.fromFile(file));
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 q(ValueCallback valueCallback, File file) {
        if (file == null) {
            valueCallback.onReceiveValue(null);
        } else {
            valueCallback.onReceiveValue(Uri.fromFile(file));
        }
        return n1.f44123a;
    }

    private final void r() {
        this.f6b.setOnKeyListener(new View.OnKeyListener() { // from class: g
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
                boolean s5;
                s5 = H5BaseWebChromeClient.s(H5BaseWebChromeClient.this, view, i6, keyEvent);
                return s5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u(H5BaseWebChromeClient h5BaseWebChromeClient, View view) {
        g0.n(view, "null cannot be cast to non-null type android.webkit.WebView");
        WebView.HitTestResult hitTestResult = ((WebView) view).getHitTestResult();
        g0.o(hitTestResult, "getHitTestResult(...)");
        if (hitTestResult.getType() != 5 && hitTestResult.getType() != 8) {
            return false;
        }
        String extra = hitTestResult.getExtra();
        j.d("imageUrl=" + extra, new Object[0]);
        h5BaseWebChromeClient.z(extra);
        return true;
    }

    private final void x(boolean z5) {
        this.f5a.getWindow().setFlags(z5 ? 0 : 1024, 1024);
    }

    @NotNull
    protected final FrameLayout.LayoutParams i() {
        return this.f8d;
    }

    @NotNull
    public final Function1<String, n1> j() {
        return this.f7c;
    }

    @NotNull
    public final SmartWebView k() {
        return this.f6b;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(@NotNull WebView view, @NotNull String title) {
        g0.p(view, "view");
        g0.p(title, "title");
        if (TextUtils.isEmpty(title) || kotlin.text.u.H2(title, b.f50154a, false, 2, null) || g0.g(title, "网页无法打开")) {
            return;
        }
        this.f7c.invoke(title);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(@Nullable WebView webView, @NotNull final ValueCallback<Uri[]> filePathCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        g0.p(filePathCallback, "filePathCallback");
        if (fileChooserParams == null || !fileChooserParams.isCaptureEnabled()) {
            u.f16942a.C(this.f5a, new Function1() { // from class: f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 n6;
                    n6 = H5BaseWebChromeClient.n(filePathCallback, (File) obj);
                    return n6;
                }
            });
        } else {
            u.f16942a.p(this.f5a, new Function1() { // from class: e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 m6;
                    m6 = H5BaseWebChromeClient.m(filePathCallback, (File) obj);
                    return m6;
                }
            });
        }
        return true;
    }

    public final void openFileChooser(@NotNull final ValueCallback<Uri> valueCallback, @Nullable String str) {
        g0.p(valueCallback, "valueCallback");
        u.f16942a.C(this.f5a, new Function1() { // from class: h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 p5;
                p5 = H5BaseWebChromeClient.p(valueCallback, (File) obj);
                return p5;
            }
        });
    }

    public final void t() {
        this.f6b.getWebView().setOnLongClickListener(new View.OnLongClickListener() { // from class: c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean u5;
                u5 = H5BaseWebChromeClient.u(H5BaseWebChromeClient.this, view);
                return u5;
            }
        });
    }

    public final void v(@NotNull Function1<? super String, n1> function1) {
        g0.p(function1, "<set-?>");
        this.f7c = function1;
    }

    public final void w(@NotNull SmartWebView smartWebView) {
        g0.p(smartWebView, "<set-?>");
        this.f6b = smartWebView;
    }

    public final void z(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        com.bxkj.base.v2.view.a aVar = new com.bxkj.base.v2.view.a(this.f5a);
        aVar.i("请选择");
        aVar.c("保存到相册").g(new a(str));
        aVar.h("取消");
        aVar.show();
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(@Nullable View view, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
        y(view, customViewCallback);
    }

    public final void openFileChooser(@NotNull final ValueCallback<Uri> valueCallback, @Nullable String str, @Nullable String str2) {
        g0.p(valueCallback, "valueCallback");
        u.f16942a.C(this.f5a, new Function1() { // from class: b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 q5;
                q5 = H5BaseWebChromeClient.q(valueCallback, (File) obj);
                return q5;
            }
        });
    }
}
