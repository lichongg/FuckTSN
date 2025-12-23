package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.PublishedApi;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class DebuggerInfo implements Serializable {

    @Nullable
    private final Long coroutineId;

    @Nullable
    private final String dispatcher;

    @NotNull
    private final List<StackTraceElement> lastObservedStackTrace;

    @Nullable
    private final String lastObservedThreadName;

    @Nullable
    private final String lastObservedThreadState;

    @Nullable
    private final String name;
    private final long sequenceNumber;

    @NotNull
    private final String state;

    @Nullable
    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    @Nullable
    public final String getDispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    @Nullable
    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    @Nullable
    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    public DebuggerInfo(@NotNull e eVar, @NotNull kotlin.coroutines.i iVar) {
        Long l6;
        String str;
        String str2;
        String str3;
        Thread.State state;
        p0 p0Var = (p0) iVar.get(p0.f49417b);
        if (p0Var != null) {
            l6 = Long.valueOf(p0Var.w());
        } else {
            l6 = null;
        }
        this.coroutineId = l6;
        kotlin.coroutines.f fVar = (kotlin.coroutines.f) iVar.get(kotlin.coroutines.f.f43765o0);
        if (fVar != null) {
            str = fVar.toString();
        } else {
            str = null;
        }
        this.dispatcher = str;
        q0 q0Var = (q0) iVar.get(q0.f49425b);
        if (q0Var != null) {
            str2 = q0Var.w();
        } else {
            str2 = null;
        }
        this.name = str2;
        this.state = eVar.f();
        Thread thread = eVar.lastObservedThread;
        if (thread != null && (state = thread.getState()) != null) {
            str3 = state.toString();
        } else {
            str3 = null;
        }
        this.lastObservedThreadState = str3;
        Thread thread2 = eVar.lastObservedThread;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = eVar.g();
        this.sequenceNumber = eVar.f48534b;
    }
}
