package cn.jiguang.i;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends a {

    /* renamed from: a, reason: collision with root package name */
    private static String f3024a = "/proc/uid_stat";

    /* renamed from: b, reason: collision with root package name */
    private static String f3025b = "tcp_rcv";

    /* renamed from: c, reason: collision with root package name */
    private static String f3026c = "tcp_snd";

    private long a(List<cn.jiguang.common.app.entity.d> list, String str) {
        long j6 = 0;
        if (list != null && !list.isEmpty()) {
            for (cn.jiguang.common.app.entity.d dVar : list) {
                try {
                    if (!TextUtils.isEmpty(dVar.f2848d) && dVar.f2848d.contains(str)) {
                        long j7 = dVar.f2851g;
                        if (j7 > j6) {
                            j6 = j7;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return j6;
    }

    private List<cn.jiguang.common.app.entity.e> b(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        List<cn.jiguang.common.app.entity.d> a6 = cn.jiguang.common.app.helper.c.a(context, 1);
        for (String str : list) {
            long a7 = a(a6, str);
            if (a7 > 0) {
                cn.jiguang.common.app.entity.e eVar = new cn.jiguang.common.app.entity.e();
                eVar.f2868c = str;
                eVar.f2871f = a7;
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    @Override // cn.jiguang.i.a
    public HashMap<String, cn.jiguang.common.app.entity.a> a(Context context, List<String> list) {
        StringBuilder sb;
        List<Integer> list2;
        int i6;
        cn.jiguang.common.app.entity.a aVar;
        HashMap<String, cn.jiguang.common.app.entity.a> hashMap = new HashMap<>();
        if (context != null && list != null) {
            try {
                if (!list.isEmpty()) {
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 24) {
                        sb = new StringBuilder();
                        sb.append("no traffic usage, os_version: ");
                        sb.append(i7);
                    } else {
                        cn.jiguang.bb.f.c("CollectByTrafficUsage", "start collect active data by traffic usage, package size: " + list.size());
                        List<cn.jiguang.common.app.entity.e> b6 = b(context, list);
                        if (b6.isEmpty()) {
                            sb = new StringBuilder();
                            sb.append("no traffic usage, os_version: ");
                            sb.append(i7);
                        } else {
                            for (cn.jiguang.common.app.entity.e eVar : b6) {
                                if (!hashMap.containsKey(eVar.f2868c) || (aVar = hashMap.get(eVar.f2868c)) == null || aVar.f2824e.isEmpty() || aVar.f2824e.get(0).longValue() < eVar.f2871f) {
                                    if (eVar.f2869d > 0 || eVar.f2870e > 0 || eVar.f2871f > 0) {
                                        cn.jiguang.common.app.entity.a aVar2 = new cn.jiguang.common.app.entity.a();
                                        aVar2.f2820a = eVar.f2868c;
                                        aVar2.f2826g.add(Long.valueOf(eVar.f2869d + eVar.f2870e));
                                        aVar2.f2824e.add(Long.valueOf(eVar.f2871f));
                                        if (eVar.f2869d <= 0 && eVar.f2870e <= 0) {
                                            list2 = aVar2.f2823d;
                                            i6 = 4;
                                            list2.add(i6);
                                            hashMap.put(eVar.f2868c, aVar2);
                                        }
                                        list2 = aVar2.f2823d;
                                        i6 = 2;
                                        list2.add(i6);
                                        hashMap.put(eVar.f2868c, aVar2);
                                    }
                                }
                            }
                            sb = new StringBuilder();
                            sb.append("collect app active data by traffic usage, size: ");
                            sb.append(hashMap.size());
                        }
                    }
                    cn.jiguang.bb.f.c("CollectByTrafficUsage", sb.toString());
                    return hashMap;
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("CollectByTrafficUsage", "get app traffic usage data failed, " + th.getMessage());
                return hashMap;
            }
        }
        cn.jiguang.bb.f.i("CollectByTrafficUsage", "exception error, null is occur");
        return hashMap;
    }
}
