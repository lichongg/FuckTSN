package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.e1;
import com.amap.api.col.s.i4;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.y;
import com.amap.api.col.s.z0;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;

    /* renamed from: c, reason: collision with root package name */
    private static ServiceSettings f9241c;

    /* renamed from: a, reason: collision with root package name */
    private String f9242a = "zh-CN";

    /* renamed from: b, reason: collision with root package name */
    private int f9243b = 1;

    /* renamed from: d, reason: collision with root package name */
    private int f9244d = 20000;

    /* renamed from: e, reason: collision with root package name */
    private int f9245e = 20000;

    public static ServiceSettings getInstance() {
        if (f9241c == null) {
            f9241c = new ServiceSettings();
        }
        return f9241c;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z5) {
        synchronized (ServiceSettings.class) {
            cf.i(context, z5, i4.a(false));
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z5, boolean z6) {
        synchronized (ServiceSettings.class) {
            cf.j(context, z5, z6, i4.a(false));
        }
    }

    public int getConnectionTimeOut() {
        return this.f9244d;
    }

    public String getLanguage() {
        return this.f9242a;
    }

    public int getProtocol() {
        return this.f9243b;
    }

    public int getSoTimeOut() {
        return this.f9245e;
    }

    public void setConnectionTimeOut(int i6) {
        if (i6 < 5000) {
            this.f9244d = 5000;
        } else if (i6 > 30000) {
            this.f9244d = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        } else {
            this.f9244d = i6;
        }
    }

    public void setLanguage(String str) {
        this.f9242a = str;
    }

    public void setProtocol(int i6) {
        this.f9243b = i6;
        e1.a().e(this.f9243b == 2);
    }

    public void setSoTimeOut(int i6) {
        if (i6 < 5000) {
            this.f9245e = 5000;
        } else if (i6 > 30000) {
            this.f9245e = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        } else {
            this.f9245e = i6;
        }
    }

    private ServiceSettings() {
    }

    public void destroyInnerAsynThreadPool() {
        try {
            y.c();
        } catch (Throwable th) {
            j4.i(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public void setApiKey(String str) {
        z0.a(str);
    }
}
