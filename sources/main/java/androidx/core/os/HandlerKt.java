package androidx.core.os;

import android.os.Handler;
import kotlin.jvm.functions.Function0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class HandlerKt {
    @NotNull
    public static final Runnable postAtTime(@NotNull Handler handler, long j6, @Nullable Object obj, @NotNull Function0<n1> function0) {
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(function0);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j6);
        return handlerKt$postAtTime$runnable$1;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long j6, Object obj, Function0 function0, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            obj = null;
        }
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(function0);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j6);
        return handlerKt$postAtTime$runnable$1;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull Handler handler, long j6, @Nullable Object obj, @NotNull Function0<n1> function0) {
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(function0);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j6);
            return handlerKt$postDelayed$runnable$1;
        }
        HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j6);
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long j6, Object obj, Function0 function0, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            obj = null;
        }
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(function0);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j6);
            return handlerKt$postDelayed$runnable$1;
        }
        HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j6);
        return handlerKt$postDelayed$runnable$1;
    }
}
