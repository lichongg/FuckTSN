package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class PropertyAccessorRenderingPolicy {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $VALUES;
    public static final PropertyAccessorRenderingPolicy PRETTY = new PropertyAccessorRenderingPolicy("PRETTY", 0);
    public static final PropertyAccessorRenderingPolicy DEBUG = new PropertyAccessorRenderingPolicy("DEBUG", 1);
    public static final PropertyAccessorRenderingPolicy NONE = new PropertyAccessorRenderingPolicy("NONE", 2);

    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $values() {
        return new PropertyAccessorRenderingPolicy[]{PRETTY, DEBUG, NONE};
    }

    static {
        PropertyAccessorRenderingPolicy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static PropertyAccessorRenderingPolicy valueOf(String str) {
        return (PropertyAccessorRenderingPolicy) Enum.valueOf(PropertyAccessorRenderingPolicy.class, str);
    }

    public static PropertyAccessorRenderingPolicy[] values() {
        return (PropertyAccessorRenderingPolicy[]) $VALUES.clone();
    }

    private PropertyAccessorRenderingPolicy(String str, int i6) {
    }
}
