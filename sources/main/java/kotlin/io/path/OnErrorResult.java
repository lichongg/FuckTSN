package kotlin.io.path;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.8")
@ExperimentalPathApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class OnErrorResult {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ OnErrorResult[] $VALUES;
    public static final OnErrorResult SKIP_SUBTREE = new OnErrorResult("SKIP_SUBTREE", 0);
    public static final OnErrorResult TERMINATE = new OnErrorResult("TERMINATE", 1);

    private static final /* synthetic */ OnErrorResult[] $values() {
        return new OnErrorResult[]{SKIP_SUBTREE, TERMINATE};
    }

    static {
        OnErrorResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<OnErrorResult> getEntries() {
        return $ENTRIES;
    }

    public static OnErrorResult valueOf(String str) {
        return (OnErrorResult) Enum.valueOf(OnErrorResult.class, str);
    }

    public static OnErrorResult[] values() {
        return (OnErrorResult[]) $VALUES.clone();
    }

    private OnErrorResult(String str, int i6) {
    }
}
