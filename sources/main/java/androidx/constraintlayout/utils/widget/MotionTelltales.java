package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class MotionTelltales extends MockView {
    private static final String TAG = "MotionTelltales";
    Matrix mInvertMatrix;
    MotionLayout mMotionLayout;
    private Paint mPaintTelltales;
    int mTailColor;
    float mTailScale;
    int mVelocityMode;
    float[] velocity;

    public MotionTelltales(Context context) {
        super(context);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.mTailColor = obtainStyledAttributes.getColor(index, this.mTailColor);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.mVelocityMode = obtainStyledAttributes.getInt(index, this.mVelocityMode);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.mTailScale = obtainStyledAttributes.getFloat(index, this.mTailScale);
                }
            }
        }
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.mInvertMatrix);
        if (this.mMotionLayout == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.mMotionLayout = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i6 = 0; i6 < 5; i6++) {
            float f6 = fArr[i6];
            for (int i7 = 0; i7 < 5; i7++) {
                float f7 = fArr[i7];
                this.mMotionLayout.getViewVelocity(this, f7, f6, this.velocity, this.mVelocityMode);
                this.mInvertMatrix.mapVectors(this.velocity);
                float f8 = width * f7;
                float f9 = height * f6;
                float[] fArr2 = this.velocity;
                float f10 = fArr2[0];
                float f11 = this.mTailScale;
                float f12 = f9 - (fArr2[1] * f11);
                this.mInvertMatrix.mapVectors(fArr2);
                canvas.drawLine(f8, f9, f8 - (f10 * f11), f12, this.mPaintTelltales);
            }
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attributeSet);
    }
}
