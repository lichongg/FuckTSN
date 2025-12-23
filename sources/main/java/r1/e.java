package r1;

import com.huawei.hms.framework.common.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f51987a = "e";

    public static boolean a(Long l6) {
        if (l6 == null) {
            Logger.v(f51987a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
        } catch (NumberFormatException unused) {
            Logger.v(f51987a, "isSpExpire spValue NumberFormatException.");
        }
        if (l6.longValue() - System.currentTimeMillis() >= 0) {
            Logger.i(f51987a, "isSpExpire false.");
            return false;
        }
        Logger.i(f51987a, "isSpExpire true.");
        return true;
    }

    public static boolean b(Long l6, long j6) {
        if (l6 == null) {
            Logger.v(f51987a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l6.longValue() - (System.currentTimeMillis() + j6) >= 0) {
                Logger.v(f51987a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.v(f51987a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
