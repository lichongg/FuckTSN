package cn.bluemobi.dylan.photoview.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import cn.bluemobi.dylan.photoview.library.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PhotoView extends ImageView implements c {

    /* renamed from: a, reason: collision with root package name */
    private d f1302a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView.ScaleType f1303b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void a(float f6, float f7, float f8, boolean z5) {
        this.f1302a.a(f6, f7, f8, z5);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void b(float f6, boolean z5) {
        this.f1302a.b(f6, z5);
    }

    protected void c() {
        d dVar = this.f1302a;
        if (dVar == null || dVar.u() == null) {
            this.f1302a = new d(this);
        }
        ImageView.ScaleType scaleType = this.f1303b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f1303b = null;
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public boolean d() {
        return this.f1302a.d();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public boolean g(Matrix matrix) {
        return this.f1302a.g(matrix);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public Matrix getDisplayMatrix() {
        return this.f1302a.getDisplayMatrix();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public RectF getDisplayRect() {
        return this.f1302a.getDisplayRect();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public c getIPhotoViewImplementation() {
        return this.f1302a;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMaximumScale() {
        return this.f1302a.getMaximumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMediumScale() {
        return this.f1302a.getMediumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMinimumScale() {
        return this.f1302a.getMinimumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public d.f getOnPhotoTapListener() {
        return this.f1302a.getOnPhotoTapListener();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public d.h getOnViewTapListener() {
        return this.f1302a.getOnViewTapListener();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getScale() {
        return this.f1302a.getScale();
    }

    @Override // android.widget.ImageView, cn.bluemobi.dylan.photoview.library.c
    public ImageView.ScaleType getScaleType() {
        return this.f1302a.getScaleType();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public Bitmap getVisibleRectangleBitmap() {
        return this.f1302a.getVisibleRectangleBitmap();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void h(float f6, float f7, float f8) {
        this.f1302a.h(f6, f7, f8);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.f1302a.r();
        super.onDetachedFromWindow();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setAllowParentInterceptOnEdge(boolean z5) {
        this.f1302a.setAllowParentInterceptOnEdge(z5);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMaximumScale(float f6) {
        this.f1302a.setMaximumScale(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMediumScale(float f6) {
        this.f1302a.setMediumScale(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMinimumScale(float f6) {
        this.f1302a.setMinimumScale(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f1302a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View, cn.bluemobi.dylan.photoview.library.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f1302a.setOnLongClickListener(onLongClickListener);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnMatrixChangeListener(d.e eVar) {
        this.f1302a.setOnMatrixChangeListener(eVar);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnPhotoTapListener(d.f fVar) {
        this.f1302a.setOnPhotoTapListener(fVar);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnScaleChangeListener(d.g gVar) {
        this.f1302a.setOnScaleChangeListener(gVar);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnViewTapListener(d.h hVar) {
        this.f1302a.setOnViewTapListener(hVar);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setPhotoViewRotation(float f6) {
        this.f1302a.setRotationTo(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setRotationBy(float f6) {
        this.f1302a.setRotationBy(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setRotationTo(float f6) {
        this.f1302a.setRotationTo(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setScale(float f6) {
        this.f1302a.setScale(f6);
    }

    @Override // android.widget.ImageView, cn.bluemobi.dylan.photoview.library.c
    public void setScaleType(ImageView.ScaleType scaleType) {
        d dVar = this.f1302a;
        if (dVar != null) {
            dVar.setScaleType(scaleType);
        } else {
            this.f1303b = scaleType;
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setZoomTransitionDuration(int i6) {
        this.f1302a.setZoomTransitionDuration(i6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setZoomable(boolean z5) {
        this.f1302a.setZoomable(z5);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        c();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        c();
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d dVar = this.f1302a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i6) {
        super.setImageResource(i6);
        d dVar = this.f1302a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d dVar = this.f1302a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMaxScale(float f6) {
        setMaximumScale(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMidScale(float f6) {
        setMediumScale(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMinScale(float f6) {
        setMinimumScale(f6);
    }
}
