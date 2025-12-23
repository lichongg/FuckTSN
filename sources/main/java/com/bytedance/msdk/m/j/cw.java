package com.bytedance.msdk.m.j;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class cw {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.j.j.cw f25157j;
    private final Set<String> xt = new CopyOnWriteArraySet();
    private final AtomicBoolean cw = new AtomicBoolean(false);

    private synchronized void cw(com.bytedance.msdk.api.r.qv qvVar) {
        try {
            if (up()) {
                return;
            }
            String cw = cw();
            if (!TextUtils.isEmpty(cw)) {
                throw new Exception("adn init ".concat(String.valueOf(cw)));
            }
            Map<String, Object> j6 = j();
            if (j6 == null) {
                throw new Exception("adn init getConfig() is null");
            }
            j6.put(MediationConstant.EXTRA_ADN_NAME, xt());
            j6.put("q_x_c", Integer.valueOf(com.bytedance.msdk.ae.j.j.j().r()));
            j6.put("wf_q_x_c", Integer.valueOf(com.bytedance.msdk.ae.j.j.j().up()));
            com.bytedance.msdk.j.j.r j7 = com.bytedance.msdk.m.xt.xt.j().j(xt(), qvVar);
            if (j7 == null) {
                throw new Exception("configuration is null");
            }
            j(j7, j6);
            r();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            com.bytedance.msdk.m.xt.j.j(xt(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, th.toString()));
        }
    }

    protected abstract String cw();

    protected abstract Map<String, Object> j();

    public void m() {
        xt((com.bytedance.msdk.api.r.qv) null);
    }

    public final synchronized void r() {
        this.cw.set(true);
    }

    public synchronized void tl() {
        if (!up()) {
            m();
        }
    }

    public final synchronized boolean up() {
        return this.cw.get();
    }

    protected abstract String xt();

    private void xt(com.bytedance.msdk.api.r.qv qvVar) {
        com.bytedance.msdk.core.oq.j j6 = com.bytedance.msdk.core.xt.xt().j(xt());
        if (qvVar != null || j6 != null || "pangle_custom".equals(xt()) || MediationConstant.ADN_PANGLE.equals(xt())) {
            cw(qvVar);
        }
    }

    public void j(com.bytedance.msdk.api.r.qv qvVar) {
        xt(qvVar);
    }

    protected com.bytedance.msdk.core.oq.j ae() {
        return com.bytedance.msdk.core.xt.xt().j(xt());
    }

    public void j(com.bytedance.msdk.api.r.qv qvVar, com.bytedance.msdk.j.j.cw cwVar) {
        this.f25157j = cwVar;
        xt(qvVar);
    }

    private synchronized void j(com.bytedance.msdk.j.j.r rVar, Map<String, Object> map) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.msdk.j.up.cw.j("TMe", "--==--time: start " + xt());
        rVar.j(com.bytedance.msdk.core.xt.getContext(), map, new com.bytedance.msdk.j.j.cw() { // from class: com.bytedance.msdk.m.j.cw.1
            @Override // com.bytedance.msdk.j.j.cw
            public void j() {
                if (cw.this.f25157j != null) {
                    cw.this.f25157j.j();
                }
                if (TextUtils.equals(cw.this.xt(), MediationConstant.ADN_PANGLE)) {
                    x.j();
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                com.bytedance.msdk.j.up.cw.j("TMe", "--==--time: " + cw.this.xt() + ", ----==----- " + elapsedRealtime2);
                if (!cw.this.xt.contains(cw.this.xt())) {
                    cw.this.xt.add(cw.this.xt());
                    l.cw(cw.this.xt(), elapsedRealtime2);
                }
                com.bytedance.msdk.m.xt.j.j(cw.this.xt(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
            }

            @Override // com.bytedance.msdk.j.j.cw
            public void j(@NonNull com.bytedance.msdk.api.j jVar) {
                if (cw.this.f25157j != null) {
                    cw.this.f25157j.j(jVar);
                }
                if (jVar != null) {
                    com.bytedance.msdk.m.xt.j.j(cw.this.xt(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + jVar.f24334j + " errorMessage = " + jVar.xt));
                }
            }
        });
    }
}
