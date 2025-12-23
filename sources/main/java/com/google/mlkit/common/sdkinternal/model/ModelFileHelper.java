package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.stub.StubApp;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class ModelFileHelper {

    @KeepForSdk
    public static final int INVALID_INDEX = -1;
    private final MlKitContext zze;
    private static final GmsLogger zzd = new GmsLogger("ModelFileHelper", "");

    @NonNull
    @VisibleForTesting
    public static final String zza = String.format("com.google.mlkit.%s.models", "translate");

    @NonNull
    @VisibleForTesting
    public static final String zzb = String.format("com.google.mlkit.%s.models", "custom");

    @VisibleForTesting
    static final String zzc = String.format("com.google.mlkit.%s.models", "base");

    @KeepForSdk
    @WorkerThread
    public synchronized void deleteAllModels(@NonNull ModelType modelType, @NonNull String str) {
        deleteRecursively(getModelDirUnsafe(str, modelType, false));
        deleteRecursively(getModelDirUnsafe(str, modelType, true));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        if (r5 != false) goto L17;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean deleteRecursively(@androidx.annotation.Nullable java.io.File r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            boolean r1 = r8.isDirectory()
            r2 = 1
            if (r1 == 0) goto L2c
            java.io.File[] r1 = r8.listFiles()
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            java.io.File[] r1 = (java.io.File[]) r1
            int r3 = r1.length
            r4 = 0
            r5 = 1
        L18:
            if (r4 >= r3) goto L2a
            r6 = r1[r4]
            if (r5 == 0) goto L26
            boolean r5 = r7.deleteRecursively(r6)
            if (r5 == 0) goto L26
            r5 = 1
            goto L27
        L26:
            r5 = 0
        L27:
            int r4 = r4 + 1
            goto L18
        L2a:
            if (r5 == 0) goto L33
        L2c:
            boolean r8 = r8.delete()
            if (r8 == 0) goto L33
            return r2
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.ModelFileHelper.deleteRecursively(java.io.File):boolean");
    }

    @KeepForSdk
    @WorkerThread
    public void deleteTempFilesInPrivateFolder(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        File zzc2 = zzc(str, modelType, true);
        if (deleteRecursively(zzc2)) {
            return;
        }
        zzd.e("ModelFileHelper", "Failed to delete the temp labels file directory: ".concat(String.valueOf(zzc2 != null ? zzc2.getAbsolutePath() : null)));
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File getModelDir(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return zzc(str, modelType, false);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File getModelTempDir(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File getTempFileInPrivateFolder(@NonNull String str, @NonNull ModelType modelType, @NonNull String str2) throws MlKitException {
        File zzc2 = zzc(str, modelType, true);
        if (zzc2.exists() && zzc2.isFile() && !zzc2.delete()) {
            throw new MlKitException("Failed to delete the temp labels file: ".concat(String.valueOf(zzc2.getAbsolutePath())), 13);
        }
        if (!zzc2.exists()) {
            zzd.d("ModelFileHelper", "Temp labels folder does not exist, creating one: ".concat(String.valueOf(zzc2.getAbsolutePath())));
            if (!zzc2.mkdirs()) {
                throw new MlKitException("Failed to create a directory to hold the AutoML model's labels file.", 13);
            }
        }
        return new File(zzc2, str2);
    }

    @NonNull
    @WorkerThread
    public final File zza(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File getModelDirUnsafe(@NonNull String str, @NonNull ModelType modelType, boolean z5) {
        String str2;
        ModelType modelType2 = ModelType.UNKNOWN;
        int ordinal = modelType.ordinal();
        if (ordinal == 1) {
            str2 = zzc;
        } else if (ordinal == 2) {
            str2 = zza;
        } else {
            if (ordinal != 4) {
                throw new IllegalArgumentException("Unknown model type " + modelType.name() + ". Cannot find a dir to store the downloaded model.");
            }
            str2 = zzb;
        }
        File file = new File(StubApp.getOrigApplicationContext(this.zze.getApplicationContext()).getNoBackupFilesDir(), str2);
        if (z5) {
            file = new File(file, "temp");
        }
        return new File(file, str);
    }

    @KeepForSdk
    @WorkerThread
    public boolean modelExistsLocally(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        String zzb2;
        if (modelType == ModelType.UNKNOWN || (zzb2 = zzb(str, modelType)) == null) {
            return false;
        }
        File file = new File(zzb2);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file, Constants.MODEL_FILE_NAME);
        zzd.i("ModelFileHelper", "Model file path: ".concat(String.valueOf(file2.getAbsolutePath())));
        return file2.exists();
    }

    public ModelFileHelper(@NonNull MlKitContext mlKitContext) {
        this.zze = mlKitContext;
    }

    @WorkerThread
    private final File zzc(@NonNull String str, @NonNull ModelType modelType, boolean z5) throws MlKitException {
        File modelDirUnsafe = getModelDirUnsafe(str, modelType, z5);
        if (!modelDirUnsafe.exists()) {
            zzd.d("ModelFileHelper", "model folder does not exist, creating one: ".concat(String.valueOf(modelDirUnsafe.getAbsolutePath())));
            if (!modelDirUnsafe.mkdirs()) {
                throw new MlKitException("Failed to create model folder: ".concat(String.valueOf(modelDirUnsafe)), 13);
            }
        } else if (!modelDirUnsafe.isDirectory()) {
            throw new MlKitException("Can not create model folder, since an existing file has the same name: ".concat(String.valueOf(modelDirUnsafe)), 6);
        }
        return modelDirUnsafe;
    }

    @KeepForSdk
    @WorkerThread
    public int getLatestCachedModelVersion(@NonNull File file) {
        File[] listFiles = file.listFiles();
        int i6 = -1;
        if (listFiles != null && (listFiles.length) != 0) {
            for (File file2 : listFiles) {
                try {
                    i6 = Math.max(i6, Integer.parseInt(file2.getName()));
                } catch (NumberFormatException unused) {
                    zzd.d("ModelFileHelper", "Contains non-integer file name ".concat(String.valueOf(file2.getName())));
                }
            }
        }
        return i6;
    }

    @Nullable
    @WorkerThread
    public final String zzb(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        File modelDir = getModelDir(str, modelType);
        int latestCachedModelVersion = getLatestCachedModelVersion(modelDir);
        if (latestCachedModelVersion == -1) {
            return null;
        }
        return modelDir.getAbsolutePath() + "/" + latestCachedModelVersion;
    }
}
