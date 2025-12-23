package com.acse.ottn;

import android.view.animation.Interpolator;
import com.acse.ottn.w1;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class x1 {

    /* renamed from: a, reason: collision with root package name */
    public int f5477a;

    /* renamed from: b, reason: collision with root package name */
    public w1 f5478b;

    /* renamed from: c, reason: collision with root package name */
    public w1 f5479c;

    /* renamed from: d, reason: collision with root package name */
    public Interpolator f5480d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<w1> f5481e;

    /* renamed from: f, reason: collision with root package name */
    public m4 f5482f;

    public static x1 a(int... iArr) {
        int length = iArr.length;
        w1.b[] bVarArr = new w1.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (w1.b) w1.b(0.0f);
            bVarArr[1] = (w1.b) w1.a(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (w1.b) w1.a(0.0f, iArr[0]);
            for (int i6 = 1; i6 < length; i6++) {
                bVarArr[i6] = (w1.b) w1.a(i6 / (length - 1), iArr[i6]);
            }
        }
        return new t1(bVarArr);
    }

    public String toString() {
        String str = " ";
        for (int i6 = 0; i6 < this.f5477a; i6++) {
            str = str + this.f5481e.get(i6).e() + "  ";
        }
        return str;
    }

    public x1(w1... w1VarArr) {
        this.f5477a = w1VarArr.length;
        ArrayList<w1> arrayList = new ArrayList<>();
        this.f5481e = arrayList;
        arrayList.addAll(Arrays.asList(w1VarArr));
        this.f5478b = this.f5481e.get(0);
        w1 w1Var = this.f5481e.get(this.f5477a - 1);
        this.f5479c = w1Var;
        this.f5480d = w1Var.c();
    }

    public static x1 a(float... fArr) {
        int length = fArr.length;
        w1.a[] aVarArr = new w1.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (w1.a) w1.a(0.0f);
            aVarArr[1] = (w1.a) w1.a(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (w1.a) w1.a(0.0f, fArr[0]);
            for (int i6 = 1; i6 < length; i6++) {
                aVarArr[i6] = (w1.a) w1.a(i6 / (length - 1), fArr[i6]);
            }
        }
        return new e1(aVarArr);
    }

    public static x1 a(w1... w1VarArr) {
        int length = w1VarArr.length;
        int i6 = 0;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (w1 w1Var : w1VarArr) {
            if (w1Var instanceof w1.a) {
                z5 = true;
            } else if (w1Var instanceof w1.b) {
                z6 = true;
            } else {
                z7 = true;
            }
        }
        if (z5 && !z6 && !z7) {
            w1.a[] aVarArr = new w1.a[length];
            while (i6 < length) {
                aVarArr[i6] = (w1.a) w1VarArr[i6];
                i6++;
            }
            return new e1(aVarArr);
        }
        if (z6 && !z5 && !z7) {
            w1.b[] bVarArr = new w1.b[length];
            while (i6 < length) {
                bVarArr[i6] = (w1.b) w1VarArr[i6];
                i6++;
            }
            return new t1(bVarArr);
        }
        return new x1(w1VarArr);
    }

    public static x1 a(Object... objArr) {
        int length = objArr.length;
        w1.c[] cVarArr = new w1.c[Math.max(length, 2)];
        if (length == 1) {
            cVarArr[0] = (w1.c) w1.c(0.0f);
            cVarArr[1] = (w1.c) w1.a(1.0f, objArr[0]);
        } else {
            cVarArr[0] = (w1.c) w1.a(0.0f, objArr[0]);
            for (int i6 = 1; i6 < length; i6++) {
                cVarArr[i6] = (w1.c) w1.a(i6 / (length - 1), objArr[i6]);
            }
        }
        return new x1(cVarArr);
    }

    public void a(m4 m4Var) {
        this.f5482f = m4Var;
    }

    @Override // 
    /* renamed from: a */
    public x1 clone() {
        ArrayList<w1> arrayList = this.f5481e;
        int size = arrayList.size();
        w1[] w1VarArr = new w1[size];
        for (int i6 = 0; i6 < size; i6++) {
            w1VarArr[i6] = arrayList.get(i6).clone();
        }
        return new x1(w1VarArr);
    }

    public Object a(float f6) {
        int i6 = this.f5477a;
        if (i6 == 2) {
            Interpolator interpolator = this.f5480d;
            if (interpolator != null) {
                f6 = interpolator.getInterpolation(f6);
            }
            return this.f5482f.evaluate(f6, this.f5478b.e(), this.f5479c.e());
        }
        int i7 = 1;
        if (f6 <= 0.0f) {
            w1 w1Var = this.f5481e.get(1);
            Interpolator c6 = w1Var.c();
            if (c6 != null) {
                f6 = c6.getInterpolation(f6);
            }
            float b6 = this.f5478b.b();
            return this.f5482f.evaluate((f6 - b6) / (w1Var.b() - b6), this.f5478b.e(), w1Var.e());
        }
        if (f6 >= 1.0f) {
            w1 w1Var2 = this.f5481e.get(i6 - 2);
            Interpolator c7 = this.f5479c.c();
            if (c7 != null) {
                f6 = c7.getInterpolation(f6);
            }
            float b7 = w1Var2.b();
            return this.f5482f.evaluate((f6 - b7) / (this.f5479c.b() - b7), w1Var2.e(), this.f5479c.e());
        }
        w1 w1Var3 = this.f5478b;
        while (i7 < this.f5477a) {
            w1 w1Var4 = this.f5481e.get(i7);
            if (f6 < w1Var4.b()) {
                Interpolator c8 = w1Var4.c();
                if (c8 != null) {
                    f6 = c8.getInterpolation(f6);
                }
                float b8 = w1Var3.b();
                return this.f5482f.evaluate((f6 - b8) / (w1Var4.b() - b8), w1Var3.e(), w1Var4.e());
            }
            i7++;
            w1Var3 = w1Var4;
        }
        return this.f5479c.e();
    }
}
