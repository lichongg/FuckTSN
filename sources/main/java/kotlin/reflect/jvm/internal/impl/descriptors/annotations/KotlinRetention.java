package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class KotlinRetention {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ KotlinRetention[] $VALUES;
    public static final KotlinRetention RUNTIME = new KotlinRetention("RUNTIME", 0);
    public static final KotlinRetention BINARY = new KotlinRetention("BINARY", 1);
    public static final KotlinRetention SOURCE = new KotlinRetention("SOURCE", 2);

    private static final /* synthetic */ KotlinRetention[] $values() {
        return new KotlinRetention[]{RUNTIME, BINARY, SOURCE};
    }

    static {
        KotlinRetention[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static KotlinRetention valueOf(String str) {
        return (KotlinRetention) Enum.valueOf(KotlinRetention.class, str);
    }

    public static KotlinRetention[] values() {
        return (KotlinRetention[]) $VALUES.clone();
    }

    private KotlinRetention(String str, int i6) {
    }
}
