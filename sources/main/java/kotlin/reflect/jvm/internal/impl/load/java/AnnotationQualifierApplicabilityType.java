package kotlin.reflect.jvm.internal.impl.load.java;

import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class AnnotationQualifierApplicabilityType {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ AnnotationQualifierApplicabilityType[] $VALUES;

    @NotNull
    private final String javaTarget;
    public static final AnnotationQualifierApplicabilityType METHOD_RETURN_TYPE = new AnnotationQualifierApplicabilityType("METHOD_RETURN_TYPE", 0, "METHOD");
    public static final AnnotationQualifierApplicabilityType VALUE_PARAMETER = new AnnotationQualifierApplicabilityType("VALUE_PARAMETER", 1, "PARAMETER");
    public static final AnnotationQualifierApplicabilityType FIELD = new AnnotationQualifierApplicabilityType("FIELD", 2, "FIELD");
    public static final AnnotationQualifierApplicabilityType TYPE_USE = new AnnotationQualifierApplicabilityType("TYPE_USE", 3, "TYPE_USE");
    public static final AnnotationQualifierApplicabilityType TYPE_PARAMETER_BOUNDS = new AnnotationQualifierApplicabilityType("TYPE_PARAMETER_BOUNDS", 4, "TYPE_USE");
    public static final AnnotationQualifierApplicabilityType TYPE_PARAMETER = new AnnotationQualifierApplicabilityType("TYPE_PARAMETER", 5, "TYPE_PARAMETER");

    private static final /* synthetic */ AnnotationQualifierApplicabilityType[] $values() {
        return new AnnotationQualifierApplicabilityType[]{METHOD_RETURN_TYPE, VALUE_PARAMETER, FIELD, TYPE_USE, TYPE_PARAMETER_BOUNDS, TYPE_PARAMETER};
    }

    static {
        AnnotationQualifierApplicabilityType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static AnnotationQualifierApplicabilityType valueOf(String str) {
        return (AnnotationQualifierApplicabilityType) Enum.valueOf(AnnotationQualifierApplicabilityType.class, str);
    }

    public static AnnotationQualifierApplicabilityType[] values() {
        return (AnnotationQualifierApplicabilityType[]) $VALUES.clone();
    }

    @NotNull
    public final String getJavaTarget() {
        return this.javaTarget;
    }

    private AnnotationQualifierApplicabilityType(String str, int i6, String str2) {
        this.javaTarget = str2;
    }
}
