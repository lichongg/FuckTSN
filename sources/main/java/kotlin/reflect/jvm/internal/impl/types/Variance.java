package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Variance {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ Variance[] $VALUES;
    public static final Variance INVARIANT = new Variance("INVARIANT", 0, "", true, true, 0);
    public static final Variance IN_VARIANCE = new Variance("IN_VARIANCE", 1, "in", true, false, -1);
    public static final Variance OUT_VARIANCE = new Variance("OUT_VARIANCE", 2, "out", false, true, 1);
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;

    @NotNull
    private final String label;
    private final int superpositionFactor;

    private static final /* synthetic */ Variance[] $values() {
        return new Variance[]{INVARIANT, IN_VARIANCE, OUT_VARIANCE};
    }

    static {
        Variance[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static Variance valueOf(String str) {
        return (Variance) Enum.valueOf(Variance.class, str);
    }

    public static Variance[] values() {
        return (Variance[]) $VALUES.clone();
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.label;
    }

    private Variance(String str, int i6, String str2, boolean z5, boolean z6, int i7) {
        this.label = str2;
        this.allowsInPosition = z5;
        this.allowsOutPosition = z6;
        this.superpositionFactor = i7;
    }
}
