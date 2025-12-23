package w4;

import android.text.TextUtils;
import master.flame.danmaku.danmaku.model.android.f;
import master.flame.danmaku.danmaku.model.android.g;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a {
    private static boolean b(int i6, int i7, float[] fArr, float[] fArr2) {
        if (i6 != i7) {
            return false;
        }
        return i6 == 1 ? fArr2[0] < fArr[2] : i6 == 6 && fArr2[2] > fArr[0];
    }

    public static final boolean g(d dVar, d dVar2) {
        if (dVar == dVar2) {
            return false;
        }
        CharSequence charSequence = dVar.f50056c;
        CharSequence charSequence2 = dVar2.f50056c;
        if (charSequence == charSequence2) {
            return true;
        }
        return charSequence != null && charSequence.equals(charSequence2);
    }

    public static f a(d dVar, n nVar, f fVar, int i6) {
        if (fVar == null) {
            fVar = new f();
        }
        f fVar2 = fVar;
        fVar2.d((int) Math.ceil(dVar.f50069p), (int) Math.ceil(dVar.f50070q), nVar.getDensityDpi(), false, i6);
        g gVar = fVar2.get();
        if (gVar != null) {
            ((master.flame.danmaku.danmaku.model.b) nVar).s(dVar, gVar.f50035a, 0.0f, 0.0f, true);
            if (nVar.isHardwareAccelerated()) {
                gVar.h(nVar.getWidth(), nVar.getHeight(), nVar.o(), nVar.i());
            }
        }
        return fVar2;
    }

    public static final int d(d dVar, d dVar2) {
        CharSequence charSequence;
        if (dVar == dVar2) {
            return 0;
        }
        if (dVar == null) {
            return -1;
        }
        if (dVar2 == null) {
            return 1;
        }
        long j6 = dVar.j() - dVar2.j();
        if (j6 > 0) {
            return 1;
        }
        if (j6 < 0) {
            return -1;
        }
        int type = dVar.getType() - dVar2.getType();
        if (type > 0) {
            return 1;
        }
        if (type < 0 || (charSequence = dVar.f50056c) == null) {
            return -1;
        }
        if (dVar2.f50056c == null) {
            return 1;
        }
        int compareTo = charSequence.toString().compareTo(dVar2.f50056c.toString());
        if (compareTo != 0) {
            return compareTo;
        }
        int i6 = dVar.f50060g - dVar2.f50060g;
        if (i6 != 0) {
            return i6 < 0 ? -1 : 1;
        }
        int i7 = dVar.f50072s - dVar2.f50072s;
        return i7 != 0 ? i7 < 0 ? -1 : 1 : dVar.hashCode() - dVar.hashCode();
    }

    public static void e(d dVar, CharSequence charSequence) {
        dVar.f50056c = charSequence;
        if (TextUtils.isEmpty(charSequence) || !charSequence.toString().contains(d.L)) {
            return;
        }
        String[] split = String.valueOf(dVar.f50056c).split(d.L, -1);
        if (split.length > 1) {
            dVar.f50057d = split;
        }
    }

    public static int f(int i6, int i7, int i8) {
        return i6 * i7 * i8;
    }

    private static boolean c(n nVar, d dVar, d dVar2, long j6) {
        float[] h6 = dVar.h(nVar, j6);
        float[] h7 = dVar2.h(nVar, j6);
        if (h6 != null && h7 != null) {
            return b(dVar.getType(), dVar2.getType(), h6, h7);
        }
        return false;
    }

    public static final boolean h(n nVar, d dVar) {
        if (nVar.isHardwareAccelerated()) {
            if (dVar.f50069p > nVar.o() || dVar.f50070q > nVar.i()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean i(n nVar, d dVar, d dVar2, long j6, long j7) {
        int type = dVar.getType();
        if (type != dVar2.getType() || dVar.s()) {
            return false;
        }
        long b6 = dVar2.b() - dVar.b();
        if (b6 <= 0) {
            return true;
        }
        if (Math.abs(b6) >= j6 || dVar.w() || dVar2.w()) {
            return false;
        }
        if (type != 5 && type != 4 && !c(nVar, dVar, dVar2, j7) && !c(nVar, dVar, dVar2, dVar.b() + dVar.f())) {
            return false;
        }
        return true;
    }
}
