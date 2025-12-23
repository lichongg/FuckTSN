package com.bxkj.student.common.crop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bxkj.student.R;
import com.bxkj.student.common.crop.view.ClipView;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ClipViewLayout extends RelativeLayout {

    /* renamed from: n, reason: collision with root package name */
    private static final int f17717n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static final int f17718o = 1;

    /* renamed from: p, reason: collision with root package name */
    private static final int f17719p = 2;

    /* renamed from: a, reason: collision with root package name */
    private ImageView f17720a;

    /* renamed from: b, reason: collision with root package name */
    private ClipView f17721b;

    /* renamed from: c, reason: collision with root package name */
    private float f17722c;

    /* renamed from: d, reason: collision with root package name */
    private float f17723d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f17724e;

    /* renamed from: f, reason: collision with root package name */
    private Matrix f17725f;

    /* renamed from: g, reason: collision with root package name */
    private int f17726g;

    /* renamed from: h, reason: collision with root package name */
    private PointF f17727h;

    /* renamed from: i, reason: collision with root package name */
    private PointF f17728i;

    /* renamed from: j, reason: collision with root package name */
    private float f17729j;

    /* renamed from: k, reason: collision with root package name */
    private final float[] f17730k;

    /* renamed from: l, reason: collision with root package name */
    private float f17731l;

    /* renamed from: m, reason: collision with root package name */
    private float f17732m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f17733a;

        a(final Uri val$uri) {
            this.f17733a = val$uri;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ClipViewLayout.this.i(this.f17733a);
            ClipViewLayout.this.f17720a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public ClipViewLayout(Context context) {
        this(context, null);
    }

    private void j(PointF point, MotionEvent event) {
        point.set((event.getX(0) + event.getX(1)) / 2.0f, (event.getY(0) + event.getY(1)) / 2.0f);
    }

    private float k(MotionEvent event) {
        float x5 = event.getX(0) - event.getX(1);
        float y5 = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((x5 * x5) + (y5 * y5));
    }

    public ClipViewLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public static int b(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i6 = options.outHeight;
        int i7 = options.outWidth;
        if (i6 <= reqHeight && i7 <= reqWidth) {
            return 1;
        }
        int round = Math.round(i6 / reqHeight);
        int round2 = Math.round(i7 / reqWidth);
        if (round >= round2) {
            round = round2;
        }
        if (round >= 3) {
            if (round < 6.5d) {
                return 4;
            }
            if (round < 8) {
                return 8;
            }
        }
        return round;
    }

    private void c() {
        float f6;
        RectF g6 = g(this.f17724e);
        int width = this.f17720a.getWidth();
        int height = this.f17720a.getHeight();
        float width2 = g6.width();
        float f7 = width;
        float f8 = this.f17722c;
        if (width2 >= f7 - (f8 * 2.0f)) {
            float f9 = g6.left;
            f6 = f9 > f8 ? (-f9) + f8 : 0.0f;
            float f10 = g6.right;
            if (f10 < f7 - f8) {
                f6 = (f7 - f8) - f10;
            }
        } else {
            f6 = 0.0f;
        }
        float height2 = g6.height();
        float f11 = height;
        float f12 = this.f17723d;
        if (height2 >= f11 - (2.0f * f12)) {
            float f13 = g6.top;
            r7 = f13 > f12 ? (-f13) + f12 : 0.0f;
            float f14 = g6.bottom;
            if (f14 < f11 - f12) {
                r7 = (f11 - f12) - f14;
            }
        }
        this.f17724e.postTranslate(f6, r7);
    }

    public static Bitmap e(String filePath, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = b(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    public static int f(String filepath) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(filepath);
        } catch (IOException e6) {
            e6.printStackTrace();
            exifInterface = null;
        }
        if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) != -1) {
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt == 8) {
                return 270;
            }
        }
        return 0;
    }

    private RectF g(Matrix matrix) {
        RectF rectF = new RectF();
        if (this.f17720a.getDrawable() != null) {
            rectF.set(0.0f, 0.0f, r1.getIntrinsicWidth(), r1.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap d() {
        /*
            r6 = this;
            android.widget.ImageView r0 = r6.f17720a
            r1 = 1
            r0.setDrawingCacheEnabled(r1)
            android.widget.ImageView r0 = r6.f17720a
            r0.buildDrawingCache()
            com.bxkj.student.common.crop.view.ClipView r0 = r6.f17721b
            android.graphics.Rect r0 = r0.getClipRect()
            r1 = 0
            android.widget.ImageView r2 = r6.f17720a     // Catch: java.lang.Exception -> L33
            android.graphics.Bitmap r2 = r2.getDrawingCache()     // Catch: java.lang.Exception -> L33
            int r3 = r0.left     // Catch: java.lang.Exception -> L33
            int r4 = r0.top     // Catch: java.lang.Exception -> L33
            int r5 = r0.width()     // Catch: java.lang.Exception -> L33
            int r0 = r0.height()     // Catch: java.lang.Exception -> L33
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r0)     // Catch: java.lang.Exception -> L33
            r2 = 295(0x127, float:4.13E-43)
            r3 = 413(0x19d, float:5.79E-43)
            android.graphics.Bitmap r1 = l(r0, r2, r3)     // Catch: java.lang.Exception -> L31
            goto L38
        L31:
            r2 = move-exception
            goto L35
        L33:
            r2 = move-exception
            r0 = r1
        L35:
            r2.printStackTrace()
        L38:
            if (r0 == 0) goto L3d
            r0.recycle()
        L3d:
            android.widget.ImageView r0 = r6.f17720a
            r0.destroyDrawingCache()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.crop.view.ClipViewLayout.d():android.graphics.Bitmap");
    }

    public final float getScale() {
        this.f17724e.getValues(this.f17730k);
        return this.f17730k[0];
    }

    public void h(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ClipViewLayout);
        this.f17722c = obtainStyledAttributes.getDimensionPixelSize(2, (int) TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics()));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        int i6 = obtainStyledAttributes.getInt(1, 1);
        obtainStyledAttributes.recycle();
        ClipView clipView = new ClipView(context);
        this.f17721b = clipView;
        clipView.setClipType(i6 == 1 ? ClipView.ClipType.CIRCLE : ClipView.ClipType.RECTANGLE);
        this.f17721b.setClipBorderWidth(dimensionPixelSize);
        this.f17721b.setmHorizontalPadding(this.f17722c);
        this.f17720a = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.f17720a, layoutParams);
        addView(this.f17721b, layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0068, code lost:
    
        if (r0 < r1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008f, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008d, code lost:
    
        if (r0 < r1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i(android.net.Uri r10) {
        /*
            r9 = this;
            if (r10 != 0) goto L3
            goto L1f
        L3:
            r10.toString()
            android.content.Context r0 = r9.getContext()
            java.lang.String r10 = com.bxkj.base.util.j.c(r0, r10)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L15
            goto L1f
        L15:
            r0 = 720(0x2d0, float:1.009E-42)
            r1 = 1280(0x500, float:1.794E-42)
            android.graphics.Bitmap r2 = e(r10, r0, r1)
            if (r2 != 0) goto L20
        L1f:
            return
        L20:
            int r10 = f(r10)
            android.graphics.Matrix r7 = new android.graphics.Matrix
            r7.<init>()
            float r10 = (float) r10
            r7.setRotate(r10)
            int r5 = r2.getWidth()
            int r6 = r2.getHeight()
            r8 = 1
            r3 = 0
            r4 = 0
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)
            int r0 = r10.getWidth()
            int r1 = r10.getHeight()
            if (r0 < r1) goto L6b
            android.widget.ImageView r0 = r9.f17720a
            int r0 = r0.getWidth()
            float r0 = (float) r0
            int r1 = r10.getWidth()
            float r1 = (float) r1
            float r0 = r0 / r1
            com.bxkj.student.common.crop.view.ClipView r1 = r9.f17721b
            android.graphics.Rect r1 = r1.getClipRect()
            int r1 = r1.height()
            float r1 = (float) r1
            int r2 = r10.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            r9.f17731l = r1
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 >= 0) goto L90
            goto L8f
        L6b:
            android.widget.ImageView r0 = r9.f17720a
            int r0 = r0.getHeight()
            float r0 = (float) r0
            int r1 = r10.getHeight()
            float r1 = (float) r1
            float r0 = r0 / r1
            com.bxkj.student.common.crop.view.ClipView r1 = r9.f17721b
            android.graphics.Rect r1 = r1.getClipRect()
            int r1 = r1.width()
            float r1 = (float) r1
            int r2 = r10.getWidth()
            float r2 = (float) r2
            float r1 = r1 / r2
            r9.f17731l = r1
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 >= 0) goto L90
        L8f:
            r0 = r1
        L90:
            android.graphics.Matrix r1 = r9.f17724e
            r1.postScale(r0, r0)
            android.widget.ImageView r1 = r9.f17720a
            int r1 = r1.getWidth()
            int r1 = r1 / 2
            android.widget.ImageView r2 = r9.f17720a
            int r2 = r2.getHeight()
            int r2 = r2 / 2
            int r3 = r10.getWidth()
            float r3 = (float) r3
            float r3 = r3 * r0
            r4 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 / r4
            int r3 = (int) r3
            int r5 = r10.getHeight()
            float r5 = (float) r5
            float r5 = r5 * r0
            float r5 = r5 / r4
            int r0 = (int) r5
            android.graphics.Matrix r4 = r9.f17724e
            int r1 = r1 - r3
            float r1 = (float) r1
            int r2 = r2 - r0
            float r0 = (float) r2
            r4.postTranslate(r1, r0)
            android.widget.ImageView r0 = r9.f17720a
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX
            r0.setScaleType(r1)
            android.widget.ImageView r0 = r9.f17720a
            android.graphics.Matrix r1 = r9.f17724e
            r0.setImageMatrix(r1)
            android.widget.ImageView r0 = r9.f17720a
            r0.setImageBitmap(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.crop.view.ClipViewLayout.i(android.net.Uri):void");
    }

    public void setImageSrc(final Uri uri) {
        this.f17720a.getViewTreeObserver().addOnGlobalLayoutListener(new a(uri));
    }

    public ClipViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f17724e = new Matrix();
        this.f17725f = new Matrix();
        this.f17726g = 0;
        this.f17727h = new PointF();
        this.f17728i = new PointF();
        this.f17729j = 1.0f;
        this.f17730k = new float[9];
        this.f17732m = 4.0f;
        h(context, attrs);
    }

    public static Bitmap l(Bitmap bitmap, int w5, int h6) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(w5 / width, h6 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction() & 255;
        if (action != 0) {
            if (action != 2) {
                if (action != 5) {
                    if (action == 6) {
                        this.f17726g = 0;
                    }
                } else {
                    float k6 = k(event);
                    this.f17729j = k6;
                    if (k6 > 10.0f) {
                        this.f17725f.set(this.f17724e);
                        j(this.f17728i, event);
                        this.f17726g = 2;
                    }
                }
            } else {
                int i6 = this.f17726g;
                if (i6 == 1) {
                    this.f17724e.set(this.f17725f);
                    float x5 = event.getX() - this.f17727h.x;
                    float y5 = event.getY() - this.f17727h.y;
                    this.f17723d = this.f17721b.getClipRect().top;
                    this.f17724e.postTranslate(x5, y5);
                    c();
                } else if (i6 == 2) {
                    float k7 = k(event);
                    if (k7 > 10.0f) {
                        float f6 = k7 / this.f17729j;
                        if (f6 < 1.0f) {
                            if (getScale() > this.f17731l) {
                                this.f17724e.set(this.f17725f);
                                this.f17723d = this.f17721b.getClipRect().top;
                                Matrix matrix = this.f17724e;
                                PointF pointF = this.f17728i;
                                matrix.postScale(f6, f6, pointF.x, pointF.y);
                                while (getScale() < this.f17731l) {
                                    Matrix matrix2 = this.f17724e;
                                    PointF pointF2 = this.f17728i;
                                    matrix2.postScale(1.01f, 1.01f, pointF2.x, pointF2.y);
                                }
                            }
                            c();
                        } else if (getScale() <= this.f17732m) {
                            this.f17724e.set(this.f17725f);
                            this.f17723d = this.f17721b.getClipRect().top;
                            Matrix matrix3 = this.f17724e;
                            PointF pointF3 = this.f17728i;
                            matrix3.postScale(f6, f6, pointF3.x, pointF3.y);
                        }
                    }
                }
                this.f17720a.setImageMatrix(this.f17724e);
            }
        } else {
            this.f17725f.set(this.f17724e);
            this.f17727h.set(event.getX(), event.getY());
            this.f17726g = 1;
        }
        return true;
    }
}
