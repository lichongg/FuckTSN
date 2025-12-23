package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class y7 extends t6 {
    private static void a(String[] strArr, HmsScan.EventTime eventTime) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            d3.a(str, eventTime);
        }
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a6 = t6.a(s6Var);
        if (!a6.startsWith("BEGIN:VEVENT")) {
            return null;
        }
        String str = a6 + com.snail.antifake.deviceid.e.f37542d;
        String a7 = a("SUMMARY", str, true);
        String a8 = a("LOCATION", str, true);
        String a9 = a("ORGANIZER", str, true);
        String a10 = a("DESCRIPTION", str, true);
        String a11 = a("STATUS", str, true);
        String[] b6 = b("DTSTART", str, true);
        String[] b7 = b("DTEND", str, true);
        HmsScan.EventTime eventTime = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        HmsScan.EventTime eventTime2 = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        a(b6, eventTime);
        a(b7, eventTime2);
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a7, HmsScan.EVENT_INFO_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.EventInfo(a7, eventTime, eventTime2, a8, a10, a9, a11)));
    }

    private static String a(CharSequence charSequence, String str, boolean z5) {
        List<List<String>> b6 = x7.b(charSequence, str, z5, false);
        return (b6 == null || b6.isEmpty()) ? "" : b6.get(b6.size() - 1).get(0);
    }

    private static String[] b(CharSequence charSequence, String str, boolean z5) {
        List<List<String>> b6 = x7.b(charSequence, str, z5, false);
        if (b6 != null && !b6.isEmpty()) {
            int size = b6.size();
            String[] strArr = new String[size];
            for (int i6 = 0; i6 < size; i6++) {
                strArr[i6] = b6.get(i6).get(0);
            }
            return strArr;
        }
        return new String[0];
    }
}
