package rx.internal.util.unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class a0<E> extends f<E> {

    /* renamed from: x, reason: collision with root package name */
    private static final Integer f54207x = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: w, reason: collision with root package name */
    protected final int f54208w;

    public a0(int i6) {
        super(i6);
        this.f54208w = Math.min(i6 / 4, f54207x.intValue());
    }
}
