package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.adexpress.r.xt;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.oq;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.m.tl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ImageFlipSlide extends View {
    private final Rect ae;
    private Bitmap cw;

    /* renamed from: j, reason: collision with root package name */
    Paint f25933j;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f25934m;

    /* renamed from: r, reason: collision with root package name */
    private List<String> f25935r;
    private final boolean tl;
    private Path up;
    private float xt;

    /* JADX INFO: Access modifiers changed from: private */
    public int getBlurPx() {
        if (this.f25935r == null) {
            return 0;
        }
        for (int i6 = 0; i6 < this.f25935r.size(); i6++) {
            if (this.f25935r.get(i6).contains("blur")) {
                return Integer.parseInt(this.f25935r.get(i6).split("\\(")[1].split("px")[0]);
            }
        }
        return 0;
    }

    public ImageFlipSlide(Context context, boolean z5) {
        super(context);
        this.xt = 0.1f;
        this.f25934m = new Rect();
        this.ae = new Rect();
        this.tl = z5;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cw == null) {
            return;
        }
        if (this.tl) {
            this.f25934m.left = (int) (r0.getWidth() * (1.0f - this.xt));
            this.f25934m.right = this.cw.getWidth();
            Rect rect = this.f25934m;
            rect.top = 0;
            rect.bottom = this.cw.getHeight();
            this.ae.left = (int) (getWidth() * (1.0f - this.xt));
            this.ae.right = getWidth();
            Rect rect2 = this.ae;
            rect2.top = 0;
            rect2.bottom = getHeight();
            canvas.drawBitmap(this.cw, this.f25934m, this.ae, this.f25933j);
            return;
        }
        canvas.clipPath(this.up);
        canvas.drawBitmap(this.cw, 0.0f, 0.0f, this.f25933j);
    }

    public void j(String str, String str2, List<String> list) {
        final oq xt = com.bytedance.sdk.component.adexpress.j.j.j.j().up().j(str).xt(str2);
        this.f25935r = list;
        xt.j(Bitmap.Config.ARGB_4444).cw(2);
        if (getBlurPx() != 0) {
            xt.j(new tl() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.1
                @Override // com.bytedance.sdk.component.m.tl
                @ATSMethod(1)
                public Bitmap j(Bitmap bitmap) {
                    try {
                        return xt.j(ImageFlipSlide.this.getContext(), bitmap, ImageFlipSlide.this.getBlurPx());
                    } catch (Exception unused) {
                        return bitmap;
                    }
                }
            });
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2
            @Override // java.lang.Runnable
            public void run() {
                xt.j(new av<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2.1
                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(2)
                    public void j(int i6, String str3, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(1)
                    public void j(qv<Bitmap> qvVar) {
                        try {
                            ImageFlipSlide imageFlipSlide = ImageFlipSlide.this;
                            imageFlipSlide.cw = imageFlipSlide.j(qvVar.cw(), ImageFlipSlide.this.getWidth(), ImageFlipSlide.this.getHeight());
                        } catch (Exception unused) {
                        }
                        ImageFlipSlide.this.invalidate();
                    }
                });
            }
        });
        Paint paint = new Paint();
        this.f25933j = paint;
        paint.setAntiAlias(true);
        this.f25933j.setDither(true);
        if (this.tl) {
            this.f25933j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        List<String> list2 = this.f25935r;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        for (int i6 = 0; i6 < this.f25935r.size(); i6++) {
            j(colorMatrix, this.f25935r.get(i6));
        }
        this.f25933j.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    private void j(ColorMatrix colorMatrix, String str) {
        try {
            ColorMatrix colorMatrix2 = new ColorMatrix();
            if (str.startsWith("hue-rotate")) {
                colorMatrix2.setRotate(0, Integer.parseInt(str.split("\\(")[1].split("deg")[0]));
            } else {
                if (!str.startsWith("grayscale") && !str.startsWith("contrast")) {
                    if (str.startsWith("invert")) {
                        float parseInt = (Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f) * 255.0f;
                        colorMatrix2.set(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, parseInt, 0.0f, -1.0f, 0.0f, 0.0f, parseInt, 0.0f, 0.0f, -1.0f, 0.0f, parseInt, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                    } else if (str.startsWith("sepia")) {
                        float parseInt2 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                        colorMatrix2.setScale(parseInt2, parseInt2, 1.0f, 1.0f);
                    } else if (str.startsWith("brightness")) {
                        float parseInt3 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                        colorMatrix2.setScale(parseInt3, parseInt3, parseInt3, 1.0f);
                    }
                }
                colorMatrix2.setSaturation(Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f);
            }
            colorMatrix.postConcat(colorMatrix2);
        } catch (Exception unused) {
        }
    }

    public void j(float f6) {
        this.xt = f6;
        invalidate();
    }

    public void j(Path path) {
        this.up = path;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap j(Bitmap bitmap, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f6 = i6;
        float f7 = (width * 1.0f) / f6;
        float f8 = i7;
        float f9 = (height * 1.0f) / f8;
        Matrix matrix = new Matrix();
        if (f9 > f7) {
            int i12 = (int) (f8 * f7);
            float f10 = 1.0f / f7;
            matrix.setScale(f10, f10);
            i10 = i12;
            i8 = width;
            i11 = (height / 2) - (i12 / 2);
            i9 = 0;
        } else {
            int i13 = (int) (f6 * f9);
            float f11 = 1.0f / f9;
            matrix.setScale(f11, f11);
            i8 = i13;
            i9 = (width / 2) - (i13 / 2);
            i10 = height;
            i11 = 0;
        }
        return Bitmap.createBitmap(bitmap, i9, i11, i8, i10, matrix, false);
    }
}
