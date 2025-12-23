package k2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f43559a;

    /* renamed from: b, reason: collision with root package name */
    private String f43560b;

    /* renamed from: c, reason: collision with root package name */
    private int f43561c;

    /* renamed from: d, reason: collision with root package name */
    private int f43562d;

    /* renamed from: e, reason: collision with root package name */
    private long f43563e;

    public int a() {
        return this.f43562d;
    }

    public int b() {
        return this.f43559a;
    }

    public long c() {
        return this.f43563e;
    }

    public String d() {
        return this.f43560b;
    }

    public int e() {
        return this.f43561c;
    }

    public void f(int evilClass) {
        this.f43562d = evilClass;
    }

    public void g(int id) {
        this.f43559a = id;
    }

    public void h(long timestamp) {
        this.f43563e = timestamp;
    }

    public void i(String url) {
        this.f43560b = url;
    }

    public void j(int urlType) {
        this.f43561c = urlType;
    }

    public String toString() {
        return "{id=" + this.f43559a + ", url='" + this.f43560b + "', urlType=" + this.f43561c + ", evilClass=" + this.f43562d + ", timestamp=" + this.f43563e + "}\n";
    }
}
