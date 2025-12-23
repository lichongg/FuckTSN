package com.bytedance.pangle.m;

import androidx.annotation.NonNull;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.m.m;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements m.j {
    @Override // com.bytedance.pangle.m.m.j
    public boolean j(String str, int i6) {
        String j6 = ae.j(str, i6);
        String cw = com.bytedance.pangle.up.cw.cw(str, i6);
        String[] split = j6.split(":");
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(j6));
        long currentTimeMillis = System.currentTimeMillis();
        int length = split.length;
        boolean z5 = false;
        int i7 = 0;
        boolean z6 = false;
        while (true) {
            if (i7 >= length) {
                z5 = z6;
                break;
            }
            String str2 = split[i7];
            if (!j(str2, cw + File.separator + xt.j(str2))) {
                break;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
            i7++;
            z6 = true;
        }
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - currentTimeMillis) + " result:" + z5);
        return z5;
    }

    private boolean j(@NonNull String str, @NonNull String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
