package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Score {
    private static final int BLUE_500 = -12417548;
    private static final double CUTOFF_CHROMA = 5.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ScoredComparator implements Comparator<ScoredHCT> {
        @Override // java.util.Comparator
        public int compare(ScoredHCT scoredHCT, ScoredHCT scoredHCT2) {
            return Double.compare(scoredHCT2.score, scoredHCT.score);
        }
    }

    public static List<Integer> score(Map<Integer, Integer> map) {
        return score(map, 4, BLUE_500, true);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct hct, double d6) {
            this.hct = hct;
            this.score = d6;
        }
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i6) {
        return score(map, i6, BLUE_500, true);
    }

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i6, int i7) {
        return score(map, i6, i7, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i6, int i7, boolean z5) {
        ArrayList<Hct> arrayList = new ArrayList();
        int[] iArr = new int[360];
        double d6 = 0.0d;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Hct fromInt = Hct.fromInt(entry.getKey().intValue());
            arrayList.add(fromInt);
            int floor = (int) Math.floor(fromInt.getHue());
            int intValue = entry.getValue().intValue();
            iArr[floor] = iArr[floor] + intValue;
            d6 += intValue;
        }
        double[] dArr = new double[360];
        for (int i8 = 0; i8 < 360; i8++) {
            double d7 = iArr[i8] / d6;
            for (int i9 = i8 - 14; i9 < i8 + 16; i9++) {
                int sanitizeDegreesInt = MathUtils.sanitizeDegreesInt(i9);
                dArr[sanitizeDegreesInt] = dArr[sanitizeDegreesInt] + d7;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Hct hct : arrayList) {
            double d8 = dArr[MathUtils.sanitizeDegreesInt((int) Math.round(hct.getHue()))];
            if (!z5 || (hct.getChroma() >= CUTOFF_CHROMA && d8 > CUTOFF_EXCITED_PROPORTION)) {
                arrayList2.add(new ScoredHCT(hct, (d8 * 100.0d * WEIGHT_PROPORTION) + ((hct.getChroma() - TARGET_CHROMA) * (hct.getChroma() < TARGET_CHROMA ? WEIGHT_CHROMA_BELOW : WEIGHT_CHROMA_ABOVE))));
            }
        }
        Collections.sort(arrayList2, new ScoredComparator());
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 90; i10 >= 15; i10--) {
            arrayList3.clear();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Hct hct2 = ((ScoredHCT) it.next()).hct;
                Iterator it2 = arrayList3.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        arrayList3.add(hct2);
                        break;
                    }
                    if (MathUtils.differenceDegrees(hct2.getHue(), ((Hct) it2.next()).getHue()) < i10) {
                        break;
                    }
                }
                if (arrayList3.size() >= i6) {
                    break;
                }
            }
            if (arrayList3.size() >= i6) {
                break;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.isEmpty()) {
            arrayList4.add(Integer.valueOf(i7));
            return arrayList4;
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(Integer.valueOf(((Hct) it3.next()).toInt()));
        }
        return arrayList4;
    }
}
