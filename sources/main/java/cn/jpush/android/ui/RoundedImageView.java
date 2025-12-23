package cn.jpush.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\Downloads\app\classes2.dex */
public class RoundedImageView extends ImageView {
    private int defaultRadius;
    private float height;
    private int leftBottomRadius;
    private int leftTopRadius;
    private int radius;
    private int rightBottomRadius;
    private int rightTopRadius;
    private float width;

    public RoundedImageView(Context context) {
        this(context, null);
        init(context, null);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i6 = this.defaultRadius;
        this.leftTopRadius = i6;
        this.rightTopRadius = i6;
        this.rightBottomRadius = i6;
        this.leftBottomRadius = i6;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int max = Math.max(this.leftTopRadius, this.leftBottomRadius) + Math.max(this.rightTopRadius, this.rightBottomRadius);
        int max2 = Math.max(this.leftTopRadius, this.rightTopRadius) + Math.max(this.leftBottomRadius, this.rightBottomRadius);
        if (this.width >= max && this.height > max2) {
            Path path = new Path();
            path.moveTo(this.leftTopRadius, 0.0f);
            path.lineTo(this.width - this.rightTopRadius, 0.0f);
            float f6 = this.width;
            path.quadTo(f6, 0.0f, f6, this.rightTopRadius);
            path.lineTo(this.width, this.height - this.rightBottomRadius);
            float f7 = this.width;
            float f8 = this.height;
            path.quadTo(f7, f8, f7 - this.rightBottomRadius, f8);
            path.lineTo(this.leftBottomRadius, this.height);
            float f9 = this.height;
            path.quadTo(0.0f, f9, 0.0f, f9 - this.leftBottomRadius);
            path.lineTo(0.0f, this.leftTopRadius);
            path.quadTo(0.0f, 0.0f, this.leftTopRadius, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    public void setRadius(int i6, int i7, int i8, int i9) {
        this.leftTopRadius = i6;
        this.rightTopRadius = i7;
        this.rightBottomRadius = i8;
        this.leftBottomRadius = i9;
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.defaultRadius = 45;
        init(context, attributeSet);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        this.width = getWidth();
        this.height = getHeight();
    }
}
