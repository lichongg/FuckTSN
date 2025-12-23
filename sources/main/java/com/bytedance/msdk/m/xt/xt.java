package com.bytedance.msdk.m.xt;

import com.bytedance.msdk.api.r.qv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private static volatile xt cw;

    /* renamed from: j, reason: collision with root package name */
    public qv f25197j;
    private final Map<String, com.bytedance.msdk.j.j.r> xt = new ConcurrentHashMap();

    public static xt j() {
        if (cw == null) {
            synchronized (xt.class) {
                try {
                    if (cw == null) {
                        cw = new xt();
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    public Collection<com.bytedance.msdk.j.j.r> cw() {
        return this.xt.values();
    }

    public synchronized Map<String, com.bytedance.msdk.j.j.r> xt() {
        return this.xt;
    }

    private com.bytedance.msdk.j.j.r cw(String str) {
        return MediationConstant.ADN_PANGLE.equalsIgnoreCase(str) ? new com.bytedance.msdk.j.cw.j() : new r();
    }

    private com.bytedance.msdk.j.j.r xt(String str) {
        if (str == null) {
            return null;
        }
        return this.xt.get(str);
    }

    private xt() {
    }

    public com.bytedance.msdk.j.j.r j(String str, qv qvVar) {
        this.f25197j = qvVar;
        return j(str);
    }

    public synchronized com.bytedance.msdk.j.j.r j(String str) {
        com.bytedance.msdk.j.j.r xt;
        qv qvVar;
        try {
            xt = xt(str);
            if (xt == null) {
                com.bytedance.msdk.core.oq.j j6 = com.bytedance.msdk.core.xt.xt().j(str);
                if (j6 == null && (qvVar = this.f25197j) != null) {
                    j6 = new com.bytedance.msdk.core.oq.j(qvVar.cw(), this.f25197j.r());
                    this.f25197j = null;
                }
                if (j6 != null && !j6.r()) {
                    xt = cw(str);
                }
                if (xt != null) {
                    j(str, xt);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return xt;
    }

    private void j(String str, com.bytedance.msdk.j.j.r rVar) {
        if (str == null) {
            return;
        }
        this.xt.put(str, rVar);
    }
}
