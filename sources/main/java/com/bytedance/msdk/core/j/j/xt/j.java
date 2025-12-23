package com.bytedance.msdk.core.j.j.xt;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.api.j.xt;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.xt.cw;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j implements com.bytedance.msdk.core.j.j.j.j {
    public Function<SparseArray<Object>, Object> cw;

    /* renamed from: j, reason: collision with root package name */
    public xt f24490j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.msdk.core.j.j.j.xt f24491r;
    public oq xt;

    protected abstract void j(Context context);

    @Override // com.bytedance.msdk.core.j.j.j.j
    public final void j(Context context, Function<SparseArray<Object>, Object> function, xt xtVar, oq oqVar, com.bytedance.msdk.core.j.j.j.xt xtVar2) {
        if (function == null || xtVar == null || oqVar == null || xtVar2 == null) {
            return;
        }
        this.f24491r = xtVar2;
        this.xt = oqVar;
        this.f24490j = xtVar;
        this.cw = function;
        j(context);
    }

    public String xt() {
        oq oqVar = this.xt;
        return (oqVar == null || !oqVar.h() || this.xt.l() == null) ? "" : this.xt.l().oq();
    }

    public boolean cw() {
        boolean z5;
        boolean z6;
        boolean z7;
        if (com.bytedance.msdk.ae.j.j.j().r() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean la = this.xt.la();
        if (com.bytedance.msdk.ae.j.j.j().up() == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (this.xt.mi() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if ((!z5 || !la) && (!z6 || !z7)) {
            return false;
        }
        return true;
    }

    public final void j(int i6, String str) {
        com.bytedance.msdk.core.j.j.j.xt xtVar = this.f24491r;
        if (xtVar != null) {
            xtVar.j(i6, str);
        }
    }

    public void j(List<cw> list) {
        com.bytedance.msdk.core.j.j.j.xt xtVar = this.f24491r;
        if (xtVar != null) {
            xtVar.j(list);
        }
    }

    public void j(cw cwVar, com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.core.j.j.j.xt xtVar = this.f24491r;
        if (xtVar != null) {
            xtVar.j(cwVar, jVar);
        }
    }

    public boolean j() {
        oq oqVar = this.xt;
        if (oqVar == null) {
            return false;
        }
        int oq = oqVar.oq();
        return oq == 1 || oq == 3;
    }
}
