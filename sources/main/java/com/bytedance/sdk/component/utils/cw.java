package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.baidu.mobads.sdk.internal.by;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static HashMap<String, ArrayList<String>> f26859j = new HashMap<>();

    public static ArrayList<String> j(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (f26859j.get(str) != null) {
                return f26859j.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : xt(context, packageName)) {
                    String str2 = "error!";
                    if (by.f10823a.equals(str)) {
                        str2 = j(signature, by.f10823a);
                    } else if ("SHA1".equals(str)) {
                        str2 = j(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        str2 = j(signature, "SHA256");
                    }
                    arrayList.add(str2);
                }
            } catch (Exception e6) {
                vl.cw(e6.toString());
            }
            f26859j.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] xt(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e6) {
            vl.cw(e6.toString());
            return null;
        }
    }

    public static String j(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> j6 = j(context, "SHA1");
        if (j6 != null && j6.size() != 0) {
            for (int i6 = 0; i6 < j6.size(); i6++) {
                sb.append(j6.get(i6));
                if (i6 < j6.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String j(Signature signature, String str) {
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
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e6) {
            vl.cw(e6.toString());
            return "error!";
        }
    }
}
