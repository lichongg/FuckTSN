package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class LegacyModelMigrator {

    @NonNull
    @KeepForSdk
    protected final ModelFileHelper modelFileHelper;
    private final Context zzb;
    private final TaskCompletionSource zza = new TaskCompletionSource();
    private final Executor zzc = MLTaskExecutor.workerThreadExecutor();

    @NonNull
    @KeepForSdk
    @VisibleForTesting
    protected abstract String getLegacyModelDirName();

    @KeepForSdk
    protected abstract void migrateAllModelDirs(@NonNull File file);

    @KeepForSdk
    protected static boolean isValidFirebasePersistenceKey(@NonNull String str) {
        String[] split = str.split("\\+", -1);
        if (split.length != 2) {
            return false;
        }
        try {
            Base64Utils.decodeUrlSafeNoPadding(split[0]);
            Base64Utils.decodeUrlSafeNoPadding(split[1]);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @NonNull
    @KeepForSdk
    @VisibleForTesting
    public File getLegacyRootDir() {
        Context context = this.zzb;
        return new File(context.getNoBackupFilesDir(), getLegacyModelDirName());
    }

    @NonNull
    @KeepForSdk
    public Task<Void> getMigrationTask() {
        return this.zza.getTask();
    }

    @KeepForSdk
    public void start() {
        this.zzc.execute(new Runnable() { // from class: com.google.mlkit.common.sdkinternal.model.zza
            @Override // java.lang.Runnable
            public final void run() {
                LegacyModelMigrator.this.zza();
            }
        });
    }

    @KeepForSdk
    protected LegacyModelMigrator(@NonNull Context context, @NonNull ModelFileHelper modelFileHelper) {
        this.zzb = context;
        this.modelFileHelper = modelFileHelper;
    }

    @KeepForSdk
    protected static void deleteIfEmpty(@NonNull File file) {
        File[] listFiles = file.listFiles();
        if ((listFiles == null || listFiles.length == 0) && !file.delete()) {
            "Error deleting model directory ".concat(String.valueOf(file));
        }
    }

    @KeepForSdk
    @VisibleForTesting
    public static void migrateFile(@NonNull File file, @NonNull File file2) {
        if (file.exists()) {
            if (!file2.exists() && !file.renameTo(file2)) {
                String.valueOf(file);
                String.valueOf(file2);
            }
            if (file.exists() && !file.delete()) {
                "Error deleting model file ".concat(String.valueOf(file));
            }
        }
    }

    final /* synthetic */ void zza() {
        File legacyRootDir = getLegacyRootDir();
        File[] listFiles = legacyRootDir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                migrateAllModelDirs(file);
            }
            deleteIfEmpty(legacyRootDir);
        }
        this.zza.setResult(null);
    }
}
