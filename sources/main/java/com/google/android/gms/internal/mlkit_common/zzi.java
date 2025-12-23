package com.google.android.gms.internal.mlkit_common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.t;
import com.umeng.socialize.common.SocializeConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzi {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzc;
    private static final String[] zzd;

    static {
        String str = Build.HARDWARE;
        zzc = new String[]{SocializeConstants.KEY_PLATFORM, (str.equals("goldfish") || str.equals("ranchu")) ? "androidx.test.services.storage.runfiles" : ""};
        int i6 = Build.VERSION.SDK_INT;
        zzd = new String[]{i6 <= 25 ? "com.google.android.inputmethod.latin.inputcontent" : "", i6 <= 25 ? "com.google.android.inputmethod.latin.dev.inputcontent" : "", "com.google.android.apps.docs.storage.legacy"};
    }

    public static AssetFileDescriptor zza(Context context, Uri uri, String str) throws FileNotFoundException {
        zzh zzhVar = zzh.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri zzc2 = zzc(uri);
        String scheme = zzc2.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(zzc2, t.f36150k);
        }
        if ("content".equals(scheme)) {
            if (!zzj(context, zzc2, 1, zzhVar)) {
                throw new FileNotFoundException("Can't open content uri.");
            }
            AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(zzc2, t.f36150k);
            zzd(openAssetFileDescriptor);
            return openAssetFileDescriptor;
        }
        if (!b.f50156c.equals(scheme)) {
            throw new FileNotFoundException("Unsupported scheme");
        }
        AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(zzc2, t.f36150k);
        zzd(openAssetFileDescriptor2);
        try {
            zzi(context, openAssetFileDescriptor2.getParcelFileDescriptor(), zzc2, zzhVar);
            return openAssetFileDescriptor2;
        } catch (FileNotFoundException e6) {
            zzg(openAssetFileDescriptor2, e6);
            throw e6;
        } catch (IOException e7) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
            fileNotFoundException.initCause(e7);
            zzg(openAssetFileDescriptor2, fileNotFoundException);
            throw fileNotFoundException;
        }
    }

    private static Uri zzc(Uri uri) {
        return Build.VERSION.SDK_INT < 30 ? Uri.parse(uri.toString()) : uri;
    }

    private static Object zzd(Object obj) throws FileNotFoundException {
        if (obj != null) {
            return obj;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }

    private static void zzi(final Context context, ParcelFileDescriptor parcelFileDescriptor, Uri uri, zzh zzhVar) throws IOException {
        boolean z5;
        File dataDir;
        String canonicalPath = new File(uri.getPath()).getCanonicalPath();
        zzf(parcelFileDescriptor, canonicalPath);
        if (!canonicalPath.startsWith("/proc/") && !canonicalPath.startsWith("/data/misc/")) {
            zzh.zza(zzhVar);
            File dataDir2 = ContextCompat.getDataDir(context);
            boolean z6 = true;
            if (dataDir2 == null ? !canonicalPath.startsWith(zze(Environment.getDataDirectory())) : !canonicalPath.startsWith(zze(dataDir2))) {
                Context createDeviceProtectedStorageContext = ContextCompat.createDeviceProtectedStorageContext(context);
                if (createDeviceProtectedStorageContext == null || (dataDir = ContextCompat.getDataDir(createDeviceProtectedStorageContext)) == null || !canonicalPath.startsWith(zze(dataDir))) {
                    File[] zzk = zzk(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzb
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            int i6 = zzi.zza;
                            return ContextCompat.getExternalFilesDirs(context, null);
                        }
                    });
                    int length = zzk.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 < length) {
                            File file = zzk[i6];
                            if (file != null && canonicalPath.startsWith(zze(file))) {
                                break;
                            } else {
                                i6++;
                            }
                        } else {
                            File[] zzk2 = zzk(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzc
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    int i7 = zzi.zza;
                                    return ContextCompat.getExternalCacheDirs(context);
                                }
                            });
                            int length2 = zzk2.length;
                            int i7 = 0;
                            while (true) {
                                if (i7 < length2) {
                                    File file2 = zzk2[i7];
                                    if (file2 != null && canonicalPath.startsWith(zze(file2))) {
                                        break;
                                    } else {
                                        i7++;
                                    }
                                } else {
                                    z6 = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            z5 = zzhVar.zzb;
            if (z6 == z5) {
                return;
            }
        }
        throw new FileNotFoundException("Can't open file: ".concat(canonicalPath));
    }

    public static InputStream zzb(Context context, Uri uri, zzh zzhVar) throws FileNotFoundException {
        ContentResolver contentResolver = context.getContentResolver();
        Uri zzc2 = zzc(uri);
        String scheme = zzc2.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openInputStream(zzc2);
        }
        if ("content".equals(scheme)) {
            if (zzj(context, zzc2, 1, zzhVar)) {
                InputStream openInputStream = contentResolver.openInputStream(zzc2);
                zzd(openInputStream);
                return openInputStream;
            }
            throw new FileNotFoundException("Can't open content uri.");
        }
        if (b.f50156c.equals(scheme)) {
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(Uri.fromFile(new File(zzc2.getPath()).getCanonicalFile()), t.f36150k);
                try {
                    zzi(context, openFileDescriptor, zzc2, zzhVar);
                    return new ParcelFileDescriptor.AutoCloseInputStream(openFileDescriptor);
                } catch (FileNotFoundException e6) {
                    zzh(openFileDescriptor, e6);
                    throw e6;
                } catch (IOException e7) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                    fileNotFoundException.initCause(e7);
                    zzh(openFileDescriptor, fileNotFoundException);
                    throw fileNotFoundException;
                }
            } catch (IOException e8) {
                FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Canonicalization failed.");
                fileNotFoundException2.initCause(e8);
                throw fileNotFoundException2;
            }
        }
        throw new FileNotFoundException("Unsupported scheme");
    }

    private static String zze(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (!canonicalPath.endsWith("/")) {
            return canonicalPath.concat("/");
        }
        return canonicalPath;
    }

    private static void zzf(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        try {
            StructStat fstat = Os.fstat(parcelFileDescriptor.getFileDescriptor());
            try {
                StructStat lstat = Os.lstat(str);
                if (!OsConstants.S_ISLNK(lstat.st_mode)) {
                    if (fstat.st_dev == lstat.st_dev && fstat.st_ino == lstat.st_ino) {
                        return;
                    } else {
                        throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(str)));
                    }
                }
                throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(str)));
            } catch (ErrnoException e6) {
                throw new IOException(e6);
            }
        } catch (ErrnoException e7) {
            throw new IOException(e7);
        }
    }

    private static void zzg(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            assetFileDescriptor.close();
        } catch (IOException e6) {
            fileNotFoundException.addSuppressed(e6);
        }
    }

    private static void zzh(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e6) {
            fileNotFoundException.addSuppressed(e6);
        }
    }

    private static boolean zzj(Context context, Uri uri, int i6, zzh zzhVar) {
        boolean z5;
        boolean z6;
        boolean z7;
        String authority = uri.getAuthority();
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
        if (resolveContentProvider == null) {
            int lastIndexOf = authority.lastIndexOf(64);
            if (lastIndexOf >= 0) {
                authority = authority.substring(lastIndexOf + 1);
                resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            }
            if (resolveContentProvider == null) {
                z7 = zzhVar.zzb;
                if (z7) {
                    return false;
                }
                return true;
            }
        }
        if (zzh.zzc(zzhVar, context, new zzj(uri, resolveContentProvider, authority)) - 1 == 1) {
            return false;
        }
        if (context.getPackageName().equals(resolveContentProvider.packageName)) {
            z6 = zzhVar.zzb;
            return z6;
        }
        z5 = zzhVar.zzb;
        if (z5) {
            return false;
        }
        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 1) != 0 && resolveContentProvider.exported) {
            String[] strArr = zzc;
            int length = strArr.length;
            for (int i7 = 0; i7 < 2; i7++) {
                if (strArr[i7].equals(authority)) {
                    return true;
                }
            }
            String[] strArr2 = zzd;
            int length2 = strArr2.length;
            for (int i8 = 0; i8 < 3; i8++) {
                if (strArr2[i8].equals(authority)) {
                    return true;
                }
            }
            String[] strArr3 = zzb;
            for (int i9 = 0; i9 < 6; i9++) {
                String str = strArr3[i9];
                if (str.charAt(str.length() - 1) == '.') {
                    if (resolveContentProvider.packageName.startsWith(str)) {
                        return false;
                    }
                } else if (resolveContentProvider.packageName.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static File[] zzk(Callable callable) {
        try {
            return (File[]) callable.call();
        } catch (NullPointerException e6) {
            if (Build.VERSION.SDK_INT < 22) {
                return new File[0];
            }
            throw e6;
        } catch (Exception e7) {
            throw new RuntimeException(e7);
        }
    }
}
