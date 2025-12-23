package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.resource.gif.f;
import com.bumptech.glide.util.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class GifDrawable extends Drawable implements f.b, Animatable, Animatable2Compat {

    /* renamed from: l, reason: collision with root package name */
    public static final int f15698l = -1;

    /* renamed from: m, reason: collision with root package name */
    public static final int f15699m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static final int f15700n = 119;

    /* renamed from: a, reason: collision with root package name */
    private final a f15701a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f15702b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f15703c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f15704d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f15705e;

    /* renamed from: f, reason: collision with root package name */
    private int f15706f;

    /* renamed from: g, reason: collision with root package name */
    private int f15707g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f15708h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f15709i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f15710j;

    /* renamed from: k, reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f15711k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        final f f15712a;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        a(f fVar) {
            this.f15712a = fVar;
        }
    }

    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.i<Bitmap> iVar, int i6, int i7, Bitmap bitmap) {
        this(context, gifDecoder, iVar, i6, i7, bitmap);
    }

    private void n() {
        this.f15706f = 0;
    }

    private void t() {
        this.f15702b = false;
        this.f15701a.f15712a.w(this);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public void m() {
        this.f15704d = true;
        this.f15701a.f15712a.a();
    }

    public void q(int i6) {
        if (i6 <= 0 && i6 != -1 && i6 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i6 != 0) {
            this.f15707g = i6;
        } else {
            int j6 = this.f15701a.f15712a.j();
            this.f15707g = j6 != 0 ? j6 : -1;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f15703c = true;
        n();
        if (this.f15705e) {
            s();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f15703c = false;
        t();
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, com.bumptech.glide.load.i<Bitmap> iVar, int i6, int i7, Bitmap bitmap) {
        this(new a(new f(com.bumptech.glide.b.e(context), gifDecoder, i6, i7, iVar, bitmap)));
    }

    private Rect d() {
        if (this.f15710j == null) {
            this.f15710j = new Rect();
        }
        return this.f15710j;
    }

    private Paint i() {
        if (this.f15709i == null) {
            this.f15709i = new Paint(2);
        }
        return this.f15709i;
    }

    private void l() {
        List<Animatable2Compat.AnimationCallback> list = this.f15711k;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.f15711k.get(i6).onAnimationEnd(this);
            }
        }
    }

    private void s() {
        k.a(!this.f15704d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f15701a.f15712a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f15702b) {
                return;
            }
            this.f15702b = true;
            this.f15701a.f15712a.v(this);
            invalidateSelf();
        }
    }

    public ByteBuffer c() {
        return this.f15701a.f15712a.b();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f15711k;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f15704d) {
            return;
        }
        if (this.f15708h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f15708h = false;
        }
        canvas.drawBitmap(this.f15701a.f15712a.c(), (Rect) null, d(), i());
    }

    public Bitmap e() {
        return this.f15701a.f15712a.e();
    }

    public int f() {
        return this.f15701a.f15712a.f();
    }

    public int g() {
        return this.f15701a.f15712a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f15701a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f15701a.f15712a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f15701a.f15712a.m();
    }

    public com.bumptech.glide.load.i<Bitmap> h() {
        return this.f15701a.f15712a.h();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f15702b;
    }

    public int j() {
        return this.f15701a.f15712a.l();
    }

    boolean k() {
        return this.f15704d;
    }

    public void o(com.bumptech.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this.f15701a.f15712a.q(iVar, bitmap);
    }

    void p(boolean z5) {
        this.f15702b = z5;
    }

    public void r() {
        k.a(!this.f15702b, "You cannot restart a currently running animation.");
        this.f15701a.f15712a.r();
        start();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f15711k == null) {
            this.f15711k = new ArrayList();
        }
        this.f15711k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        k.a(!this.f15704d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f15705e = z5;
        if (!z5) {
            t();
        } else if (this.f15703c) {
            s();
        }
        return super.setVisible(z5, z6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f15711k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    @Override // com.bumptech.glide.load.resource.gif.f.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f15706f++;
        }
        int i6 = this.f15707g;
        if (i6 != -1 && this.f15706f >= i6) {
            l();
            stop();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f15708h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        i().setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        i().setColorFilter(colorFilter);
    }

    GifDrawable(a aVar) {
        this.f15705e = true;
        this.f15707g = -1;
        this.f15701a = (a) k.d(aVar);
    }

    @VisibleForTesting
    GifDrawable(f fVar, Paint paint) {
        this(new a(fVar));
        this.f15709i = paint;
    }
}
