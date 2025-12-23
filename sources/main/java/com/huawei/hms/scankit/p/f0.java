package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    private e0 f34245a;

    /* renamed from: b, reason: collision with root package name */
    private Point f34246b;

    /* renamed from: c, reason: collision with root package name */
    private Point f34247c;

    void a(Camera camera, e0 e0Var) {
        if (camera == null || e0Var == null) {
            throw new IllegalArgumentException("initCameraParameters param is invalid");
        }
        Camera.Parameters parameters = camera.getParameters();
        this.f34245a = e0Var;
        this.f34246b = a(parameters, e0Var.a(), false);
        this.f34246b.toString();
        if (e0Var.c() == 0) {
            this.f34247c = a(parameters, e0Var.a(), true);
            this.f34247c.toString();
        }
        a(camera, this.f34246b, this.f34247c);
    }

    private void c(Camera.Parameters parameters) {
        String str;
        String[] strArr = {"continuous-picture", "continuous-video", "auto"};
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            return;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= 3) {
                str = null;
                break;
            }
            str = strArr[i6];
            if (supportedFocusModes.contains(str)) {
                break;
            } else {
                i6++;
            }
        }
        if (str != null) {
            parameters.setFocusMode(str);
        }
    }

    private void b(Camera.Parameters parameters) {
        if (parameters.isZoomSupported()) {
            parameters.setZoom(1);
        }
    }

    Point a() {
        return this.f34246b;
    }

    private void a(Camera camera, Point point, Point point2) {
        if (this.f34245a == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(point.x, point.y);
        if (this.f34245a.c() == 0) {
            parameters.setPictureSize(point2.x, point2.y);
        }
        if (this.f34245a.b() != 1) {
            a(parameters);
        }
        c(parameters);
        b(parameters);
        if (this.f34245a.e()) {
            parameters.setRecordingHint(true);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            a(parameters, true);
        }
        camera.setParameters(parameters);
    }

    public static void a(Camera.Parameters parameters, boolean z5) {
        try {
            Method method = Camera.Parameters.class.getMethod("setScanOptEnable", Boolean.TYPE);
            if (method != null) {
                method.invoke(parameters, Boolean.valueOf(z5));
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | Exception unused) {
        }
    }

    private Point a(Camera.Parameters parameters, Point point, boolean z5) {
        List<Camera.Size> supportedPictureSizes;
        if (!z5) {
            supportedPictureSizes = parameters.getSupportedPreviewSizes();
        } else {
            supportedPictureSizes = parameters.getSupportedPictureSizes();
        }
        if (supportedPictureSizes != null && !supportedPictureSizes.isEmpty()) {
            return a(supportedPictureSizes, point);
        }
        return new Point(0, 0);
    }

    private Point a(List<Camera.Size> list, Point point) {
        double d6 = point.x / point.y;
        int i6 = 0;
        double d7 = Double.MAX_VALUE;
        int i7 = 0;
        for (Camera.Size size : list) {
            int i8 = size.width;
            int i9 = size.height;
            if (i8 == point.x && i9 == point.y) {
                return new Point(i8, i9);
            }
            if (i8 * i9 >= 153600.0d) {
                double d8 = (i8 / i9) - d6;
                if (Math.abs(d8) < d7) {
                    d7 = Math.abs(d8);
                    i7 = i9;
                    i6 = i8;
                }
            }
        }
        return new Point(i6, i7);
    }

    private void a(Camera.Parameters parameters) {
        e0 e0Var = this.f34245a;
        if (e0Var == null) {
            return;
        }
        String f6 = e0Var.f();
        if (!f6.equals(kotlinx.coroutines.t0.f49654e) && !f6.equals("torch")) {
            f6 = kotlinx.coroutines.t0.f49654e;
        }
        parameters.setFlashMode(f6);
    }
}
