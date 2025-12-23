package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33473a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f33474b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONArray f33475c;

        a(long j6, ArrayList arrayList, JSONArray jSONArray) {
            this.f33473a = j6;
            this.f33474b = arrayList;
            this.f33475c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            q1.a aVar = new q1.a();
            aVar.put("total_time", this.f33473a);
            Iterator it = this.f33474b.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.D() || dVar.B()) {
                    aVar.put(e.c(dVar));
                    it.remove();
                    break;
                }
            }
            if (this.f33474b.size() > 0) {
                ArrayList arrayList = this.f33474b;
                d dVar2 = (d) arrayList.get(arrayList.size() - 1);
                aVar.put(e.c(dVar2));
                this.f33474b.remove(dVar2);
            }
            if (this.f33474b.size() > 0) {
                Iterator it2 = this.f33474b.iterator();
                while (it2.hasNext()) {
                    this.f33475c.put(new JSONObject(e.c((d) it2.next())));
                }
            }
            if (this.f33475c.length() > 0) {
                aVar.put("failed_info", this.f33475c.toString());
            }
            Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
            HianalyticsHelper.getInstance().onEvent(aVar.get(), "grs_request");
        }
    }

    public static void b(ArrayList<d> arrayList, long j6, JSONArray jSONArray, Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReport(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j6, arrayList, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashMap<String, String> c(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception p5 = dVar.p();
        if (p5 != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(p5));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, p5.getClass().getSimpleName());
            linkedHashMapPack.put(CrashHianalyticsData.MESSAGE, StringUtils.anonymizeMessage(p5.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", dVar.f());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, dVar.k());
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.A()).getHost());
        } catch (MalformedURLException e6) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e6);
        }
        linkedHashMapPack.put("req_start_time", dVar.w());
        linkedHashMapPack.put("req_end_time", dVar.v());
        linkedHashMapPack.put("req_total_time", dVar.x());
        return linkedHashMapPack.getAll();
    }
}
