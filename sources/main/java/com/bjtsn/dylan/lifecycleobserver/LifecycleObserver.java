package com.bjtsn.dylan.lifecycleobserver;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    private Lifecycle f14537a;

    public LifecycleObserver(@NotNull FragmentActivity activity) {
        g0.p(activity, "activity");
        Lifecycle lifecycle = activity.getLifecycle();
        g0.o(lifecycle, "activity.lifecycle");
        this.f14537a = lifecycle;
    }

    public LifecycleObserver(@NotNull Fragment fragment) {
        g0.p(fragment, "fragment");
        Lifecycle lifecycle = fragment.getLifecycle();
        g0.o(lifecycle, "fragment.lifecycle");
        this.f14537a = lifecycle;
    }

    public final void c(@NotNull final b lifecycleCallback) {
        g0.p(lifecycleCallback, "lifecycleCallback");
        this.f14537a.addObserver(new androidx.lifecycle.LifecycleObserver() { // from class: com.bjtsn.dylan.lifecycleobserver.LifecycleObserver$observer$1
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public final void onCreate() {
                lifecycleCallback.onCreate();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                Lifecycle lifecycle;
                lifecycleCallback.onDestroy();
                lifecycle = LifecycleObserver.this.f14537a;
                lifecycle.removeObserver(this);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public final void onPause() {
                lifecycleCallback.onPause();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public final void onResume() {
                lifecycleCallback.onResume();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public final void onStart() {
                lifecycleCallback.onStart();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public final void onStop() {
                lifecycleCallback.onStop();
            }
        });
    }
}
