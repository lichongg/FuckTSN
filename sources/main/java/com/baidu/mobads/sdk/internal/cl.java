package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.acse.ottn.l3;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class cl {

    /* renamed from: b, reason: collision with root package name */
    public static final String f10887b = "404";

    /* renamed from: c, reason: collision with root package name */
    public static final int f10888c = 843;

    /* renamed from: d, reason: collision with root package name */
    protected final bu f10896d = bu.a();

    /* renamed from: h, reason: collision with root package name */
    private Context f10897h;

    /* renamed from: a, reason: collision with root package name */
    public static final String f10886a = z.f11212b;

    /* renamed from: g, reason: collision with root package name */
    private static cl f10891g = new cl();

    /* renamed from: e, reason: collision with root package name */
    public static volatile String f10889e = "";

    /* renamed from: f, reason: collision with root package name */
    public static volatile String f10890f = "";

    /* renamed from: i, reason: collision with root package name */
    private static AtomicBoolean f10892i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private static String f10893j = "";

    /* renamed from: k, reason: collision with root package name */
    private static AtomicBoolean f10894k = new AtomicBoolean(false);

    /* renamed from: l, reason: collision with root package name */
    private static String f10895l = "";

    public static cl a() {
        return f10891g;
    }

    private String d() {
        String str = cm.f10902e;
        if (cm.f10901d.equals(str)) {
            try {
                double b6 = ca.b(ca.a(this.f10897h));
                if (b6 > 0.0d) {
                    return String.valueOf(b6);
                }
            } catch (Throwable th) {
                this.f10896d.a(th);
            }
        }
        return str;
    }

    public void a(Context context) {
        if (this.f10897h == null) {
            this.f10897h = context;
        }
    }

    public String b() {
        try {
            if (f10892i.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", null).invoke(cls, null);
                if (!TextUtils.isEmpty(str)) {
                    f10893j = str;
                }
            }
            return f10893j;
        } catch (Throwable th) {
            this.f10896d.a(th);
            return f10893j;
        }
    }

    public String c() {
        try {
            if (f10894k.get()) {
                return f10895l;
            }
            if (!f10892i.get()) {
                b();
            }
            if (f10893j.equalsIgnoreCase("")) {
                f10894k.set(true);
                return "";
            }
            if (f10894k.compareAndSet(false, true)) {
                String a6 = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(a6)) {
                    f10895l = a6;
                }
            }
            return f10895l;
        } catch (Throwable th) {
            this.f10896d.a(th);
            return f10895l;
        }
    }

    private cl() {
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.umeng.analytics.pro.bi.az, str3);
            hashMap.put("stacktrace", str2);
            a(str, f10887b, hashMap);
        } catch (Exception e6) {
            this.f10896d.a(e6);
        }
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder builder = new Uri.Builder();
        try {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter("subtype", String.valueOf(f10888c)).appendQueryParameter(com.umeng.analytics.pro.bi.bg, "9.40").appendQueryParameter("appsid", a("appsid", new Object[0])).appendQueryParameter("v", "android_" + d() + "_" + cm.f10903f);
            Context context = this.f10897h;
            appendQueryParameter.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.f10897h)).appendQueryParameter("cuid", a("encodedCUID", this.f10897h)).appendQueryParameter("os", FaceEnvironment.OS).appendQueryParameter("osv", bn.a(this.f10897h).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c()).appendQueryParameter("bdr", "" + bn.a(this.f10897h).a()).appendQueryParameter("brd", "" + a(bn.a(this.f10897h).e()));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter(MediationConstant.KEY_REASON, str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f10896d.a(th);
        }
        an anVar = new an(f10886a, "POST");
        anVar.a(builder);
        anVar.b();
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory c6;
        aa a6 = aa.a();
        if (a6 != null && (c6 = a6.c()) != null) {
            Object remoteParam = c6.getRemoteParam(str, objArr);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
            return "";
        }
        return "";
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod(l3.f4736f, String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.f10896d.a(th);
            return str2;
        }
    }
}
