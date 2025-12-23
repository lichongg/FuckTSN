package com.devlin_n.videoplayer.player;

import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static c f32405b;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<IjkVideoView> f32406a;

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f32405b == null) {
                    f32405b = new c();
                }
                cVar = f32405b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public IjkVideoView a() {
        WeakReference<IjkVideoView> weakReference = this.f32406a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean c() {
        WeakReference<IjkVideoView> weakReference = this.f32406a;
        return (weakReference == null || weakReference.get() == null || !this.f32406a.get().X()) ? false : true;
    }

    public void d() {
        WeakReference<IjkVideoView> weakReference = this.f32406a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f32406a.get().Z();
        this.f32406a = null;
    }

    public void e(IjkVideoView ijkVideoView) {
        this.f32406a = new WeakReference<>(ijkVideoView);
    }

    private c() {
    }
}
