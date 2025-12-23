package com.bytedance.sdk.openadsdk.core.rn;

import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    static class j implements Comparable<j> {

        /* renamed from: j, reason: collision with root package name */
        private long f30162j;
        private String xt;

        @Override // java.lang.Comparable
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compareTo(j jVar) {
            if (jVar == null) {
                return 1;
            }
            long j6 = this.f30162j;
            long j7 = jVar.f30162j;
            if (j6 > j7) {
                return 1;
            }
            return j6 == j7 ? 0 : -1;
        }

        public j(String str, long j6) {
            this.xt = str;
            this.f30162j = j6;
        }
    }

    private static boolean j(int i6) {
        return i6 == 3 || i6 == 7 || i6 == 8;
    }

    private static void delete(int i6, int i7, com.bytedance.sdk.component.r.j.xt xtVar, int i8) {
        if (xtVar == null) {
            return;
        }
        try {
            Map<String, ?> all = xtVar.getAll();
            if (all != null && all.size() != 0) {
                int size = all.size();
                if (j(i6)) {
                    if (size > 1) {
                        xtVar.j();
                        return;
                    }
                    return;
                }
                if (i8 >= i7) {
                    xtVar.j();
                    return;
                }
                int i9 = size + i8;
                if (i9 > i7) {
                    PriorityQueue priorityQueue = new PriorityQueue();
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        String str = (String) entry.getValue();
                        JSONObject jSONObject = (str == null || !str.contains("pre_fetch_time")) ? str != null ? new JSONObject(com.bytedance.sdk.component.utils.j.cw(str)) : null : new JSONObject(str);
                        if (jSONObject != null) {
                            priorityQueue.add(new j(entry.getKey(), jSONObject.optLong("pre_fetch_time")));
                        }
                    }
                    int size2 = priorityQueue.size();
                    int i10 = i9 - i7;
                    if (size2 == 0 || size2 < i10) {
                        xtVar.j();
                        return;
                    }
                    for (int i11 = 0; i11 < i10; i11++) {
                        j jVar = (j) priorityQueue.poll();
                        if (jVar != null) {
                            xtVar.j(jVar.xt);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, int i6, int i7) {
        if (jVar == null || jVar.xt() == null || i7 <= 0) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.tj.n> xt = jVar.xt();
        int size = xt.size();
        try {
            com.bytedance.sdk.component.r.j.xt j6 = h.j(i6 + "_prefetch");
            delete(i6, i7, j6, size);
            for (com.bytedance.sdk.openadsdk.core.tj.n nVar : xt) {
                String wq = nVar.wq();
                String xt2 = com.bytedance.sdk.component.utils.j.xt(nVar.tv().toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pre_fetch_time", System.currentTimeMillis());
                jSONObject.put(CrashHianalyticsData.MESSAGE, xt2);
                j6.j(wq, jSONObject.toString());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public static com.bytedance.sdk.openadsdk.core.tj.n j(String str, int i6) {
        if (com.bytedance.sdk.openadsdk.core.v.xt().h() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.r.j.xt j6 = h.j(i6 + "_prefetch");
        String xt = j6.xt(str, (String) null);
        if (!TextUtils.isEmpty(xt)) {
            try {
                if (xt.contains("pre_fetch_time")) {
                    xt = new JSONObject(xt).optString(CrashHianalyticsData.MESSAGE);
                }
                com.bytedance.sdk.openadsdk.core.tj.n j7 = com.bytedance.sdk.openadsdk.core.j.j(new JSONObject(com.bytedance.sdk.component.utils.j.cw(xt)));
                j6.j(str);
                return j7;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
