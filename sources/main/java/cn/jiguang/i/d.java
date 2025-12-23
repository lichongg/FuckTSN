package cn.jiguang.i;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d extends a {
    private long a() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long b() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTimeInMillis();
    }

    @TargetApi(22)
    private HashMap<String, cn.jiguang.common.app.entity.a> a(Context context) {
        cn.jiguang.common.app.entity.a aVar;
        HashMap<String, cn.jiguang.common.app.entity.a> hashMap = new HashMap<>();
        if (!b(context)) {
            cn.jiguang.bb.f.c("CollectByUsageStateManager", "no usage state permission");
            return hashMap;
        }
        cn.jiguang.bb.f.c("CollectByUsageStateManager", "start collect active data by usage state");
        long a6 = a();
        long b6 = b();
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
        List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, a6, b6);
        if (queryUsageStats != null && !queryUsageStats.isEmpty()) {
            a(usageStatsManager, hashMap, a6, b6);
            for (UsageStats usageStats : queryUsageStats) {
                String packageName = usageStats.getPackageName();
                long lastTimeStamp = usageStats.getLastTimeStamp();
                if (!hashMap.containsKey(packageName) || (aVar = hashMap.get(packageName)) == null || aVar.f2824e.isEmpty() || aVar.f2824e.get(0).longValue() < lastTimeStamp) {
                    cn.jiguang.common.app.entity.a aVar2 = hashMap.get(packageName);
                    if (aVar2 == null) {
                        aVar2 = new cn.jiguang.common.app.entity.a();
                        aVar2.f2820a = packageName;
                        hashMap.put(packageName, aVar2);
                    }
                    aVar2.f2821b = usageStats.getTotalTimeInForeground() / 1000;
                    aVar2.f2824e.add(Long.valueOf(lastTimeStamp));
                    aVar2.f2823d.add(1);
                }
            }
        }
        return hashMap;
    }

    @TargetApi(21)
    private boolean b(Context context) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
        }
        return ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) == 0;
    }

    @Override // cn.jiguang.i.a
    public HashMap<String, cn.jiguang.common.app.entity.a> a(Context context, List<String> list) {
        return a(context);
    }

    @TargetApi(21)
    private void a(UsageStatsManager usageStatsManager, HashMap<String, cn.jiguang.common.app.entity.a> hashMap, long j6, long j7) {
        ArrayList arrayList = new ArrayList();
        UsageEvents queryEvents = usageStatsManager.queryEvents(j6, j7);
        while (queryEvents.hasNextEvent()) {
            UsageEvents.Event event = new UsageEvents.Event();
            queryEvents.getNextEvent(event);
            if (event.getEventType() == 1) {
                cn.jiguang.common.app.entity.a aVar = new cn.jiguang.common.app.entity.a();
                aVar.f2820a = event.getPackageName();
                arrayList.add(aVar);
            }
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            cn.jiguang.common.app.entity.a aVar2 = (cn.jiguang.common.app.entity.a) arrayList.get(i6);
            String str = aVar2.f2820a;
            if (str.contains("launcher") && i6 > 0) {
                cn.jiguang.common.app.entity.a aVar3 = (cn.jiguang.common.app.entity.a) arrayList.get(i6 - 1);
                String str2 = aVar3.f2820a;
                if (!str2.contains("launcher")) {
                    aVar3.f2822c = hashMap.get(str2) == null ? 1 : hashMap.get(str2).f2822c + 1;
                    hashMap.put(str2, aVar3);
                }
            }
            if (i6 == arrayList.size() - 1 && !str.contains("launcher")) {
                aVar2.f2822c = hashMap.get(str) == null ? 1 : hashMap.get(str).f2822c + 1;
                hashMap.put(str, aVar2);
            }
        }
        arrayList.clear();
    }
}
