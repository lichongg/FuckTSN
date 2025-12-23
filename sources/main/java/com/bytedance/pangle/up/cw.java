package com.bytedance.pangle.up;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.g;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.io.FileFilter;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private static File cw;

    /* renamed from: j, reason: collision with root package name */
    private static File f25535j;
    private static File xt;

    public static String cw() {
        Application appApplication = Zeus.getAppApplication();
        if (cw == null) {
            cw = new File(appApplication.getFilesDir(), ".pangle" + g.f25393j);
        }
        return j(cw);
    }

    public static String j(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String r() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + g.xt);
            if (externalFilesDir != null) {
                return j(externalFilesDir);
            }
            return null;
        } catch (Exception e6) {
            m.j(e6);
            return null;
        }
    }

    private static void up() {
        if (f25535j == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + g.cw);
            f25535j = file;
            j(file);
        }
    }

    public static String xt() {
        Application appApplication = Zeus.getAppApplication();
        if (xt == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + g.xt);
            }
            xt = downloadDir;
        }
        return j(xt);
    }

    public static String ae(String str, int i6) {
        return new File(j(str, "version-".concat(String.valueOf(i6)), "apk", "temp")).getPath();
    }

    public static String g(String str, int i6) {
        return j(str, "version-".concat(String.valueOf(i6)), "secondary-dexes");
    }

    public static String m(String str, int i6) {
        return new File(j(str, "version-".concat(String.valueOf(i6)), "apk")).getPath();
    }

    public static boolean oq(@NonNull String str, int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append(j());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append("version-");
        sb.append(i6);
        return new File(sb.toString()).exists();
    }

    public static File[] qv(String str, int i6) {
        String j6 = j(str, "version-".concat(String.valueOf(i6)), "dex");
        if (TextUtils.isEmpty(j6)) {
            return null;
        }
        return new File(j6).listFiles(new FileFilter() { // from class: com.bytedance.pangle.up.cw.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file.isFile() && file.getName().endsWith(".dex")) {
                    return true;
                }
                return false;
            }
        });
    }

    public static String vl(String str, int i6) {
        return new File(j(str, "version-".concat(String.valueOf(i6)), "config"), "config.json").getPath();
    }

    public static String tl(String str, int i6) {
        if (com.bytedance.pangle.util.g.ws()) {
            return j(str, "version-".concat(String.valueOf(i6)), "apk", "temp", "oat", com.bytedance.pangle.m.xt.j());
        }
        return j(str, "version-".concat(String.valueOf(i6)), "dalvik-cache");
    }

    private static String j(String... strArr) {
        up();
        File file = f25535j;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return j(file);
    }

    public static String up(String str, int i6) {
        return new File(j(str, "version-".concat(String.valueOf(i6)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String cw(String str, int i6) {
        if (com.bytedance.pangle.util.g.ws()) {
            return j(str, "version-".concat(String.valueOf(i6)), "apk", "oat", com.bytedance.pangle.m.xt.j());
        }
        return j(str, "version-".concat(String.valueOf(i6)), "dalvik-cache");
    }

    public static String r(String str, int i6) {
        return j(str, "version-".concat(String.valueOf(i6)), "lib");
    }

    public static String xt(String str, int i6) {
        return new File(j(str, "version-".concat(String.valueOf(i6)), "apk"), "base-1.apk").getPath();
    }

    public static String j() {
        up();
        return f25535j.getPath();
    }

    public static String j(String str, int i6) {
        up();
        File file = f25535j;
        String[] strArr = {str, "version-".concat(String.valueOf(i6))};
        for (int i7 = 0; i7 < 2; i7++) {
            String str2 = strArr[i7];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String j(String str) {
        return j(str);
    }

    public static String j(String str, int i6, String str2) {
        return new File(j(str, "version-".concat(String.valueOf(i6)), "dex"), str2).getPath();
    }
}
