package com.danikula.videocache.file;

import android.text.TextUtils;
import com.danikula.videocache.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f32171a = 4;

    private String a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 6 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.danikula.videocache.file.c
    public String generate(String str) {
        String a6 = a(str);
        String d6 = p.d(str);
        if (TextUtils.isEmpty(a6)) {
            return d6;
        }
        return d6 + "." + a6;
    }
}
