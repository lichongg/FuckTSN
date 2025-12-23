package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.TextureView;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.e0;
import com.huawei.hms.scankit.p.e5;
import com.huawei.hms.scankit.p.f5;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.k0;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.m0;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.v3;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.tencent.open.apireq.BaseResp;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class b {
    public static final String H = "b";
    public static volatile v3 I;
    public static volatile w3 J;
    private IOnErrorCallback D;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f33829a;

    /* renamed from: b, reason: collision with root package name */
    private final int f33830b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f33831c;

    /* renamed from: d, reason: collision with root package name */
    private Context f33832d;

    /* renamed from: e, reason: collision with root package name */
    private com.huawei.hms.scankit.a f33833e;

    /* renamed from: f, reason: collision with root package name */
    private f5 f33834f;

    /* renamed from: g, reason: collision with root package name */
    private j0 f33835g;

    /* renamed from: h, reason: collision with root package name */
    private ViewfinderView f33836h;

    /* renamed from: i, reason: collision with root package name */
    public TextureView f33837i;

    /* renamed from: j, reason: collision with root package name */
    private TextureView.SurfaceTextureListener f33838j;

    /* renamed from: k, reason: collision with root package name */
    private Collection<BarcodeFormat> f33839k;

    /* renamed from: l, reason: collision with root package name */
    private Map<l1, ?> f33840l;

    /* renamed from: m, reason: collision with root package name */
    private String f33841m;

    /* renamed from: o, reason: collision with root package name */
    private String f33843o;

    /* renamed from: q, reason: collision with root package name */
    private float f33845q;

    /* renamed from: u, reason: collision with root package name */
    private boolean f33849u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f33850v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f33851w;

    /* renamed from: x, reason: collision with root package name */
    private IObjectWrapper f33852x;

    /* renamed from: y, reason: collision with root package name */
    private e5 f33853y;

    /* renamed from: z, reason: collision with root package name */
    private IOnResultCallback f33854z;

    /* renamed from: p, reason: collision with root package name */
    private boolean f33844p = true;

    /* renamed from: r, reason: collision with root package name */
    private boolean f33846r = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f33847s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f33848t = true;
    private boolean A = false;
    private boolean B = false;
    private boolean E = true;
    private boolean F = false;
    private boolean G = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f33842n = false;
    private boolean C = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f33835g.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.scankit.b$b, reason: collision with other inner class name */
    class C0547b implements j0.d {
        C0547b() {
        }

        @Override // com.huawei.hms.scankit.p.j0.d
        public void b() {
            if (b.this.D != null) {
                try {
                    b.this.D.onError(-1000);
                } catch (RemoteException unused) {
                    o4.b(b.H, "RemoteException");
                }
            }
        }

        @Override // com.huawei.hms.scankit.p.j0.d
        public void a() {
        }

        @Override // com.huawei.hms.scankit.p.j0.d
        public void c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements TextureView.SurfaceTextureListener {
        c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
            b.this.B = false;
            if (surfaceTexture == null) {
                o4.b(b.H, "*** WARNING *** surfaceCreated() gave us a null surface!");
            }
            if (b.this.f33842n) {
                return;
            }
            b.this.f33842n = true;
            if (b.this.f33832d.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0) {
                b bVar = b.this;
                bVar.a(bVar.f33837i);
            } else {
                if (b.this.G || !(b.this.f33832d instanceof Activity) || Build.VERSION.SDK_INT < 23) {
                    return;
                }
                b.this.B = true;
                ((Activity) b.this.f33832d).requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.f33842n = false;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements f5 {
        d() {
        }

        @Override // com.huawei.hms.scankit.p.f5
        public void a(HmsScan[] hmsScanArr, Bitmap bitmap, float f6) {
            b.this.a(hmsScanArr, bitmap);
        }
    }

    public void f() {
        TextureView textureView;
        TextureView textureView2;
        this.C = false;
        try {
            I = new v3((Bundle) ObjectWrapper.unwrap(this.f33852x), this.f33843o);
            I.h();
        } catch (RuntimeException unused) {
            o4.b(H, "RuntimeException");
        } catch (Exception unused2) {
            o4.b(H, "Exception");
        }
        if (!this.A && !this.f33842n && (textureView2 = this.f33837i) != null) {
            textureView2.setSurfaceTextureListener(this.f33838j);
            if (this.f33842n) {
                a(this.f33837i);
            } else {
                this.f33837i.setSurfaceTextureListener(this.f33838j);
            }
        }
        if (this.B && this.f33832d.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0 && (textureView = this.f33837i) != null) {
            this.B = false;
            a(textureView);
        }
    }

    public void g() {
        this.C = false;
        TextureView textureView = this.f33837i;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(this.f33838j);
            this.A = true;
            if (this.f33842n) {
                a(this.f33837i);
            } else {
                this.f33837i.setSurfaceTextureListener(this.f33838j);
            }
        }
    }

    public void h() {
        this.C = true;
        if (I != null) {
            I.i();
        }
        I = null;
        if (this.A) {
            j();
        }
    }

    private void j() {
        com.huawei.hms.scankit.a aVar = this.f33833e;
        if (aVar != null) {
            aVar.e();
            this.f33833e = null;
        }
        this.f33835g.l();
    }

    public void c() {
        this.C = false;
        try {
            J = new w3((Bundle) ObjectWrapper.unwrap(this.f33852x), this.f33843o);
            J.a("single");
        } catch (RuntimeException unused) {
            o4.b(H, "RuntimeException");
        } catch (Exception unused2) {
            o4.b(H, "Exception");
        }
        if (this.f33832d.getPackageManager() == null || this.f33832d.getPackageManager().hasSystemFeature("android.hardware.camera")) {
            this.f33835g = new j0(this.f33832d, a(this.f33832d));
            new Thread(new a()).start();
            this.f33835g.a(new C0547b());
            this.f33838j = new c();
            this.f33834f = new d();
        }
    }

    public void d() {
        this.C = true;
        this.f33837i.setSurfaceTextureListener(null);
        this.f33835g.k();
        J.f34937l.b();
        J = null;
    }

    public void e() {
        this.C = true;
        if (this.A) {
            return;
        }
        j();
    }

    public void i() {
        try {
            j0 j0Var = this.f33835g;
            if (j0Var != null) {
                j0Var.d(1);
            }
        } catch (RuntimeException unused) {
            o4.b(H, "RuntimeException in reset zoomValue");
        } catch (Exception unused2) {
            o4.b(H, "Exception in reset zoomValue");
        }
    }

    public b(Context context, TextureView textureView, ViewfinderView viewfinderView, Rect rect, int i6, IObjectWrapper iObjectWrapper, boolean z5, String str, boolean z6) {
        this.f33832d = context;
        this.f33836h = viewfinderView;
        this.f33852x = iObjectWrapper;
        this.f33837i = textureView;
        this.f33829a = rect;
        this.f33830b = i6;
        this.f33831c = z5;
        this.f33843o = str;
        this.f33850v = z6;
    }

    public boolean b(MotionEvent motionEvent) {
        j0 j0Var = this.f33835g;
        if (j0Var == null || !this.f33844p || j0Var.f().a() < j0.c.CAMERA_OPENED.a() || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float a6 = a(motionEvent);
            float f6 = this.f33845q;
            if (a6 > f6 + 6.0f) {
                a(true, this.f33835g);
            } else if (a6 < f6 - 6.0f) {
                a(false, this.f33835g);
            } else {
                o4.d("CaptureHelper", "MotionEvent.ACTION_MOVE no handleZoom");
            }
            this.f33845q = a6;
        } else if (action == 5) {
            this.f33845q = a(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextureView textureView) {
        if (textureView != null && textureView.getSurfaceTexture() != null) {
            try {
                this.f33835g.a(textureView);
                this.f33835g.a(Collections.singletonList(new k0.a(new Rect(-150, -150, 150, 150), 1000)));
                try {
                    this.f33835g.n();
                } catch (Exception unused) {
                    o4.b(H, "initCamera() get exception");
                }
                if (this.f33833e == null) {
                    com.huawei.hms.scankit.a aVar = new com.huawei.hms.scankit.a(this.f33832d, this.f33836h, this.f33834f, this.f33839k, this.f33840l, this.f33841m, this.f33835g, this.f33829a, this.f33830b, this.f33850v, this.E);
                    this.f33833e = aVar;
                    aVar.c(this.f33849u);
                    this.f33833e.a(this.f33851w);
                    this.f33833e.b(this.f33846r);
                    this.f33833e.a(this.f33853y);
                    return;
                }
                return;
            } catch (Exception e6) {
                if (I != null) {
                    I.c(-1002);
                }
                o4.a(H, "initCamera IOException", e6);
                return;
            }
        }
        o4.e(H, "initCamera() no surface view");
    }

    public void b(boolean z5) {
        this.E = z5;
    }

    public boolean b() {
        return this.F;
    }

    public void c(boolean z5) {
        this.G = z5;
    }

    private void a(boolean z5, j0 j0Var) {
        try {
            m0 g6 = j0Var.g();
            if (j0Var.j()) {
                int c6 = g6.c();
                int b6 = g6.b();
                if (z5 && b6 < c6) {
                    b6++;
                } else if (b6 > 0) {
                    b6--;
                } else {
                    o4.d(H, "handleZoom  zoom not change");
                }
                j0Var.d(b6);
                return;
            }
            o4.d(H, "zoom not supported");
        } catch (RuntimeException unused) {
        }
    }

    private float a(MotionEvent motionEvent) {
        float x5 = motionEvent.getX(0) - motionEvent.getX(1);
        float y5 = motionEvent.getY(0) - motionEvent.getY(1);
        double sqrt = Math.sqrt((x5 * x5) + (y5 * y5));
        if (Double.isInfinite(sqrt) || Double.isNaN(sqrt)) {
            return 0.0f;
        }
        return BigDecimal.valueOf(sqrt).floatValue();
    }

    public void a(HmsScan[] hmsScanArr, Bitmap bitmap) {
        o4.a("scan-time", "decode time:" + System.currentTimeMillis());
        try {
            String str = H;
            o4.d(str, "result onResult");
            if (this.f33853y.a()) {
                o4.d(str, "result intercepted");
                return;
            }
            if (I != null) {
                I.a(hmsScanArr);
            }
            if (!this.f33831c) {
                hmsScanArr = w7.a(hmsScanArr);
            }
            if (this.f33853y != null) {
                if (this.f33836h != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                    o4.d(str, "result draw result point");
                    if (this.f33832d instanceof Activity) {
                        this.f33836h.a(hmsScanArr[0].getBorderRect(), w7.c((Activity) this.f33832d), this.f33835g.e());
                    }
                    this.C = false;
                }
                this.f33853y.a(hmsScanArr);
            }
            if (this.f33854z != null) {
                try {
                    o4.d(str, "result callback end: pauseStatus" + this.C);
                    if (this.C) {
                        return;
                    }
                    if (this.f33851w && hmsScanArr != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                        Context context = this.f33832d;
                        if (context instanceof Activity) {
                            hmsScanArr[0].originalBitmap = w7.a(bitmap, ((Activity) context).getWindowManager().getDefaultDisplay().getRotation());
                        }
                    }
                    this.f33854z.onResult(hmsScanArr);
                } catch (RemoteException e6) {
                    if (I != null) {
                        I.c(BaseResp.CODE_PERMISSION_NOT_GRANTED);
                    }
                    o4.e("CaptureHelper", "onResult  RemoteException  e:" + e6);
                }
            }
        } catch (RuntimeException e7) {
            e7.toString();
        } catch (Exception e8) {
            e8.toString();
        }
    }

    public b a(boolean z5) {
        this.f33851w = z5;
        com.huawei.hms.scankit.a aVar = this.f33833e;
        if (aVar != null) {
            aVar.a(z5);
        }
        return this;
    }

    public b a(e5 e5Var) {
        this.f33853y = e5Var;
        return this;
    }

    public void a(IOnResultCallback iOnResultCallback) {
        this.f33854z = iOnResultCallback;
    }

    public j0 a() {
        return this.f33835g;
    }

    public void a(IOnErrorCallback iOnErrorCallback) {
        this.D = iOnErrorCallback;
    }

    private e0 a(Context context) {
        e0 a6;
        Activity activity = (Activity) context;
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            a6 = new e0.b().a(new Point(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s)).a(1).b(90).b(false).a(true).a();
        } else if (rotation == 1) {
            a6 = new e0.b().a(new Point(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s)).a(1).b(0).b(false).a(true).a();
        } else if (rotation == 2) {
            a6 = new e0.b().a(new Point(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s)).a(1).b(270).b(false).a(true).a();
        } else if (rotation != 3) {
            a6 = new e0.b().a(new Point(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s)).a(1).b(90).b(false).a(true).a();
        } else {
            a6 = new e0.b().a(new Point(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s)).a(1).b(180).b(false).a(true).a();
        }
        if (w7.f(context) || w7.b(activity) || w7.e(context)) {
            a6.a(new Point(PredefinedCaptureConfigurations.f35652s, PredefinedCaptureConfigurations.f35652s));
            this.F = true;
        }
        if ("ceres-c3".equals(Build.DEVICE)) {
            a6 = new e0.b().a(new Point(PredefinedCaptureConfigurations.f35652s, PredefinedCaptureConfigurations.f35653t)).a(1).b(false).a(true).a();
        }
        boolean b6 = w7.b();
        boolean e6 = w7.e();
        if ((!w7.e(context) || b6) && (!w7.b(activity) || e6)) {
            return a6;
        }
        e0 a7 = new e0.b().a(new Point(PredefinedCaptureConfigurations.f35652s, PredefinedCaptureConfigurations.f35652s)).a(1).b(90).b(false).a(true).a();
        this.F = true;
        return a7;
    }
}
