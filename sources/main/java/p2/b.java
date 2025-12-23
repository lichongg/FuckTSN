package p2;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {
    public static String c(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubscriberInfo", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(telephonyManager, null);
            try {
                Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getDeviceId", String.class);
                if (declaredMethod2 != null) {
                    return (String) declaredMethod2.invoke(invoke, context.getPackageName());
                }
            } catch (Exception unused) {
            }
            Method declaredMethod3 = invoke.getClass().getDeclaredMethod("getDeviceId", null);
            return declaredMethod3 != null ? (String) declaredMethod3.invoke(invoke, null) : "";
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class);
            declaredMethod.setAccessible(true);
            IBinder iBinder = (IBinder) declaredMethod.invoke(null, "iphonesubinfo");
            Method declaredMethod2 = Class.forName("com.android.internal.telephony.IPhoneSubInfo$Stub").getDeclaredMethod("asInterface", IBinder.class);
            declaredMethod2.setAccessible(true);
            Object invoke = declaredMethod2.invoke(null, iBinder);
            try {
                Method declaredMethod3 = invoke.getClass().getDeclaredMethod("getDeviceId", String.class);
                if (declaredMethod3 != null) {
                    return (String) declaredMethod3.invoke(invoke, context.getPackageName());
                }
            } catch (Exception unused) {
            }
            Method declaredMethod4 = invoke.getClass().getDeclaredMethod("getDeviceId", null);
            return declaredMethod4 != null ? (String) declaredMethod4.invoke(invoke, null) : "";
        } catch (Exception unused2) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0071 A[Catch: Exception -> 0x007e, TRY_LEAVE, TryCatch #1 {Exception -> 0x007e, blocks: (B:10:0x0067, B:12:0x0071), top: B:9:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e(android.content.Context r12) {
        /*
            java.lang.String r0 = "TRANSACTION_getDeviceId"
            java.lang.String r1 = "getDeviceId"
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            java.lang.String r3 = ""
            java.lang.String r4 = "android.os.ServiceManager"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L7f
            java.lang.String r5 = "getService"
            r6 = 1
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L7f
            r8 = 0
            r7[r8] = r2     // Catch: java.lang.Exception -> L7f
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r5, r7)     // Catch: java.lang.Exception -> L7f
            r4.setAccessible(r6)     // Catch: java.lang.Exception -> L7f
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L7f
            java.lang.String r7 = "iphonesubinfo"
            r5[r8] = r7     // Catch: java.lang.Exception -> L7f
            r7 = 0
            java.lang.Object r4 = r4.invoke(r7, r5)     // Catch: java.lang.Exception -> L7f
            android.os.IBinder r4 = (android.os.IBinder) r4     // Catch: java.lang.Exception -> L7f
            java.lang.String r5 = "com.android.internal.telephony.IPhoneSubInfo$Stub"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L7f
            java.lang.String r9 = "asInterface"
            java.lang.Class[] r10 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L7f
            java.lang.Class<android.os.IBinder> r11 = android.os.IBinder.class
            r10[r8] = r11     // Catch: java.lang.Exception -> L7f
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r9, r10)     // Catch: java.lang.Exception -> L7f
            r5.setAccessible(r6)     // Catch: java.lang.Exception -> L7f
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L7f
            r9[r8] = r4     // Catch: java.lang.Exception -> L7f
            java.lang.Object r5 = r5.invoke(r7, r9)     // Catch: java.lang.Exception -> L7f
            java.lang.Class r9 = r5.getClass()     // Catch: java.lang.Exception -> L66
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L66
            r6[r8] = r2     // Catch: java.lang.Exception -> L66
            java.lang.reflect.Method r2 = r9.getDeclaredMethod(r1, r6)     // Catch: java.lang.Exception -> L66
            if (r2 == 0) goto L66
            java.lang.String r12 = r12.getPackageName()     // Catch: java.lang.Exception -> L66
            java.lang.String r2 = com.snail.antifake.deviceid.b.a(r5)     // Catch: java.lang.Exception -> L66
            int r6 = com.snail.antifake.deviceid.b.b(r5, r0)     // Catch: java.lang.Exception -> L66
            java.lang.String r12 = a(r12, r4, r2, r6)     // Catch: java.lang.Exception -> L66
            goto L67
        L66:
            r12 = r3
        L67:
            java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Exception -> L7e
            java.lang.reflect.Method r1 = r2.getDeclaredMethod(r1, r7)     // Catch: java.lang.Exception -> L7e
            if (r1 == 0) goto L80
            java.lang.String r1 = com.snail.antifake.deviceid.b.a(r5)     // Catch: java.lang.Exception -> L7e
            int r0 = com.snail.antifake.deviceid.b.b(r5, r0)     // Catch: java.lang.Exception -> L7e
            java.lang.String r12 = a(r3, r4, r1, r0)     // Catch: java.lang.Exception -> L7e
            goto L80
        L7e:
            r3 = r12
        L7f:
            r12 = r3
        L80:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.b.e(android.content.Context):java.lang.String");
    }

    private static String a(String str, IBinder iBinder, String str2, int i6) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str2);
            if (!TextUtils.isEmpty(str)) {
                obtain.writeString(str);
            }
            iBinder.transact(i6, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return readString;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    public static String b(Context context) {
        String e6 = e(context);
        if (TextUtils.isEmpty(e6)) {
            e6 = d(context);
            if (TextUtils.isEmpty(e6)) {
                String c6 = c(context);
                TextUtils.isEmpty(c6);
                return c6;
            }
        }
        return e6;
    }
}
