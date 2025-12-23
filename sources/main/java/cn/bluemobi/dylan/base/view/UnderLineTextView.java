package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.internal.view.SupportMenu;
import cn.bluemobi.dylan.base.R;
import cn.bluemobi.dylan.base.utils.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class UnderLineTextView extends AppCompatTextView {
    private float density;
    private int mColor;
    private Paint mPaint;
    private Rect mRect;
    private float mStrokeWidth;
    private float spase;

    public UnderLineTextView(Context context) {
        this(context, null, 0);
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i6) {
        this.spase = u.a(1.0f, context);
        this.density = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlinedTextView, i6, 0);
        this.mColor = obtainStyledAttributes.getColor(R.styleable.UnderlinedTextView_underlineColor, SupportMenu.CATEGORY_MASK);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.UnderlinedTextView_underlineWidth, this.density * 2.0f);
        obtainStyledAttributes.recycle();
        this.mRect = new Rect();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
    }

    public int getUnderLineColor() {
        return this.mColor;
    }

    public float getUnderlineWidth() {
        return this.mStrokeWidth;
    }

    public void setUnderLineColor(int i6) {
        this.mColor = i6;
        invalidate();
    }

    public void setUnderlineWidth(float f6) {
        this.mStrokeWidth = f6;
        invalidate();
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        init(context, attributeSet, i6);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int lineCount = getLineCount();
        Layout layout = getLayout();
        for (int i6 = 0; i6 < lineCount; i6++) {
            int lineBounds = getLineBounds(i6, this.mRect);
            int lineStart = layout.getLineStart(i6);
            int lineEnd = layout.getLineEnd(i6);
            float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
            float primaryHorizontal2 = layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal);
            float f6 = lineBounds;
            float f7 = this.mStrokeWidth;
            float f8 = this.spase;
            canvas.drawLine(primaryHorizontal, f6 + f7 + f8, primaryHorizontal2, f6 + f7 + f8, this.mPaint);
        }
        super.onDraw(canvas);
    }
}
