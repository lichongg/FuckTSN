package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class c extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34059b = Pattern.compile("(?:MECARD:)([\\s\\S]+)", 2);

    /* renamed from: c, reason: collision with root package name */
    static final String[] f34060c = new String[0];

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        peopleName.spelling = str2;
        int indexOf = str.indexOf(",");
        if (indexOf < 0) {
            peopleName.fullName = str;
            String[] split = str.split(" ");
            if (split.length > 0) {
                peopleName.givenName = split[0];
            }
            if (split.length > 1) {
                peopleName.familyName = split[1];
            }
            return peopleName;
        }
        peopleName.familyName = str.substring(0, indexOf);
        int i6 = indexOf + 1;
        int indexOf2 = str.indexOf(",", i6);
        if (indexOf2 < 0) {
            peopleName.givenName = str.substring(i6);
        } else {
            peopleName.givenName = str.substring(i6, indexOf2);
        }
        peopleName.fullName = peopleName.givenName + " " + peopleName.familyName;
        return peopleName;
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            telPhoneNumberArr[i6] = new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OTHER_USE_TYPE, strArr[i6]);
        }
        return telPhoneNumberArr;
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a6 = t6.a(s6Var);
        if (TextUtils.isEmpty(a6)) {
            return null;
        }
        Matcher matcher = f34059b.matcher(a6);
        if (!matcher.matches()) {
            return null;
        }
        String[] split = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String a7 = a(split, "N:");
        if (a7.length() == 0) {
            return null;
        }
        String[] b6 = b(split, "TEL:");
        String[] b7 = b(split, "EMAIL:");
        String[] b8 = b(split, "ADR:");
        String[] b9 = b(split, "URL:");
        String a8 = a(split, "SOUND:");
        HmsScan.ContactDetail contactDetail = new HmsScan.ContactDetail(a(a7, a8), "", a(split, "ORG:"), c(b6), b(b7), a(b8), b9, a(split, "NOTE:"));
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), contactDetail.peopleName.fullName, HmsScan.CONTACT_DETAIL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(contactDetail));
    }

    private static HmsScan.AddressInfo[] a(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
            for (int i6 = 0; i6 < strArr.length; i6++) {
                addressInfoArr[i6] = new HmsScan.AddressInfo(new String[]{strArr[i6]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
            }
            return addressInfoArr;
        }
        return new HmsScan.AddressInfo[0];
    }

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return t6.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    private static HmsScan.EmailContent[] b(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
            for (int i6 = 0; i6 < strArr.length; i6++) {
                emailContentArr[i6] = new HmsScan.EmailContent(strArr[i6], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
            }
            return emailContentArr;
        }
        return new HmsScan.EmailContent[0];
    }

    private static String[] b(String[] strArr, String str) {
        ArrayList arrayList = new ArrayList(5);
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                arrayList.add(t6.b(str2.substring(str.length())));
            }
        }
        return (String[]) arrayList.toArray(f34060c);
    }
}
