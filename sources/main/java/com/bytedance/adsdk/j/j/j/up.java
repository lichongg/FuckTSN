package com.bytedance.adsdk.j.j.j;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
class up {
    int ae;

    /* renamed from: m, reason: collision with root package name */
    int f23164m;

    /* renamed from: r, reason: collision with root package name */
    int f23165r;
    int up;

    void j(com.bytedance.adsdk.j.j.xt.j jVar) throws IOException {
    }

    static int j(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    up() {
    }

    void xt(com.bytedance.adsdk.j.j.xt.j jVar) throws IOException {
        int r5 = jVar.r();
        j(jVar);
        int r6 = r5 - jVar.r();
        int i6 = this.f23165r;
        if (r6 <= i6) {
            if (r6 < i6) {
                jVar.j(i6 - r6);
                return;
            }
            return;
        }
        throw new IOException("Out of chunk area");
    }
}
