package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.i;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes5.dex */
public class e extends j1.a {

    /* renamed from: c, reason: collision with root package name */
    private final Context f32933c;

    /* renamed from: d, reason: collision with root package name */
    private final String f32934d;

    /* renamed from: e, reason: collision with root package name */
    private j1.b f32935e;

    /* renamed from: f, reason: collision with root package name */
    private volatile f f32936f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f32937g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private com.huawei.agconnect.b f32938h = com.huawei.agconnect.b.f32910b;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, String> f32939i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private volatile g f32940j;

    static class a extends j1.b {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InputStream f32941c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, InputStream inputStream) {
            super(context);
            this.f32941c = inputStream;
        }

        @Override // j1.b
        public InputStream b(Context context) {
            return this.f32941c;
        }
    }

    @Override // com.huawei.agconnect.e
    public boolean a(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.e
    public int b(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.e
    public String getString(String str) {
        return getString(str, null);
    }

    private static j1.b j(Context context, InputStream inputStream) {
        return new a(context, inputStream);
    }

    private void l() {
        if (this.f32936f == null) {
            synchronized (this.f32937g) {
                try {
                    if (this.f32936f == null) {
                        j1.b bVar = this.f32935e;
                        if (bVar != null) {
                            this.f32936f = new j(bVar.c(), "UTF-8");
                            this.f32935e.a();
                            this.f32935e = null;
                        } else {
                            this.f32936f = new m(this.f32933c, this.f32934d);
                        }
                        this.f32940j = new g(this.f32936f);
                    }
                    n();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void n() {
        if (this.f32938h != com.huawei.agconnect.b.f32910b || this.f32936f == null) {
            return;
        }
        this.f32938h = b.f(this.f32936f.a("/region", null), this.f32936f.a("/agcgw/url", null));
    }

    @Override // com.huawei.agconnect.e
    public com.huawei.agconnect.b c() {
        if (this.f32938h == null) {
            this.f32938h = com.huawei.agconnect.b.f32910b;
        }
        com.huawei.agconnect.b bVar = this.f32938h;
        com.huawei.agconnect.b bVar2 = com.huawei.agconnect.b.f32910b;
        if (bVar == bVar2 && this.f32936f == null) {
            l();
        }
        com.huawei.agconnect.b bVar3 = this.f32938h;
        return bVar3 == null ? bVar2 : bVar3;
    }

    @Override // j1.a
    public void f(j1.b bVar) {
        this.f32935e = bVar;
    }

    @Override // j1.a
    public void g(InputStream inputStream) {
        f(j(this.f32933c, inputStream));
    }

    @Override // com.huawei.agconnect.e
    public Context getContext() {
        return this.f32933c;
    }

    @Override // com.huawei.agconnect.e
    public String getIdentifier() {
        return b.f32919c;
    }

    @Override // com.huawei.agconnect.e
    public String getPackageName() {
        return this.f32934d;
    }

    @Override // com.huawei.agconnect.e
    public String getString(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("path must not be null.");
        }
        if (this.f32936f == null) {
            l();
        }
        String k6 = k(str);
        String str3 = this.f32939i.get(k6);
        if (str3 != null) {
            return str3;
        }
        String m6 = m(k6);
        if (m6 != null) {
            return m6;
        }
        String a6 = this.f32936f.a(k6, str2);
        return g.c(a6) ? this.f32940j.a(a6, str2) : a6;
    }

    @Override // j1.a
    public void h(String str, String str2) {
        this.f32939i.put(b.e(str), str2);
    }

    @Override // j1.a
    public void i(com.huawei.agconnect.b bVar) {
        this.f32938h = bVar;
    }

    public e(Context context, String str) {
        this.f32933c = context;
        this.f32934d = str;
    }

    private static String k(String str) {
        int i6 = 0;
        if (str.length() > 0) {
            while (str.charAt(i6) == '/') {
                i6++;
            }
        }
        return '/' + str.substring(i6);
    }

    private String m(String str) {
        i.a aVar;
        Map<String, i.a> a6 = com.huawei.agconnect.i.a();
        if (!a6.containsKey(str) || (aVar = a6.get(str)) == null) {
            return null;
        }
        return aVar.a(this);
    }

    @Override // com.huawei.agconnect.e
    public boolean getBoolean(String str, boolean z5) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z5)));
    }

    @Override // com.huawei.agconnect.e
    public int getInt(String str, int i6) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i6)));
        } catch (NumberFormatException unused) {
            return i6;
        }
    }
}
