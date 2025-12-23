package cn.jiguang.bz;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\Downloads\app\classes2.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static int f2795a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static String f2796b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f2797c = "";

    public static int a(Context context) {
        try {
            if (!cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsChecksumLevel)) {
                return 0;
            }
            if (k.a("getIntNetworkType")) {
                return f2795a;
            }
            f2795a = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
            cn.jiguang.bb.f.c("TeleonyManagerUtils", "getNetworkType int by api");
            return f2795a;
        } catch (Throwable th) {
            th.getMessage();
            return 0;
        }
    }

    public static String b(Context context) {
        String str = "";
        try {
            int a6 = a(context);
            cn.jiguang.bb.f.c("TeleonyManagerUtils", "step2 - networkType:" + a6);
            Object a7 = t.a((Class<?>) TelephonyManager.class, "getNetworkClass", new Object[]{Integer.valueOf(a6)}, new Class[]{Integer.TYPE});
            if (((Integer) a7).intValue() == 0) {
                str = "unknown";
            } else if (((Integer) a7).intValue() == 1) {
                str = "2g";
            } else if (((Integer) a7).intValue() == 2) {
                str = "3g";
            } else if (((Integer) a7).intValue() == 3) {
                str = "4g";
            }
            cn.jiguang.bb.f.c("TeleonyManagerUtils", "step2 - type:" + str);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | Exception unused) {
        }
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    public static String a(Context context, boolean z5) {
        if ((!z5 && !cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsDownloadSource)) || !q.a(context, com.kuaishou.weapon.p0.g.f36042b)) {
            return "";
        }
        if (k.a("getNetworkOperator")) {
            return f2796b;
        }
        try {
            f2796b = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            cn.jiguang.bb.f.c("TeleonyManagerUtils", "getNetworkOperator by api");
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("TeleonyManagerUtils", "getNetworkOperator failed, " + th.getMessage());
        }
        return f2796b;
    }

    public static String b(Context context, boolean z5) {
        if ((!z5 && !cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsSpeedCoefficientValue)) || !q.a(context, com.kuaishou.weapon.p0.g.f36042b)) {
            return "";
        }
        if (k.a("getNetworkOperatorName")) {
            return f2797c;
        }
        try {
            f2797c = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            cn.jiguang.bb.f.c("TeleonyManagerUtils", "getNetworkOperatorName by api");
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("TeleonyManagerUtils", "getNetworkOperatorName failed, " + th.getMessage());
        }
        return f2797c;
    }

    public static void a() {
        f2796b = "";
        o.f2773a = "";
        f2797c = "";
    }
}
