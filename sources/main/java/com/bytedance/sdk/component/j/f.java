package com.bytedance.sdk.component.j;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
class f {
    private final qv cw;

    /* renamed from: j, reason: collision with root package name */
    private final Collection<String> f26481j;

    /* renamed from: r, reason: collision with root package name */
    private final Set<j> f26482r;
    private final Map<String, tj> xt;

    interface j {
    }

    tj j(String str) {
        if (this.f26481j.contains(str) || TextUtils.equals(str, "host")) {
            return j(str, null);
        }
        throw new IllegalArgumentException("Namespace: " + str + " not registered.");
    }

    void xt(j jVar) {
        this.f26482r.remove(jVar);
    }

    void j(j jVar) {
        this.f26482r.add(jVar);
    }

    private tj j(String str, JSONObject jSONObject) {
        tj tjVar = this.xt.get(str);
        if (tjVar == null) {
            tj tjVar2 = new tj(str, this.cw.cw(), this.cw.j(), this.cw.xt(), jSONObject);
            this.xt.put(str, tjVar2);
            return tjVar2;
        }
        if (jSONObject != null) {
            tjVar.update(jSONObject);
        }
        return tjVar;
    }
}
