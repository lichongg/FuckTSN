package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CF548F19A")
/* loaded from: D:\Downloads\app\classes2.dex */
public class ProximityLocationResult {
    public float accuracy;
    public boolean is2d;
    public double timestamp;
    public double validTime;

    /* renamed from: x, reason: collision with root package name */
    public float f1434x;

    /* renamed from: y, reason: collision with root package name */
    public float f1435y;

    /* renamed from: z, reason: collision with root package name */
    public float f1436z;

    public ProximityLocationResult() {
    }

    public ProximityLocationResult(float x5, float y5, float z5, float accuracy, double timestamp, boolean is2d, double validTime) {
        this.f1434x = x5;
        this.f1435y = y5;
        this.f1436z = z5;
        this.accuracy = accuracy;
        this.timestamp = timestamp;
        this.is2d = is2d;
        this.validTime = validTime;
    }
}
