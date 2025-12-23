package com.acse.ottn;

import android.view.animation.Interpolator;
import com.acse.ottn.w1;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e1 extends x1 {

    /* renamed from: g, reason: collision with root package name */
    public float f4496g;

    /* renamed from: h, reason: collision with root package name */
    public float f4497h;

    /* renamed from: i, reason: collision with root package name */
    public float f4498i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4499j;

    @Override // com.acse.ottn.x1
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e1 clone() {
        ArrayList<w1> arrayList = this.f5481e;
        int size = arrayList.size();
        w1.a[] aVarArr = new w1.a[size];
        for (int i6 = 0; i6 < size; i6++) {
            aVarArr[i6] = (w1.a) arrayList.get(i6).clone();
        }
        return new e1(aVarArr);
    }

    @Override // com.acse.ottn.x1
    public Object a(float f6) {
        return Float.valueOf(b(f6));
    }

    public e1(w1.a... aVarArr) {
        super(aVarArr);
        this.f4499j = true;
    }

    public float b(float f6) {
        float h6;
        float f7;
        float h7;
        float h8;
        float f8;
        int i6 = this.f5477a;
        if (i6 != 2) {
            if (f6 <= 0.0f) {
                w1.a aVar = (w1.a) this.f5481e.get(0);
                w1.a aVar2 = (w1.a) this.f5481e.get(1);
                h7 = aVar.h();
                h8 = aVar2.h();
                float b6 = aVar.b();
                float b7 = aVar2.b();
                Interpolator c6 = aVar2.c();
                if (c6 != null) {
                    f6 = c6.getInterpolation(f6);
                }
                f8 = (f6 - b6) / (b7 - b6);
                m4 m4Var = this.f5482f;
                if (m4Var != null) {
                    return ((Number) m4Var.evaluate(f8, Float.valueOf(h7), Float.valueOf(h8))).floatValue();
                }
            } else if (f6 >= 1.0f) {
                w1.a aVar3 = (w1.a) this.f5481e.get(i6 - 2);
                w1.a aVar4 = (w1.a) this.f5481e.get(this.f5477a - 1);
                h7 = aVar3.h();
                h8 = aVar4.h();
                float b8 = aVar3.b();
                float b9 = aVar4.b();
                Interpolator c7 = aVar4.c();
                if (c7 != null) {
                    f6 = c7.getInterpolation(f6);
                }
                f8 = (f6 - b8) / (b9 - b8);
                m4 m4Var2 = this.f5482f;
                if (m4Var2 != null) {
                    return ((Number) m4Var2.evaluate(f8, Float.valueOf(h7), Float.valueOf(h8))).floatValue();
                }
            } else {
                w1.a aVar5 = (w1.a) this.f5481e.get(0);
                int i7 = 1;
                while (true) {
                    int i8 = this.f5477a;
                    if (i7 < i8) {
                        w1.a aVar6 = (w1.a) this.f5481e.get(i7);
                        if (f6 < aVar6.b()) {
                            Interpolator c8 = aVar6.c();
                            if (c8 != null) {
                                f6 = c8.getInterpolation(f6);
                            }
                            f6 = (f6 - aVar5.b()) / (aVar6.b() - aVar5.b());
                            h6 = aVar5.h();
                            float h9 = aVar6.h();
                            m4 m4Var3 = this.f5482f;
                            if (m4Var3 != null) {
                                return ((Number) m4Var3.evaluate(f6, Float.valueOf(h6), Float.valueOf(h9))).floatValue();
                            }
                            f7 = h9 - h6;
                        } else {
                            i7++;
                            aVar5 = aVar6;
                        }
                    } else {
                        return ((Number) this.f5481e.get(i8 - 1).e()).floatValue();
                    }
                }
            }
            return h7 + (f8 * (h8 - h7));
        }
        if (this.f4499j) {
            this.f4499j = false;
            this.f4496g = ((w1.a) this.f5481e.get(0)).h();
            float h10 = ((w1.a) this.f5481e.get(1)).h();
            this.f4497h = h10;
            this.f4498i = h10 - this.f4496g;
        }
        Interpolator interpolator = this.f5480d;
        if (interpolator != null) {
            f6 = interpolator.getInterpolation(f6);
        }
        m4 m4Var4 = this.f5482f;
        if (m4Var4 == null) {
            h6 = this.f4496g;
            f7 = this.f4498i;
        } else {
            return ((Number) m4Var4.evaluate(f6, Float.valueOf(this.f4496g), Float.valueOf(this.f4497h))).floatValue();
        }
        return h6 + (f6 * f7);
    }
}
