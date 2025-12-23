package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import com.umeng.analytics.pro.bi;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    protected static h f40534a;

    /* renamed from: e, reason: collision with root package name */
    protected HandlerThread f40538e;

    /* renamed from: f, reason: collision with root package name */
    protected Handler f40539f;

    /* renamed from: b, reason: collision with root package name */
    protected Random f40535b = new SecureRandom();

    /* renamed from: d, reason: collision with root package name */
    protected List<Serializable> f40537d = Collections.synchronizedList(new ArrayList());

    /* renamed from: c, reason: collision with root package name */
    protected List<Serializable> f40536c = Collections.synchronizedList(new ArrayList());

    /* renamed from: g, reason: collision with root package name */
    protected Executor f40540g = l.b();

    /* renamed from: h, reason: collision with root package name */
    protected Executor f40541h = l.b();

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            try {
                if (f40534a == null) {
                    f40534a = new h();
                }
                hVar = f40534a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    protected Map<String, String> c() {
        List<Serializable> b6 = g.b("report_via");
        if (b6 != null) {
            this.f40537d.addAll(b6);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f40537d.size());
        if (this.f40537d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f40537d) {
            JSONObject jSONObject = new JSONObject();
            c cVar = (c) serializable;
            for (String str : cVar.f40530a.keySet()) {
                try {
                    String str2 = cVar.f40530a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e6) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e6);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject2.toString());
            return hashMap;
        } catch (JSONException e7) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e7);
            return null;
        }
    }

    private h() {
        this.f40538e = null;
        if (this.f40538e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f40538e = handlerThread;
            handlerThread.start();
        }
        if (this.f40538e.isAlive() && this.f40538e.getLooper() != null) {
            this.f40539f = new Handler(this.f40538e.getLooper()) { // from class: com.tencent.open.b.h.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i6 = message.what;
                    if (i6 == 1000) {
                        h.this.b();
                    } else if (i6 == 1001) {
                        h.this.d();
                    }
                    super.handleMessage(message);
                }
            };
        }
    }

    protected void d() {
        if (!m.b(com.tencent.open.utils.g.a())) {
            return;
        }
        this.f40540g.execute(new Runnable() { // from class: com.tencent.open.b.h.3
            /* JADX WARN: Code restructure failed: missing block: B:57:0x009c, code lost:
            
                r21 = r5;
                r27 = r8;
                r25 = r9;
                r23 = r14;
                r7 = true;
             */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00d9 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:39:? A[LOOP:0: B:10:0x0030->B:39:?, LOOP_END, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 298
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.AnonymousClass3.run():void");
            }
        });
    }

    public void a(final Bundle bundle, String str, final boolean z5) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z5) {
            this.f40540g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("platform", "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", "");
                        bundle2.putString("network", a.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("language", d.a());
                        bundle2.putString("resolution", d.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.g.a()));
                        bundle2.putString(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
                        bundle2.putString(bi.M, TimeZone.getDefault().getID());
                        bundle2.putString(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", m.d(com.tencent.open.utils.g.a(), Constants.PACKAGE_QZONE));
                        bundle2.putString(Constants.PARAM_QQ_VER, m.c(com.tencent.open.utils.g.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", m.e(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.g.b());
                        bundle2.putString(Constants.PARAM_APP_VER, m.d(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        Bundle bundle3 = bundle;
                        if (bundle3 != null) {
                            bundle2.putAll(bundle3);
                        }
                        h.this.f40537d.add(new c(bundle2));
                        int size = h.this.f40537d.size();
                        int a6 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a6 == 0) {
                            a6 = 10000;
                        }
                        if (!h.this.a("report_via", size) && !z5) {
                            if (h.this.f40539f.hasMessages(1001)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            h.this.f40539f.sendMessageDelayed(obtain, a6);
                            return;
                        }
                        h.this.d();
                        h.this.f40539f.removeMessages(1001);
                    } catch (Exception e6) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e6);
                    }
                }
            });
        }
    }

    public void a(String str, long j6, long j7, long j8, int i6) {
        a(str, j6, j7, j8, i6, "", false);
    }

    public void a(String str, long j6, long j7, long j8, int i6, String str2, boolean z5) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j6 + " | reqSize:" + j7 + " | rspSize: " + j8 + " | responseCode: " + i6 + " | detail: " + str2);
    }

    protected boolean a(String str, String str2) {
        int a6;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z5 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i6 = 100;
        if (str.equals("report_cgi")) {
            try {
                a6 = a(Integer.parseInt(str2));
                if (this.f40535b.nextInt(100) < a6) {
                    z5 = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                a6 = f.a(str2);
                if (this.f40535b.nextInt(100) < a6) {
                    i6 = a6;
                    z5 = true;
                }
            }
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z5 + " | frequency: " + i6);
            return z5;
        }
        i6 = a6;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z5 + " | frequency: " + i6);
        return z5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1e
            android.content.Context r0 = com.tencent.open.utils.g.a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.i.a(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L1c:
            r1 = r0
            goto L38
        L1e:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L37
            android.content.Context r0 = com.tencent.open.utils.g.a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.i.a(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L37:
            r1 = 0
        L38:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "-->availableCount, report: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " | dataSize: "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = " | maxcount: "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "openSDK_LOG.ReportManager"
            com.tencent.open.log.SLog.d(r0, r5)
            if (r6 < r1) goto L62
            r5 = 1
            return r5
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.a(java.lang.String, int):boolean");
    }

    protected void b() {
    }

    protected int a(int i6) {
        if (i6 == 0) {
            int a6 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a6 == 0) {
                return 10;
            }
            return a6;
        }
        int a7 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a7 == 0) {
            return 100;
        }
        return a7;
    }

    public void a(final String str, final Map<String, String> map) {
        if (m.b(com.tencent.open.utils.g.a())) {
            l.b(new Runnable() { // from class: com.tencent.open.b.h.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int a6 = f.a();
                        if (a6 == 0) {
                            a6 = 3;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + a6);
                        int i6 = 0;
                        do {
                            i6++;
                            try {
                                try {
                                    SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + com.tencent.open.a.f.a().a(str, map).d());
                                } catch (Exception e6) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e6);
                                }
                            } catch (SocketTimeoutException e7) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e7);
                            }
                        } while (i6 < a6);
                    } catch (Exception e8) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e8);
                    }
                }
            });
        }
    }
}
