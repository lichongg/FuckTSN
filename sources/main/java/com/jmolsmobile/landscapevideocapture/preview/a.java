package com.jmolsmobile.landscapevideocapture.preview;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    private boolean f35661a = false;

    /* renamed from: b, reason: collision with root package name */
    private final b f35662b;

    /* renamed from: c, reason: collision with root package name */
    public final com.jmolsmobile.landscapevideocapture.camera.b f35663c;

    public static boolean b() {
        for (int i6 = 0; i6 < Camera.getNumberOfCameras(); i6++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i6, cameraInfo);
            if (cameraInfo.facing == 1) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        if (this.f35661a) {
            try {
                this.f35663c.n();
                d(false);
            } catch (Exception e6) {
                e6.printStackTrace();
                com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35596c, "Failed to clean up preview resources");
            }
        }
    }

    protected void d(boolean z5) {
        this.f35661a = z5;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
        if (this.f35661a) {
            try {
                this.f35663c.n();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        try {
            this.f35663c.a(i7, i8);
            com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35596c, "Configured camera for preview in surface of " + i7 + " by " + i8);
            try {
                this.f35663c.b();
            } catch (RuntimeException e7) {
                e7.printStackTrace();
                com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35596c, "AutoFocus not available for preview");
            }
            try {
                this.f35663c.m(surfaceHolder);
                d(true);
            } catch (IOException e8) {
                e8.printStackTrace();
                com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35596c, "Failed to show preview - unable to connect camera to preview (IOException)");
                this.f35662b.a();
            } catch (RuntimeException e9) {
                e9.printStackTrace();
                com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35596c, "Failed to show preview - unable to start camera preview (RuntimeException)");
                this.f35662b.a();
            }
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35596c, "Failed to show preview - invalid parameters set to camera preview");
            this.f35662b.a();
        }
    }

    public a(b bVar, com.jmolsmobile.landscapevideocapture.camera.b bVar2, SurfaceHolder surfaceHolder) {
        this.f35662b = bVar;
        this.f35663c = bVar2;
        a(surfaceHolder);
    }

    private void a(SurfaceHolder surfaceHolder) {
        surfaceHolder.removeCallback(this);
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
