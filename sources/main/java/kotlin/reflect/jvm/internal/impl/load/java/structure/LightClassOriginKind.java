package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.enums.a;
import kotlin.enums.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class LightClassOriginKind {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ LightClassOriginKind[] $VALUES;
    public static final LightClassOriginKind SOURCE = new LightClassOriginKind("SOURCE", 0);
    public static final LightClassOriginKind BINARY = new LightClassOriginKind("BINARY", 1);

    private static final /* synthetic */ LightClassOriginKind[] $values() {
        return new LightClassOriginKind[]{SOURCE, BINARY};
    }

    static {
        LightClassOriginKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = c.c($values);
    }

    public static LightClassOriginKind valueOf(String str) {
        return (LightClassOriginKind) Enum.valueOf(LightClassOriginKind.class, str);
    }

    public static LightClassOriginKind[] values() {
        return (LightClassOriginKind[]) $VALUES.clone();
    }

    private LightClassOriginKind(String str, int i6) {
    }
}
