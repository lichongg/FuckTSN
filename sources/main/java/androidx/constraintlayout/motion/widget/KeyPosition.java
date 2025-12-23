package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class KeyPosition extends KeyPositionBase {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    private static final String PERCENT_X = "percentX";
    private static final String PERCENT_Y = "percentY";
    private static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    String mTransitionEasing = null;
    int mPathMotionArc = Key.UNSET;
    int mDrawPath = 0;
    float mPercentWidth = Float.NaN;
    float mPercentHeight = Float.NaN;
    float mPercentX = Float.NaN;
    float mPercentY = Float.NaN;
    float mAltPercentX = Float.NaN;
    float mAltPercentY = Float.NaN;
    int mPositionType = 0;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArray.getIndex(i6);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            keyPosition.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            break;
                        }
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTransitionEasing = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        break;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        break;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        break;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        break;
                    case 8:
                        float f6 = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f6;
                        keyPosition.mPercentHeight = f6;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        break;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        break;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        break;
                    case 12:
                        keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        break;
                    default:
                        Integer.toHexString(index);
                        mAttrMap.get(index);
                        break;
                }
            }
            int i7 = keyPosition.mFramePosition;
        }
    }

    private void calcCartesianPosition(float f6, float f7, float f8, float f9) {
        float f10 = f8 - f6;
        float f11 = f9 - f7;
        float f12 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f13 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f14 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (f6 + (f12 * f10) + ((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f11));
        this.mCalculatedPositionY = (int) (f7 + (f10 * f13) + (f11 * f14));
    }

    private void calcPathPosition(float f6, float f7, float f8, float f9) {
        float f10 = f8 - f6;
        float f11 = f9 - f7;
        float f12 = this.mPercentX;
        float f13 = this.mPercentY;
        this.mCalculatedPositionX = f6 + (f10 * f12) + ((-f11) * f13);
        this.mCalculatedPositionY = f7 + (f11 * f12) + (f10 * f13);
    }

    private void calcScreenPosition(int i6, int i7) {
        float f6 = this.mPercentX;
        float f7 = 0;
        this.mCalculatedPositionX = (i6 * f6) + f7;
        this.mCalculatedPositionY = (i7 * f6) + f7;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    void calcPosition(int i6, int i7, float f6, float f7, float f8, float f9) {
        int i8 = this.mPositionType;
        if (i8 == 1) {
            calcPathPosition(f6, f7, f8, f9);
        } else if (i8 != 2) {
            calcCartesianPosition(f6, f7, f8, f9);
        } else {
            calcScreenPosition(i6, i7);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f6, float f7, String[] strArr, float[] fArr) {
        int i6 = this.mPositionType;
        if (i6 == 1) {
            positionPathAttributes(rectF, rectF2, f6, f7, strArr, fArr);
        } else if (i6 != 2) {
            positionCartAttributes(rectF, rectF2, f6, f7, strArr, fArr);
        } else {
            positionScreenAttributes(view, rectF, rectF2, f6, f7, strArr, fArr);
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int i6, int i7, RectF rectF, RectF rectF2, float f6, float f7) {
        calcPosition(i6, i7, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        if (Math.abs(f6 - this.mCalculatedPositionX) < 20.0f && Math.abs(f7 - this.mCalculatedPositionY) < 20.0f) {
            return true;
        }
        return false;
    }

    void positionCartAttributes(RectF rectF, RectF rectF2, float f6, float f7, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        String str = strArr[0];
        if (str != null) {
            if (PERCENT_X.equals(str)) {
                fArr[0] = (f6 - centerX) / centerX2;
                fArr[1] = (f7 - centerY) / centerY2;
                return;
            } else {
                fArr[1] = (f6 - centerX) / centerX2;
                fArr[0] = (f7 - centerY) / centerY2;
                return;
            }
        }
        strArr[0] = PERCENT_X;
        fArr[0] = (f6 - centerX) / centerX2;
        strArr[1] = PERCENT_Y;
        fArr[1] = (f7 - centerY) / centerY2;
    }

    void positionPathAttributes(RectF rectF, RectF rectF2, float f6, float f7, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        float hypot = (float) Math.hypot(centerX2, centerY2);
        if (hypot < 1.0E-4d) {
            System.out.getClass();
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f8 = centerX2 / hypot;
        float f9 = centerY2 / hypot;
        float f10 = f7 - centerY;
        float f11 = f6 - centerX;
        float f12 = ((f8 * f10) - (f11 * f9)) / hypot;
        float f13 = ((f8 * f11) + (f9 * f10)) / hypot;
        String str = strArr[0];
        if (str != null) {
            if (PERCENT_X.equals(str)) {
                fArr[0] = f13;
                fArr[1] = f12;
                return;
            }
            return;
        }
        strArr[0] = PERCENT_X;
        strArr[1] = PERCENT_Y;
        fArr[0] = f13;
        fArr[1] = f12;
    }

    void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f6, float f7, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        String str = strArr[0];
        if (str != null) {
            if (PERCENT_X.equals(str)) {
                fArr[0] = f6 / width;
                fArr[1] = f7 / height;
                return;
            } else {
                fArr[1] = f6 / width;
                fArr[0] = f7 / height;
                return;
            }
        }
        strArr[0] = PERCENT_X;
        fArr[0] = f6 / width;
        strArr[1] = PERCENT_Y;
        fArr[1] = f7 / height;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.getClass();
        switch (str) {
            case "transitionEasing":
                this.mTransitionEasing = obj.toString();
                break;
            case "percentWidth":
                this.mPercentWidth = toFloat(obj);
                break;
            case "percentHeight":
                this.mPercentHeight = toFloat(obj);
                break;
            case "drawPath":
                this.mDrawPath = toInt(obj);
                break;
            case "sizePercent":
                float f6 = toFloat(obj);
                this.mPercentWidth = f6;
                this.mPercentHeight = f6;
                break;
            case "percentX":
                this.mPercentX = toFloat(obj);
                break;
            case "percentY":
                this.mPercentY = toFloat(obj);
                break;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }
}
