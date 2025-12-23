package ms.bz.bd.c.Pgl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    static String f50293a;

    /* renamed from: b, reason: collision with root package name */
    static String f50294b;

    @SuppressLint({"MissingPermission"})
    public static synchronized String a(Context context) {
        TelephonyManager telephonyManager;
        synchronized (h1.class) {
            String str = f50293a;
            if (str != null) {
                return q1.a(str);
            }
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.a("6765744465766963654964")), null);
            declaredMethod.setAccessible(true);
            f50293a = (String) declaredMethod.invoke(telephonyManager, null);
            return q1.a(f50293a);
        }
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String b(Context context) {
        TelephonyManager telephonyManager;
        synchronized (h1.class) {
            String str = f50293a;
            if (str != null) {
                return q1.a(str);
            }
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.a("676574537562736372696265724964")), null);
            declaredMethod.setAccessible(true);
            f50294b = (String) declaredMethod.invoke(telephonyManager, null);
            return q1.a(f50294b);
        }
    }
}
