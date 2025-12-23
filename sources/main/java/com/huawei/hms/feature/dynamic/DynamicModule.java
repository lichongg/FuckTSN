package com.huawei.hms.feature.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.IDynamicInstall;
import com.huawei.hms.feature.dynamic.IDynamicLoader;
import com.stub.StubApp;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class DynamicModule {
    public static final int MODULE_INTER_ERROR = 3;
    public static final int MODULE_NEED_UPDATE = 2;
    public static final int MODULE_NORMAL = 0;
    public static final int MODULE_NOT_EXIST = 1;
    public static final int MODULE_NOT_PRESET_HSF = 5;
    public static final int MODULE_NOT_READY = 4;

    /* renamed from: c, reason: collision with root package name */
    public static final int f33151c = 256;

    /* renamed from: d, reason: collision with root package name */
    public static final int f33152d = -100;

    /* renamed from: i, reason: collision with root package name */
    public static int f33157i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static final int f33158j = 1;

    /* renamed from: k, reason: collision with root package name */
    public static final int f33159k = 2;

    /* renamed from: l, reason: collision with root package name */
    public static int f33160l;

    /* renamed from: a, reason: collision with root package name */
    public Context f33163a;
    public static final VersionPolicy PREFER_REMOTE = new com.huawei.hms.feature.dynamic.e.e();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new com.huawei.hms.feature.dynamic.e.c();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new com.huawei.hms.feature.dynamic.e.d();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new com.huawei.hms.feature.dynamic.e.e();

    /* renamed from: b, reason: collision with root package name */
    public static final String f33150b = DynamicModule.class.getSimpleName();

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<HashMap<String, Boolean>> f33153e = new ThreadLocal<>();

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadLocal<HashMap<String, String>> f33154f = new ThreadLocal<>();

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<HashMap<String, IDynamicLoader>> f33155g = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    public static final ThreadLocal<HashMap<String, ClassLoader>> f33156h = new ThreadLocal<>();

    /* renamed from: m, reason: collision with root package name */
    public static HashMap<String, Boolean> f33161m = new HashMap<>();

    /* renamed from: n, reason: collision with root package name */
    public static HashMap<String, Boolean> f33162n = new HashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DynamicLoaderClassLoader {

        /* renamed from: a, reason: collision with root package name */
        public static HashMap<String, ClassLoader> f33164a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return f33164a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            f33164a.put(str, classLoader);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class LoadingException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public Bundle f33165a;

        public LoadingException(String str) {
            super(str);
        }

        public LoadingException(String str, Bundle bundle) {
            super(str);
            this.f33165a = bundle;
        }

        public Bundle getBundle() {
            return this.f33165a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface VersionPolicy {
        Bundle getModuleInfo(Context context, String str) throws LoadingException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends HashMap<String, ClassLoader> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33166a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f33167b;

        public a(String str, ClassLoader classLoader) {
            this.f33166a = str;
            this.f33167b = classLoader;
            put(str, classLoader);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends HashMap<String, ClassLoader> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33168a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f33169b;

        public b(String str, ClassLoader classLoader) {
            this.f33168a = str;
            this.f33169b = classLoader;
            put(str, classLoader);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c implements Callable<Bundle> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f33170a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f33171b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Bundle call() {
            try {
                return DynamicModule.queryHMSModuleBundle(this.f33170a, com.huawei.hms.feature.dynamic.b.f33206e, this.f33171b);
            } catch (Exception e6) {
                Logger.w(DynamicModule.f33150b, "Query provider error.", e6);
                return new Bundle();
            }
        }

        public c(Context context, Bundle bundle) {
            this.f33170a = context;
            this.f33171b = bundle;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d extends HashMap<String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33172a;

        public d(String str) {
            this.f33172a = str;
            put(str, Boolean.TRUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e extends HashMap<String, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33173a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33174b;

        public e(String str, String str2) {
            this.f33173a = str;
            this.f33174b = str2;
            put(str, str2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f extends HashMap<String, IDynamicLoader> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33175a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBinder f33176b;

        public f(String str, IBinder iBinder) {
            this.f33175a = str;
            this.f33176b = iBinder;
            put(str, IDynamicLoader.Stub.asInterface(iBinder));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class g extends Exception {
        public g(String str) {
            super(str);
        }

        public /* synthetic */ g(String str, a aVar) {
            this(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x008e A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r9, java.lang.String r10, android.os.Bundle r11) throws com.huawei.hms.feature.dynamic.DynamicModule.LoadingException {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.a(android.content.Context, java.lang.String, android.os.Bundle):int");
    }

    public static Bundle b(Context context, String str) throws LoadingException {
        boolean z5 = false;
        try {
            try {
                Class<?> a6 = a(context);
                Method declaredMethod = a6.getDeclaredMethod("getsClassLoader", String.class);
                Method declaredMethod2 = a6.getDeclaredMethod("setsClassLoader", String.class, ClassLoader.class);
                ClassLoader classLoader = (ClassLoader) declaredMethod.invoke(null, str);
                if (classLoader == null) {
                    try {
                        String str2 = f33150b;
                        Logger.i(str2, "No available cached loader, query remote.");
                        Bundle c6 = c(context, str);
                        synchronized (DynamicModule.class) {
                            try {
                                HashMap<String, String> hashMap = f33154f.get();
                                Objects.requireNonNull(hashMap);
                                String str3 = hashMap.get(str);
                                if (TextUtils.isEmpty(str3)) {
                                    return c6;
                                }
                                if (!com.huawei.hms.feature.dynamic.f.c.a(context, str3)) {
                                    Logger.w(str2, "The loaderPath is invalid.");
                                    throw new LoadingException("getHMSModuleInfo: checkPathValidity failed.");
                                }
                                com.huawei.hms.feature.dynamic.e.a aVar = new com.huawei.hms.feature.dynamic.e.a(str3, ClassLoader.getSystemClassLoader());
                                a(str, aVar);
                                declaredMethod2.invoke(null, str, aVar);
                                f33153e.set(new d(str));
                                return c6;
                            } finally {
                            }
                        }
                    } catch (g unused) {
                    }
                } else if (classLoader != ClassLoader.getSystemClassLoader()) {
                    Logger.i(f33150b, "Cached loader is available, ready to use it.");
                    try {
                        a(str, classLoader);
                    } catch (LoadingException e6) {
                        Logger.w(f33150b, "Get loader interface failed.", e6);
                    }
                    z5 = true;
                }
            } catch (Exception e7) {
                Logger.w(f33150b, "failed to load.", e7);
            }
            HashMap<String, Boolean> hashMap2 = new HashMap<>();
            hashMap2.put(str, Boolean.valueOf(z5));
            f33153e.set(hashMap2);
            return new Bundle();
        } catch (LoadingException e8) {
            throw e8;
        }
    }

    public static Bundle c(Context context, String str) throws LoadingException, g {
        try {
            Bundle queryHMSModuleBundle = queryHMSModuleBundle(context, str);
            String string = queryHMSModuleBundle.getString(com.huawei.hms.feature.dynamic.b.f33219r);
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                f33154f.set(new e(str, string));
                Logger.i(f33150b, "Query remote version by module name:" + str + " success.");
                return queryHMSModuleBundle;
            }
            Logger.w(f33150b, "The loader_path:" + string + " in query bundle is not available,change the module version to:-100");
            queryHMSModuleBundle.putInt(com.huawei.hms.feature.dynamic.b.f33212k, -100);
            return queryHMSModuleBundle;
        } catch (LoadingException e6) {
            throw e6;
        } catch (Exception unused) {
            throw new g("failed to Query remote version.", null);
        }
    }

    public static int getLocalVersion(Context context, String str) {
        if (context == null || str.length() == 0 || str.length() > 256) {
            Logger.e(f33150b, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str2 = AssetLoadManager.f33129d + str + ".ModuleDescriptor";
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            return context.getClassLoader().loadClass(str2).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.w(f33150b, "Cannot find the class of module descriptor for " + str);
            return 0;
        } catch (Exception e6) {
            Logger.w(f33150b, "Get local module info failed.", e6);
            return 0;
        }
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return loadV3(context, versionPolicy, str, new Bundle());
    }

    public static Bundle queryHMSModuleBundle(Context context, String str) throws LoadingException, g {
        return queryHMSModuleBundle(context, str, null);
    }

    public static int a(VersionPolicy versionPolicy) {
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.e) {
            return 1;
        }
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.d) {
            return 2;
        }
        return versionPolicy instanceof com.huawei.hms.feature.dynamic.e.c ? 3 : 0;
    }

    public static DynamicModule b(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        String str2 = f33150b;
        Logger.i(str2, "dynamic-api version: 10024300");
        a(context, versionPolicy, str, bundle);
        try {
            int a6 = a(context, str, bundle);
            if (a6 >= 10015300) {
                Logger.i(str2, "Load start in new-version-policy.");
                return a(context, str, versionPolicy, bundle);
            }
            if (a6 <= 0) {
                throw new LoadingException("Cannot find a valid dynamicLoader in HMS and local.");
            }
            Logger.i(str2, "Load start in old-version-policy.");
            return a(context, str, versionPolicy);
        } catch (LoadingException e6) {
            throw e6;
        } catch (Exception e7) {
            Logger.e(f33150b, "Other exception:" + e7);
            throw new LoadingException("Load failed.");
        }
    }

    public static DynamicModule c(Context context, String str, Bundle bundle) throws LoadingException {
        Boolean bool;
        IDynamicLoader iDynamicLoader;
        try {
            synchronized (DynamicModule.class) {
                HashMap<String, Boolean> hashMap = f33153e.get();
                Objects.requireNonNull(hashMap);
                bool = hashMap.get(str);
                HashMap<String, IDynamicLoader> hashMap2 = f33155g.get();
                Objects.requireNonNull(hashMap2);
                iDynamicLoader = hashMap2.get(str);
            }
            if (bool == null || iDynamicLoader == null) {
                throw new LoadingException("The loader for " + str + " was not prepared.");
            }
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            Context a6 = a(context, str, bundle, iDynamicLoader);
            if (a6 != null) {
                return new DynamicModule(a6);
            }
            throw new LoadingException("Failed to get remote module context: null");
        } catch (LoadingException e6) {
            throw e6;
        } catch (Exception unused) {
            throw new LoadingException("Load Module Error.");
        }
    }

    public static void enable3rdPhone(String str, boolean z5) {
        f33161m.put(str, Boolean.valueOf(z5));
    }

    public static void enableLowEMUI(String str, boolean z5) {
        f33162n.put(str, Boolean.valueOf(z5));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle getRemoteModuleInfo(android.content.Context r4, java.lang.String r5) throws com.huawei.hms.feature.dynamic.DynamicModule.LoadingException {
        /*
            java.lang.Class<com.huawei.hms.feature.dynamic.DynamicModule> r0 = com.huawei.hms.feature.dynamic.DynamicModule.class
            monitor-enter(r0)     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.Boolean>> r1 = com.huawei.hms.feature.dynamic.DynamicModule.f33153e     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r2 = r1.get()     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2c
            java.lang.Object r2 = r1.get()     // Catch: java.lang.Throwable -> L2a
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r2 = r2.get(r5)     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2c
            java.lang.Object r2 = r1.get()     // Catch: java.lang.Throwable -> L2a
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r2 = r2.get(r5)     // Catch: java.lang.Throwable -> L2a
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L2a
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L2a
            if (r2 != 0) goto L3a
            goto L2c
        L2a:
            r4 = move-exception
            goto L5d
        L2c:
            android.os.Bundle r2 = b(r4, r5)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r3 = "module_version"
            int r3 = r2.getInt(r3)     // Catch: java.lang.Throwable -> L2a
            if (r3 <= 0) goto L3a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            return r2
        L3a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r0 = r1.get()     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
            java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
            if (r0 == 0) goto L7a
            android.os.Bundle r4 = c(r4, r5)     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.g -> L54 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
            return r4
        L52:
            r4 = move-exception
            goto L5f
        L54:
            r4 = move-exception
            java.lang.String r0 = com.huawei.hms.feature.dynamic.DynamicModule.f33150b     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
            java.lang.String r1 = "Query remote module info in HMS failed."
            com.huawei.hms.common.util.Logger.w(r0, r1, r4)     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
            goto L7a
        L5d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r4     // Catch: java.lang.Exception -> L52 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L80
        L5f:
            java.lang.String r0 = com.huawei.hms.feature.dynamic.DynamicModule.f33150b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Get remote module info for "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " failed."
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.huawei.hms.common.util.Logger.w(r0, r5, r4)
        L7a:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            return r4
        L80:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.getRemoteModuleInfo(android.content.Context, java.lang.String):android.os.Bundle");
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle c6 = c(context, str);
            if (c6 != null && !c6.isEmpty()) {
                return c6.getInt(com.huawei.hms.feature.dynamic.b.f33212k);
            }
            Logger.w(f33150b, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.");
        } catch (g e6) {
            Logger.w(f33150b, "Query remote module:" + str + " exception:" + e6);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void install(android.content.Context r3, int r4) {
        /*
            java.lang.String r0 = com.huawei.hms.feature.dynamic.DynamicModule.f33150b
            java.lang.String r1 = "dynamic-api version: 10024300"
            com.huawei.hms.common.util.Logger.i(r0, r1)
            if (r3 != 0) goto Lf
            java.lang.String r3 = "The input context is null."
            com.huawei.hms.common.util.Logger.e(r0, r3)
            return
        Lf:
            com.huawei.hms.feature.dynamic.DynamicModule.f33160l = r4     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            r4.<init>()     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            java.lang.String r1 = "Query HMS provider timeOut is set to:"
            r4.append(r1)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            int r1 = com.huawei.hms.feature.dynamic.DynamicModule.f33160l     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            r4.append(r1)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            java.lang.String r1 = " ms."
            r4.append(r1)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            java.lang.String r4 = r4.toString()     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            com.huawei.hms.common.util.Logger.i(r0, r4)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            com.huawei.hms.feature.dynamic.IDynamicInstall r4 = b(r3)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            if (r4 == 0) goto L5c
            com.huawei.hms.feature.dynamic.IObjectWrapper r1 = com.huawei.hms.feature.dynamic.ObjectWrapper.wrap(r3)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            android.os.Bundle r2 = new android.os.Bundle     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            r2.<init>()     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            android.os.Bundle r4 = r4.install(r1, r2)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            if (r4 == 0) goto L54
            com.huawei.hms.feature.dynamic.d r1 = com.huawei.hms.feature.dynamic.d.a()     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            r1.a(r4)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            java.lang.String r4 = "Install module success."
            com.huawei.hms.common.util.Logger.i(r0, r4)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            return
        L4e:
            r4 = move-exception
            goto L64
        L50:
            r4 = move-exception
            goto L64
        L52:
            r4 = move-exception
            goto L64
        L54:
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r4 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            java.lang.String r0 = "Get install info failed: moduleBundle is null."
            r4.<init>(r0)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            throw r4     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
        L5c:
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r4 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            java.lang.String r0 = "Get dynamicInstaller failed."
            r4.<init>(r0)     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
            throw r4     // Catch: java.lang.NullPointerException -> L4e android.os.RemoteException -> L50 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> L52
        L64:
            int r0 = com.huawei.hms.feature.dynamic.DynamicModule.f33157i
            r1 = 2
            if (r0 == r1) goto Lad
            java.lang.String r0 = "huawei_module_dynamicloader"
            int r0 = getLocalVersion(r3, r0)
            if (r0 <= 0) goto Lad
            java.lang.String r4 = com.huawei.hms.feature.dynamic.DynamicModule.f33150b
            java.lang.String r0 = "Ready to use local loader-fallback to retry:"
            com.huawei.hms.common.util.Logger.i(r4, r0)
            com.huawei.hms.feature.dynamic.IDynamicInstall r0 = c(r3)     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            com.huawei.hms.feature.dynamic.IObjectWrapper r3 = com.huawei.hms.feature.dynamic.ObjectWrapper.wrap(r3)     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            android.os.Bundle r1 = new android.os.Bundle     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            r1.<init>()     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            android.os.Bundle r3 = r0.install(r3, r1)     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            if (r3 == 0) goto L98
            com.huawei.hms.feature.dynamic.d r0 = com.huawei.hms.feature.dynamic.d.a()     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            r0.a(r3)     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            java.lang.String r3 = "Retry install module with local loader-fallback success."
            com.huawei.hms.common.util.Logger.i(r4, r3)     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            goto Lb4
        L98:
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r3 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            java.lang.String r4 = "Retry: get install info failed: moduleBundle is null."
            r3.<init>(r4)     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
            throw r3     // Catch: java.lang.NullPointerException -> La0 android.os.RemoteException -> La2 com.huawei.hms.feature.dynamic.DynamicModule.LoadingException -> La4
        La0:
            r3 = move-exception
            goto La5
        La2:
            r3 = move-exception
            goto La5
        La4:
            r3 = move-exception
        La5:
            java.lang.String r4 = com.huawei.hms.feature.dynamic.DynamicModule.f33150b
            java.lang.String r0 = "Retry failed with local loader-fallback."
            com.huawei.hms.common.util.Logger.w(r4, r0, r3)
            goto Lb4
        Lad:
            java.lang.String r3 = com.huawei.hms.feature.dynamic.DynamicModule.f33150b
            java.lang.String r0 = "Install module failed."
            com.huawei.hms.common.util.Logger.w(r3, r0, r4)
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.install(android.content.Context, int):void");
    }

    public static DynamicModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return b(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV2(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        Bundle bundle = new Bundle();
        bundle.putString(com.huawei.hms.feature.dynamic.b.f33220s, "v2");
        return b(context, versionPolicy, str, bundle);
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        bundle.putString(com.huawei.hms.feature.dynamic.b.f33220s, com.huawei.hms.feature.dynamic.b.f33222u);
        return b(context, versionPolicy, str, bundle);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str, Bundle bundle) throws LoadingException, g {
        a aVar = null;
        try {
            if (!com.huawei.hms.feature.dynamic.f.c.a(context)) {
                Logger.w(f33150b, "No valid HMS Core in this device.");
                throw new g("HMS Core is not installed.", aVar);
            }
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                throw new g("Query remote version failed: null contentResolver.", aVar);
            }
            Bundle call = contentResolver.call(Uri.parse(com.huawei.hms.feature.dynamic.b.f33202a), str, (String) null, bundle);
            if (call == null) {
                Logger.w(f33150b, "Failed to get bundle info:null.");
                throw new g("Query remote version failed: null bundle info.", aVar);
            }
            int i6 = call.getInt(com.huawei.hms.feature.dynamic.b.f33209h);
            String string = call.getString(com.huawei.hms.feature.dynamic.b.f33219r);
            String str2 = f33150b;
            Logger.i(str2, "bundle info: errorCode:" + i6 + ", moduleVersion:" + call.getInt(com.huawei.hms.feature.dynamic.b.f33212k) + ", modulePath:" + call.getString(com.huawei.hms.feature.dynamic.b.f33215n) + ", loader_version:" + call.getInt(com.huawei.hms.feature.dynamic.b.f33218q) + ", loaderPath:" + string + ", armeabiType:" + call.getInt(com.huawei.hms.feature.dynamic.b.f33223v));
            if (i6 == 0) {
                return call;
            }
            Logger.w(str2, "Failed to get " + str + " bundle info, errcode:" + i6);
            throw new LoadingException("Query " + str + " unavailable, errorCode:" + i6, call);
        } catch (LoadingException e6) {
            throw e6;
        } catch (Exception unused) {
            throw new g("failed to get :" + str + " info from HMS Core.", aVar);
        }
    }

    public final Context getModuleContext() {
        return this.f33163a;
    }

    public DynamicModule(Context context) {
        this.f33163a = context;
    }

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper load = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(com.huawei.hms.feature.dynamic.b.f33212k), ObjectWrapper.wrap(bundle));
            Object unwrap = ObjectWrapper.unwrap(load);
            if (unwrap == null) {
                Logger.w(f33150b, "Get remote context is null, module:" + str);
                return null;
            }
            if (unwrap instanceof Context) {
                Logger.i(f33150b, "Get context for module:" + str + " success.");
                return (Context) unwrap;
            }
            if (unwrap instanceof Bundle) {
                Logger.i(f33150b, "Get module info bundle for " + str);
                return a(context, str, bundle, iDynamicLoader, (Bundle) unwrap);
            }
            if (!unwrap.getClass().getName().equals(LoadingException.class.getName())) {
                Logger.w(f33150b, "Get remote context is null, module:" + str);
                return null;
            }
            Bundle bundle2 = (Bundle) ObjectWrapper.unwrap(load).getClass().getDeclaredMethod("getBundle", null).invoke(ObjectWrapper.unwrap(load), null);
            Logger.w(f33150b, "Successfully get the bundle in exception.");
            throw new LoadingException("Failed to load, please check the bundle in exception.", bundle2);
        } catch (LoadingException e6) {
            throw e6;
        } catch (Exception e7) {
            Logger.w(f33150b, "Failed to get module context for:" + str, e7);
            return null;
        }
    }

    public static DynamicModule b(Context context, String str, Bundle bundle) throws LoadingException {
        ClassLoader classLoader;
        synchronized (DynamicModule.class) {
            try {
                ThreadLocal<HashMap<String, ClassLoader>> threadLocal = f33156h;
                if (threadLocal.get() != null && threadLocal.get().get(str) != null) {
                    Logger.i(f33150b, "Cached loader for module is available, ready to use it.");
                    classLoader = threadLocal.get().get(str);
                }
                Logger.i(f33150b, "No available cached loader for module:" + str);
                classLoader = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        IDynamicLoader a6 = a(context, str, bundle.getString(com.huawei.hms.feature.dynamic.b.f33219r), classLoader);
        if (a6 == null) {
            throw new LoadingException("Failed to get iDynamicLoader: null.");
        }
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        Context a7 = a(context, str, bundle, a6);
        if (a7 != null) {
            return new DynamicModule(a7);
        }
        throw new LoadingException("New version policy: Failed to get module context: null.");
    }

    public static IDynamicInstall c(Context context) throws LoadingException {
        try {
            return (IDynamicInstall) context.getClassLoader().loadClass(com.huawei.hms.feature.dynamic.b.f33208g).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e6) {
            throw new LoadingException("getLocalLoaderFallback: failed to instantiate dynamic loader: " + e6.getMessage());
        }
    }

    public static Set<String> getInstalledModuleInfo() {
        return com.huawei.hms.feature.dynamic.d.a().f33235a;
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString(com.huawei.hms.feature.dynamic.b.f33211j, str);
        bundle.putInt(com.huawei.hms.feature.dynamic.b.f33213l, localVersion);
        return bundle;
    }

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader, Bundle bundle2) throws LoadingException {
        Object obj;
        bundle.putInt(com.huawei.hms.feature.dynamic.b.f33224w, 4);
        if (AssetLoadManager.getAssetModuleInfo(context, str).getInt(com.huawei.hms.feature.dynamic.b.f33214m, 0) <= 0) {
            Logger.i(f33150b, "No fallback module in assets.");
            throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
        }
        try {
            obj = ObjectWrapper.unwrap(iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(com.huawei.hms.feature.dynamic.b.f33212k), ObjectWrapper.wrap(bundle)));
        } catch (RemoteException e6) {
            Logger.w(f33150b, "tryWithAssetsModule RemoteException.", e6);
            obj = null;
        }
        if (!(obj instanceof Context)) {
            Logger.w(f33150b, "tryWithAssetsModule get dynamicContext failed: null or wrong type.");
            throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
        }
        Logger.i(f33150b, "get dynamic module context for:" + str + " from assets fallback success.");
        return (Context) obj;
    }

    public static IDynamicInstall b(Context context) throws LoadingException {
        int i6;
        String str = null;
        int i7 = 0;
        try {
            Bundle a6 = a(context, (Bundle) null);
            str = a6.getString(com.huawei.hms.feature.dynamic.b.f33219r);
            i6 = a6.getInt(com.huawei.hms.feature.dynamic.b.f33218q);
        } catch (Exception e6) {
            Logger.w(f33150b, "Cannot get remote HMS dynamicLoader.", e6);
            i6 = 0;
        }
        try {
            i7 = getLocalVersion(context, com.huawei.hms.feature.dynamic.b.f33206e);
        } catch (Exception e7) {
            Logger.w(f33150b, "Cannot find local dynamicLoader fallback.", e7);
        }
        String str2 = f33150b;
        Logger.i(str2, "DynamicLoader remoteHMSVersion:" + i6 + ", hmsLoaderPath:" + str + ", localLoaderVersion:" + i7);
        int max = Math.max(i6, i7);
        if (max > 10009300) {
            if (i6 <= i7) {
                Logger.i(str2, "Choose local dynamicLoader fallback: ");
                f33157i = 2;
                return c(context);
            }
            Logger.i(str2, "Choose hms dynamicLoader: " + str);
            f33157i = 1;
            return a(context, str);
        }
        Logger.w(str2, "The current version:" + max + " is too low.");
        throw new LoadingException("The loader version:" + max + " is too low to support HFF.");
    }

    public static Bundle a(Context context, Bundle bundle) throws g {
        a aVar = null;
        try {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            FutureTask futureTask = new FutureTask(new c(context, bundle));
            newSingleThreadExecutor.execute(futureTask);
            Bundle bundle2 = (Bundle) futureTask.get(f33160l, TimeUnit.MILLISECONDS);
            String string = bundle2.getString(com.huawei.hms.feature.dynamic.b.f33219r);
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                Logger.i(f33150b, "Query HMS module:huawei_module_dynamicloader info success.");
                return bundle2;
            }
            Logger.w(f33150b, "The loader_path:" + string + " is not available.");
            throw new g("The loader_path in queryBundle is empty or not exist.", aVar);
        } catch (TimeoutException unused) {
            Logger.w(f33150b, "Query hms provider timeout: over " + f33160l + " ms, choose the local loader fallback.");
            return new Bundle();
        } catch (Exception e6) {
            Logger.w(f33150b, "FutureTask: query provider exception.", e6);
            throw new g("failed to get :huawei_module_dynamicloader info.", aVar);
        }
    }

    public static DynamicModule a(Context context, String str, VersionPolicy versionPolicy) throws LoadingException {
        Bundle moduleInfo = versionPolicy.getModuleInfo(context, str);
        if (moduleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33212k) <= 0) {
            if (moduleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33213l) <= 0) {
                throw new LoadingException("Query remote version and local version failed.");
            }
            Logger.i(f33150b, "Remote version is invalid, use local context.");
            return new DynamicModule(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        try {
            return c(context, str, moduleInfo);
        } catch (LoadingException e6) {
            Logger.w(f33150b, "Failed to load remote module.", e6);
            if (getLocalVersion(context, str) <= 0) {
                throw e6;
            }
            Logger.d(f33150b, "Local module version is valid, use local fallback.");
            return new DynamicModule(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    }

    public static DynamicModule a(Context context, String str, VersionPolicy versionPolicy, Bundle bundle) throws LoadingException {
        int a6 = a(versionPolicy);
        String string = bundle.getString(com.huawei.hms.feature.dynamic.b.f33219r);
        Logger.i(f33150b, "The loader path for module:" + str + " is:" + string + ", and versionType is:" + a6);
        if (TextUtils.isEmpty(string)) {
            throw new LoadingException("Cannot find a valid dynamic loader in HMS or local.");
        }
        Boolean bool = f33162n.get(str);
        Boolean bool2 = f33161m.get(str);
        bundle.putString(com.huawei.hms.feature.dynamic.b.f33211j, str);
        bundle.putInt(com.huawei.hms.feature.dynamic.b.f33224w, a6);
        bundle.putBoolean(com.huawei.hms.feature.dynamic.b.f33225x, bool != null ? bool.booleanValue() : false);
        bundle.putBoolean(com.huawei.hms.feature.dynamic.b.f33226y, bool2 != null ? bool2.booleanValue() : false);
        try {
            return b(context, str, bundle);
        } catch (LoadingException e6) {
            throw e6;
        } catch (Exception e7) {
            Logger.e(f33150b, "Other exception,", e7);
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            return new DynamicModule(context);
        }
    }

    public static IDynamicInstall a(Context context, String str) throws LoadingException {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (com.huawei.hms.feature.dynamic.f.c.a(context, str)) {
                        return IDynamicInstall.Stub.asInterface((IBinder) new com.huawei.hms.feature.dynamic.e.a(str, ClassLoader.getSystemClassLoader()).loadClass(com.huawei.hms.feature.dynamic.b.f33208g).getConstructor(null).newInstance(null));
                    }
                    Logger.w(f33150b, "check path failed: invalid.");
                    throw new LoadingException("getHMSDynamicInstaller: checkPathValidity failed.");
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e6) {
                throw new LoadingException("getHMSDynamicInstaller: failed to instantiate dynamic loader:" + e6.getMessage());
            }
        }
        throw new LoadingException("Failed to get dynamicLoader path.");
    }

    public static IDynamicLoader a(Context context, String str, String str2, ClassLoader classLoader) {
        if (classLoader == null) {
            try {
                classLoader = new com.huawei.hms.feature.dynamic.e.a(str2, ClassLoader.getSystemClassLoader());
                f33156h.set(new b(str, classLoader));
            } catch (Exception e6) {
                Logger.w(f33150b, "Get iDynamicLoader failed.", e6);
                return null;
            }
        }
        return IDynamicLoader.Stub.asInterface((IBinder) classLoader.loadClass(com.huawei.hms.feature.dynamic.b.f33207f).getConstructor(null).newInstance(null));
    }

    public static Class<?> a(Context context) throws LoadingException {
        Class<?> cls;
        try {
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            cls = context.getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
        } catch (ClassNotFoundException unused) {
            Logger.w(f33150b, "ClassLoader class not found when use client context.");
            cls = null;
        }
        if (cls == null) {
            try {
                ClassLoader classLoader = DynamicModule.class.getClassLoader();
                Objects.requireNonNull(classLoader);
                cls = classLoader.loadClass(DynamicLoaderClassLoader.class.getName());
                if (cls == null) {
                    throw new LoadingException("ClassLoader class is null.");
                }
            } catch (ClassNotFoundException unused2) {
                throw new LoadingException("ClassLoader class not found when use DynamicModule's classLoader.");
            }
        }
        return cls;
    }

    public static void a(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        if (context == null || versionPolicy == null || str == null || str.length() == 0 || str.length() > 256 || bundle == null) {
            throw new LoadingException("Null param, please check it.");
        }
    }

    public static void a(String str, ClassLoader classLoader) throws LoadingException {
        try {
            f33155g.set(new f(str, (IBinder) classLoader.loadClass(com.huawei.hms.feature.dynamic.b.f33207f).getConstructor(null).newInstance(null)));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e6) {
            throw new LoadingException("Failed to get loader interface:" + e6.getMessage());
        }
    }

    public static boolean a(String str, int i6) {
        if (i6 == 1) {
            Boolean bool = f33162n.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        if (i6 != 2) {
            return i6 == 3 || i6 == 4;
        }
        Boolean bool2 = f33161m.get(str);
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }
}
