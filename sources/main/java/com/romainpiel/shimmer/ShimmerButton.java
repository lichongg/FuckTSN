package com.romainpiel.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import com.romainpiel.shimmer.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ShimmerButton extends Button implements c {

    /* renamed from: a, reason: collision with root package name */
    private d f36810a;

    public ShimmerButton(Context context) {
        super(context);
        d dVar = new d(this, getPaint(), null);
        this.f36810a = dVar;
        dVar.l(getCurrentTextColor());
    }

    @Override // android.widget.TextView
    public void setTextColor(int i6) {
        super.setTextColor(i6);
        d dVar = this.f36810a;
        if (dVar != null) {
            dVar.l(getCurrentTextColor());
        }
    }

    @Override // com.romainpiel.shimmer.c
    public boolean a() {
        return this.f36810a.e();
    }

    @Override // com.romainpiel.shimmer.c
    public boolean b() {
        return this.f36810a.f();
    }

    @Override // com.romainpiel.shimmer.c
    public float getGradientX() {
        return this.f36810a.a();
    }

    @Override // com.romainpiel.shimmer.c
    public int getPrimaryColor() {
        return this.f36810a.b();
    }

    @Override // com.romainpiel.shimmer.c
    public int getReflectionColor() {
        return this.f36810a.c();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        d dVar = this.f36810a;
        if (dVar != null) {
            dVar.g();
        }
        super.onDraw(canvas);
    }

    @Override // com.romainpiel.shimmer.c
    public void setAnimationSetupCallback(d.a aVar) {
        this.f36810a.j(aVar);
    }

    @Override // com.romainpiel.shimmer.c
    public void setGradientX(float f6) {
        this.f36810a.k(f6);
    }

    @Override // com.romainpiel.shimmer.c
    public void setPrimaryColor(int i6) {
        this.f36810a.l(i6);
    }

    @Override // com.romainpiel.shimmer.c
    public void setReflectionColor(int i6) {
        this.f36810a.m(i6);
    }

    @Override // com.romainpiel.shimmer.c
    public void setShimmering(boolean z5) {
        this.f36810a.n(z5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        d dVar = this.f36810a;
        if (dVar != null) {
            dVar.h();
        }
    }

    public ShimmerButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d dVar = new d(this, getPaint(), attributeSet);
        this.f36810a = dVar;
        dVar.l(getCurrentTextColor());
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        d dVar = this.f36810a;
        if (dVar != null) {
            dVar.l(getCurrentTextColor());
        }
    }

    public ShimmerButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        d dVar = new d(this, getPaint(), attributeSet);
        this.f36810a = dVar;
        dVar.l(getCurrentTextColor());
    }
}
