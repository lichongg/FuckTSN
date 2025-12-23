package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FunctionClassKind {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ FunctionClassKind[] $VALUES;

    @NotNull
    public static final a Companion;
    public static final FunctionClassKind Function = new FunctionClassKind("Function", 0);
    public static final FunctionClassKind SuspendFunction = new FunctionClassKind("SuspendFunction", 1);
    public static final FunctionClassKind KFunction = new FunctionClassKind("KFunction", 2);
    public static final FunctionClassKind KSuspendFunction = new FunctionClassKind("KSuspendFunction", 3);
    public static final FunctionClassKind UNKNOWN = new FunctionClassKind("UNKNOWN", 4);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final FunctionClassKind a(@NotNull e functionTypeKind) {
            g0.p(functionTypeKind, "functionTypeKind");
            return g0.g(functionTypeKind, e.a.f44424f) ? FunctionClassKind.Function : g0.g(functionTypeKind, e.d.f44427f) ? FunctionClassKind.SuspendFunction : g0.g(functionTypeKind, e.b.f44425f) ? FunctionClassKind.KFunction : g0.g(functionTypeKind, e.c.f44426f) ? FunctionClassKind.KSuspendFunction : FunctionClassKind.UNKNOWN;
        }
    }

    private static final /* synthetic */ FunctionClassKind[] $values() {
        return new FunctionClassKind[]{Function, SuspendFunction, KFunction, KSuspendFunction, UNKNOWN};
    }

    static {
        FunctionClassKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
        Companion = new a(null);
    }

    public static FunctionClassKind valueOf(String str) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, str);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) $VALUES.clone();
    }

    private FunctionClassKind(String str, int i6) {
    }
}
