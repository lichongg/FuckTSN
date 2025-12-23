package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15624a = "TransformationUtils";

    /* renamed from: b, reason: collision with root package name */
    public static final int f15625b = 6;

    /* renamed from: d, reason: collision with root package name */
    private static final int f15627d = 7;

    /* renamed from: f, reason: collision with root package name */
    private static final Paint f15629f;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<String> f15630g;

    /* renamed from: h, reason: collision with root package name */
    private static final Lock f15631h;

    /* renamed from: c, reason: collision with root package name */
    private static final Paint f15626c = new Paint(6);

    /* renamed from: e, reason: collision with root package name */
    private static final Paint f15628e = new Paint(7);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f15632a;

        a(int i6) {
            this.f15632a = i6;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            int i6 = this.f15632a;
            canvas.drawRoundRect(rectF, i6, i6, paint);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f15633a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f15634b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f15635c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f15636d;

        b(float f6, float f7, float f8, float f9) {
            this.f15633a = f6;
            this.f15634b = f7;
            this.f15635c = f8;
            this.f15636d = f9;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            Path path = new Path();
            float f6 = this.f15633a;
            float f7 = this.f15634b;
            float f8 = this.f15635c;
            float f9 = this.f15636d;
            path.addRoundRect(rectF, new float[]{f6, f6, f7, f7, f8, f8, f9, f9}, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface c {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class d implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j6, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        d() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f15630g = hashSet;
        f15631h = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new d();
        Paint paint = new Paint(7);
        f15629f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = f15631h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f15626c);
            e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f15631h.unlock();
            throw th;
        }
    }

    @NonNull
    private static Bitmap.Config h(@NonNull Bitmap bitmap) {
        Bitmap.Config config;
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.RGBA_F16;
            if (config.equals(bitmap.getConfig())) {
                config2 = Bitmap.Config.RGBA_F16;
                return config2;
            }
        }
        return Bitmap.Config.ARGB_8888;
    }

    public static Lock i() {
        return f15631h;
    }

    @VisibleForTesting
    static void l(int i6, Matrix matrix) {
        switch (i6) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    public static Bitmap n(@NonNull Bitmap bitmap, int i6) {
        Bitmap bitmap2;
        Matrix matrix;
        if (i6 == 0) {
            return bitmap;
        }
        try {
            matrix = new Matrix();
            matrix.setRotate(i6);
            bitmap2 = bitmap;
        } catch (Exception unused) {
            bitmap2 = bitmap;
        }
        try {
            return Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception unused2) {
            Log.isLoggable(f15624a, 6);
            return bitmap2;
        }
    }

    public static Bitmap p(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, float f6, float f7, float f8, float f9) {
        return s(eVar, bitmap, new b(f6, f7, f8, f9));
    }

    public static Bitmap q(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6) {
        com.bumptech.glide.util.k.a(i6 > 0, "roundingRadius must be greater than 0.");
        return s(eVar, bitmap, new a(i6));
    }

    private k0() {
    }

    public static Bitmap b(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7) {
        float width;
        float height;
        if (bitmap.getWidth() == i6 && bitmap.getHeight() == i7) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f6 = 0.0f;
        if (bitmap.getWidth() * i7 > bitmap.getHeight() * i6) {
            width = i7 / bitmap.getHeight();
            f6 = (i6 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i6 / bitmap.getWidth();
            height = (i7 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f6 + 0.5f), (int) (height + 0.5f));
        Bitmap e6 = eVar.e(i6, i7, k(bitmap));
        t(bitmap, e6);
        a(bitmap, e6, matrix);
        return e6;
    }

    public static Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7) {
        if (bitmap.getWidth() <= i6 && bitmap.getHeight() <= i7) {
            Log.isLoggable(f15624a, 2);
            return bitmap;
        }
        Log.isLoggable(f15624a, 2);
        return f(eVar, bitmap, i6, i7);
    }

    public static Bitmap d(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7) {
        int min = Math.min(i6, i7);
        float f6 = min;
        float f7 = f6 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f6 / width, f6 / height);
        float f8 = width * max;
        float f9 = max * height;
        float f10 = (f6 - f8) / 2.0f;
        float f11 = (f6 - f9) / 2.0f;
        RectF rectF = new RectF(f10, f11, f8 + f10, f9 + f11);
        Bitmap g6 = g(eVar, bitmap);
        Bitmap e6 = eVar.e(min, min, h(bitmap));
        e6.setHasAlpha(true);
        Lock lock = f15631h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(e6);
            canvas.drawCircle(f7, f7, f7, f15628e);
            canvas.drawBitmap(g6, (Rect) null, rectF, f15629f);
            e(canvas);
            lock.unlock();
            if (!g6.equals(bitmap)) {
                eVar.d(g6);
            }
            return e6;
        } catch (Throwable th) {
            f15631h.unlock();
            throw th;
        }
    }

    public static Bitmap f(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7) {
        if (bitmap.getWidth() == i6 && bitmap.getHeight() == i7) {
            Log.isLoggable(f15624a, 2);
            return bitmap;
        }
        float min = Math.min(i6 / bitmap.getWidth(), i7 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            Log.isLoggable(f15624a, 2);
            return bitmap;
        }
        Bitmap e6 = eVar.e((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), k(bitmap));
        t(bitmap, e6);
        if (Log.isLoggable(f15624a, 2)) {
            bitmap.getWidth();
            bitmap.getHeight();
            e6.getWidth();
            e6.getHeight();
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, e6, matrix);
        return e6;
    }

    private static Bitmap g(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap) {
        Bitmap.Config h6 = h(bitmap);
        if (h6.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap e6 = eVar.e(bitmap.getWidth(), bitmap.getHeight(), h6);
        new Canvas(e6).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return e6;
    }

    public static int j(int i6) {
        switch (i6) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @NonNull
    private static Bitmap.Config k(@NonNull Bitmap bitmap) {
        if (bitmap.getConfig() != null) {
            return bitmap.getConfig();
        }
        return Bitmap.Config.ARGB_8888;
    }

    public static boolean m(int i6) {
        switch (i6) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap o(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6) {
        if (!m(i6)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        l(i6, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap e6 = eVar.e(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        e6.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, e6, matrix);
        return e6;
    }

    @Deprecated
    public static Bitmap r(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i6, int i7, int i8) {
        return q(eVar, bitmap, i8);
    }

    private static Bitmap s(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, c cVar) {
        Bitmap.Config h6 = h(bitmap);
        Bitmap g6 = g(eVar, bitmap);
        Bitmap e6 = eVar.e(g6.getWidth(), g6.getHeight(), h6);
        e6.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(g6, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, e6.getWidth(), e6.getHeight());
        Lock lock = f15631h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(e6);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            cVar.a(canvas, paint, rectF);
            e(canvas);
            lock.unlock();
            if (!g6.equals(bitmap)) {
                eVar.d(g6);
            }
            return e6;
        } catch (Throwable th) {
            f15631h.unlock();
            throw th;
        }
    }

    public static void t(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
