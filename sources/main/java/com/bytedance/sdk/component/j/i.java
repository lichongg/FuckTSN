package com.bytedance.sdk.component.j;

import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.j.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class i {

    /* renamed from: j, reason: collision with root package name */
    static f f26484j;
    private final com.bytedance.sdk.component.jy.cw cw;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f26485m;

    /* renamed from: r, reason: collision with root package name */
    private final oq f26486r;
    private final List<ws> up;
    private final j xt;

    public static oq j(com.bytedance.sdk.component.jy.cw cwVar) {
        return new oq(cwVar);
    }

    private void xt() {
        if (this.f26485m) {
            g.j(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    @AnyThread
    public <T> void j(String str, T t5) {
        xt();
        this.xt.j(str, (String) t5);
    }

    i(oq oqVar) {
        tj tjVar;
        f fVar;
        ArrayList arrayList = new ArrayList();
        this.up = arrayList;
        this.f26485m = false;
        this.f26486r = oqVar;
        if (oqVar.tl && (fVar = f26484j) != null) {
            tjVar = fVar.j(oqVar.qv);
        } else {
            tjVar = null;
        }
        if (oqVar.f26498j != null) {
            j jVar = oqVar.xt;
            if (jVar == null) {
                this.xt = new ch();
            } else {
                this.xt = jVar;
            }
        } else {
            this.xt = oqVar.xt;
        }
        this.xt.j(oqVar, tjVar);
        this.cw = oqVar.f26498j;
        arrayList.add(oqVar.oq);
        g.j(oqVar.f26499m);
        x.j(oqVar.ae);
    }

    public i j(String str, up<?, ?> upVar) {
        return j(str, (String) null, upVar);
    }

    @UiThread
    public i j(String str, String str2, up<?, ?> upVar) {
        xt();
        this.xt.ae.j(str, upVar);
        return this;
    }

    public i j(String str, r.xt xtVar) {
        return j(str, (String) null, xtVar);
    }

    @UiThread
    public i j(String str, String str2, r.xt xtVar) {
        xt();
        this.xt.ae.j(str, xtVar);
        return this;
    }

    public void j() {
        if (this.f26485m) {
            return;
        }
        this.xt.xt();
        this.f26485m = true;
        Iterator<ws> it = this.up.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
