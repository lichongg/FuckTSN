package kotlin.time;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalTime
/* loaded from: D:\Downloads\app\classes8.dex */
final class x implements Externalizable {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f48054c = new a(null);
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private long f48055a;

    /* renamed from: b, reason: collision with root package name */
    private int f48056b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public x(long j6, int i6) {
        this.f48055a = j6;
        this.f48056b = i6;
    }

    private final Object readResolve() {
        return Instant.Companion.b(this.f48055a, this.f48056b);
    }

    public final long a() {
        return this.f48055a;
    }

    public final int b() {
        return this.f48056b;
    }

    public final void c(long j6) {
        this.f48055a = j6;
    }

    public final void d(int i6) {
        this.f48056b = i6;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput input) {
        kotlin.jvm.internal.g0.p(input, "input");
        this.f48055a = input.readLong();
        this.f48056b = input.readInt();
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput output) {
        kotlin.jvm.internal.g0.p(output, "output");
        output.writeLong(this.f48055a);
        output.writeInt(this.f48056b);
    }

    public x() {
        this(0L, 0);
    }
}
