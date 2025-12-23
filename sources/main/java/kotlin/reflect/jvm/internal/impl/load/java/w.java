package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<AnnotationQualifierApplicabilityType> f45850a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<AnnotationQualifierApplicabilityType> f45851b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, v> f45852c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, v> f45853d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, v> f45854e;

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        List<AnnotationQualifierApplicabilityType> Q = kotlin.collections.f0.Q(AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);
        f45850a = Q;
        List<AnnotationQualifierApplicabilityType> l6 = kotlin.collections.f0.l(annotationQualifierApplicabilityType);
        f45851b = l6;
        kotlin.reflect.jvm.internal.impl.name.c k6 = j0.k();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        Map<kotlin.reflect.jvm.internal.impl.name.c, v> W = i1.W(kotlin.o0.a(k6, new v(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j(nullabilityQualifier, false, 2, null), Q, false)), kotlin.o0.a(j0.i(), new v(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j(nullabilityQualifier, false, 2, null), Q, false)), kotlin.o0.a(j0.j(), new v(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j(NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null), Q, false, 4, null)));
        f45852c = W;
        Map<kotlin.reflect.jvm.internal.impl.name.c, v> W2 = i1.W(kotlin.o0.a(j0.d(), new v(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j(nullabilityQualifier, false, 2, null), l6, false, 4, null)), kotlin.o0.a(j0.e(), new v(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j(NullabilityQualifier.NULLABLE, false, 2, null), l6, false, 4, null)));
        f45853d = W2;
        f45854e = i1.n0(W, W2);
    }

    @NotNull
    public static final Map<kotlin.reflect.jvm.internal.impl.name.c, v> a() {
        return f45854e;
    }

    @NotNull
    public static final Map<kotlin.reflect.jvm.internal.impl.name.c, v> b() {
        return f45852c;
    }
}
