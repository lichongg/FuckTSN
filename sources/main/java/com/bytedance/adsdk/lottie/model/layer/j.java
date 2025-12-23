package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.kt;
import com.bytedance.adsdk.lottie.up.xt;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends ae {

    /* renamed from: g, reason: collision with root package name */
    private float f23386g;
    private final Handler jy;
    private ImageView oq;
    private Drawable qv;
    private float tl;
    private LottieAnimationView vl;
    private final Runnable ws;

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        boolean isRunning;
        if (Build.VERSION.SDK_INT < 28 || !a.a(this.qv)) {
            return;
        }
        isRunning = b.a(this.qv).isRunning();
        if (isRunning) {
            return;
        }
        b.a(this.qv).setRepeatCount(-1);
        b.a(this.qv).start();
        az();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.qv != null) {
            ViewParent parent = this.oq.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.oq);
            }
            ViewParent parent2 = this.vl.getParent();
            if (parent2 instanceof ViewGroup) {
                this.oq.setTranslationX(2.1474836E9f);
                this.oq.setImageDrawable(this.qv);
                ((ViewGroup) parent2).addView(this.oq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        this.jy.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ae, com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        if (this.tl <= 0.0f || this.oq == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        j(i6);
        float tl = tl();
        j(this.oq, (int) this.tl, (int) this.f23386g);
        this.oq.setAlpha(tl);
        canvas.clipRect(0.0f, 0.0f, this.tl, this.f23386g);
        this.oq.draw(canvas);
        canvas.restore();
    }

    public j(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2, Context context) {
        super(tlVar, tlVar2);
        String str;
        this.tl = -1.0f;
        this.f23386g = -1.0f;
        this.jy = new Handler(Looper.getMainLooper());
        this.ws = new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.j.5
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.vl != null && j.this.vl.up()) {
                    j.this.vl.invalidate();
                }
                j.this.jy.postDelayed(j.this.ws, 40L);
            }
        };
        if (((ae) this).ae != null && tlVar != null) {
            LottieAnimationView xt = tlVar.xt();
            this.vl = xt;
            if (xt != null) {
                float j6 = com.bytedance.adsdk.lottie.up.g.j();
                this.tl = (int) (((ae) this).ae.j() * j6);
                this.f23386g = (int) (((ae) this).ae.xt() * j6);
                kt ch = tlVar.ch();
                if (ch != null) {
                    str = ch.j(((ae) this).ae.vl());
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    ImageView imageView = new ImageView(context);
                    this.oq = imageView;
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.oq.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.j.1
                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewAttachedToWindow(View view) {
                            if (j.this.oq == view) {
                                j.this.av();
                            }
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewDetachedFromWindow(View view) {
                            if (j.this.oq == view) {
                                j.this.ws();
                                if (Build.VERSION.SDK_INT < 28 || !a.a(j.this.qv)) {
                                    return;
                                }
                                b.a(j.this.qv).stop();
                            }
                        }
                    });
                    this.vl.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.j.2
                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewAttachedToWindow(View view) {
                            if (j.this.vl == view) {
                                if (j.this.xt()) {
                                    j.this.vl.removeOnAttachStateChangeListener(this);
                                } else {
                                    j.this.j(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.j.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            j.this.i();
                                        }
                                    });
                                }
                            }
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewDetachedFromWindow(View view) {
                            if (j.this.vl == view) {
                                j.this.j(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.j.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ViewParent parent = j.this.oq.getParent();
                                        if (parent instanceof ViewGroup) {
                                            ((ViewGroup) parent).removeView(j.this.oq);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    j(str, context);
                }
            }
        }
    }

    private void az() {
        ws();
        if (this.vl != null) {
            this.jy.postDelayed(this.ws, 40L);
        }
    }

    private void j(String str, Context context) {
        File file = new File(com.bytedance.adsdk.lottie.up.xt.j(context), com.bytedance.sdk.component.utils.up.xt(str));
        if (file.exists()) {
            j(file);
        } else {
            com.bytedance.adsdk.lottie.up.xt.j(str, context, new xt.j<File>() { // from class: com.bytedance.adsdk.lottie.model.layer.j.3
                @Override // com.bytedance.adsdk.lottie.up.xt.j
                public void j(File file2) {
                    j.this.j(file2);
                }

                @Override // com.bytedance.adsdk.lottie.up.xt.j
                public void j(int i6, String str2) {
                    com.bytedance.sdk.component.utils.vl.j("TMe", "--==--- webp: " + i6 + ", " + str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(File file) {
        ImageDecoder.Source createSource;
        Drawable decodeDrawable;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                if (a.a(this.qv)) {
                    b.a(this.qv).stop();
                }
                createSource = ImageDecoder.createSource(file);
                decodeDrawable = ImageDecoder.decodeDrawable(createSource);
                this.qv = decodeDrawable;
                this.jy.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.j.4
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.i();
                    }
                });
            } catch (IOException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    private static void j(View view, int i6, int i7) {
        view.layout(0, 0, i6, i7);
        view.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
