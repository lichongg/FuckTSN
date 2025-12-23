package com.baidu.idl.face.platform.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.face.platform.utils.DensityUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceDetectRoundView extends View {
    public static final int CIRCLE_LINE_WIDTH = 3;
    public static final float HEIGHT_EXT_RATIO = 0.2f;
    public static final float HEIGHT_RATIO = 0.1f;
    public static final int PATH_SMALL_SPACE = 12;
    public static final int PATH_SPACE = 16;
    public static final float RECT_RATIO = 0.9f;
    public static final float SURFACE_HEIGHT = 1000.0f;
    public static final float SURFACE_RATIO = 0.75f;
    private static final String TAG = "FaceDetectRoundView";
    public static final float WIDTH_SPACE_RATIO = 0.33f;
    private static float mRatioX;
    private static float mRatioY;
    private Paint mBGPaint;
    private Paint mCircleLinePaint;
    private Paint mCircleLineSelectPaint;
    private Rect mFaceDetectRect;
    private FaceExtInfo mFaceExtInfo;
    private Rect mFaceRect;
    private Paint mFaceRoundPaint;
    private boolean mIsActiveLive;
    private float mR;
    private int mSuccessActiveCount;
    private Paint mTextSecondPaint;
    private Paint mTextTopPaint;
    private String mTipSecondText;
    private String mTipTopText;
    private int mTotalActiveCount;
    private float mX;
    private float mY;
    public static final int COLOR_BG = Color.parseColor("#FFFFFF");
    public static final int COLOR_ROUND = Color.parseColor("#FFA800");
    public static final int COLOR_CIRCLE_LINE = Color.parseColor("#CCCCCC");
    public static final int COLOR_CIRCLE_SELECT_LINE = Color.parseColor("#00BAF2");

    public static Rect getPreviewDetectRect(int i6, int i7, int i8) {
        float f6 = i6 / 2;
        float f7 = f6 - (0.33f * f6);
        float f8 = i7 / 2;
        float f9 = i8 / 2;
        float f10 = f9 - (0.1f * f9);
        if (f8 <= f7) {
            f7 = f8;
        }
        float f11 = (0.2f * f7) + f7;
        return new Rect((int) (f8 - f7), (int) (f10 - f11), (int) (f8 + f7), (int) (f10 + f11));
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        float f6 = (i8 - i6) / 2.0f;
        float f7 = (i9 - i7) / 2.0f;
        float f8 = f7 - (0.1f * f7);
        float f9 = f6 - (0.33f * f6);
        if (this.mFaceRect == null) {
            this.mFaceRect = new Rect((int) (f6 - f9), (int) (f8 - f9), (int) (f6 + f9), (int) (f8 + f9));
        }
        if (this.mFaceDetectRect == null) {
            float f10 = (0.2f * f9) + f9;
            this.mFaceDetectRect = new Rect((int) (f6 - f9), (int) (f8 - f10), (int) (f6 + f9), (int) (f10 + f8));
        }
        this.mX = f6;
        this.mY = f8;
        this.mR = f9;
    }

    private void drawSuccessCircleLine(Canvas canvas) {
        int i6 = (int) ((this.mSuccessActiveCount / this.mTotalActiveCount) * 360.0f);
        canvas.save();
        canvas.rotate(-90.0f);
        int i7 = 0;
        while (i7 < i6) {
            float f6 = this.mR;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f6 + 40.0f, 0.0f, f6 + 40.0f + 25.0f, 0.0f, this.mCircleLineSelectPaint);
            canvas2.rotate(6.0f);
            i7 += 6;
            canvas = canvas2;
        }
        canvas.restore();
    }

    public static Rect getFaceInfoRect(FaceExtInfo faceExtInfo) {
        if (faceExtInfo == null) {
            return null;
        }
        return faceExtInfo.getFaceRect(mRatioX, mRatioY, 0.75f);
    }

    public Rect getFaceRoundRect() {
        Rect rect = this.mFaceRect;
        if (rect != null) {
            rect.toString();
        }
        return this.mFaceRect;
    }

    public float getRound() {
        return this.mR;
    }

    public void setFaceInfo(FaceExtInfo faceExtInfo) {
        this.mFaceExtInfo = faceExtInfo;
        postInvalidate();
    }

    public void setIsActiveLive(boolean z5) {
        this.mIsActiveLive = z5;
    }

    public void setProcessCount(int i6, int i7) {
        this.mSuccessActiveCount = i6;
        this.mTotalActiveCount = i7;
        postInvalidate();
    }

    public void setTipSecondText(String str) {
        this.mTipSecondText = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        invalidate();
    }

    public void setTipTopText(String str) {
        this.mTipTopText = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        invalidate();
    }

    public FaceDetectRoundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, null);
        float dip2px = DensityUtils.dip2px(context, 3.0f);
        Paint paint = new Paint(1);
        this.mBGPaint = paint;
        paint.setColor(COLOR_BG);
        Paint paint2 = this.mBGPaint;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.mBGPaint.setAntiAlias(true);
        this.mBGPaint.setDither(true);
        Paint paint3 = new Paint(1);
        this.mFaceRoundPaint = paint3;
        paint3.setColor(COLOR_ROUND);
        this.mFaceRoundPaint.setStyle(style);
        this.mFaceRoundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mFaceRoundPaint.setAntiAlias(true);
        this.mFaceRoundPaint.setDither(true);
        Paint paint4 = new Paint(1);
        this.mCircleLinePaint = paint4;
        paint4.setColor(COLOR_CIRCLE_LINE);
        this.mCircleLinePaint.setStrokeWidth(dip2px);
        Paint paint5 = this.mCircleLinePaint;
        Paint.Style style2 = Paint.Style.STROKE;
        paint5.setStyle(style2);
        this.mCircleLinePaint.setAntiAlias(true);
        this.mCircleLinePaint.setDither(true);
        Paint paint6 = new Paint(1);
        this.mCircleLineSelectPaint = paint6;
        paint6.setColor(COLOR_CIRCLE_SELECT_LINE);
        this.mCircleLineSelectPaint.setStrokeWidth(dip2px);
        this.mCircleLineSelectPaint.setStyle(style2);
        this.mCircleLineSelectPaint.setAntiAlias(true);
        this.mCircleLineSelectPaint.setDither(true);
        Paint paint7 = new Paint(1);
        this.mTextSecondPaint = paint7;
        paint7.setColor(Color.parseColor("#666666"));
        this.mTextSecondPaint.setTextSize(DensityUtils.dip2px(getContext(), 16.0f));
        Paint paint8 = this.mTextSecondPaint;
        Paint.Align align = Paint.Align.CENTER;
        paint8.setTextAlign(align);
        this.mTextSecondPaint.setAntiAlias(true);
        this.mTextSecondPaint.setDither(true);
        Paint paint9 = new Paint(1);
        this.mTextTopPaint = paint9;
        paint9.setColor(Color.parseColor("#000000"));
        this.mTextTopPaint.setTextSize(DensityUtils.dip2px(getContext(), 22.0f));
        this.mTextTopPaint.setTextAlign(align);
        this.mTextTopPaint.setAntiAlias(true);
        this.mTextTopPaint.setDither(true);
    }

    private void drawCircleLine(Canvas canvas) {
        canvas.save();
        canvas.rotate(-90.0f);
        int i6 = 0;
        while (i6 < 360) {
            float f6 = this.mR;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f6 + 40.0f, 0.0f, f6 + 40.0f + 25.0f, 0.0f, this.mCircleLinePaint);
            canvas2.rotate(6.0f);
            i6 += 6;
            canvas = canvas2;
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        canvas.drawPaint(this.mBGPaint);
        canvas.drawCircle(this.mX, this.mY, this.mR, this.mFaceRoundPaint);
        if (!TextUtils.isEmpty(this.mTipSecondText)) {
            canvas.drawText(this.mTipSecondText, this.mX, (((this.mY - this.mR) - 40.0f) - 25.0f) - 59.0f, this.mTextSecondPaint);
        }
        if (!TextUtils.isEmpty(this.mTipTopText)) {
            canvas.drawText(this.mTipTopText, this.mX, ((((this.mY - this.mR) - 40.0f) - 25.0f) - 59.0f) - 90.0f, this.mTextTopPaint);
        }
        if (this.mIsActiveLive) {
            canvas.translate(this.mX, this.mY);
            drawCircleLine(canvas);
            drawSuccessCircleLine(canvas);
        }
    }

    public static Rect getPreviewDetectRect(int i6, int i7, int i8, int i9) {
        float f6 = i6 / 2;
        float f7 = f6 - (0.33f * f6);
        float f8 = i8;
        float f9 = (i6 * 1.0f) / (f8 * 1.0f);
        mRatioX = f9;
        float f10 = i9;
        float f11 = (i7 * 1.0f) / (1.0f * f10);
        mRatioY = f11;
        float f12 = f8 / 2.0f;
        float f13 = f12 * f9;
        float f14 = f10 / 2.0f;
        float f15 = (f14 * f11) - ((f14 * f11) * 0.1f);
        if (f12 * f9 <= f7) {
            f7 = f12 * f9;
        }
        float f16 = (0.2f * f7) + f7;
        return new Rect((int) (f13 - f7), (int) (f15 - f16), (int) (f13 + f7), (int) (f15 + f16));
    }
}
