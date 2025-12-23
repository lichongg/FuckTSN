package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class k extends a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(@NotNull t0 t0Var) {
        this(t0Var, null);
        if (t0Var == null) {
            c(0);
        }
    }

    private static /* synthetic */ void c(int i6) {
        Object[] objArr = new Object[3];
        if (i6 != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i6 != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private k(@NotNull t0 t0Var, @Nullable h hVar) {
        super(t0Var, hVar);
        if (t0Var == null) {
            c(1);
        }
    }

    public String toString() {
        return "{Transient} : " + getType();
    }
}
