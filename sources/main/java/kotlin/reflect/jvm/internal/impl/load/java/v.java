package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j f45847a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Collection<AnnotationQualifierApplicabilityType> f45848b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f45849c;

    /* JADX WARN: Multi-variable type inference failed */
    public v(@NotNull kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j nullabilityQualifier, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z5) {
        kotlin.jvm.internal.g0.p(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.g0.p(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.f45847a = nullabilityQualifier;
        this.f45848b = qualifierApplicabilityTypes;
        this.f45849c = z5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return kotlin.jvm.internal.g0.g(this.f45847a, vVar.f45847a) && kotlin.jvm.internal.g0.g(this.f45848b, vVar.f45848b) && this.f45849c == vVar.f45849c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ v b(v vVar, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j jVar, Collection collection, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            jVar = vVar.f45847a;
        }
        if ((i6 & 2) != 0) {
            collection = vVar.f45848b;
        }
        if ((i6 & 4) != 0) {
            z5 = vVar.f45849c;
        }
        return vVar.a(jVar, collection, z5);
    }

    @NotNull
    public final v a(@NotNull kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j nullabilityQualifier, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z5) {
        kotlin.jvm.internal.g0.p(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.g0.p(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        return new v(nullabilityQualifier, qualifierApplicabilityTypes, z5);
    }

    public final boolean c() {
        return this.f45849c;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j d() {
        return this.f45847a;
    }

    @NotNull
    public final Collection<AnnotationQualifierApplicabilityType> e() {
        return this.f45848b;
    }

    public int hashCode() {
        return (((this.f45847a.hashCode() * 31) + this.f45848b.hashCode()) * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.f45849c);
    }

    @NotNull
    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f45847a + ", qualifierApplicabilityTypes=" + this.f45848b + ", definitelyNotNull=" + this.f45849c + ')';
    }

    public /* synthetic */ v(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j jVar, Collection collection, boolean z5, int i6, kotlin.jvm.internal.v vVar) {
        this(jVar, collection, (i6 & 4) != 0 ? jVar.c() == NullabilityQualifier.NOT_NULL : z5);
    }
}
