package cn.jiguang.bi;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    int f2221a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f2222b;

    /* renamed from: c, reason: collision with root package name */
    public String f2223c;

    /* renamed from: d, reason: collision with root package name */
    int f2224d;

    /* renamed from: e, reason: collision with root package name */
    int f2225e;

    /* renamed from: f, reason: collision with root package name */
    long f2226f;

    /* renamed from: g, reason: collision with root package name */
    byte[] f2227g;

    /* renamed from: h, reason: collision with root package name */
    long f2228h;

    /* renamed from: i, reason: collision with root package name */
    long f2229i;

    /* renamed from: j, reason: collision with root package name */
    boolean f2230j;

    public void a() {
        this.f2221a++;
    }

    public String toString() {
        return "InnerRequest{times=" + this.f2221a + ", requestId=" + this.f2222b + ", sdkType='" + this.f2223c + "', command=" + this.f2224d + ", ver=" + this.f2225e + ", rid=" + this.f2226f + ", reqeustTime=" + this.f2228h + ", timeout=" + this.f2229i + '}';
    }

    public d(long j6, String str, int i6, int i7, long j7, long j8, byte[] bArr) {
        this.f2222b = j6;
        this.f2223c = str;
        this.f2224d = i6;
        this.f2225e = i7;
        this.f2226f = j7;
        this.f2229i = j8;
        this.f2227g = bArr;
        if (j8 > 0) {
            this.f2230j = true;
        }
    }
}
