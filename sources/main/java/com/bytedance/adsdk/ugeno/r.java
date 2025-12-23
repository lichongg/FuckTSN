package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.up.oq;
import com.bytedance.adsdk.ugeno.up.tl;
import com.bytedance.adsdk.ugeno.up.up;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static volatile r f23713j;
    private com.bytedance.adsdk.ugeno.cw.j.j ae;
    private com.bytedance.adsdk.ugeno.cw.cw cw;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.cw.xt.r f23714m;

    /* renamed from: r, reason: collision with root package name */
    private j f23715r;
    private com.bytedance.adsdk.ugeno.r.j up;
    private List<com.bytedance.adsdk.ugeno.cw.xt> xt;

    public static r j() {
        if (f23713j == null) {
            synchronized (r.class) {
                try {
                    if (f23713j == null) {
                        f23713j = new r();
                    }
                } finally {
                }
            }
        }
        return f23713j;
    }

    private void m() {
        ArrayList arrayList = new ArrayList();
        this.xt = arrayList;
        com.bytedance.adsdk.ugeno.cw.cw cwVar = this.cw;
        if (cwVar != null) {
            arrayList.addAll(cwVar.j());
        }
        com.bytedance.adsdk.ugeno.cw.r.j(this.xt);
    }

    public com.bytedance.adsdk.ugeno.r.j cw() {
        return this.up;
    }

    public com.bytedance.adsdk.ugeno.cw.xt.r r() {
        return this.f23714m;
    }

    public com.bytedance.adsdk.ugeno.cw.j.j up() {
        return this.ae;
    }

    public j xt() {
        return this.f23715r;
    }

    private r() {
    }

    public void j(Context context, com.bytedance.adsdk.ugeno.cw.cw cwVar, j jVar) {
        this.cw = cwVar;
        this.f23715r = jVar;
        m();
    }

    public void j(com.bytedance.adsdk.ugeno.r.j jVar) {
        this.up = jVar;
    }

    public void j(tl tlVar) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.up.j().j());
        if (tlVar != null) {
            arrayList.addAll(tlVar.j());
        }
        oq.j(arrayList);
    }

    public void j(com.bytedance.adsdk.ugeno.up.cw cwVar) {
        ArrayList arrayList = new ArrayList(new up().j());
        if (cwVar != null) {
            arrayList.addAll(cwVar.j());
        }
        com.bytedance.adsdk.ugeno.up.r.j(arrayList);
    }

    public void j(com.bytedance.adsdk.ugeno.cw.xt.r rVar) {
        this.f23714m = rVar;
    }

    public void j(com.bytedance.adsdk.ugeno.cw.j.j jVar) {
        this.ae = jVar;
    }
}
