package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.scankit.p.b4;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.y3;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f33752a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f33753b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f33754c = false;

    /* renamed from: d, reason: collision with root package name */
    static int f33755d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    static int f33756e = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    private static volatile Context f33757f;

    public static int a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt("huawei_module_scankit_local", Integer.MAX_VALUE);
        } catch (PackageManager.NameNotFoundException unused) {
            o4.b("exception", "NameNotFoundException");
            return Integer.MAX_VALUE;
        }
    }

    static IRemoteCreator c(Context context) {
        Context e6;
        Preconditions.checkNotNull(context);
        try {
            e6 = e(context);
        } catch (ClassNotFoundException unused) {
            o4.b("exception", "ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            o4.b("exception", "IllegalAccessException");
        } catch (InstantiationException unused3) {
            o4.b("exception", "InstantiationException");
        } catch (NoSuchMethodException unused4) {
            o4.b("exception", "NoSuchMethodException");
        } catch (InvocationTargetException unused5) {
            o4.b("exception", "InvocationTargetException");
        }
        if (e6 == null) {
            return null;
        }
        Object newInstance = e6.getClassLoader().loadClass("com.huawei.hms.scankit.Creator").newInstance();
        if (newInstance instanceof IBinder) {
            return IRemoteCreator.Stub.asInterface((IBinder) newInstance);
        }
        return null;
    }

    static IRemoteCreator d(Context context) {
        Preconditions.checkNotNull(context);
        try {
            Object newInstance = context.getClassLoader().loadClass("com.huawei.hms.scankit.Creator").newInstance();
            if (newInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) newInstance);
            }
            return null;
        } catch (ClassNotFoundException unused) {
            o4.b("exception", "ClassNotFoundException");
            return null;
        } catch (IllegalAccessException unused2) {
            o4.b("exception", "IllegalAccessException");
            return null;
        } catch (InstantiationException unused3) {
            o4.b("exception", "InvocationTargetException");
            return null;
        }
    }

    public static Context e(Context context) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        b(context);
        if (f33757f != null && !a()) {
            return f33757f;
        }
        try {
            b4.f34021a = false;
            if (f33755d == Integer.MIN_VALUE) {
                f33755d = a(context);
            }
            Context moduleContext = DynamicModule.load(StubApp.getOrigApplicationContext(context.getApplicationContext()), DynamicModule.PREFER_REMOTE, "huawei_module_scankit").getModuleContext();
            if (f33756e == Integer.MIN_VALUE) {
                f33756e = DynamicModule.getRemoteVersion(StubApp.getOrigApplicationContext(context.getApplicationContext()), "huawei_module_scankit");
            }
            if (f33755d >= 21200300) {
                f33754c = true;
            } else {
                f33754c = false;
            }
            String b6 = y3.b(context);
            o4.d("ScankitSDK", "local Version: " + f33755d + " remote Version: " + f33756e);
            if (!a() && f33755d < f33756e && !b6.equals("com.huawei.scanner")) {
                f33752a = true;
                b4.f34021a = true;
                b4.f34022b = String.valueOf(f33756e);
                f33757f = moduleContext;
                return f33757f;
            }
            o4.d("ScankitSDK", "use local Version: " + f33755d);
            b(context);
            f33752a = false;
            f33757f = null;
            return context;
        } catch (DynamicModule.LoadingException e6) {
            o4.b("ScankitSDK", "ClassNotFoundException exception " + e6.getMessage());
            b(context);
            return context;
        } catch (ClassNotFoundException unused) {
            o4.b("ScankitSDK", "ClassNotFoundException exception");
            b(context);
            return context;
        } catch (IllegalAccessException unused2) {
            o4.b("ScankitSDK", "IllegalAccessException exception");
            b(context);
            return context;
        } catch (NoSuchMethodException unused3) {
            o4.b("ScankitSDK", "NoSuchMethodException exception");
            b(context);
            return context;
        } catch (RuntimeException unused4) {
            o4.b("ScankitSDK", "other RuntimeException exception");
            b(context);
            return context;
        } catch (InvocationTargetException unused5) {
            o4.b("ScankitSDK", "InvocationTargetException exception");
            b(context);
            return context;
        } catch (Exception unused6) {
            o4.b("ScankitSDK", "Exception exception");
            b(context);
            return context;
        } catch (Throwable unused7) {
            o4.b("ScankitSDK", "Throwable exception");
            b(context);
            return context;
        }
    }

    public static void b(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        context.getClassLoader().loadClass("com.huawei.hms.feature.DynamicModuleInitializer").getDeclaredMethod("initializeModule", Context.class).invoke(null, context);
    }

    public static boolean a() {
        return f33754c && f33752a && f33753b;
    }
}
