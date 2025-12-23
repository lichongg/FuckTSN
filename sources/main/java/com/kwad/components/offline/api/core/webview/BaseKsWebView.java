package com.kwad.components.offline.api.core.webview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.widget.j;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class BaseKsWebView extends FrameLayout {
    private boolean enableScroll;
    public DeepLinkListener mDeeplinkListener;
    protected String mUniqueId;
    private j mViewRCHelper;
    public WebLoadListener mWebLoadListener;
    protected WebViewStateListener mWebViewStateListener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface DeepLinkListener {
        void onFailed();

        void onSuccess();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface WebLoadListener {
        void onDownloadStart(String str, String str2, String str3, String str4, long j6);

        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i6, String str, String str2);

        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface WebViewStateListener {
        void onFocusChanged(boolean z5, int i6, Rect rect);

        void onScrollChanged(int i6, int i7, int i8, int i9);

        void onSizeChanged(int i6, int i7, int i8, int i9);

        void onVisibilityChanged(View view, int i6);

        void onWindowFocusChanged(boolean z5);
    }

    public BaseKsWebView(@NonNull Context context) {
        super(context);
        this.enableScroll = true;
        init(context, null);
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public abstract void callJs(String str);

    public abstract void callJs(String str, String str2);

    public abstract boolean canGoBack();

    public abstract boolean canGoForward();

    public abstract void destroy();

    public abstract void goBack();

    public abstract void goForward();

    public abstract void loadUrl(String str);

    @Override // android.view.View
    public abstract void scrollBy(int i6, int i7);

    @Override // android.view.View
    public abstract void scrollTo(int i6, int i7);

    public abstract void setAcceptThirdPartyCookies(boolean z5);

    public abstract void setAdCacheId(int i6, String str);

    public abstract void setAdTemplateString(String str);

    public abstract void setAllowContentAccess(boolean z5);

    public abstract void setAllowFileAccess(boolean z5);

    public abstract void setAllowFileAccessFromFileURLs(boolean z5);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean z5);

    public abstract void setCacheMode(int i6);

    public abstract void setContextUniqId(int i6);

    public abstract void setDebugEnabled(boolean z5);

    public abstract void setDeeplinkEnabled(boolean z5);

    public abstract void setEnableScroll(boolean z5);

    public abstract void setEnableWebCache(boolean z5);

    public abstract void setInnerDownloadEnabled(boolean z5);

    public abstract void setJavaScriptEnabled(boolean z5);

    public abstract void setMixedContentMode(int i6);

    public abstract void setSavePassword(boolean z5);

    public abstract void setTextZoom(int i6);

    private float[] getRadius(float f6, float f7, float f8, float f9) {
        return new float[]{f6, f6, f7, f7, f8, f8, f9, f9};
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        j jVar = new j();
        this.mViewRCHelper = jVar;
        jVar.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    public String getUniqueId() {
        if (this.mUniqueId == null) {
            this.mUniqueId = UUID.randomUUID().toString();
        }
        return this.mUniqueId;
    }

    public void setDeeplinkListener(DeepLinkListener deepLinkListener) {
        this.mDeeplinkListener = deepLinkListener;
    }

    public void setWebLoadListener(WebLoadListener webLoadListener) {
        this.mWebLoadListener = webLoadListener;
    }

    public void setWebViewStateListener(WebViewStateListener webViewStateListener) {
        this.mWebViewStateListener = webViewStateListener;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z5, int i6, Rect rect) {
        super.onFocusChanged(z5, i6, rect);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onFocusChanged(z5, i6, rect);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i6, int i7, int i8, int i9) {
        super.onScrollChanged(i6, i7, i8, i9);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onScrollChanged(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.mViewRCHelper.onSizeChanged(i6, i7);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onSizeChanged(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i6) {
        super.onVisibilityChanged(view, i6);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onVisibilityChanged(view, i6);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onWindowFocusChanged(z5);
        }
    }

    public void setRadius(float f6, float f7, float f8, float f9) {
        this.mViewRCHelper.setRadius(getRadius(f6, f7, f8, f9));
        postInvalidate();
    }

    public BaseKsWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enableScroll = true;
        init(context, attributeSet);
    }

    public BaseKsWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.enableScroll = true;
        init(context, attributeSet);
    }
}
