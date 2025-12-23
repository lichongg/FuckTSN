package com.huawei.hms.hatool;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class n0 {

    /* renamed from: b, reason: collision with root package name */
    private static n0 f33613b = new n0();

    /* renamed from: a, reason: collision with root package name */
    private a f33614a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a {

        /* renamed from: a, reason: collision with root package name */
        String f33615a;

        /* renamed from: b, reason: collision with root package name */
        String f33616b;

        /* renamed from: c, reason: collision with root package name */
        long f33617c = 0;

        a() {
        }

        void a(long j6) {
            n0.this.f33614a.f33617c = j6;
        }

        void b(String str) {
            n0.this.f33614a.f33616b = str;
        }

        void c(String str) {
            n0.this.f33614a.f33615a = str;
        }
    }

    public static n0 f() {
        return f33613b;
    }

    public String b() {
        return this.f33614a.f33616b;
    }

    public long d() {
        return this.f33614a.f33617c;
    }

    public String e() {
        return this.f33614a.f33615a;
    }

    public void c(String str, String str2) {
        long d6 = d();
        String d7 = l1.d(str, str2);
        if (d7 != null && !d7.isEmpty()) {
            if (d6 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                String e6 = d2.b.e(16);
                String a6 = w.a(d7, e6);
                this.f33614a.a(currentTimeMillis);
                this.f33614a.c(e6);
                this.f33614a.b(a6);
                return;
            }
            if (System.currentTimeMillis() - d6 > 43200000) {
                String e7 = d2.b.e(16);
                String a7 = w.a(d7, e7);
                this.f33614a.a(d6);
                this.f33614a.c(e7);
                this.f33614a.b(a7);
                return;
            }
            return;
        }
        j1.l("WorkKeyHandler", "get rsa pubkey config error");
    }
}
