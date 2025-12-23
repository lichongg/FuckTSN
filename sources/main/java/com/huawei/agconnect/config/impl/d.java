package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.i;
import com.stub.StubApp;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes5.dex */
public class d implements com.huawei.agconnect.e {

    /* renamed from: a, reason: collision with root package name */
    private final String f32924a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f32925b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32926c;

    /* renamed from: d, reason: collision with root package name */
    private final com.huawei.agconnect.b f32927d;

    /* renamed from: e, reason: collision with root package name */
    private final f f32928e;

    /* renamed from: f, reason: collision with root package name */
    private final g f32929f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, String> f32930g;

    /* renamed from: h, reason: collision with root package name */
    private final List<com.huawei.agconnect.core.b> f32931h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, String> f32932i = new HashMap();

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

    private String f() {
        return String.valueOf(("{packageName='" + this.f32926c + "', routePolicy=" + this.f32927d + ", reader=" + this.f32928e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f32930g).toString().hashCode() + '}').hashCode());
    }

    @Override // com.huawei.agconnect.e
    public com.huawei.agconnect.b c() {
        com.huawei.agconnect.b bVar = this.f32927d;
        return bVar == null ? com.huawei.agconnect.b.f32910b : bVar;
    }

    public List<com.huawei.agconnect.core.b> e() {
        return this.f32931h;
    }

    @Override // com.huawei.agconnect.e
    public Context getContext() {
        return this.f32925b;
    }

    @Override // com.huawei.agconnect.e
    public String getIdentifier() {
        return this.f32924a;
    }

    @Override // com.huawei.agconnect.e
    public String getPackageName() {
        return this.f32926c;
    }

    @Override // com.huawei.agconnect.e
    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String e6 = b.e(str);
        String str3 = this.f32930g.get(e6);
        if (str3 != null) {
            return str3;
        }
        String d6 = d(e6);
        if (d6 != null) {
            return d6;
        }
        String a6 = this.f32928e.a(e6, str2);
        return g.c(a6) ? this.f32929f.a(a6, str2) : a6;
    }

    public d(Context context, String str, com.huawei.agconnect.b bVar, InputStream inputStream, Map<String, String> map, List<com.huawei.agconnect.core.b> list, String str2) {
        context = StubApp.getOrigApplicationContext(context.getApplicationContext()) != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : context;
        this.f32925b = context;
        str = str == null ? context.getPackageName() : str;
        this.f32926c = str;
        if (inputStream != null) {
            this.f32928e = new j(inputStream, str);
            b.a(inputStream);
        } else {
            this.f32928e = new m(context, str);
        }
        this.f32929f = new g(this.f32928e);
        com.huawei.agconnect.b bVar2 = com.huawei.agconnect.b.f32910b;
        if (bVar != bVar2 && "1.0".equals(this.f32928e.a("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f32927d = (bVar == null || bVar == bVar2) ? b.f(this.f32928e.a("/region", null), this.f32928e.a("/agcgw/url", null)) : bVar;
        this.f32930g = b.d(map);
        this.f32931h = list;
        this.f32924a = str2 == null ? f() : str2;
    }

    private String d(String str) {
        Map<String, i.a> a6 = com.huawei.agconnect.i.a();
        if (!a6.containsKey(str)) {
            return null;
        }
        if (this.f32932i.containsKey(str)) {
            return this.f32932i.get(str);
        }
        i.a aVar = a6.get(str);
        if (aVar == null) {
            return null;
        }
        String a7 = aVar.a(this);
        this.f32932i.put(str, a7);
        return a7;
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
