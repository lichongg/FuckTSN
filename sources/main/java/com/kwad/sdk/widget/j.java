package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {
    private boolean mClipBackground;

    @NonNull
    private a mCornerConf;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    public float[] radiusArray;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private boolean leftTop = true;
        private boolean topRight = true;
        private boolean rightBottom = true;
        private boolean bottomLeft = true;

        public final a cp(boolean z5) {
            this.leftTop = z5;
            return this;
        }

        public final a cq(boolean z5) {
            this.topRight = z5;
            return this;
        }

        public final a cr(boolean z5) {
            this.rightBottom = z5;
            return this;
        }

        public final a cs(boolean z5) {
            this.bottomLeft = z5;
            return this;
        }

        public final boolean isBottomLeft() {
            return this.bottomLeft;
        }

        public final boolean isLeftTop() {
            return this.leftTop;
        }

        public final boolean isRightBottom() {
            return this.rightBottom;
        }

        public final boolean isTopRight() {
            return this.topRight;
        }

        public final void setAllCorner(boolean z5) {
            this.leftTop = z5;
            this.topRight = z5;
            this.rightBottom = z5;
            this.bottomLeft = z5;
        }
    }

    public j() {
        this.radiusArray = new float[8];
        this.mCornerConf = new a();
    }

    public final void initAttrs(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int i6 = R.attr.ksad_radius;
                int i7 = R.attr.ksad_clipBackground;
                int[] iArr = {i6, i7};
                Arrays.sort(iArr);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
                this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i6), 0);
                this.mClipBackground = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i7), true);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void setRadius(float f6) {
        this.mRadius = f6;
    }

    private Path getPath() {
        try {
            this.mPath.reset();
        } catch (Exception unused) {
        }
        this.mPath.addRoundRect(this.mRectF, this.mRadius == 0.0f ? this.radiusArray : getRadius(), Path.Direction.CW);
        return this.mPath;
    }

    private float[] getRadius() {
        this.radiusArray[0] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[1] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[2] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[3] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[4] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[5] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[6] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        this.radiusArray[7] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        return this.radiusArray;
    }

    public final void afterDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public final void afterDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(getPath(), this.mPaint);
            }
            canvas.restore();
        }
    }

    public final void beforeDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.mRectF, null, 31);
        } else {
            canvas.save();
            canvas.clipPath(getPath());
        }
    }

    public final void beforeDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.mRectF, null, 31);
            } else {
                canvas.save();
                canvas.clipPath(getPath());
            }
        }
    }

    @NonNull
    public final a getCornerConf() {
        return this.mCornerConf;
    }

    public final void onSizeChanged(int i6, int i7) {
        this.mRectF.set(0.0f, 0.0f, i6, i7);
    }

    public final void setRadius(float[] fArr) {
        this.radiusArray = fArr;
    }

    public j(a aVar) {
        this.radiusArray = new float[8];
        this.mCornerConf = aVar;
    }
}
