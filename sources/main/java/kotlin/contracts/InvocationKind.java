package kotlin.contracts;

import kotlin.SinceKotlin;
import kotlin.enums.a;
import kotlin.enums.c;
import kotlin.internal.ContractsDsl;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@ContractsDsl
@ExperimentalContracts
/* loaded from: D:\Downloads\app\classes8.dex */
public final class InvocationKind {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ InvocationKind[] $VALUES;

    @ContractsDsl
    public static final InvocationKind AT_MOST_ONCE = new InvocationKind("AT_MOST_ONCE", 0);

    @ContractsDsl
    public static final InvocationKind AT_LEAST_ONCE = new InvocationKind("AT_LEAST_ONCE", 1);

    @ContractsDsl
    public static final InvocationKind EXACTLY_ONCE = new InvocationKind("EXACTLY_ONCE", 2);

    @ContractsDsl
    public static final InvocationKind UNKNOWN = new InvocationKind("UNKNOWN", 3);

    private static final /* synthetic */ InvocationKind[] $values() {
        return new InvocationKind[]{AT_MOST_ONCE, AT_LEAST_ONCE, EXACTLY_ONCE, UNKNOWN};
    }

    static {
        InvocationKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = c.c($values);
    }

    @NotNull
    public static a<InvocationKind> getEntries() {
        return $ENTRIES;
    }

    public static InvocationKind valueOf(String str) {
        return (InvocationKind) Enum.valueOf(InvocationKind.class, str);
    }

    public static InvocationKind[] values() {
        return (InvocationKind[]) $VALUES.clone();
    }

    private InvocationKind(String str, int i6) {
    }
}
