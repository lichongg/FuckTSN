package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.g1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull kotlin.coroutines.i context, long j6, @NotNull Function2<? super LiveDataScope<T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> block) {
        g0.p(context, "context");
        g0.p(block, "block");
        return new CoroutineLiveData(context, j6, block);
    }

    public static /* synthetic */ LiveData liveData$default(kotlin.coroutines.i iVar, long j6, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i6 & 2) != 0) {
            j6 = 5000;
        }
        return liveData(iVar, j6, function2);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull kotlin.coroutines.i context, @NotNull Duration timeout, @NotNull Function2<? super LiveDataScope<T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> block) {
        g0.p(context, "context");
        g0.p(timeout, "timeout");
        g0.p(block, "block");
        return new CoroutineLiveData(context, Api26Impl.INSTANCE.toMillis(timeout), block);
    }

    @Nullable
    public static final <T> Object addDisposableSource(@NotNull MediatorLiveData<T> mediatorLiveData, @NotNull LiveData<T> liveData, @NotNull kotlin.coroutines.e<? super EmittedSource> eVar) {
        return kotlinx.coroutines.i.h(g1.e().v(), new CoroutineLiveDataKt$addDisposableSource$2(mediatorLiveData, liveData, null), eVar);
    }

    public static /* synthetic */ LiveData liveData$default(kotlin.coroutines.i iVar, Duration duration, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        return liveData(iVar, duration, function2);
    }
}
