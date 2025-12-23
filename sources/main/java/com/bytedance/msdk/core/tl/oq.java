package com.bytedance.msdk.core.tl;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq {

    /* renamed from: j, reason: collision with root package name */
    private static final String f24706j = "TTMediationSDK_" + oq.class.getSimpleName();
    private com.bytedance.msdk.up.j.cw<g> cw;
    private Map<String, g> xt;

    /* renamed from: com.bytedance.msdk.core.tl.oq$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static oq f24707j = new oq(null);
    }

    /* synthetic */ oq(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static oq j() {
        return j.f24707j;
    }

    public g xt(String str) {
        if (this.cw == null) {
            return null;
        }
        Map<String, g> map = this.xt;
        g gVar = map != null ? map.get(str) : null;
        if (gVar != null) {
            return gVar;
        }
        g query = this.cw.query(str);
        if (query != null) {
            this.xt.put(query.xt(), query);
        }
        return query;
    }

    private oq() {
        this.cw = new com.bytedance.msdk.up.j.r(com.bytedance.msdk.core.xt.getContext());
        this.xt = new ConcurrentHashMap();
    }

    public void j(String str, long j6) {
        if (this.cw != null) {
            Map<String, g> map = this.xt;
            g gVar = map != null ? map.get(str) : null;
            if (gVar != null) {
                gVar.j(j6);
            }
            this.cw.j(str, j6);
        }
    }

    public g xt(String str, String str2) {
        g gVar = null;
        if (this.cw == null) {
            return null;
        }
        Map<String, g> map = this.xt;
        if (map != null) {
            gVar = map.get(str + "_" + str2);
        }
        if (gVar != null) {
            return gVar;
        }
        g query = this.cw.query(str, str2);
        if (query != null) {
            this.xt.put(query.r(), query);
        }
        return query;
    }

    public void j(String str, String str2, long j6) {
        g gVar;
        if (this.cw != null) {
            Map<String, g> map = this.xt;
            if (map != null) {
                gVar = map.get(str + "_" + str2);
            } else {
                gVar = null;
            }
            if (gVar != null) {
                gVar.j(j6);
            }
            this.cw.j(str, str2, j6);
        }
    }

    public void j(String str) {
        if (this.cw != null) {
            Map<String, g> map = this.xt;
            if (map != null) {
                map.remove(str);
            }
            this.cw.delete(str);
        }
    }

    public void j(String str, String str2) {
        if (this.cw != null) {
            Map<String, g> map = this.xt;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.cw.delete(str, str2);
        }
    }

    public void j(g gVar) {
        if (this.cw == null || TextUtils.isEmpty(gVar.oq())) {
            return;
        }
        Map<String, g> map = this.xt;
        if (map != null) {
            map.put(gVar.r(), gVar);
        }
        this.cw.xt(gVar);
    }
}
