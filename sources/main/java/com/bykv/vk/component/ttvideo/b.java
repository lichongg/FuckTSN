package com.bykv.vk.component.ttvideo;

import android.view.Surface;
import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes3.dex */
public class b implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<TTVideoEngine> f22885a;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TTVideoEngine tTVideoEngine = this.f22885a.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.a(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        TTVideoEngine tTVideoEngine = this.f22885a.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.a((Surface) null);
        }
    }

    public b(TTVideoEngine tTVideoEngine) {
        this.f22885a = new WeakReference<>(tTVideoEngine);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
    }
}
