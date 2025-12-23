package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d extends a implements g {

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a f46795c;

    private static /* synthetic */ void c(int i6) {
        String str = i6 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i6 != 2 ? 3 : 2];
        if (i6 == 1) {
            objArr[0] = "receiverType";
        } else if (i6 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i6 != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i6 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i6 != 2) {
            if (i6 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String format = String.format(str, objArr);
        if (i6 == 2) {
            throw new IllegalStateException(format);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull t0 t0Var, @Nullable h hVar) {
        super(t0Var, hVar);
        if (aVar == null) {
            c(0);
        }
        if (t0Var == null) {
            c(1);
        }
        this.f46795c = aVar;
    }

    public String toString() {
        return getType() + ": Ext {" + this.f46795c + "}";
    }
}
