package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.cj;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.d;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final int f41886b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f41887c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f41888d = 3;

    /* renamed from: o, reason: collision with root package name */
    private static final String f41889o = "thtstart";

    /* renamed from: p, reason: collision with root package name */
    private static final String f41890p = "gkvc";

    /* renamed from: q, reason: collision with root package name */
    private static final String f41891q = "ekvc";

    /* renamed from: a, reason: collision with root package name */
    String f41892a;

    /* renamed from: f, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f41894f;

    /* renamed from: g, reason: collision with root package name */
    private ImprintHandler f41895g;

    /* renamed from: h, reason: collision with root package name */
    private e f41896h;

    /* renamed from: i, reason: collision with root package name */
    private ImprintHandler.a f41897i;

    /* renamed from: k, reason: collision with root package name */
    private Defcon f41899k;

    /* renamed from: l, reason: collision with root package name */
    private long f41900l;

    /* renamed from: m, reason: collision with root package name */
    private int f41901m;

    /* renamed from: n, reason: collision with root package name */
    private int f41902n;

    /* renamed from: r, reason: collision with root package name */
    private Context f41903r;

    /* renamed from: e, reason: collision with root package name */
    private final int f41893e = 1;

    /* renamed from: j, reason: collision with root package name */
    private ABTest f41898j = null;

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a a6 = com.umeng.commonsdk.statistics.internal.a.a(this.f41903r);
            a6.e(name);
            boolean a7 = a6.a(name);
            boolean b6 = a6.b(name);
            boolean c6 = a6.c(name);
            boolean d6 = a6.d(name);
            String d7 = d.d(name);
            byte[] a8 = this.f41894f.a(byteArray, a7, c6, !TextUtils.isEmpty(d7) ? d.c(d7) : d6 ? UMServerURL.SILENT_HEART_BEAT : c6 ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int a9 = a8 == null ? 1 : a(a8);
            if (UMConfigure.isDebugLog()) {
                if (d6 && a9 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (c6 && a9 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (b6 && a9 == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (a7 && a9 == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (a9 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (a9 == 2) {
                e eVar = this.f41896h;
                if (eVar != null) {
                    eVar.e();
                }
                StatTracer.getInstance(this.f41903r).saveSate();
                if (d6) {
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f41903r, "iss", "");
                    if (!TextUtils.isEmpty(imprintProperty)) {
                        if ("1".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                            com.umeng.commonsdk.utils.c.a(this.f41903r, System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                            com.umeng.commonsdk.utils.c.a(this.f41903r, 0L);
                            com.umeng.commonsdk.utils.c.d(this.f41903r);
                        }
                    }
                }
            } else if (a9 == 3) {
                StatTracer.getInstance(this.f41903r).saveSate();
                if (c6) {
                    FieldManager.a().a(this.f41903r);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.f41903r;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f41765s, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return a9 == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f41903r, th);
            return false;
        }
    }

    public c(Context context) {
        this.f41896h = null;
        this.f41897i = null;
        this.f41899k = null;
        this.f41900l = 0L;
        this.f41901m = 0;
        this.f41902n = 0;
        this.f41892a = null;
        this.f41903r = context;
        this.f41897i = ImprintHandler.getImprintService(context).c();
        this.f41899k = Defcon.getService(this.f41903r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f41903r);
        this.f41900l = sharedPreferences.getLong(f41889o, 0L);
        this.f41901m = sharedPreferences.getInt(f41890p, 0);
        this.f41902n = sharedPreferences.getInt(f41891q, 0);
        this.f41892a = UMEnvelopeBuild.imprintProperty(this.f41903r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.f41903r);
        this.f41895g = imprintService;
        imprintService.a(new com.umeng.commonsdk.statistics.internal.d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f41899k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.f41892a = UMEnvelopeBuild.imprintProperty(cVar.f41903r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f41903r)) {
            this.f41896h = e.a(this.f41903r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.f41903r);
        this.f41894f = cVar;
        cVar.a(StatTracer.getInstance(this.f41903r));
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new bu(new cj.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f41895g.b(response.getImprint());
                this.f41895g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f41903r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
