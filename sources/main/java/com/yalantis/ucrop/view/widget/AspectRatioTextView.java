package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AspectRatioTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private final float f42895a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f42896b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f42897c;

    /* renamed from: d, reason: collision with root package name */
    private int f42898d;

    /* renamed from: e, reason: collision with root package name */
    private float f42899e;

    /* renamed from: f, reason: collision with root package name */
    private String f42900f;

    /* renamed from: g, reason: collision with root package name */
    private float f42901g;

    /* renamed from: h, reason: collision with root package name */
    private float f42902h;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    private void c(@NonNull TypedArray typedArray) {
        setGravity(1);
        this.f42900f = typedArray.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.f42901g = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f6 = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.f42902h = f6;
        float f7 = this.f42901g;
        if (f7 == 0.0f || f6 == 0.0f) {
            this.f42899e = 0.0f;
        } else {
            this.f42899e = f7 / f6;
        }
        this.f42898d = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.f42897c = paint;
        paint.setStyle(Paint.Style.FILL);
        d();
        a(getResources().getColor(R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(@ColorInt int i6) {
        Paint paint = this.f42897c;
        if (paint != null) {
            paint.setColor(i6);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[]{0}}, new int[]{i6, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget)}));
    }

    private void d() {
        if (TextUtils.isEmpty(this.f42900f)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.f42901g), Integer.valueOf((int) this.f42902h)));
        } else {
            setText(this.f42900f);
        }
    }

    private void e() {
        if (this.f42899e != 0.0f) {
            float f6 = this.f42901g;
            float f7 = this.f42902h;
            this.f42901g = f7;
            this.f42902h = f6;
            this.f42899e = f7 / f6;
        }
    }

    public float b(boolean z5) {
        if (z5) {
            e();
            d();
        }
        return this.f42899e;
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f42895a = 1.5f;
        this.f42896b = new Rect();
        c(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.f42896b);
            Rect rect = this.f42896b;
            float f6 = (rect.right - rect.left) / 2.0f;
            float f7 = rect.bottom - (rect.top / 2.0f);
            int i6 = this.f42898d;
            canvas.drawCircle(f6, f7 - (i6 * 1.5f), i6 / 2.0f, this.f42897c);
        }
    }

    public void setActiveColor(@ColorInt int i6) {
        a(i6);
        invalidate();
    }

    public void setAspectRatio(@NonNull AspectRatio aspectRatio) {
        this.f42900f = aspectRatio.a();
        this.f42901g = aspectRatio.b();
        float c6 = aspectRatio.c();
        this.f42902h = c6;
        float f6 = this.f42901g;
        if (f6 != 0.0f && c6 != 0.0f) {
            this.f42899e = f6 / c6;
        } else {
            this.f42899e = 0.0f;
        }
        d();
    }

    @TargetApi(21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f42895a = 1.5f;
        this.f42896b = new Rect();
        c(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }
}
