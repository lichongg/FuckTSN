package kotlin.random;

import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class c extends java.util.Random {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f44146c = new a(null);
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Random f44147a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f44148b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.f44147a.nextInt();
    }

    public c(@NotNull Random impl) {
        g0.p(impl, "impl");
        this.f44147a = impl;
    }

    @NotNull
    public final Random a() {
        return this.f44147a;
    }

    @Override // java.util.Random
    protected int next(int i6) {
        return this.f44147a.nextBits(i6);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.f44147a.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(@NotNull byte[] bytes) {
        g0.p(bytes, "bytes");
        this.f44147a.nextBytes(bytes);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.f44147a.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.f44147a.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt(int i6) {
        return this.f44147a.nextInt(i6);
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.f44147a.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j6) {
        if (this.f44148b) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.f44148b = true;
    }
}
