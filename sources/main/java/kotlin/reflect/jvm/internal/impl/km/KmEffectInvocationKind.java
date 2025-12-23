package kotlin.reflect.jvm.internal.impl.km;

import kotlin.contracts.ExperimentalContracts;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalContracts
/* loaded from: D:\Downloads\app\classes8.dex */
public final class KmEffectInvocationKind {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ KmEffectInvocationKind[] $VALUES;
    public static final KmEffectInvocationKind AT_MOST_ONCE = new KmEffectInvocationKind("AT_MOST_ONCE", 0);
    public static final KmEffectInvocationKind EXACTLY_ONCE = new KmEffectInvocationKind("EXACTLY_ONCE", 1);
    public static final KmEffectInvocationKind AT_LEAST_ONCE = new KmEffectInvocationKind("AT_LEAST_ONCE", 2);

    private static final /* synthetic */ KmEffectInvocationKind[] $values() {
        return new KmEffectInvocationKind[]{AT_MOST_ONCE, EXACTLY_ONCE, AT_LEAST_ONCE};
    }

    static {
        KmEffectInvocationKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static KmEffectInvocationKind valueOf(String str) {
        return (KmEffectInvocationKind) Enum.valueOf(KmEffectInvocationKind.class, str);
    }

    public static KmEffectInvocationKind[] values() {
        return (KmEffectInvocationKind[]) $VALUES.clone();
    }

    private KmEffectInvocationKind(String str, int i6) {
    }
}
