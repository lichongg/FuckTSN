package com.bxkj.student.v2.ai.fitness.camera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.bxkj.student.v2.ai.fitness.camera.f;
import com.google.android.gms.common.images.Size;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c {

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f20513m = 0;

    /* renamed from: n, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f20514n = 1;

    /* renamed from: o, reason: collision with root package name */
    public static final int f20515o = 17;

    /* renamed from: p, reason: collision with root package name */
    public static final int f20516p = 480;

    /* renamed from: q, reason: collision with root package name */
    public static final int f20517q = 360;

    /* renamed from: r, reason: collision with root package name */
    private static final String f20518r = "MIDemoApp:CameraSource";

    /* renamed from: s, reason: collision with root package name */
    private static final int f20519s = 100;

    /* renamed from: t, reason: collision with root package name */
    private static final float f20520t = 0.01f;

    /* renamed from: u, reason: collision with root package name */
    private static final float f20521u = 30.0f;

    /* renamed from: v, reason: collision with root package name */
    private static final boolean f20522v = true;

    /* renamed from: a, reason: collision with root package name */
    protected Activity f20523a;

    /* renamed from: b, reason: collision with root package name */
    private Camera f20524b;

    /* renamed from: d, reason: collision with root package name */
    private int f20526d;

    /* renamed from: e, reason: collision with root package name */
    private Size f20527e;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceTexture f20528f;

    /* renamed from: g, reason: collision with root package name */
    private final GraphicOverlay f20529g;

    /* renamed from: h, reason: collision with root package name */
    private Thread f20530h;

    /* renamed from: i, reason: collision with root package name */
    private final b f20531i;

    /* renamed from: k, reason: collision with root package name */
    private m f20533k;

    /* renamed from: c, reason: collision with root package name */
    private int f20525c = 1;

    /* renamed from: j, reason: collision with root package name */
    private final Object f20532j = new Object();

    /* renamed from: l, reason: collision with root package name */
    private final IdentityHashMap<byte[], ByteBuffer> f20534l = new IdentityHashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements Camera.PreviewCallback {
        /* synthetic */ a(c cVar, d dVar) {
            this();
        }

        private a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] data, Camera camera) {
            c.this.f20531i.b(data, camera);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Object f20536a = new Object();

        /* renamed from: b, reason: collision with root package name */
        private boolean f20537b = true;

        /* renamed from: c, reason: collision with root package name */
        private ByteBuffer f20538c;

        b() {
        }

        void a(boolean active) {
            synchronized (this.f20536a) {
                this.f20537b = active;
                this.f20536a.notifyAll();
            }
        }

        void b(byte[] data, Camera camera) {
            synchronized (this.f20536a) {
                try {
                    ByteBuffer byteBuffer = this.f20538c;
                    if (byteBuffer != null) {
                        camera.addCallbackBuffer(byteBuffer.array());
                        this.f20538c = null;
                    }
                    if (c.this.f20534l.containsKey(data)) {
                        this.f20538c = (ByteBuffer) c.this.f20534l.get(data);
                        this.f20536a.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        @SuppressLint({"InlinedApi"})
        public void run() {
            boolean z5;
            ByteBuffer byteBuffer;
            while (true) {
                synchronized (this.f20536a) {
                    while (true) {
                        z5 = this.f20537b;
                        if (!z5 || this.f20538c != null) {
                            break;
                        }
                        try {
                            this.f20536a.wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                    if (!z5) {
                        return;
                    }
                    byteBuffer = this.f20538c;
                    this.f20538c = null;
                }
                try {
                    synchronized (c.this.f20532j) {
                        c.this.f20533k.a(byteBuffer, new f.a().d(c.this.f20527e.getWidth()).b(c.this.f20527e.getHeight()).c(c.this.f20526d).a(), c.this.f20529g);
                    }
                } catch (Exception unused2) {
                } finally {
                    c.this.f20524b.addCallbackBuffer(byteBuffer.array());
                }
            }
        }
    }

    public synchronized void s(int facing) {
        try {
            if (facing != 0 && facing != 1) {
                throw new IllegalArgumentException("Invalid camera: " + facing);
            }
            this.f20525c = facing;
        } catch (Throwable th) {
            throw th;
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public synchronized c v() throws IOException {
        if (this.f20524b != null) {
            return this;
        }
        this.f20524b = j();
        SurfaceTexture surfaceTexture = new SurfaceTexture(100);
        this.f20528f = surfaceTexture;
        this.f20524b.setPreviewTexture(surfaceTexture);
        this.f20524b.startPreview();
        this.f20530h = new Thread(this.f20531i);
        this.f20531i.a(true);
        this.f20530h.start();
        return this;
    }

    @RequiresPermission("android.permission.CAMERA")
    public synchronized c w(SurfaceHolder surfaceHolder) throws IOException {
        if (this.f20524b != null) {
            return this;
        }
        Camera j6 = j();
        this.f20524b = j6;
        j6.setPreviewDisplay(surfaceHolder);
        this.f20524b.startPreview();
        this.f20530h = new Thread(this.f20531i);
        this.f20531i.a(true);
        this.f20530h.start();
        return this;
    }

    public synchronized void x() {
        this.f20531i.a(false);
        Thread thread = this.f20530h;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException unused) {
            }
            this.f20530h = null;
        }
        Camera camera = this.f20524b;
        if (camera != null) {
            camera.stopPreview();
            this.f20524b.setPreviewCallbackWithBuffer(null);
            try {
                this.f20524b.setPreviewTexture(null);
                this.f20528f = null;
                this.f20524b.setPreviewDisplay(null);
            } catch (Exception e6) {
                e6.toString();
            }
            this.f20524b.release();
            this.f20524b = null;
        }
        this.f20534l.clear();
    }

    private void i() {
        this.f20529g.h();
    }

    @SuppressLint({"InlinedApi"})
    private Camera j() throws IOException {
        int n6 = n(this.f20525c);
        if (n6 == -1) {
            throw new IOException("Could not find requested camera.");
        }
        Camera open = Camera.open(n6);
        C0275c a6 = com.bxkj.student.v2.ai.fitness.preference.a.a(this.f20523a, n6);
        if (a6 == null) {
            a6 = r(open, 480, 360);
        }
        if (a6 == null) {
            throw new IOException("Could not find suitable preview size.");
        }
        this.f20527e = a6.f20540a;
        Objects.toString(this.f20527e);
        int[] q5 = q(open, 30.0f);
        if (q5 == null) {
            throw new IOException("Could not find suitable preview frames per second range.");
        }
        Camera.Parameters parameters = open.getParameters();
        Size size = a6.f20541b;
        if (size != null) {
            size.toString();
            parameters.setPictureSize(size.getWidth(), size.getHeight());
        }
        parameters.setPreviewSize(this.f20527e.getWidth(), this.f20527e.getHeight());
        parameters.setPreviewFpsRange(q5[0], q5[1]);
        parameters.setPreviewFormat(17);
        u(open, parameters, n6);
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new a(this, null));
        open.addCallbackBuffer(k(this.f20527e));
        open.addCallbackBuffer(k(this.f20527e));
        open.addCallbackBuffer(k(this.f20527e));
        open.addCallbackBuffer(k(this.f20527e));
        return open;
    }

    @SuppressLint({"InlinedApi"})
    private byte[] k(Size previewSize) {
        byte[] bArr = new byte[((int) Math.ceil(((previewSize.getHeight() * previewSize.getWidth()) * ImageFormat.getBitsPerPixel(17)) / 8.0d)) + 1];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.f20534l.put(bArr, wrap);
        return bArr;
    }

    private static int n(int facing) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i6 = 0; i6 < Camera.getNumberOfCameras(); i6++) {
            Camera.getCameraInfo(i6, cameraInfo);
            if (cameraInfo.facing == facing) {
                return i6;
            }
        }
        return -1;
    }

    @SuppressLint({"InlinedApi"})
    private static int[] q(Camera camera, float desiredPreviewFps) {
        int i6 = (int) (desiredPreviewFps * 1000.0f);
        int[] iArr = null;
        int i7 = Integer.MAX_VALUE;
        int i8 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i6 - iArr2[1]);
            int i9 = iArr2[0];
            if (abs <= i7 && i9 <= i8) {
                iArr = iArr2;
                i7 = abs;
                i8 = i9;
            }
        }
        return iArr;
    }

    private void u(Camera camera, Camera.Parameters parameters, int cameraId) {
        int i6;
        int rotation = ((WindowManager) this.f20523a.getSystemService("window")).getDefaultDisplay().getRotation();
        int i7 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i7 = 90;
            } else if (rotation == 2) {
                i7 = 180;
            } else if (rotation == 3) {
                i7 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(cameraId, cameraInfo);
        if (cameraInfo.facing == 1) {
            int i8 = (cameraInfo.orientation + i7) % 360;
            this.f20526d = i8;
            i6 = (360 - i8) % 360;
        } else {
            i6 = ((cameraInfo.orientation - i7) + 360) % 360;
            this.f20526d = i6;
        }
        camera.setDisplayOrientation(i6);
        parameters.setRotation(this.f20526d);
    }

    public int m() {
        return this.f20525c;
    }

    public Size o() {
        return this.f20527e;
    }

    public void p() {
        synchronized (this.f20532j) {
            try {
                x();
                i();
                m mVar = this.f20533k;
                if (mVar != null) {
                    mVar.stop();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void t(m processor) {
        synchronized (this.f20532j) {
            try {
                i();
                m mVar = this.f20533k;
                if (mVar != null) {
                    mVar.stop();
                }
                this.f20533k = processor;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.v2.ai.fitness.camera.c$c, reason: collision with other inner class name */
    public static class C0275c {

        /* renamed from: a, reason: collision with root package name */
        public final Size f20540a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final Size f20541b;

        C0275c(Camera.Size previewSize, @Nullable Camera.Size pictureSize) {
            this.f20540a = new Size(previewSize.width, previewSize.height);
            this.f20541b = pictureSize != null ? new Size(pictureSize.width, pictureSize.height) : null;
        }

        public C0275c(Size previewSize, @Nullable Size pictureSize) {
            this.f20540a = previewSize;
            this.f20541b = pictureSize;
        }
    }

    public c(Activity activity, GraphicOverlay overlay) {
        this.f20523a = activity;
        this.f20529g = overlay;
        overlay.h();
        this.f20531i = new b();
    }

    public static List<C0275c> l(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f6 = size.width / size.height;
            Iterator<Camera.Size> it = supportedPictureSizes.iterator();
            while (true) {
                if (it.hasNext()) {
                    Camera.Size next = it.next();
                    if (Math.abs(f6 - (next.width / next.height)) < f20520t) {
                        arrayList.add(new C0275c(size, next));
                        break;
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
            while (it2.hasNext()) {
                arrayList.add(new C0275c(it2.next(), (Camera.Size) null));
            }
        }
        return arrayList;
    }

    public static C0275c r(Camera camera, int desiredWidth, int desiredHeight) {
        C0275c c0275c = null;
        int i6 = Integer.MAX_VALUE;
        for (C0275c c0275c2 : l(camera)) {
            Size size = c0275c2.f20540a;
            int abs = Math.abs(size.getWidth() - desiredWidth) + Math.abs(size.getHeight() - desiredHeight);
            if (abs < i6) {
                c0275c = c0275c2;
                i6 = abs;
            }
        }
        return c0275c;
    }
}
