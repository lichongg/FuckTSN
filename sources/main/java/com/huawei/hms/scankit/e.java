package com.huawei.hms.scankit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.e5;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.r3;
import com.huawei.hms.scankit.p.r6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.util.OpencvJNI;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.umeng.analytics.pro.bi;
import java.util.Iterator;
import kotlinx.coroutines.t0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class e extends IRemoteViewDelegate.Stub implements e5, SensorEventListener {

    /* renamed from: y, reason: collision with root package name */
    private static final String f33915y = "e";

    /* renamed from: z, reason: collision with root package name */
    protected static boolean f33916z;

    /* renamed from: b, reason: collision with root package name */
    protected int f33918b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f33919c;

    /* renamed from: d, reason: collision with root package name */
    protected ProviderRemoteView f33920d;

    /* renamed from: e, reason: collision with root package name */
    protected TextureView f33921e;

    /* renamed from: f, reason: collision with root package name */
    protected com.huawei.hms.scankit.b f33922f;

    /* renamed from: g, reason: collision with root package name */
    protected IOnResultCallback f33923g;

    /* renamed from: h, reason: collision with root package name */
    protected SensorManager f33924h;

    /* renamed from: i, reason: collision with root package name */
    protected View.OnClickListener f33925i;

    /* renamed from: l, reason: collision with root package name */
    protected Boolean f33928l;

    /* renamed from: m, reason: collision with root package name */
    protected AlertDialog f33929m;

    /* renamed from: n, reason: collision with root package name */
    protected Rect f33930n;

    /* renamed from: o, reason: collision with root package name */
    private IObjectWrapper f33931o;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f33932p;

    /* renamed from: q, reason: collision with root package name */
    private OrientationEventListener f33933q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f33934r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f33935s;

    /* renamed from: v, reason: collision with root package name */
    protected IOnLightCallback f33938v;

    /* renamed from: w, reason: collision with root package name */
    protected LinearLayout f33939w;

    /* renamed from: a, reason: collision with root package name */
    private volatile w3 f33917a = null;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f33926j = false;

    /* renamed from: k, reason: collision with root package name */
    protected final Float f33927k = Float.valueOf(40.0f);

    /* renamed from: t, reason: collision with root package name */
    protected boolean f33936t = true;

    /* renamed from: u, reason: collision with root package name */
    private Point f33937u = null;

    /* renamed from: x, reason: collision with root package name */
    boolean f33940x = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            e.this.f33922f.b(motionEvent);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends OrientationEventListener {
        b(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i6) {
            int rotation = ((Activity) e.this.f33919c).getWindowManager().getDefaultDisplay().getRotation();
            boolean b6 = w7.b();
            boolean e6 = w7.e();
            if (w7.e(e.this.f33919c) && !b6) {
                e.this.a(90);
                return;
            }
            if (w7.b((Activity) e.this.f33919c) && !e6) {
                e.this.a(90);
                return;
            }
            if (rotation == 0) {
                e.this.a(90);
                return;
            }
            if (rotation == 1) {
                e.this.a(0);
            } else if (rotation == 2) {
                e.this.a(270);
            } else {
                if (rotation != 3) {
                    return;
                }
                e.this.a(180);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f33929m.dismiss();
        }
    }

    protected void b(Point point, boolean z5) {
        int i6;
        int i7;
        float f6;
        float f7;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f33921e.getLayoutParams();
        float f8 = point.x;
        float f9 = point.y;
        boolean b6 = w7.b();
        o4.d(f33915y, "initSurfaceViewSize: isPortraitScreen: " + w7.c((Activity) this.f33919c) + " inMultiWindow: " + w7.f(this.f33919c) + " isInMultiWindowFreeform: " + w7.b((Activity) this.f33919c) + " isPadOrFold: " + w7.j(this.f33919c) + " isFoldStateExpand: " + w7.h(this.f33919c) + " isPad: " + w7.i(this.f33919c) + " inMagicWindow: " + w7.e(this.f33919c) + " ignore: " + b6 + " screen: " + point.toString() + " width: " + layoutParams.width + " height: " + layoutParams.height + " inMagicWindow " + w7.e(this.f33919c) + " ignore " + b6 + " isInit " + z5 + " isSpecialExpectSize " + this.f33922f.b());
        if (w7.c((Activity) this.f33919c) || (w7.e(this.f33919c) && !(w7.e(this.f33919c) && b6))) {
            f33916z = false;
            boolean equals = "ceres-c3".equals(Build.DEVICE);
            int i8 = PredefinedCaptureConfigurations.f35648o;
            if (equals) {
                i6 = PredefinedCaptureConfigurations.f35648o;
                i7 = PredefinedCaptureConfigurations.f35648o;
            } else {
                i6 = PredefinedCaptureConfigurations.f35652s;
                i7 = PredefinedCaptureConfigurations.f35653t;
            }
            if (z5 && (w7.f(this.f33919c) || w7.b((Activity) this.f33919c) || w7.e(this.f33919c))) {
                i6 = PredefinedCaptureConfigurations.f35648o;
                i7 = PredefinedCaptureConfigurations.f35648o;
            }
            if (this.f33922f.b()) {
                i7 = PredefinedCaptureConfigurations.f35648o;
            } else {
                i8 = i6;
            }
            float f10 = i8;
            float f11 = f8 / f10;
            float f12 = i7;
            float f13 = f9 / f12;
            if (f11 > f13) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f12 * f11);
                layoutParams.gravity = 17;
            } else {
                layoutParams.height = -1;
                layoutParams.width = (int) (f10 * f13);
                layoutParams.gravity = 17;
            }
        } else {
            f33916z = true;
            float f14 = 1280.0f;
            if (z5 && (w7.f(this.f33919c) || w7.b((Activity) this.f33919c) || w7.e(this.f33919c))) {
                f6 = 1280.0f;
                f7 = 1280.0f;
            } else {
                f6 = 1920.0f;
                f7 = 1080.0f;
            }
            if (this.f33922f.b()) {
                f7 = 1280.0f;
            } else {
                f14 = f6;
            }
            float f15 = f8 / f14;
            float f16 = f9 / f7;
            if (f15 > f16) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f7 * f15);
                layoutParams.gravity = 17;
            } else {
                layoutParams.height = -1;
                layoutParams.width = (int) (f14 * f16);
                layoutParams.gravity = 17;
            }
        }
        this.f33921e.setLayoutParams(layoutParams);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void resumeContinuouslyScan() throws RemoteException {
        this.f33940x = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6) {
        com.huawei.hms.scankit.b bVar = this.f33922f;
        if (bVar == null || bVar.a() == null) {
            return;
        }
        try {
            Point a6 = a(this.f33919c);
            if (i6 != this.f33922f.a().d()) {
                this.f33922f.a().b(i6);
            }
            if (this.f33922f.a().i()) {
                Point point = this.f33937u;
                if (point == null || point.x != a6.x) {
                    a(a6, false);
                }
            }
        } catch (NullPointerException unused) {
            o4.e(f33915y, "adjustCameraOrientation: nullpoint");
        } catch (Exception unused2) {
            o4.e(f33915y, "adjustCameraOrientation: Exception");
        }
    }

    protected void c() {
        Object systemService = this.f33919c.getSystemService(bi.ac);
        if (systemService instanceof SensorManager) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.f33924h = sensorManager;
            Iterator<Sensor> it = sensorManager.getSensorList(-1).iterator();
            while (it.hasNext()) {
                if (5 == it.next().getType()) {
                    this.f33926j = true;
                    return;
                }
            }
        }
    }

    protected ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.f33919c : DynamicModuleInitializer.getContext(), true);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        boolean z5;
        boolean z6;
        boolean z7;
        if (!r3.A) {
            OpencvJNI.init();
        }
        Bundle bundle = (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) ? new Bundle() : (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z5 = false;
            z6 = false;
            z7 = true;
        } else {
            z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.USE_APK, false);
            z6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.SUPPORT_ROLLBACK, false);
            z7 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, true);
        }
        r3.f34735f = z7;
        if (z6 && !r3.f34730a && z5) {
            return new HmsScan[]{r6.b()};
        }
        if (this.f33917a == null) {
            try {
                this.f33917a = new w3(bundle, DetailRect.PHOTO_MODE);
            } catch (RuntimeException unused) {
                o4.b(f33915y, "RuntimeException");
            } catch (Exception unused2) {
                o4.b(f33915y, "Exception");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    protected void f() {
        try {
            com.huawei.hms.scankit.b bVar = this.f33922f;
            if (bVar == null || bVar.a() == null) {
                return;
            }
            this.f33922f.a().a(t0.f49654e);
        } catch (RuntimeException unused) {
            o4.b(f33915y, "offFlashRuntimeException");
        } catch (Exception unused2) {
            o4.b(f33915y, "offFlashException");
        }
    }

    public void g() {
        try {
            com.huawei.hms.scankit.b bVar = this.f33922f;
            if (bVar == null || bVar.a() == null) {
                return;
            }
            this.f33922f.a().a("torch");
        } catch (RuntimeException unused) {
            o4.b(f33915y, "openFlashRuntimeException");
        } catch (Exception unused2) {
            o4.b(f33915y, "openFlashException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.f33920d);
    }

    protected void h() {
        AlertDialog create = new AlertDialog.Builder(this.f33919c).create();
        this.f33929m = create;
        create.show();
        View inflate = LayoutInflater.from(DynamicModuleInitializer.getContext() == null ? this.f33919c : DynamicModuleInitializer.getContext()).inflate(R.layout.scankit_dialog_layout, (ViewGroup) null);
        Window window = this.f33929m.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = 60;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setContentView(inflate);
        window.setGravity(80);
        inflate.findViewById(R.id.dialog_sure_btn).setOnClickListener(new c());
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        Context context = this.f33919c;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.f33919c).getWindow().setFlags(16777216, 16777216);
        }
        Context context2 = this.f33919c;
        if (context2 != null && context2.getPackageManager() != null) {
            this.f33936t = this.f33919c.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            o4.d("Scankit", "initlight hasFlash " + this.f33936t);
        }
        e();
        this.f33922f.a(this);
        this.f33920d.setOnTouchListener(new a());
        IOnResultCallback iOnResultCallback = this.f33923g;
        if (iOnResultCallback != null) {
            this.f33922f.a(iOnResultCallback);
        }
        this.f33922f.a(this.f33934r);
        this.f33922f.c();
        if (Build.VERSION.SDK_INT >= 24) {
            b bVar = new b(this.f33919c);
            this.f33933q = bVar;
            if (bVar.canDetectOrientation()) {
                this.f33933q.enable();
            } else {
                this.f33933q.disable();
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onDestroy() {
        try {
            this.f33922f.d();
            OrientationEventListener orientationEventListener = this.f33933q;
            if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
                this.f33933q.disable();
            }
            if (this.f33919c != null) {
                this.f33919c = null;
            }
            AlertDialog alertDialog = this.f33929m;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
            this.f33929m.dismiss();
            this.f33929m = null;
        } catch (RuntimeException unused) {
            o4.b(f33915y, "onDestroyRuntimeException");
        } catch (Exception unused2) {
            o4.b(f33915y, "onDestroyException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onPause() {
        try {
            this.f33922f.e();
            this.f33924h.unregisterListener(this);
        } catch (RuntimeException unused) {
            o4.b(f33915y, "onPauseRuntimeException");
        } catch (Exception unused2) {
            o4.b(f33915y, "onPauseException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        try {
            this.f33922f.f();
            SensorManager sensorManager = this.f33924h;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
        } catch (RuntimeException unused) {
            o4.b(f33915y, "onResumeRuntimeException");
        } catch (Exception unused2) {
            o4.b(f33915y, "onResumeException");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f33926j && sensorEvent.sensor.getType() == 5 && this.f33936t) {
            boolean z5 = sensorEvent.values[0] > this.f33927k.floatValue();
            this.f33928l = Boolean.valueOf(z5);
            if (z5) {
                if (sensorEvent.values[0] > 600.0f) {
                    if (this.f33939w != null && !b()) {
                        this.f33939w.setVisibility(8);
                    }
                    IOnLightCallback iOnLightCallback = this.f33938v;
                    if (iOnLightCallback != null) {
                        try {
                            iOnLightCallback.onVisibleChanged(false);
                            return;
                        } catch (RemoteException unused) {
                            o4.e(f33915y, "onSensorChanged RemoteException");
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (w7.a(this.f33919c)) {
                if (this.f33939w != null) {
                    o4.d("Scankit", "initlight onSensorChanged open");
                    this.f33939w.setVisibility(0);
                }
                IOnLightCallback iOnLightCallback2 = this.f33938v;
                if (iOnLightCallback2 != null) {
                    try {
                        iOnLightCallback2.onVisibleChanged(true);
                    } catch (RemoteException unused2) {
                        o4.e(f33915y, "onSensorChanged RemoteException");
                    }
                }
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStart() {
        try {
            this.f33922f.g();
        } catch (RuntimeException unused) {
            o4.b(f33915y, "onStartRuntimeException");
        } catch (Exception unused2) {
            o4.b(f33915y, "onStartException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStop() {
        try {
            this.f33922f.h();
        } catch (RuntimeException unused) {
            o4.b(f33915y, "onStopRuntimeException");
        } catch (Exception unused2) {
            o4.b(f33915y, "onStopException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void pauseContinuouslyScan() throws RemoteException {
        com.huawei.hms.scankit.b bVar = this.f33922f;
        if (bVar != null) {
            bVar.i();
        }
        this.f33940x = true;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.f33925i = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
        com.huawei.hms.scankit.b bVar = this.f33922f;
        if (bVar != null) {
            bVar.a(iOnErrorCallback);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
        this.f33938v = iOnLightCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnResultCallback(IOnResultCallback iOnResultCallback) {
        this.f33923g = iOnResultCallback;
        com.huawei.hms.scankit.b bVar = this.f33922f;
        if (bVar != null) {
            bVar.a(iOnResultCallback);
        }
    }

    public e(Context context, int i6, Object obj, IObjectWrapper iObjectWrapper, boolean z5, boolean z6, boolean z7) {
        this.f33918b = 0;
        this.f33932p = false;
        this.f33919c = context;
        this.f33918b = i6;
        this.f33931o = iObjectWrapper;
        if (obj instanceof Rect) {
            this.f33930n = (Rect) obj;
        } else {
            this.f33930n = null;
        }
        this.f33932p = z5;
        this.f33934r = z6;
        this.f33935s = z7;
    }

    protected void e() {
        ProviderRemoteView d6 = d();
        this.f33920d = d6;
        this.f33921e = (TextureView) d6.findViewById(R.id.surfaceView);
        com.huawei.hms.scankit.b bVar = new com.huawei.hms.scankit.b(this.f33919c, this.f33921e, null, this.f33930n, this.f33918b, this.f33931o, this.f33932p, "CustomizedView", true);
        this.f33922f = bVar;
        bVar.b(this.f33935s);
        c();
        a((Point) null, true);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public boolean getLightStatus() throws RemoteException {
        return b();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
        f();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
        g();
    }

    private static Point a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (!w7.f(context) && !w7.e(context)) {
            defaultDisplay.getRealSize(point);
            return point;
        }
        defaultDisplay.getSize(point);
        return point;
    }

    protected void a(Point point, boolean z5) {
        try {
            if (this.f33919c.getSystemService("window") != null) {
                if (point == null) {
                    point = a(this.f33919c);
                }
                this.f33937u = point;
                b(point, z5);
            }
        } catch (NullPointerException unused) {
            o4.e(f33915y, "initSurfaceView: nullpoint");
        } catch (Exception unused2) {
            o4.e(f33915y, "initSurfaceView: Exception");
        }
    }

    @Override // com.huawei.hms.scankit.p.e5
    public boolean a(HmsScan[] hmsScanArr) {
        AlertDialog alertDialog;
        if (hmsScanArr == null || hmsScanArr.length <= 0 || (alertDialog = this.f33929m) == null || !alertDialog.isShowing()) {
            return false;
        }
        this.f33929m.dismiss();
        return false;
    }

    @Override // com.huawei.hms.scankit.p.e5
    public boolean a() {
        return this.f33940x;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z5;
        int i6;
        if (iObjectWrapper == null) {
            o4.b("ScankitRemoteS", "bitmap is null");
            return new HmsScan[0];
        }
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z5 = false;
            i6 = 0;
        } else {
            i6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            int i7 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i7;
            z5 = i7 >= 2;
            if (z5) {
                i6 = w7.b(i6);
            }
        }
        HmsScan[] b6 = r6.a().b((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), i6, true, this.f33917a);
        if (!z5) {
            b6 = w7.a(b6);
        }
        if (b6.length == 0) {
            h();
            return b6;
        }
        HmsScan hmsScan = b6[0];
        if (hmsScan != null && TextUtils.isEmpty(hmsScan.originalValue)) {
            h();
        }
        return b6;
    }

    protected boolean b() {
        try {
            return this.f33922f.a().h().equals("torch");
        } catch (RuntimeException unused) {
            o4.b(f33915y, "getFlashStatusRuntimeException");
            return false;
        } catch (Exception unused2) {
            o4.b(f33915y, "getFlashStatusException");
            return false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i6) {
    }
}
