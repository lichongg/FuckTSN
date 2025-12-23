package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.l2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nsignatureEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureParts\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,296:1\n1#2:297\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class l1 extends d<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.a f45809a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f45810b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45811c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final AnnotationQualifierApplicabilityType f45812d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f45813e;

    public /* synthetic */ l1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z5, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z6, int i6, kotlin.jvm.internal.v vVar) {
        this(aVar, z5, kVar, annotationQualifierApplicabilityType, (i6 & 16) != 0 ? false : z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    @Nullable
    protected j t(@Nullable j jVar, @Nullable kotlin.reflect.jvm.internal.impl.load.java.v vVar) {
        j b6;
        if (jVar != null && (b6 = j.b(jVar, NullabilityQualifier.NOT_NULL, false, 2, null)) != null) {
            return b6;
        }
        if (vVar != null) {
            return vVar.d();
        }
        return null;
    }

    public l1(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k containerContext, @NotNull AnnotationQualifierApplicabilityType containerApplicabilityType, boolean z6) {
        kotlin.jvm.internal.g0.p(containerContext, "containerContext");
        kotlin.jvm.internal.g0.p(containerApplicabilityType, "containerApplicabilityType");
        this.f45809a = aVar;
        this.f45810b = z5;
        this.f45811c = containerContext;
        this.f45812d = containerApplicabilityType;
        this.f45813e = z6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    public boolean B(@NotNull e4.g gVar) {
        kotlin.jvm.internal.g0.p(gVar, "<this>");
        return kotlin.reflect.jvm.internal.impl.builtins.j.f0((kotlin.reflect.jvm.internal.impl.types.t0) gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    public boolean C() {
        return this.f45810b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    public boolean D(@NotNull e4.g gVar, @NotNull e4.g other) {
        kotlin.jvm.internal.g0.p(gVar, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        return this.f45811c.a().k().a((kotlin.reflect.jvm.internal.impl.types.t0) gVar, (kotlin.reflect.jvm.internal.impl.types.t0) other);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    public boolean E(@NotNull e4.p pVar) {
        kotlin.jvm.internal.g0.p(pVar, "<this>");
        return pVar instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    public boolean F(@NotNull e4.g gVar) {
        kotlin.jvm.internal.g0.p(gVar, "<this>");
        return ((kotlin.reflect.jvm.internal.impl.types.t0) gVar).L0() instanceof i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public boolean l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, @Nullable e4.g gVar) {
        kotlin.jvm.internal.g0.p(cVar, "<this>");
        if ((cVar instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.g) && ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.g) cVar).e()) {
            return true;
        }
        if ((cVar instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j) && !u() && (((kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j) cVar).k() || q() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS)) {
            return true;
        }
        return gVar != null && kotlin.reflect.jvm.internal.impl.builtins.j.r0((kotlin.reflect.jvm.internal.impl.types.t0) gVar) && m().p(cVar) && !this.f45811c.a().q().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    @NotNull
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.load.java.c m() {
        return this.f45811c.a().a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    @Nullable
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.types.t0 v(@NotNull e4.g gVar) {
        kotlin.jvm.internal.g0.p(gVar, "<this>");
        return l2.a((kotlin.reflect.jvm.internal.impl.types.t0) gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    @NotNull
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public e4.t A() {
        return kotlin.reflect.jvm.internal.impl.types.checker.u.f47196a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    @NotNull
    public Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> n(@NotNull e4.g gVar) {
        kotlin.jvm.internal.g0.p(gVar, "<this>");
        return ((kotlin.reflect.jvm.internal.impl.types.t0) gVar).getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    @NotNull
    public Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> p() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar = this.f45809a;
        return (aVar == null || (annotations = aVar.getAnnotations()) == null) ? kotlin.collections.f0.J() : annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    @NotNull
    public AnnotationQualifierApplicabilityType q() {
        return this.f45812d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.load.java.e0 r() {
        return this.f45811c.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    public boolean s() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar = this.f45809a;
        return (aVar instanceof q1) && ((q1) aVar).z0() != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    public boolean u() {
        return this.f45811c.a().q().c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.d x(@NotNull e4.g gVar) {
        kotlin.jvm.internal.g0.p(gVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.d f6 = j2.f((kotlin.reflect.jvm.internal.impl.types.t0) gVar);
        if (f6 != null) {
            return kotlin.reflect.jvm.internal.impl.resolve.i.m(f6);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
    public boolean z() {
        return this.f45813e;
    }
}
