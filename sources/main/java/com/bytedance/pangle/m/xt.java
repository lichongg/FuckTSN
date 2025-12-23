package com.bytedance.pangle.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.g;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    public static int f25415j = 1;
    public static int xt = 2;

    public static SharedPreferences j(Context context) {
        return com.bytedance.sdk.openadsdk.ats.cw.j(StubApp.getOrigApplicationContext(context.getApplicationContext()), "plugin_oat_info", 0);
    }

    static String[] j(String str, String str2, int i6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add(ContainerUtils.FIELD_DELIMITER);
        }
        arrayList.add("--instruction-set=" + j());
        if (i6 == f25415j) {
            if (g.ws()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i6 == xt) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String xt(String str) {
        String substring = str.substring(str.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(substring)) {
            return substring;
        }
        if (".zip".equals(substring) || ".apk".equals(substring)) {
            return str2;
        }
        return str + str2;
    }

    public static String j() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e6) {
            com.bytedance.sdk.openadsdk.api.m.j(e6);
            return null;
        }
    }

    public static String j(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        String substring2 = substring.substring(substring.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(substring2)) {
            return substring;
        }
        if (!".zip".equals(substring2) && !".apk".equals(substring2)) {
            return substring + str2;
        }
        return substring.replace(substring2, str2);
    }

    public static boolean j(String str, String str2) {
        return j.j(j(str, str2, f25415j));
    }

    public static boolean j(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !tl.j(file)) {
                return false;
            }
        }
        return true;
    }

    public static boolean j(String str, String... strArr) {
        for (String str2 : strArr) {
            if (!new File(str + File.separator + j(str2)).exists()) {
                return false;
            }
        }
        return true;
    }
}
