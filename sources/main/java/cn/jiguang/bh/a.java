package cn.jiguang.bh;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private C0031a[] f2155a = new C0031a[17];

    /* renamed from: cn.jiguang.bh.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jiguang.bh.a$a, reason: collision with other inner class name */
    private static class C0031a {

        /* renamed from: a, reason: collision with root package name */
        g f2156a;

        /* renamed from: b, reason: collision with root package name */
        int f2157b;

        /* renamed from: c, reason: collision with root package name */
        C0031a f2158c;

        private C0031a() {
        }

        /* synthetic */ C0031a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public int a(g gVar) {
        int i6 = -1;
        for (C0031a c0031a = this.f2155a[(gVar.hashCode() & Integer.MAX_VALUE) % 17]; c0031a != null; c0031a = c0031a.f2158c) {
            if (c0031a.f2156a.equals(gVar)) {
                i6 = c0031a.f2157b;
            }
        }
        return i6;
    }

    public void a(int i6, g gVar) {
        if (i6 > 16383) {
            return;
        }
        int hashCode = (gVar.hashCode() & Integer.MAX_VALUE) % 17;
        C0031a c0031a = new C0031a(null);
        c0031a.f2156a = gVar;
        c0031a.f2157b = i6;
        C0031a[] c0031aArr = this.f2155a;
        c0031a.f2158c = c0031aArr[hashCode];
        c0031aArr[hashCode] = c0031a;
    }
}
