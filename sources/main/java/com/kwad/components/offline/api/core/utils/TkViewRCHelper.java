package com.kwad.components.offline.api.core.utils;

import android.content.Context;
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
import com.kwad.sdk.widget.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class TkViewRCHelper {
    private boolean mClipBackground;

    @NonNull
    private j.a mCornerConf;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    public float[] radiusArray;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CornerConf {
        private boolean leftTop = true;
        private boolean topRight = true;
        private boolean rightBottom = true;
        private boolean bottomLeft = true;

        public boolean isBottomLeft() {
            return this.bottomLeft;
        }

        public boolean isLeftTop() {
            return this.leftTop;
        }

        public boolean isRightBottom() {
            return this.rightBottom;
        }

        public boolean isTopRight() {
            return this.topRight;
        }

        public void setAllCorner(boolean z5) {
            this.leftTop = z5;
            this.topRight = z5;
            this.rightBottom = z5;
            this.bottomLeft = z5;
        }

        public CornerConf setBottomLeft(boolean z5) {
            this.bottomLeft = z5;
            return this;
        }

        public CornerConf setLeftTop(boolean z5) {
            this.leftTop = z5;
            return this;
        }

        public CornerConf setRightBottom(boolean z5) {
            this.rightBottom = z5;
            return this;
        }

        public CornerConf setTopRight(boolean z5) {
            this.topRight = z5;
            return this;
        }
    }

    public TkViewRCHelper() {
        this.radiusArray = new float[8];
        this.mCornerConf = new j.a();
    }

    public void setRadius(float f6) {
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

    public void afterDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public void afterDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(getPath(), this.mPaint);
            }
            canvas.restore();
        }
    }

    public void beforeDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.mRectF, null, 31);
        } else {
            canvas.save();
            canvas.clipPath(getPath());
        }
    }

    public void beforeDraw(Canvas canvas) {
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
    public j.a getCornerConf() {
        return this.mCornerConf;
    }

    public void initAttrs(Context context, @Nullable AttributeSet attributeSet) {
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void onSizeChanged(int i6, int i7) {
        this.mRectF.set(0.0f, 0.0f, i6, i7);
    }

    public void setRadius(float[] fArr) {
        this.radiusArray = fArr;
    }

    public TkViewRCHelper(j.a aVar) {
        this.radiusArray = new float[8];
        if (aVar == null) {
            this.mCornerConf = new j.a();
        } else {
            this.mCornerConf = aVar;
        }
    }
}
