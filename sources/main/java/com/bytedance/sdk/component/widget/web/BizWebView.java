package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.jy.cw;
import com.bytedance.sdk.component.jy.xt;
import com.bytedance.sdk.component.utils.tl;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BizWebView extends MultiWebview implements cw {
    @Override // com.bytedance.sdk.component.jy.cw
    public void addJavascriptInterface(final Object obj, final String str) {
        if (this.xt != null) {
            this.xt.addJavascriptInterface(obj, str);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.addJavascriptInterface(obj, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public boolean canGoBack() {
        if (this.xt != null) {
            if (this.xt.canGoBack()) {
                return true;
            }
            if (getWebViewCount() > 1 && j() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void clearCache(boolean z5) {
        if (this.xt != null) {
            this.xt.clearCache(z5);
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void clearHistory() {
        if (this.xt != null) {
            this.xt.clearHistory();
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void clearView() {
        if (this.xt != null) {
            this.xt.clearView();
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void computeScroll() {
        if (this.xt != null) {
            this.xt.computeScroll();
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.28
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.xt != null) {
                    BizWebView.this.xt.computeScroll();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (this.xt != null) {
            this.xt.evaluateJavascript(str, valueCallback);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public int getContentHeight() {
        if (this.xt != null) {
            return this.xt.getContentHeight();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public int getProgress() {
        if (this.xt != null) {
            return this.xt.getProgress();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public String getUrl() {
        return this.xt != null ? this.xt.getUrl() : "";
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public String getUserAgentString() {
        return this.xt != null ? this.xt.getUserAgentString() : "";
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public WebView getWebView() {
        if (this.xt != null) {
            return this.xt.getWebView();
        }
        if (up()) {
            return null;
        }
        long j6 = 500;
        while (this.f27179j.get() < 3 && j6 > 0) {
            try {
                Thread.sleep(10L);
                j6 -= 10;
            } catch (Exception unused) {
            }
        }
        if (this.xt != null) {
            return this.xt.getWebView();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void goBack() {
        if (this.xt != null) {
            this.xt.goBack();
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void j(String str, String str2, Object obj) {
        if (this.xt != null) {
            this.xt.j(str, str2, obj);
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void loadUrl(final String str) {
        if (this.xt != null) {
            this.xt.loadUrl(str);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.loadUrl(str);
                    }
                }
            });
        }
    }

    public void onPause() {
        if (this.xt != null) {
            this.xt.onPause();
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void onResume() {
        if (this.xt != null) {
            this.xt.onResume();
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void pauseTimers() {
        if (this.xt != null) {
            this.xt.pauseTimers();
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void removeJavascriptInterface(String str) {
        cw cwVar = this.xt;
        if (cwVar != null) {
            cwVar.removeJavascriptInterface(str);
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void resumeTimers() {
        if (this.xt != null) {
            this.xt.resumeTimers();
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setAllowFileAccess(final boolean z5) {
        if (this.xt != null) {
            this.xt.setAllowFileAccess(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.20
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setAllowFileAccess(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setAllowFileAccessFromFileURLs(final boolean z5) {
        if (this.xt != null) {
            this.xt.setAllowFileAccessFromFileURLs(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setAllowFileAccessFromFileURLs(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setAllowUniversalAccessFromFileURLs(final boolean z5) {
        if (this.xt != null) {
            this.xt.setAllowUniversalAccessFromFileURLs(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.24
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setAllowFileAccessFromFileURLs(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setAppCacheEnabled(final boolean z5) {
        if (this.xt != null) {
            this.xt.setAppCacheEnabled(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setAppCacheEnabled(z5);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setBackgroundResource(final int i6) {
        if (this.xt != null) {
            this.xt.setBackgroundResource(i6);
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.35
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.xt != null) {
                    BizWebView.this.xt.setBackgroundResource(i6);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setBlockNetworkImage(final boolean z5) {
        if (this.xt != null) {
            this.xt.setBlockNetworkImage(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setBlockNetworkImage(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setBuiltInZoomControls(final boolean z5) {
        if (this.xt != null) {
            this.xt.setBuiltInZoomControls(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setBuiltInZoomControls(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setCacheMode(final int i6) {
        if (this.xt != null) {
            this.xt.setCacheMode(i6);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setCacheMode(i6);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDatabaseEnabled(final boolean z5) {
        if (this.xt != null) {
            this.xt.setDatabaseEnabled(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.19
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setDatabaseEnabled(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDefaultFontSize(final int i6) {
        if (this.xt != null) {
            this.xt.setDefaultFontSize(i6);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setDefaultFontSize(i6);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDefaultTextEncodingName(final String str) {
        if (this.xt != null) {
            this.xt.setDefaultTextEncodingName(str);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setDefaultTextEncodingName(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDisplayZoomControls(final boolean z5) {
        if (this.xt != null) {
            this.xt.setDisplayZoomControls(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setDisplayZoomControls(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDomStorageEnabled(final boolean z5) {
        if (this.xt != null) {
            this.xt.setDomStorageEnabled(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setDomStorageEnabled(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.xt != null) {
            this.xt.setDownloadListener(downloadListener);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.38
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setDownloadListener(downloadListener);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z5) {
        if (this.xt != null) {
            this.xt.setJavaScriptCanOpenWindowsAutomatically(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setJavaScriptCanOpenWindowsAutomatically(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setJavaScriptEnabled(final boolean z5) {
        if (this.xt != null) {
            this.xt.setJavaScriptEnabled(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setJavaScriptEnabled(z5);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setLayerType(final int i6, final Paint paint) {
        if (this.xt != null) {
            this.xt.setLayerType(i6, paint);
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.29
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.xt != null) {
                    BizWebView.this.xt.setLayerType(i6, paint);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        if (this.xt != null) {
            this.xt.setLayoutAlgorithm(layoutAlgorithm);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setLayoutAlgorithm(layoutAlgorithm);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setLoadWithOverviewMode(final boolean z5) {
        if (this.xt != null) {
            this.xt.setLoadWithOverviewMode(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.15
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setLoadWithOverviewMode(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setMediaPlaybackRequiresUserGesture(final boolean z5) {
        if (this.xt != null) {
            this.xt.setMediaPlaybackRequiresUserGesture(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.26
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setMediaPlaybackRequiresUserGesture(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setMixedContentMode(final int i6) {
        if (this.xt != null) {
            this.xt.setMixedContentMode(i6);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.18
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setMixedContentMode(i6);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setNetworkAvailable(final boolean z5) {
        if (this.xt != null) {
            this.xt.setNetworkAvailable(z5);
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.xt != null) {
                    BizWebView.this.xt.setNetworkAvailable(z5);
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        if (this.xt != null) {
            this.xt.setOnScrollChangeListener(onScrollChangeListener);
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.33
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.xt != null) {
                    BizWebView.this.xt.setOnScrollChangeListener(onScrollChangeListener);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setSavePassword(final boolean z5) {
        if (this.xt != null) {
            this.xt.setSavePassword(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.25
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setSavePassword(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setSupportZoom(final boolean z5) {
        if (this.xt != null) {
            this.xt.setSupportZoom(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setSupportZoom(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.xt
    public void setTouchEventListener(final xt.j jVar) {
        if (this.xt != null) {
            this.xt.setTouchEventListener(jVar);
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.34
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.xt != null) {
                    BizWebView.this.xt.setTouchEventListener(jVar);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setUseWideViewPort(final boolean z5) {
        if (this.xt != null) {
            this.xt.setUseWideViewPort(z5);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setUseWideViewPort(z5);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setUserAgentString(final String str) {
        if (this.xt != null) {
            this.xt.setUserAgentString(str);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.36
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setUserAgentString(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        if (this.xt != null) {
            this.xt.setWebChromeClient(webChromeClient);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setWebChromeClient(webChromeClient);
                    }
                }
            });
        }
    }

    public void setWebViewClient(final WebViewClient webViewClient) {
        if (this.xt != null) {
            this.xt.setWebViewClient(webViewClient);
        } else if (this.f27179j.get() < 3) {
            xt(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.37
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setWebViewClient(webViewClient);
                    }
                }
            });
        }
    }

    public BizWebView(Context context) {
        super(context);
    }

    private void xt(Runnable runnable) {
        tl.xt().post(runnable);
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview
    public void G_() {
        super.G_();
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.jy.cw
    public void destroy() {
        super.destroy();
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setAlpha(final float f6) {
        super.setAlpha(f6);
        if (this.xt != null) {
            this.xt.setAlpha(f6);
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger != null && atomicInteger.get() < 3) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.32
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setAlpha(f6);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setBackgroundColor(final int i6) {
        super.setBackgroundColor(i6);
        if (this.xt != null) {
            this.xt.setBackgroundColor(i6);
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger != null && atomicInteger.get() < 3) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.27
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setBackgroundColor(i6);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setOverScrollMode(final int i6) {
        super.setOverScrollMode(i6);
        if (this.xt != null) {
            this.xt.setOverScrollMode(i6);
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger != null && atomicInteger.get() < 3) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.30
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setOverScrollMode(i6);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.jy.cw
    public void setVisibility(final int i6) {
        super.setVisibility(i6);
        if (this.xt != null) {
            this.xt.setVisibility(i6);
            return;
        }
        AtomicInteger atomicInteger = this.f27179j;
        if (atomicInteger != null && atomicInteger.get() < 3) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.31
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.xt != null) {
                        BizWebView.this.xt.setVisibility(i6);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.jy.cw
    public View getView() {
        return this;
    }
}
