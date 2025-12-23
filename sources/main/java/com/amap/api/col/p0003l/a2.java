package com.amap.api.col.p0003l;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a2 {

    /* renamed from: a, reason: collision with root package name */
    int f5618a;

    /* renamed from: b, reason: collision with root package name */
    int[] f5619b;

    /* renamed from: c, reason: collision with root package name */
    int f5620c;

    /* renamed from: d, reason: collision with root package name */
    int f5621d;

    /* renamed from: e, reason: collision with root package name */
    String f5622e;

    /* renamed from: f, reason: collision with root package name */
    String f5623f;

    /* renamed from: g, reason: collision with root package name */
    String f5624g;

    public a2(int i6, int[] iArr, String str, String str2, String str3) {
        this.f5618a = i6;
        this.f5619b = iArr;
        this.f5622e = str;
        this.f5623f = str2;
        this.f5624g = str3;
        str = TextUtils.isEmpty(str) ? str2 : str;
        this.f5620c = -1000;
        if ("regions".equals(str)) {
            this.f5620c = 1001;
        } else if ("water".equals(str)) {
            this.f5620c = 1002;
        } else if ("buildings".equals(str)) {
            this.f5620c = 1003;
        } else if ("roads".equals(str)) {
            this.f5620c = 1004;
        } else if ("labels".equals(str)) {
            this.f5620c = 1005;
        } else if ("borders".equals(str)) {
            this.f5620c = 1006;
        }
        this.f5621d = (i6 * 1000) + iArr.hashCode();
    }
}
