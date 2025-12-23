package com.bykv.vk.component.ttvideo.player;

import android.view.SurfaceHolder;

/* loaded from: D:\Downloads\app\classes3.dex */
public class TTSurfaceCallback implements SurfaceHolder.Callback {
    private static final String TAG = "TTSurfaceCallback";
    private ISurfaceListener mListener;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
        ISurfaceListener iSurfaceListener = this.mListener;
        if (iSurfaceListener != null) {
            iSurfaceListener.onSurfaceChanged(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ISurfaceListener iSurfaceListener = this.mListener;
        if (iSurfaceListener != null) {
            iSurfaceListener.onSurfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ISurfaceListener iSurfaceListener = this.mListener;
        if (iSurfaceListener != null) {
            iSurfaceListener.onSurfaceDestroyed(surfaceHolder);
        }
    }

    TTSurfaceCallback(ISurfaceListener iSurfaceListener) {
        this.mListener = iSurfaceListener;
    }
}
