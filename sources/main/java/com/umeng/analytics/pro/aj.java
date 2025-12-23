package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class aj implements aa {

    /* renamed from: a, reason: collision with root package name */
    private Set<Integer> f40838a;

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return 0L;
    }

    public aj(Set<Integer> set) {
        this.f40838a = null;
        this.f40838a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int i6 = 7;
            int i7 = calendar.get(7) - 1;
            if (i7 != 0) {
                i6 = i7;
            }
            Set<Integer> set = this.f40838a;
            if (set != null && set.contains(Integer.valueOf(i6))) {
                return true;
            }
            String str = "";
            Iterator<Integer> it = this.f40838a.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "WeekOn skipped. day of week: " + i6 + "; config: " + str);
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }
}
