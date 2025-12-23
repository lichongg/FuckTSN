package o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b implements c {

    /* renamed from: c, reason: collision with root package name */
    public static final int f50450c = 9;

    /* renamed from: d, reason: collision with root package name */
    private static final int f50451d = 0;

    /* renamed from: a, reason: collision with root package name */
    private int f50452a;

    /* renamed from: b, reason: collision with root package name */
    private int f50453b;

    public b() {
        this(0, 9);
    }

    public b(int i6, int i7) {
        this.f50452a = i6;
        this.f50453b = i7;
    }

    @Override // o.c
    public int a() {
        return (this.f50453b - this.f50452a) + 1;
    }

    @Override // o.c
    public Object getItem(int i6) {
        if (i6 < 0 || i6 >= a()) {
            return 0;
        }
        return Integer.valueOf(this.f50452a + i6);
    }

    @Override // o.c
    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.f50452a;
        } catch (Exception unused) {
            return -1;
        }
    }
}
