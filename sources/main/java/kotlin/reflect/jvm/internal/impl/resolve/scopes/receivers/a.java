package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a implements h {

    /* renamed from: a, reason: collision with root package name */
    protected final t0 f46789a;

    /* renamed from: b, reason: collision with root package name */
    private final h f46790b;

    private static /* synthetic */ void c(int i6) {
        String str = (i6 == 1 || i6 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 1 || i6 == 2) ? 2 : 3];
        if (i6 == 1 || i6 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i6 == 1) {
            objArr[1] = "getType";
        } else if (i6 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i6 != 1 && i6 != 2) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public a(@NotNull t0 t0Var, @Nullable h hVar) {
        if (t0Var == null) {
            c(0);
        }
        this.f46789a = t0Var;
        this.f46790b = hVar == null ? this : hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h
    @NotNull
    public t0 getType() {
        t0 t0Var = this.f46789a;
        if (t0Var == null) {
            c(1);
        }
        return t0Var;
    }
}
