package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.TextureView;
import android.view.View;
import com.bytedance.adsdk.lottie.g;

/* loaded from: D:\Downloads\app\classes3.dex */
public class VideoFrame extends View {
    private Bitmap ae;
    private final g.j.C0314j cw;

    /* renamed from: j, reason: collision with root package name */
    private final TextureView f23366j;

    /* renamed from: m, reason: collision with root package name */
    private long f23367m;

    /* renamed from: r, reason: collision with root package name */
    private RenderScript f23368r;
    private int tl;
    private ScriptIntrinsicBlur up;
    private final Matrix xt;

    public Bitmap j(Bitmap bitmap, float f6) {
        Bitmap bitmap2;
        try {
            RenderScript renderScript = this.f23368r;
            if (renderScript != null && this.up != null) {
                Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation createTyped = Allocation.createTyped(this.f23368r, createFromBitmap.getType());
                this.up.setRadius(f6);
                this.up.setInput(createFromBitmap);
                this.up.forEach(createTyped);
                bitmap2 = Bitmap.createBitmap(bitmap);
                try {
                    createTyped.copyTo(bitmap2);
                    createTyped.destroy();
                    createFromBitmap.destroy();
                    return bitmap2;
                } catch (Throwable th) {
                    th = th;
                    com.bytedance.sdk.component.utils.vl.j(th);
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bitmap2 = null;
        }
    }

    public VideoFrame(Context context, TextureView textureView, g.j.C0314j c0314j) {
        super(context);
        this.f23367m = -1L;
        this.ae = null;
        this.tl = 0;
        this.f23366j = textureView;
        this.xt = new Matrix();
        this.cw = c0314j;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RenderScript renderScript = this.f23368r;
        if (renderScript != null) {
            renderScript.destroy();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.up;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript create = RenderScript.create(getContext());
        this.f23368r = create;
        this.up = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.ae;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.ae.recycle();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.up;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.up = null;
        }
        RenderScript renderScript = this.f23368r;
        if (renderScript != null) {
            renderScript.destroy();
            this.f23368r = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.f23367m >= 40) {
            this.f23367m = elapsedRealtime;
            TextureView textureView = this.f23366j;
            if (textureView != null && textureView.isAvailable()) {
                float width = this.f23366j.getWidth() / 160.0f;
                if (width > 0.0f) {
                    this.tl = (int) (this.f23366j.getHeight() / width);
                }
                int i6 = this.tl;
                if (i6 > 0 && (bitmap2 = this.f23366j.getBitmap(160, i6)) != null) {
                    Bitmap bitmap3 = this.ae;
                    if (bitmap3 != null && !bitmap3.isRecycled()) {
                        this.ae.recycle();
                    }
                    this.ae = j(bitmap2, this.cw.f23230j);
                    bitmap2.recycle();
                }
            }
        }
        if (this.tl > 0 && (bitmap = this.ae) != null && !bitmap.isRecycled()) {
            canvas.save();
            this.xt.reset();
            this.xt.setScale(getWidth() / 160.0f, getHeight() / this.tl);
            canvas.concat(this.xt);
            canvas.drawBitmap(this.ae, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }
}
