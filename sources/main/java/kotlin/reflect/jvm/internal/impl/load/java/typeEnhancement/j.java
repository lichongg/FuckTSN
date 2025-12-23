package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final NullabilityQualifier f45791a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f45792b;

    public j(@NotNull NullabilityQualifier qualifier, boolean z5) {
        kotlin.jvm.internal.g0.p(qualifier, "qualifier");
        this.f45791a = qualifier;
        this.f45792b = z5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f45791a == jVar.f45791a && this.f45792b == jVar.f45792b;
    }

    public static /* synthetic */ j b(j jVar, NullabilityQualifier nullabilityQualifier, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            nullabilityQualifier = jVar.f45791a;
        }
        if ((i6 & 2) != 0) {
            z5 = jVar.f45792b;
        }
        return jVar.a(nullabilityQualifier, z5);
    }

    @NotNull
    public final j a(@NotNull NullabilityQualifier qualifier, boolean z5) {
        kotlin.jvm.internal.g0.p(qualifier, "qualifier");
        return new j(qualifier, z5);
    }

    @NotNull
    public final NullabilityQualifier c() {
        return this.f45791a;
    }

    public final boolean d() {
        return this.f45792b;
    }

    public int hashCode() {
        return (this.f45791a.hashCode() * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.f45792b);
    }

    @NotNull
    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f45791a + ", isForWarningOnly=" + this.f45792b + ')';
    }

    public /* synthetic */ j(NullabilityQualifier nullabilityQualifier, boolean z5, int i6, kotlin.jvm.internal.v vVar) {
        this(nullabilityQualifier, (i6 & 2) != 0 ? false : z5);
    }
}
