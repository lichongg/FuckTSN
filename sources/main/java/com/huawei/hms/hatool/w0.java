package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f33673a = {"e2f856b9f9a4fd4cb2795aeaf83268e4bff189aaec05d691ffde76e075b82648", "173cf86fe9894a0f70dadd09d4fd88c380836099d4939f8c3754361bdc16a32b", "b368b110e3b565fe97c91f786e11bc48754cc8e4e6f21d8a94a68ac6ad67aaaf", "db48223fd9e143f7e133c57f5d08a4e38549ce3ebd921fe3b4003c26e5e35bed", "4bdecdf772491e35c4e8b48f88aee22bae1311984f2e1da4dfad0b78ee7f5163", "3081a0adab3018d57165e6dd24074bdbac640f6dbe21a9e24d3474a87ebf38b8", "db53fcdc9ab71e9bdd4eab257fe1aba7989ad2b24fbe3a85dfef72ea1dd6bae2", "d80f18e8081b624cc64985f87f70118f1702985d2e10dbc985ee7be334fd3c7d", "5fed96c85bd58c58aadbd465c172a4c9a794d8eb2f86cbc7bcee6caf4c7a2c5f", "07ff9b7aeeff969173c45b285fe0fecdbaae244576ff7a2796a36f1c0c11adb4", "92974c6802419e4d18b5ec536cbfa167b8e8eff09ec4c8510a5b95750b1e0c82", "403f14ad2f0e5eb3c4f3a0bcd5c1592cc4492662ad53191c92905255d4990656", "4230baa077b401374d0fc012375047e79ea0790d58d095ef18d97d95470c738d", "f8d927750a0952ffb5bd87dfb83d781ae65f7bed043a7886d1d3cdcfc94bb77a", "e9702f1e92e97fce49cdf81a5fa730a4e913554d09b3fe41e1d8a7fba00a8459", "24fbae40bcd50b759b26e3ba0f46aa25e932fa7da05f226d75ec507bcf53bce5"};

    public static boolean d(String str) {
        if (x0.f33680a.booleanValue()) {
            return true;
        }
        for (String str2 : f33673a) {
            if (c(str, str2, 2)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(9)
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            j1.h("hmsSdk", "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str) && !str.toLowerCase(Locale.US).startsWith("http:")) {
                return new URI(str).getHost();
            }
            j1.e("hmsSdk", "url don't starts with https");
            return null;
        } catch (URISyntaxException e6) {
            j1.e("hmsSdk", "getHostByURI error : " + e6.getMessage());
            return null;
        }
    }

    private static String b(String str, int i6) {
        if (!TextUtils.isEmpty(str) && i6 > 0) {
            String[] split = str.split("\\.");
            if (split.length < i6) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(split[split.length - i6]);
            for (int i7 = 1; i7 < i6; i7++) {
                stringBuffer.append(".");
                stringBuffer.append(split[(split.length - i6) + i7]);
            }
            return stringBuffer.toString();
        }
        j1.h("hmsSdk", "url is null");
        return str;
    }

    public static boolean c(String str, String str2, int i6) {
        String str3;
        StringBuilder sb;
        String str4;
        String a6 = a(str);
        if (!TextUtils.isEmpty(a6) && !TextUtils.isEmpty(str2)) {
            String b6 = b(a6, i6);
            if (TextUtils.isEmpty(b6)) {
                str3 = "get urlLastNStr is null";
            } else {
                if (str2.equals(z1.d.b(a6))) {
                    return true;
                }
                if (!str2.equals(z1.d.b(b6))) {
                    return false;
                }
                try {
                    String substring = a6.substring(0, a6.length() - b6.length());
                    if (!substring.endsWith(".")) {
                        return false;
                    }
                    return substring.matches("^[A-Za-z0-9.-]+$");
                } catch (IndexOutOfBoundsException e6) {
                    e = e6;
                    sb = new StringBuilder();
                    str4 = "IndexOutOfBoundsException";
                    sb.append(str4);
                    sb.append(e.getMessage());
                    str3 = sb.toString();
                    j1.e("hmsSdk", str3);
                    return false;
                } catch (Exception e7) {
                    e = e7;
                    sb = new StringBuilder();
                    str4 = "Exception : ";
                    sb.append(str4);
                    sb.append(e.getMessage());
                    str3 = sb.toString();
                    j1.e("hmsSdk", str3);
                    return false;
                }
            }
        } else {
            str3 = "url or whitelistHash is null";
        }
        j1.e("hmsSdk", str3);
        return false;
    }
}
