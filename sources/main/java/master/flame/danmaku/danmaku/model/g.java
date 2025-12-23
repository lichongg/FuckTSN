package master.flame.danmaku.danmaku.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private long f50082a;

    /* renamed from: b, reason: collision with root package name */
    private float f50083b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    public long f50084c;

    public void a(float f6) {
        if (this.f50083b != f6) {
            this.f50083b = f6;
            this.f50084c = (long) (this.f50082a * f6);
        }
    }

    public void b(long j6) {
        this.f50082a = j6;
        this.f50084c = (long) (j6 * this.f50083b);
    }

    public g(long j6) {
        this.f50082a = j6;
        this.f50084c = j6;
    }
}
