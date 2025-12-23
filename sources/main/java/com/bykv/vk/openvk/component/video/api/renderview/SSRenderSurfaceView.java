package com.bykv.vk.openvk.component.video.api.renderview;

import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.xt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes3.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, xt {
    private static final ArrayList<cw> cw = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<j> f22973j;

    /* renamed from: r, reason: collision with root package name */
    private xt.j f22974r;
    private cw xt;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public void j(j jVar) {
        this.f22973j = new WeakReference<>(jVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<cw> it = cw.iterator();
        while (it.hasNext()) {
            cw next = it.next();
            if (next != null && next.j() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.xt);
    }

    public void setWindowVisibilityChangedListener(xt.j jVar) {
        this.f22974r = jVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_SurfaceView", "surfaceChanged: ");
        WeakReference<j> weakReference = this.f22973j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f22973j.get().j(surfaceHolder, i6, i7, i8);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<j> weakReference = this.f22973j;
        if (weakReference != null && weakReference.get() != null) {
            this.f22973j.get().j(surfaceHolder);
        }
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_SurfaceView", "surfaceCreated: ");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_SurfaceView", "surfaceDestroyed: ");
        WeakReference<j> weakReference = this.f22973j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f22973j.get().xt(surfaceHolder);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public void j(int i6, int i7) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i7;
        layoutParams.width = i6;
        setLayoutParams(layoutParams);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public View getView() {
        return this;
    }
}
