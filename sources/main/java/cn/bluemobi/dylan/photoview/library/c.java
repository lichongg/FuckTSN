package cn.bluemobi.dylan.photoview.library;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import cn.bluemobi.dylan.photoview.library.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface c {

    /* renamed from: d0, reason: collision with root package name */
    public static final float f1306d0 = 3.0f;

    /* renamed from: e0, reason: collision with root package name */
    public static final float f1307e0 = 1.75f;

    /* renamed from: f0, reason: collision with root package name */
    public static final float f1308f0 = 1.0f;

    /* renamed from: g0, reason: collision with root package name */
    public static final int f1309g0 = 200;

    void a(float f6, float f7, float f8, boolean z5);

    void b(float f6, boolean z5);

    boolean d();

    boolean g(Matrix matrix);

    Matrix getDisplayMatrix();

    RectF getDisplayRect();

    c getIPhotoViewImplementation();

    @Deprecated
    float getMaxScale();

    float getMaximumScale();

    float getMediumScale();

    @Deprecated
    float getMidScale();

    @Deprecated
    float getMinScale();

    float getMinimumScale();

    d.f getOnPhotoTapListener();

    d.h getOnViewTapListener();

    float getScale();

    ImageView.ScaleType getScaleType();

    Bitmap getVisibleRectangleBitmap();

    void h(float f6, float f7, float f8);

    void setAllowParentInterceptOnEdge(boolean z5);

    @Deprecated
    void setMaxScale(float f6);

    void setMaximumScale(float f6);

    void setMediumScale(float f6);

    @Deprecated
    void setMidScale(float f6);

    @Deprecated
    void setMinScale(float f6);

    void setMinimumScale(float f6);

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

    void setOnMatrixChangeListener(d.e eVar);

    void setOnPhotoTapListener(d.f fVar);

    void setOnScaleChangeListener(d.g gVar);

    void setOnViewTapListener(d.h hVar);

    void setPhotoViewRotation(float f6);

    void setRotationBy(float f6);

    void setRotationTo(float f6);

    void setScale(float f6);

    void setScaleType(ImageView.ScaleType scaleType);

    void setZoomTransitionDuration(int i6);

    void setZoomable(boolean z5);
}
