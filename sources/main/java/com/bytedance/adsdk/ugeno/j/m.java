package com.bytedance.adsdk.ugeno.j;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    private List<cw> f23692j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xt.cw f23693r;
    private List<j> xt;

    public void j() {
        List<j> list = this.xt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (j jVar : this.xt) {
            if (jVar != null) {
                jVar.r();
            }
        }
    }

    private void r() {
        this.xt = new ArrayList();
        List<cw> list = this.f23692j;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i6 = 0; i6 < this.f23692j.size(); i6++) {
            cw cwVar = this.f23692j.get(i6);
            if (cwVar != null) {
                this.xt.add(new j(this.cw, this.f23693r, cwVar));
            }
        }
    }

    public void cw() {
        List<j> list = this.xt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (j jVar : this.xt) {
            if (jVar != null) {
                jVar.cw();
            }
        }
    }

    public void xt() {
        List<j> list = this.xt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (j jVar : this.xt) {
            if (jVar != null) {
                jVar.j();
            }
        }
    }

    public m(Context context, com.bytedance.adsdk.ugeno.xt.cw cwVar, List<cw> list) {
        this.f23693r = cwVar;
        this.cw = context;
        this.f23692j = list;
        r();
    }

    public void j(Canvas canvas) {
        List<j> list = this.xt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (j jVar : this.xt) {
            if (jVar != null) {
                jVar.j(canvas);
            }
        }
    }

    public void j(int i6, int i7) {
        List<j> list = this.xt;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (j jVar : this.xt) {
            if (jVar != null) {
                jVar.j(i6, i7);
            }
        }
    }

    public j j(String str) {
        List<j> list = this.xt;
        if (list != null && !list.isEmpty()) {
            for (j jVar : this.xt) {
                if (jVar != null && TextUtils.equals(jVar.up(), str)) {
                    return jVar;
                }
            }
        }
        return null;
    }
}
