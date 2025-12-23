package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MutabilityQualifier {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ MutabilityQualifier[] $VALUES;
    public static final MutabilityQualifier READ_ONLY = new MutabilityQualifier("READ_ONLY", 0);
    public static final MutabilityQualifier MUTABLE = new MutabilityQualifier("MUTABLE", 1);

    private static final /* synthetic */ MutabilityQualifier[] $values() {
        return new MutabilityQualifier[]{READ_ONLY, MUTABLE};
    }

    static {
        MutabilityQualifier[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static MutabilityQualifier valueOf(String str) {
        return (MutabilityQualifier) Enum.valueOf(MutabilityQualifier.class, str);
    }

    public static MutabilityQualifier[] values() {
        return (MutabilityQualifier[]) $VALUES.clone();
    }

    private MutabilityQualifier(String str, int i6) {
    }
}
