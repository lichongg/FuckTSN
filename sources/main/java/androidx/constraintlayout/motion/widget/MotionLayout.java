package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private DecelerateInterpolator mDecelerateLogic;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, MotionController> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private KeyCache mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    private View mRegionView;
    MotionScene mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private ArrayList<TransitionListener> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class DecelerateInterpolator extends MotionInterpolator {
        float maxA;
        float initalV = 0.0f;
        float currentP = 0.0f;

        DecelerateInterpolator() {
        }

        public void config(float f6, float f7, float f8) {
            this.initalV = f6;
            this.currentP = f7;
            this.maxA = f8;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7;
            float f8;
            float f9 = this.initalV;
            if (f9 > 0.0f) {
                float f10 = this.maxA;
                if (f9 / f10 < f6) {
                    f6 = f9 / f10;
                }
                MotionLayout.this.mLastVelocity = f9 - (f10 * f6);
                f7 = (f9 * f6) - (((f10 * f6) * f6) / 2.0f);
                f8 = this.currentP;
            } else {
                float f11 = this.maxA;
                if ((-f9) / f11 < f6) {
                    f6 = (-f9) / f11;
                }
                MotionLayout.this.mLastVelocity = (f11 * f6) + f9;
                f7 = (f9 * f6) + (((f11 * f6) * f6) / 2.0f);
                f8 = this.currentP;
            }
            return f7 + f8;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        DashPathEffect mDashPathEffect;
        Paint mFillPaint;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        private float[] mRectangle;
        int mShadowTranslate;
        Paint mTextPaint;
        final int RED_COLOR = -21965;
        final int KEYFRAME_COLOR = -2067046;
        final int GRAPH_COLOR = -13391360;
        final int SHADOW_COLOR = 1996488704;
        final int DIAMOND_SIZE = 10;
        Rect mBounds = new Rect();
        boolean mPresentationMode = false;

        private void drawPathAsConfigured(Canvas canvas) {
            boolean z5 = false;
            boolean z6 = false;
            for (int i6 = 0; i6 < this.mKeyFrameCount; i6++) {
                int i7 = this.mPathMode[i6];
                if (i7 == 1) {
                    z5 = true;
                }
                if (i7 == 2) {
                    z6 = true;
                }
            }
            if (z5) {
                drawPathRelative(canvas);
            }
            if (z6) {
                drawPathCartesian(canvas);
            }
        }

        public void drawAll(Canvas canvas, int i6, int i7, MotionController motionController) {
            if (i6 == 4) {
                drawPathAsConfigured(canvas);
            }
            if (i6 == 2) {
                drawPathRelative(canvas);
            }
            if (i6 == 3) {
                drawPathCartesian(canvas);
            }
            drawBasicPath(canvas);
            drawTicks(canvas, i6, i7, motionController);
        }

        public DevModeDraw() {
            this.mShadowTranslate = 1;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            Paint paint2 = this.mPaint;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.mPaintKeyframes = paint3;
            paint3.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(style);
            Paint paint4 = new Paint();
            this.mPaintGraph = paint4;
            paint4.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(style);
            Paint paint5 = new Paint();
            this.mTextPaint = paint5;
            paint5.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint paint6 = new Paint();
            this.mFillPaint = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            canvas.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathCartesian(Canvas canvas) {
            float[] fArr = this.mPoints;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[fArr.length - 2];
            float f9 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f6, f8), Math.max(f7, f9), Math.max(f6, f8), Math.max(f7, f9), this.mPaintGraph);
            canvas.drawLine(Math.min(f6, f8), Math.min(f7, f9), Math.min(f6, f8), Math.max(f7, f9), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas canvas, float f6, float f7) {
            float[] fArr = this.mPoints;
            float f8 = fArr[0];
            float f9 = fArr[1];
            float f10 = fArr[fArr.length - 2];
            float f11 = fArr[fArr.length - 1];
            float min = Math.min(f8, f10);
            float max = Math.max(f9, f11);
            float min2 = f6 - Math.min(f8, f10);
            float max2 = Math.max(f9, f11) - f7;
            String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f10 - f8)) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((min2 / 2.0f) - (this.mBounds.width() / 2)) + min, f7 - 20.0f, this.mTextPaint);
            canvas.drawLine(f6, f7, Math.min(f8, f10), f7, this.mPaintGraph);
            String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f11 - f9)) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, f6 + 5.0f, max - ((max2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f6, f7, f6, Math.max(f9, f11), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas canvas) {
            float[] fArr = this.mPoints;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas canvas, float f6, float f7) {
            float[] fArr = this.mPoints;
            float f8 = fArr[0];
            float f9 = fArr[1];
            float f10 = fArr[fArr.length - 2];
            float f11 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f8 - f10, f9 - f11);
            float f12 = f10 - f8;
            float f13 = f11 - f9;
            float f14 = (((f6 - f8) * f12) + ((f7 - f9) * f13)) / (hypot * hypot);
            float f15 = f8 + (f12 * f14);
            float f16 = f9 + (f14 * f13);
            Path path = new Path();
            path.moveTo(f6, f7);
            path.lineTo(f15, f16);
            float hypot2 = (float) Math.hypot(f15 - f6, f16 - f7);
            String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            canvas.drawLine(f6, f7, f15, f16, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas canvas, float f6, float f7, int i6, int i7) {
            String str = "" + (((int) ((((f6 - (i6 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i6)) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((f6 / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, f7 - 20.0f, this.mTextPaint);
            canvas.drawLine(f6, f7, Math.min(0.0f, 1.0f), f7, this.mPaintGraph);
            String str2 = "" + (((int) ((((f7 - (i7 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i7)) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, 5.0f + f6, 0.0f - ((f7 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f6, f7, f6, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            this.mPath.reset();
            for (int i6 = 0; i6 <= 50; i6++) {
                motionController.buildRect(i6 / 50, this.mRectangle, 0);
                Path path = this.mPath;
                float[] fArr = this.mRectangle;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.mPath;
                float[] fArr2 = this.mRectangle;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.mPath;
                float[] fArr3 = this.mRectangle;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.mPath;
                float[] fArr4 = this.mRectangle;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.mPath.close();
            }
            this.mPaint.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.translate(-2.0f, -2.0f);
            this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas canvas, int i6, int i7, MotionController motionController) {
            int i8;
            int i9;
            View view = motionController.mView;
            if (view != null) {
                i8 = view.getWidth();
                i9 = motionController.mView.getHeight();
            } else {
                i8 = 0;
                i9 = 0;
            }
            for (int i10 = 1; i10 < i7 - 1; i10++) {
                if (i6 != 4 || this.mPathMode[i10 - 1] != 0) {
                    float[] fArr = this.mKeyFramePoints;
                    int i11 = i10 * 2;
                    float f6 = fArr[i11];
                    float f7 = fArr[i11 + 1];
                    this.mPath.reset();
                    this.mPath.moveTo(f6, f7 + 10.0f);
                    this.mPath.lineTo(f6 + 10.0f, f7);
                    this.mPath.lineTo(f6, f7 - 10.0f);
                    this.mPath.lineTo(f6 - 10.0f, f7);
                    this.mPath.close();
                    int i12 = i10 - 1;
                    motionController.getKeyFrame(i12);
                    if (i6 == 4) {
                        int i13 = this.mPathMode[i12];
                        if (i13 == 1) {
                            drawPathRelativeTicks(canvas, f6 - 0.0f, f7 - 0.0f);
                        } else if (i13 == 2) {
                            drawPathCartesianTicks(canvas, f6 - 0.0f, f7 - 0.0f);
                        } else if (i13 == 3) {
                            drawPathScreenTicks(canvas, f6 - 0.0f, f7 - 0.0f, i8, i9);
                        }
                        canvas.drawPath(this.mPath, this.mFillPaint);
                    }
                    if (i6 == 2) {
                        drawPathRelativeTicks(canvas, f6 - 0.0f, f7 - 0.0f);
                    }
                    if (i6 == 3) {
                        drawPathCartesianTicks(canvas, f6 - 0.0f, f7 - 0.0f);
                    }
                    if (i6 == 6) {
                        drawPathScreenTicks(canvas, f6 - 0.0f, f7 - 0.0f, i8, i9);
                    }
                    canvas.drawPath(this.mPath, this.mFillPaint);
                }
            }
            float[] fArr2 = this.mPoints;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                float[] fArr3 = this.mPoints;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        private void drawTranslation(Canvas canvas, float f6, float f7, float f8, float f9) {
            canvas.drawRect(f6, f7, f8, f9, this.mPaintGraph);
            canvas.drawLine(f6, f7, f8, f9, this.mPaintGraph);
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> hashMap, int i6, int i7) {
            if (hashMap == null || hashMap.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i7 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.mTextPaint);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.mPaint);
            }
            for (MotionController motionController : hashMap.values()) {
                int drawPath = motionController.getDrawPath();
                if (i7 > 0 && drawPath == 0) {
                    drawPath = 1;
                }
                if (drawPath != 0) {
                    this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                    if (drawPath >= 1) {
                        int i8 = i6 / 16;
                        float[] fArr = this.mPoints;
                        if (fArr == null || fArr.length != i8 * 2) {
                            this.mPoints = new float[i8 * 2];
                            this.mPath = new Path();
                        }
                        int i9 = this.mShadowTranslate;
                        canvas.translate(i9, i9);
                        this.mPaint.setColor(1996488704);
                        this.mFillPaint.setColor(1996488704);
                        this.mPaintKeyframes.setColor(1996488704);
                        this.mPaintGraph.setColor(1996488704);
                        motionController.buildPath(this.mPoints, i8);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        this.mPaint.setColor(-21965);
                        this.mPaintKeyframes.setColor(-2067046);
                        this.mFillPaint.setColor(-2067046);
                        this.mPaintGraph.setColor(-13391360);
                        int i10 = this.mShadowTranslate;
                        canvas.translate(-i10, -i10);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        if (drawPath == 5) {
                            drawRectangle(canvas, motionController);
                        }
                    }
                }
            }
            canvas.restore();
        }

        void getTextBounds(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.mBounds);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class Model {
        int mEndId;
        int mStartId;
        ConstraintWidgetContainer mLayoutStart = new ConstraintWidgetContainer();
        ConstraintWidgetContainer mLayoutEnd = new ConstraintWidgetContainer();
        ConstraintSet mStart = null;
        ConstraintSet mEnd = null;

        Model() {
        }

        private void debugLayoutParam(String str, ConstraintLayout.LayoutParams layoutParams) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            sb.append(layoutParams.startToStart != -1 ? "SS" : "__");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(layoutParams.startToEnd != -1 ? "|SE" : "|__");
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(layoutParams.endToStart != -1 ? "|ES" : "|__");
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            sb7.append(layoutParams.endToEnd != -1 ? "|EE" : "|__");
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(sb8);
            sb9.append(layoutParams.leftToLeft != -1 ? "|LL" : "|__");
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            sb11.append(layoutParams.leftToRight != -1 ? "|LR" : "|__");
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(sb12);
            sb13.append(layoutParams.rightToLeft != -1 ? "|RL" : "|__");
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(sb14);
            sb15.append(layoutParams.rightToRight != -1 ? "|RR" : "|__");
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(sb16);
            sb17.append(layoutParams.topToTop != -1 ? "|TT" : "|__");
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(sb18);
            sb19.append(layoutParams.topToBottom != -1 ? "|TB" : "|__");
            String sb20 = sb19.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append(sb20);
            sb21.append(layoutParams.bottomToTop != -1 ? "|BT" : "|__");
            String sb22 = sb21.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append(sb22);
            sb23.append(layoutParams.bottomToBottom != -1 ? "|BB" : "|__");
        }

        private void debugWidget(String str, ConstraintWidget constraintWidget) {
            String str2;
            String str3;
            String str4;
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            String str5 = "__";
            if (constraintWidget.mTop.mTarget != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ExifInterface.GPS_DIRECTION_TRUE);
                sb2.append(constraintWidget.mTop.mTarget.mType == ConstraintAnchor.Type.TOP ? ExifInterface.GPS_DIRECTION_TRUE : "B");
                str2 = sb2.toString();
            } else {
                str2 = "__";
            }
            sb.append(str2);
            String sb3 = sb.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            if (constraintWidget.mBottom.mTarget != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("B");
                sb5.append(constraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP ? ExifInterface.GPS_DIRECTION_TRUE : "B");
                str3 = sb5.toString();
            } else {
                str3 = "__";
            }
            sb4.append(str3);
            String sb6 = sb4.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            if (constraintWidget.mLeft.mTarget != null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("L");
                sb8.append(constraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT ? "L" : "R");
                str4 = sb8.toString();
            } else {
                str4 = "__";
            }
            sb7.append(str4);
            String sb9 = sb7.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(sb9);
            if (constraintWidget.mRight.mTarget != null) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append("R");
                sb11.append(constraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT ? "L" : "R");
                str5 = sb11.toString();
            }
            sb10.append(str5);
            constraintWidget.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            Iterator<ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.getCompanionWidget()).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.getChildren().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                next2.setWidth(constraintSet.getWidth(view.getId()));
                next2.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    next2.setVisibility(view.getVisibility());
                } else {
                    next2.setVisibility(constraintSet.getVisibility(view.getId()));
                }
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.getChildren().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof VirtualLayout) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) next3.getCompanionWidget();
                    Helper helper = (Helper) next3;
                    constraintHelper.updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }

        public void build() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.mFrameArrayList.clear();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = MotionLayout.this.getChildAt(i6);
                MotionLayout.this.mFrameArrayList.put(childAt, new MotionController(childAt));
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt2 = MotionLayout.this.getChildAt(i7);
                MotionController motionController = MotionLayout.this.mFrameArrayList.get(childAt2);
                if (motionController != null) {
                    if (this.mStart != null) {
                        ConstraintWidget widget = getWidget(this.mLayoutStart, childAt2);
                        if (widget != null) {
                            motionController.setStartState(widget, this.mStart);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Debug.getLocation();
                            Debug.getName(childAt2);
                            childAt2.getClass();
                        }
                    }
                    if (this.mEnd != null) {
                        ConstraintWidget widget2 = getWidget(this.mLayoutEnd, childAt2);
                        if (widget2 != null) {
                            motionController.setEndState(widget2, this.mEnd);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Debug.getLocation();
                            Debug.getName(childAt2);
                            childAt2.getClass();
                        }
                    }
                }
            }
        }

        void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.mStart = constraintSet;
            this.mEnd = constraintSet2;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(((ConstraintLayout) MotionLayout.this).mLayoutWidget.getMeasurer());
            this.mLayoutEnd.setMeasurer(((ConstraintLayout) MotionLayout.this).mLayoutWidget.getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.mLayoutStart);
            copy(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.mLayoutEnd);
            if (MotionLayout.this.mTransitionLastPosition > 0.5d) {
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            } else {
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
            }
            this.mLayoutStart.setRtl(MotionLayout.this.isRtl());
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.this.isRtl());
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    this.mLayoutEnd.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
        }

        public boolean isNotConfiguredWith(int i6, int i7) {
            return (i6 == this.mStartId && i7 == this.mEndId) ? false : true;
        }

        public void reEvaluateState() {
            measure(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int i6, int i7) {
            this.mStartId = i6;
            this.mEndId = i7;
        }

        private void debugLayout(String str, ConstraintWidgetContainer constraintWidgetContainer) {
            String str2;
            String str3;
            String str4;
            String str5 = str + " " + Debug.getName((View) constraintWidgetContainer.getCompanionWidget());
            constraintWidgetContainer.toString();
            int size = constraintWidgetContainer.getChildren().size();
            for (int i6 = 0; i6 < size; i6++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append("[");
                sb.append(i6);
                sb.append("] ");
                ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i6);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                String str6 = "_";
                if (constraintWidget.mTop.mTarget == null) {
                    str2 = "_";
                } else {
                    str2 = ExifInterface.GPS_DIRECTION_TRUE;
                }
                sb2.append(str2);
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb3);
                if (constraintWidget.mBottom.mTarget == null) {
                    str3 = "_";
                } else {
                    str3 = "B";
                }
                sb4.append(str3);
                String sb5 = sb4.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(sb5);
                if (constraintWidget.mLeft.mTarget == null) {
                    str4 = "_";
                } else {
                    str4 = "L";
                }
                sb6.append(str4);
                String sb7 = sb6.toString();
                StringBuilder sb8 = new StringBuilder();
                sb8.append(sb7);
                if (constraintWidget.mRight.mTarget != null) {
                    str6 = "R";
                }
                sb8.append(str6);
                View view = (View) constraintWidget.getCompanionWidget();
                String name = Debug.getName(view);
                if (view instanceof TextView) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(name);
                    sb9.append("(");
                    sb9.append((Object) ((TextView) view).getText());
                    sb9.append(")");
                }
                constraintWidget.toString();
            }
        }

        void copy(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = children.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                    constraintWidget = new androidx.constraintlayout.solver.widgets.Barrier();
                } else if (next instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (next instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (next instanceof Helper) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.add(constraintWidget);
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = children.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                hashMap.get(next2).copy(next2, hashMap);
            }
        }

        ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget = children.get(i6);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void measure(int i6, int i7) {
            boolean z5;
            boolean z6;
            int mode = View.MeasureSpec.getMode(i6);
            int mode2 = View.MeasureSpec.getMode(i7);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            MotionLayout motionLayout2 = MotionLayout.this;
            if (motionLayout2.mCurrentState == motionLayout2.getStartState()) {
                MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i6, i7);
                if (this.mStart != null) {
                    MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i6, i7);
                }
            } else {
                if (this.mStart != null) {
                    MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i6, i7);
                }
                MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i6, i7);
            }
            boolean z7 = true;
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                MotionLayout motionLayout3 = MotionLayout.this;
                motionLayout3.mWidthMeasureMode = mode;
                motionLayout3.mHeightMeasureMode = mode2;
                if (motionLayout3.mCurrentState == motionLayout3.getStartState()) {
                    MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i6, i7);
                    if (this.mStart != null) {
                        MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i6, i7);
                    }
                } else {
                    if (this.mStart != null) {
                        MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i6, i7);
                    }
                    MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i6, i7);
                }
                MotionLayout.this.mStartWrapWidth = this.mLayoutStart.getWidth();
                MotionLayout.this.mStartWrapHeight = this.mLayoutStart.getHeight();
                MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.getWidth();
                MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.getHeight();
                MotionLayout motionLayout4 = MotionLayout.this;
                if (motionLayout4.mStartWrapWidth == motionLayout4.mEndWrapWidth && motionLayout4.mStartWrapHeight == motionLayout4.mEndWrapHeight) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                motionLayout4.mMeasureDuringTransition = z5;
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            int i8 = motionLayout5.mStartWrapWidth;
            int i9 = motionLayout5.mStartWrapHeight;
            int i10 = motionLayout5.mWidthMeasureMode;
            if (i10 == Integer.MIN_VALUE || i10 == 0) {
                i8 = (int) (i8 + (motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapWidth - i8)));
            }
            int i11 = motionLayout5.mHeightMeasureMode;
            if (i11 == Integer.MIN_VALUE || i11 == 0) {
                i9 = (int) (i9 + (motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapHeight - i9)));
            }
            if (!this.mLayoutStart.isWidthMeasuredTooSmall() && !this.mLayoutEnd.isWidthMeasuredTooSmall()) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (!this.mLayoutStart.isHeightMeasuredTooSmall() && !this.mLayoutEnd.isHeightMeasuredTooSmall()) {
                z7 = false;
            }
            MotionLayout.this.resolveMeasuredDimension(i6, i7, i8, i9, z6, z7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i6);

        void computeCurrentVelocity(int i6, float f6);

        float getXVelocity();

        float getXVelocity(int i6);

        float getYVelocity();

        float getYVelocity(int i6);

        void recycle();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class MyTracker implements MotionTracker {
        private static MyTracker me = new MyTracker();
        VelocityTracker tracker;

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i6) {
            this.tracker.computeCurrentVelocity(i6);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            return this.tracker.getXVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            return this.tracker.getYVelocity();
        }

        public static MyTracker obtain() {
            me.tracker = VelocityTracker.obtain();
            return me;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            this.tracker.clear();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i6, float f6) {
            this.tracker.computeCurrentVelocity(i6, f6);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int i6) {
            return this.tracker.getXVelocity(i6);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int i6) {
            return getYVelocity(i6);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            this.tracker.recycle();
            this.tracker = null;
        }

        private MyTracker() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class StateCache {
        float mProgress = Float.NaN;
        float mVelocity = Float.NaN;
        int startState = -1;
        int endState = -1;
        final String KeyProgress = "motion.progress";
        final String KeyVelocity = "motion.velocity";
        final String KeyStartState = "motion.StartState";
        final String KeyEndState = "motion.EndState";

        StateCache() {
        }

        void apply() {
            int i6 = this.startState;
            if (i6 != -1 || this.endState != -1) {
                if (i6 == -1) {
                    MotionLayout.this.transitionToState(this.endState);
                } else {
                    int i7 = this.endState;
                    if (i7 == -1) {
                        MotionLayout.this.setState(i6, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i6, i7);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.mVelocity)) {
                if (Float.isNaN(this.mProgress)) {
                    return;
                }
                MotionLayout.this.setProgress(this.mProgress);
            } else {
                MotionLayout.this.setProgress(this.mProgress, this.mVelocity);
                this.mProgress = Float.NaN;
                this.mVelocity = Float.NaN;
                this.startState = -1;
                this.endState = -1;
            }
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.mProgress);
            bundle.putFloat("motion.velocity", this.mVelocity);
            bundle.putInt("motion.StartState", this.startState);
            bundle.putInt("motion.EndState", this.endState);
            return bundle;
        }

        public void recordState() {
            this.endState = MotionLayout.this.mEndState;
            this.startState = MotionLayout.this.mBeginState;
            this.mVelocity = MotionLayout.this.getVelocity();
            this.mProgress = MotionLayout.this.getProgress();
        }

        public void setEndState(int i6) {
            this.endState = i6;
        }

        public void setProgress(float f6) {
            this.mProgress = f6;
        }

        public void setStartState(int i6) {
            this.startState = i6;
        }

        public void setTransitionState(Bundle bundle) {
            this.mProgress = bundle.getFloat("motion.progress");
            this.mVelocity = bundle.getFloat("motion.velocity");
            this.startState = bundle.getInt("motion.StartState");
            this.endState = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f6) {
            this.mVelocity = f6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i6, int i7, float f6);

        void onTransitionCompleted(MotionLayout motionLayout, int i6);

        void onTransitionStarted(MotionLayout motionLayout, int i6, int i7);

        void onTransitionTrigger(MotionLayout motionLayout, int i6, boolean z5, float f6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(null);
    }

    private void checkStructure() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        int startId = motionScene.getStartId();
        MotionScene motionScene2 = this.mScene;
        checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<MotionScene.Transition> it = this.mScene.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            MotionScene.Transition next = it.next();
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            checkStructure(next);
            int startConstraintSetId = next.getStartConstraintSetId();
            int endConstraintSetId = next.getEndConstraintSetId();
            Debug.getName(getContext(), startConstraintSetId);
            Debug.getName(getContext(), endConstraintSetId);
            sparseIntArray.get(startConstraintSetId);
            sparseIntArray2.get(endConstraintSetId);
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            this.mScene.getConstraintSet(startConstraintSetId);
            this.mScene.getConstraintSet(endConstraintSetId);
        }
    }

    private void debugPos() {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            Debug.getLocation();
            Debug.getName(this);
            Debug.getName(getContext(), this.mCurrentState);
            Debug.getName(childAt);
            childAt.getLeft();
            childAt.getTop();
        }
    }

    private static boolean willJump(float f6, float f7, float f8) {
        if (f6 > 0.0f) {
            float f9 = f6 / f8;
            return f7 + ((f6 * f9) - (((f8 * f9) * f9) / 2.0f)) > 1.0f;
        }
        float f10 = (-f6) / f8;
        return f7 + ((f6 * f10) + (((f8 * f10) * f10) / 2.0f)) < 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        evaluate(false);
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
            this.mFrames++;
            long nanoTime = getNanoTime();
            long j6 = this.mLastDrawTime;
            if (j6 != -1) {
                if (nanoTime - j6 > 200000000) {
                    this.mLastFps = ((int) ((this.mFrames / (r5 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                    this.mLastDrawTime = nanoTime;
                }
            } else {
                this.mLastDrawTime = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            String str = this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(Debug.getState(this, this.mEndState));
            sb.append(" (progress: ");
            sb.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb.append(" ) state=");
            int i6 = this.mCurrentState;
            sb.append(i6 == -1 ? "undefined" : Debug.getState(this, i6));
            String sb2 = sb.toString();
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawText(sb2, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb2, 10.0f, getHeight() - 30, paint);
        }
        if (this.mDebugPath > 1) {
            if (this.mDevModeDraw == null) {
                this.mDevModeDraw = new DevModeDraw();
            }
            this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        MotionLayout motionLayout;
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z5, i6, i7, i8, i9);
                this.mInLayout = false;
                return;
            }
            motionLayout = this;
            int i10 = i8 - i6;
            int i11 = i9 - i7;
            try {
                if (motionLayout.mLastLayoutWidth == i10) {
                    if (motionLayout.mLastLayoutHeight != i11) {
                    }
                    motionLayout.mLastLayoutWidth = i10;
                    motionLayout.mLastLayoutHeight = i11;
                    motionLayout.mOldWidth = i10;
                    motionLayout.mOldHeight = i11;
                    motionLayout.mInLayout = false;
                }
                rebuildScene();
                evaluate(true);
                motionLayout.mLastLayoutWidth = i10;
                motionLayout.mLastLayoutHeight = i11;
                motionLayout.mOldWidth = i10;
                motionLayout.mOldHeight = i11;
                motionLayout.mInLayout = false;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                motionLayout.mInLayout = false;
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            motionLayout = this;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f6, float f7, boolean z5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f6, float f7) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i6, int i7, int i8, int i9, int i10) {
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void parseLayoutDescription(int i6) {
        this.mConstraintLayoutSpec = null;
    }

    public void setProgress(float f6, float f7) {
        if (isAttachedToWindow()) {
            setProgress(f6);
            setState(TransitionState.MOVING);
            this.mLastVelocity = f7;
            animateTo(1.0f);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setProgress(f6);
        this.mStateCache.setVelocity(f7);
    }

    void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.mCurrentState == -1) {
            return;
        }
        TransitionState transitionState3 = this.mTransitionState;
        this.mTransitionState = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            fireTransitionChange();
        }
        int i6 = AnonymousClass2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[transitionState3.ordinal()];
        if (i6 != 1 && i6 != 2) {
            if (i6 == 3 && transitionState == transitionState2) {
                fireTransitionCompleted();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            fireTransitionChange();
        }
        if (transitionState == transitionState2) {
            fireTransitionCompleted();
        }
    }

    public void setTransition(int i6, int i7) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i6);
            this.mStateCache.setEndState(i7);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mBeginState = i6;
            this.mEndState = i7;
            motionScene.setTransition(i6, i7);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(i6), this.mScene.getConstraintSet(i7));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i6) {
        if (isAttachedToWindow()) {
            transitionToState(i6, -1, -1);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setEndState(i6);
    }

    public void updateState(int i6, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(i6, constraintSet);
        }
        updateState();
        if (this.mCurrentState == i6) {
            constraintSet.applyTo(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;

        static {
            int[] iArr = new int[TransitionState.values().length];
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void evaluateLayout() {
        boolean z5;
        float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        float f6 = this.mTransitionLastPosition + (!(interpolator instanceof StopLogic) ? (((nanoTime - this.mTransitionLastTime) * signum) * 1.0E-9f) / this.mTransitionDuration : 0.0f);
        if (this.mTransitionInstantly) {
            f6 = this.mTransitionGoalPosition;
        }
        if ((signum <= 0.0f || f6 < this.mTransitionGoalPosition) && (signum > 0.0f || f6 > this.mTransitionGoalPosition)) {
            z5 = false;
        } else {
            f6 = this.mTransitionGoalPosition;
            z5 = true;
        }
        if (interpolator != null && !z5) {
            f6 = this.mTemporalInterpolator ? interpolator.getInterpolation((nanoTime - this.mAnimationStartTime) * 1.0E-9f) : interpolator.getInterpolation(f6);
        }
        if ((signum > 0.0f && f6 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f6 <= this.mTransitionGoalPosition)) {
            f6 = this.mTransitionGoalPosition;
        }
        float f7 = f6;
        this.mPostInterpolationPosition = f7;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.interpolate(childAt, f7, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        ArrayList<TransitionListener> arrayList;
        if ((this.mTransitionListener == null && ((arrayList = this.mTransitionListeners) == null || arrayList.isEmpty())) || this.mListenerPosition == this.mTransitionPosition) {
            return;
        }
        if (this.mListenerState != -1) {
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
            }
            ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
            if (arrayList2 != null) {
                Iterator<TransitionListener> it = arrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
            }
            this.mIsAnimating = true;
        }
        this.mListenerState = -1;
        float f6 = this.mTransitionPosition;
        this.mListenerPosition = f6;
        TransitionListener transitionListener2 = this.mTransitionListener;
        if (transitionListener2 != null) {
            transitionListener2.onTransitionChange(this, this.mBeginState, this.mEndState, f6);
        }
        ArrayList<TransitionListener> arrayList3 = this.mTransitionListeners;
        if (arrayList3 != null) {
            Iterator<TransitionListener> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
            }
        }
        this.mIsAnimating = true;
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int i6, int i7) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, i6, i7);
        }
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(motionLayout, i6, i7);
            }
        }
    }

    private boolean handlesTouchEvent(float f6, float f7, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                if (handlesTouchEvent(view.getLeft() + f6, view.getTop() + f7, viewGroup.getChildAt(i6), motionEvent)) {
                    return true;
                }
            }
        }
        this.mBoundsCheck.set(view.getLeft() + f6, view.getTop() + f7, f6 + view.getRight(), f7 + view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    private void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        if (motionScene.autoTransition(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i6 = this.mCurrentState;
        if (i6 != -1) {
            this.mScene.addOnClickListeners(this, i6);
        }
        if (this.mScene.supportTouch()) {
            this.mScene.setupTouch();
        }
    }

    private void processTransitionCompleted() {
        ArrayList<TransitionListener> arrayList;
        if (this.mTransitionListener == null && ((arrayList = this.mTransitionListeners) == null || arrayList.isEmpty())) {
            return;
        }
        this.mIsAnimating = false;
        Iterator<Integer> it = this.mTransitionCompleted.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionCompleted(this, next.intValue());
            }
            ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
            if (arrayList2 != null) {
                Iterator<TransitionListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionCompleted(this, next.intValue());
                }
            }
        }
        this.mTransitionCompleted.clear();
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new ArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    void animateTo(float f6) {
        if (this.mScene == null) {
            return;
        }
        float f7 = this.mTransitionLastPosition;
        float f8 = this.mTransitionPosition;
        if (f7 != f8 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f8;
        }
        float f9 = this.mTransitionLastPosition;
        if (f9 == f6) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f6;
        this.mTransitionDuration = r0.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f9;
        this.mTransitionLastPosition = f9;
        invalidate();
    }

    void disableAutoTransition(boolean z5) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.disableAutoTransition(z5);
    }

    void evaluate(boolean z5) {
        float f6;
        boolean z6;
        int i6;
        float interpolation;
        boolean z7;
        if (this.mTransitionLastTime == -1) {
            this.mTransitionLastTime = getNanoTime();
        }
        float f7 = this.mTransitionLastPosition;
        if (f7 > 0.0f && f7 < 1.0f) {
            this.mCurrentState = -1;
        }
        boolean z8 = false;
        if (this.mKeepAnimating || (this.mInTransition && (z5 || this.mTransitionGoalPosition != f7))) {
            float signum = Math.signum(this.mTransitionGoalPosition - f7);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.mInterpolator;
            if (interpolator instanceof MotionInterpolator) {
                f6 = 0.0f;
            } else {
                f6 = (((nanoTime - this.mTransitionLastTime) * signum) * 1.0E-9f) / this.mTransitionDuration;
                this.mLastVelocity = f6;
            }
            float f8 = this.mTransitionLastPosition + f6;
            if (this.mTransitionInstantly) {
                f8 = this.mTransitionGoalPosition;
            }
            if ((signum <= 0.0f || f8 < this.mTransitionGoalPosition) && (signum > 0.0f || f8 > this.mTransitionGoalPosition)) {
                z6 = false;
            } else {
                f8 = this.mTransitionGoalPosition;
                this.mInTransition = false;
                z6 = true;
            }
            this.mTransitionLastPosition = f8;
            this.mTransitionPosition = f8;
            this.mTransitionLastTime = nanoTime;
            if (interpolator != null && !z6) {
                if (this.mTemporalInterpolator) {
                    interpolation = interpolator.getInterpolation((nanoTime - this.mAnimationStartTime) * 1.0E-9f);
                    this.mTransitionLastPosition = interpolation;
                    this.mTransitionLastTime = nanoTime;
                    Interpolator interpolator2 = this.mInterpolator;
                    if (interpolator2 instanceof MotionInterpolator) {
                        float velocity = ((MotionInterpolator) interpolator2).getVelocity();
                        this.mLastVelocity = velocity;
                        if (Math.abs(velocity) * this.mTransitionDuration <= EPSILON) {
                            this.mInTransition = false;
                        }
                        if (velocity > 0.0f && interpolation >= 1.0f) {
                            this.mTransitionLastPosition = 1.0f;
                            this.mInTransition = false;
                            interpolation = 1.0f;
                        }
                        if (velocity < 0.0f && interpolation <= 0.0f) {
                            this.mTransitionLastPosition = 0.0f;
                            this.mInTransition = false;
                            f8 = 0.0f;
                        }
                    }
                } else {
                    interpolation = interpolator.getInterpolation(f8);
                    Interpolator interpolator3 = this.mInterpolator;
                    if (interpolator3 instanceof MotionInterpolator) {
                        this.mLastVelocity = ((MotionInterpolator) interpolator3).getVelocity();
                    } else {
                        this.mLastVelocity = ((interpolator3.getInterpolation(f8 + f6) - interpolation) * signum) / f6;
                    }
                }
                f8 = interpolation;
            }
            if (Math.abs(this.mLastVelocity) > EPSILON) {
                setState(TransitionState.MOVING);
            }
            if ((signum > 0.0f && f8 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f8 <= this.mTransitionGoalPosition)) {
                f8 = this.mTransitionGoalPosition;
                this.mInTransition = false;
            }
            if (f8 >= 1.0f || f8 <= 0.0f) {
                this.mInTransition = false;
                setState(TransitionState.FINISHED);
            }
            int childCount = getChildCount();
            this.mKeepAnimating = false;
            long nanoTime2 = getNanoTime();
            this.mPostInterpolationPosition = f8;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                MotionController motionController = this.mFrameArrayList.get(childAt);
                if (motionController != null) {
                    this.mKeepAnimating |= motionController.interpolate(childAt, f8, nanoTime2, this.mKeyCache);
                }
            }
            boolean z9 = (signum > 0.0f && f8 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f8 <= this.mTransitionGoalPosition);
            if (!this.mKeepAnimating && !this.mInTransition && z9) {
                setState(TransitionState.FINISHED);
            }
            if (this.mMeasureDuringTransition) {
                requestLayout();
            }
            this.mKeepAnimating = (!z9) | this.mKeepAnimating;
            if (f8 <= 0.0f && (i6 = this.mBeginState) != -1 && this.mCurrentState != i6) {
                this.mCurrentState = i6;
                this.mScene.getConstraintSet(i6).applyCustomAttributes(this);
                setState(TransitionState.FINISHED);
                z8 = true;
            }
            if (f8 >= 1.0d) {
                int i8 = this.mCurrentState;
                int i9 = this.mEndState;
                if (i8 != i9) {
                    this.mCurrentState = i9;
                    this.mScene.getConstraintSet(i9).applyCustomAttributes(this);
                    setState(TransitionState.FINISHED);
                    z8 = true;
                }
            }
            if (this.mKeepAnimating || this.mInTransition) {
                invalidate();
            } else if ((signum > 0.0f && f8 == 1.0f) || (signum < 0.0f && f8 == 0.0f)) {
                setState(TransitionState.FINISHED);
            }
            if ((!this.mKeepAnimating && this.mInTransition && signum > 0.0f && f8 == 1.0f) || (signum < 0.0f && f8 == 0.0f)) {
                onNewStateAttachHandlers();
            }
        }
        float f9 = this.mTransitionLastPosition;
        if (f9 < 1.0f) {
            if (f9 <= 0.0f) {
                int i10 = this.mCurrentState;
                int i11 = this.mBeginState;
                z7 = i10 == i11 ? z8 : true;
                this.mCurrentState = i11;
            }
            this.mNeedsFireTransitionCompleted |= z8;
            if (z8 && !this.mInLayout) {
                requestLayout();
            }
            this.mTransitionPosition = this.mTransitionLastPosition;
        }
        int i12 = this.mCurrentState;
        int i13 = this.mEndState;
        z7 = i12 == i13 ? z8 : true;
        this.mCurrentState = i13;
        z8 = z7;
        this.mNeedsFireTransitionCompleted |= z8;
        if (z8) {
            requestLayout();
        }
        this.mTransitionPosition = this.mTransitionLastPosition;
    }

    protected void fireTransitionCompleted() {
        int i6;
        ArrayList<TransitionListener> arrayList;
        if ((this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (this.mTransitionCompleted.isEmpty()) {
                i6 = -1;
            } else {
                i6 = this.mTransitionCompleted.get(r0.size() - 1).intValue();
            }
            int i7 = this.mCurrentState;
            if (i6 != i7 && i7 != -1) {
                this.mTransitionCompleted.add(Integer.valueOf(i7));
            }
        }
        processTransitionCompleted();
    }

    public void fireTrigger(int i6, boolean z5, float f6) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i6, z5, f6);
        }
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i6, z5, f6);
            }
        }
    }

    void getAnchorDpDt(int i6, float f6, float f7, float f8, float[] fArr) {
        HashMap<View, MotionController> hashMap = this.mFrameArrayList;
        View viewById = getViewById(i6);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f6, f7, f8, fArr);
            float y5 = viewById.getY();
            this.lastPos = f6;
            this.lastY = y5;
            return;
        }
        if (viewById != null) {
            viewById.getContext().getResources().getResourceName(i6);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i6);
    }

    public ConstraintSet getConstraintSet(int i6) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i6);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    String getConstraintSetNames(int i6) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i6);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean z5) {
        this.mDebugPath = z5 ? 2 : 1;
        invalidate();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int i6) {
        return this.mScene.getTransitionById(i6);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        if (this.mScene != null) {
            this.mTransitionDuration = r0.getDuration() / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f6, float f7, float[] fArr, int i6) {
        float f8;
        float[] fArr2;
        float f9 = this.mLastVelocity;
        float f10 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float signum = Math.signum(this.mTransitionGoalPosition - f10);
            float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
            f8 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f9 = (signum * ((interpolation - f8) / EPSILON)) / this.mTransitionDuration;
        } else {
            f8 = f10;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof MotionInterpolator) {
            f9 = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((i6 & 1) == 0) {
            fArr2 = fArr;
            motionController.getPostLayoutDvDp(f8, view.getWidth(), view.getHeight(), f6, f7, fArr2);
        } else {
            fArr2 = fArr;
            motionController.getDpDt(f8, f6, f7, fArr2);
        }
        if (i6 < 2) {
            fArr2[0] = fArr2[0] * f9;
            fArr2[1] = fArr2[1] * f9;
        }
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i6) {
        if (i6 == 0) {
            this.mScene = null;
            return;
        }
        try {
            this.mScene = new MotionScene(getContext(), this, i6);
            if (isAttachedToWindow()) {
                this.mScene.readFallback(this);
                this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
                rebuildScene();
                this.mScene.setRtl(isRtl());
            }
        } catch (Exception e6) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e6);
        }
    }

    int lookUpConstraintId(String str) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        RectF touchRegion;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled && (transition = motionScene.mCurrentTransition) != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (touchRegion = touchResponse.getTouchRegion(this, new RectF())) == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && (touchRegionId = touchResponse.getTouchRegionId()) != -1)) {
            View view = this.mRegionView;
            if (view == null || view.getId() != touchRegionId) {
                this.mRegionView = findViewById(touchRegionId);
            }
            if (this.mRegionView != null) {
                this.mBoundsCheck.set(r0.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
                if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent(0.0f, 0.0f, this.mRegionView, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (this.mScene == null) {
            super.onMeasure(i6, i7);
            return;
        }
        boolean z5 = false;
        boolean z6 = (this.mLastWidthMeasureSpec == i6 && this.mLastHeightMeasureSpec == i7) ? false : true;
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z6 = true;
        }
        if (this.mDirtyHierarchy) {
            z6 = true;
        }
        this.mLastWidthMeasureSpec = i6;
        this.mLastHeightMeasureSpec = i7;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if ((z6 || this.mModel.isNotConfiguredWith(startId, endId)) && this.mBeginState != -1) {
            super.onMeasure(i6, i7);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(startId, endId);
        } else {
            z5 = true;
        }
        if (this.mMeasureDuringTransition || z5) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int width = this.mLayoutWidget.getWidth() + getPaddingLeft() + getPaddingRight();
            int height = this.mLayoutWidget.getHeight() + paddingTop;
            int i8 = this.mWidthMeasureMode;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                width = (int) (this.mStartWrapWidth + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r7)));
                requestLayout();
            }
            int i9 = this.mHeightMeasureMode;
            if (i9 == Integer.MIN_VALUE || i9 == 0) {
                height = (int) (this.mStartWrapHeight + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r7)));
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        evaluateLayout();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(final View view, int i6, int i7, int[] iArr, int i8) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.mCurrentTransition) == null || !transition.isEnabled()) {
            return;
        }
        MotionScene.Transition transition2 = this.mScene.mCurrentTransition;
        if (transition2 == null || !transition2.isEnabled() || (touchResponse = transition2.getTouchResponse()) == null || (touchRegionId = touchResponse.getTouchRegionId()) == -1 || view.getId() == touchRegionId) {
            MotionScene motionScene2 = this.mScene;
            if (motionScene2 != null && motionScene2.getMoveWhenScrollAtTop()) {
                float f6 = this.mTransitionPosition;
                if ((f6 == 1.0f || f6 == 0.0f) && view.canScrollVertically(-1)) {
                    return;
                }
            }
            if (transition2.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) != 0) {
                float progressDirection = this.mScene.getProgressDirection(i6, i7);
                float f7 = this.mTransitionLastPosition;
                if ((f7 <= 0.0f && progressDirection < 0.0f) || (f7 >= 1.0f && progressDirection > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setNestedScrollingEnabled(true);
                        }
                    });
                    return;
                }
            }
            float f8 = this.mTransitionPosition;
            long nanoTime = getNanoTime();
            float f9 = i6;
            this.mScrollTargetDX = f9;
            float f10 = i7;
            this.mScrollTargetDY = f10;
            this.mScrollTargetDT = (float) ((nanoTime - this.mScrollTargetTime) * 1.0E-9d);
            this.mScrollTargetTime = nanoTime;
            this.mScene.processScrollMove(f9, f10);
            if (f8 != this.mTransitionPosition) {
                iArr[0] = i6;
                iArr[1] = i7;
            }
            evaluate(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.mUndergoingMotion = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
        if (this.mUndergoingMotion || i6 != 0 || i7 != 0) {
            iArr[0] = iArr[0] + i8;
            iArr[1] = iArr[1] + i9;
        }
        this.mUndergoingMotion = false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i6) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i6, int i7) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.mScene;
        return (motionScene == null || (transition = motionScene.mCurrentTransition) == null || transition.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i6) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        float f6 = this.mScrollTargetDX;
        float f7 = this.mScrollTargetDT;
        motionScene.processScrollUp(f6 / f7, this.mScrollTargetDY / f7);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null || !this.mInteractionEnabled || !motionScene.supportTouch()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.mScene.mCurrentTransition;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
        return true;
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(transitionListener);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (this.mMeasureDuringTransition || this.mCurrentState != -1 || (motionScene = this.mScene) == null || (transition = motionScene.mCurrentTransition) == null || transition.getLayoutDuringTransition() != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i6) {
        this.mDebugPath = i6;
        invalidate();
    }

    public void setInteractionEnabled(boolean z5) {
        this.mInteractionEnabled = z5;
    }

    public void setInterpolatedProgress(float f6) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f6));
                return;
            }
        }
        setProgress(f6);
    }

    public void setOnHide(float f6) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.mOnHideHelpers.get(i6).setProgress(f6);
            }
        }
    }

    public void setOnShow(float f6) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.mOnShowHelpers.get(i6).setProgress(f6);
            }
        }
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    public void setTransitionDuration(int i6) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.setDuration(i6);
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    public void touchAnimateTo(int i6, float f6, float f7) {
        if (this.mScene == null || this.mTransitionLastPosition == f6) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        float duration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionDuration = duration;
        this.mTransitionGoalPosition = f6;
        this.mInTransition = true;
        if (i6 == 0 || i6 == 1 || i6 == 2) {
            float f8 = i6 == 1 ? 0.0f : i6 == 2 ? 1.0f : f6;
            this.mStopLogic.config(this.mTransitionLastPosition, f8, f7, duration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
            int i7 = this.mCurrentState;
            this.mTransitionGoalPosition = f8;
            this.mCurrentState = i7;
            this.mInterpolator = this.mStopLogic;
        } else if (i6 == 4) {
            this.mDecelerateLogic.config(f7, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
            this.mInterpolator = this.mDecelerateLogic;
        } else if (i6 == 5) {
            if (willJump(f7, this.mTransitionLastPosition, this.mScene.getMaxAcceleration())) {
                this.mDecelerateLogic.config(f7, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                this.mInterpolator = this.mDecelerateLogic;
            } else {
                this.mStopLogic.config(this.mTransitionLastPosition, f6, f7, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                this.mLastVelocity = 0.0f;
                int i8 = this.mCurrentState;
                this.mTransitionGoalPosition = f6;
                this.mCurrentState = i8;
                this.mInterpolator = this.mStopLogic;
            }
        }
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        animateTo(1.0f);
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.setStartCurrentState(childAt);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        int i6;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z5 = true;
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z5 = obtainStyledAttributes.getBoolean(index, z5);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i6 = 2;
                        } else {
                            i6 = 0;
                        }
                        this.mDebugPath = i6;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (!z5) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState == -1 && (motionScene = this.mScene) != null) {
            this.mCurrentState = motionScene.getStartId();
            this.mBeginState = this.mScene.getStartId();
            this.mEndState = this.mScene.getEndId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupMotionViews() {
        float f6;
        float f7;
        int childCount = getChildCount();
        this.mModel.build();
        boolean z5 = true;
        this.mInTransition = true;
        int width = getWidth();
        int height = getHeight();
        int gatPathMotionArc = this.mScene.gatPathMotionArc();
        int i6 = 0;
        if (gatPathMotionArc != -1) {
            for (int i7 = 0; i7 < childCount; i7++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i7));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i8));
            if (motionController2 != null) {
                this.mScene.getKeyFrames(motionController2);
                motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            if (staggered >= 0.0d) {
                z5 = false;
            }
            float abs = Math.abs(staggered);
            float f8 = -3.4028235E38f;
            float f9 = Float.MAX_VALUE;
            float f10 = Float.MAX_VALUE;
            float f11 = -3.4028235E38f;
            for (int i9 = 0; i9 < childCount; i9++) {
                MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i9));
                if (!Float.isNaN(motionController3.mMotionStagger)) {
                    for (int i10 = 0; i10 < childCount; i10++) {
                        MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i10));
                        if (!Float.isNaN(motionController4.mMotionStagger)) {
                            f9 = Math.min(f9, motionController4.mMotionStagger);
                            f8 = Math.max(f8, motionController4.mMotionStagger);
                        }
                    }
                    while (i6 < childCount) {
                        MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i6));
                        if (!Float.isNaN(motionController5.mMotionStagger)) {
                            motionController5.mStaggerScale = 1.0f / (1.0f - abs);
                            if (z5) {
                                motionController5.mStaggerOffset = abs - (((f8 - motionController5.mMotionStagger) / (f8 - f9)) * abs);
                            } else {
                                motionController5.mStaggerOffset = abs - (((motionController5.mMotionStagger - f9) * abs) / (f8 - f9));
                            }
                        }
                        i6++;
                    }
                    return;
                }
                float finalX = motionController3.getFinalX();
                float finalY = motionController3.getFinalY();
                if (z5) {
                    f7 = finalY - finalX;
                } else {
                    f7 = finalY + finalX;
                }
                f10 = Math.min(f10, f7);
                f11 = Math.max(f11, f7);
            }
            while (i6 < childCount) {
                MotionController motionController6 = this.mFrameArrayList.get(getChildAt(i6));
                float finalX2 = motionController6.getFinalX();
                float finalY2 = motionController6.getFinalY();
                if (z5) {
                    f6 = finalY2 - finalX2;
                } else {
                    f6 = finalY2 + finalX2;
                }
                motionController6.mStaggerScale = 1.0f / (1.0f - abs);
                motionController6.mStaggerOffset = abs - (((f6 - f10) * abs) / (f11 - f10));
                i6++;
            }
        }
    }

    public void enableTransition(int i6, boolean z5) {
        MotionScene.Transition transition = getTransition(i6);
        if (z5) {
            transition.setEnable(true);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (transition == motionScene.mCurrentTransition) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.mScene.mCurrentTransition = next;
                    break;
                }
            }
        }
        transition.setEnable(false);
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    protected MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        int i6;
        super.onAttachedToWindow();
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (i6 = this.mCurrentState) != -1) {
            ConstraintSet constraintSet = motionScene.getConstraintSet(i6);
            this.mScene.readFallback(this);
            if (constraintSet != null) {
                constraintSet.applyTo(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        StateCache stateCache = this.mStateCache;
        if (stateCache != null) {
            stateCache.apply();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new ArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Deprecated
    public void rebuildMotion() {
        rebuildScene();
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void transitionToState(int i6, int i7, int i8) {
        StateSet stateSet;
        int convertToConstraintSet;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (stateSet = motionScene.mStateSet) != null && (convertToConstraintSet = stateSet.convertToConstraintSet(this.mCurrentState, i6, i7, i8)) != -1) {
            i6 = convertToConstraintSet;
        }
        int i9 = this.mCurrentState;
        if (i9 == i6) {
            return;
        }
        if (this.mBeginState == i6) {
            animateTo(0.0f);
            return;
        }
        if (this.mEndState == i6) {
            animateTo(1.0f);
            return;
        }
        this.mEndState = i6;
        if (i9 != -1) {
            setTransition(i9, i6);
            animateTo(1.0f);
            this.mTransitionLastPosition = 0.0f;
            transitionToEnd();
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mBeginState = -1;
        this.mScene.setTransition(-1, this.mEndState);
        this.mScene.getStartId();
        int childCount = getChildCount();
        this.mFrameArrayList.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            this.mFrameArrayList.put(childAt, new MotionController(childAt));
        }
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(i6));
        rebuildScene();
        this.mModel.build();
        computeCurrentPositions();
        int width = getWidth();
        int height = getHeight();
        for (int i11 = 0; i11 < childCount; i11++) {
            MotionController motionController = this.mFrameArrayList.get(getChildAt(i11));
            this.mScene.getKeyFrames(motionController);
            motionController.setup(width, height, this.mTransitionDuration, getNanoTime());
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            float f6 = Float.MAX_VALUE;
            float f7 = -3.4028235E38f;
            for (int i12 = 0; i12 < childCount; i12++) {
                MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i12));
                float finalY = motionController2.getFinalY() + motionController2.getFinalX();
                f6 = Math.min(f6, finalY);
                f7 = Math.max(f7, finalY);
            }
            for (int i13 = 0; i13 < childCount; i13++) {
                MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i13));
                float finalX = motionController3.getFinalX();
                float finalY2 = motionController3.getFinalY();
                motionController3.mStaggerScale = 1.0f / (1.0f - staggered);
                motionController3.mStaggerOffset = staggered - ((((finalX + finalY2) - f6) * staggered) / (f7 - f6));
            }
        }
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public void setProgress(float f6) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f6);
            return;
        }
        if (f6 <= 0.0f) {
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f6 >= 1.0f) {
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(TransitionState.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f6;
        this.mTransitionPosition = f6;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i6, int i7, int i8) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i6;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i6, i7, i8);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getConstraintSet(i6).applyTo(this);
        }
    }

    public void setTransition(int i6) {
        float f6;
        if (this.mScene != null) {
            MotionScene.Transition transition = getTransition(i6);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache();
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            int i7 = this.mCurrentState;
            if (i7 == this.mBeginState) {
                f6 = 0.0f;
            } else {
                f6 = i7 == this.mEndState ? 1.0f : Float.NaN;
            }
            this.mScene.setTransition(transition);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            this.mTransitionLastPosition = Float.isNaN(f6) ? 0.0f : f6;
            if (Float.isNaN(f6)) {
                Debug.getLocation();
                transitionToStart();
            } else {
                setProgress(f6);
            }
        }
    }

    private void checkStructure(int i6, ConstraintSet constraintSet) {
        Debug.getName(getContext(), i6);
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (constraintSet.getConstraint(childAt.getId()) == null) {
                Debug.getName(childAt);
            }
        }
        int[] knownIds = constraintSet.getKnownIds();
        for (int i8 = 0; i8 < knownIds.length; i8++) {
            int i9 = knownIds[i8];
            Debug.getName(getContext(), i9);
            findViewById(knownIds[i8]);
            constraintSet.getHeight(i9);
            constraintSet.getWidth(i9);
        }
    }

    private void checkStructure(MotionScene.Transition transition) {
        transition.debugString(getContext());
        transition.getDuration();
        transition.getStartConstraintSetId();
        transition.getEndConstraintSetId();
    }

    protected void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1L : getNanoTime();
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId == this.mBeginState && endId == this.mEndState) {
            return;
        }
        this.mBeginState = startId;
        this.mEndState = endId;
        this.mScene.setTransition(startId, endId);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i6, int i7) {
    }
}
