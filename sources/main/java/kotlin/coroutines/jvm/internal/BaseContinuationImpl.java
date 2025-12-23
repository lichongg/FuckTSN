package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class BaseContinuationImpl implements kotlin.coroutines.e<Object>, c, Serializable {

    @Nullable
    private final kotlin.coroutines.e<Object> completion;

    @NotNull
    public kotlin.coroutines.e<n1> create(@NotNull kotlin.coroutines.e<?> completion) {
        g0.p(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Nullable
    protected abstract Object invokeSuspend(@NotNull Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.e
    public final void resumeWith(@NotNull Object obj) {
        Object invokeSuspend;
        kotlin.coroutines.e eVar = this;
        while (true) {
            e.b(eVar);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) eVar;
            kotlin.coroutines.e eVar2 = baseContinuationImpl.completion;
            g0.m(eVar2);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.a aVar = Result.Companion;
                obj = Result.m130constructorimpl(kotlin.g0.a(th));
            }
            if (invokeSuspend == kotlin.coroutines.intrinsics.a.l()) {
                return;
            }
            Result.a aVar2 = Result.Companion;
            obj = Result.m130constructorimpl(invokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (!(eVar2 instanceof BaseContinuationImpl)) {
                eVar2.resumeWith(obj);
                return;
            }
            eVar = eVar2;
        }
    }

    @NotNull
    public kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> completion) {
        g0.p(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public c getCallerFrame() {
        kotlin.coroutines.e<Object> eVar = this.completion;
        if (eVar instanceof c) {
            return (c) eVar;
        }
        return null;
    }

    @Nullable
    public final kotlin.coroutines.e<Object> getCompletion() {
        return this.completion;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public BaseContinuationImpl(@Nullable kotlin.coroutines.e<Object> eVar) {
        this.completion = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return d.e(this);
    }

    protected void releaseIntercepted() {
    }
}
