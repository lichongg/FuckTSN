package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.EnumMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final EnumMap<AnnotationQualifierApplicabilityType, v> f45425a;

    public e0(@NotNull EnumMap<AnnotationQualifierApplicabilityType, v> defaultQualifiers) {
        kotlin.jvm.internal.g0.p(defaultQualifiers, "defaultQualifiers");
        this.f45425a = defaultQualifiers;
    }

    @Nullable
    public final v a(@Nullable AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.f45425a.get(annotationQualifierApplicabilityType);
    }

    @NotNull
    public final EnumMap<AnnotationQualifierApplicabilityType, v> b() {
        return this.f45425a;
    }
}
