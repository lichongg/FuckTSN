package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class n2 extends t6 {

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f34591c = new a();

    /* renamed from: b, reason: collision with root package name */
    private String f34592b = "";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends ArrayList<String> {
        a() {
            add("");
            add("DCT");
            add("DAD");
            add("DCS");
            add("DBC");
            add("DBB");
            add("DAG");
            add("DAI");
            add("DAJ");
            add("DAK");
            add("DAQ");
            add("DCG");
            add("DBD");
            add("DBA");
        }
    }

    public HmsScan.DriverInfo a(String[] strArr, String str) {
        String[] strArr2 = {"", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        strArr2[0] = str;
        boolean z5 = false;
        for (String str2 : strArr) {
            if (str2.length() <= 3) {
                return null;
            }
            int indexOf = f34591c.indexOf(str2.substring(0, 3));
            if (indexOf != -1) {
                strArr2[indexOf] = str2.substring(3).trim();
                z5 = true;
            }
        }
        if (!z5) {
            return null;
        }
        this.f34592b = strArr2[0] + " " + strArr2[3] + " " + strArr2[1];
        return new HmsScan.DriverInfo(strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], strArr2[9], strArr2[10], strArr2[11], strArr2[12], strArr2[13], null, null, null, null);
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a6 = t6.a(s6Var);
        if (!TextUtils.isEmpty(a6) && a6.startsWith("@") && a6.length() > 34 && a6.substring(4, 8).equals("ANSI")) {
            String valueOf = String.valueOf(a6.charAt(1));
            String valueOf2 = String.valueOf(a6.charAt(3));
            String substring = a6.substring(21, 23);
            HmsScan.DriverInfo a7 = a(a6.substring(a6.indexOf(substring, 23) + 2).split(valueOf2)[0].split(valueOf), substring);
            if (a7 != null) {
                return new HmsScan(s6Var.k(), t6.a(s6Var.c()), this.f34592b, HmsScan.DRIVER_INFO_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(a7));
            }
        }
        return null;
    }
}
