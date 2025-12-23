package com.bytedance.sdk.openadsdk.core.qv.j;

import com.bytedance.sdk.openadsdk.core.qv.r.cw;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements ITTDownloadAdapter.OnEventLogHandler {
    private cw.j mPluginLogHandler;

    public boolean onEventLog(int i6, String str, String str2, String str3, Object obj) {
        cw.j jVar = this.mPluginLogHandler;
        if (jVar != null) {
            return jVar.j(i6, str, str2, str3, obj);
        }
        return false;
    }

    public j(cw.j jVar) {
        this.mPluginLogHandler = jVar;
    }
}
