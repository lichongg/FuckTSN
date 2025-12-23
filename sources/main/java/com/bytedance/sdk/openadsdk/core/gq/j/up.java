package com.bytedance.sdk.openadsdk.core.gq.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static final List<String> f29115j = new ArrayList(Arrays.asList("1", "3", "2"));

    private static String j(String str) {
        str.getClass();
        switch (str) {
            case "46000":
            case "46002":
            case "46004":
            case "46007":
            case "46008":
                return "1";
            case "46001":
            case "46006":
            case "46009":
                return "2";
            case "46003":
            case "46005":
            case "46011":
                return "3";
            default:
                return "0";
        }
    }

    public static String j() {
        String i6 = kt.i();
        String mi = kt.mi();
        String w5 = kt.w();
        String kt = kt.kt();
        if (!kt.av()) {
            return "5";
        }
        if (!TextUtils.isEmpty(i6) && !TextUtils.isEmpty(mi)) {
            if (!TextUtils.isEmpty(w5) && !TextUtils.isEmpty(kt)) {
                String j6 = j(i6 + mi);
                String j7 = j(w5 + kt);
                List<String> list = f29115j;
                if (list.contains(j6) && list.contains(j7) && !j7.equals(j6)) {
                    return "6";
                }
                return list.contains(j6) ? j6 : list.contains(j7) ? j7 : "0";
            }
            return j(i6 + mi);
        }
        if (!TextUtils.isEmpty(w5) && !TextUtils.isEmpty(kt)) {
            return j(w5 + kt);
        }
        return "4";
    }
}
