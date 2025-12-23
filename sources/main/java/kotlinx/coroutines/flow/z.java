package kotlinx.coroutines.flow;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.s0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final s0 f49193a = new s0("NO_VALUE");

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object[] objArr, long j6) {
        return objArr[(objArr.length - 1) & ((int) j6)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Object[] objArr, long j6, Object obj) {
        objArr[(objArr.length - 1) & ((int) j6)] = obj;
    }

    @NotNull
    public static final <T> s<T> a(int i6, int i7, @NotNull BufferOverflow bufferOverflow) {
        if (i6 < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i6).toString());
        }
        if (i7 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i7).toString());
        }
        if (i6 > 0 || i7 > 0 || bufferOverflow == BufferOverflow.SUSPEND) {
            int i8 = i7 + i6;
            if (i8 < 0) {
                i8 = Integer.MAX_VALUE;
            }
            return new y(i6, i8, bufferOverflow);
        }
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
    }

    public static /* synthetic */ s b(int i6, int i7, BufferOverflow bufferOverflow, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return a(i6, i7, bufferOverflow);
    }

    @NotNull
    public static final <T> i<T> e(@NotNull x<? extends T> xVar, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return ((i6 == 0 || i6 == -3) && bufferOverflow == BufferOverflow.SUSPEND) ? xVar : new kotlinx.coroutines.flow.internal.h(xVar, iVar, i6, bufferOverflow);
    }
}
