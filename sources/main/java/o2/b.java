package o2;

import android.content.ContentResolver;
import android.content.Context;
import android.os.IBinder;
import android.os.Process;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {
    public static String a(Context context, String str) {
        try {
            Class<?> cls = Class.forName("android.os.UserHandle");
            Class<?> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("getUserId", cls2);
            declaredMethod.setAccessible(true);
            Integer num = (Integer) declaredMethod.invoke(null, Integer.valueOf(Process.myUid()));
            num.intValue();
            Method declaredMethod2 = Class.forName("android.provider.Settings$Secure").getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, cls2);
            declaredMethod2.setAccessible(true);
            return (String) declaredMethod2.invoke(null, context.getContentResolver(), str, num);
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static String b(Context context, String str) {
        char c6;
        Class<?> cls = Integer.TYPE;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Method declaredMethod = Class.forName("android.os.UserHandle").getDeclaredMethod("getUserId", cls);
            declaredMethod.setAccessible(true);
            Integer num = (Integer) declaredMethod.invoke(null, Integer.valueOf(Process.myUid()));
            num.intValue();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            try {
                Class<?> cls2 = Class.forName("android.provider.Settings$Global");
                Field declaredField = cls2.getDeclaredField("MOVED_TO_SECURE");
                declaredField.setAccessible(true);
                hashSet = (HashSet) declaredField.get(cls2);
            } catch (Exception unused) {
            }
            try {
                Class<?> cls3 = Class.forName("android.provider.Settings$Secure");
                Field declaredField2 = cls3.getDeclaredField("MOVED_TO_LOCK_SETTINGS");
                declaredField2.setAccessible(true);
                hashSet2 = (HashSet) declaredField2.get(cls3);
            } catch (Exception unused2) {
            }
            try {
                Class<?> cls4 = Class.forName("android.provider.Settings$Secure");
                Field declaredField3 = cls4.getDeclaredField("MOVED_TO_GLOBAL");
                declaredField3.setAccessible(true);
                hashSet3 = (HashSet) declaredField3.get(cls4);
            } catch (Exception unused3) {
            }
            if (!hashSet.contains(str)) {
                if (hashSet3.contains(str)) {
                    Method declaredMethod2 = Class.forName("android.provider.Global").getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, cls);
                    declaredMethod2.setAccessible(true);
                    return (String) declaredMethod2.invoke(null, contentResolver, str, num);
                }
                if (hashSet2.contains(str)) {
                    Method declaredMethod3 = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", null);
                    declaredMethod3.setAccessible(true);
                    IBinder iBinder = (IBinder) declaredMethod3.invoke(null, "lock_settings");
                    c6 = 0;
                    Method declaredMethod4 = Class.forName("com.android.internal.widget.ILockSettings$Stub").getDeclaredMethod("asInterface", IBinder.class);
                    declaredMethod4.setAccessible(true);
                    Object invoke = declaredMethod4.invoke(null, iBinder);
                    boolean z5 = Process.myUid() == 1000;
                    if (hashSet2.contains(str) && invoke != null && !z5) {
                        return (String) invoke.getClass().getDeclaredMethod("getString", String.class, String.class, cls).invoke(str, "0", num);
                    }
                    Field declaredField4 = Class.forName("android.provider.Settings$Secure").getDeclaredField("sNameValueCache");
                    declaredField4.setAccessible(true);
                    Object obj = declaredField4.get(null);
                    Class<?> cls5 = obj.getClass();
                    Class<?>[] clsArr = new Class[3];
                    clsArr[c6] = ContentResolver.class;
                    clsArr[1] = String.class;
                    clsArr[2] = cls;
                    Method declaredMethod5 = cls5.getDeclaredMethod("getStringForUser", clsArr);
                    Object[] objArr = new Object[3];
                    objArr[c6] = contentResolver;
                    objArr[1] = str;
                    objArr[2] = num;
                    return (String) declaredMethod5.invoke(obj, objArr);
                }
            }
            c6 = 0;
            Field declaredField42 = Class.forName("android.provider.Settings$Secure").getDeclaredField("sNameValueCache");
            declaredField42.setAccessible(true);
            Object obj2 = declaredField42.get(null);
            Class<?> cls52 = obj2.getClass();
            Class<?>[] clsArr2 = new Class[3];
            clsArr2[c6] = ContentResolver.class;
            clsArr2[1] = String.class;
            clsArr2[2] = cls;
            Method declaredMethod52 = cls52.getDeclaredMethod("getStringForUser", clsArr2);
            Object[] objArr2 = new Object[3];
            objArr2[c6] = contentResolver;
            objArr2[1] = str;
            objArr2[2] = num;
            return (String) declaredMethod52.invoke(obj2, objArr2);
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }
}
