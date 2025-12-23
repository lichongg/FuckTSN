package kotlin.coroutines.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements c0<Object>, k {
    private final int arity;

    public RestrictedSuspendLambda(int i6, @Nullable kotlin.coroutines.e<Object> eVar) {
        super(eVar);
        this.arity = i6;
    }

    @Override // kotlin.jvm.internal.c0
    public int getArity() {
        return this.arity;
    }

    public RestrictedSuspendLambda(int i6) {
        this(i6, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public String toString() {
        if (getCompletion() == null) {
            String w5 = o0.w(this);
            g0.o(w5, "renderLambdaToString(...)");
            return w5;
        }
        return super.toString();
    }
}
