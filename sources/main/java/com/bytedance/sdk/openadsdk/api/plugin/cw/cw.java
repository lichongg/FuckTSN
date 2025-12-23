package com.bytedance.sdk.openadsdk.api.plugin.cw;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.m;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    public static String[] f27559j;

    public static boolean j() {
        String[] strArr = Build.SUPPORTED_ABIS;
        StringBuilder sb = new StringBuilder("abi-support: ");
        sb.append(strArr == null ? "null" : strArr.toString());
        m.j(sb.toString());
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("arm64-v8a")) {
                return true;
            }
        }
        return false;
    }

    private static void r() {
        if (f27559j != null || TextUtils.isEmpty("null")) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray("null");
            String[] strArr = new String[jSONArray.length()];
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                strArr[i6] = jSONArray.getString(i6);
            }
            f27559j = strArr;
        } catch (Exception unused) {
        }
    }

    public static boolean cw() {
        r();
        String[] strArr = f27559j;
        if (strArr == null || strArr.length == 0 || strArr.length != 1 || !strArr[0].toLowerCase().contains("arm64-v8a")) {
            return false;
        }
        return true;
    }

    public static boolean xt() {
        if (cw() && !j()) {
            return true;
        }
        return false;
    }
}
