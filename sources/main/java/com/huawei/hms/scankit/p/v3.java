package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.ml.scan.HmsScan;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class v3 extends u3 {

    /* renamed from: o, reason: collision with root package name */
    private static String f34891o = "AiDetect";

    /* renamed from: p, reason: collision with root package name */
    private static String f34892p = "defaultDetect";

    /* renamed from: h, reason: collision with root package name */
    private int f34893h;

    /* renamed from: i, reason: collision with root package name */
    protected String f34894i;

    /* renamed from: j, reason: collision with root package name */
    protected String f34895j;

    /* renamed from: k, reason: collision with root package name */
    protected long f34896k;

    /* renamed from: l, reason: collision with root package name */
    protected long f34897l;

    /* renamed from: m, reason: collision with root package name */
    protected long f34898m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f34899n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends SimpleDateFormat {
        a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends LinkedHashMap<String, String> {
        b() {
            v3.this.g();
            putAll(v3.this.f34861b);
        }
    }

    public void a(long j6) {
        this.f34896k = j6;
    }

    private void j() {
        this.f34893h = -1001;
        this.f34894i = u3.f34856d;
        this.f34895j = u3.f34857e;
    }

    public void a(long j6, long j7, boolean z5) {
        this.f34897l = j6;
        this.f34898m = j7;
        this.f34899n = z5;
    }

    public void c(int i6) {
        this.f34893h = i6;
    }

    public void i() {
        try {
            if (a()) {
                b bVar = new b();
                bVar.put("result", String.valueOf(this.f34893h));
                bVar.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(System.currentTimeMillis() - this.f34862c));
                bVar.put("scanType", this.f34894i);
                bVar.put("sceneType", this.f34895j);
                if (this.f34897l != 0 && this.f34898m != 0) {
                    if (this.f34899n) {
                        bVar.put("recognizeMode", f34891o);
                        bVar.put("defaultDetectTime", String.valueOf(this.f34897l - this.f34896k));
                        bVar.put("aiDetectTime", String.valueOf(this.f34898m - this.f34897l));
                    } else {
                        bVar.put("recognizeMode", f34892p);
                        bVar.put("defaultDetectTime", String.valueOf(this.f34897l - this.f34896k));
                    }
                    bVar.put("recognizeSuccessTime", String.valueOf(this.f34898m - this.f34896k));
                }
                a4.b().b(WiseOpenHianalyticsData.UNION_EVENT_ID, bVar);
                j();
            }
        } catch (NullPointerException unused) {
            o4.b("HaLog60000", "nullPoint");
        } catch (Exception unused2) {
            o4.b("HaLog60000", "logEnd Exception");
        }
    }

    public v3(Bundle bundle, String str) {
        super(bundle, StubApp.getOrigApplicationContext(DynamicModuleInitializer.getContext().getApplicationContext()));
        this.f34893h = -1001;
        this.f34894i = u3.f34856d;
        this.f34895j = u3.f34857e;
        this.f34861b.put(WiseOpenHianalyticsData.UNION_CALLTIME, new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(System.currentTimeMillis())));
        this.f34861b.put("transId", UUID.randomUUID().toString());
        this.f34861b.put(WiseOpenHianalyticsData.UNION_API_NAME, str);
    }

    public void h() {
        this.f34862c = System.currentTimeMillis();
    }

    public void a(HmsScan[] hmsScanArr) {
        if (hmsScanArr != null) {
            this.f34893h = hmsScanArr.length;
            for (HmsScan hmsScan : hmsScanArr) {
                this.f34894i = u3.a(hmsScan.scanType);
                this.f34895j = u3.b(hmsScan.scanTypeForm);
            }
        }
    }
}
