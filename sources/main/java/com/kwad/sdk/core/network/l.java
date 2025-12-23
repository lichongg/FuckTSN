package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bw;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    private static final String TAG = "Networking";

    @Nullable
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.HU();

    private void notifyOnErrorListener(@NonNull R r5, c cVar, String str) {
        String url = r5.getUrl();
        DomainException domainException = new DomainException(cVar.aEi, cVar.aEj);
        com.kwad.sdk.core.network.idc.a.HF().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener((l<R, T>) r5, cVar.code, str);
    }

    protected boolean enableCrashReport() {
        return true;
    }

    protected boolean enableMonitorReport() {
        return true;
    }

    protected boolean isPostByJson() {
        return true;
    }

    @NonNull
    protected abstract T parseData(String str);

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar == null || cVar.Hx() || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null || !ao.isNetworkConnected(fVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.MI();
    }

    private String getHostTypeByUrl(@NonNull String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnStartRequest(@NonNull R r5) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r5);
    }

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mMonitorRecorder.HN();
        this.mListener = gVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.HB().U(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    protected void fetchImpl() {
        R r5;
        Throwable th;
        c cVar = null;
        try {
            try {
                this.mMonitorRecorder.HR();
                r5 = createRequest();
            } catch (Throwable th2) {
                r5 = null;
                th = th2;
            }
            try {
                notifyOnStartRequest(r5);
                this.mMonitorRecorder.ei(r5.getUrl()).ej(r5.getUrl());
                setMonitorRequestId(r5);
                if (ao.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                    try {
                        String url = r5.getUrl();
                        AdHttpProxy AI = com.kwad.sdk.g.AI();
                        if (AI instanceof com.kwad.sdk.core.network.c.b) {
                            this.mMonitorRecorder.el("ok_http").HQ();
                        } else {
                            this.mMonitorRecorder.el(master.flame.danmaku.danmaku.parser.b.f50154a).HQ();
                        }
                        cVar = isPostByJson() ? AI.doPost(url, r5.getHeader(), r5.getBody()) : AI.doPost(url, r5.getHeader(), r5.getBodyMap());
                        com.kwad.sdk.core.d.c.i(TAG, "url: " + url + ", response: " + cVar);
                    } catch (Exception e6) {
                        notifyOnErrorListener((l<R, T>) r5, e.aEv.errorCode, bw.s(e6));
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                        this.mMonitorRecorder.ek("requestError:" + e6.getMessage());
                    }
                    this.mMonitorRecorder.HO().HP().dA(com.kwad.sdk.ip.direct.a.getType());
                    try {
                        onResponse(r5, cVar);
                    } catch (Exception e7) {
                        notifyOnErrorListener((l<R, T>) r5, e.aEv.errorCode, bw.s(e7));
                        this.mMonitorRecorder.ek("onResponseError:" + e7.getMessage());
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e7);
                    }
                } else {
                    e eVar = e.aEo;
                    notifyOnErrorListener((l<R, T>) r5, eVar.errorCode, eVar.msg);
                    this.mMonitorRecorder.dx(e.aEo.errorCode).ek(e.aEo.msg);
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    try {
                        this.mMonitorRecorder.ek("requestError:" + th.getMessage());
                    } finally {
                        try {
                            if (enableMonitorReport()) {
                                this.mMonitorRecorder.report();
                            }
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
                notifyOnErrorListener((l<R, T>) r5, e.aEv.errorCode, bw.s(th));
                com.kwad.sdk.core.d.c.printStackTrace(th);
                if (!enableMonitorReport()) {
                }
            }
        } catch (Exception unused3) {
        }
    }

    @Override // com.kwad.sdk.core.network.a
    protected void onResponse(R r5, c cVar) {
        if (cVar == null) {
            e eVar = e.aEo;
            notifyOnErrorListener((l<R, T>) r5, eVar.errorCode, eVar.msg);
            this.mMonitorRecorder.ek("responseBase is null");
            com.kwad.sdk.core.d.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.dx(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.aEk) || !cVar.Hx()) {
            notifyOnErrorListener((l<R, T>) r5, cVar, "网络错误");
            this.mMonitorRecorder.ek("httpCodeError:" + cVar.code + ":" + cVar.aEk);
            StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
            sb.append(cVar.code);
            com.kwad.sdk.core.d.c.w(TAG, sb.toString());
            return;
        }
        try {
            parseCommonData(r5.getUrl(), cVar.aEk);
            T parseData = parseData(cVar.aEk);
            afterParseData(parseData);
            if (cVar.aEk != null) {
                this.mMonitorRecorder.az(r7.length()).HS().dz(parseData.result);
            }
            if (!parseData.isResultOk()) {
                this.mMonitorRecorder.ek("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
                if (parseData.notifyFailOnResultError()) {
                    notifyOnErrorListener((l<R, T>) r5, parseData.result, parseData.errorMsg);
                    return;
                }
            }
            if (parseData.isDataEmpty()) {
                notifyOnErrorListener((l<R, T>) r5, e.aEq.errorCode, !TextUtils.isEmpty(parseData.testErrorMsg) ? parseData.testErrorMsg : e.aEq.msg);
            } else {
                checkAndSetHasData(parseData);
                notifyOnSuccess(r5, parseData);
            }
        } catch (Exception e6) {
            e eVar2 = e.aEp;
            notifyOnErrorListener((l<R, T>) r5, eVar2.errorCode, eVar2.msg);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            this.mMonitorRecorder.ek("parseDataError:" + e6.getMessage());
        }
    }

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.dy(1);
        }
    }

    private void notifyOnSuccess(@NonNull R r5, T t5) {
        if (com.kwad.sdk.core.network.idc.a.HF().HH()) {
            String hostTypeByUrl = getHostTypeByUrl(r5.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.HF().ec(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r5, t5);
        this.mMonitorRecorder.HT();
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void setMonitorRequestId(@NonNull f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (!TextUtils.isEmpty(str)) {
                this.mMonitorRecorder.em(str);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((l<R, T>) null, e.aEv.errorCode, bw.s(th));
            reportSdkCaughtException(th);
        }
    }

    private void notifyOnErrorListener(@NonNull R r5, int i6, String str) {
        try {
            h.Hy().b(r5, i6);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r5, i6, str);
        this.mMonitorRecorder.HT();
    }

    protected void afterParseData(T t5) {
    }
}
