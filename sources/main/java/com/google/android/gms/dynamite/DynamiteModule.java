package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class DynamiteModule {

    @KeepForSdk
    public static final int LOCAL = -1;

    @KeepForSdk
    public static final int NONE = 0;

    @KeepForSdk
    public static final int NO_SELECTION = 0;

    @KeepForSdk
    public static final int REMOTE = 1;

    @Nullable
    @GuardedBy("DynamiteModule.class")
    private static Boolean zzb = null;

    @Nullable
    @GuardedBy("DynamiteModule.class")
    private static String zzc = null;

    @GuardedBy("DynamiteModule.class")
    private static boolean zzd = false;

    @GuardedBy("DynamiteModule.class")
    private static int zze = -1;

    @Nullable
    @GuardedBy("DynamiteModule.class")
    private static Boolean zzf;

    @Nullable
    @GuardedBy("DynamiteModule.class")
    private static zzq zzk;

    @Nullable
    @GuardedBy("DynamiteModule.class")
    private static zzr zzl;
    private final Context zzj;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zzf();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzg();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();

    @NonNull
    public static final VersionPolicy zza = new zzl();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @Nullable
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface VersionPolicy {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @KeepForSdk
        public interface IVersions {
            int zza(@NonNull Context context, @NonNull String str);

            int zzb(@NonNull Context context, @NonNull String str, boolean z5) throws LoadingException;
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @KeepForSdk
        public static class SelectionResult {

            @KeepForSdk
            public int localVersion = 0;

            @KeepForSdk
            public int remoteVersion = 0;

            @KeepForSdk
            public int selection = 0;
        }

        @NonNull
        @KeepForSdk
        SelectionResult selectModule(@NonNull Context context, @NonNull String str, @NonNull IVersions iVersions) throws LoadingException;
    }

    @KeepForSdk
    public static int getLocalVersion(@NonNull Context context, @NonNull String str) {
        try {
            Class<?> loadClass = StubApp.getOrigApplicationContext(context.getApplicationContext()).getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String.valueOf(declaredField.get(null));
            return 0;
        } catch (ClassNotFoundException unused) {
            return 0;
        } catch (Exception e6) {
            "Failed to load module descriptor class: ".concat(String.valueOf(e6.getMessage()));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(@NonNull Context context, @NonNull String str) {
        return zza(context, str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a8, code lost:
    
        r9.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int zzb(android.content.Context r9, java.lang.String r10, boolean r11, boolean r12) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    @GuardedBy("DynamiteModule.class")
    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        zzp zzpVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new zzr(iBinder);
            }
            zzl = zzrVar;
        } catch (ClassNotFoundException e6) {
            e = e6;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        } catch (IllegalAccessException e7) {
            e = e7;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        } catch (InstantiationException e8) {
            e = e8;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        } catch (NoSuchMethodException e9) {
            e = e9;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        } catch (InvocationTargetException e10) {
            e = e10;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        }
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static DynamiteModule load(@NonNull Context context, @NonNull VersionPolicy versionPolicy, @NonNull String str) throws LoadingException {
        long j6;
        DynamiteModule zzc2;
        Boolean bool;
        IObjectWrapper zzj;
        DynamiteModule dynamiteModule;
        zzr zzrVar;
        boolean z5;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext == null) {
            throw new LoadingException("null application Context", null);
        }
        ThreadLocal threadLocal = zzg;
        zzn zznVar = (zzn) threadLocal.get();
        zzn zznVar2 = new zzn(null);
        threadLocal.set(zznVar2);
        ThreadLocal threadLocal2 = zzh;
        Long l6 = (Long) threadLocal2.get();
        long longValue = l6.longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context, str, zzi);
            int i6 = selectModule.localVersion;
            int i7 = selectModule.selection;
            if (i7 != 0) {
                if (i7 == -1) {
                    if (selectModule.localVersion != 0) {
                        i7 = -1;
                    }
                }
                j6 = 0;
                if (i7 == 1) {
                    try {
                        if (selectModule.remoteVersion != 0) {
                        }
                        throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + ".", null);
                    } catch (Throwable th) {
                        th = th;
                        if (longValue == j6) {
                            zzh.remove();
                        } else {
                            zzh.set(l6);
                        }
                        Cursor cursor = zznVar2.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        zzg.set(zznVar);
                        throw th;
                    }
                }
                if (i7 == -1) {
                    zzc2 = zzc(origApplicationContext, str);
                } else {
                    if (i7 != 1) {
                        throw new LoadingException("VersionPolicy returned invalid code:" + i7, null);
                    }
                    try {
                        int i8 = selectModule.remoteVersion;
                        try {
                            synchronized (DynamiteModule.class) {
                                if (!zzf(context)) {
                                    throw new LoadingException("Remote loading disabled", null);
                                }
                                bool = zzb;
                            }
                            if (bool == null) {
                                throw new LoadingException("Failed to determine which loading route to use.", null);
                            }
                            if (bool.booleanValue()) {
                                synchronized (DynamiteModule.class) {
                                    zzrVar = zzl;
                                }
                                if (zzrVar == null) {
                                    throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                }
                                zzn zznVar3 = (zzn) threadLocal.get();
                                if (zznVar3 == null || zznVar3.zza == null) {
                                    throw new LoadingException("No result cursor", null);
                                }
                                Context origApplicationContext2 = StubApp.getOrigApplicationContext(context.getApplicationContext());
                                Cursor cursor2 = zznVar3.zza;
                                ObjectWrapper.wrap(null);
                                synchronized (DynamiteModule.class) {
                                    z5 = zze >= 2;
                                }
                                Context context2 = (Context) ObjectWrapper.unwrap(z5 ? zzrVar.zzf(ObjectWrapper.wrap(origApplicationContext2), str, i8, ObjectWrapper.wrap(cursor2)) : zzrVar.zze(ObjectWrapper.wrap(origApplicationContext2), str, i8, ObjectWrapper.wrap(cursor2)));
                                if (context2 == null) {
                                    throw new LoadingException("Failed to get module context", null);
                                }
                                dynamiteModule = new DynamiteModule(context2);
                            } else {
                                zzq zzg2 = zzg(context);
                                if (zzg2 == null) {
                                    throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                }
                                int zze2 = zzg2.zze();
                                if (zze2 >= 3) {
                                    zzn zznVar4 = (zzn) threadLocal.get();
                                    if (zznVar4 == null) {
                                        throw new LoadingException("No cached result cursor holder", null);
                                    }
                                    zzj = zzg2.zzi(ObjectWrapper.wrap(context), str, i8, ObjectWrapper.wrap(zznVar4.zza));
                                } else {
                                    zzj = zze2 == 2 ? zzg2.zzj(ObjectWrapper.wrap(context), str, i8) : zzg2.zzh(ObjectWrapper.wrap(context), str, i8);
                                }
                                Object unwrap = ObjectWrapper.unwrap(zzj);
                                if (unwrap == null) {
                                    throw new LoadingException("Failed to load remote module.", null);
                                }
                                dynamiteModule = new DynamiteModule((Context) unwrap);
                            }
                            zzc2 = dynamiteModule;
                        } catch (RemoteException e6) {
                            throw new LoadingException("Failed to load remote module.", e6, null);
                        } catch (LoadingException e7) {
                            throw e7;
                        } catch (Throwable th2) {
                            CrashUtils.addDynamiteErrorToDropBox(context, th2);
                            throw new LoadingException("Failed to load remote module.", th2, null);
                        }
                    } catch (LoadingException e8) {
                        e8.getMessage();
                        int i9 = selectModule.localVersion;
                        if (i9 == 0 || versionPolicy.selectModule(context, str, new zzo(i9, 0)).selection != -1) {
                            throw new LoadingException("Remote load failed. No local fallback found.", e8, null);
                        }
                        zzc2 = zzc(origApplicationContext, str);
                    }
                }
                if (longValue == 0) {
                    zzh.remove();
                } else {
                    zzh.set(l6);
                }
                Cursor cursor3 = zznVar2.zza;
                if (cursor3 != null) {
                    cursor3.close();
                }
                zzg.set(zznVar);
                return zzc2;
            }
            throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + ".", null);
        } catch (Throwable th3) {
            th = th3;
            j6 = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x013d, code lost:
    
        if (zze(r11) != false) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017f A[Catch: all -> 0x00d9, TryCatch #10 {all -> 0x00d9, blocks: (B:3:0x0002, B:9:0x00ce, B:70:0x00d4, B:11:0x00e3, B:38:0x0149, B:28:0x0154, B:53:0x017f, B:54:0x0182, B:48:0x0177, B:75:0x00df, B:135:0x0184, B:5:0x0003, B:78:0x0009, B:79:0x0029, B:86:0x00cb, B:91:0x004d, B:109:0x00a5, B:117:0x00a8, B:128:0x00c0, B:8:0x00cd, B:131:0x00c6), top: B:2:0x0002, inners: #1, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[Catch: all -> 0x00d9, SYNTHETIC, TRY_LEAVE, TryCatch #10 {all -> 0x00d9, blocks: (B:3:0x0002, B:9:0x00ce, B:70:0x00d4, B:11:0x00e3, B:38:0x0149, B:28:0x0154, B:53:0x017f, B:54:0x0182, B:48:0x0177, B:75:0x00df, B:135:0x0184, B:5:0x0003, B:78:0x0009, B:79:0x0029, B:86:0x00cb, B:91:0x004d, B:109:0x00a5, B:117:0x00a8, B:128:0x00c0, B:8:0x00cd, B:131:0x00c6), top: B:2:0x0002, inners: #1, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.NonNull java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        "Selected local version of ".concat(String.valueOf(str));
        return new DynamiteModule(context);
    }

    private static boolean zze(Cursor cursor) {
        zzn zznVar = (zzn) zzg.get();
        if (zznVar == null || zznVar.zza != null) {
            return false;
        }
        zznVar.zza = cursor;
        return true;
    }

    @GuardedBy("DynamiteModule.class")
    private static boolean zzf(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(zzf)) {
            return true;
        }
        boolean z5 = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z5 = true;
            }
            zzf = Boolean.valueOf(z5);
            if (z5 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                zzd = true;
            }
        }
        return z5;
    }

    @Nullable
    private static zzq zzg(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = zzk;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    zzk = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e6) {
                e6.getMessage();
            }
            return null;
        }
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public Context getModuleContext() {
        return this.zzj;
    }

    @NonNull
    @KeepForSdk
    public IBinder instantiate(@NonNull String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e6) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e6, null);
        }
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }
}
