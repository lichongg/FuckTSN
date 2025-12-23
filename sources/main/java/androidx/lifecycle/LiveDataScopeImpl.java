package androidx.lifecycle;

import android.annotation.SuppressLint;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.j1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {

    @NotNull
    private final kotlin.coroutines.i coroutineContext;

    @NotNull
    private CoroutineLiveData<T> target;

    public LiveDataScopeImpl(@NotNull CoroutineLiveData<T> target, @NotNull kotlin.coroutines.i context) {
        g0.p(target, "target");
        g0.p(context, "context");
        this.target = target;
        this.coroutineContext = context.plus(g1.e().v());
    }

    @Override // androidx.lifecycle.LiveDataScope
    @SuppressLint({"NullSafeMutableLiveData"})
    @Nullable
    public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object h6 = kotlinx.coroutines.i.h(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, t5, null), eVar);
        return h6 == kotlin.coroutines.intrinsics.a.l() ? h6 : n1.f44123a;
    }

    @Override // androidx.lifecycle.LiveDataScope
    @Nullable
    public Object emitSource(@NotNull LiveData<T> liveData, @NotNull kotlin.coroutines.e<? super j1> eVar) {
        return kotlinx.coroutines.i.h(this.coroutineContext, new LiveDataScopeImpl$emitSource$2(this, liveData, null), eVar);
    }

    @Override // androidx.lifecycle.LiveDataScope
    @Nullable
    public T getLatestValue() {
        return this.target.getValue();
    }

    @NotNull
    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_ktx_release(@NotNull CoroutineLiveData<T> coroutineLiveData) {
        g0.p(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
