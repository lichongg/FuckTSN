package com.bytedance.sdk.openadsdk.av;

import android.text.TextUtils;
import com.bytedance.embedapplog.up;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private String f27625j;
    private up.j xt;

    public r(up.j jVar) {
        this.xt = jVar;
        if (jVar == null || TextUtils.isEmpty(jVar.f24072j) || TextUtils.equals("00000000-0000-0000-0000-000000000000", jVar.f24072j)) {
            this.f27625j = "error";
        }
    }

    public String getType() {
        return this.f27625j;
    }

    public up.j j() {
        return this.xt;
    }

    public r(String str) {
        this.f27625j = str;
    }
}
