package com.google.mlkit.common.sdkinternal.model;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class RemoteModelFileManager {
    private static final GmsLogger zza = new GmsLogger("RemoteModelFileManager", "");
    private final MlKitContext zzb;
    private final String zzc;
    private final ModelType zzd;

    @Nullable
    private final ModelValidator zze;
    private final RemoteModelFileMover zzf;
    private final SharedPrefManager zzg;
    private final ModelFileHelper zzh;

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a5, code lost:
    
        com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager.zza.d("RemoteModelFileManager", "Hash does not match with expected: ".concat(java.lang.String.valueOf(r12)));
        com.google.android.gms.internal.mlkit_common.zzss.zzb("common").zzf(com.google.android.gms.internal.mlkit_common.zzsk.zzg(), r13, com.google.android.gms.internal.mlkit_common.zzmu.MODEL_HASH_MISMATCH, true, r10.zzd, com.google.android.gms.internal.mlkit_common.zzna.SUCCEEDED);
        r11 = new com.google.mlkit.common.MlKitException("Hash does not match with expected", 102);
     */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.io.File moveModelToPrivateFolder(@androidx.annotation.NonNull android.os.ParcelFileDescriptor r11, @androidx.annotation.NonNull java.lang.String r12, @androidx.annotation.NonNull com.google.mlkit.common.model.RemoteModel r13) throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager.moveModelToPrivateFolder(android.os.ParcelFileDescriptor, java.lang.String, com.google.mlkit.common.model.RemoteModel):java.io.File");
    }

    @NonNull
    @WorkerThread
    public final synchronized File zza(@NonNull File file) throws MlKitException {
        File file2 = new File(String.valueOf(this.zzh.getModelDir(this.zzc, this.zzd).getAbsolutePath()).concat("/0"));
        if (file2.exists()) {
            return file;
        }
        return file.renameTo(file2) ? file2 : file;
    }

    @Nullable
    @WorkerThread
    public final synchronized String zzb() throws MlKitException {
        return this.zzh.zzb(this.zzc, this.zzd);
    }

    @WorkerThread
    public final synchronized void zzc(@NonNull File file) {
        File[] listFiles;
        File modelDirUnsafe = getModelDirUnsafe(false);
        if (modelDirUnsafe.exists() && (listFiles = modelDirUnsafe.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.equals(file)) {
                    this.zzh.deleteRecursively(file);
                    return;
                }
            }
        }
    }

    @WorkerThread
    public final synchronized boolean zzd(@NonNull File file) throws MlKitException {
        File modelDir = this.zzh.getModelDir(this.zzc, this.zzd);
        if (!modelDir.exists()) {
            return false;
        }
        File[] listFiles = modelDir.listFiles();
        boolean z5 = true;
        if (listFiles == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (!file2.equals(file) && !this.zzh.deleteRecursively(file2)) {
                z5 = false;
            }
        }
        return z5;
    }

    @NonNull
    @KeepForSdk
    public File getModelDirUnsafe(boolean z5) {
        return this.zzh.getModelDirUnsafe(this.zzc, this.zzd, z5);
    }

    @SuppressLint({"FirebaseLambdaLast"})
    public RemoteModelFileManager(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @Nullable ModelValidator modelValidator, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        String uniqueModelNameForPersist;
        this.zzb = mlKitContext;
        ModelType modelType = remoteModel.getModelType();
        this.zzd = modelType;
        if (modelType == ModelType.TRANSLATE) {
            uniqueModelNameForPersist = remoteModel.getModelNameForBackend();
        } else {
            uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
        }
        this.zzc = uniqueModelNameForPersist;
        this.zze = modelValidator;
        this.zzg = SharedPrefManager.getInstance(mlKitContext);
        this.zzh = modelFileHelper;
        this.zzf = remoteModelFileMover;
    }
}
