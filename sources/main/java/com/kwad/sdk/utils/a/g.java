package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class g implements c.b<Set<String>> {
    static final g bcN = new g();

    private static Set<String> g(byte[] bArr, int i6, int i7) {
        int i8;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i7 > 0) {
            b bVar = new b(bArr, i6);
            int i9 = i6 + i7;
            while (true) {
                i8 = bVar.position;
                if (i8 >= i9) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.Sq()));
            }
            if (i8 != i9) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final String SK() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] p(Set<String> set) {
        return e(set);
    }

    private g() {
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i6 = 0;
        int i7 = 0;
        for (String str : set) {
            if (str == null) {
                i6 += 5;
                iArr[i7] = -1;
            } else {
                int hD = b.hD(str);
                strArr[i7] = str;
                iArr[i7] = hD;
                i6 += b.fa(hD) + hD;
            }
            i7++;
        }
        b bVar = new b(i6);
        for (int i8 = 0; i8 < size; i8++) {
            int i9 = iArr[i8];
            bVar.eZ(i9);
            if (i9 >= 0) {
                bVar.hC(strArr[i8]);
            }
        }
        return bVar.bbV;
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> f(byte[] bArr, int i6, int i7) {
        return g(bArr, i6, i7);
    }
}
