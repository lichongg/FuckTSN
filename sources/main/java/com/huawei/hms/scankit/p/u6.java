package com.huawei.hms.scankit.p;

import android.os.Parcel;
import android.os.Parcelable;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class u6 implements Parcelable {
    public static final Parcelable.Creator<u6> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final float f34876a;

    /* renamed from: b, reason: collision with root package name */
    private final float f34877b;

    /* renamed from: c, reason: collision with root package name */
    private int f34878c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34879d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Parcelable.Creator<u6> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public u6 createFromParcel(Parcel parcel) {
            return new u6(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public u6[] newArray(int i6) {
            return new u6[i6];
        }

        a() {
        }
    }

    public u6(float f6, float f7, int i6) {
        this.f34879d = false;
        this.f34876a = f6;
        this.f34877b = f7;
        this.f34878c = i6;
    }

    public int a() {
        return this.f34878c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static void a(u6[] u6VarArr) {
        float a6 = a(u6VarArr[0], u6VarArr[1]);
        float a7 = a(u6VarArr[1], u6VarArr[2]);
        float a8 = a(u6VarArr[0], u6VarArr[2]);
        int[] a9 = a(a7, a6, a8);
        int i6 = a9[0];
        int i7 = a9[1];
        int i8 = a9[2];
        u6 u6Var = u6VarArr[i6];
        u6 u6Var2 = u6VarArr[i7];
        u6 u6Var3 = u6VarArr[i8];
        float[] fArr = {a7, a8, a6};
        if (r3.f34739j % 2 == 0) {
            int i9 = ((fArr[i7] / fArr[i6]) > 1.1d ? 1 : ((fArr[i7] / fArr[i6]) == 1.1d ? 0 : -1));
        }
        if (a(u6Var2, u6Var, u6Var3) < 0.0f) {
            u6Var2 = u6Var3;
            u6Var3 = u6Var2;
        }
        u6VarArr[0] = u6Var2;
        u6VarArr[1] = u6Var;
        u6VarArr[2] = u6Var3;
    }

    public final float b() {
        return this.f34876a;
    }

    public final float c() {
        return this.f34877b;
    }

    public boolean d() {
        return this.f34879d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u6) {
            u6 u6Var = (u6) obj;
            if (Math.abs(this.f34876a - u6Var.f34876a) < 1.0E-4d && Math.abs(this.f34877b - u6Var.f34877b) < 1.0E-4d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f34876a) * 31) + Float.floatToIntBits(this.f34877b);
    }

    public final String toString() {
        return "(" + this.f34876a + StringUtil.COMMA + this.f34877b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.f34876a);
        parcel.writeFloat(this.f34877b);
    }

    public u6(float f6, float f7) {
        this.f34878c = 0;
        this.f34879d = false;
        this.f34876a = f6;
        this.f34877b = f7;
    }

    public u6(float f6, float f7, boolean z5) {
        this.f34878c = 0;
        this.f34876a = f6;
        this.f34877b = f7;
        this.f34879d = z5;
    }

    protected u6(Parcel parcel) {
        this.f34878c = 0;
        this.f34879d = false;
        this.f34876a = parcel.readFloat();
        this.f34877b = parcel.readFloat();
    }

    private static int[] a(float f6, float f7, float f8) {
        int i6 = 1;
        int i7 = 2;
        int i8 = 0;
        if (f6 >= f7 && f6 >= f8) {
            i6 = 0;
            if (f7 <= f8) {
                i7 = 1;
                i8 = 2;
            }
            i8 = 1;
        } else if (f8 < f6 || f8 < f7) {
            i6 = 2;
            if (f6 > f6) {
                i7 = 0;
                i8 = 1;
            } else {
                i7 = 1;
            }
        } else if (f6 > f7) {
            i7 = 0;
            i8 = 2;
        }
        return new int[]{i6, i7, i8};
    }

    public static float a(u6 u6Var, u6 u6Var2) {
        return s4.a(u6Var.f34876a, u6Var.f34877b, u6Var2.f34876a, u6Var2.f34877b);
    }

    private static float a(u6 u6Var, u6 u6Var2, u6 u6Var3) {
        float f6 = u6Var2.f34876a;
        float f7 = u6Var2.f34877b;
        return ((u6Var3.f34876a - f6) * (u6Var.f34877b - f7)) - ((u6Var3.f34877b - f7) * (u6Var.f34876a - f6));
    }
}
