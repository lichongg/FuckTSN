package kotlin.jvm.internal;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Lambda<R> implements c0<R>, Serializable {
    private final int arity;

    @Override // kotlin.jvm.internal.c0
    public int getArity() {
        return this.arity;
    }

    public Lambda(int i6) {
        this.arity = i6;
    }

    @NotNull
    public String toString() {
        String x5 = o0.x(this);
        g0.o(x5, "renderLambdaToString(...)");
        return x5;
    }
}
