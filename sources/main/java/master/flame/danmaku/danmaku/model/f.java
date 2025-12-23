package master.flame.danmaku.danmaku.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public long f50080a;

    /* renamed from: b, reason: collision with root package name */
    private long f50081b;

    public f() {
    }

    public f(long j6) {
        update(j6);
    }

    public long a(long j6) {
        return update(this.f50080a + j6);
    }

    public long b() {
        return this.f50081b;
    }

    public long update(long j6) {
        long j7 = j6 - this.f50080a;
        this.f50081b = j7;
        this.f50080a = j6;
        return j7;
    }
}
