package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import java.time.Duration;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.flow.h0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "FlowLiveDataConversions")
/* loaded from: D:\Downloads\app\classes.dex */
public final class FlowLiveDataConversions {
    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull kotlinx.coroutines.flow.i<? extends T> iVar) {
        g0.p(iVar, "<this>");
        return asLiveData$default(iVar, (kotlin.coroutines.i) null, 0L, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(kotlinx.coroutines.flow.i iVar, kotlin.coroutines.i iVar2, long j6, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar2 = EmptyCoroutineContext.INSTANCE;
        }
        if ((i6 & 2) != 0) {
            j6 = 5000;
        }
        return asLiveData(iVar, iVar2, j6);
    }

    @NotNull
    public static final <T> kotlinx.coroutines.flow.i<T> asFlow(@NotNull LiveData<T> liveData) {
        g0.p(liveData, "<this>");
        return kotlinx.coroutines.flow.k.W(kotlinx.coroutines.flow.k.s(new FlowLiveDataConversions$asFlow$1(liveData, null)));
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull kotlinx.coroutines.flow.i<? extends T> iVar, @NotNull kotlin.coroutines.i context) {
        g0.p(iVar, "<this>");
        g0.p(context, "context");
        return asLiveData$default(iVar, context, 0L, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull kotlinx.coroutines.flow.i<? extends T> iVar, @NotNull kotlin.coroutines.i context, long j6) {
        g0.p(iVar, "<this>");
        g0.p(context, "context");
        Camera2CameraInfoImpl.RedirectableLiveData redirectableLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j6, new FlowLiveDataConversions$asLiveData$1(iVar, null));
        if (iVar instanceof h0) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                redirectableLiveData.setValue(((h0) iVar).getValue());
                return redirectableLiveData;
            }
            redirectableLiveData.postValue(((h0) iVar).getValue());
        }
        return redirectableLiveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(kotlinx.coroutines.flow.i iVar, kotlin.coroutines.i iVar2, Duration duration, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar2 = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(iVar, iVar2, duration);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull kotlinx.coroutines.flow.i<? extends T> iVar, @NotNull kotlin.coroutines.i context, @NotNull Duration timeout) {
        g0.p(iVar, "<this>");
        g0.p(context, "context");
        g0.p(timeout, "timeout");
        return asLiveData(iVar, context, Api26Impl.INSTANCE.toMillis(timeout));
    }
}
