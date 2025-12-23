package androidx.core.util;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class AndroidXConsumerKt {
    @NotNull
    public static final <T> Consumer<T> asAndroidXConsumer(@NotNull kotlin.coroutines.e<? super T> eVar) {
        return new AndroidXContinuationConsumer(eVar);
    }
}
