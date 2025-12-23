package kotlin.random;

import java.io.InvalidObjectException;
import java.io.Serializable;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nXorWowRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XorWowRandom.kt\nkotlin/random/XorWowRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class XorWowRandom extends Random implements Serializable {

    @NotNull
    private static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    private int addend;

    /* renamed from: v, reason: collision with root package name */
    private int f44140v;

    /* renamed from: w, reason: collision with root package name */
    private int f44141w;

    /* renamed from: x, reason: collision with root package name */
    private int f44142x;

    /* renamed from: y, reason: collision with root package name */
    private int f44143y;

    /* renamed from: z, reason: collision with root package name */
    private int f44144z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    public XorWowRandom(int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f44142x = i6;
        this.f44143y = i7;
        this.f44144z = i8;
        this.f44141w = i9;
        this.f44140v = i10;
        this.addend = i11;
        checkInvariants();
        for (int i12 = 0; i12 < 64; i12++) {
            nextInt();
        }
    }

    private final void checkInvariants() {
        if ((this.f44142x | this.f44143y | this.f44144z | this.f44141w | this.f44140v) == 0) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.");
        }
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int i6 = this.f44142x;
        int i7 = i6 ^ (i6 >>> 2);
        this.f44142x = this.f44143y;
        this.f44143y = this.f44144z;
        this.f44144z = this.f44141w;
        int i8 = this.f44140v;
        this.f44141w = i8;
        int i9 = ((i7 ^ (i7 << 1)) ^ i8) ^ (i8 << 4);
        this.f44140v = i9;
        int i10 = this.addend + 362437;
        this.addend = i10;
        return i9 + i10;
    }

    private final Object readResolve() {
        try {
            checkInvariants();
            return this;
        } catch (Throwable th) {
            Throwable initCause = new InvalidObjectException(th.getMessage()).initCause(th);
            g0.o(initCause, "initCause(...)");
            throw initCause;
        }
    }

    @Override // kotlin.random.Random
    public int nextBits(int i6) {
        return f.j(nextInt(), i6);
    }

    public XorWowRandom(int i6, int i7) {
        this(i6, i7, 0, 0, ~i6, (i6 << 10) ^ (i7 >>> 4));
    }
}
