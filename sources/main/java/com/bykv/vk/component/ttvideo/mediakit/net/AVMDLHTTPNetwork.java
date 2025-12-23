package com.bykv.vk.component.ttvideo.mediakit.net;

import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.az;
import com.bytedance.sdk.component.xt.j.cw;
import com.bytedance.sdk.component.xt.j.i;
import com.bytedance.sdk.component.xt.j.oq;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import com.bytedance.sdk.component.xt.j.xt;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final oq JSON = oq.j("application/json");
    private static vl mClient;
    private xt mCall;

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            try {
                if (mClient == null) {
                    vl.j xt = new vl().xt();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    mClient = xt.j(10L, timeUnit).cw(10L, timeUnit).xt(10L, timeUnit).j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ws.j j6 = new ws.j().j(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                j6.j(str2, map.get(str2));
            }
        }
        xt j7 = mClient.j(j6.xt());
        this.mCall = j7;
        j7.j(new cw() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.bytedance.sdk.component.xt.j.cw
            public void onResponse(xt xtVar, av avVar) {
                i iVar;
                Throwable th2;
                JSONObject jSONObject;
                try {
                    iVar = avVar.m();
                } catch (Throwable th3) {
                    iVar = null;
                    th2 = th3;
                }
                try {
                    try {
                        jSONObject = new JSONObject(iVar.xt());
                        e = null;
                    } catch (Exception e6) {
                        e = e6;
                        com.bytedance.sdk.component.utils.vl.j(e);
                        jSONObject = null;
                    }
                    if (e == null && !avVar.r()) {
                        e = new Exception("http fail");
                        avVar.cw();
                    }
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th2;
                }
            }

            @Override // com.bytedance.sdk.component.xt.j.cw
            public void onFailure(xt xtVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        xt xtVar = this.mCall;
        if (xtVar == null || xtVar.cw()) {
            return;
        }
        this.mCall.xt();
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i6, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            try {
                if (mClient == null) {
                    vl.j xt = new vl().xt();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    mClient = xt.j(10L, timeUnit).cw(10L, timeUnit).xt(10L, timeUnit).j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ws.j j6 = new ws.j().j(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                j6.xt(str2, map.get(str2));
            }
        }
        if (i6 == 1) {
            j6.j(az.j(JSON, String.valueOf(jSONObject)));
        }
        xt j7 = mClient.j(j6.xt());
        this.mCall = j7;
        j7.j(new cw() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.bytedance.sdk.component.xt.j.cw
            public void onResponse(xt xtVar, av avVar) throws IOException {
                i iVar;
                Throwable th2;
                String obj;
                JSONObject jSONObject2;
                try {
                    iVar = avVar.m();
                } catch (Throwable th3) {
                    iVar = null;
                    th2 = th3;
                }
                try {
                    try {
                        jSONObject2 = new JSONObject(iVar.xt());
                        obj = null;
                    } catch (Exception e6) {
                        obj = e6.toString();
                        com.bytedance.sdk.component.utils.vl.j(e6);
                        jSONObject2 = null;
                    }
                    if (!avVar.r()) {
                        obj = avVar.up();
                        avVar.cw();
                    }
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (obj == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, obj.toString()));
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th2;
                }
            }

            @Override // com.bytedance.sdk.component.xt.j.cw
            public void onFailure(xt xtVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }
        });
    }
}
