package com.bytedance.sdk.component.m.cw;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.m.i;
import com.bytedance.sdk.component.m.jy;
import com.bytedance.sdk.component.m.mi;
import com.bytedance.sdk.component.m.tj;
import com.bytedance.sdk.component.m.vl;
import com.bytedance.sdk.component.m.w;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    private vl ae;

    /* renamed from: g, reason: collision with root package name */
    private i f26574g;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.component.m.r f26576m;
    private ExecutorService tl;
    private final jy xt;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, List<cw>> f26575j = new ConcurrentHashMap();
    private Map<String, w> cw = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private Map<String, mi> f26577r = new HashMap();
    private Map<String, com.bytedance.sdk.component.m.cw> up = new HashMap();

    private com.bytedance.sdk.component.m.cw m(com.bytedance.sdk.component.m.xt xtVar) {
        com.bytedance.sdk.component.m.cw ae = this.xt.ae();
        return ae != null ? ae : new com.bytedance.sdk.component.m.cw.j.j.xt(xtVar.up(), xtVar.j(), m());
    }

    private w r(com.bytedance.sdk.component.m.xt xtVar) {
        w up = this.xt.up();
        return up != null ? com.bytedance.sdk.component.m.cw.j.xt.j.j(up) : com.bytedance.sdk.component.m.cw.j.xt.j.j(xtVar.xt());
    }

    private mi up(com.bytedance.sdk.component.m.xt xtVar) {
        mi m6 = this.xt.m();
        return m6 != null ? m6 : com.bytedance.sdk.component.m.cw.j.xt.up.j(xtVar.tl());
    }

    public Collection<com.bytedance.sdk.component.m.cw> cw() {
        return this.up.values();
    }

    public Collection<w> j() {
        return this.cw.values();
    }

    public Collection<mi> xt() {
        return this.f26577r.values();
    }

    private com.bytedance.sdk.component.m.r g() {
        com.bytedance.sdk.component.m.r r5 = this.xt.r();
        return r5 == null ? com.bytedance.sdk.component.m.xt.xt.j() : r5;
    }

    private vl oq() {
        vl j6 = this.xt.j();
        return j6 != null ? j6 : com.bytedance.sdk.component.m.j.xt.j();
    }

    private ExecutorService qv() {
        ExecutorService xt = this.xt.xt();
        return xt != null ? xt : com.bytedance.sdk.component.m.j.cw.j();
    }

    private i vl() {
        i tl = this.xt.tl();
        return tl == null ? new ae() : tl;
    }

    public Map<String, List<cw>> ae() {
        return this.f26575j;
    }

    public com.bytedance.sdk.component.m.cw cw(com.bytedance.sdk.component.m.xt xtVar) {
        if (xtVar == null) {
            xtVar = com.bytedance.sdk.component.m.cw.j.j.g();
        }
        String file = xtVar.up().toString();
        com.bytedance.sdk.component.m.cw cwVar = this.up.get(file);
        if (cwVar != null) {
            return cwVar;
        }
        com.bytedance.sdk.component.m.cw m6 = m(xtVar);
        this.up.put(file, m6);
        return m6;
    }

    public w j(com.bytedance.sdk.component.m.xt xtVar) {
        if (xtVar == null) {
            xtVar = com.bytedance.sdk.component.m.cw.j.j.g();
        }
        String file = xtVar.up().toString();
        w wVar = this.cw.get(file);
        if (wVar != null) {
            return wVar;
        }
        w r5 = r(xtVar);
        this.cw.put(file, r5);
        return r5;
    }

    public i tl() {
        if (this.f26574g == null) {
            this.f26574g = vl();
        }
        return this.f26574g;
    }

    public mi xt(com.bytedance.sdk.component.m.xt xtVar) {
        if (xtVar == null) {
            xtVar = com.bytedance.sdk.component.m.cw.j.j.g();
        }
        String file = xtVar.up().toString();
        mi miVar = this.f26577r.get(file);
        if (miVar != null) {
            return miVar;
        }
        mi up = up(xtVar);
        this.f26577r.put(file, up);
        return up;
    }

    public m(Context context, jy jyVar) {
        this.xt = (jy) tl.j(jyVar);
        com.bytedance.sdk.component.m.cw.j.j.j(context, jyVar.g());
    }

    public ExecutorService m() {
        ExecutorService j6;
        tj cw = this.xt.cw();
        if (cw != null && (j6 = cw.j()) != null) {
            return j6;
        }
        if (this.tl == null) {
            this.tl = qv();
        }
        return this.tl;
    }

    public vl up() {
        if (this.ae == null) {
            this.ae = oq();
        }
        return this.ae;
    }

    public com.bytedance.sdk.component.m.r r() {
        if (this.f26576m == null) {
            this.f26576m = g();
        }
        return this.f26576m;
    }

    public com.bytedance.sdk.component.m.cw j(String str) {
        return cw(com.bytedance.sdk.component.m.cw.j.j.j(new File(str)));
    }

    public com.bytedance.sdk.component.m.cw.xt.j j(cw cwVar) {
        ImageView.ScaleType up = cwVar.up();
        if (up == null) {
            up = com.bytedance.sdk.component.m.cw.xt.j.f26591j;
        }
        ImageView.ScaleType scaleType = up;
        Bitmap.Config vl = cwVar.vl();
        if (vl == null) {
            vl = com.bytedance.sdk.component.m.cw.xt.j.xt;
        }
        return new com.bytedance.sdk.component.m.cw.xt.j(cwVar.cw(), cwVar.r(), scaleType, vl, cwVar.g(), cwVar.oq());
    }
}
