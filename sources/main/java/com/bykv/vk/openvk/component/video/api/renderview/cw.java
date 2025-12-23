package com.bykv.vk.openvk.component.video.api.renderview;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements SurfaceHolder.Callback {

    /* renamed from: j, reason: collision with root package name */
    private final WeakReference<SurfaceHolder.Callback> f22976j;

    public SurfaceHolder.Callback j() {
        return this.f22976j.get();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
        SurfaceHolder.Callback callback = this.f22976j.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i6, i7, i8);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f22976j.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f22976j.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
