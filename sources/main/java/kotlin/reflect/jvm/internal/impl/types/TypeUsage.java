package kotlin.reflect.jvm.internal.impl.types;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class TypeUsage {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ TypeUsage[] $VALUES;
    public static final TypeUsage SUPERTYPE = new TypeUsage("SUPERTYPE", 0);
    public static final TypeUsage COMMON = new TypeUsage("COMMON", 1);

    private static final /* synthetic */ TypeUsage[] $values() {
        return new TypeUsage[]{SUPERTYPE, COMMON};
    }

    static {
        TypeUsage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static TypeUsage valueOf(String str) {
        return (TypeUsage) Enum.valueOf(TypeUsage.class, str);
    }

    public static TypeUsage[] values() {
        return (TypeUsage[]) $VALUES.clone();
    }

    private TypeUsage(String str, int i6) {
    }
}
