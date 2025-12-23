package androidx.room.coroutines;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class RunBlockingUninterruptible_androidKt {
    public static final <T> T runBlockingUninterruptible(@NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> block) {
        Object b6;
        g0.p(block, "block");
        Thread.interrupted();
        b6 = j.b(null, new RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(block, null), 1, null);
        return (T) b6;
    }
}
