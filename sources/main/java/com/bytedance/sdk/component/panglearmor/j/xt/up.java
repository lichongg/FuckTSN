package com.bytedance.sdk.component.panglearmor.j.xt;

import android.text.TextUtils;
import androidx.camera.core.processing.j0;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    public static String j(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        List<String> xt = xt(new ArrayList(new TreeSet(list)));
        return j0.a(Logger.f33116c, xt.subList(0, Math.min(xt.size(), 100)));
    }

    private static List<String> xt(List<String> list) {
        if (list != null && !list.isEmpty()) {
            String[] strArr = {"abc_", "$avd_hide_", "avd_hide_", "$avd_show_", "avd_show_", "m3_avd_", "$m3_avd_", "ic_mtrl_", "$mtrl_", "mtrl_", "btn_checkbox_", "bd_progress_", "bd_bg_", "btn_radio_", "pangle_", "ksad_", "anythink_", "gdt_", "ksadsdk_", "mbridge_", "sig_", "tt_appdownloader_", "tt_mediation_", "ttdownloader_", "com.qq.e.", MediationConstant.ADN_KLEVIN, "kssdk_", "mobads_", "tapad_", "umeng_", "bdxadsdk.jar", "bugly_", "vivo_module_", "notplugmapnaveinfoox111.dex", "notplugmappoiinfoxo.db", "notplugmaprouteextradata.db", "-journal"};
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                for (int i6 = 0; i6 < 37; i6++) {
                    String str = strArr[i6];
                    if (!TextUtils.isEmpty(str) && (next.startsWith(str) || next.endsWith(str))) {
                        it.remove();
                        break;
                    }
                }
            }
        }
        return list;
    }
}
