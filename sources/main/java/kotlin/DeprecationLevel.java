package kotlin;

import com.baidu.mobads.sdk.internal.ca;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class DeprecationLevel {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ DeprecationLevel[] $VALUES;
    public static final DeprecationLevel WARNING = new DeprecationLevel("WARNING", 0);
    public static final DeprecationLevel ERROR = new DeprecationLevel(ca.f10846l, 1);
    public static final DeprecationLevel HIDDEN = new DeprecationLevel("HIDDEN", 2);

    private static final /* synthetic */ DeprecationLevel[] $values() {
        return new DeprecationLevel[]{WARNING, ERROR, HIDDEN};
    }

    static {
        DeprecationLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<DeprecationLevel> getEntries() {
        return $ENTRIES;
    }

    public static DeprecationLevel valueOf(String str) {
        return (DeprecationLevel) Enum.valueOf(DeprecationLevel.class, str);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[]) $VALUES.clone();
    }

    private DeprecationLevel(String str, int i6) {
    }
}
