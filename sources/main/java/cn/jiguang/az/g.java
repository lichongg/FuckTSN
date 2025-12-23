package cn.jiguang.az;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static String f1862a;

    /* renamed from: b, reason: collision with root package name */
    private static String f1863b;

    /* renamed from: c, reason: collision with root package name */
    private static String f1864c;

    private static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i6;
        int i7;
        PackageInfo a6;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            cn.jiguang.ay.b.e("JDyAndroidUtils", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            i7 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            a6 = f.a(context, str, Integer.valueOf(i7));
        } catch (Throwable th) {
            cn.jiguang.ay.b.f("JDyAndroidUtils", "hasComponent error:" + th);
        }
        if (a6 == null) {
            return null;
        }
        ComponentInfo[] componentInfoArr = i7 != 1 ? i7 != 2 ? i7 != 4 ? i7 != 8 ? null : a6.providers : a6.services : a6.receivers : a6.activities;
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ay.b.g("ReflectUtils", "getCurrentProcessNameByActivityThread: " + th.getMessage());
            return null;
        }
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                byte[] bArr = new byte[256];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        fileInputStream.close();
                        return sb.toString();
                    }
                    for (int i6 = 0; i6 < read; i6++) {
                        byte b6 = bArr[i6];
                        if (b6 == 0) {
                            break;
                        }
                        sb.append((char) b6);
                    }
                }
            } finally {
            }
        } catch (IOException unused) {
            return "";
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        String a6 = a(context);
        if (TextUtils.isEmpty(a6)) {
            return false;
        }
        return a6.equals(c(context));
    }

    public static String c(Context context) {
        StringBuilder sb;
        String str;
        String str2 = f1864c;
        if (str2 != null) {
            return str2;
        }
        String d6 = d(context);
        if (TextUtils.isEmpty(d6)) {
            f1864c = context.getPackageName();
            sb = new StringBuilder();
            str = "user serviceProcess is curProcessName:";
        } else {
            f1864c = a(context, d6);
            sb = new StringBuilder();
            str = "user serviceProcess is:";
        }
        sb.append(str);
        sb.append(f1864c);
        cn.jiguang.ay.b.b("JDyAndroidUtils", sb.toString());
        return f1864c;
    }

    private static String d(Context context) {
        ComponentInfo a6;
        String str;
        Class<?> cls = null;
        try {
            str = f1863b;
        } catch (Throwable th) {
            cn.jiguang.ay.b.b("JDyAndroidUtils", "getUserServiceClass failed:" + th);
        }
        if (str != null) {
            return str;
        }
        cls = Class.forName("cn.jpush.android.service.JCommonService");
        Intent intent = new Intent();
        intent.setAction(JConstants.USER_SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        String a7 = a(context, intent, "");
        if (!TextUtils.isEmpty(a7) && cls.isAssignableFrom(Class.forName(a7))) {
            f1863b = a7;
            cn.jiguang.ay.b.d("JDyAndroidUtils", "found userServiceClass :" + f1863b + " by getCommonServiceNames");
        }
        if (TextUtils.isEmpty(f1863b) && (a6 = a(context, context.getPackageName(), cls)) != null) {
            f1863b = a6.name;
            cn.jiguang.ay.b.d("JDyAndroidUtils", "found userServiceClass :" + f1863b + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(f1863b)) {
            f1863b = "";
        }
        return f1863b;
    }

    public static String a(Context context) {
        String b6;
        String processName;
        if (!TextUtils.isEmpty(f1862a)) {
            return f1862a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                f1862a = processName;
                if (!TextUtils.isEmpty(processName)) {
                    return f1862a;
                }
            }
            b6 = b();
            f1862a = b6;
        } catch (Throwable th) {
            cn.jiguang.ay.b.f("JDyAndroidUtils", "#unexcepted - getCurProcessName failed:" + th.getMessage());
        }
        if (TextUtils.isEmpty(b6)) {
            f1862a = a();
            return f1862a;
        }
        return f1862a;
    }

    private static String a(Context context, Intent intent, String str) {
        try {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (serviceInfo == null) {
                return "";
            }
            String str2 = serviceInfo.name;
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            if (!TextUtils.isEmpty(str)) {
                if (packageManager.checkPermission(str, resolveService.activityInfo.packageName) != 0) {
                    return "";
                }
            }
            return str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }
}
