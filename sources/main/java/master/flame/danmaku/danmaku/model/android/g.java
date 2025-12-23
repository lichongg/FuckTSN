package master.flame.danmaku.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.lang.reflect.Array;
import tv.cjump.jni.NativeBitmapFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public Canvas f50035a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f50036b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap[][] f50037c;

    /* renamed from: d, reason: collision with root package name */
    public Object f50038d;

    /* renamed from: e, reason: collision with root package name */
    public int f50039e;

    /* renamed from: f, reason: collision with root package name */
    public int f50040f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f50041g;

    /* renamed from: h, reason: collision with root package name */
    private int f50042h;

    public final synchronized boolean b(Canvas canvas, float f6, float f7, Paint paint) {
        if (this.f50037c == null) {
            Bitmap bitmap = this.f50036b;
            if (bitmap == null) {
                return false;
            }
            canvas.drawBitmap(bitmap, f6, f7, paint);
            return true;
        }
        for (int i6 = 0; i6 < this.f50037c.length; i6++) {
            int i7 = 0;
            while (true) {
                Bitmap[] bitmapArr = this.f50037c[i6];
                if (i7 < bitmapArr.length) {
                    Bitmap bitmap2 = bitmapArr[i7];
                    if (bitmap2 != null) {
                        float width = (bitmap2.getWidth() * i7) + f6;
                        if (width <= canvas.getWidth() && bitmap2.getWidth() + width >= 0.0f) {
                            float height = (bitmap2.getHeight() * i6) + f7;
                            if (height <= canvas.getHeight() && bitmap2.getHeight() + height >= 0.0f) {
                                canvas.drawBitmap(bitmap2, width, height, paint);
                            }
                        }
                    }
                    i7++;
                }
            }
        }
        return true;
    }

    public synchronized void f() {
        try {
            Bitmap bitmap = this.f50036b;
            this.f50036b = null;
            this.f50040f = 0;
            this.f50039e = 0;
            if (bitmap != null) {
                bitmap.recycle();
            }
            g();
            this.f50038d = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void d(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
    }

    private void e() {
        if (this.f50037c != null) {
            for (int i6 = 0; i6 < this.f50037c.length; i6++) {
                int i7 = 0;
                while (true) {
                    Bitmap[] bitmapArr = this.f50037c[i6];
                    if (i7 < bitmapArr.length) {
                        d(bitmapArr[i7]);
                        i7++;
                    }
                }
            }
        }
    }

    private void g() {
        Bitmap[][] bitmapArr = this.f50037c;
        this.f50037c = null;
        if (bitmapArr != null) {
            for (int i6 = 0; i6 < bitmapArr.length; i6++) {
                int i7 = 0;
                while (true) {
                    Bitmap[] bitmapArr2 = bitmapArr[i6];
                    if (i7 < bitmapArr2.length) {
                        Bitmap bitmap = bitmapArr2[i7];
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmapArr[i6][i7] = null;
                        }
                        i7++;
                    }
                }
            }
        }
    }

    public void a(int i6, int i7, int i8, boolean z5, int i9) {
        if (!z5 ? !(i6 > this.f50039e || i7 > this.f50040f) : !(i6 != this.f50039e || i7 != this.f50040f)) {
            Bitmap bitmap = this.f50036b;
            if (bitmap != null) {
                bitmap.eraseColor(0);
                this.f50035a.setBitmap(this.f50036b);
                g();
                return;
            }
        }
        if (this.f50036b != null) {
            f();
        }
        this.f50039e = i6;
        this.f50040f = i7;
        Bitmap.Config config = Bitmap.Config.ARGB_4444;
        if (i9 == 32) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap a6 = NativeBitmapFactory.a(i6, i7, config);
        this.f50036b = a6;
        if (i8 > 0) {
            this.f50042h = i8;
            a6.setDensity(i8);
        }
        Canvas canvas = this.f50035a;
        if (canvas != null) {
            canvas.setBitmap(this.f50036b);
            return;
        }
        Canvas canvas2 = new Canvas(this.f50036b);
        this.f50035a = canvas2;
        canvas2.setDensity(i8);
    }

    public void c() {
        d(this.f50036b);
        e();
    }

    @SuppressLint({"NewApi"})
    public void h(int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        g();
        int i13 = this.f50039e;
        if (i13 > 0 && (i10 = this.f50040f) > 0 && this.f50036b != null) {
            if (i13 > i8 || i10 > i9) {
                int min = Math.min(i8, i6);
                int min2 = Math.min(i9, i7);
                int i14 = this.f50039e;
                int i15 = i14 / min;
                if (i14 % min == 0) {
                    i11 = 0;
                } else {
                    i11 = 1;
                }
                int i16 = i15 + i11;
                int i17 = this.f50040f;
                int i18 = i17 / min2;
                if (i17 % min2 == 0) {
                    i12 = 0;
                } else {
                    i12 = 1;
                }
                int i19 = i18 + i12;
                int i20 = i14 / i16;
                int i21 = i17 / i19;
                Bitmap[][] bitmapArr = (Bitmap[][]) Array.newInstance((Class<?>) Bitmap.class, i19, i16);
                if (this.f50035a == null) {
                    Canvas canvas = new Canvas();
                    this.f50035a = canvas;
                    int i22 = this.f50042h;
                    if (i22 > 0) {
                        canvas.setDensity(i22);
                    }
                }
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                for (int i23 = 0; i23 < i19; i23++) {
                    for (int i24 = 0; i24 < i16; i24++) {
                        Bitmap[] bitmapArr2 = bitmapArr[i23];
                        Bitmap a6 = NativeBitmapFactory.a(i20, i21, Bitmap.Config.ARGB_8888);
                        bitmapArr2[i24] = a6;
                        int i25 = this.f50042h;
                        if (i25 > 0) {
                            a6.setDensity(i25);
                        }
                        this.f50035a.setBitmap(a6);
                        int i26 = i24 * i20;
                        int i27 = i23 * i21;
                        rect.set(i26, i27, i26 + i20, i27 + i21);
                        rect2.set(0, 0, a6.getWidth(), a6.getHeight());
                        this.f50035a.drawBitmap(this.f50036b, rect, rect2, (Paint) null);
                    }
                }
                this.f50035a.setBitmap(this.f50036b);
                this.f50037c = bitmapArr;
            }
        }
    }
}
