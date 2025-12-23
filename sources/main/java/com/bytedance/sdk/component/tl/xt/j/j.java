package com.bytedance.sdk.component.tl.xt.j;

import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {
    public List<com.bytedance.sdk.component.tl.j.xt> j(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, List<String> list, String str) {
        if (com.bytedance.sdk.component.tl.xt.cw.j.j(i6)) {
            return xt(i6, xtVar, z5, list, str);
        }
        if (j(xtVar)) {
            return xt(i6, xtVar, z5, list, str);
        }
        return null;
    }

    public abstract boolean j(com.bytedance.sdk.component.tl.j.xt xtVar);

    public abstract boolean j(String str);

    public abstract List<com.bytedance.sdk.component.tl.j.xt> xt(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, List<String> list, String str);

    public abstract boolean xt(int i6, String str, com.bytedance.sdk.component.tl.j.xt xtVar);

    public boolean j(int i6, String str, com.bytedance.sdk.component.tl.j.xt xtVar) {
        if (com.bytedance.sdk.component.tl.xt.cw.j.j(i6)) {
            return j(str);
        }
        if (j(xtVar)) {
            return xt(i6, str, xtVar);
        }
        return false;
    }
}
