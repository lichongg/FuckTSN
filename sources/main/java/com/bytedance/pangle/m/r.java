package com.bytedance.pangle.m;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.m.m;
import java.io.File;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements m.j {
    @Override // com.bytedance.pangle.m.m.j
    public boolean j(String str, int i6) {
        String xt = com.bytedance.pangle.up.cw.xt(str, i6);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(xt)));
        String cw = com.bytedance.pangle.up.cw.cw(str, i6);
        StringBuilder sb = new StringBuilder();
        sb.append(cw);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("compFully");
        sb.append(xt.xt(xt));
        String sb2 = sb.toString();
        String str3 = cw + str2 + xt.j(xt);
        if (!xt(xt, sb2)) {
            return false;
        }
        j(sb2, str3);
        boolean j6 = xt.j(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(j6)));
        return j6;
    }

    private static boolean xt(@NonNull String str, @NonNull String str2) {
        try {
            return j.j(xt.j(str, str2, xt.xt));
        } catch (Exception unused) {
            return false;
        }
    }

    private void j(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
        }
        String str3 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        File file2 = new File(str.replace(str3, ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str2.replace(str3, ".vdex")));
        }
    }
}
