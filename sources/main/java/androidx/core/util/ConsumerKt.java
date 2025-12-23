package androidx.core.util;

import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(24)
@JvmName(name = "ConsumerKt")
/* loaded from: D:\Downloads\app\classes.dex */
public final class ConsumerKt {
    @RequiresApi(24)
    @NotNull
    public static final <T> java.util.function.Consumer<T> asConsumer(@NotNull kotlin.coroutines.e<? super T> eVar) {
        return a.a(new ContinuationConsumer(eVar));
    }
}
