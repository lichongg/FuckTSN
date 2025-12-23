package com.umeng.socialize.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.DeviceConfig;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.URLBuilder;
import com.umeng.socialize.utils.UmengText;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class OauthDialog extends BaseDialog {
    private static final String BASE_URL = "https://log.umsns.com/";
    private static final String TAG = "OauthDialog";
    private static String mRedirectUri = "error";
    private a mListener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.socialize.view.OauthDialog$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private UMAuthListener f42539a;

        /* renamed from: b, reason: collision with root package name */
        private SHARE_MEDIA f42540b;

        /* renamed from: c, reason: collision with root package name */
        private int f42541c;

        public void a(Exception exc) {
            UMAuthListener uMAuthListener = this.f42539a;
            if (uMAuthListener != null) {
                uMAuthListener.onError(this.f42540b, this.f42541c, exc);
            }
        }

        public void a(Bundle bundle) {
            UMAuthListener uMAuthListener = this.f42539a;
            if (uMAuthListener != null) {
                uMAuthListener.onComplete(this.f42540b, this.f42541c, SocializeUtils.bundleTomap(bundle));
            }
        }

        public a(UMAuthListener uMAuthListener, SHARE_MEDIA share_media) {
            this.f42539a = uMAuthListener;
            this.f42540b = share_media;
        }

        public void a() {
            UMAuthListener uMAuthListener = this.f42539a;
            if (uMAuthListener != null) {
                uMAuthListener.onCancel(this.f42540b, this.f42541c);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends WebChromeClient {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<OauthDialog> f42542a;

        /* synthetic */ b(OauthDialog oauthDialog, AnonymousClass1 anonymousClass1) {
            this(oauthDialog);
        }

        private b(OauthDialog oauthDialog) {
            this.f42542a = new WeakReference<>(oauthDialog);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            OauthDialog oauthDialog;
            super.onProgressChanged(webView, i6);
            WeakReference<OauthDialog> weakReference = this.f42542a;
            if (weakReference == null) {
                oauthDialog = null;
            } else {
                oauthDialog = weakReference.get();
            }
            if (oauthDialog != null) {
                if (i6 < 90) {
                    oauthDialog.mProgressbar.setVisibility(0);
                } else {
                    oauthDialog.mHandler.sendEmptyMessage(1);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<OauthDialog> f42543a;

        /* synthetic */ c(OauthDialog oauthDialog, AnonymousClass1 anonymousClass1) {
            this(oauthDialog);
        }

        private c(OauthDialog oauthDialog) {
            this.f42543a = new WeakReference<>(oauthDialog);
        }

        private void a(String str) {
            WeakReference<OauthDialog> weakReference = this.f42543a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                oauthDialog.mFlag = 1;
                oauthDialog.mValues = SocializeUtils.parseUrl(str);
                if (oauthDialog.isShowing()) {
                    SocializeUtils.safeCloseDialog(oauthDialog);
                }
            }
        }

        private void b(String str) {
            WeakReference<OauthDialog> weakReference = this.f42543a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                oauthDialog.mFlag = 1;
                oauthDialog.mValues = SocializeNetUtils.parseUrl(str);
                if (oauthDialog.isShowing()) {
                    SocializeUtils.safeCloseDialog(oauthDialog);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WeakReference<OauthDialog> weakReference = this.f42543a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                oauthDialog.mHandler.sendEmptyMessage(1);
                super.onPageFinished(webView, str);
                if (oauthDialog.mFlag == 0 && str.contains(oauthDialog.mWaitUrl)) {
                    a(str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WeakReference<OauthDialog> weakReference = this.f42543a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                String decrypt = str.contains("?ud_get=") ? oauthDialog.decrypt(str) : "";
                if (decrypt.contains("access_key") && decrypt.contains("access_secret")) {
                    if (str.contains(oauthDialog.mWaitUrl)) {
                        a(str);
                        return;
                    }
                    return;
                } else if (str.startsWith(OauthDialog.mRedirectUri)) {
                    b(str);
                }
            }
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i6, String str, String str2) {
            WeakReference<OauthDialog> weakReference = this.f42543a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                View view = oauthDialog.mProgressbar;
                if (view.getVisibility() == 0) {
                    view.setVisibility(8);
                }
            }
            super.onReceivedError(webView, i6, str, str2);
            if (oauthDialog != null) {
                SocializeUtils.safeCloseDialog(oauthDialog);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WeakReference<OauthDialog> weakReference = this.f42543a;
            OauthDialog oauthDialog = weakReference == null ? null : weakReference.get();
            if (oauthDialog != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(oauthDialog.mContext.getApplicationContext());
                if (!DeviceConfig.isNetworkAvailable(origApplicationContext)) {
                    Toast.makeText(origApplicationContext, UmengText.NET.NET_INAVALIBLE, 0).show();
                    return true;
                }
                if (str.contains("?ud_get=")) {
                    str = oauthDialog.decrypt(str);
                }
                if (str.contains(oauthDialog.mWaitUrl)) {
                    a(str);
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String decrypt(String str) {
        try {
            String[] split = str.split("ud_get=");
            return split[0] + split[1];
        } catch (Exception e6) {
            SLog.error(e6);
            return str;
        }
    }

    private WebViewClient getAdapterWebViewClient() {
        return new c(this, null);
    }

    private String getUrl(SHARE_MEDIA share_media) {
        URLBuilder uRLBuilder = new URLBuilder(this.mContext);
        uRLBuilder.setHost("https://log.umsns.com/").setPath("share/auth/").setAppkey(SocializeUtils.getAppkey(this.mContext)).setEntityKey(Config.EntityKey).withMedia(share_media).withOpId(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).withSessionId(Config.SessionId).withUID(UMUtils.getUMId(this.mContext));
        return uRLBuilder.toEncript();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Bundle bundle = this.mValues;
        if (bundle != null) {
            String string = bundle.getString("uid");
            String string2 = this.mValues.getString("error_code");
            String string3 = this.mValues.getString("error_description");
            if (this.mPlatform == SHARE_MEDIA.SINA && !TextUtils.isEmpty(string3)) {
                this.mListener.a(new SocializeException(UmengErrorCode.AuthorizeFailed.getMessage() + "errorcode:" + string2 + " message:" + string3));
            } else if (TextUtils.isEmpty(string)) {
                this.mListener.a(new SocializeException(UmengErrorCode.AuthorizeFailed.getMessage() + "unfetch usid..."));
            } else {
                Bundle bundle2 = this.mValues;
                bundle2.putString("accessToken", bundle2.getString("access_key"));
                Bundle bundle3 = this.mValues;
                bundle3.putString("expiration", bundle3.getString("expires_in"));
                this.mListener.a(this.mValues);
            }
        } else {
            this.mListener.a();
        }
        super.dismiss();
        releaseWebView();
    }

    public void setmRedirectUri(String str) {
        mRedirectUri = str;
    }

    public OauthDialog(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        super(activity, share_media);
        this.mListener = new a(uMAuthListener, share_media);
        initViews();
    }

    @Override // com.umeng.socialize.view.BaseDialog
    public void setClient(WebView webView) {
        webView.setWebViewClient(getAdapterWebViewClient());
        this.mWebView.setWebChromeClient(new b(this, null));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.mValues = null;
        SHARE_MEDIA share_media = this.mPlatform;
        if (share_media == SHARE_MEDIA.SINA) {
            this.mWebView.loadUrl(this.mWaitUrl);
        } else {
            this.mWebView.loadUrl(getUrl(share_media));
        }
    }
}
