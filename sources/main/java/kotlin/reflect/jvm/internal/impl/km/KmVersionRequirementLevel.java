package kotlin.reflect.jvm.internal.impl.km;

import com.baidu.mobads.sdk.internal.ca;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class KmVersionRequirementLevel {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ KmVersionRequirementLevel[] $VALUES;
    public static final KmVersionRequirementLevel WARNING = new KmVersionRequirementLevel("WARNING", 0);
    public static final KmVersionRequirementLevel ERROR = new KmVersionRequirementLevel(ca.f10846l, 1);
    public static final KmVersionRequirementLevel HIDDEN = new KmVersionRequirementLevel("HIDDEN", 2);

    private static final /* synthetic */ KmVersionRequirementLevel[] $values() {
        return new KmVersionRequirementLevel[]{WARNING, ERROR, HIDDEN};
    }

    static {
        KmVersionRequirementLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static KmVersionRequirementLevel valueOf(String str) {
        return (KmVersionRequirementLevel) Enum.valueOf(KmVersionRequirementLevel.class, str);
    }

    public static KmVersionRequirementLevel[] values() {
        return (KmVersionRequirementLevel[]) $VALUES.clone();
    }

    private KmVersionRequirementLevel(String str, int i6) {
    }
}
