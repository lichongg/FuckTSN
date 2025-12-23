package com.tencent.open.a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class c implements g {

    /* renamed from: a, reason: collision with root package name */
    private String f40491a;

    /* renamed from: b, reason: collision with root package name */
    private int f40492b;

    /* renamed from: c, reason: collision with root package name */
    private int f40493c;

    /* renamed from: d, reason: collision with root package name */
    private int f40494d;

    /* renamed from: e, reason: collision with root package name */
    private String f40495e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, List<String>> f40496f = new HashMap();

    @Override // com.tencent.open.a.g
    public String a() {
        return this.f40491a;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f40492b;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f40493c;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f40494d;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + "\ncontent = [" + this.f40491a + "]\nresponseSize = " + this.f40492b + "\nrequestSize = " + this.f40493c + "\nresultCode = " + this.f40494d + "\nerrorMsg = " + this.f40495e;
    }

    public c(HttpURLConnection httpURLConnection, String str, int i6, int i7, int i8, String str2) {
        Map<String, List<String>> headerFields;
        this.f40491a = str;
        this.f40492b = i6;
        this.f40493c = i7;
        this.f40494d = i8;
        this.f40495e = str2;
        if (httpURLConnection != null && (headerFields = httpURLConnection.getHeaderFields()) != null) {
            this.f40496f.putAll(headerFields);
        }
    }
}
