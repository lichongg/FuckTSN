package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t0 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f46914c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final t0 f46915d = new t0(false, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f46916a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<String> f46917b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public t0(boolean z5, @NotNull List<String> poisoningFeatures) {
        kotlin.jvm.internal.g0.p(poisoningFeatures, "poisoningFeatures");
        this.f46916a = z5;
        this.f46917b = poisoningFeatures;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f46916a == t0Var.f46916a && kotlin.jvm.internal.g0.g(this.f46917b, t0Var.f46917b);
    }

    public /* synthetic */ t0(boolean z5, List list, int i6, kotlin.jvm.internal.v vVar) {
        this(z5, (i6 & 2) != 0 ? kotlin.collections.f0.J() : list);
    }

    public int hashCode() {
        return (kotlin.reflect.jvm.internal.impl.km.f.a(this.f46916a) * 31) + this.f46917b.hashCode();
    }

    @NotNull
    public String toString() {
        return "PreReleaseInfo(isInvisible=" + this.f46916a + ", poisoningFeatures=" + this.f46917b + ')';
    }
}
