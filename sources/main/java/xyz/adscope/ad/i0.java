package xyz.adscope.ad;

import android.content.Context;
import java.util.Map;
import java.util.Set;
import xyz.adscope.common.v2.persistent.sp.CommonSpHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f55223a = f0.a();

    public static Map<String, ?> a(Context context, String str) {
        return CommonSpHelper.getAll(context, str);
    }

    public static void b(Context context, String str, String str2, String str3) {
        CommonSpHelper.putString(context, str, str2, str3);
    }

    public static void a(Context context, String str, String str2, boolean z5) {
        CommonSpHelper.putBoolean(context, str, str2, z5);
    }

    public static void b(Context context, String str, String str2, long j6) {
        CommonSpHelper.putLong(context, str, str2, j6);
    }

    public static boolean a(Context context, String str, String str2, Set<String> set) {
        return CommonSpHelper.putStringSet(context, str, str2, set);
    }

    public static boolean b(Context context, String str, String str2) {
        return CommonSpHelper.getBoolean(context, str, str2);
    }

    public static Set<String> c(Context context, String str, String str2) {
        return CommonSpHelper.getStringSet(context, str, str2);
    }

    public static String a(Context context, String str, String str2, String str3) {
        return CommonSpHelper.getString(context, str, str2, str3);
    }

    public static String b() {
        return String.format("asnp_cfg_%s", f55223a);
    }

    public static long a(Context context, String str, String str2, long j6) {
        return CommonSpHelper.getLong(context, str, str2, j6);
    }

    public static boolean a(Context context, String str, String str2) {
        return CommonSpHelper.containKey(context, str, str2);
    }

    public static String a() {
        return CommonSpHelper.getBasicSPFile(f55223a);
    }
}
