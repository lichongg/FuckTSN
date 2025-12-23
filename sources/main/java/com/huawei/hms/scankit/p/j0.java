package com.huawei.hms.scankit.p;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.TextureView;
import com.huawei.hms.scankit.p.k0;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    private e0 f34417a;

    /* renamed from: b, reason: collision with root package name */
    private d f34418b;

    /* renamed from: c, reason: collision with root package name */
    private b f34419c;

    /* renamed from: d, reason: collision with root package name */
    private Camera.PreviewCallback f34420d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f34421e;

    /* renamed from: f, reason: collision with root package name */
    private i0 f34422f;

    /* renamed from: g, reason: collision with root package name */
    private h0 f34423g;

    /* renamed from: h, reason: collision with root package name */
    private n0 f34424h;

    /* renamed from: i, reason: collision with root package name */
    private l0 f34425i;

    /* renamed from: j, reason: collision with root package name */
    private Camera f34426j;

    /* renamed from: k, reason: collision with root package name */
    private f0 f34427k;

    /* renamed from: l, reason: collision with root package name */
    private String f34428l;

    /* renamed from: m, reason: collision with root package name */
    private c f34429m = c.CAMERA_CLOSED;

    /* renamed from: n, reason: collision with root package name */
    private int f34430n = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(Point point);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum c {
        CAMERA_CLOSED(1),
        CAMERA_OPENED(2),
        CAMERA_INITIALED(3),
        PREVIEW_STARTED(4),
        PREVIEW_STOPPED(5);


        /* renamed from: a, reason: collision with root package name */
        private final int f34437a;

        public int a() {
            return this.f34437a;
        }

        c(int i6) {
            this.f34437a = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a();

        void b();

        void c();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void a(byte[] bArr);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class f implements Camera.PreviewCallback {
        private f() {
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    }

    public synchronized void a(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("CameraManager::setFrameCallback param invalid");
        }
        this.f34420d = new f6(eVar);
    }

    public synchronized g0 b() {
        if (this.f34426j == null || this.f34429m.a() == c.CAMERA_CLOSED.a()) {
            return null;
        }
        try {
            return this.f34423g.a();
        } catch (Exception unused) {
            return null;
        }
    }

    public synchronized void c(int i6) {
        if (this.f34426j != null && this.f34429m.a() != c.CAMERA_CLOSED.a()) {
            this.f34423g.a(i6);
        }
    }

    public synchronized void d(int i6) {
        if (this.f34426j != null && this.f34429m.a() != c.CAMERA_CLOSED.a()) {
            this.f34424h.a(i6);
        }
    }

    public synchronized Point e() {
        return this.f34427k.a();
    }

    public synchronized c f() {
        return this.f34429m;
    }

    public synchronized m0 g() {
        if (this.f34426j != null && this.f34429m.a() != c.CAMERA_CLOSED.a()) {
            return this.f34424h.a();
        }
        return null;
    }

    public synchronized String h() {
        return this.f34428l;
    }

    public synchronized boolean i() {
        boolean z5;
        if (this.f34426j != null) {
            z5 = this.f34429m.a() >= c.CAMERA_OPENED.a();
        }
        return z5;
    }

    public synchronized boolean j() {
        return this.f34424h.b();
    }

    public synchronized void k() {
        this.f34419c = null;
    }

    public synchronized void l() {
        try {
            if (this.f34429m.a() == c.PREVIEW_STARTED.a()) {
                a();
                q();
                this.f34429m = c.PREVIEW_STOPPED;
            }
            if (h().equals("torch")) {
                a(kotlinx.coroutines.t0.f49654e);
            }
            if (this.f34429m.a() >= c.CAMERA_OPENED.a()) {
                this.f34429m = c.CAMERA_CLOSED;
                Camera camera = this.f34426j;
                if (camera != null) {
                    camera.setPreviewCallback(null);
                    this.f34426j.stopPreview();
                    this.f34426j.release();
                    this.f34426j = null;
                }
                d dVar = this.f34418b;
                if (dVar != null) {
                    dVar.c();
                }
            }
        } catch (RuntimeException unused) {
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void m() {
        c cVar = this.f34429m;
        if (cVar == c.CAMERA_CLOSED || cVar == c.PREVIEW_STOPPED) {
            try {
                this.f34426j = Camera.open(a(this.f34417a.b()));
            } catch (RuntimeException e6) {
                e6.getMessage();
            }
            if (this.f34426j == null) {
                d dVar = this.f34418b;
                if (dVar != null) {
                    dVar.b();
                }
            } else {
                d dVar2 = this.f34418b;
                if (dVar2 != null) {
                    dVar2.a();
                }
                this.f34429m = c.CAMERA_OPENED;
            }
        }
    }

    public synchronized void n() {
        Camera camera;
        if (this.f34429m.a() < c.CAMERA_OPENED.a()) {
            return;
        }
        if (this.f34417a.c() != 0 && (camera = this.f34426j) != null) {
            camera.setPreviewCallback(new f(null));
        }
    }

    public synchronized void o() {
        try {
            if (this.f34417a.c() == 1) {
                if (this.f34429m == c.PREVIEW_STOPPED) {
                    return;
                }
                Camera camera = this.f34426j;
                if (camera != null) {
                    camera.setOneShotPreviewCallback(this.f34420d);
                }
            } else if (this.f34417a.c() == 0) {
                if (this.f34429m == c.PREVIEW_STOPPED) {
                    p();
                }
            } else if (this.f34417a.c() == 2) {
                if (this.f34429m == c.PREVIEW_STOPPED) {
                    return;
                }
                Camera camera2 = this.f34426j;
                if (camera2 != null) {
                    camera2.setPreviewCallback(this.f34420d);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void p() {
        if (this.f34429m.a() < c.CAMERA_INITIALED.a()) {
            return;
        }
        Camera camera = this.f34426j;
        if (camera != null) {
            camera.startPreview();
            this.f34429m = c.PREVIEW_STARTED;
        }
    }

    public synchronized void q() {
        if (this.f34429m.a() < c.PREVIEW_STARTED.a()) {
            return;
        }
        Camera camera = this.f34426j;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.f34426j.stopPreview();
            this.f34429m = c.PREVIEW_STOPPED;
        }
    }

    public j0(Context context, e0 e0Var) {
        if (context != null && e0Var != null) {
            this.f34421e = new WeakReference<>(context);
            this.f34417a = e0Var;
            this.f34428l = e0Var.f();
            this.f34427k = new f0();
            this.f34423g = new h0();
            this.f34424h = new n0();
            this.f34425i = new l0();
            return;
        }
        throw new IllegalArgumentException("CameraManager constructor param invalid");
    }

    public synchronized void a(d dVar) {
        if (dVar != null) {
            this.f34418b = dVar;
        } else {
            throw new IllegalArgumentException("CameraManager::setCameraStatusListener param invalid");
        }
    }

    public synchronized k0 c() {
        if (this.f34426j != null && this.f34429m.a() != c.CAMERA_CLOSED.a()) {
            return this.f34425i.a();
        }
        return null;
    }

    public synchronized int d() {
        return this.f34417a.d();
    }

    public synchronized void b(int i6) {
        if (this.f34417a != null && this.f34426j != null && this.f34429m.a() >= c.CAMERA_OPENED.a()) {
            this.f34417a.a(i6);
            try {
                this.f34426j.setDisplayOrientation(i6);
            } catch (RuntimeException | Exception unused) {
            }
        }
    }

    public synchronized void a(TextureView textureView) throws IOException {
        try {
            if (textureView != null) {
                if (this.f34429m.a() != c.CAMERA_OPENED.a()) {
                    m();
                }
                this.f34423g.a(this.f34426j);
                this.f34424h.a(this.f34426j);
                this.f34425i.a(this.f34426j);
                Camera camera = this.f34426j;
                if (camera != null) {
                    camera.setPreviewTexture(textureView.getSurfaceTexture());
                }
                this.f34427k.a(this.f34426j, this.f34417a);
                Camera camera2 = this.f34426j;
                if (camera2 != null) {
                    camera2.setDisplayOrientation(this.f34417a.d());
                }
                b bVar = this.f34419c;
                if (bVar != null) {
                    bVar.a(this.f34427k.a());
                }
                this.f34429m = c.CAMERA_INITIALED;
            } else {
                throw new IllegalArgumentException("CameraManager::initCamera SurfaceHolder is null");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(String str) {
        if (this.f34426j != null && this.f34429m.a() != c.CAMERA_CLOSED.a()) {
            if (kotlinx.coroutines.t0.f49654e.equals(str) || "torch".equals(str)) {
                Camera.Parameters parameters = this.f34426j.getParameters();
                parameters.setFlashMode(str);
                this.f34426j.setParameters(parameters);
                this.f34428l = str;
            }
        }
    }

    public synchronized void a(Rect rect, boolean z5) {
        try {
            if (this.f34426j == null) {
                return;
            }
            if (this.f34422f == null) {
                this.f34422f = new i0(this.f34426j);
            }
            this.f34422f.a(rect, this.f34427k.a().x, this.f34427k.a().y, z5, this.f34417a.b() == 1);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a() {
        i0 i0Var = this.f34422f;
        if (i0Var != null) {
            i0Var.e();
            this.f34422f = null;
        }
    }

    public synchronized void a(List<k0.a> list) {
        if (this.f34426j != null && this.f34429m.a() != c.CAMERA_CLOSED.a()) {
            this.f34425i.a(list);
        }
    }

    private int a(int i6) {
        if (i6 != 0 && i6 != 1) {
            return 0;
        }
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i7 = 0; i7 < numberOfCameras; i7++) {
                Camera.getCameraInfo(i7, cameraInfo);
                if (cameraInfo.facing == i6) {
                    return i7;
                }
            }
        } catch (RuntimeException | Exception unused) {
        }
        return 0;
    }
}
