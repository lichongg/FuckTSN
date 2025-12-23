package kotlin.coroutines.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    @Override // kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public RestrictedContinuationImpl(@Nullable kotlin.coroutines.e<Object> eVar) {
        super(eVar);
        if (eVar == null || eVar.getContext() == EmptyCoroutineContext.INSTANCE) {
        } else {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }
}
