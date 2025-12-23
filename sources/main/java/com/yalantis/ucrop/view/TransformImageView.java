package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.util.d;
import com.yalantis.ucrop.util.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TransformImageView extends ImageView {

    /* renamed from: p, reason: collision with root package name */
    private static final String f42871p = "TransformImageView";

    /* renamed from: q, reason: collision with root package name */
    private static final int f42872q = 8;

    /* renamed from: r, reason: collision with root package name */
    private static final int f42873r = 2;

    /* renamed from: s, reason: collision with root package name */
    private static final int f42874s = 9;

    /* renamed from: a, reason: collision with root package name */
    protected final float[] f42875a;

    /* renamed from: b, reason: collision with root package name */
    protected final float[] f42876b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f42877c;

    /* renamed from: d, reason: collision with root package name */
    protected Matrix f42878d;

    /* renamed from: e, reason: collision with root package name */
    protected int f42879e;

    /* renamed from: f, reason: collision with root package name */
    protected int f42880f;

    /* renamed from: g, reason: collision with root package name */
    protected b f42881g;

    /* renamed from: h, reason: collision with root package name */
    private float[] f42882h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f42883i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f42884j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f42885k;

    /* renamed from: l, reason: collision with root package name */
    private int f42886l;

    /* renamed from: m, reason: collision with root package name */
    private String f42887m;

    /* renamed from: n, reason: collision with root package name */
    private String f42888n;

    /* renamed from: o, reason: collision with root package name */
    private com.yalantis.ucrop.model.b f42889o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements f3.b {
        a() {
        }

        @Override // f3.b
        public void a(@NonNull Bitmap bitmap, @NonNull com.yalantis.ucrop.model.b bVar, @NonNull String str, @Nullable String str2) {
            TransformImageView.this.f42887m = str;
            TransformImageView.this.f42888n = str2;
            TransformImageView.this.f42889o = bVar;
            TransformImageView transformImageView = TransformImageView.this;
            transformImageView.f42884j = true;
            transformImageView.setImageBitmap(bitmap);
        }

        @Override // f3.b
        public void onFailure(@NonNull Exception exc) {
            b bVar = TransformImageView.this.f42881g;
            if (bVar != null) {
                bVar.b(exc);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a();

        void b(@NonNull Exception exc);

        void c(float f6);

        void d(float f6);
    }

    public TransformImageView(Context context) {
        this(context, null);
    }

    public float d(@NonNull Matrix matrix) {
        return (float) (-(Math.atan2(f(matrix, 1), f(matrix, 0)) * 57.29577951308232d));
    }

    public float e(@NonNull Matrix matrix) {
        return (float) Math.sqrt(Math.pow(f(matrix, 0), 2.0d) + Math.pow(f(matrix, 3), 2.0d));
    }

    public void i(float f6, float f7, float f8) {
        if (f6 != 0.0f) {
            this.f42878d.postRotate(f6, f7, f8);
            setImageMatrix(this.f42878d);
            b bVar = this.f42881g;
            if (bVar != null) {
                bVar.d(d(this.f42878d));
            }
        }
    }

    public void j(float f6, float f7, float f8) {
        if (f6 != 0.0f) {
            this.f42878d.postScale(f6, f6, f7, f8);
            setImageMatrix(this.f42878d);
            b bVar = this.f42881g;
            if (bVar != null) {
                bVar.c(e(this.f42878d));
            }
        }
    }

    public void k(float f6, float f7) {
        if (f6 == 0.0f && f7 == 0.0f) {
            return;
        }
        this.f42878d.postTranslate(f6, f7);
        setImageMatrix(this.f42878d);
    }

    protected void l(@NonNull String str, @NonNull Matrix matrix) {
        f(matrix, 2);
        f(matrix, 5);
        e(matrix);
        d(matrix);
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void n() {
        this.f42878d.mapPoints(this.f42875a, this.f42882h);
        this.f42878d.mapPoints(this.f42876b, this.f42883i);
    }

    protected float f(@NonNull Matrix matrix, @IntRange(from = 0, to = 9) int i6) {
        matrix.getValues(this.f42877c);
        return this.f42877c[i6];
    }

    protected void g() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public float getCurrentAngle() {
        return d(this.f42878d);
    }

    public float getCurrentScale() {
        return e(this.f42878d);
    }

    public com.yalantis.ucrop.model.b getExifInfo() {
        return this.f42889o;
    }

    public String getImageInputPath() {
        return this.f42887m;
    }

    public String getImageOutputPath() {
        return this.f42888n;
    }

    public int getMaxBitmapSize() {
        if (this.f42886l <= 0) {
            this.f42886l = com.yalantis.ucrop.util.a.b(getContext());
        }
        return this.f42886l;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new d(bitmap));
    }

    public void setMaxBitmapSize(int i6) {
        this.f42886l = i6;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        }
    }

    public void setTransformImageListener(b bVar) {
        this.f42881g = bVar;
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f42875a = new float[8];
        this.f42876b = new float[2];
        this.f42877c = new float[9];
        this.f42878d = new Matrix();
        this.f42884j = false;
        this.f42885k = false;
        this.f42886l = 0;
        g();
    }

    @Nullable
    public Bitmap getViewBitmap() {
        if (getDrawable() != null && (getDrawable() instanceof d)) {
            return ((d) getDrawable()).a();
        }
        return null;
    }

    protected void h() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight));
            RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
            this.f42882h = g.b(rectF);
            this.f42883i = g.a(rectF);
            this.f42885k = true;
            b bVar = this.f42881g;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void m(@NonNull Uri uri, @Nullable Uri uri2) throws Exception {
        int maxBitmapSize = getMaxBitmapSize();
        com.yalantis.ucrop.util.a.d(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new a());
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (!z5 && (!this.f42884j || this.f42885k)) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        this.f42879e = width - paddingLeft;
        this.f42880f = height - paddingTop;
        h();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f42878d.set(matrix);
        n();
    }
}
