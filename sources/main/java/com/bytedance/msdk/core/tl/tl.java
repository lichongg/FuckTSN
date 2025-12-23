package com.bytedance.msdk.core.tl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {

    /* renamed from: j, reason: collision with root package name */
    private static final String f24714j = "TTMediationSDK_" + tl.class.getSimpleName();
    private com.bytedance.msdk.up.j.j<ae> cw;
    private Map<String, ae> xt;

    /* renamed from: com.bytedance.msdk.core.tl.tl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static tl f24715j = new tl(null);
    }

    /* synthetic */ tl(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static tl j() {
        return j.f24715j;
    }

    public ae xt(String str) {
        if (this.cw != null) {
            Map<String, ae> map = this.xt;
            ae aeVar = map != null ? map.get(str) : null;
            if (aeVar != null) {
                return aeVar;
            }
            ae query = this.cw.query(str);
            if (query != null) {
                Map<String, ae> map2 = this.xt;
                if (map2 != null) {
                    map2.put(query.r(), query);
                }
                return query;
            }
        }
        return null;
    }

    private tl() {
        this.cw = new com.bytedance.msdk.up.j.xt(com.bytedance.msdk.core.xt.getContext());
        this.xt = new ConcurrentHashMap();
    }

    public void j(String str) {
        if (this.cw != null) {
            Map<String, ae> map = this.xt;
            if (map != null) {
                map.remove(str);
            }
            this.cw.delete(str);
        }
    }

    public void j(String str, String str2) {
        if (this.cw != null) {
            Map<String, ae> map = this.xt;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.cw.delete(str, str2);
        }
    }

    public ae xt(String str, String str2) {
        ae aeVar;
        if (this.cw != null) {
            Map<String, ae> map = this.xt;
            if (map != null) {
                aeVar = map.get(str + "_" + str2);
            } else {
                aeVar = null;
            }
            if (aeVar != null) {
                return aeVar;
            }
            ae query = this.cw.query(str, str2);
            if (query != null) {
                Map<String, ae> map2 = this.xt;
                if (map2 != null) {
                    map2.put(query.r(), query);
                }
                return query;
            }
        }
        return null;
    }

    public void j(ae aeVar) {
        ae xt;
        up upVar;
        if (aeVar.j()) {
            xt = xt(aeVar.xt(), aeVar.cw());
        } else {
            xt = xt(aeVar.xt());
        }
        if (xt == null) {
            if (this.cw != null) {
                Map<String, ae> map = this.xt;
                if (map != null) {
                    map.put(aeVar.r(), aeVar);
                }
                this.cw.xt(aeVar);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        for (up upVar2 : xt.qv()) {
            hashMap.put(upVar2.cw(), upVar2);
        }
        for (up upVar3 : aeVar.qv()) {
            if (hashMap.containsKey(upVar3.cw()) && (upVar = (up) hashMap.get(upVar3.cw())) != null) {
                upVar3.j(upVar);
            }
        }
        Map<String, ae> map2 = this.xt;
        if (map2 != null) {
            map2.put(aeVar.r(), aeVar);
        }
        xt(aeVar);
    }

    public void xt(ae aeVar) {
        if (this.cw != null) {
            Map<String, ae> map = this.xt;
            if (map != null) {
                map.put(aeVar.r(), aeVar);
            }
            this.cw.j(aeVar);
        }
    }

    public void j(ae aeVar, String str, int i6) {
        if (this.cw != null) {
            aeVar.j(str, i6);
            Map<String, ae> map = this.xt;
            if (map != null) {
                map.put(aeVar.r(), aeVar);
            }
            this.cw.j(aeVar);
        }
    }

    public void j(ae aeVar, String str, long j6) {
        if (this.cw != null) {
            aeVar.j(str, j6);
            Map<String, ae> map = this.xt;
            if (map != null) {
                map.put(aeVar.r(), aeVar);
            }
            this.cw.j(aeVar);
        }
    }
}
