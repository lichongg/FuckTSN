package com.bytedance.sdk.component.j;

import android.net.Uri;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.sdk.component.j.f;
import com.bytedance.sdk.component.j.qv;
import com.bytedance.sdk.component.j.tj;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
class kt {
    private final f cw = i.f26484j;

    /* renamed from: j, reason: collision with root package name */
    private final Set<String> f26491j;

    /* renamed from: r, reason: collision with root package name */
    private final tj f26492r;
    private qv.xt up;
    private final Set<String> xt;

    @MainThread
    final synchronized v j(boolean z5, String str, xt xtVar) throws tj.j {
        qv.xt xtVar2;
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (host == null) {
                return null;
            }
            v vVar = this.xt.contains(xtVar.j()) ? v.PUBLIC : null;
            for (String str2 : this.f26491j) {
                if (parse.getHost().equals(str2) || host.endsWith(".".concat(String.valueOf(str2)))) {
                    vVar = v.PRIVATE;
                    break;
                }
            }
            if (vVar == null && (xtVar2 = this.up) != null && xtVar2.j(str)) {
                if (this.up.j(str, xtVar.j())) {
                    return null;
                }
                vVar = v.PRIVATE;
            }
            v j6 = z5 ? j(str, xtVar) : xt(str, xtVar);
            return j6 != null ? j6 : vVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized v xt(String str, xt xtVar) {
        return j(str, xtVar, false);
    }

    void xt(f.j jVar) {
        f fVar = this.cw;
        if (fVar != null) {
            fVar.xt(jVar);
        }
    }

    kt(tj tjVar, Set<String> set, Set<String> set2) {
        this.f26492r = tjVar;
        if (set != null && !set.isEmpty()) {
            this.f26491j = new LinkedHashSet(set);
        } else {
            this.f26491j = new LinkedHashSet();
        }
        if (set2 != null && !set2.isEmpty()) {
            this.xt = new LinkedHashSet(set2);
        } else {
            this.xt = new LinkedHashSet();
        }
    }

    @MainThread
    final synchronized v j(String str, xt xtVar) throws tj.j {
        return j(str, xtVar, true);
    }

    void j(qv.xt xtVar) {
        this.up = xtVar;
    }

    void j(f.j jVar) {
        f fVar = this.cw;
        if (fVar != null) {
            fVar.j(jVar);
        }
    }

    private v j(String str, xt xtVar, boolean z5) {
        tj tjVar;
        if (!z5 || (tjVar = this.f26492r) == null) {
            return null;
        }
        tj.cw j6 = tjVar.j(str, this.f26491j);
        if (j6.cw.contains(xtVar.j())) {
            return null;
        }
        if (j6.xt.contains(xtVar.j())) {
            return v.PRIVATE;
        }
        if (j6.f26505j.compareTo(xtVar.xt()) < 0) {
            return null;
        }
        return j6.f26505j;
    }
}
