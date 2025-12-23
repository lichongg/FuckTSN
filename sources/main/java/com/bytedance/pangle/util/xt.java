package com.bytedance.pangle.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static String f25548j;

    public static String j(Context context) {
        if (f25548j == null) {
            String[] j6 = cw.j(new File(context.getApplicationInfo().sourceDir));
            String str = j6[0];
            f25548j = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + j6[2]);
            }
        }
        return f25548j;
    }

    public static boolean j() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
