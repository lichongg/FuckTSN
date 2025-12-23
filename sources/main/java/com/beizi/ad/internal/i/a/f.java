package com.beizi.ad.internal.i.a;

import android.text.TextUtils;
import com.beizi.ad.internal.i.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f implements c {
    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 6 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.beizi.ad.internal.i.a.c
    public String a(String str) {
        String b6 = b(str);
        String d6 = n.d(str);
        if (TextUtils.isEmpty(b6)) {
            return d6;
        }
        return d6 + "." + b6;
    }
}
