package cn.jiguang.au;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {
    public static List<cn.jiguang.as.c> a(String str, String str2, String str3, int i6) {
        List<cn.jiguang.as.c> list;
        cn.jiguang.as.c cVar = new cn.jiguang.as.c();
        cVar.f1718a = str2;
        cVar.f1719b = str3;
        if (str == null || TextUtils.isEmpty(str)) {
            list = null;
        } else {
            list = c.a(str);
            cn.jiguang.bb.f.c("JWakePackageHelper", "cache cmd wakeTargets:" + list);
        }
        if (list != null && !list.isEmpty()) {
            int size = list.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (list.get(size).f1718a.equals(str2) && list.get(size).f1719b.equals(str3)) {
                        list.remove(size);
                        break;
                    }
                    size--;
                } else {
                    break;
                }
            }
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (i6 == 1) {
            list.add(cVar);
        }
        return list;
    }
}
