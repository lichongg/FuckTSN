package com.bytedance.adsdk.ugeno.cw.j;

import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.adsdk.ugeno.xt.cw;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class xt implements w {

    /* renamed from: j, reason: collision with root package name */
    protected w f23611j;

    /* renamed from: r, reason: collision with root package name */
    protected JSONObject f23612r;
    protected String xt;
    protected boolean cw = true;
    protected boolean up = false;

    public abstract void cw(av avVar, w.xt xtVar, w.j jVar);

    public void j(JSONObject jSONObject) {
        this.f23612r = jSONObject;
    }

    public void xt(boolean z5) {
        this.up = z5;
    }

    public void j(String str) {
        this.xt = str;
    }

    protected void xt(av avVar, w.xt xtVar, w.j jVar) {
        w wVar = this.f23611j;
        if (wVar == null) {
            return;
        }
        wVar.j(avVar, xtVar, jVar);
    }

    public xt(w wVar) {
        this.f23611j = wVar;
    }

    public void j(boolean z5) {
        this.cw = z5;
    }

    public boolean j() {
        String str;
        return this.cw && (str = this.xt) != null && "3".compareTo(str) <= 0 && this.f23612r != null;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(av avVar, w.xt xtVar, w.j jVar) {
        if (j()) {
            cw(avVar, xtVar, jVar);
        } else {
            xt(avVar, xtVar, jVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(cw cwVar, String str, m.j jVar) {
        w wVar = this.f23611j;
        if (wVar == null) {
            return;
        }
        wVar.j(cwVar, str, jVar);
    }
}
