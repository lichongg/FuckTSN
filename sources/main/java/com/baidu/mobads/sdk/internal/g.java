package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private df f11033a;

    /* renamed from: b, reason: collision with root package name */
    private String f11034b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void a(int i6, String str, NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i6);

        void a(List<NativeResponse> list);

        void b();

        void b(int i6, String str, NativeResponse nativeResponse);

        void b(NativeResponse nativeResponse);

        void c();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public g(Context context, String str, a aVar, boolean z5, int i6) {
        this(context, aVar, new df(context, str, "feed", z5, i6));
    }

    public void a() {
        df dfVar = this.f11033a;
        if (dfVar != null) {
            dfVar.p();
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public g(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z5, int i6) {
        df dfVar = new df(context, str, "feed", z5, i6);
        this.f11033a = dfVar;
        dfVar.a(expressAdListener);
        this.f11033a.a(1);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        df dfVar = this.f11033a;
        if (dfVar != null) {
            dfVar.h(this.f11034b);
        }
        this.f11033a.a(requestParameters);
        this.f11033a.a();
    }

    public void a(b bVar) {
        df dfVar = this.f11033a;
        if (dfVar != null) {
            dfVar.a(bVar);
        }
    }

    public void a(int i6) {
        df dfVar = this.f11033a;
        if (dfVar != null) {
            dfVar.f10738r = i6;
        }
    }

    public g(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z5, int i6) {
        df dfVar = new df(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z5, i6);
        this.f11033a = dfVar;
        dfVar.a(entryAdListener);
    }

    public void a(boolean z5) {
        df dfVar = this.f11033a;
        if (dfVar != null) {
            dfVar.c(z5);
        }
    }

    public void b(String str) {
        this.f11034b = str;
    }

    public g(Context context, String str, a aVar, boolean z5, int i6, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.f11033a = new df(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z5, i6);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.f11033a = new df(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z5, i6);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.f11033a = new df(context, str, "video", z5, i6);
            } else {
                this.f11033a = new df(context, str, "feed", z5, i6);
            }
        }
        this.f11033a.a(aVar);
    }

    public String a(RequestParameters requestParameters) {
        if (this.f11033a == null) {
            return null;
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.f11033a.h(this.f11034b);
        this.f11033a.a(requestParameters);
        return this.f11033a.l();
    }

    public void a(String str) {
        df dfVar = this.f11033a;
        if (dfVar != null) {
            dfVar.b(str);
        }
    }

    public g(Context context, a aVar, df dfVar) {
        this.f11033a = dfVar;
        dfVar.a(aVar);
    }
}
