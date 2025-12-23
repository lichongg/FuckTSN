package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import kotlinx.coroutines.channels.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ j a(int i6) {
        return d(i6, null, null, 6, null);
    }

    @NotNull
    public static final <E> j<E> b(int i6, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, n1> function1) {
        if (i6 == -2) {
            return bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(j.f48222t0.a(), function1) : new u(1, bufferOverflow, function1);
        }
        if (i6 != -1) {
            return i6 != 0 ? i6 != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(i6, function1) : new u(i6, bufferOverflow, function1) : new BufferedChannel(Integer.MAX_VALUE, function1) : bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(0, function1) : new u(1, bufferOverflow, function1);
        }
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            return new u(1, BufferOverflow.DROP_OLDEST, function1);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static /* synthetic */ j c(int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        return a(i6);
    }

    public static /* synthetic */ j d(int i6, BufferOverflow bufferOverflow, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        if ((i7 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i7 & 4) != 0) {
            function1 = null;
        }
        return b(i6, bufferOverflow, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T e(@NotNull Object obj, @NotNull Function1<? super Throwable, ? extends T> function1) {
        return obj instanceof n.c ? function1.invoke(n.f(obj)) : obj;
    }

    @NotNull
    public static final <T> Object f(@NotNull Object obj, @NotNull Function1<? super Throwable, n1> function1) {
        if (obj instanceof n.a) {
            function1.invoke(n.f(obj));
        }
        return obj;
    }

    @NotNull
    public static final <T> Object g(@NotNull Object obj, @NotNull Function1<? super Throwable, n1> function1) {
        if (obj instanceof n.c) {
            function1.invoke(n.f(obj));
        }
        return obj;
    }

    @NotNull
    public static final <T> Object h(@NotNull Object obj, @NotNull Function1<? super T, n1> function1) {
        if (!(obj instanceof n.c)) {
            function1.invoke(obj);
        }
        return obj;
    }
}
