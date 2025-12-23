package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    String str = "identity";
    static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* renamed from: x1, reason: collision with root package name */
        double f805x1;

        /* renamed from: x2, reason: collision with root package name */
        double f806x2;

        /* renamed from: y1, reason: collision with root package name */
        double f807y1;

        /* renamed from: y2, reason: collision with root package name */
        double f808y2;

        CubicEasing(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f805x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i6 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i6);
            this.f807y1 = Double.parseDouble(str.substring(i6, indexOf3).trim());
            int i7 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i7);
            this.f806x2 = Double.parseDouble(str.substring(i7, indexOf4).trim());
            int i8 = indexOf4 + 1;
            this.f808y2 = Double.parseDouble(str.substring(i8, str.indexOf(41, i8)).trim());
        }

        private double getDiffX(double d6) {
            double d7 = 1.0d - d6;
            double d8 = this.f805x1;
            double d9 = this.f806x2;
            return (d7 * 3.0d * d7 * d8) + (d7 * 6.0d * d6 * (d9 - d8)) + (3.0d * d6 * d6 * (1.0d - d9));
        }

        private double getDiffY(double d6) {
            double d7 = 1.0d - d6;
            double d8 = this.f807y1;
            double d9 = this.f808y2;
            return (d7 * 3.0d * d7 * d8) + (d7 * 6.0d * d6 * (d9 - d8)) + (3.0d * d6 * d6 * (1.0d - d9));
        }

        private double getX(double d6) {
            double d7 = 1.0d - d6;
            double d8 = 3.0d * d7;
            return (this.f805x1 * d7 * d8 * d6) + (this.f806x2 * d8 * d6 * d6) + (d6 * d6 * d6);
        }

        private double getY(double d6) {
            double d7 = 1.0d - d6;
            double d8 = 3.0d * d7;
            return (this.f807y1 * d7 * d8 * d6) + (this.f808y2 * d8 * d6 * d6) + (d6 * d6 * d6);
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double d6) {
            if (d6 <= 0.0d) {
                return 0.0d;
            }
            if (d6 >= 1.0d) {
                return 1.0d;
            }
            double d7 = 0.5d;
            double d8 = 0.5d;
            while (d7 > error) {
                d7 *= 0.5d;
                d8 = getX(d8) < d6 ? d8 + d7 : d8 - d7;
            }
            double d9 = d8 - d7;
            double x5 = getX(d9);
            double d10 = d8 + d7;
            double x6 = getX(d10);
            double y5 = getY(d9);
            return (((getY(d10) - y5) * (d6 - x5)) / (x6 - x5)) + y5;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double d6) {
            double d7 = 0.5d;
            double d8 = 0.5d;
            while (d7 > d_error) {
                d7 *= 0.5d;
                d8 = getX(d8) < d6 ? d8 + d7 : d8 - d7;
            }
            double d9 = d8 - d7;
            double d10 = d8 + d7;
            return (getY(d10) - getY(d9)) / (getX(d10) - getX(d9));
        }

        void setup(double d6, double d7, double d8, double d9) {
            this.f805x1 = d6;
            this.f807y1 = d7;
            this.f806x2 = d8;
            this.f808y2 = d9;
        }

        public CubicEasing(double d6, double d7, double d8, double d9) {
            setup(d6, d7, d8, d9);
        }
    }

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        switch (str) {
            case "accelerate":
                return new CubicEasing(ACCELERATE);
            case "decelerate":
                return new CubicEasing(DECELERATE);
            case "linear":
                return new CubicEasing(LINEAR);
            case "standard":
                return new CubicEasing(STANDARD);
            default:
                Arrays.toString(NAMED_EASING);
                return sDefault;
        }
    }

    public double getDiff(double d6) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    public double get(double d6) {
        return d6;
    }
}
