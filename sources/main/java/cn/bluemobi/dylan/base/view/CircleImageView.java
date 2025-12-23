package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import cn.bluemobi.dylan.base.R;
import cn.bluemobi.dylan.base.utils.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CircleImageView extends AppCompatImageView {
    private static final int COLORDRAWABLE_DIMENSION = 1;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private final Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    private final RectF mBorderRect;
    private int mBorderWidth;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private boolean mReady;
    private boolean mSetupPending;
    private final Matrix mShaderMatrix;
    private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

    public CircleImageView(Context context) {
        super(context);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(1, 1, BITMAP_CONFIG);
            } else {
                i.a c6 = i.c(this);
                createBitmap = Bitmap.createBitmap(c6.f1226a, c6.f1227b, BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private void setup() {
        if (!this.mReady) {
            this.mSetupPending = true;
            return;
        }
        if (this.mBitmap == null) {
            return;
        }
        Bitmap bitmap = this.mBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setShader(this.mBitmapShader);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBitmapHeight = this.mBitmap.getHeight();
        this.mBitmapWidth = this.mBitmap.getWidth();
        this.mBorderRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mBorderRadius = Math.max((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
        RectF rectF = this.mDrawableRect;
        int i6 = this.mBorderWidth;
        rectF.set(i6, i6, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
        this.mDrawableRadius = Math.max(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
        updateShaderMatrix();
        invalidate();
    }

    private void updateShaderMatrix() {
        float height;
        float f6;
        this.mShaderMatrix.set(null);
        float f7 = 0.0f;
        if (this.mBitmapWidth * this.mDrawableRect.height() > this.mDrawableRect.width() * this.mBitmapHeight) {
            height = this.mDrawableRect.width() / this.mBitmapWidth;
            f6 = (this.mDrawableRect.height() - (this.mBitmapHeight * height)) * 0.5f;
        } else {
            height = this.mDrawableRect.height() / this.mBitmapHeight;
            f7 = (this.mDrawableRect.width() - (this.mBitmapWidth * height)) * 0.5f;
            f6 = 0.0f;
        }
        this.mShaderMatrix.setScale(height, height);
        Matrix matrix = this.mShaderMatrix;
        int i6 = this.mBorderWidth;
        matrix.postTranslate(((int) (f7 + 0.5f)) + i6, ((int) (f6 + 0.5f)) + i6);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public void setBorderColor(int i6) {
        if (i6 == this.mBorderColor) {
            return;
        }
        this.mBorderColor = i6;
        this.mBorderPaint.setColor(i6);
        invalidate();
    }

    public void setBorderWidth(int i6) {
        if (i6 == this.mBorderWidth) {
            return;
        }
        this.mBorderWidth = i6;
        setup();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mDrawableRadius, this.mBitmapPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mBorderRadius, this.mBorderPaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        setup();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = getBitmapFromDrawable(drawable);
        setup();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i6) {
        super.setImageResource(i6);
        this.mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        super.setScaleType(SCALE_TYPE);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i6, 0);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_border_width, 0);
        this.mBorderColor = obtainStyledAttributes.getColor(R.styleable.CircleImageView_border_color, -16777216);
        obtainStyledAttributes.recycle();
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }
}
