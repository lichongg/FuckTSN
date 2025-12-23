package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class br implements ExpressResponse {

    /* renamed from: a, reason: collision with root package name */
    private Context f10779a;

    /* renamed from: b, reason: collision with root package name */
    private int f10780b = 1;

    /* renamed from: c, reason: collision with root package name */
    private ExpressResponse.ExpressInteractionListener f10781c;

    /* renamed from: d, reason: collision with root package name */
    private ExpressResponse.ExpressAdDownloadWindowListener f10782d;

    /* renamed from: e, reason: collision with root package name */
    private ExpressResponse.ExpressDislikeListener f10783e;

    /* renamed from: f, reason: collision with root package name */
    private ExpressResponse.ExpressCloseListener f10784f;

    /* renamed from: g, reason: collision with root package name */
    private final df f10785g;

    /* renamed from: h, reason: collision with root package name */
    private final a f10786h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f10787i;

    /* renamed from: j, reason: collision with root package name */
    private ExpressAdData f10788j;

    /* renamed from: k, reason: collision with root package name */
    private String f10789k;

    public void a(int i6) {
        this.f10780b = i6;
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f10781c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    public void a(String str) {
        this.f10789k = str;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        if (this.f10785g != null) {
            String str = this.f10789k;
            a aVar = this.f10786h;
            if (aVar != null) {
                str = aVar.I();
            }
            this.f10785g.a(str, false, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        df dfVar;
        a aVar = this.f10786h;
        if (aVar == null || (dfVar = this.f10785g) == null) {
            return;
        }
        dfVar.a(aVar.I(), true, linkedHashMap, biddingListener);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        df dfVar = this.f10785g;
        if (dfVar != null) {
            dfVar.b(activity);
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f10781c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f10783e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void destroy() {
        a aVar;
        ViewGroup viewGroup;
        df dfVar = this.f10785g;
        if (dfVar == null || (aVar = this.f10786h) == null || (viewGroup = this.f10787i) == null) {
            return;
        }
        dfVar.b(viewGroup, aVar);
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f10783e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f10781c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f10782d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.f10780b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.f10788j;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public Object getAdDataForKey(String str) {
        if (this.f10786h != null) {
            return "request_id".equals(str) ? this.f10786h.V() : this.f10786h.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        a aVar = this.f10786h;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        a aVar;
        if (this.f10787i == null && (aVar = this.f10786h) != null) {
            this.f10787i = this.f10785g.a(aVar);
        }
        return this.f10787i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getPECPM() {
        a aVar = this.f10786h;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        a aVar = this.f10786h;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    public void h() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f10782d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADFunctionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.f10786h != null && System.currentTimeMillis() - this.f10786h.y() <= this.f10786h.G();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isReady(Context context) {
        return this.f10786h != null && System.currentTimeMillis() - this.f10786h.y() <= this.f10786h.G();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        a aVar;
        df dfVar = this.f10785g;
        if (dfVar == null || (aVar = this.f10786h) == null) {
            return;
        }
        if (this.f10787i == null) {
            this.f10787i = dfVar.a(aVar);
        }
        this.f10785g.a(this.f10787i, this.f10786h);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdCloseListener(ExpressResponse.ExpressCloseListener expressCloseListener) {
        this.f10784f = expressCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.f10783e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.f10782d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setExpectedSizePixel(int i6, int i7) {
        df dfVar = this.f10785g;
        if (dfVar != null) {
            dfVar.a(i6, i7);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.f10781c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i6) {
        df dfVar = this.f10785g;
        if (dfVar != null) {
            return dfVar.a(this.f10787i, this.f10786h, i6);
        }
        return false;
    }

    public br(Context context, df dfVar, a aVar) {
        this.f10779a = context;
        this.f10785g = dfVar;
        this.f10786h = aVar;
    }

    public String a() {
        a aVar = this.f10786h;
        if (aVar != null) {
            return aVar.I();
        }
        return "";
    }

    public void b(String str) {
        df dfVar;
        a aVar = this.f10786h;
        if (aVar != null && (dfVar = this.f10785g) != null) {
            this.f10788j = new ExpressAdData(aVar, dfVar.g());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f10783e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void a(View view, int i6, int i7) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f10781c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i6, i7);
        }
    }

    public void b(boolean z5) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f10782d;
        if (expressAdDownloadWindowListener != null) {
            if (z5) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    public void a(View view, String str, int i6) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f10781c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i6);
        }
    }

    public void a(ExpressResponse expressResponse) {
        ExpressResponse.ExpressCloseListener expressCloseListener = this.f10784f;
        if (expressCloseListener != null) {
            expressCloseListener.onAdClose(expressResponse);
        }
    }

    public void a(boolean z5) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f10782d;
        if (expressAdDownloadWindowListener != null) {
            if (z5) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }
}
