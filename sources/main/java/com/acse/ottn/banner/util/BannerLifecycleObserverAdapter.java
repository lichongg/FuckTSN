package com.acse.ottn.banner.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.acse.ottn.d2;
import com.acse.ottn.x;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BannerLifecycleObserverAdapter implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    public final x f4299a;

    /* renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f4300b;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        d2.c("onDestroy");
        this.f4299a.a(this.f4300b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        d2.c("onStart");
        this.f4299a.b(this.f4300b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        d2.c("onStop");
        this.f4299a.c(this.f4300b);
    }

    public BannerLifecycleObserverAdapter(LifecycleOwner lifecycleOwner, x xVar) {
        this.f4300b = lifecycleOwner;
        this.f4299a = xVar;
    }
}
