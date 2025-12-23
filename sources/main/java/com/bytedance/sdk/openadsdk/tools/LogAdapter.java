package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.component.sdk.annotation.Keep;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.wq.j.cw;

@Keep
/* loaded from: D:\Downloads\app\classes4.dex */
public class LogAdapter implements com.bytedance.sdk.component.j {

    /* renamed from: j, reason: collision with root package name */
    public static LogAdapter f31848j;
    private cw.j xt;

    public cw.j j() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.j
    public void xt(String str, String str2) {
        cw.j jVar = this.xt;
        if (jVar != null) {
            jVar.r(str, str2);
        }
    }

    public static void j(cw.j jVar, boolean z5) {
        LogAdapter logAdapter = new LogAdapter();
        f31848j = logAdapter;
        if (z5) {
            logAdapter.xt = new j(jVar);
        } else {
            logAdapter.xt = jVar;
        }
    }

    @Keep
    public static void zzz(TTILog tTILog) {
        if (h.xt > 5300 && f31848j == null && tTILog != null) {
            j((cw.j) new cw.xt(tTILog), false);
        }
    }

    @Override // com.bytedance.sdk.component.j
    public void cw(String str, String str2) {
        cw.j jVar = this.xt;
        if (jVar != null) {
            jVar.up(str, str2);
        }
    }

    public void r(String str, String str2) {
        cw.j jVar = this.xt;
        if (jVar != null) {
            jVar.xt(str, str2);
        }
    }

    private LogAdapter() {
    }

    @Override // com.bytedance.sdk.component.j
    public void xt(String str, String str2, Throwable th) {
        cw.j jVar = this.xt;
        if (jVar != null) {
            jVar.xt(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.j
    public void j(String str, String str2) {
        cw.j jVar = this.xt;
        if (jVar != null) {
            jVar.cw(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.j
    public void j(String str, String str2, Throwable th) {
        cw.j jVar = this.xt;
        if (jVar != null) {
            jVar.j(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.j
    public void j(String str, Throwable th) {
        cw.j jVar = this.xt;
        if (jVar != null) {
            jVar.j(str, th);
        }
    }
}
