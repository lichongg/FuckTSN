package com.huawei.hms.scankit.p;

import android.hardware.Camera;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class n0 {

    /* renamed from: a, reason: collision with root package name */
    private Camera f34578a;

    public synchronized void a(Camera camera) {
        this.f34578a = camera;
    }

    public synchronized boolean b() {
        Camera camera = this.f34578a;
        if (camera == null) {
            return false;
        }
        return camera.getParameters().isZoomSupported();
    }

    public synchronized m0 a() {
        return new m0(this.f34578a.getParameters().getMaxZoom(), this.f34578a.getParameters().getZoom(), this.f34578a.getParameters().getZoomRatios());
    }

    public synchronized void a(int i6) {
        Camera camera = this.f34578a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setZoom(i6);
        try {
            this.f34578a.setParameters(parameters);
        } catch (RuntimeException e6) {
            e6.getMessage();
        }
    }
}
