package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class WorkSourceUtil {
    private static final int zza;
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;

    @GuardedBy("WorkSourceUtil.class")
    private static Boolean zzj;

    @NonNull
    @KeepForSdk
    public static WorkSource fromPackage(@NonNull Context context, @NonNull String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    "Could not get applicationInfo from package: ".concat(str);
                    return null;
                }
                int i6 = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i6, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                "Could not find package: ".concat(str);
            }
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public static WorkSource fromPackageAndModuleExperimentalPi(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            return null;
        }
        int i6 = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                "Could not get applicationInfo from package: ".concat(str);
            } else {
                i6 = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            "Could not find package: ".concat(str);
        }
        if (i6 < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            add(workSource, i6, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, null);
                int i7 = zza;
                if (i6 != i7) {
                    method.invoke(invoke, Integer.valueOf(i6), str);
                }
                method.invoke(invoke, Integer.valueOf(i7), str2);
            } catch (Exception unused2) {
            }
        }
        return workSource;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:0|1|2|3|4|(22:52|53|7|8|9|10|11|12|13|(13:44|45|16|(10:40|41|19|(7:36|37|22|(6:28|29|30|31|25|26)|24|25|26)|21|22|(0)|24|25|26)|18|19|(0)|21|22|(0)|24|25|26)|15|16|(0)|18|19|(0)|21|22|(0)|24|25|26)|6|7|8|9|10|11|12|13|(0)|15|16|(0)|18|19|(0)|21|22|(0)|24|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0048, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x003a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.String r0 = "add"
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.Class<android.os.WorkSource> r2 = android.os.WorkSource.class
            int r3 = android.os.Process.myUid()
            com.google.android.gms.common.util.WorkSourceUtil.zza = r3
            r3 = 0
            r4 = 1
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L18
            r6[r3] = r1     // Catch: java.lang.Exception -> L18
            java.lang.reflect.Method r6 = r2.getMethod(r0, r6)     // Catch: java.lang.Exception -> L18
            goto L1a
        L18:
            r6 = r5
        L1a:
            com.google.android.gms.common.util.WorkSourceUtil.zzb = r6
            boolean r6 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r7 = 2
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            if (r6 == 0) goto L30
            java.lang.Class[] r6 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L30
            r6[r3] = r1     // Catch: java.lang.Exception -> L30
            r6[r4] = r8     // Catch: java.lang.Exception -> L30
            java.lang.reflect.Method r0 = r2.getMethod(r0, r6)     // Catch: java.lang.Exception -> L30
            goto L31
        L30:
            r0 = r5
        L31:
            com.google.android.gms.common.util.WorkSourceUtil.zzc = r0
            java.lang.String r0 = "size"
            java.lang.reflect.Method r0 = r2.getMethod(r0, r5)     // Catch: java.lang.Exception -> L3a
            goto L3b
        L3a:
            r0 = r5
        L3b:
            com.google.android.gms.common.util.WorkSourceUtil.zzd = r0
            java.lang.String r0 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L48
            r6[r3] = r1     // Catch: java.lang.Exception -> L48
            java.lang.reflect.Method r0 = r2.getMethod(r0, r6)     // Catch: java.lang.Exception -> L48
            goto L4a
        L48:
            r0 = r5
        L4a:
            com.google.android.gms.common.util.WorkSourceUtil.zze = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r0 == 0) goto L5e
            java.lang.String r0 = "getName"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L5d
            r6[r3] = r1     // Catch: java.lang.Exception -> L5d
            java.lang.reflect.Method r0 = r2.getMethod(r0, r6)     // Catch: java.lang.Exception -> L5d
            goto L5f
        L5d:
        L5e:
            r0 = r5
        L5f:
            com.google.android.gms.common.util.WorkSourceUtil.zzf = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L6f
            java.lang.String r0 = "createWorkChain"
            java.lang.reflect.Method r0 = r2.getMethod(r0, r5)     // Catch: java.lang.Exception -> L6e
            goto L70
        L6e:
        L6f:
            r0 = r5
        L70:
            com.google.android.gms.common.util.WorkSourceUtil.zzg = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L8c
            java.lang.String r0 = "android.os.WorkSource$WorkChain"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L8b
            java.lang.String r6 = "addNode"
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L8b
            r7[r3] = r1     // Catch: java.lang.Exception -> L8b
            r7[r4] = r8     // Catch: java.lang.Exception -> L8b
            java.lang.reflect.Method r0 = r0.getMethod(r6, r7)     // Catch: java.lang.Exception -> L8b
            goto L8d
        L8b:
        L8c:
            r0 = r5
        L8d:
            com.google.android.gms.common.util.WorkSourceUtil.zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L9f
            java.lang.String r0 = "isEmpty"
            java.lang.reflect.Method r0 = r2.getMethod(r0, r5)     // Catch: java.lang.Exception -> L9f
            r0.setAccessible(r4)     // Catch: java.lang.Exception -> La0
            goto La0
        L9f:
            r0 = r5
        La0:
            com.google.android.gms.common.util.WorkSourceUtil.zzi = r0
            com.google.android.gms.common.util.WorkSourceUtil.zzj = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    @KeepForSdk
    public static void add(@NonNull WorkSource workSource, int i6, @NonNull String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i6), str);
                return;
            } catch (Exception e6) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
                return;
            }
        }
        Method method2 = zzb;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i6));
            } catch (Exception e7) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e7);
            }
        }
    }

    @KeepForSdk
    public static int get(@NonNull WorkSource workSource, int i6) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, Integer.valueOf(i6));
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e6) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
            }
        }
        return 0;
    }

    @NonNull
    @KeepForSdk
    public static String getName(@NonNull WorkSource workSource, int i6) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i6));
        } catch (Exception e6) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
            return null;
        }
    }

    @NonNull
    @KeepForSdk
    public static List<String> getNames(@NonNull WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int size = workSource == null ? 0 : size(workSource);
        if (size != 0) {
            for (int i6 = 0; i6 < size; i6++) {
                String name = getName(workSource, i6);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static synchronized boolean hasWorkSourcePermission(@NonNull Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (context == null) {
                return false;
            }
            boolean z5 = ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0;
            zzj = Boolean.valueOf(z5);
            return z5;
        }
    }

    @KeepForSdk
    public static boolean isEmpty(@NonNull WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, null);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception unused) {
            }
        }
        return size(workSource) == 0;
    }

    @KeepForSdk
    public static int size(@NonNull WorkSource workSource) {
        Method method = zzd;
        if (method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(workSource, null);
            Preconditions.checkNotNull(invoke);
            return ((Integer) invoke).intValue();
        } catch (Exception e6) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
            return 0;
        }
    }

    private WorkSourceUtil() {
    }
}
