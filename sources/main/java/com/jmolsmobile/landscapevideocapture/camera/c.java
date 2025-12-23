package com.jmolsmobile.landscapevideocapture.camera;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Camera f35611a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f35612b = false;

    /* renamed from: c, reason: collision with root package name */
    private Camera.Parameters f35613c = null;

    private boolean g() {
        for (int i6 = 0; i6 < Camera.getNumberOfCameras(); i6++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i6, cameraInfo);
            if (cameraInfo.facing == 1) {
                return true;
            }
        }
        return false;
    }

    private int c() {
        return this.f35612b ? 1 : 0;
    }

    public void a() {
        this.f35611a.setPreviewCallback(null);
    }

    public int b() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(d(), cameraInfo);
        return cameraInfo.orientation;
    }

    public Camera e() {
        return this.f35611a;
    }

    public Camera.Parameters f() {
        if (this.f35613c == null) {
            this.f35613c = this.f35611a.getParameters();
        }
        return this.f35613c;
    }

    public boolean h() {
        return this.f35612b;
    }

    public void i(boolean z5) throws RuntimeException {
        if (!z5) {
            this.f35611a = Camera.open(0);
        } else if (g()) {
            this.f35611a = Camera.open(1);
            this.f35612b = true;
        }
    }

    public void j() {
        this.f35611a.release();
    }

    public void k(int i6) {
        this.f35611a.setDisplayOrientation(i6);
    }

    public void l(SurfaceHolder surfaceHolder) throws IOException {
        this.f35611a.setPreviewDisplay(surfaceHolder);
    }

    public void m() {
        this.f35611a.startPreview();
    }

    public void n() {
        this.f35611a.stopPreview();
    }

    public void o() {
        this.f35611a.unlock();
    }

    public void p(Camera.Parameters parameters) {
        this.f35613c = parameters;
        this.f35611a.setParameters(parameters);
    }

    private int d() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i6 = 0; i6 < numberOfCameras; i6++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i6, cameraInfo);
            if (cameraInfo.facing == c()) {
                return i6;
            }
        }
        return -1;
    }
}
