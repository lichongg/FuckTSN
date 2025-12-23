package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class x extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34995b = Pattern.compile("(?:BIZCARD:)([\\s\\S]+)", 2);

    private static HmsScan.PeopleName a(String str, String str2, String str3) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        peopleName.givenName = str;
        peopleName.familyName = str2;
        peopleName.fullName = str3;
        return peopleName;
    }

    private static HmsScan.AddressInfo[] c(String str) {
        return (str == null || str.isEmpty()) ? new HmsScan.AddressInfo[0] : new HmsScan.AddressInfo[]{new HmsScan.AddressInfo(new String[]{str}, HmsScan.AddressInfo.OTHER_USE_TYPE)};
    }

    private static HmsScan.EmailContent[] d(String str) {
        return (str == null || str.isEmpty()) ? new HmsScan.EmailContent[0] : new HmsScan.EmailContent[]{new HmsScan.EmailContent(str, "", "", HmsScan.EmailContent.OTHER_USE_TYPE)};
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a6 = t6.a(s6Var);
        if (TextUtils.isEmpty(a6)) {
            return null;
        }
        Matcher matcher = f34995b.matcher(a6);
        if (!matcher.matches()) {
            return null;
        }
        String[] split = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String a7 = a(split, "N:");
        String a8 = a(split, "X:");
        String trim = (a7 + " " + a8).trim();
        String a9 = a(split, "T:");
        String a10 = a(split, "C:");
        String a11 = a(split, "A:");
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), trim, HmsScan.CONTACT_DETAIL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.ContactDetail(a(a7, a8, trim), a9, a10, b(a(split, "B:"), a(split, "F:"), a(split, "M:")), d(a(split, "E:")), c(a11), new String[0], null)));
    }

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return t6.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    private static HmsScan.TelPhoneNumber[] b(String str, String str2, String str3) {
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[0];
        ArrayList arrayList = new ArrayList(3);
        if (str != null && !str.isEmpty()) {
            arrayList.add(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OFFICE_USE_TYPE, str));
        }
        if (str2 != null && !str2.isEmpty()) {
            arrayList.add(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.FAX_USE_TYPE, str2));
        }
        if (str3 != null && !str3.isEmpty()) {
            arrayList.add(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.CELLPHONE_NUMBER_USE_TYPE, str3));
        }
        return (HmsScan.TelPhoneNumber[]) arrayList.toArray(telPhoneNumberArr);
    }
}
