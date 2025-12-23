package com.scwang.smartrefresh.layout.util;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final double f37467a = 95.047d;

    /* renamed from: b, reason: collision with root package name */
    private static final double f37468b = 100.0d;

    /* renamed from: c, reason: collision with root package name */
    private static final double f37469c = 108.883d;

    /* renamed from: d, reason: collision with root package name */
    private static final double f37470d = 0.008856d;

    /* renamed from: e, reason: collision with root package name */
    private static final double f37471e = 903.3d;

    /* renamed from: f, reason: collision with root package name */
    private static final int f37472f = 10;

    /* renamed from: g, reason: collision with root package name */
    private static final int f37473g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final ThreadLocal<double[]> f37474h = new ThreadLocal<>();

    @ColorInt
    public static int a(@NonNull float[] fArr) {
        int round;
        int round2;
        int round3;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[2];
        float abs = (1.0f - Math.abs((f8 * 2.0f) - 1.0f)) * f7;
        float f9 = f8 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f6 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f6) / 60) {
            case 0:
                round = Math.round((abs + f9) * 255.0f);
                round2 = Math.round((abs2 + f9) * 255.0f);
                round3 = Math.round(f9 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f9) * 255.0f);
                round2 = Math.round((abs + f9) * 255.0f);
                round3 = Math.round(f9 * 255.0f);
                break;
            case 2:
                round = Math.round(f9 * 255.0f);
                round2 = Math.round((abs + f9) * 255.0f);
                round3 = Math.round((abs2 + f9) * 255.0f);
                break;
            case 3:
                round = Math.round(f9 * 255.0f);
                round2 = Math.round((abs2 + f9) * 255.0f);
                round3 = Math.round((abs + f9) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f9) * 255.0f);
                round2 = Math.round(f9 * 255.0f);
                round3 = Math.round((abs + f9) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f9) * 255.0f);
                round2 = Math.round(f9 * 255.0f);
                round3 = Math.round((abs2 + f9) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(w(round, 0, 255), w(round2, 0, 255), w(round3, 0, 255));
    }

    public static void d(@IntRange(from = 0, to = 255) int i6, @IntRange(from = 0, to = 255) int i7, @IntRange(from = 0, to = 255) int i8, @NonNull float[] fArr) {
        float f6;
        float abs;
        float f7 = i6 / 255.0f;
        float f8 = i7 / 255.0f;
        float f9 = i8 / 255.0f;
        float max = Math.max(f7, Math.max(f8, f9));
        float min = Math.min(f7, Math.min(f8, f9));
        float f10 = max - min;
        float f11 = (max + min) / 2.0f;
        if (max == min) {
            f6 = 0.0f;
            abs = 0.0f;
        } else {
            f6 = max == f7 ? ((f8 - f9) / f10) % 6.0f : max == f8 ? ((f9 - f7) / f10) + 2.0f : 4.0f + ((f7 - f8) / f10);
            abs = f10 / (1.0f - Math.abs((2.0f * f11) - 1.0f));
        }
        float f12 = (f6 * 60.0f) % 360.0f;
        if (f12 < 0.0f) {
            f12 += 360.0f;
        }
        fArr[0] = v(f12, 0.0f, 360.0f);
        fArr[1] = v(abs, 0.0f, 1.0f);
        fArr[2] = v(f11, 0.0f, 1.0f);
    }

    public static void h(@FloatRange(from = 0.0d, to = 95.047d) double d6, @FloatRange(from = 0.0d, to = 100.0d) double d7, @FloatRange(from = 0.0d, to = 108.883d) double d8, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double z5 = z(d6 / f37467a);
        double z6 = z(d7 / f37468b);
        double z7 = z(d8 / f37469c);
        dArr[0] = Math.max(0.0d, (116.0d * z6) - 16.0d);
        dArr[1] = (z5 - z6) * 500.0d;
        dArr[2] = (z6 - z7) * 200.0d;
    }

    public static void j(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f6, @NonNull float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f7 = 1.0f - f6;
        fArr3[0] = o(fArr[0], fArr2[0], f6);
        fArr3[1] = (fArr[1] * f7) + (fArr2[1] * f6);
        fArr3[2] = (fArr[2] * f7) + (fArr2[2] * f6);
    }

    public static void k(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d6, @NonNull double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d7 = 1.0d - d6;
        dArr3[0] = (dArr[0] * d7) + (dArr2[0] * d6);
        dArr3[1] = (dArr[1] * d7) + (dArr2[1] * d6);
        dArr3[2] = (dArr[2] * d7) + (dArr2[2] * d6);
    }

    public static double x(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    @ColorInt
    public static int A(@ColorInt int i6, @IntRange(from = 0, to = 255) int i7) {
        if (i7 < 0 || i7 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i6 & 16777215) | (i7 << 24);
    }

    public static void c(@FloatRange(from = 0.0d, to = 100.0d) double d6, @FloatRange(from = -128.0d, to = 127.0d) double d7, @FloatRange(from = -128.0d, to = 127.0d) double d8, @NonNull double[] dArr) {
        double d9 = (d6 + 16.0d) / 116.0d;
        double d10 = (d7 / 500.0d) + d9;
        double d11 = d9 - (d8 / 200.0d);
        double pow = Math.pow(d10, 3.0d);
        if (pow <= f37470d) {
            pow = ((d10 * 116.0d) - 16.0d) / f37471e;
        }
        double pow2 = d6 > 7.9996247999999985d ? Math.pow(d9, 3.0d) : d6 / f37471e;
        double pow3 = Math.pow(d11, 3.0d);
        if (pow3 <= f37470d) {
            pow3 = ((d11 * 116.0d) - 16.0d) / f37471e;
        }
        dArr[0] = pow * f37467a;
        dArr[1] = pow2 * f37468b;
        dArr[2] = pow3 * f37469c;
    }

    public static void f(@IntRange(from = 0, to = 255) int i6, @IntRange(from = 0, to = 255) int i7, @IntRange(from = 0, to = 255) int i8, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d6 = i6 / 255.0d;
        double pow = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        double d7 = i7 / 255.0d;
        double pow2 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
        double d8 = i8 / 255.0d;
        double pow3 = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * f37468b;
        dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * f37468b;
        dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * f37468b;
    }

    @ColorInt
    public static int i(@ColorInt int i6, @ColorInt int i7, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        float f7 = 1.0f - f6;
        return Color.argb((int) ((Color.alpha(i6) * f7) + (Color.alpha(i7) * f6)), (int) ((Color.red(i6) * f7) + (Color.red(i7) * f6)), (int) ((Color.green(i6) * f7) + (Color.green(i7) * f6)), (int) ((Color.blue(i6) * f7) + (Color.blue(i7) * f6)));
    }

    @VisibleForTesting
    static float o(float f6, float f7, float f8) {
        if (Math.abs(f7 - f6) > 180.0f) {
            if (f7 > f6) {
                f6 += 360.0f;
            } else {
                f7 += 360.0f;
            }
        }
        return (f6 + ((f7 - f6) * f8)) % 360.0f;
    }

    private static int s(int i6, int i7) {
        return 255 - (((255 - i7) * (255 - i6)) / 255);
    }

    private static int u(int i6, int i7, int i8, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        return (((i6 * 255) * i7) + ((i8 * i9) * (255 - i7))) / (i10 * 255);
    }

    private static float v(float f6, float f7, float f8) {
        return f6 < f7 ? f7 : f6 > f8 ? f8 : f6;
    }

    private static int w(int i6, int i7, int i8) {
        return i6 < i7 ? i7 : i6 > i8 ? i8 : i6;
    }

    private static double[] y() {
        ThreadLocal<double[]> threadLocal = f37474h;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private a() {
    }

    @ColorInt
    public static int b(@FloatRange(from = 0.0d, to = 100.0d) double d6, @FloatRange(from = -128.0d, to = 127.0d) double d7, @FloatRange(from = -128.0d, to = 127.0d) double d8) {
        double[] y5 = y();
        c(d6, d7, d8, y5);
        return g(y5[0], y5[1], y5[2]);
    }

    public static void e(@IntRange(from = 0, to = 255) int i6, @IntRange(from = 0, to = 255) int i7, @IntRange(from = 0, to = 255) int i8, @NonNull double[] dArr) {
        f(i6, i7, i8, dArr);
        h(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static double l(@ColorInt int i6, @ColorInt int i7) {
        if (Color.alpha(i7) == 255) {
            if (Color.alpha(i6) < 255) {
                i6 = t(i6, i7);
            }
            double m6 = m(i6) + 0.05d;
            double m7 = m(i7) + 0.05d;
            return Math.max(m6, m7) / Math.min(m6, m7);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i7));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double m(@ColorInt int i6) {
        double[] y5 = y();
        r(i6, y5);
        return y5[1] / f37468b;
    }

    public static int n(@ColorInt int i6, @ColorInt int i7, float f6) {
        int i8 = 255;
        if (Color.alpha(i7) == 255) {
            double d6 = f6;
            if (l(A(i6, 255), i7) < d6) {
                return -1;
            }
            int i9 = 0;
            for (int i10 = 0; i10 <= 10 && i8 - i9 > 1; i10++) {
                int i11 = (i9 + i8) / 2;
                if (l(A(i6, i11), i7) < d6) {
                    i9 = i11;
                } else {
                    i8 = i11;
                }
            }
            return i8;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i7));
    }

    public static void p(@ColorInt int i6, @NonNull float[] fArr) {
        d(Color.red(i6), Color.green(i6), Color.blue(i6), fArr);
    }

    public static void q(@ColorInt int i6, @NonNull double[] dArr) {
        e(Color.red(i6), Color.green(i6), Color.blue(i6), dArr);
    }

    public static void r(@ColorInt int i6, @NonNull double[] dArr) {
        f(Color.red(i6), Color.green(i6), Color.blue(i6), dArr);
    }

    public static int t(@ColorInt int i6, @ColorInt int i7) {
        int alpha = Color.alpha(i7);
        int alpha2 = Color.alpha(i6);
        int s5 = s(alpha2, alpha);
        return Color.argb(s5, u(Color.red(i6), alpha2, Color.red(i7), alpha, s5), u(Color.green(i6), alpha2, Color.green(i7), alpha, s5), u(Color.blue(i6), alpha2, Color.blue(i7), alpha, s5));
    }

    @ColorInt
    public static int g(@FloatRange(from = 0.0d, to = 95.047d) double d6, @FloatRange(from = 0.0d, to = 100.0d) double d7, @FloatRange(from = 0.0d, to = 108.883d) double d8) {
        double d9;
        double d10;
        double d11;
        double d12 = (((3.2406d * d6) + ((-1.5372d) * d7)) + ((-0.4986d) * d8)) / f37468b;
        double d13 = ((((-0.9689d) * d6) + (1.8758d * d7)) + (0.0415d * d8)) / f37468b;
        double d14 = (((0.0557d * d6) + ((-0.204d) * d7)) + (1.057d * d8)) / f37468b;
        if (d12 > 0.0031308d) {
            d9 = (Math.pow(d12, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d9 = d12 * 12.92d;
        }
        if (d13 > 0.0031308d) {
            d10 = (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d10 = d13 * 12.92d;
        }
        if (d14 > 0.0031308d) {
            d11 = (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d11 = 12.92d * d14;
        }
        return Color.rgb(w((int) Math.round(d9 * 255.0d), 0, 255), w((int) Math.round(d10 * 255.0d), 0, 255), w((int) Math.round(d11 * 255.0d), 0, 255));
    }

    private static double z(double d6) {
        if (d6 > f37470d) {
            return Math.pow(d6, 0.3333333333333333d);
        }
        return ((d6 * f37471e) + 16.0d) / 116.0d;
    }
}
