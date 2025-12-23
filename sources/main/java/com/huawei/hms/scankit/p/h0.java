package com.huawei.hms.scankit.p;

import android.hardware.Camera;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h0 {

    /* renamed from: a, reason: collision with root package name */
    private Camera f34330a;

    public synchronized void a(Camera camera) {
        this.f34330a = camera;
    }

    public synchronized g0 a() {
        return new g0(this.f34330a.getParameters().getMaxExposureCompensation(), this.f34330a.getParameters().getMinExposureCompensation(), this.f34330a.getParameters().getExposureCompensation(), this.f34330a.getParameters().getExposureCompensationStep());
    }

    public synchronized void a(int i6) {
        Camera camera = this.f34330a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setExposureCompensation(i6);
            parameters.getAutoExposureLock();
            this.f34330a.setParameters(parameters);
            parameters.getAutoExposureLock();
        } catch (RuntimeException unused) {
        }
    }
}
