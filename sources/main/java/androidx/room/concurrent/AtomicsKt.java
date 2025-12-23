package androidx.room.concurrent;

import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class AtomicsKt {
    @NotNull
    public static final Void loop(@NotNull AtomicInteger atomicInteger, @NotNull Function1<? super Integer, n1> action) {
        g0.p(atomicInteger, "<this>");
        g0.p(action, "action");
        while (true) {
            action.invoke(Integer.valueOf(atomicInteger.get()));
        }
    }
}
