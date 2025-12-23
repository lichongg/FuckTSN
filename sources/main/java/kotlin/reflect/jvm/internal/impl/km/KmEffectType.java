package kotlin.reflect.jvm.internal.impl.km;

import kotlin.contracts.ExperimentalContracts;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalContracts
/* loaded from: D:\Downloads\app\classes8.dex */
public final class KmEffectType {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ KmEffectType[] $VALUES;
    public static final KmEffectType RETURNS_CONSTANT = new KmEffectType("RETURNS_CONSTANT", 0);
    public static final KmEffectType CALLS = new KmEffectType("CALLS", 1);
    public static final KmEffectType RETURNS_NOT_NULL = new KmEffectType("RETURNS_NOT_NULL", 2);

    private static final /* synthetic */ KmEffectType[] $values() {
        return new KmEffectType[]{RETURNS_CONSTANT, CALLS, RETURNS_NOT_NULL};
    }

    static {
        KmEffectType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static KmEffectType valueOf(String str) {
        return (KmEffectType) Enum.valueOf(KmEffectType.class, str);
    }

    public static KmEffectType[] values() {
        return (KmEffectType[]) $VALUES.clone();
    }

    private KmEffectType(String str, int i6) {
    }
}
