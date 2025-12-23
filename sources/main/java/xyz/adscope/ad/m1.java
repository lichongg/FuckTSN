package xyz.adscope.ad;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    private final String f55402a;

    /* renamed from: b, reason: collision with root package name */
    private final long f55403b = System.currentTimeMillis();

    /* renamed from: c, reason: collision with root package name */
    private final String f55404c;

    private String a(String str) {
        return str.contains("xyz.adscope.ad") ? "AdScope-ASNP" : str.contains("xyz.adscope.common") ? "AdScope-Foundation" : "";
    }

    public String b() {
        return this.f55402a;
    }

    public long c() {
        return this.f55403b;
    }

    m1(String str) {
        this.f55402a = str;
        this.f55404c = a(str);
    }

    public String a() {
        return this.f55404c;
    }
}
