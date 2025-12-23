package cn.jiguang.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import cn.jiguang.bz.l;
import cn.jiguang.m.c;
import cn.jpush.android.api.JPushInterface;
import com.stub.StubApp;
import java.util.ArrayList;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<String> f1743a;

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList<String> f1744b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f1745c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f1746d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f1747e;

    static cn.jiguang.as.c a(Context context, PackageManager packageManager, String str, String str2) {
        StringBuilder sb;
        String message;
        if (packageManager != null && !TextUtils.isEmpty(str)) {
            try {
                int checkPermission = packageManager.checkPermission(str + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, str);
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    String a6 = cn.jiguang.ba.a.a(context);
                    Intent intent = new Intent();
                    intent.setClassName(str, "cn.jpush.android.service.PushService");
                    boolean z5 = packageManager.resolveService(intent, 0) != null;
                    if (checkPermission == 0 && z5 && !TextUtils.isEmpty(a6) && a6.length() == 24) {
                        cn.jiguang.as.c cVar = new cn.jiguang.as.c(str, str2, applicationInfo.targetSdkVersion);
                        cVar.f1721d = str + ".DownloadProvider";
                        return cVar;
                    }
                }
            } catch (PackageManager.NameNotFoundException e6) {
                sb = new StringBuilder();
                sb.append("checkWhetherToStart exception:");
                message = e6.toString();
                sb.append(message);
                cn.jiguang.bb.f.i("JComponentHelper", sb.toString());
                return null;
            } catch (Throwable th) {
                sb = new StringBuilder();
                sb.append("checkWhetherToStart throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.bb.f.i("JComponentHelper", sb.toString());
                return null;
            }
        }
        return null;
    }

    private static void b(Context context, boolean z5, Class cls) {
        String str;
        if (context == null) {
            str = "context is null, give up setComponentEnabled";
        } else {
            try {
                PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
                if (packageManager != null) {
                    int i6 = z5 ? 1 : 2;
                    ComponentName componentName = new ComponentName(context, (Class<?>) cls);
                    if (packageManager.getComponentEnabledSetting(componentName) == i6) {
                        cn.jiguang.bb.f.c("JComponentHelper", componentName.getClassName() + " enabled is :" + z5 + ", no need repeat set.");
                        return;
                    }
                    cn.jiguang.bb.f.c("JComponentHelper", componentName + " setDownloadProviderEnabledSetting newState: " + i6);
                    packageManager.setComponentEnabledSetting(componentName, i6, 1);
                    return;
                }
                str = "PackageManager is null, give up setComponentEnabled";
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JComponentHelper", "setContentProviderEnabled throwable:" + th.getMessage());
                return;
            }
        }
        cn.jiguang.bb.f.j("JComponentHelper", str);
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f1743a = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        f1744b = arrayList2;
        arrayList.add(l.b(new byte[]{122, 103, 123, Utf8.REPLACEMENT_BYTE, 67, 79, 113, 125, 56, Byte.MAX_VALUE, 85, 87, 106, 107, 122, 120, 85, 78, 109}));
        arrayList2.add(l.b(new byte[]{107, 121, 124, 30, 84, 124, 102, 117, 116, 94, 84, 55, 105, 120, 117, 66, 79, 112, 108, 56, 96, 65, 68, 118, Byte.MAX_VALUE, 120, 125, 95, 65, 125, 109, 100}));
        f1747e = "Xiaomi".toLowerCase();
    }

    public static void a(Context context, boolean z5) {
        try {
            if (f1745c == z5) {
                return;
            }
            f1745c = z5;
            a(context, z5, "cn.jpush.android.intent.DaemonService", Class.forName("cn.jpush.android.service.DaemonService", false, context.getClassLoader()));
            b(context, z5, Class.forName("cn.jpush.android.service.DownloadProvider", false, context.getClassLoader()));
            a(context, z5, Class.forName("cn.jpush.android.service.DActivity", false, context.getClassLoader()));
            a(context, z5, Class.forName("cn.jpush.android.service.BActivity", false, context.getClassLoader()));
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("JComponentHelper", "setComponentEnable failed, " + th.getMessage());
        }
    }

    private static boolean b(Context context) {
        try {
            String str = c.a.f3098b;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(f1747e, str.toLowerCase());
        } catch (Throwable th) {
            cn.jiguang.bb.f.j("JComponentHelper", "get MANUFACTURER failed - error:" + th);
            return false;
        }
    }

    private static void a(Context context, boolean z5, Class cls) {
        String str;
        if (context == null) {
            str = "context is null, give up setComponentEnabled";
        } else {
            if (cls == null) {
                return;
            }
            try {
                PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
                if (packageManager != null) {
                    int i6 = z5 ? 1 : 2;
                    ComponentName componentName = new ComponentName(context, (Class<?>) cls);
                    if (packageManager.getComponentEnabledSetting(componentName) == i6) {
                        cn.jiguang.bb.f.c("JComponentHelper", componentName.getClassName() + " enabled is :" + z5 + ", no need repeat set.");
                        return;
                    }
                    cn.jiguang.bb.f.c("JComponentHelper", componentName + " setActivityEnabledSetting newState: " + i6);
                    packageManager.setComponentEnabledSetting(componentName, i6, 1);
                    return;
                }
                str = "PackageManager is null, give up setComponentEnabled";
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JComponentHelper", "setActivityEnabled throwable:" + th.getMessage());
                return;
            }
        }
        cn.jiguang.bb.f.j("JComponentHelper", str);
    }

    private static void a(Context context, boolean z5, String str, Class cls) {
        String str2;
        String str3;
        if (context == null) {
            str3 = "context is null, give up setComponentEnabled";
        } else {
            try {
                PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
                if (packageManager != null) {
                    String packageName = context.getPackageName();
                    int i6 = z5 ? 1 : 2;
                    Intent intent = new Intent();
                    intent.setPackage(packageName);
                    intent.setAction(str);
                    ResolveInfo resolveService = packageManager.resolveService(intent, 512);
                    if (resolveService != null) {
                        ServiceInfo serviceInfo = resolveService.serviceInfo;
                        if (serviceInfo == null) {
                            return;
                        }
                        String str4 = serviceInfo.name;
                        if (TextUtils.isEmpty(str4)) {
                            return;
                        }
                        try {
                            if (cls.isAssignableFrom(Class.forName(str4))) {
                                ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                                cn.jiguang.bb.f.c("JComponentHelper", componentName + " setComponentEnabledSetting newState: " + i6);
                                if (packageManager.getComponentEnabledSetting(componentName) != i6) {
                                    packageManager.setComponentEnabledSetting(componentName, i6, 1);
                                    return;
                                }
                                cn.jiguang.bb.f.c("JComponentHelper", "DaemonService  enabled is :" + z5 + ", no need repeat set.");
                                return;
                            }
                            cn.jiguang.bb.f.j("JComponentHelper", "give up setting, as " + str4 + " is not extend from: " + cls.getName());
                            return;
                        } catch (ClassNotFoundException unused) {
                            str2 = "cant't find service class:" + str4;
                        }
                    } else {
                        str2 = "cant't find DaemonService";
                    }
                    cn.jiguang.bb.f.i("JComponentHelper", str2);
                    return;
                }
                str3 = "PackageManager is null, give up setComponentEnabled";
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JComponentHelper", "setServiceEnabled throwable:" + th.getMessage());
                return;
            }
        }
        cn.jiguang.bb.f.j("JComponentHelper", str3);
    }

    public static boolean a(Context context) {
        Boolean bool = f1746d;
        if (bool != null) {
            return bool.booleanValue();
        }
        f1746d = b(context) ? Boolean.TRUE : Boolean.FALSE;
        return f1746d.booleanValue();
    }

    public static boolean a(Context context, String str, Intent intent, boolean z5) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            intent.setPackage(str);
            if (!z5) {
                intent.setAction("cn.jpush.android.intent.DActivity");
                intent.addCategory(str);
            }
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            if (resolveActivity == null) {
                cn.jiguang.bb.f.i("JComponentHelper", "getDActivity resolveInfo was null from:" + intent);
                return false;
            }
            cn.jiguang.bb.f.c("JComponentHelper", "target actvity name:" + resolveActivity.activityInfo.name + ", theme:" + resolveActivity.activityInfo.theme + ", exported:" + resolveActivity.activityInfo.exported + ", enable: " + resolveActivity.activityInfo.enabled);
            if (resolveActivity.activityInfo.exported && (!a(str) || resolveActivity.activityInfo.enabled)) {
                if (f1744b.contains(str) || resolveActivity.activityInfo.theme == 16973840) {
                    cn.jiguang.bb.f.c("JComponentHelper", "dIntent:" + intent);
                    return true;
                }
                cn.jiguang.bb.f.i("JComponentHelper", resolveActivity.activityInfo.name + "activity theme must config as @android:style/Theme.Translucent.NoTitleBar");
                return false;
            }
            cn.jiguang.bb.f.i("JComponentHelper", "activity muse be exported and enabled");
            return false;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JComponentHelper", "get deeplink activity error#" + th);
            return false;
        }
    }

    private static boolean a(String str) {
        boolean contains = f1743a.contains(str);
        StringBuilder sb = new StringBuilder();
        sb.append("package[");
        sb.append(str);
        sb.append("] need check activity enable state, ");
        sb.append(!contains);
        cn.jiguang.bb.f.f("JComponentHelper", sb.toString());
        return !contains;
    }
}
