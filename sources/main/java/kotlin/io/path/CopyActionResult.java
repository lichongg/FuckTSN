package kotlin.io.path;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.8")
@ExperimentalPathApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CopyActionResult {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ CopyActionResult[] $VALUES;
    public static final CopyActionResult CONTINUE = new CopyActionResult("CONTINUE", 0);
    public static final CopyActionResult SKIP_SUBTREE = new CopyActionResult("SKIP_SUBTREE", 1);
    public static final CopyActionResult TERMINATE = new CopyActionResult("TERMINATE", 2);

    private static final /* synthetic */ CopyActionResult[] $values() {
        return new CopyActionResult[]{CONTINUE, SKIP_SUBTREE, TERMINATE};
    }

    static {
        CopyActionResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<CopyActionResult> getEntries() {
        return $ENTRIES;
    }

    public static CopyActionResult valueOf(String str) {
        return (CopyActionResult) Enum.valueOf(CopyActionResult.class, str);
    }

    public static CopyActionResult[] values() {
        return (CopyActionResult[]) $VALUES.clone();
    }

    private CopyActionResult(String str, int i6) {
    }
}
