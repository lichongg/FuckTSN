package com.bytedance.pangle.res.j;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv {
    static int j(ae aeVar) {
        return (int) aeVar.f25483j.j().xt();
    }

    static byte[] j(int i6) {
        return new byte[]{(byte) i6, (byte) (i6 >> 8), (byte) (i6 >> 16), (byte) (i6 >> 24)};
    }

    static int j(byte[] bArr, int i6, int i7, tl tlVar) {
        if (i6 < 2130706432) {
            return i6;
        }
        int j6 = tlVar.j(i6);
        byte[] j7 = j(j6);
        bArr[i7] = j7[0];
        bArr[i7 + 1] = j7[1];
        bArr[i7 + 2] = j7[2];
        bArr[i7 + 3] = j7[3];
        return j6;
    }

    static void j(byte[] bArr, tl tlVar) throws IOException {
        xt xtVar = new xt(bArr, tlVar);
        xtVar.xt(new ByteArrayInputStream(bArr));
        while (xtVar.cw() != 1) {
        }
    }

    static void j(String str, byte[] bArr, tl tlVar) throws Throwable {
        if (!TextUtils.isEmpty(str) && tlVar.j(str)) {
            if (str.equals("AndroidManifest.xml")) {
                j(bArr, tlVar);
                return;
            }
            if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
                j(bArr, tlVar);
            } else if (str.equals("resources.arsc")) {
                new j(bArr, tlVar).j();
            }
        }
    }

    public static void j(int i6, byte[] bArr, int[] iArr, int i7, HashMap<Integer, Integer> hashMap) {
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        int i8 = -1;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = iArr[(i9 * 5) + 1];
            if (hashMap.containsKey(Integer.valueOf(i10))) {
                if (i8 == -1) {
                    i8 = i9;
                }
                int i11 = (i9 * 20) + i6;
                hashMap2.put(Integer.valueOf(i9), Arrays.copyOfRange(bArr, i11, i11 + 20));
                Integer num = hashMap.get(Integer.valueOf(i10));
                num.intValue();
                hashMap3.put(num, Integer.valueOf(i9));
            }
        }
        ArrayList arrayList = new ArrayList(hashMap3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            Integer num2 = (Integer) hashMap3.get((Integer) it.next());
            num2.intValue();
            byte[] bArr2 = (byte[]) hashMap2.get(num2);
            System.arraycopy(bArr2, 0, bArr, ((i12 + i8) * 20) + i6, bArr2.length);
            i12++;
        }
    }
}
