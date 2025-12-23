package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class QuantizerCelebi {
    public static Map<Integer, Integer> quantize(int[] iArr, int i6) {
        Set<Integer> keySet = new QuantizerWu().quantize(iArr, i6).colorToCount.keySet();
        int[] iArr2 = new int[keySet.size()];
        Iterator<Integer> it = keySet.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            iArr2[i7] = it.next().intValue();
            i7++;
        }
        return QuantizerWsmeans.quantize(iArr, iArr2, i6);
    }

    private QuantizerCelebi() {
    }
}
