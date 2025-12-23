package com.bxkj.student.run.app.livedata;

import android.app.Service;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class LifecycleService extends Service implements LifecycleOwner {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private LifecycleRegistry f19843a = new LifecycleRegistry(this);

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.f19843a;
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i6, int i7) {
        this.f19843a.handleLifecycleEvent(Lifecycle.Event.ON_START);
        return super.onStartCommand(intent, i6, i7);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f19843a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f19843a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }
}
