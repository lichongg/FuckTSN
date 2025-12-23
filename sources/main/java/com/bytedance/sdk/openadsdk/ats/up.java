package com.bytedance.sdk.openadsdk.ats;

import android.util.Pair;
import java.util.HashMap;

@ATS(single = true, value = {"system_info"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements com.bytedance.sdk.component.r.up {

    /* renamed from: j, reason: collision with root package name */
    private static HashMap<String, j> f27615j = new HashMap<>();
    private com.bytedance.sdk.component.r.up xt = new com.bytedance.sdk.openadsdk.ats.j.cw();

    /* renamed from: com.bytedance.sdk.openadsdk.ats.up$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class j {
        long cw;

        /* renamed from: j, reason: collision with root package name */
        String f27616j;

        /* renamed from: r, reason: collision with root package name */
        boolean f27617r;
        int xt;

        private j() {
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(1)
    public String j(String str) {
        Pair<j, Boolean> up = up(str);
        if (((Boolean) up.second).booleanValue()) {
            ((j) up.first).f27616j = this.xt.j(str);
        }
        return ((j) up.first).f27616j;
    }

    private Pair<j, Boolean> up(String str) {
        j jVar = f27615j.get(str);
        if (jVar != null) {
            return new Pair<>(jVar, Boolean.FALSE);
        }
        j jVar2 = new j(null);
        f27615j.put(str, jVar2);
        return new Pair<>(jVar2, Boolean.TRUE);
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(3)
    public long cw(String str) {
        Pair<j, Boolean> up = up(str);
        if (((Boolean) up.second).booleanValue()) {
            ((j) up.first).cw = this.xt.cw(str);
        }
        return ((j) up.first).cw;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(4)
    public boolean r(String str) {
        Pair<j, Boolean> up = up(str);
        if (((Boolean) up.second).booleanValue()) {
            ((j) up.first).f27617r = this.xt.r(str);
        }
        return ((j) up.first).f27617r;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(2)
    public int xt(String str) {
        Pair<j, Boolean> up = up(str);
        if (((Boolean) up.second).booleanValue()) {
            ((j) up.first).xt = this.xt.xt(str);
        }
        return ((j) up.first).xt;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(5)
    public void j(String str, String str2) {
        this.xt.j(str, str2);
    }
}
