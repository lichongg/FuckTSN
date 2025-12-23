package androidx.lifecycle;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface DefaultLifecycleObserver extends LifecycleObserver {
    void onCreate(@NotNull LifecycleOwner lifecycleOwner);

    void onDestroy(@NotNull LifecycleOwner lifecycleOwner);

    void onPause(@NotNull LifecycleOwner lifecycleOwner);

    void onResume(@NotNull LifecycleOwner lifecycleOwner);

    void onStart(@NotNull LifecycleOwner lifecycleOwner);

    void onStop(@NotNull LifecycleOwner lifecycleOwner);
}
