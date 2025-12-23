package k0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: f, reason: collision with root package name */
    private static final float f43546f = 9.0f;

    /* renamed from: g, reason: collision with root package name */
    private static final float f43547g = 9.0f;

    /* renamed from: a, reason: collision with root package name */
    private final String f43548a;

    /* renamed from: b, reason: collision with root package name */
    private final float f43549b;

    /* renamed from: c, reason: collision with root package name */
    private final float f43550c;

    /* renamed from: d, reason: collision with root package name */
    private int f43551d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f43552e;

    public j(String className) {
        this(className, 9.0f, 9.0f);
    }

    public j(String className, float enterThreshold, float exitThreshold) {
        this.f43548a = className;
        this.f43549b = enterThreshold;
        this.f43550c = exitThreshold;
        this.f43551d = 0;
        this.f43552e = false;
    }

    public int a(b classificationResult) {
        float c6 = classificationResult.c(this.f43548a);
        if (!this.f43552e) {
            this.f43552e = c6 > this.f43549b;
            return this.f43551d;
        }
        if (c6 < this.f43550c) {
            this.f43551d++;
            this.f43552e = false;
        }
        return this.f43551d;
    }

    public String b() {
        return this.f43548a;
    }

    public int c() {
        return this.f43551d;
    }
}
