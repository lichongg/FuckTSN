package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes5.dex */
public class c extends com.huawei.agconnect.c {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, com.huawei.agconnect.c> f32920b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f32921c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static String f32922d;

    /* renamed from: a, reason: collision with root package name */
    private j1.a f32923a;

    public static com.huawei.agconnect.c n() {
        return q(f32922d);
    }

    public static com.huawei.agconnect.c q(String str) {
        com.huawei.agconnect.c cVar;
        synchronized (f32921c) {
            try {
                cVar = f32920b.get(str);
                if (cVar == null) {
                    throw new IllegalStateException("you should call AGConnectApp.initialize first");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // com.huawei.agconnect.c
    public void e(String str) {
        this.f32923a.h("/client/api_key", str);
    }

    @Override // com.huawei.agconnect.c
    public void f(String str) {
        this.f32923a.h("/client/app_id", str);
    }

    @Override // com.huawei.agconnect.c
    public void g(String str) {
        this.f32923a.h("/client/client_id", str);
    }

    @Override // com.huawei.agconnect.c
    public void h(String str) {
        this.f32923a.h("/client/client_secret", str);
    }

    @Override // com.huawei.agconnect.c
    public void i(String str) {
        this.f32923a.h("/client/cp_id", str);
    }

    @Override // com.huawei.agconnect.c
    public void m(String str) {
        this.f32923a.h("/client/product_id", str);
    }

    private c(Context context, String str) {
        this.f32923a = j1.a.e(context, str);
    }

    public static com.huawei.agconnect.c o(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext != null) {
            context = origApplicationContext;
        }
        String packageName = context.getPackageName();
        f32922d = packageName;
        return p(context, packageName);
    }

    public static com.huawei.agconnect.c p(Context context, String str) {
        com.huawei.agconnect.c cVar;
        if (!TextUtils.isEmpty(str)) {
            synchronized (f32921c) {
                try {
                    Map<String, com.huawei.agconnect.c> map = f32920b;
                    cVar = map.get(str);
                    if (cVar == null) {
                        map.put(str, new c(context, str));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return cVar;
        }
        throw new IllegalArgumentException("packageName can not be empty");
    }

    @Override // com.huawei.agconnect.c
    public void j(com.huawei.agconnect.g gVar) {
        ((com.huawei.agconnect.core.a.b) com.huawei.agconnect.d.b()).o(gVar);
    }

    @Override // com.huawei.agconnect.c
    public void k(com.huawei.agconnect.h hVar) {
        ((com.huawei.agconnect.core.a.b) com.huawei.agconnect.d.b()).p(hVar);
    }

    @Override // com.huawei.agconnect.c
    public void l(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f32923a.h(str, str2);
            return;
        }
        throw new IllegalArgumentException("path can not be empty");
    }
}
