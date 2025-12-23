package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f16239a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f16240b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f16241c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f16242d;

    /* renamed from: e, reason: collision with root package name */
    private a f16243e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f16244f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f16245a;

        /* renamed from: b, reason: collision with root package name */
        final int f16246b;

        /* renamed from: c, reason: collision with root package name */
        final int f16247c;

        a(a aVar) {
            this(aVar.f16245a, aVar.f16246b, aVar.f16247c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new i(this, this.f16245a.newDrawable());
        }

        a(Drawable.ConstantState constantState, int i6, int i7) {
            this.f16245a = constantState;
            this.f16246b = i6;
            this.f16247c = i7;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new i(this, this.f16245a.newDrawable(resources));
        }
    }

    public i(Drawable drawable, int i6, int i7) {
        this(new a(drawable.getConstantState(), i6, i7), drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i6, int i7, int i8, int i9) {
        super.setBounds(i6, i7, i8, i9);
        this.f16241c.set(i6, i7, i8, i9);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i6, @NonNull PorterDuff.Mode mode) {
        this.f16242d.setColorFilter(i6, mode);
    }

    i(a aVar, Drawable drawable) {
        this.f16243e = (a) com.bumptech.glide.util.k.d(aVar);
        this.f16242d = (Drawable) com.bumptech.glide.util.k.d(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f16239a = new Matrix();
        this.f16240b = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f16241c = new RectF();
    }

    private void a() {
        this.f16239a.setRectToRect(this.f16240b, this.f16241c, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f16242d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
    public int getAlpha() {
        return this.f16242d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.f16242d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f16242d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f16243e;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f16242d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f16243e.f16247c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f16243e.f16246b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f16242d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f16242d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f16242d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f16242d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f16244f && super.mutate() == this) {
            this.f16242d = this.f16242d.mutate();
            this.f16243e = new a(this.f16243e);
            this.f16244f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f16242d.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i6) {
        this.f16242d.setChangingConfigurations(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f16242d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z5) {
        this.f16242d.setDither(z5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z5) {
        this.f16242d.setFilterBitmap(z5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        return this.f16242d.setVisible(z5, z6);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.f16239a);
        this.f16242d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f16242d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(@NonNull Runnable runnable, long j6) {
        super.scheduleSelf(runnable, j6);
        this.f16242d.scheduleSelf(runnable, j6);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f16242d.unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        this.f16241c.set(rect);
        a();
    }
}
