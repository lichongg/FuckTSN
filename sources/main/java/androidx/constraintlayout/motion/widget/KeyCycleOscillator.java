package androidx.constraintlayout.motion.widget;

import android.annotation.TargetApi;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    protected ConstraintAttribute mCustom;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class CustomSet extends KeyCycleOscillator {
        float[] value = new float[1];

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            this.value[0] = get(f6);
            this.mCustom.setInterpolatedValue(view, this.value);
        }

        CustomSet() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffset;
        float mPathLength;
        float[] mPeriod;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;
        Oscillator mOscillator = new Oscillator();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            if (!this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = new ConstraintAttribute(str, attributeType);
                this.mCustomConstraints.put(str, constraintAttribute);
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = this.mCustomConstraints.get(str);
            if (constraintAttribute2.getType() == attributeType) {
                return constraintAttribute2;
            }
            throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute2.getType().name());
        }

        public double getSlope(float f6) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d6 = f6;
                curveFit.getSlope(d6, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d6, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d7 = f6;
            double value = this.mOscillator.getValue(d7);
            double slope = this.mOscillator.getSlope(d7);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[1]) + (slope * this.mSplineValueCache[1]);
        }

        public double getValues(float f6) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f6, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffset[0];
                dArr[1] = this.mValues[0];
            }
            return this.mSplineValueCache[0] + (this.mOscillator.getValue(f6) * this.mSplineValueCache[1]);
        }

        public void setPoint(int i6, int i7, float f6, float f7, float f8) {
            this.mPosition[i6] = i7 / 100.0d;
            this.mPeriod[i6] = f6;
            this.mOffset[i6] = f7;
            this.mValues[i6] = f8;
        }

        public void setup(float f6) {
            this.mPathLength = f6;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 2);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 1];
            this.mSplineSlopeCache = new double[fArr.length + 1];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i6 = 0; i6 < dArr.length; i6++) {
                dArr[i6][0] = this.mOffset[i6];
                int i7 = 0;
                while (true) {
                    if (i7 < this.mValues.length) {
                        dArr[i7][1] = r4[i7];
                        i7++;
                    }
                }
                this.mOscillator.addPoint(this.mPosition[i6], this.mPeriod[i6]);
            }
            this.mOscillator.normalize();
            double[] dArr3 = this.mPosition;
            if (dArr3.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr3, dArr);
            } else {
                this.mCurveFit = null;
            }
        }

        CycleOscillator(int i6, int i7, int i8) {
            this.mWaveShape = i6;
            this.mVariesBy = i7;
            this.mOscillator.setType(i6);
            this.mValues = new float[i8];
            this.mPosition = new double[i8];
            this.mPeriod = new float[i8];
            this.mOffset = new float[i8];
            this.mScale = new float[i8];
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class IntDoubleSort {
        static void sort(int[] iArr, float[] fArr, int i6, int i7) {
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

        private static int partition(int[] iArr, float[] fArr, int i6, int i7) {
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

        private static void swap(int[] iArr, float[] fArr, int i6, int i7) {
            int i8 = iArr[i6];
            iArr[i6] = iArr[i7];
            iArr[i7] = i8;
            float f6 = fArr[i6];
            fArr[i6] = fArr[i7];
            fArr[i7] = f6;
        }

        private IntDoubleSort() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class IntFloatFloatSort {
        static void sort(int[] iArr, float[] fArr, float[] fArr2, int i6, int i7) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i7;
            iArr2[1] = i6;
            int i8 = 2;
            while (i8 > 0) {
                int i9 = iArr2[i8 - 1];
                int i10 = i8 - 2;
                int i11 = iArr2[i10];
                if (i9 < i11) {
                    int partition = partition(iArr, fArr, fArr2, i9, i11);
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

        private static int partition(int[] iArr, float[] fArr, float[] fArr2, int i6, int i7) {
            int i8 = iArr[i7];
            int i9 = i6;
            while (i6 < i7) {
                if (iArr[i6] <= i8) {
                    swap(iArr, fArr, fArr2, i9, i6);
                    i9++;
                }
                i6++;
            }
            swap(iArr, fArr, fArr2, i9, i7);
            return i9;
        }

        private static void swap(int[] iArr, float[] fArr, float[] fArr2, int i6, int i7) {
            int i8 = iArr[i6];
            iArr[i6] = iArr[i7];
            iArr[i7] = i8;
            float f6 = fArr[i6];
            fArr[i6] = fArr[i7];
            fArr[i7] = f6;
            float f7 = fArr2[i6];
            fArr2[i6] = fArr2[i7];
            fArr2[i7] = f7;
        }

        private IntFloatFloatSort() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ProgressSet extends KeyCycleOscillator {
        boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f6));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.mNoMethod = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(get(f6)));
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            }
        }

        ProgressSet() {
        }
    }

    public void setPoint(int i6, int i7, int i8, float f6, float f7, float f8, ConstraintAttribute constraintAttribute) {
        this.mWavePoints.add(new WavePoint(i6, f6, f7, f8));
        if (i8 != -1) {
            this.mVariesBy = i8;
        }
        this.mWaveShape = i7;
        this.mCustom = constraintAttribute;
    }

    public abstract void setProperty(View view, float f6);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AlphaSet extends KeyCycleOscillator {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setAlpha(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ElevationSet extends KeyCycleOscillator {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setElevation(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class PathRotateSet extends KeyCycleOscillator {
        PathRotateSet() {
        }

        public void setPathRotate(View view, float f6, double d6, double d7) {
            view.setRotation(get(f6) + ((float) Math.toDegrees(Math.atan2(d7, d6))));
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RotationSet extends KeyCycleOscillator {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setRotation(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RotationXset extends KeyCycleOscillator {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setRotationX(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class RotationYset extends KeyCycleOscillator {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setRotationY(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ScaleXset extends KeyCycleOscillator {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setScaleX(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ScaleYset extends KeyCycleOscillator {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setScaleY(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TranslationXset extends KeyCycleOscillator {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setTranslationX(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TranslationYset extends KeyCycleOscillator {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setTranslationY(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TranslationZset extends KeyCycleOscillator {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f6) {
            view.setTranslationZ(get(f6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class WavePoint {
        float mOffset;
        float mPeriod;
        int mPosition;
        float mValue;

        public WavePoint(int i6, float f6, float f7, float f8) {
            this.mPosition = i6;
            this.mValue = f8;
            this.mOffset = f7;
            this.mPeriod = f6;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static KeyCycleOscillator makeSpline(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c6 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c6 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c6 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c6 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c6 = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c6 = '\b';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c6 = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c6 = '\n';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c6 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c6 = '\f';
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c6 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                return new ProgressSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case '\b':
                return new AlphaSet();
            case '\t':
                return new RotationSet();
            case '\n':
                return new ElevationSet();
            case 11:
                return new PathRotateSet();
            case '\f':
                return new AlphaSet();
            case '\r':
                return new AlphaSet();
            default:
                return null;
        }
    }

    public float get(float f6) {
        return (float) this.mCycleOscillator.getValues(f6);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f6) {
        return (float) this.mCycleOscillator.getSlope(f6);
    }

    public void setType(String str) {
        this.mType = str;
    }

    @TargetApi(19)
    public void setup(float f6) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.motion.widget.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 2);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mVariesBy, size);
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            WavePoint next = it.next();
            float f7 = next.mPeriod;
            dArr[i6] = f7 * 0.01d;
            double[] dArr3 = dArr2[i6];
            float f8 = next.mValue;
            dArr3[0] = f8;
            float f9 = next.mOffset;
            dArr3[1] = f9;
            this.mCycleOscillator.setPoint(i6, next.mPosition, f7, f9, f8);
            i6++;
        }
        this.mCycleOscillator.setup(f6);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().mPosition + " , " + decimalFormat.format(r3.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i6, int i7, int i8, float f6, float f7, float f8) {
        this.mWavePoints.add(new WavePoint(i6, f6, f7, f8));
        if (i8 != -1) {
            this.mVariesBy = i8;
        }
        this.mWaveShape = i7;
    }
}
