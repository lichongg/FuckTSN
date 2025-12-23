package com.bytedance.msdk.cw.j.j;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class cw extends com.bytedance.msdk.xt.cw {

    /* renamed from: g, reason: collision with root package name */
    protected com.bytedance.msdk.cw.cw.xt.j.j.xt f24993g;
    protected Function<SparseArray<Object>, Object> oq;

    @Override // com.bytedance.msdk.xt.cw
    public void j(Map<String, Object> map) {
        int i6;
        if (map == null) {
            return;
        }
        try {
            Object obj = map.get("bidding_lose_reason_NUM");
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            i6 = intValue > 0 ? intValue : 10001;
        } catch (Exception unused) {
            i6 = 10001;
        }
        j(false, -1.0d, i6, null);
    }

    @Override // com.bytedance.msdk.xt.cw
    public boolean up() {
        return false;
    }

    @Override // com.bytedance.msdk.xt.cw
    public Integer m() {
        com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar = this.f24993g;
        return xtVar != null ? xtVar.oq() : super.m();
    }

    public cw(com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar, Function<SparseArray<Object>, Object> function) {
        this.f24993g = xtVar;
        this.oq = function;
    }

    @Override // com.bytedance.msdk.xt.cw
    public void av() {
        super.av();
        com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar = this.f24993g;
        if (xtVar != null) {
            xtVar.qv();
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void i() {
        super.i();
        com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar = this.f24993g;
        if (xtVar != null) {
            xtVar.vl();
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void w() {
        super.w();
        com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar = this.f24993g;
        if (xtVar != null) {
            xtVar.jy();
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void xt(Map<String, Object> map) {
        j(true, t(), -1, null);
    }

    public void j(boolean z5, double d6, int i6, Map<String, Object> map) {
        com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar = this.f24993g;
        if (xtVar != null) {
            xtVar.j(z5, d6, i6, map);
        }
    }
}
