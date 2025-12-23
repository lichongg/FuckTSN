package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzsh;
import com.google.android.gms.internal.mlkit_common.zzss;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class RemoteModelLoader {
    private static final GmsLogger zza = new GmsLogger("RemoteModelLoader", "");

    @GuardedBy("RemoteModelLoader.class")
    private static final Map zzb = new HashMap();
    private final MlKitContext zzc;
    private final RemoteModel zzd;
    private final RemoteModelDownloadManager zze;
    private final RemoteModelFileManager zzf;
    private final RemoteModelLoaderHelper zzg;
    private final zzsh zzh;
    private boolean zzi;

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b8 A[Catch: all -> 0x002e, TryCatch #1 {all -> 0x002e, blocks: (B:3:0x0001, B:7:0x001e, B:9:0x0026, B:12:0x00b8, B:14:0x00c7, B:19:0x00cf, B:22:0x00d5, B:23:0x00f3, B:24:0x00f4, B:26:0x0031, B:28:0x0048, B:31:0x0051, B:33:0x006f, B:35:0x0077, B:36:0x0089, B:38:0x0091, B:39:0x00a8), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f4 A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #1 {all -> 0x002e, blocks: (B:3:0x0001, B:7:0x001e, B:9:0x0026, B:12:0x00b8, B:14:0x00c7, B:19:0x00cf, B:22:0x00d5, B:23:0x00f3, B:24:0x00f4, B:26:0x0031, B:28:0x0048, B:31:0x0051, B:33:0x006f, B:35:0x0077, B:36:0x0089, B:38:0x0091, B:39:0x00a8), top: B:2:0x0001, inners: #0 }] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.nio.MappedByteBuffer load() throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelLoader.load():java.nio.MappedByteBuffer");
    }

    @NonNull
    @KeepForSdk
    public static synchronized RemoteModelLoader getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        RemoteModelLoader remoteModelLoader;
        synchronized (RemoteModelLoader.class) {
            try {
                String uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
                Map map = zzb;
                if (!map.containsKey(uniqueModelNameForPersist)) {
                    map.put(uniqueModelNameForPersist, new RemoteModelLoader(mlKitContext, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
                }
                remoteModelLoader = (RemoteModelLoader) map.get(uniqueModelNameForPersist);
            } catch (Throwable th) {
                throw th;
            }
        }
        return remoteModelLoader;
    }

    @NonNull
    @WorkerThread
    private final MappedByteBuffer zza(@NonNull String str) throws MlKitException {
        return this.zzg.loadModelAtPath(str);
    }

    @NonNull
    @KeepForSdk
    public RemoteModel getRemoteModel() {
        return this.zzd;
    }

    private RemoteModelLoader(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, remoteModel, modelValidator, new ModelFileHelper(mlKitContext), remoteModelFileMover);
        this.zzf = remoteModelFileManager;
        this.zzi = true;
        this.zze = RemoteModelDownloadManager.getInstance(mlKitContext, remoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
        this.zzg = remoteModelLoaderHelper;
        this.zzc = mlKitContext;
        this.zzd = remoteModel;
        this.zzh = zzss.zzb("common");
    }

    private final MappedByteBuffer zzb(File file) throws MlKitException {
        try {
            return zza(file.getAbsolutePath());
        } catch (Exception e6) {
            this.zzf.zzc(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e6);
        }
    }
}
