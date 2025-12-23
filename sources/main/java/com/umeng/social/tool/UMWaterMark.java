package com.umeng.social.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class UMWaterMark {
    static final int RELATIVE_POSITION_HORIZONTAL_LEFT = 4;
    static final int RELATIVE_POSITION_HORIZONTAL_RIGHT = 3;
    static final int RELATIVE_POSITION_VERTICAL_BOTTOM = 1;
    static final int RELATIVE_POSITION_VERTICAL_TOP = 2;
    private static final String TAG = "UMWaterMark";
    private int mBottomMargin;
    private Context mContext;
    private int mLeftMargin;
    private int mRightMargin;
    private int mTopMargin;
    private float mScale = 0.3f;
    private Rect mAnchorMarkRect = new Rect();
    private int mVerticalRelativePosition = -1;
    private int mHorizontalRelativePosition = -1;
    private int mGravity = 51;
    private boolean mIsTransparent = false;
    private boolean mIsBringToFront = false;
    private float mAlpha = -1.0f;
    private int mDegree = -1;
    private Rect mMeasureRect = new Rect();

    public void bringToFront() {
        this.mIsBringToFront = true;
    }

    void clearRelativePosition() {
        this.mHorizontalRelativePosition = -1;
        this.mVerticalRelativePosition = -1;
    }

    public Bitmap compound(Bitmap bitmap) {
        Bitmap createBitmap;
        Canvas canvas;
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap markBitmap = getMarkBitmap();
            if (markBitmap == null) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                int markWidth = getMarkWidth();
                int markHeight = getMarkHeight();
                if (markWidth > 0 && markHeight > 0) {
                    if (this.mIsTransparent) {
                        createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        canvas = new Canvas(createBitmap);
                        canvas.drawColor(0);
                    } else {
                        createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                        canvas = new Canvas(createBitmap);
                    }
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    Matrix matrix = new Matrix();
                    float min = (this.mScale * Math.min(bitmap.getWidth(), bitmap.getHeight())) / Math.max(markWidth, markHeight);
                    matrix.postScale(min, min, getScaleAnchorX(markWidth), getScaleAnchorY(markHeight));
                    int i6 = this.mDegree;
                    if (i6 != -1) {
                        matrix.postRotate(i6, markWidth / 2, markHeight / 2);
                    }
                    matrix.postTranslate(isHorizontalRelativePosition() ? getRelativeDx(width) : getDx(width), isVerticalRelativePosition() ? getRelativeDy(height) : getDy(height));
                    if (this.mAlpha != -1.0f) {
                        Paint paint = new Paint();
                        paint.setAlpha((int) (this.mAlpha * 255.0f));
                        canvas.drawBitmap(markBitmap, matrix, paint);
                    } else {
                        canvas.drawBitmap(markBitmap, matrix, null);
                    }
                    safelyRecycleBitmap(bitmap);
                    safelyRecycleBitmap(markBitmap);
                    releaseResource();
                    return createBitmap;
                }
            }
            return bitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    Bitmap getMarkBitmap() {
        return null;
    }

    public void setAlpha(float f6) {
        if (f6 < 0.0f || f6 > 1.0f) {
            return;
        }
        this.mAlpha = f6;
    }

    public void setScale(float f6) {
        if (f6 < 0.0f || f6 > 1.0f) {
            return;
        }
        this.mScale = f6;
    }

    public void setTransparent() {
        this.mIsTransparent = true;
    }

    private float getDx(int i6) {
        int dip2px = dip2px(this.mLeftMargin);
        int i7 = -dip2px(this.mRightMargin);
        int i8 = this.mGravity & 7;
        if (i8 != 1) {
            return i8 != 5 ? dip2px : (i6 - getMarkWidth()) + i7;
        }
        if (dip2px == 0) {
            dip2px = i7;
        }
        return (((i6 - getMarkWidth()) * 1.0f) / 2.0f) + dip2px;
    }

    private float getDy(int i6) {
        int i7 = -dip2px(this.mBottomMargin);
        int dip2px = dip2px(this.mTopMargin);
        int i8 = this.mGravity & 112;
        if (i8 != 16) {
            return i8 != 80 ? dip2px : (i6 - getMarkHeight()) + i7;
        }
        if (dip2px != 0) {
            i7 = dip2px;
        }
        return (((i6 - getMarkHeight()) * 1.0f) / 2.0f) + i7;
    }

    private float getRelativeDx(int i6) {
        Rect rect = this.mAnchorMarkRect;
        float f6 = rect.left;
        float f7 = rect.right;
        int i7 = this.mHorizontalRelativePosition;
        if (i7 == 3) {
            return f7 + dip2px(this.mLeftMargin);
        }
        if (i7 != 4) {
            return getDx(i6);
        }
        return (f6 - getMarkWidth()) + (-dip2px(this.mRightMargin));
    }

    private float getRelativeDy(int i6) {
        Rect rect = this.mAnchorMarkRect;
        float f6 = rect.top;
        float f7 = rect.bottom;
        int i7 = this.mVerticalRelativePosition;
        if (i7 == 1) {
            return f7 + dip2px(this.mTopMargin);
        }
        if (i7 != 2) {
            return getDy(i6);
        }
        return (f6 - getMarkHeight()) + (-dip2px(this.mBottomMargin));
    }

    private float getScaleAnchorX(int i6) {
        int i7 = this.mGravity & 7;
        if (i7 == 1) {
            return i6 / 2;
        }
        if (i7 != 5) {
            return 0.0f;
        }
        return i6;
    }

    private float getScaleAnchorY(int i6) {
        int i7 = this.mGravity & 112;
        if (i7 == 16) {
            return i6 / 2;
        }
        if (i7 != 80) {
            return 0.0f;
        }
        return i6;
    }

    private void safelyRecycleBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception unused) {
            }
        }
    }

    int dip2px(float f6) {
        return (int) ((f6 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    boolean isBringToFront() {
        return this.mIsBringToFront;
    }

    boolean isHorizontalRelativePosition() {
        return this.mHorizontalRelativePosition != -1;
    }

    boolean isVerticalRelativePosition() {
        return this.mVerticalRelativePosition != -1;
    }

    void setAnchorMarkHorizontalRect(Rect rect) {
        Rect rect2 = this.mAnchorMarkRect;
        rect2.set(rect.left, rect2.top, rect.right, rect2.bottom);
    }

    void setAnchorMarkVerticalRect(Rect rect) {
        this.mAnchorMarkRect = rect;
        rect.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setGravity(int i6) {
        if (i6 > 0 && this.mGravity != i6) {
            this.mGravity = i6;
        }
    }

    void setHorizontalRelativePosition(int i6) {
        this.mHorizontalRelativePosition = i6;
    }

    public void setMargins(int i6, int i7, int i8, int i9) {
        this.mLeftMargin = i6;
        this.mTopMargin = i7;
        this.mRightMargin = i8;
        this.mBottomMargin = i9;
    }

    public void setRotate(int i6) {
        if (i6 < 0 || i6 > 360) {
            return;
        }
        this.mDegree = i6;
    }

    void setVerticalRelativePosition(int i6) {
        this.mVerticalRelativePosition = i6;
    }

    UMWaterMark() {
    }

    private int getMarkHeight() {
        if (getMarkBitmap() == null) {
            return -1;
        }
        return getMarkBitmap().getHeight();
    }

    private int getMarkWidth() {
        if (getMarkBitmap() == null) {
            return -1;
        }
        return getMarkBitmap().getWidth();
    }

    Rect onMeasure(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11 = 0;
        if (!isHorizontalRelativePosition()) {
            i8 = (int) getDx(i6);
            i9 = getMarkWidth() + i8;
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (!isVerticalRelativePosition()) {
            i11 = (int) getDy(i7);
            i10 = getMarkHeight() + i11;
        } else {
            i10 = 0;
        }
        this.mMeasureRect.set(i8, i11, i9, i10);
        return this.mMeasureRect;
    }

    void releaseResource() {
    }
}
