package com.jmolsmobile.landscapevideocapture.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.os.Build;
import android.view.SurfaceHolder;
import com.jmolsmobile.landscapevideocapture.camera.OpenCameraException;
import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f35609a;

    /* renamed from: b, reason: collision with root package name */
    private c f35610b;

    private CamcorderProfile e() {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        if (camcorderProfile != null) {
            return camcorderProfile;
        }
        CamcorderProfile camcorderProfile2 = CamcorderProfile.get(0);
        if (camcorderProfile2 != null) {
            return camcorderProfile2;
        }
        throw new RuntimeException("No quality level found");
    }

    public CamcorderProfile c() {
        return CamcorderProfile.hasProfile(5) ? CamcorderProfile.get(5) : CamcorderProfile.hasProfile(4) ? CamcorderProfile.get(4) : e();
    }

    public void a(int i6, int i7) {
        Camera.Parameters f6 = this.f35610b.f();
        a f7 = f(f6.getSupportedPreviewSizes(), i6, i7);
        f6.setPreviewSize(f7.b(), f7.a());
        f6.setPreviewFormat(17);
        this.f35610b.p(f6);
        this.f35610b.k(g());
        com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35599f, "Preview size: " + f7.b() + "x" + f7.a());
    }

    public void b() {
        Camera.Parameters f6 = this.f35610b.f();
        f6.setFocusMode("continuous-video");
        this.f35610b.p(f6);
    }

    public Camera d() {
        return this.f35610b.e();
    }

    public a f(List<Camera.Size> list, int i6, int i7) {
        double d6 = i6 / i7;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d7 = Double.MAX_VALUE;
        double d8 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((size2.width / size2.height) - d6) <= 0.1d && Math.abs(size2.height - i7) < d8) {
                d8 = Math.abs(size2.height - i7);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i7) < d7) {
                    size = size3;
                    d7 = Math.abs(size3.height - i7);
                }
            }
        }
        return new a(size.width, size.height);
    }

    public int g() {
        int i6 = this.f35609a * 90;
        return this.f35610b.h() ? (360 - ((this.f35610b.b() + i6) % 360)) % 360 : ((this.f35610b.b() - i6) + 360) % 360;
    }

    public d h(int i6, int i7) {
        a f6 = f(i(Build.VERSION.SDK_INT), i6, i7);
        if (f6 == null) {
            com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35599f, "Failed to find supported recording size - falling back to requested: " + i6 + "x" + i7);
            return new d(i6, i7);
        }
        com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35599f, "Recording size: " + f6.b() + "x" + f6.a());
        return new d(f6.b(), f6.a());
    }

    @TargetApi(11)
    protected List<Camera.Size> i(int i6) {
        Camera.Parameters f6 = this.f35610b.f();
        if (i6 < 11) {
            com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35599f, "Using supportedPreviewSizes iso supportedVideoSizes due to API restriction");
            return f6.getSupportedPreviewSizes();
        }
        if (f6.getSupportedVideoSizes() != null) {
            return f6.getSupportedVideoSizes();
        }
        com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35599f, "Using supportedPreviewSizes because supportedVideoSizes is null");
        return f6.getSupportedPreviewSizes();
    }

    public void j(boolean z5) throws OpenCameraException {
        try {
            this.f35610b.i(z5);
            if (this.f35610b.e() == null) {
                throw new OpenCameraException(OpenCameraException.OpenType.NOCAMERA);
            }
        } catch (RuntimeException e6) {
            e6.printStackTrace();
            throw new OpenCameraException(OpenCameraException.OpenType.INUSE);
        }
    }

    public void k() throws PrepareCameraException {
        try {
            this.f35610b.o();
        } catch (RuntimeException e6) {
            e6.printStackTrace();
            throw new PrepareCameraException();
        }
    }

    public void m(SurfaceHolder surfaceHolder) throws IOException {
        this.f35610b.l(surfaceHolder);
        this.f35610b.m();
    }

    public void n() throws Exception {
        this.f35610b.n();
        this.f35610b.a();
    }

    public b(c cVar, int i6) {
        this.f35610b = cVar;
        this.f35609a = i6;
    }

    public void l() {
        if (d() == null) {
            return;
        }
        this.f35610b.j();
    }
}
