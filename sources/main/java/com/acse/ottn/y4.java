package com.acse.ottn;

import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class y4 {
    public static boolean c() {
        return false;
    }

    public static boolean a() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.endsWith(".so") && !readLine.endsWith(".jar")) {
                }
                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains("XposedBridge.jar")) {
                    c2.a("HookDetection", "Xposed JAR found: " + str);
                    return true;
                }
            }
            return false;
        } catch (Exception e6) {
            c2.a("HookDetection", e6.toString());
            return false;
        }
    }

    public static void b() {
        boolean z5 = false;
        try {
            HelpShopAppUtil.getContext();
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            if (!TextUtils.isEmpty(packageManager.getApplicationLabel(packageManager.getPackageInfo("de.robv.android.xposed.installer", 0).applicationInfo).toString())) {
                j3.a().a("xposed_state", Boolean.FALSE);
                z5 = true;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        j3.a().a("xposed_state", Boolean.valueOf(z5));
    }

    public static void d() {
        try {
            b();
        } catch (Exception unused) {
        }
    }
}
