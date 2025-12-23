package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f45321c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final x f45322d = new x(null, null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private KmVariance f45323a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private u f45324b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f45323a == xVar.f45323a && g0.g(this.f45324b, xVar.f45324b);
    }

    @Nullable
    public final KmVariance a() {
        return this.f45323a;
    }

    @Nullable
    public final u b() {
        return this.f45324b;
    }

    public int hashCode() {
        KmVariance kmVariance = this.f45323a;
        int hashCode = (kmVariance == null ? 0 : kmVariance.hashCode()) * 31;
        u uVar = this.f45324b;
        return hashCode + (uVar != null ? uVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "KmTypeProjection(variance=" + this.f45323a + ", type=" + this.f45324b + ')';
    }

    public x(@Nullable KmVariance kmVariance, @Nullable u uVar) {
        this.f45323a = kmVariance;
        this.f45324b = uVar;
    }
}
