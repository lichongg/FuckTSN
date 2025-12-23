package kotlin.coroutines;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
public interface e<T> {
    @NotNull
    i getContext();

    void resumeWith(@NotNull Object obj);
}
