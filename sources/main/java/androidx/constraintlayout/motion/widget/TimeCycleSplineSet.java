package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    long last_time;
    protected CurveFit mCurveFit;
    private String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);
    private float[] mCache = new float[3];
    protected boolean mContinue = false;
    float last_cycle = Float.NaN;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int i6, float f6, float f7, int i7, float f8) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int i6, ConstraintAttribute constraintAttribute, float f6, int i7, float f7) {
            this.mConstraintAttributeList.append(i6, constraintAttribute);
            this.mWaveProperties.append(i6, new float[]{f6, f7});
            this.mWaveShape = Math.max(this.mWaveShape, i7);
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            this.mCurveFit.getPos(f6, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f7 = fArr[fArr.length - 2];
            float f8 = fArr[fArr.length - 1];
            float f9 = (float) ((this.last_cycle + (((j6 - this.last_time) * 1.0E-9d) * f7)) % 1.0d);
            this.last_cycle = f9;
            this.last_time = j6;
            float calcWave = calcWave(f9);
            this.mContinue = false;
            int i6 = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i6 >= fArr2.length) {
                    break;
                }
                boolean z5 = this.mContinue;
                float f10 = this.mTempValues[i6];
                this.mContinue = z5 | (((double) f10) != 0.0d);
                fArr2[i6] = (f10 * calcWave) + f8;
                i6++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (f7 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i6) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            int i7 = noOfInterpValues + 2;
            this.mTempValues = new float[i7];
            this.mCache = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i7);
            for (int i8 = 0; i8 < size; i8++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i8);
                ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i8);
                float[] valueAt2 = this.mWaveProperties.valueAt(i8);
                dArr[i8] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i9 = 0;
                while (true) {
                    if (i9 < this.mTempValues.length) {
                        dArr2[i8][i9] = r8[i9];
                        i9++;
                    }
                }
                double[] dArr3 = dArr2[i8];
                dArr3[noOfInterpValues] = valueAt2[0];
                dArr3[noOfInterpValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i6, dArr, dArr2);
        }

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class PathRotate extends TimeCycleSplineSet {
        public boolean setPathRotate(View view, KeyCache keyCache, float f6, long j6, double d6, double d7) {
            view.setRotation(get(f6, j6, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d7, d6))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            return this.mContinue;
        }

        PathRotate() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            ProgressSet progressSet;
            Method method;
            if (view instanceof MotionLayout) {
                progressSet = this;
                ((MotionLayout) view).setProgress(progressSet.get(f6, j6, view, keyCache));
            } else {
                progressSet = this;
                if (progressSet.mNoMethod) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    progressSet.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(progressSet.get(f6, j6, view, keyCache)));
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            return progressSet.mContinue;
        }

        ProgressSet() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Sort {
        static void doubleQuickSort(int[] iArr, float[][] fArr, int i6, int i7) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i7;
            iArr2[1] = i6;
            int i8 = 2;
            while (i8 > 0) {
                int i9 = iArr2[i8 - 1];
                int i10 = i8 - 2;
                int i11 = iArr2[i10];
                if (i9 < i11) {
                    int partition = partition(iArr, fArr, i9, i11);
                    iArr2[i10] = partition - 1;
                    iArr2[i8 - 1] = i9;
                    int i12 = i8 + 1;
                    iArr2[i8] = i11;
                    i8 += 2;
                    iArr2[i12] = partition + 1;
                } else {
                    i8 = i10;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i6, int i7) {
            int i8 = iArr[i7];
            int i9 = i6;
            while (i6 < i7) {
                if (iArr[i6] <= i8) {
                    swap(iArr, fArr, i9, i6);
                    i9++;
                }
                i6++;
            }
            swap(iArr, fArr, i9, i7);
            return i9;
        }

        private static void swap(int[] iArr, float[][] fArr, int i6, int i7) {
            int i8 = iArr[i6];
            iArr[i6] = iArr[i7];
            iArr[i7] = i8;
            float[] fArr2 = fArr[i6];
            fArr[i6] = fArr[i7];
            fArr[i7] = fArr2;
        }

        private Sort() {
        }
    }

    public abstract boolean setProperty(View view, float f6, long j6, KeyCache keyCache);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AlphaSet extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setAlpha(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        AlphaSet() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ElevationSet extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setElevation(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        ElevationSet() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RotationSet extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setRotation(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        RotationSet() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RotationXset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setRotationX(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        RotationXset() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RotationYset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setRotationY(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        RotationYset() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ScaleXset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setScaleX(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        ScaleXset() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ScaleYset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setScaleY(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        ScaleYset() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TranslationXset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setTranslationX(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        TranslationXset() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TranslationYset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setTranslationY(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        TranslationYset() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TranslationZset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f6, long j6, KeyCache keyCache) {
            view.setTranslationZ(get(f6, j6, view, keyCache));
            return this.mContinue;
        }

        TranslationZset() {
        }
    }

    static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    protected float calcWave(float f6) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f6 * VAL_2PI);
            case 2:
                abs = Math.abs(f6);
                break;
            case 3:
                return (((f6 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f6 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f6 * VAL_2PI);
            case 6:
                float abs2 = 1.0f - Math.abs(((f6 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f6 * VAL_2PI);
        }
        return 1.0f - abs;
    }

    public float get(float f6, long j6, View view, KeyCache keyCache) {
        this.mCurveFit.getPos(f6, this.mCache);
        float[] fArr = this.mCache;
        float f7 = fArr[1];
        if (f7 == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f8 = (float) ((this.last_cycle + (((j6 - this.last_time) * 1.0E-9d) * f7)) % 1.0d);
        this.last_cycle = f8;
        keyCache.setFloatValue(view, this.mType, 0, f8);
        this.last_time = j6;
        float f9 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f9) + this.mCache[2];
        this.mContinue = (f9 == 0.0f && f7 == 0.0f) ? false : true;
        return calcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i6, float f6, float f7, int i7, float f8) {
        int[] iArr = this.mTimePoints;
        int i8 = this.count;
        iArr[i8] = i6;
        float[] fArr = this.mValues[i8];
        fArr[0] = f6;
        fArr[1] = f7;
        fArr[2] = f8;
        this.mWaveShape = Math.max(this.mWaveShape, i7);
        this.count++;
    }

    protected void setStartTime(long j6) {
        this.last_time = j6;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i6) {
        int i7;
        int i8 = this.count;
        if (i8 == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i8 - 1);
        int i9 = 1;
        int i10 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i9 >= iArr.length) {
                break;
            }
            if (iArr[i9] != iArr[i9 - 1]) {
                i10++;
            }
            i9++;
        }
        if (i10 == 0) {
            i10 = 1;
        }
        double[] dArr = new double[i10];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i10, 3);
        int i11 = 0;
        while (i7 < this.count) {
            if (i7 > 0) {
                int[] iArr2 = this.mTimePoints;
                i7 = iArr2[i7] == iArr2[i7 + (-1)] ? i7 + 1 : 0;
            }
            dArr[i11] = this.mTimePoints[i7] * 0.01d;
            double[] dArr3 = dArr2[i11];
            float[] fArr = this.mValues[i7];
            dArr3[0] = fArr[0];
            dArr3[1] = fArr[1];
            dArr3[2] = fArr[2];
            i11++;
        }
        this.mCurveFit = CurveFit.get(i6, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i6 = 0; i6 < this.count; i6++) {
            str = str + "[" + this.mTimePoints[i6] + " , " + decimalFormat.format(this.mValues[i6]) + "] ";
        }
        return str;
    }

    static TimeCycleSplineSet makeSpline(String str, long j6) {
        TimeCycleSplineSet rotationXset;
        str.getClass();
        switch (str) {
            case "rotationX":
                rotationXset = new RotationXset();
                break;
            case "rotationY":
                rotationXset = new RotationYset();
                break;
            case "translationX":
                rotationXset = new TranslationXset();
                break;
            case "translationY":
                rotationXset = new TranslationYset();
                break;
            case "translationZ":
                rotationXset = new TranslationZset();
                break;
            case "progress":
                rotationXset = new ProgressSet();
                break;
            case "scaleX":
                rotationXset = new ScaleXset();
                break;
            case "scaleY":
                rotationXset = new ScaleYset();
                break;
            case "rotation":
                rotationXset = new RotationSet();
                break;
            case "elevation":
                rotationXset = new ElevationSet();
                break;
            case "transitionPathRotate":
                rotationXset = new PathRotate();
                break;
            case "alpha":
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(j6);
        return rotationXset;
    }
}
