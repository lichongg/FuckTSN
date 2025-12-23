package com.bytedance.sdk.component.tl.xt;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.tl.j.ae;
import com.bytedance.sdk.component.tl.j.g;
import com.bytedance.sdk.component.tl.j.m;
import com.bytedance.sdk.component.tl.j.r;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.vl;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements ae {

    /* renamed from: r, reason: collision with root package name */
    private static volatile com.bytedance.sdk.component.tl.j.j.j f26803r;
    private g cw;

    /* renamed from: j, reason: collision with root package name */
    private up f26804j;
    private Context xt;

    public xt(com.bytedance.sdk.component.tl.j.j jVar) {
        j(jVar);
    }

    public void xt(up upVar) {
        this.f26804j = upVar;
        this.xt = upVar.getContext();
        this.cw = new com.bytedance.sdk.component.tl.xt.xt.xt(this.f26804j);
    }

    public static com.bytedance.sdk.component.tl.j.j.j m() {
        if (f26803r == null) {
            synchronized (xt.class) {
                try {
                    if (f26803r == null) {
                        f26803r = new com.bytedance.sdk.component.tl.xt.up.j();
                    }
                } finally {
                }
            }
        }
        return f26803r;
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public up cw() {
        up upVar = this.f26804j;
        if (upVar == null) {
            return null;
        }
        return upVar;
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public g r() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public r up() {
        up upVar = this.f26804j;
        if (upVar == null) {
            return null;
        }
        return upVar.r();
    }

    public xt() {
    }

    private boolean ae() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    private void xt(final com.bytedance.sdk.component.tl.j.xt xtVar) {
        up upVar = this.f26804j;
        if (upVar != null && this.cw != null) {
            final r r5 = upVar.r();
            if (xtVar == null || r5 == null || this.f26804j.getContext() == null || r5.tl() == null) {
                return;
            }
            if (this.f26804j.qv()) {
                if (j(this.f26804j.getContext(), r5)) {
                    this.cw.j(xtVar);
                    return;
                }
                ae();
                if (ae()) {
                    r5.tl().execute(new com.bytedance.sdk.component.tl.xt.up.xt("dispatchEvent") { // from class: com.bytedance.sdk.component.tl.xt.xt.2
                        @Override // java.lang.Runnable
                        public void run() {
                            xt.this.j(xtVar, r5.oq());
                        }
                    });
                    return;
                } else {
                    j(xtVar, r5.oq());
                    return;
                }
            }
            this.cw.j(xtVar);
            return;
        }
        vl.r("log_error", "dispatch event configManager is null");
    }

    public void j(up upVar) {
        xt(upVar);
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public void j(m mVar) {
        up upVar = this.f26804j;
        if (upVar != null) {
            if (mVar == null) {
                mVar = com.bytedance.sdk.component.tl.xt.j.j.j.xt.f26768j;
            }
            upVar.j(mVar);
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public void j(boolean z5) {
        up upVar = this.f26804j;
        if (upVar != null) {
            upVar.j(z5);
        }
    }

    private boolean j(Context context, r rVar) {
        if (context == null || rVar == null) {
            return false;
        }
        if (rVar.oq() == 1) {
            return rVar.jy();
        }
        try {
            return i.j(context);
        } catch (Throwable th) {
            vl.j(th);
            return true;
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public void j() {
        final r r5;
        up upVar = this.f26804j;
        if (upVar == null || (r5 = upVar.r()) == null || this.f26804j.getContext() == null || r5.tl() == null) {
            return;
        }
        if (this.f26804j.qv()) {
            if (j(this.f26804j.getContext(), r5)) {
                g gVar = this.cw;
                if (gVar != null) {
                    gVar.j();
                    return;
                }
                return;
            }
            if (ae()) {
                r5.tl().execute(new com.bytedance.sdk.component.tl.xt.up.xt("start") { // from class: com.bytedance.sdk.component.tl.xt.xt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        up unused = xt.this.f26804j;
                        xt.this.j(r5.oq());
                    }
                });
                return;
            } else {
                j(r5.oq());
                return;
            }
        }
        g gVar2 = this.cw;
        if (gVar2 != null) {
            gVar2.j();
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public void xt() {
        g gVar = this.cw;
        if (gVar != null) {
            gVar.xt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6) {
        if (i6 == 0 || i6 == 2) {
            com.bytedance.sdk.component.tl.xt.xt.xt.j.j(this.f26804j);
        } else if (i6 == 1) {
            com.bytedance.sdk.component.tl.xt.xt.xt.xt.xt(this.f26804j);
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public void j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        xt(xtVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.component.tl.j.xt xtVar, int i6) {
        if (i6 == 0 || i6 == 2) {
            com.bytedance.sdk.component.tl.xt.xt.xt.j.j(xtVar, this.f26804j);
        } else if (i6 == 1) {
            com.bytedance.sdk.component.tl.xt.xt.xt.xt.j(xtVar, this.f26804j);
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public void j(final String str, final List<String> list, final boolean z5, Map<String, String> map, final JSONObject jSONObject) {
        up upVar = this.f26804j;
        if (upVar == null) {
            vl.r("log_error", "track configManager is null");
            return;
        }
        final r r5 = upVar.r();
        if (r5 == null || this.f26804j.getContext() == null || r5.tl() == null || !r5.m()) {
            return;
        }
        if (r5.oq() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (r5.oq() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (this.f26804j.qv() && !j(this.f26804j.getContext(), r5)) {
            if (ae()) {
                r5.tl().execute(new com.bytedance.sdk.component.tl.xt.up.xt("trackFailed") { // from class: com.bytedance.sdk.component.tl.xt.xt.3
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.j(str, (List<String>) list, z5, r5.oq(), jSONObject);
                    }
                });
                return;
            } else {
                j(str, list, z5, r5.oq(), jSONObject);
                return;
            }
        }
        com.bytedance.sdk.component.tl.xt.m.j.j(this.f26804j).j(str, list, z5, map, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, List<String> list, boolean z5, int i6, JSONObject jSONObject) {
        if (i6 == 0) {
            com.bytedance.sdk.component.tl.xt.xt.xt.j.j(str, list, z5, this.f26804j, jSONObject);
        } else if (i6 == 1) {
            com.bytedance.sdk.component.tl.xt.xt.xt.xt.j(str, list, z5, this.f26804j);
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.ae
    public void j(final String str) {
        up upVar = this.f26804j;
        if (upVar == null) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("log_error", "trackFailedUrls configManager is null", upVar);
            return;
        }
        final r r5 = upVar.r();
        if (r5 == null || this.f26804j.getContext() == null || r5.tl() == null || !r5.m()) {
            return;
        }
        if (r5.oq() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f26804j.qv() && !j(this.f26804j.getContext(), r5)) {
            if (ae()) {
                r5.tl().execute(new com.bytedance.sdk.component.tl.xt.up.xt("trackFailed") { // from class: com.bytedance.sdk.component.tl.xt.xt.4
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.j(str, r5.oq());
                    }
                });
                return;
            } else {
                j(str, r5.oq());
                return;
            }
        }
        com.bytedance.sdk.component.tl.xt.m.j.j(this.f26804j).j(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, int i6) {
        if (i6 == 0) {
            com.bytedance.sdk.component.tl.xt.xt.xt.j.j(str, this.f26804j);
        } else if (i6 == 1) {
            com.bytedance.sdk.component.tl.xt.xt.xt.xt.j(str, this.f26804j);
        }
    }
}
