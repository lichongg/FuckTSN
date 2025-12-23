package com.bytedance.msdk.j;

import android.text.TextUtils;
import com.bytedance.msdk.core.xt;
import com.bytedance.msdk.tl.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j {
    public static String j(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3) || (!TextUtils.equals(str, MediationConstant.ADN_GDT) && !TextUtils.equals(str, MediationConstant.ADN_PANGLE))) {
            return str2;
        }
        return str2 + "_" + str3;
    }

    public static String j(String str, String str2) {
        String[] split;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (TextUtils.equals(str, MediationConstant.ADN_PANGLE)) {
            String[] split2 = str2.split("message:");
            if (split2 != null && split2.length > 0) {
                String str3 = split2[0];
                if (!TextUtils.isEmpty(str3) && (split = str3.trim().split(":")) != null && split.length >= 2) {
                    String str4 = split[1];
                    if (!TextUtils.isEmpty(str4)) {
                        return str4.trim();
                    }
                }
            }
            return "";
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] charArray = str2.toCharArray();
        int i6 = 0;
        while (true) {
            if (i6 >= charArray.length) {
                break;
            }
            char c6 = charArray[i6];
            if (c6 >= '0' && c6 <= '9') {
                sb.append(c6);
                if (i6 == charArray.length - 1) {
                    arrayList.add(sb.toString());
                    break;
                }
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            if (arrayList.size() > 0) {
                return (String) arrayList.get(0);
            }
            i6++;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append("_");
        }
        if (sb2.length() > 0) {
            sb2.delete(sb2.length() - 1, sb2.length());
        }
        return sb2.toString();
    }

    public static boolean j() {
        boolean cw = x.cw(xt.getContext());
        boolean xt = x.xt(xt.getContext());
        if (xt.xt().vl()) {
            return cw || xt;
        }
        return false;
    }
}
