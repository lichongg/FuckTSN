package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.ct;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class CpuAdView extends RelativeLayout {
    private ct mAdProd;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CpuAdViewInternalStatusListener {
        void loadDataError(String str);

        void onAdClick();

        void onAdImpression(String str);

        void onContentClick();

        void onContentImpression(String str);

        void onExitLp();

        void onLpContentStatus(Map<String, Object> map);
    }

    public CpuAdView(Context context) {
        super(context);
    }

    protected boolean canGoBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                return webView.canGoBack();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean onKeyBackDown(int i6, KeyEvent keyEvent) {
        if (i6 != 4 || !canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    public CpuAdView(Context context, String str, int i6, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        cs csVar = new cs(context);
        this.mAdProd = new ct(context, csVar, str, i6, cPUWebAdRequestParam);
        addView(csVar, new ViewGroup.LayoutParams(-1, -1));
    }

    protected void goBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                webView.goBack();
            }
        } catch (Throwable unused) {
        }
    }

    public void onDestroy() {
        View w5 = this.mAdProd.w();
        if (w5 instanceof WebView) {
            ((WebView) w5).destroy();
        }
    }

    public void onPause() {
        View w5 = this.mAdProd.w();
        if (w5 instanceof WebView) {
            ((WebView) w5).onPause();
        }
    }

    public void onResume() {
        View w5 = this.mAdProd.w();
        if (w5 instanceof WebView) {
            ((WebView) w5).onResume();
        }
    }

    public void requestData() {
        ct ctVar = this.mAdProd;
        if (ctVar != null) {
            ctVar.a();
        }
    }

    public CpuAdView(Context context, String str, int i6, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        cs csVar = new cs(context);
        ct ctVar = new ct(context, csVar, str, i6, cPUWebAdRequestParam);
        this.mAdProd = ctVar;
        ctVar.a(cpuAdViewInternalStatusListener);
        addView(csVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
