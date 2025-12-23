package com.bytedance.sdk.component.adexpress.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.model.layer.b;
import com.bytedance.sdk.component.adexpress.r.up;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.vl;
import java.io.File;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class GifView extends ImageView {
    private boolean ae;
    private boolean az;
    private long cw;

    /* renamed from: g, reason: collision with root package name */
    private float f25918g;

    /* renamed from: j, reason: collision with root package name */
    private int f25919j;
    private volatile boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private boolean f25920m;
    private float oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private int f25921r;
    private float tl;
    private AnimatedImageDrawable up;
    private int vl;
    private boolean ws;
    private Movie xt;

    interface j {
        void j(Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r2 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.ImageDecoder.Source xt(byte[] r6) {
        /*
            r5 = this;
            r0 = 0
            com.bytedance.sdk.component.adexpress.j.j.j r1 = com.bytedance.sdk.component.adexpress.j.j.j.j()     // Catch: java.lang.Throwable -> L16
            com.bytedance.sdk.component.adexpress.j.j.cw r1 = r1.cw()     // Catch: java.lang.Throwable -> L16
            boolean r1 = r1.vl()     // Catch: java.lang.Throwable -> L16
            android.content.Context r2 = r5.getContext()     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L19
            java.lang.String r1 = "GIF_AD_CACHE/"
            goto L1b
        L16:
            r6 = move-exception
            r2 = r0
            goto L3f
        L19:
            java.lang.String r1 = "/GIF_CACHE/"
        L1b:
            java.lang.String r3 = "TT_GIF_FILE"
            java.io.File r1 = j(r2, r1, r3)     // Catch: java.lang.Throwable -> L16
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L16
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L16
            int r3 = r6.length     // Catch: java.lang.Throwable -> L39
            r4 = 0
            r2.write(r6, r4, r3)     // Catch: java.lang.Throwable -> L39
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L39
            r3 = 28
            if (r6 < r3) goto L3b
            android.graphics.ImageDecoder$Source r6 = com.bytedance.adsdk.lottie.model.layer.h.a(r1)     // Catch: java.lang.Throwable -> L39
            r2.close()     // Catch: java.lang.Throwable -> L38
        L38:
            return r6
        L39:
            r6 = move-exception
            goto L3f
        L3b:
            r2.close()     // Catch: java.lang.Throwable -> L49
            goto L49
        L3f:
            java.lang.String r1 = "GifView"
            java.lang.String r3 = "GifView  getSourceByFile fail : "
            com.bytedance.sdk.component.utils.vl.cw(r1, r3, r6)     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L49
            goto L3b
        L49:
            return r0
        L4a:
            r6 = move-exception
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.lang.Throwable -> L50
        L50:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.widget.GifView.xt(byte[]):android.graphics.ImageDecoder$Source");
    }

    private void cw() {
        if (this.xt == null || this.f25920m || !this.ws) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void r() {
        if (this.xt == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.cw == 0) {
            this.cw = uptimeMillis;
        }
        int duration = this.xt.duration();
        if (duration == 0) {
            duration = 1000;
        }
        if (this.az || Math.abs(duration - this.f25921r) >= 60) {
            this.f25921r = (int) ((uptimeMillis - this.cw) % duration);
        } else {
            this.f25921r = duration;
            this.jy = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && com.bytedance.adsdk.lottie.model.layer.a.a(drawable)) {
            AnimatedImageDrawable a6 = b.a(drawable);
            this.up = a6;
            if (!this.jy) {
                a6.start();
            }
            if (!this.az) {
                a6.setRepeatCount(0);
            }
        }
        cw();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.xt == null || this.f25920m) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.jy) {
                j(canvas);
                return;
            }
            r();
            j(canvas);
            cw();
        } catch (Throwable th) {
            vl.cw("GifView", "onDraw->Throwable->", th);
        }
    }

    public void setRepeatConfig(boolean z5) {
        AnimatedImageDrawable animatedImageDrawable;
        this.az = z5;
        if (z5) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.up) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e6) {
            vl.cw("GifView", "setRepeatConfig error", e6);
        }
    }

    public GifView(Context context) {
        super(context);
        boolean z5;
        if (Build.VERSION.SDK_INT >= 28) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f25920m = z5;
        this.ae = false;
        this.ws = true;
        this.az = true;
        j();
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        boolean z6;
        super.onLayout(z5, i6, i7, i8, i9);
        if (this.xt != null && !this.f25920m) {
            this.tl = (getWidth() - this.qv) / 2.0f;
            this.f25918g = (getHeight() - this.vl) / 2.0f;
        }
        if (getVisibility() == 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.ws = z6;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i6, int i7) {
        Movie movie;
        float f6;
        float f7;
        int size;
        int size2;
        super.onMeasure(i6, i7);
        if (!this.f25920m && (movie = this.xt) != null) {
            int width = movie.width();
            int height = this.xt.height();
            if (View.MeasureSpec.getMode(i6) != 0 && width > (size2 = View.MeasureSpec.getSize(i6))) {
                f6 = width / size2;
            } else {
                f6 = 1.0f;
            }
            if (View.MeasureSpec.getMode(i7) != 0 && height > (size = View.MeasureSpec.getSize(i7))) {
                f7 = height / size;
            } else {
                f7 = 1.0f;
            }
            float max = 1.0f / Math.max(f6, f7);
            this.oq = max;
            int i8 = (int) (width * max);
            this.qv = i8;
            int i9 = (int) (height * max);
            this.vl = i9;
            setMeasuredDimension(i8, i9);
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i6) {
        super.onScreenStateChanged(i6);
        if (this.xt != null) {
            boolean z5 = true;
            if (i6 != 1) {
                z5 = false;
            }
            this.ws = z5;
            cw();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i6) {
        boolean z5;
        super.onVisibilityChanged(view, i6);
        if (this.xt != null) {
            if (i6 == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.ws = z5;
            cw();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        boolean z5;
        super.onWindowVisibilityChanged(i6);
        if (this.xt != null) {
            if (i6 == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.ws = z5;
            cw();
        }
    }

    void j() {
        if (this.f25920m) {
            return;
        }
        setLayerType(1, null);
    }

    public void j(int i6, boolean z5) {
        this.jy = z5;
        this.f25919j = i6;
        if (i6 == -1) {
            return;
        }
        if (!this.f25920m) {
            this.xt = j(i6);
        } else {
            j(i6, new j() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.j
                public void j(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source xt(int i6) {
        ImageDecoder.Source createSource;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        createSource = ImageDecoder.createSource(kt.j(getContext()), i6);
        return createSource;
    }

    public void j(byte[] bArr, boolean z5) {
        this.jy = z5;
        if (bArr == null) {
            return;
        }
        if (!this.f25920m) {
            this.xt = j(bArr);
        } else {
            j(bArr, new j() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.j
                public void j(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    public void xt() {
        boolean isRunning;
        if (this.xt == null || !this.jy) {
            return;
        }
        this.jy = false;
        if (!this.f25920m) {
            this.cw = SystemClock.uptimeMillis() - this.f25921r;
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.up;
        if (animatedImageDrawable != null) {
            isRunning = animatedImageDrawable.isRunning();
            if (isRunning) {
                return;
            }
            this.up.start();
        }
    }

    private Movie j(int i6) {
        try {
            return Movie.decodeStream(kt.j(getContext()).openRawResource(i6));
        } catch (Throwable unused) {
            return null;
        }
    }

    private Movie j(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void j(final int i6, final j jVar) {
        if (i6 == -1) {
            return;
        }
        up.j(new g("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.3
            @Override // java.lang.Runnable
            public void run() {
                j jVar2 = jVar;
                if (jVar2 != null) {
                    GifView gifView = GifView.this;
                    jVar2.j(gifView.j(gifView.xt(i6)));
                }
            }
        }, 5);
    }

    private void j(final byte[] bArr, final j jVar) {
        if (bArr == null) {
            return;
        }
        up.j(new g("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.4
            @Override // java.lang.Runnable
            public void run() {
                j jVar2 = jVar;
                if (jVar2 != null) {
                    GifView gifView = GifView.this;
                    jVar2.j(gifView.j(gifView.xt(bArr)));
                }
            }
        }, 5);
    }

    public static File j(Context context, String str, String str2) {
        int qv = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().qv();
        boolean vl = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().vl();
        if (qv == 1) {
            vl.r("splashLoadAd", "视频存储使用内部存储");
            return m.xt(context, vl, str, str2);
        }
        vl.r("splashLoadAd", "视频存储使用外存储");
        return m.j(context, vl, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable j(ImageDecoder.Source source) {
        Drawable decodeDrawable;
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            decodeDrawable = ImageDecoder.decodeDrawable(source);
            return decodeDrawable;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void j(Canvas canvas) {
        Movie movie = this.xt;
        if (movie == null) {
            return;
        }
        movie.setTime(this.f25921r);
        float f6 = this.oq;
        if (f6 == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.xt.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f6, f6);
            Movie movie2 = this.xt;
            float f7 = this.tl;
            float f8 = this.oq;
            movie2.draw(canvas, f7 / f8, this.f25918g / f8);
        }
        canvas.restore();
    }
}
