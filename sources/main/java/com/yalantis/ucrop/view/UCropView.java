package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.R;
import f3.c;
import f3.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UCropView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private GestureCropImageView f42891a;

    /* renamed from: b, reason: collision with root package name */
    private final OverlayView f42892b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements c {
        a() {
        }

        @Override // f3.c
        public void a(float f6) {
            UCropView.this.f42892b.setTargetAspectRatio(f6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements d {
        b() {
        }

        @Override // f3.d
        public void a(RectF rectF) {
            UCropView.this.f42891a.setCropRect(rectF);
        }
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        LayoutInflater.from(context).inflate(R.layout.ucrop_view, (ViewGroup) this, true);
        this.f42891a = (GestureCropImageView) findViewById(R.id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R.id.view_overlay);
        this.f42892b = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        overlayView.h(obtainStyledAttributes);
        this.f42891a.x(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        d();
    }

    private void d() {
        this.f42891a.setCropBoundsChangeListener(new a());
        this.f42892b.setOverlayViewChangeListener(new b());
    }

    public void c() {
        removeView(this.f42891a);
        this.f42891a = new GestureCropImageView(getContext());
        d();
        this.f42891a.setCropRect(getOverlayView().getCropViewRect());
        addView(this.f42891a, 0);
    }

    @NonNull
    public GestureCropImageView getCropImageView() {
        return this.f42891a;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.f42892b;
    }
}
