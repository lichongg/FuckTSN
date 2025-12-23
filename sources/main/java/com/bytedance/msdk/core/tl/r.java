package com.bytedance.msdk.core.tl;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class r {
    protected String cw;

    /* renamed from: j, reason: collision with root package name */
    protected String f24711j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f24712m;

    /* renamed from: r, reason: collision with root package name */
    protected String f24713r;
    protected int up;
    protected String xt;

    public int ae() {
        return this.up;
    }

    public String cw() {
        return this.xt;
    }

    public boolean j() {
        return this.f24712m;
    }

    public String m() {
        return this.f24713r;
    }

    public String r() {
        if (TextUtils.isEmpty(this.xt)) {
            return this.f24711j;
        }
        return this.f24711j + "_" + this.xt;
    }

    public boolean tl() {
        return this.up == 1;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f24711j + "', showRulesVersion='" + this.cw + "', timingMode=" + this.up + '}';
    }

    public String up() {
        return this.cw;
    }

    public String xt() {
        return this.f24711j;
    }

    public r(String str, String str2, String str3, String str4, int i6) {
        this.f24711j = str;
        this.cw = str3;
        this.up = i6;
        this.xt = str2;
        this.f24712m = !TextUtils.isEmpty(str2);
        this.f24713r = str4;
    }
}
