package androidx.core.content;

import androidx.core.util.Consumer;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface OnTrimMemoryProvider {
    void addOnTrimMemoryListener(@NotNull Consumer<Integer> consumer);

    void removeOnTrimMemoryListener(@NotNull Consumer<Integer> consumer);
}
