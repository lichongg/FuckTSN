package kotlin.uuid;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalUuidApi
/* loaded from: D:\Downloads\app\classes8.dex */
final class e implements Externalizable {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f48060c = new a(null);
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private long f48061a;

    /* renamed from: b, reason: collision with root package name */
    private long f48062b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    public e(long j6, long j7) {
        this.f48061a = j6;
        this.f48062b = j7;
    }

    private final Object readResolve() {
        return Uuid.Companion.b(this.f48061a, this.f48062b);
    }

    public final long a() {
        return this.f48062b;
    }

    public final long b() {
        return this.f48061a;
    }

    public final void c(long j6) {
        this.f48062b = j6;
    }

    public final void d(long j6) {
        this.f48061a = j6;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput input) {
        g0.p(input, "input");
        this.f48061a = input.readLong();
        this.f48062b = input.readLong();
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput output) {
        g0.p(output, "output");
        output.writeLong(this.f48061a);
        output.writeLong(this.f48062b);
    }

    public e() {
        this(0L, 0L);
    }
}
