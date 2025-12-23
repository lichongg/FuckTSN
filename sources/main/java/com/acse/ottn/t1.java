package com.acse.ottn;

import android.view.animation.Interpolator;
import com.acse.ottn.w1;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class t1 extends x1 {

    /* renamed from: g, reason: collision with root package name */
    public int f5309g;

    /* renamed from: h, reason: collision with root package name */
    public int f5310h;

    /* renamed from: i, reason: collision with root package name */
    public int f5311i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5312j;

    @Override // com.acse.ottn.x1
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t1 clone() {
        ArrayList<w1> arrayList = this.f5481e;
        int size = arrayList.size();
        w1.b[] bVarArr = new w1.b[size];
        for (int i6 = 0; i6 < size; i6++) {
            bVarArr[i6] = (w1.b) arrayList.get(i6).clone();
        }
        return new t1(bVarArr);
    }

    @Override // com.acse.ottn.x1
    public Object a(float f6) {
        return Integer.valueOf(b(f6));
    }

    public t1(w1.b... bVarArr) {
        super(bVarArr);
        this.f5312j = true;
    }

    public int b(float f6) {
        int h6;
        int i6;
        int h7;
        int h8;
        float f7;
        int i7 = this.f5477a;
        if (i7 != 2) {
            if (f6 <= 0.0f) {
                w1.b bVar = (w1.b) this.f5481e.get(0);
                w1.b bVar2 = (w1.b) this.f5481e.get(1);
                h7 = bVar.h();
                h8 = bVar2.h();
                float b6 = bVar.b();
                float b7 = bVar2.b();
                Interpolator c6 = bVar2.c();
                if (c6 != null) {
                    f6 = c6.getInterpolation(f6);
                }
                f7 = (f6 - b6) / (b7 - b6);
                m4 m4Var = this.f5482f;
                if (m4Var != null) {
                    return ((Number) m4Var.evaluate(f7, Integer.valueOf(h7), Integer.valueOf(h8))).intValue();
                }
            } else if (f6 >= 1.0f) {
                w1.b bVar3 = (w1.b) this.f5481e.get(i7 - 2);
                w1.b bVar4 = (w1.b) this.f5481e.get(this.f5477a - 1);
                h7 = bVar3.h();
                h8 = bVar4.h();
                float b8 = bVar3.b();
                float b9 = bVar4.b();
                Interpolator c7 = bVar4.c();
                if (c7 != null) {
                    f6 = c7.getInterpolation(f6);
                }
                f7 = (f6 - b8) / (b9 - b8);
                m4 m4Var2 = this.f5482f;
                if (m4Var2 != null) {
                    return ((Number) m4Var2.evaluate(f7, Integer.valueOf(h7), Integer.valueOf(h8))).intValue();
                }
            } else {
                w1.b bVar5 = (w1.b) this.f5481e.get(0);
                int i8 = 1;
                while (true) {
                    int i9 = this.f5477a;
                    if (i8 < i9) {
                        w1.b bVar6 = (w1.b) this.f5481e.get(i8);
                        if (f6 < bVar6.b()) {
                            Interpolator c8 = bVar6.c();
                            if (c8 != null) {
                                f6 = c8.getInterpolation(f6);
                            }
                            f6 = (f6 - bVar5.b()) / (bVar6.b() - bVar5.b());
                            h6 = bVar5.h();
                            int h9 = bVar6.h();
                            m4 m4Var3 = this.f5482f;
                            if (m4Var3 != null) {
                                return ((Number) m4Var3.evaluate(f6, Integer.valueOf(h6), Integer.valueOf(h9))).intValue();
                            }
                            i6 = h9 - h6;
                        } else {
                            i8++;
                            bVar5 = bVar6;
                        }
                    } else {
                        return ((Number) this.f5481e.get(i9 - 1).e()).intValue();
                    }
                }
            }
            return h7 + ((int) (f7 * (h8 - h7)));
        }
        if (this.f5312j) {
            this.f5312j = false;
            this.f5309g = ((w1.b) this.f5481e.get(0)).h();
            int h10 = ((w1.b) this.f5481e.get(1)).h();
            this.f5310h = h10;
            this.f5311i = h10 - this.f5309g;
        }
        Interpolator interpolator = this.f5480d;
        if (interpolator != null) {
            f6 = interpolator.getInterpolation(f6);
        }
        m4 m4Var4 = this.f5482f;
        if (m4Var4 == null) {
            h6 = this.f5309g;
            i6 = this.f5311i;
        } else {
            return ((Number) m4Var4.evaluate(f6, Integer.valueOf(this.f5309g), Integer.valueOf(this.f5310h))).intValue();
        }
        return h6 + ((int) (f6 * i6));
    }
}
