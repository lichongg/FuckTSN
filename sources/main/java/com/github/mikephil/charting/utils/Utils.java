package com.github.mikephil.charting.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.tencent.bugly.BuglyStrategy;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class Utils {
    public static final double DEG2RAD = 0.017453292519943295d;
    public static final float FDEG2RAD = 0.017453292f;
    private static int mMaximumFlingVelocity = 8000;
    private static DisplayMetrics mMetrics = null;
    private static int mMinimumFlingVelocity = 50;
    public static final double DOUBLE_EPSILON = Double.longBitsToDouble(1);
    public static final float FLOAT_EPSILON = Float.intBitsToFloat(1);
    private static Rect mCalcTextHeightRect = new Rect();
    private static Paint.FontMetrics mFontMetrics = new Paint.FontMetrics();
    private static Rect mCalcTextSizeRect = new Rect();
    private static final int[] POW_10 = {1, 10, 100, 1000, 10000, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, 1000000, 10000000, 100000000, 1000000000};
    private static ValueFormatter mDefaultValueFormatter = generateDefaultValueFormatter();
    private static Rect mDrawableBoundsCache = new Rect();
    private static Rect mDrawTextRectBuffer = new Rect();
    private static Paint.FontMetrics mFontMetricsBuffer = new Paint.FontMetrics();

    public static FSize calcTextSize(Paint paint, String str) {
        FSize fSize = FSize.getInstance(0.0f, 0.0f);
        calcTextSize(paint, str, fSize);
        return fSize;
    }

    public static void copyIntegers(List<Integer> list, int[] iArr) {
        int length = iArr.length < list.size() ? iArr.length : list.size();
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = list.get(i6).intValue();
        }
    }

    public static void copyStrings(List<String> list, String[] strArr) {
        int length = strArr.length < list.size() ? strArr.length : list.size();
        for (int i6 = 0; i6 < length; i6++) {
            strArr[i6] = list.get(i6);
        }
    }

    public static void drawMultilineText(Canvas canvas, StaticLayout staticLayout, float f6, float f7, TextPaint textPaint, MPPointF mPPointF, float f8) {
        float fontMetrics = textPaint.getFontMetrics(mFontMetricsBuffer);
        float width = staticLayout.getWidth();
        float lineCount = staticLayout.getLineCount() * fontMetrics;
        float f9 = 0.0f - mDrawTextRectBuffer.left;
        float f10 = lineCount + 0.0f;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f8 != 0.0f) {
            float f11 = f9 - (width * 0.5f);
            float f12 = f10 - (lineCount * 0.5f);
            if (mPPointF.f32565x != 0.5f || mPPointF.f32566y != 0.5f) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(width, lineCount, f8);
                f6 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.f32565x - 0.5f);
                f7 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.f32566y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f6, f7);
            canvas.rotate(f8);
            canvas.translate(f11, f12);
            staticLayout.draw(canvas);
            canvas.restore();
        } else {
            float f13 = mPPointF.f32565x;
            if (f13 != 0.0f || mPPointF.f32566y != 0.0f) {
                f9 -= width * f13;
                f10 -= lineCount * mPPointF.f32566y;
            }
            canvas.save();
            canvas.translate(f9 + f6, f10 + f7);
            staticLayout.draw(canvas);
            canvas.restore();
        }
        textPaint.setTextAlign(textAlign);
    }

    public static String formatNumber(float f6, int i6, boolean z5) {
        return formatNumber(f6, i6, z5, '.');
    }

    public static int getDecimals(float f6) {
        float roundToNextSignificant = roundToNextSignificant(f6);
        if (Float.isInfinite(roundToNextSignificant)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10(roundToNextSignificant))) + 2;
    }

    public static float getLineHeight(Paint paint) {
        return getLineHeight(paint, mFontMetrics);
    }

    public static float getLineSpacing(Paint paint) {
        return getLineSpacing(paint, mFontMetrics);
    }

    public static float getNormalizedAngle(float f6) {
        while (f6 < 0.0f) {
            f6 += 360.0f;
        }
        return f6 % 360.0f;
    }

    public static MPPointF getPosition(MPPointF mPPointF, float f6, float f7) {
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(mPPointF, f6, f7, mPPointF2);
        return mPPointF2;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(FSize fSize, float f6) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f6 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(FSize fSize, float f6) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f6);
    }

    public static void init(Context context) {
        if (context == null) {
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            mMetrics = context.getResources().getDisplayMetrics();
        }
    }

    public static int calcTextHeight(Paint paint, String str) {
        Rect rect = mCalcTextHeightRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static float convertDpToPixel(float f6) {
        DisplayMetrics displayMetrics = mMetrics;
        return displayMetrics == null ? f6 : f6 * displayMetrics.density;
    }

    public static float convertPixelsToDp(float f6) {
        DisplayMetrics displayMetrics = mMetrics;
        return displayMetrics == null ? f6 : f6 / displayMetrics.density;
    }

    public static void drawXAxisValue(Canvas canvas, String str, float f6, float f7, Paint paint, MPPointF mPPointF, float f8) {
        float fontMetrics = paint.getFontMetrics(mFontMetricsBuffer);
        paint.getTextBounds(str, 0, str.length(), mDrawTextRectBuffer);
        float f9 = 0.0f - mDrawTextRectBuffer.left;
        float f10 = (-mFontMetricsBuffer.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f8 != 0.0f) {
            float width = f9 - (mDrawTextRectBuffer.width() * 0.5f);
            float f11 = f10 - (fontMetrics * 0.5f);
            if (mPPointF.f32565x != 0.5f || mPPointF.f32566y != 0.5f) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(mDrawTextRectBuffer.width(), fontMetrics, f8);
                f6 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.f32565x - 0.5f);
                f7 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.f32566y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f6, f7);
            canvas.rotate(f8);
            canvas.drawText(str, width, f11, paint);
            canvas.restore();
        } else {
            if (mPPointF.f32565x != 0.0f || mPPointF.f32566y != 0.0f) {
                f9 -= mDrawTextRectBuffer.width() * mPPointF.f32565x;
                f10 -= fontMetrics * mPPointF.f32566y;
            }
            canvas.drawText(str, f9 + f6, f10 + f7, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static String formatNumber(float f6, int i6, boolean z5, char c6) {
        boolean z6;
        float f7 = f6;
        int i7 = 35;
        char[] cArr = new char[35];
        if (f7 == 0.0f) {
            return "0";
        }
        int i8 = 0;
        boolean z7 = f7 < 1.0f && f7 > -1.0f;
        if (f7 < 0.0f) {
            f7 = -f7;
            z6 = true;
        } else {
            z6 = false;
        }
        int[] iArr = POW_10;
        int length = i6 > iArr.length ? iArr.length - 1 : i6;
        long round = Math.round(f7 * iArr[length]);
        int i9 = 34;
        boolean z8 = false;
        while (true) {
            if (round == 0 && i8 >= length + 1) {
                break;
            }
            char[] cArr2 = cArr;
            int i10 = (int) (round % 10);
            round /= 10;
            int i11 = i9 - 1;
            cArr2[i9] = (char) (i10 + 48);
            int i12 = i8 + 1;
            if (i12 == length) {
                i9 -= 2;
                cArr2[i11] = StringUtil.COMMA;
                i8 += 2;
                z8 = true;
            } else {
                if (z5 && round != 0 && i12 > length) {
                    if (z8) {
                        if ((i12 - length) % 4 == 0) {
                            i9 -= 2;
                            cArr2[i11] = c6;
                            i8 += 2;
                        }
                    } else if ((i12 - length) % 4 == 3) {
                        i9 -= 2;
                        cArr2[i11] = c6;
                        i8 += 2;
                    }
                }
                i9 = i11;
                i8 = i12;
            }
            cArr = cArr2;
            i7 = 35;
        }
        if (z7) {
            cArr[i9] = '0';
            i8++;
            i9--;
        }
        if (z6) {
            cArr[i9] = '-';
            i8++;
        }
        int i13 = i7 - i8;
        return String.valueOf(cArr, i13, 35 - i13);
    }

    private static ValueFormatter generateDefaultValueFormatter() {
        return new DefaultValueFormatter(1);
    }

    public static ValueFormatter getDefaultValueFormatter() {
        return mDefaultValueFormatter;
    }

    public static float getLineHeight(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getLineSpacing(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int getMaximumFlingVelocity() {
        return mMaximumFlingVelocity;
    }

    public static int getMinimumFlingVelocity() {
        return mMinimumFlingVelocity;
    }

    public static int getSDKInt() {
        return Build.VERSION.SDK_INT;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float f6, float f7, float f8) {
        return getSizeOfRotatedRectangleByRadians(f6, f7, f8 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(float f6, float f7, float f8) {
        double d6 = f8;
        return FSize.getInstance(Math.abs(((float) Math.cos(d6)) * f6) + Math.abs(((float) Math.sin(d6)) * f7), Math.abs(f6 * ((float) Math.sin(d6))) + Math.abs(f7 * ((float) Math.cos(d6))));
    }

    public static double nextUp(double d6) {
        if (d6 == Double.POSITIVE_INFINITY) {
            return d6;
        }
        double d7 = d6 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d7) + (d7 >= 0.0d ? 1L : -1L));
    }

    public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i6 = 0; i6 < pointerCount; i6++) {
            if (i6 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i6);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static void calcTextSize(Paint paint, String str, FSize fSize) {
        Rect rect = mCalcTextSizeRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.width = rect.width();
        fSize.height = rect.height();
    }

    public static int calcTextWidth(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static int[] convertIntegers(List<Integer> list) {
        int[] iArr = new int[list.size()];
        copyIntegers(list, iArr);
        return iArr;
    }

    public static String[] convertStrings(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i6 = 0; i6 < size; i6++) {
            strArr[i6] = list.get(i6);
        }
        return strArr;
    }

    public static void drawImage(Canvas canvas, Drawable drawable, int i6, int i7, int i8, int i9) {
        MPPointF mPPointF = MPPointF.getInstance();
        mPPointF.f32565x = i6 - (i8 / 2);
        mPPointF.f32566y = i7 - (i9 / 2);
        drawable.copyBounds(mDrawableBoundsCache);
        Rect rect = mDrawableBoundsCache;
        int i10 = rect.left;
        int i11 = rect.top;
        drawable.setBounds(i10, i11, i10 + i8, i8 + i11);
        int save = canvas.save();
        canvas.translate(mPPointF.f32565x, mPPointF.f32566y);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void getPosition(MPPointF mPPointF, float f6, float f7, MPPointF mPPointF2) {
        double d6 = f6;
        double d7 = f7;
        mPPointF2.f32565x = (float) (mPPointF.f32565x + (Math.cos(Math.toRadians(d7)) * d6));
        mPPointF2.f32566y = (float) (mPPointF.f32566y + (d6 * Math.sin(Math.toRadians(d7))));
    }

    @SuppressLint({"NewApi"})
    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    public static float roundToNextSignificant(double d6) {
        double d7;
        if (!Double.isInfinite(d6) && !Double.isNaN(d6) && d6 != 0.0d) {
            if (d6 < 0.0d) {
                d7 = -d6;
            } else {
                d7 = d6;
            }
            return Math.round(d6 * r0) / ((float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d7)))));
        }
        return 0.0f;
    }

    @Deprecated
    public static void init(Resources resources) {
        mMetrics = resources.getDisplayMetrics();
        mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static void drawMultilineText(Canvas canvas, String str, float f6, float f7, TextPaint textPaint, FSize fSize, MPPointF mPPointF, float f8) {
        drawMultilineText(canvas, new StaticLayout(str, 0, str.length(), textPaint, (int) Math.max(Math.ceil(fSize.width), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), f6, f7, textPaint, mPPointF, f8);
    }
}
