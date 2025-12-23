package androidx.lifecycle;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, b0 {
    private final /* synthetic */ Function1 function;

    Transformations$sam$androidx_lifecycle_Observer$0(Function1 function) {
        g0.p(function, "function");
        this.function = function;
    }

    public final boolean equals(@Nullable Object obj) {
        if ((obj instanceof Observer) && (obj instanceof b0)) {
            return g0.g(getFunctionDelegate(), ((b0) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.b0
    @NotNull
    public final n<?> getFunctionDelegate() {
        return this.function;
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
