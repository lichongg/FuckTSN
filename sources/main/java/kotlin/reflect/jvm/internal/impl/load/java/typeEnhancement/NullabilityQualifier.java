package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class NullabilityQualifier {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ NullabilityQualifier[] $VALUES;
    public static final NullabilityQualifier FORCE_FLEXIBILITY = new NullabilityQualifier("FORCE_FLEXIBILITY", 0);
    public static final NullabilityQualifier NULLABLE = new NullabilityQualifier("NULLABLE", 1);
    public static final NullabilityQualifier NOT_NULL = new NullabilityQualifier("NOT_NULL", 2);

    private static final /* synthetic */ NullabilityQualifier[] $values() {
        return new NullabilityQualifier[]{FORCE_FLEXIBILITY, NULLABLE, NOT_NULL};
    }

    static {
        NullabilityQualifier[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static NullabilityQualifier valueOf(String str) {
        return (NullabilityQualifier) Enum.valueOf(NullabilityQualifier.class, str);
    }

    public static NullabilityQualifier[] values() {
        return (NullabilityQualifier[]) $VALUES.clone();
    }

    private NullabilityQualifier(String str, int i6) {
    }
}
