package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class i1 implements v {

    /* renamed from: a, reason: collision with root package name */
    private Context f33587a = y0.q();

    /* renamed from: b, reason: collision with root package name */
    private String f33588b;

    /* renamed from: c, reason: collision with root package name */
    private String f33589c;

    /* renamed from: d, reason: collision with root package name */
    private String f33590d;

    @Override // java.lang.Runnable
    public void run() {
        Map<String, List<f>> b6;
        j1.h("hmsSdk", "eventReportTask is running");
        boolean a6 = h.a(this.f33587a);
        if (a6) {
            j1.h("hmsSdk", "workKey is refresh,begin report all data");
            this.f33589c = "alltype";
        }
        try {
            try {
                try {
                    b6 = i.b(this.f33587a, this.f33588b, this.f33589c);
                } catch (Exception e6) {
                    j1.l("hmsSdk", "readEventRecords handData Exception:" + e6.getMessage());
                    if ("alltype".equals(this.f33589c)) {
                        l.d(this.f33587a, "stat_v2_1", new String[0]);
                        l.d(this.f33587a, "cached_v2_1", new String[0]);
                    } else {
                        String d6 = q0.d(this.f33588b, this.f33589c);
                        l.d(this.f33587a, "stat_v2_1", d6);
                        l.d(this.f33587a, "cached_v2_1", d6);
                    }
                }
            } catch (IllegalArgumentException e7) {
                j1.l("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e7.getMessage());
                if ("alltype".equals(this.f33589c)) {
                    l.d(this.f33587a, "stat_v2_1", new String[0]);
                    l.d(this.f33587a, "cached_v2_1", new String[0]);
                } else {
                    String d7 = q0.d(this.f33588b, this.f33589c);
                    l.d(this.f33587a, "stat_v2_1", d7);
                    l.d(this.f33587a, "cached_v2_1", d7);
                }
            }
            if (b6.size() == 0) {
                j1.f("hmsSdk", "no have events to report: tag:%s : type:%s", this.f33588b, this.f33589c);
                if ("alltype".equals(this.f33589c)) {
                    l.d(this.f33587a, "stat_v2_1", new String[0]);
                    l.d(this.f33587a, "cached_v2_1", new String[0]);
                    return;
                } else {
                    String d8 = q0.d(this.f33588b, this.f33589c);
                    l.d(this.f33587a, "stat_v2_1", d8);
                    l.d(this.f33587a, "cached_v2_1", d8);
                    return;
                }
            }
            for (Map.Entry<String, List<f>> entry : b6.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            if ("alltype".equals(this.f33589c)) {
                l.d(this.f33587a, "stat_v2_1", new String[0]);
                l.d(this.f33587a, "cached_v2_1", new String[0]);
            } else {
                String d9 = q0.d(this.f33588b, this.f33589c);
                l.d(this.f33587a, "stat_v2_1", d9);
                l.d(this.f33587a, "cached_v2_1", d9);
            }
            if (a6) {
                j1.h("hmsSdk", "refresh local key");
                t0.g().d();
            }
        } catch (Throwable th) {
            if ("alltype".equals(this.f33589c)) {
                l.d(this.f33587a, "stat_v2_1", new String[0]);
                l.d(this.f33587a, "cached_v2_1", new String[0]);
            } else {
                String d10 = q0.d(this.f33588b, this.f33589c);
                l.d(this.f33587a, "stat_v2_1", d10);
                l.d(this.f33587a, "cached_v2_1", d10);
            }
            throw th;
        }
    }

    public i1(String str, String str2, String str3) {
        this.f33588b = str;
        this.f33589c = str2;
        this.f33590d = str3;
    }

    private void a(String str, List<f> list) {
        Pair<String, String> b6 = q0.b(str);
        new h1(list, (String) b6.first, (String) b6.second, this.f33590d).a();
    }
}
