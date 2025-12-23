package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class GrsClient {
    private static final String EMPTY_STRING = "";
    private final c grsClientGlobal;
    private int queryTimeout;

    public void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            iQueryUrlCallBack.onCallBackFail(-8);
        } else {
            cVar.m(str, str2, iQueryUrlCallBack, this.queryTimeout);
        }
    }

    public void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            iQueryUrlsCallBack.onCallBackFail(-8);
        } else {
            cVar.l(str, iQueryUrlsCallBack, this.queryTimeout);
        }
    }

    public void clearSp() {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            return;
        }
        cVar.i();
    }

    public boolean forceExpire() {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            return false;
        }
        return cVar.r();
    }

    public String synGetGrsUrl(String str, String str2) {
        c cVar = this.grsClientGlobal;
        return cVar == null ? "" : cVar.e(str, str2, this.queryTimeout);
    }

    public Map<String, String> synGetGrsUrls(String str) {
        c cVar = this.grsClientGlobal;
        return cVar == null ? new HashMap() : cVar.f(str, this.queryTimeout);
    }

    public GrsClient(Context context, GrsBaseInfo grsBaseInfo) {
        if (context != null && grsBaseInfo != null) {
            this.grsClientGlobal = d.a(grsBaseInfo, context);
            this.queryTimeout = grsBaseInfo.getQueryTimeout();
            return;
        }
        throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
    }
}
