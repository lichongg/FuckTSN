package com.huawei.hms.scankit.p;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class x7 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f35016b = Pattern.compile("\r?\n[ \t]");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f35017c = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f35018d = Pattern.compile(";");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f35019e = Pattern.compile("(?<!\\\\);+");

    /* renamed from: f, reason: collision with root package name */
    static final String[] f35020f = new String[0];

    protected static int a(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return c6 - '0';
        }
        if (c6 >= 'a' && c6 <= 'f') {
            return c6 - 'W';
        }
        if (c6 < 'A' || c6 > 'F') {
            return -1;
        }
        return c6 - '7';
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            int i7 = HmsScan.TelPhoneNumber.OTHER_USE_TYPE;
            HmsScan.TelPhoneNumber telPhoneNumber = new HmsScan.TelPhoneNumber(i7, strArr2[i6]);
            String str = strArr[i6];
            if (str != null) {
                if (str.equals("WORK")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.OFFICE_USE_TYPE;
                } else if (strArr[i6].equals("HOME")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                } else if (strArr[i6].equals("CELL")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.CELLPHONE_NUMBER_USE_TYPE;
                } else if (strArr[i6].equals("FAX")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.FAX_USE_TYPE;
                } else {
                    telPhoneNumber.useType = i7;
                }
            }
            telPhoneNumberArr[i6] = telPhoneNumber;
        }
        return telPhoneNumberArr;
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a6 = t6.a(s6Var);
        if (!a6.startsWith("BEGIN:VCARD")) {
            return null;
        }
        String str = a6 + com.snail.antifake.deviceid.e.f37542d;
        String a7 = a("N", str, true, false);
        if (a7 == null || a7.isEmpty() || a7.split(";").length == 0) {
            return null;
        }
        String a8 = a("FN", str, true, false);
        if (a8 == null || a8.isEmpty()) {
            a8 = c(a7);
        }
        String str2 = a8;
        List<List<String>> b6 = b("TEL", str, true, false);
        List<List<String>> b7 = b("EMAIL", str, true, false);
        List<List<String>> b8 = b("ADR", str, true, true);
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str2, HmsScan.CONTACT_DETAIL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.ContactDetail(a(a7, str2), a("TITLE", str, true, false), a("ORG", str, true, true), c(b(b6), a(b6)), b(b(b7), a(b7)), a(b(b8), a(b8)), a(b(Field.URL, str, true, false)), null)));
    }

    static int a(int i6, String str, boolean z5) {
        int indexOf;
        while (true) {
            indexOf = str.indexOf(10, i6);
            if (indexOf >= 0) {
                if (indexOf < str.length() - 1) {
                    int i7 = indexOf + 1;
                    if (str.charAt(i7) == ' ' || str.charAt(i7) == '\t') {
                        i6 = indexOf + 2;
                    }
                }
                if (!z5 || (!a(indexOf, 1, str) && !a(indexOf, 2, str))) {
                    break;
                }
                i6 = indexOf + 1;
            } else {
                break;
            }
        }
        return indexOf;
    }

    static void a(String str, boolean z5, boolean z6, String str2, boolean z7, List<String> list, List<List<String>> list2) {
        String replaceAll;
        if (z5) {
            str = str.trim();
        }
        if (z6) {
            replaceAll = a((CharSequence) str, str2);
            if (z7) {
                replaceAll = f35019e.matcher(replaceAll).replaceAll(" ").trim();
            }
        } else {
            if (z7) {
                str = f35019e.matcher(str).replaceAll(" ").trim();
            }
            replaceAll = f35016b.matcher(str).replaceAll("");
        }
        if (list == null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(replaceAll);
            list2.add(arrayList);
        } else {
            list.add(0, replaceAll);
            list2.add(list);
        }
    }

    private static String a(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i6 = 0;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 != '\n' && charAt2 != '\r') {
                if (charAt2 != '=') {
                    a(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (i6 < length - 2 && (charAt = charSequence.charAt(i6 + 1)) != '\r' && charAt != '\n') {
                    i6 += 2;
                    char charAt3 = charSequence.charAt(i6);
                    int a6 = a(charAt);
                    int a7 = a(charAt3);
                    if (a6 >= 0 && a7 >= 0) {
                        byteArrayOutputStream.write((a6 << 4) + a7);
                    }
                }
            }
            i6++;
        }
        a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static String c(String str) {
        int indexOf;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArr = new String[5];
        int i6 = 0;
        int i7 = 0;
        while (i6 < 4 && (indexOf = str.indexOf(59, i7)) >= 0) {
            strArr[i6] = str.substring(i7, indexOf);
            i6++;
            i7 = indexOf + 1;
        }
        strArr[i6] = str.substring(i7);
        StringBuilder sb = new StringBuilder(100);
        a(strArr, 3, sb);
        a(strArr, 1, sb);
        a(strArr, 2, sb);
        a(strArr, 0, sb);
        a(strArr, 4, sb);
        return sb.toString().trim();
    }

    static List<List<String>> b(CharSequence charSequence, String str, boolean z5, boolean z6) {
        boolean z7;
        String str2;
        ArrayList arrayList;
        int length = str.length();
        Pattern compile = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:\n(?![ |\t])]*))?:");
        int i6 = 0;
        ArrayList arrayList2 = null;
        while (i6 < length) {
            Matcher matcher = compile.matcher(str);
            if (i6 > 0) {
                i6--;
            }
            if (!matcher.find(i6)) {
                break;
            }
            int end = matcher.end(0);
            String group = matcher.group(1);
            if (group != null) {
                z7 = false;
                ArrayList arrayList3 = null;
                String str3 = null;
                for (String str4 : f35018d.split(group)) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList(1);
                    }
                    arrayList3.add(str4);
                    String[] split = f35017c.split(str4, 2);
                    if (split.length > 1) {
                        if ("ENCODING".equalsIgnoreCase(split[0]) && "QUOTED-PRINTABLE".equalsIgnoreCase(split[1])) {
                            z7 = true;
                        } else if ("CHARSET".equalsIgnoreCase(split[0])) {
                            str3 = split[1];
                        }
                    }
                }
                arrayList = arrayList3;
                str2 = str3;
            } else {
                z7 = false;
                str2 = null;
                arrayList = null;
            }
            int a6 = a(end, str, z7);
            if (a6 < 0) {
                a6 = length;
            } else if (a6 > end) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                }
                ArrayList arrayList4 = arrayList2;
                if (a6 >= 1 && str.charAt(a6 - 1) == '\r') {
                    a6--;
                }
                a(str.substring(end, a6), z5, z7, str2, z6, arrayList, arrayList4);
                arrayList2 = arrayList4;
            }
            i6 = a6 + 1;
        }
        return arrayList2;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    private static String a(CharSequence charSequence, String str, boolean z5, boolean z6) {
        List<List<String>> b6 = b(charSequence, str, z5, z6);
        String str2 = "";
        if (b6 != null && !b6.isEmpty()) {
            for (List<String> list : b6) {
                if (list.get(0) != null && !list.get(0).isEmpty()) {
                    str2 = list.get(0);
                }
            }
        }
        return str2;
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection != null && !collection.isEmpty()) {
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<List<String>> it = collection.iterator();
            while (it.hasNext()) {
                String str = it.next().get(0);
                if (str != null && !str.isEmpty()) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(f35020f);
        }
        return new String[0];
    }

    private static String[] b(Collection<List<String>> collection) {
        String str;
        if (collection != null && !collection.isEmpty()) {
            ArrayList arrayList = new ArrayList(collection.size());
            for (List<String> list : collection) {
                String str2 = list.get(0);
                if (str2 != null && !str2.isEmpty()) {
                    int i6 = 1;
                    while (true) {
                        if (i6 >= list.size()) {
                            str = null;
                            break;
                        }
                        str = list.get(i6);
                        int indexOf = str.indexOf(61);
                        if (indexOf < 0) {
                            break;
                        }
                        if ("TYPE".equals(str.substring(0, indexOf))) {
                            str = str.substring(indexOf + 1);
                            break;
                        }
                        i6++;
                    }
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(f35020f);
        }
        return new String[0];
    }

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        if (str != null) {
            String[] split = str.split(";");
            if (split.length > 0) {
                peopleName.familyName = split[0];
            }
            if (split.length > 1) {
                peopleName.givenName = split[1];
            }
            if (split.length > 2) {
                peopleName.middleName = split[2];
            }
            if (split.length > 3) {
                peopleName.namePrefix = split[3];
            }
            if (split.length > 4) {
                peopleName.nameSuffix = split[4];
            }
        }
        if (str2 != null) {
            peopleName.fullName = str2;
        }
        return peopleName;
    }

    private static HmsScan.EmailContent[] b(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.EmailContent[0];
        }
        HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            HmsScan.EmailContent emailContent = new HmsScan.EmailContent(strArr2[i6], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
            String str = strArr[i6];
            if (str != null) {
                if (str.equals("WORK")) {
                    emailContent.addressType = HmsScan.EmailContent.OFFICE_USE_TYPE;
                } else if (strArr[i6].equals("HOME")) {
                    emailContent.addressType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                }
            }
            emailContentArr[i6] = emailContent;
        }
        return emailContentArr;
    }

    private static HmsScan.AddressInfo[] a(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.AddressInfo[0];
        }
        HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            HmsScan.AddressInfo addressInfo = new HmsScan.AddressInfo(new String[]{strArr2[i6]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
            String str = strArr[i6];
            if (str != null) {
                if (str.equals("WORK")) {
                    addressInfo.addressType = HmsScan.AddressInfo.OFFICE_TYPE;
                } else if (strArr[i6].equals("HOME")) {
                    addressInfo.addressType = HmsScan.AddressInfo.RESIDENTIAL_USE_TYPE;
                }
            }
            addressInfoArr[i6] = addressInfo;
        }
        return addressInfoArr;
    }

    private static void a(String[] strArr, int i6, StringBuilder sb) {
        String str = strArr[i6];
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i6]);
    }

    private static boolean a(int i6, int i7, String str) {
        return i6 >= i7 && str.charAt(i6 - i7) == '=';
    }
}
