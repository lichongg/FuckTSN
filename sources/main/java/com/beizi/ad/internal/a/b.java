package com.beizi.ad.internal.a;

import com.beizi.ad.internal.h.o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends com.beizi.ad.internal.b.a.a {

    /* renamed from: a, reason: collision with root package name */
    private String f11443a;

    /* renamed from: b, reason: collision with root package name */
    private String f11444b;

    /* renamed from: c, reason: collision with root package name */
    private String f11445c;

    /* renamed from: d, reason: collision with root package name */
    private String f11446d;

    public String a() {
        return this.f11443a;
    }

    public long b() {
        return o.c(this.f11444b);
    }

    public void a(String str) {
        this.f11443a = str;
    }

    public void b(long j6) {
        this.f11445c = String.valueOf(j6);
    }

    public long c() {
        return o.c(this.f11445c);
    }

    public String d() {
        return this.f11446d;
    }

    public String toString() {
        return "{\"spaceId\":\"" + this.f11443a + "\",\"cacheTime\":\"" + this.f11444b + "\",\"expireTime\":\"" + this.f11445c + "\",\"requestId\":\"" + this.f11446d + "\"}";
    }

    public void a(long j6) {
        this.f11444b = String.valueOf(j6);
    }

    public void b(String str) {
        this.f11446d = str;
    }
}
