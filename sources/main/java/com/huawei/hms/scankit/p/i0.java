package com.huawei.hms.scankit.p;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i0 implements Camera.AutoFocusCallback {

    /* renamed from: i, reason: collision with root package name */
    private static final Set<String> f34364i;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f34365a;

    /* renamed from: b, reason: collision with root package name */
    private Camera f34366b;

    /* renamed from: c, reason: collision with root package name */
    private AsyncTask<?, ?, ?> f34367c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34368d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34369e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f34370f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f34371g = 2;

    /* renamed from: h, reason: collision with root package name */
    private String f34372h = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends AsyncTask<Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<i0> f34373a;

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            i0 i0Var = this.f34373a.get();
            if (i0Var == null) {
                return null;
            }
            i0Var.d();
            try {
                Thread.sleep(Math.max(i0Var.c(), 0));
            } catch (InterruptedException unused) {
            }
            return null;
        }

        a(i0 i0Var) {
            this.f34373a = new WeakReference<>(i0Var);
        }
    }

    private synchronized void b() {
        try {
            AsyncTask<?, ?, ?> asyncTask = this.f34367c;
            if (asyncTask != null) {
                if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                    this.f34367c.cancel(true);
                }
                this.f34367c = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int c() {
        return this.f34370f;
    }

    public synchronized void d() {
        if (this.f34365a) {
            this.f34367c = null;
            if (!this.f34368d && !this.f34369e) {
                try {
                    this.f34366b.autoFocus(this);
                    this.f34369e = true;
                } catch (RuntimeException e6) {
                    e6.getMessage();
                    a();
                }
            }
        }
    }

    synchronized void e() {
        this.f34368d = true;
        if (this.f34365a) {
            b();
            try {
                Camera camera = this.f34366b;
                if (camera != null) {
                    camera.cancelAutoFocus();
                }
            } catch (RuntimeException e6) {
                e6.getMessage();
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z5, Camera camera) {
        this.f34369e = false;
        a();
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (RuntimeException e6) {
                e6.getMessage();
            }
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFocusMode(this.f34372h);
                camera.setParameters(parameters);
            } catch (RuntimeException e7) {
                e7.getMessage();
            }
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f34364i = hashSet;
        hashSet.add("auto");
        hashSet.add("macro");
    }

    private synchronized void a() {
        if (!this.f34368d && this.f34367c == null) {
            a aVar = new a(this);
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f34367c = aVar;
            } catch (RejectedExecutionException e6) {
                e6.getMessage();
            }
        }
    }

    i0(Camera camera) {
        String str;
        this.f34366b = camera;
        try {
            str = camera.getParameters().getFocusMode();
        } catch (RuntimeException e6) {
            e6.getMessage();
            str = "auto";
        }
        this.f34365a = f34364i.contains(str);
    }

    public void a(Rect rect, int i6, int i7, boolean z5, boolean z6) {
        int i8 = this.f34371g;
        if (i8 < 1) {
            return;
        }
        this.f34371g = i8 - 1;
        Rect a6 = a(rect.centerX(), rect.centerY(), 1.0f, i7, i6, false, z5 ? 90 : 0);
        if (a6 == null) {
            this.f34371g--;
            return;
        }
        Camera camera = this.f34366b;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
                Camera.Parameters parameters = this.f34366b.getParameters();
                if (parameters.getMaxNumFocusAreas() > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(a6, 1000));
                    parameters.setFocusAreas(arrayList);
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new Camera.Area(a6, 1000));
                    parameters.setMeteringAreas(arrayList2);
                }
                this.f34372h = parameters.getFocusMode();
                parameters.setFocusMode("macro");
                this.f34366b.setParameters(parameters);
                this.f34366b.autoFocus(this);
            } catch (RuntimeException e6) {
                e6.getMessage();
                this.f34371g++;
            }
        }
    }

    private static Rect a(float f6, float f7, float f8, int i6, int i7, boolean z5, int i8) {
        int i9 = (int) (((f6 / i6) * 2000.0f) - 1000.0f);
        int i10 = (int) (((f7 / i7) * 2000.0f) - 1000.0f);
        RectF rectF = new RectF(a(i9 - 150), a(i10 - 150), a(i9 + 150), a(i10 + 150));
        Matrix matrix = new Matrix();
        try {
            a(matrix, z5, i8);
            matrix.mapRect(rectF);
            return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        } catch (RuntimeException e6) {
            e6.getMessage();
            return null;
        }
    }

    public static void a(Matrix matrix, boolean z5, int i6) {
        if (matrix == null) {
            return;
        }
        Matrix matrix2 = new Matrix();
        try {
            matrix.reset();
            matrix2.setScale(z5 ? -1.0f : 1.0f, 1.0f);
            matrix2.postRotate(i6);
            matrix2.invert(matrix);
        } catch (RuntimeException e6) {
            e6.getMessage();
        }
    }

    private static int a(int i6) {
        if (i6 > 1000) {
            return 1000;
        }
        return Math.max(i6, -1000);
    }
}
