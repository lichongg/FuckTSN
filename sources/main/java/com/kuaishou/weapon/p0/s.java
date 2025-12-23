package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;

/* loaded from: D:\Downloads\app\classes6.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public int f36115a;

    /* renamed from: b, reason: collision with root package name */
    public int f36116b;

    /* renamed from: c, reason: collision with root package name */
    public String f36117c;

    /* renamed from: d, reason: collision with root package name */
    public String f36118d;

    /* renamed from: e, reason: collision with root package name */
    public String f36119e;

    /* renamed from: f, reason: collision with root package name */
    public Context f36120f;

    /* renamed from: g, reason: collision with root package name */
    public ClassLoader f36121g;

    /* renamed from: h, reason: collision with root package name */
    public String f36122h;

    /* renamed from: i, reason: collision with root package name */
    public String f36123i;

    /* renamed from: j, reason: collision with root package name */
    public String f36124j;

    /* renamed from: k, reason: collision with root package name */
    public String f36125k;

    /* renamed from: l, reason: collision with root package name */
    public ActivityInfo[] f36126l;

    /* renamed from: m, reason: collision with root package name */
    public String f36127m;

    /* renamed from: n, reason: collision with root package name */
    public String f36128n;

    /* renamed from: o, reason: collision with root package name */
    public String f36129o;

    /* renamed from: p, reason: collision with root package name */
    public int f36130p;

    /* renamed from: q, reason: collision with root package name */
    public int f36131q;

    /* renamed from: r, reason: collision with root package name */
    public PackageInfo f36132r;

    /* renamed from: s, reason: collision with root package name */
    public long f36133s;

    /* renamed from: t, reason: collision with root package name */
    public int f36134t;

    /* renamed from: u, reason: collision with root package name */
    public int f36135u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f36136v;

    /* renamed from: w, reason: collision with root package name */
    public int f36137w;

    /* renamed from: x, reason: collision with root package name */
    public int f36138x = -1;

    /* renamed from: y, reason: collision with root package name */
    public boolean f36139y;

    public s() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        String str = this.f36117c;
        if (str == null) {
            if (sVar.f36117c != null) {
                return false;
            }
        } else if (!str.equals(sVar.f36117c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f36117c;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public s(PackageInfo packageInfo, int i6, String str, String str2, String str3, String str4) {
        this.f36132r = packageInfo;
        this.f36115a = i6;
        this.f36117c = str;
        this.f36118d = str2;
        this.f36123i = str3;
        this.f36124j = str4;
    }
}
