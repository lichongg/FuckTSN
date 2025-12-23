package com.bytedance.adsdk.lottie.up;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.j.j.tj;
import com.bytedance.sdk.component.utils.vl;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {

    /* renamed from: j, reason: collision with root package name */
    private static final ThreadLocal<PathMeasure> f23553j = new ThreadLocal<PathMeasure>() { // from class: com.bytedance.adsdk.lottie.up.g.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    private static final ThreadLocal<Path> xt = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.lottie.up.g.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<Path> cw = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.lottie.up.g.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };

    /* renamed from: r, reason: collision with root package name */
    private static final ThreadLocal<float[]> f23554r = new ThreadLocal<float[]>() { // from class: com.bytedance.adsdk.lottie.up.g.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };
    private static final float up = (float) (Math.sqrt(2.0d) / 2.0d);

    public static int j(float f6, float f7, float f8, float f9) {
        int i6 = f6 != 0.0f ? (int) (f6 * 527.0f) : 17;
        if (f7 != 0.0f) {
            i6 = (int) (i6 * 31 * f7);
        }
        if (f8 != 0.0f) {
            i6 = (int) (i6 * 31 * f8);
        }
        return f9 != 0.0f ? (int) (i6 * 31 * f9) : i6;
    }

    public static boolean j(int i6, int i7, int i8, int i9, int i10, int i11) {
        if (i6 < i9) {
            return false;
        }
        if (i6 > i9) {
            return true;
        }
        if (i7 < i10) {
            return false;
        }
        return i7 > i10 || i8 >= i11;
    }

    public static boolean xt(Matrix matrix) {
        float[] fArr = f23554r.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static Path j(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f6 = pointF.x + pointF3.x;
            float f7 = pointF.y + pointF3.y;
            float f8 = pointF2.x;
            float f9 = f8 + pointF4.x;
            float f10 = pointF2.y;
            path.cubicTo(f6, f7, f9, f10 + pointF4.y, f8, f10);
            return path;
        }
        path.lineTo(pointF2.x, pointF2.y);
        return path;
    }

    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    public static float j(Matrix matrix) {
        float[] fArr = f23554r.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f6 = up;
        fArr[2] = f6;
        fArr[3] = f6;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static void j(Path path, tj tjVar) {
        if (tjVar == null || tjVar.up()) {
            return;
        }
        j(path, ((com.bytedance.adsdk.lottie.j.xt.r) tjVar.xt()).g() / 100.0f, ((com.bytedance.adsdk.lottie.j.xt.r) tjVar.cw()).g() / 100.0f, ((com.bytedance.adsdk.lottie.j.xt.r) tjVar.r()).g() / 360.0f);
    }

    public static void j(Path path, float f6, float f7, float f8) {
        com.bytedance.adsdk.lottie.up.j("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f23553j.get();
        Path path2 = xt.get();
        Path path3 = cw.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f6 == 1.0f && f7 == 0.0f) {
            com.bytedance.adsdk.lottie.up.xt("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f7 - f6) - 1.0f) >= 0.01d) {
            float f9 = f6 * length;
            float f10 = f7 * length;
            float f11 = f8 * length;
            float min = Math.min(f9, f10) + f11;
            float max = Math.max(f9, f10) + f11;
            if (min >= length && max >= length) {
                min = tl.j(min, length);
                max = tl.j(max, length);
            }
            if (min < 0.0f) {
                min = tl.j(min, length);
            }
            if (max < 0.0f) {
                max = tl.j(max, length);
            }
            if (min == max) {
                path.reset();
                com.bytedance.adsdk.lottie.up.xt("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            com.bytedance.adsdk.lottie.up.xt("applyTrimPathIfNeeded");
            return;
        }
        com.bytedance.adsdk.lottie.up.xt("applyTrimPathIfNeeded");
    }

    public static float j() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float j(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap j(Bitmap bitmap, int i6, int i7) {
        if (bitmap.getWidth() == i6 && bitmap.getHeight() == i7) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i6, i7, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static boolean j(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void j(Canvas canvas, RectF rectF, Paint paint) {
        j(canvas, rectF, paint, 31);
    }

    public static void j(Canvas canvas, RectF rectF, Paint paint, int i6) {
        com.bytedance.adsdk.lottie.up.j("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i6);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.bytedance.adsdk.lottie.up.xt("Utils#saveLayer");
    }

    public static float j(String str, String str2, int i6) {
        if (str2 != null) {
            try {
                if (str2.contains("%")) {
                    return (Integer.parseInt(str2.substring(0, str2.length() - 1)) / 100.0f) * i6;
                }
                return Integer.parseInt(str2) * j();
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        if (TextUtils.equals("x", str) || TextUtils.equals("y", str)) {
            return 0.0f;
        }
        return i6;
    }
}
