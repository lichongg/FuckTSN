package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    private static HashMap<String, ArrayList<String>> aYr = new HashMap<>();
    private static String aYs;

    @Nullable
    private static ArrayList<String> M(Context context, String str) {
        String packageName;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (aYr.get(str) != null) {
            return aYr.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : getSignatures(context, packageName)) {
                String str2 = "error!";
                if (com.baidu.mobads.sdk.internal.by.f10823a.equals(str)) {
                    str2 = a(signature, com.baidu.mobads.sdk.internal.by.f10823a);
                } else if ("SHA1".equals(str)) {
                    str2 = a(signature, "SHA1");
                } else if ("SHA256".equals(str)) {
                    str2 = a(signature, "SHA256");
                }
                arrayList.add(str2);
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("AppSigningUtil", "签名信息列表获取失败 " + e6.getMessage());
        }
        aYr.put(str, arrayList);
        return arrayList;
    }

    @Nullable
    public static String cs(Context context) {
        if (!TextUtils.isEmpty(aYs)) {
            return aYs;
        }
        ArrayList<String> M = M(context, "SHA1");
        if (M != null && M.size() != 0) {
            aYs = M.get(0);
        }
        return aYs;
    }

    private static Signature[] getSignatures(Context context, String str) {
        try {
            PackageInfo packageInfo = y.getPackageInfo(context, str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("AppSigningUtil", e6.getMessage());
            return null;
        }
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b6 : digest) {
                sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("AppSigningUtil", e6.getMessage());
            return "error!";
        }
    }
}
