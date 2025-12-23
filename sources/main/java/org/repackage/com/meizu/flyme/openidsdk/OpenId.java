package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: D:\Downloads\app\classes7.dex */
class OpenId {

    /* renamed from: a, reason: collision with root package name */
    long f51584a;

    /* renamed from: b, reason: collision with root package name */
    String f51585b;

    /* renamed from: c, reason: collision with root package name */
    String f51586c;

    /* renamed from: d, reason: collision with root package name */
    int f51587d;

    void a(int i6) {
        this.f51587d = i6;
    }

    void a(long j6) {
        this.f51584a = j6;
    }

    void b() {
        this.f51584a = 0L;
    }

    OpenId(String str) {
        this.f51586c = str;
    }

    void a(String str) {
        this.f51585b = str;
    }

    boolean a() {
        return this.f51584a > System.currentTimeMillis();
    }
}
