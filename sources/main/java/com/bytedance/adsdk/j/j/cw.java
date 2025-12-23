package com.bytedance.adsdk.j.j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.j.j.j.g;
import com.bytedance.sdk.component.utils.vl;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class cw<Decoder extends g<?, ?>> extends Drawable implements g.j, xt {

    /* renamed from: j, reason: collision with root package name */
    private static final String f23128j = "cw";
    private Bitmap ae;
    private final Decoder cw;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f23129g;

    /* renamed from: m, reason: collision with root package name */
    private final Set<Object> f23130m;
    private boolean oq;
    private final Set<WeakReference<Drawable.Callback>> qv;

    /* renamed from: r, reason: collision with root package name */
    private final DrawFilter f23131r;
    private final Handler tl;
    private final Matrix up;
    private boolean vl;
    private final Paint xt;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    protected abstract Decoder xt(com.bytedance.adsdk.j.j.cw.xt xtVar, g.j jVar);

    @Override // com.bytedance.adsdk.j.j.j.g.j
    public void xt(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.ae;
            if (bitmap == null || bitmap.isRecycled()) {
                this.ae = Bitmap.createBitmap(this.cw.m().width() / this.cw.vl(), this.cw.m().height() / this.cw.vl(), Bitmap.Config.ARGB_4444);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.ae.getByteCount()) {
                vl.r(f23128j, "onRender:Buffer not large enough for pixels");
            } else {
                this.ae.copyPixelsFromBuffer(byteBuffer);
                this.tl.post(this.f23129g);
            }
        }
    }

    private void cw() {
        this.cw.j(this);
        if (this.oq) {
            this.cw.tl();
        } else {
            if (this.cw.oq()) {
                return;
            }
            this.cw.tl();
        }
    }

    private void r() {
        this.cw.xt(this);
        if (this.oq) {
            this.cw.g();
        } else {
            this.cw.up();
        }
    }

    private void up() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z5 = false;
        for (WeakReference weakReference : new HashSet(this.qv)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z5 = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.qv.remove((WeakReference) it.next());
        }
        if (z5) {
            return;
        }
        this.qv.add(new WeakReference<>(callback));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.ae;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.f23131r);
        canvas.drawBitmap(this.ae, this.up, this.xt);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.vl) {
            return -1;
        }
        try {
            return this.cw.m().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.vl) {
            return -1;
        }
        try {
            return this.cw.m().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.cw.oq();
    }

    @Override // com.bytedance.adsdk.j.j.j.g.j
    public void j() {
        Message.obtain(this.tl, 1).sendToTarget();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.xt.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.xt.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.cw.oq()) {
            this.cw.g();
        }
        this.cw.qv();
        cw();
    }

    public cw(com.bytedance.adsdk.j.j.cw.xt xtVar) {
        Paint paint = new Paint();
        this.xt = paint;
        this.f23131r = new PaintFlagsDrawFilter(0, 3);
        this.up = new Matrix();
        this.f23130m = new HashSet();
        this.tl = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.adsdk.j.j.cw.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i6 = message.what;
                if (i6 == 1) {
                    Iterator it = new ArrayList(cw.this.f23130m).iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } else {
                    if (i6 != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(cw.this.f23130m).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
            }
        };
        this.f23129g = new Runnable() { // from class: com.bytedance.adsdk.j.j.cw.2
            @Override // java.lang.Runnable
            public void run() {
                cw.this.invalidateSelf();
            }
        };
        this.oq = true;
        this.qv = new HashSet();
        this.vl = false;
        paint.setAntiAlias(true);
        this.cw = xt(xtVar, this);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.qv).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i6, int i7, int i8, int i9) {
        super.setBounds(i6, i7, i8, i9);
        boolean xt = this.cw.xt(getBounds().width(), getBounds().height());
        this.up.setScale(((getBounds().width() * 1.0f) * this.cw.vl()) / this.cw.m().width(), ((getBounds().height() * 1.0f) * this.cw.vl()) / this.cw.m().height());
        if (xt) {
            this.ae = Bitmap.createBitmap(this.cw.m().width() / this.cw.vl(), this.cw.m().height() / this.cw.vl(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        up();
        if (this.oq) {
            if (z5) {
                if (!isRunning()) {
                    cw();
                }
            } else if (isRunning()) {
                r();
            }
        }
        return super.setVisible(z5, z6);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        r();
    }

    @Override // com.bytedance.adsdk.j.j.j.g.j
    public void xt() {
        Message.obtain(this.tl, 2).sendToTarget();
    }
}
