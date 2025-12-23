package com.google.mlkit.common.sdkinternal.model;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzmu;
import com.google.android.gms.internal.mlkit_common.zzna;
import com.google.android.gms.internal.mlkit_common.zzsh;
import com.google.android.gms.internal.mlkit_common.zzsk;
import com.google.android.gms.internal.mlkit_common.zzss;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.stub.StubApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class RemoteModelDownloadManager {
    private static final GmsLogger zza = new GmsLogger("ModelDownloadManager", "");

    @GuardedBy("RemoteModelDownloadManager.class")
    private static final Map zzb = new HashMap();

    @GuardedBy("this")
    private final LongSparseArray zzc = new LongSparseArray();

    @GuardedBy("this")
    private final LongSparseArray zzd = new LongSparseArray();
    private final MlKitContext zze;

    @Nullable
    private final DownloadManager zzf;
    private final RemoteModel zzg;
    private final ModelType zzh;
    private final zzsh zzi;
    private final SharedPrefManager zzj;
    private final ModelFileHelper zzk;

    @Nullable
    private final ModelInfoRetrieverInterop zzl;
    private final RemoteModelFileManager zzm;
    private DownloadConditions zzn;

    private final synchronized TaskCompletionSource zzk(long j6) {
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzd.get(j6);
        if (taskCompletionSource != null) {
            return taskCompletionSource;
        }
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        this.zzd.put(j6, taskCompletionSource2);
        return taskCompletionSource2;
    }

    private final synchronized zzc zzm(long j6) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            zzc zzcVar = (zzc) this.zzc.get(j6);
            if (zzcVar != null) {
                return zzcVar;
            }
            zzc zzcVar2 = new zzc(this, j6, zzk(j6), null);
            this.zzc.put(j6, zzcVar2);
            return zzcVar2;
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Nullable
    private final synchronized Long zzn(@NonNull DownloadManager.Request request, @NonNull ModelInfo modelInfo) {
        DownloadManager downloadManager = this.zzf;
        if (downloadManager == null) {
            return null;
        }
        long enqueue = downloadManager.enqueue(request);
        zza.d("ModelDownloadManager", "Schedule a new downloading task: " + enqueue);
        this.zzj.setDownloadingModelInfo(enqueue, modelInfo);
        this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, false, modelInfo.getModelType(), zzna.SCHEDULED);
        return Long.valueOf(enqueue);
    }

    @Nullable
    @WorkerThread
    private final synchronized Long zzo(@NonNull ModelInfo modelInfo, @NonNull DownloadConditions downloadConditions) throws MlKitException {
        try {
            Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
            String downloadingModelHash = this.zzj.getDownloadingModelHash(this.zzg);
            Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
            if (downloadingModelHash != null && downloadingModelHash.equals(modelInfo.getModelHash()) && downloadingModelStatusCode != null) {
                Integer downloadingModelStatusCode2 = getDownloadingModelStatusCode();
                if (downloadingModelStatusCode2 != null) {
                    if (downloadingModelStatusCode2.intValue() != 8 && downloadingModelStatusCode2.intValue() != 16) {
                    }
                    zza.d("ModelDownloadManager", "New model is already in downloading, do nothing.");
                    return null;
                }
                zzsh zzshVar = this.zzi;
                RemoteModel remoteModel = this.zzg;
                zzshVar.zzf(zzsk.zzg(), remoteModel, zzmu.NO_ERROR, false, remoteModel.getModelType(), zzna.DOWNLOADING);
                zza.d("ModelDownloadManager", "New model is already in downloading, do nothing.");
                return null;
            }
            GmsLogger gmsLogger = zza;
            gmsLogger.d("ModelDownloadManager", "Need to download a new model.");
            removeOrCancelDownload();
            DownloadManager.Request request = new DownloadManager.Request(modelInfo.getModelUri());
            if (this.zzk.modelExistsLocally(modelInfo.getModelNameForPersist(), modelInfo.getModelType())) {
                gmsLogger.d("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
                this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, false, modelInfo.getModelType(), zzna.UPDATE_AVAILABLE);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                request.setRequiresCharging(downloadConditions.isChargingRequired());
            }
            if (downloadConditions.isWifiRequired()) {
                request.setAllowedNetworkTypes(2);
            }
            return zzn(request, modelInfo);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Nullable
    @KeepForSdk
    public synchronized ParcelFileDescriptor getDownloadedFile() {
        DownloadManager downloadManager = this.zzf;
        Long downloadingId = getDownloadingId();
        ParcelFileDescriptor parcelFileDescriptor = null;
        if (downloadManager == null || downloadingId == null) {
            return null;
        }
        try {
            parcelFileDescriptor = downloadManager.openDownloadedFile(downloadingId.longValue());
        } catch (FileNotFoundException unused) {
            zza.e("ModelDownloadManager", "Downloaded file is not found");
        }
        return parcelFileDescriptor;
    }

    @Nullable
    @KeepForSdk
    public synchronized Long getDownloadingId() {
        return this.zzj.getDownloadingModelId(this.zzg);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getDownloadingModelHash() {
        return this.zzj.getDownloadingModelHash(this.zzg);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        if (r3.intValue() != 16) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049 A[Catch: all -> 0x003c, TRY_ENTER, TryCatch #2 {all -> 0x003c, blocks: (B:38:0x0027, B:40:0x002d, B:13:0x0049, B:15:0x0050, B:17:0x0057, B:19:0x005d, B:21:0x0065), top: B:37:0x0027, outer: #0 }] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.Integer getDownloadingModelStatusCode() {
        /*
            r8 = this;
            monitor-enter(r8)
            android.app.DownloadManager r0 = r8.zzf     // Catch: java.lang.Throwable -> L47
            java.lang.Long r1 = r8.getDownloadingId()     // Catch: java.lang.Throwable -> L47
            r2 = 0
            if (r0 == 0) goto L7d
            if (r1 != 0) goto Le
            goto L7d
        Le:
            android.app.DownloadManager$Query r3 = new android.app.DownloadManager$Query     // Catch: java.lang.Throwable -> L47
            r3.<init>()     // Catch: java.lang.Throwable -> L47
            long r4 = r1.longValue()     // Catch: java.lang.Throwable -> L47
            r1 = 1
            long[] r6 = new long[r1]     // Catch: java.lang.Throwable -> L47
            r7 = 0
            r6[r7] = r4     // Catch: java.lang.Throwable -> L47
            android.app.DownloadManager$Query r3 = r3.setFilterById(r6)     // Catch: java.lang.Throwable -> L47
            android.database.Cursor r0 = r0.query(r3)     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L3e
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3e
            java.lang.String r3 = "status"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L3c
            int r3 = r0.getInt(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3c
            goto L3f
        L3c:
            r1 = move-exception
            goto L74
        L3e:
            r3 = r2
        L3f:
            if (r3 != 0) goto L49
            if (r0 == 0) goto L7d
            r0.close()     // Catch: java.lang.Throwable -> L47
            goto L7d
        L47:
            r0 = move-exception
            goto L7f
        L49:
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r5 = 2
            if (r4 == r5) goto L6e
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r5 = 4
            if (r4 == r5) goto L6e
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            if (r4 == r1) goto L6e
            int r1 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r4 = 8
            if (r1 == r4) goto L6e
            int r1 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r4 = 16
            if (r1 == r4) goto L6e
            goto L6f
        L6e:
            r2 = r3
        L6f:
            r0.close()     // Catch: java.lang.Throwable -> L47
            monitor-exit(r8)
            return r2
        L74:
            r0.close()     // Catch: java.lang.Throwable -> L78
            goto L7c
        L78:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch: java.lang.Throwable -> L47
        L7c:
            throw r1     // Catch: java.lang.Throwable -> L47
        L7d:
            monitor-exit(r8)
            return r2
        L7f:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L47
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.getDownloadingModelStatusCode():java.lang.Integer");
    }

    @KeepForSdk
    public synchronized void removeOrCancelDownload() throws MlKitException {
        try {
            DownloadManager downloadManager = this.zzf;
            Long downloadingId = getDownloadingId();
            if (downloadManager != null && downloadingId != null) {
                zza.d("ModelDownloadManager", "Cancel or remove existing downloading task: ".concat(downloadingId.toString()));
                if (this.zzf.remove(downloadingId.longValue()) <= 0) {
                    if (getDownloadingModelStatusCode() == null) {
                    }
                }
                ModelFileHelper modelFileHelper = this.zzk;
                RemoteModel remoteModel = this.zzg;
                modelFileHelper.deleteTempFilesInPrivateFolder(remoteModel.getUniqueModelNameForPersist(), remoteModel.getModelType());
                this.zzj.clearDownloadingModelInfo(this.zzg);
            }
        } finally {
        }
    }

    @KeepForSdk
    public synchronized void updateLatestModelHashAndType(@NonNull String str) throws MlKitException {
        this.zzj.setLatestModelHash(this.zzg, str);
        removeOrCancelDownload();
    }

    @Nullable
    @WorkerThread
    final synchronized ModelInfo zzg() throws MlKitException {
        try {
            boolean modelExistsLocally = modelExistsLocally();
            if (modelExistsLocally) {
                zzsh zzshVar = this.zzi;
                RemoteModel remoteModel = this.zzg;
                zzshVar.zzf(zzsk.zzg(), remoteModel, zzmu.NO_ERROR, false, remoteModel.getModelType(), zzna.LIVE);
            }
            ModelInfoRetrieverInterop modelInfoRetrieverInterop = this.zzl;
            if (modelInfoRetrieverInterop == null) {
                throw new MlKitException("Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase.", 14);
            }
            ModelInfo retrieveRemoteModelInfo = modelInfoRetrieverInterop.retrieveRemoteModelInfo(this.zzg);
            if (retrieveRemoteModelInfo == null) {
                return null;
            }
            MlKitContext mlKitContext = this.zze;
            RemoteModel remoteModel2 = this.zzg;
            String modelHash = retrieveRemoteModelInfo.getModelHash();
            SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(mlKitContext);
            boolean equals = modelHash.equals(sharedPrefManager.getIncompatibleModelHash(remoteModel2));
            boolean z5 = false;
            boolean z6 = true;
            if (equals && CommonUtils.getAppVersion(StubApp.getOrigApplicationContext(mlKitContext.getApplicationContext())).equals(sharedPrefManager.getPreviousAppVersion())) {
                zza.e("ModelDownloadManager", "The model is incompatible with TFLite and the app is not upgraded, do not download");
                z6 = false;
            }
            if (!modelExistsLocally) {
                this.zzj.clearLatestModelHash(this.zzg);
            }
            boolean equals2 = retrieveRemoteModelInfo.getModelHash().equals(SharedPrefManager.getInstance(this.zze).getLatestModelHash(this.zzg));
            boolean z7 = !equals2;
            if (!z6) {
                z5 = z7;
            } else if (!modelExistsLocally || !equals2) {
                return retrieveRemoteModelInfo;
            }
            if (modelExistsLocally && (z5 ^ z6)) {
                return null;
            }
            throw new MlKitException("The model " + this.zzg.getModelName() + " is incompatible with TFLite runtime", 100);
        } catch (Throwable th) {
            throw th;
        }
    }

    @NonNull
    @KeepForSdk
    public static synchronized RemoteModelDownloadManager getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        RemoteModel remoteModel2;
        RemoteModelDownloadManager remoteModelDownloadManager;
        synchronized (RemoteModelDownloadManager.class) {
            try {
                Map map = zzb;
                if (map.containsKey(remoteModel)) {
                    remoteModel2 = remoteModel;
                } else {
                    remoteModel2 = remoteModel;
                    map.put(remoteModel2, new RemoteModelDownloadManager(mlKitContext, remoteModel2, modelFileHelper, remoteModelFileManager, modelInfoRetrieverInterop, zzss.zzb("common")));
                }
                remoteModelDownloadManager = (RemoteModelDownloadManager) map.get(remoteModel2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return remoteModelDownloadManager;
    }

    private final Task zzj(long j6) {
        MlKitContext mlKitContext = this.zze;
        ContextCompat.registerReceiver(StubApp.getOrigApplicationContext(mlKitContext.getApplicationContext()), zzm(j6), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), null, MLTaskExecutor.getInstance().getHandler(), 2);
        return zzk(j6).getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MlKitException zzl(@Nullable Long l6) {
        DownloadManager downloadManager = this.zzf;
        Cursor cursor = null;
        if (downloadManager != null && l6 != null) {
            cursor = downloadManager.query(new DownloadManager.Query().setFilterById(l6.longValue()));
        }
        int i6 = 13;
        String str = "Model downloading failed";
        if (cursor != null && cursor.moveToFirst()) {
            int i7 = cursor.getInt(cursor.getColumnIndex(MediationConstant.KEY_REASON));
            if (i7 == 1006) {
                str = "Model downloading failed due to insufficient space on the device.";
                i6 = 101;
            } else {
                str = "Model downloading failed due to error code: " + i7 + " from Android DownloadManager";
            }
        }
        return new MlKitException(str, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00af, code lost:
    
        r0 = zzo(r0, r13.zzn);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:
    
        if (r0 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bf, code lost:
    
        return zzj(r0.longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c0, code lost:
    
        com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.zza.i("ModelDownloadManager", "Didn't schedule download for the updated model");
     */
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.tasks.Task<java.lang.Void> ensureModelDownloaded() {
        /*
            r13 = this;
            com.google.android.gms.internal.mlkit_common.zzsh r0 = r13.zzi
            com.google.android.gms.internal.mlkit_common.zzry r1 = com.google.android.gms.internal.mlkit_common.zzsk.zzg()
            com.google.mlkit.common.model.RemoteModel r2 = r13.zzg
            com.google.android.gms.internal.mlkit_common.zzmu r3 = com.google.android.gms.internal.mlkit_common.zzmu.NO_ERROR
            com.google.mlkit.common.sdkinternal.ModelType r5 = com.google.mlkit.common.sdkinternal.ModelType.UNKNOWN
            com.google.android.gms.internal.mlkit_common.zzna r6 = com.google.android.gms.internal.mlkit_common.zzna.EXPLICITLY_REQUESTED
            r4 = 0
            r0.zzf(r1, r2, r3, r4, r5, r6)
            r1 = 0
            com.google.mlkit.common.sdkinternal.ModelInfo r0 = r13.zzg()     // Catch: com.google.mlkit.common.MlKitException -> L19
            r2 = r1
            goto L1c
        L19:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L1c:
            r3 = 13
            java.lang.Integer r4 = r13.getDownloadingModelStatusCode()     // Catch: com.google.mlkit.common.MlKitException -> L38
            java.lang.Long r5 = r13.getDownloadingId()     // Catch: com.google.mlkit.common.MlKitException -> L38
            boolean r6 = r13.modelExistsLocally()     // Catch: com.google.mlkit.common.MlKitException -> L38
            if (r6 != 0) goto Lad
            if (r4 == 0) goto L3b
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> L38
            r7 = 8
            if (r6 != r7) goto L3b
            goto Lad
        L38:
            r0 = move-exception
            goto Lce
        L3b:
            if (r4 == 0) goto L51
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> L38
            r7 = 16
            if (r6 != r7) goto L51
            com.google.mlkit.common.MlKitException r0 = r13.zzl(r5)     // Catch: com.google.mlkit.common.MlKitException -> L38
            r13.removeOrCancelDownload()     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch: com.google.mlkit.common.MlKitException -> L38
            return r0
        L51:
            if (r4 == 0) goto L8d
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> L38
            r7 = 4
            if (r6 == r7) goto L68
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> L38
            r7 = 2
            if (r6 == r7) goto L68
            int r4 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> L38
            r6 = 1
            if (r4 != r6) goto L8d
        L68:
            if (r5 == 0) goto L8d
            java.lang.String r4 = r13.getDownloadingModelHash()     // Catch: com.google.mlkit.common.MlKitException -> L38
            if (r4 == 0) goto L8d
            com.google.android.gms.internal.mlkit_common.zzsh r6 = r13.zzi     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.android.gms.internal.mlkit_common.zzry r7 = com.google.android.gms.internal.mlkit_common.zzsk.zzg()     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.mlkit.common.model.RemoteModel r8 = r13.zzg     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.android.gms.internal.mlkit_common.zzmu r9 = com.google.android.gms.internal.mlkit_common.zzmu.NO_ERROR     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.mlkit.common.sdkinternal.ModelType r11 = r8.getModelType()     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.android.gms.internal.mlkit_common.zzna r12 = com.google.android.gms.internal.mlkit_common.zzna.DOWNLOADING     // Catch: com.google.mlkit.common.MlKitException -> L38
            r10 = 0
            r6.zzf(r7, r8, r9, r10, r11, r12)     // Catch: com.google.mlkit.common.MlKitException -> L38
            long r0 = r5.longValue()     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.android.gms.tasks.Task r0 = r13.zzj(r0)     // Catch: com.google.mlkit.common.MlKitException -> L38
            return r0
        L8d:
            if (r0 != 0) goto L90
            goto L96
        L90:
            com.google.mlkit.common.model.DownloadConditions r1 = r13.zzn     // Catch: com.google.mlkit.common.MlKitException -> L38
            java.lang.Long r1 = r13.zzo(r0, r1)     // Catch: com.google.mlkit.common.MlKitException -> L38
        L96:
            if (r1 != 0) goto La4
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException     // Catch: com.google.mlkit.common.MlKitException -> L38
            java.lang.String r1 = "Failed to schedule the download task"
            r0.<init>(r1, r3, r2)     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch: com.google.mlkit.common.MlKitException -> L38
            return r0
        La4:
            long r0 = r1.longValue()     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.android.gms.tasks.Task r0 = r13.zzj(r0)     // Catch: com.google.mlkit.common.MlKitException -> L38
            return r0
        Lad:
            if (r0 == 0) goto Lc9
            com.google.mlkit.common.model.DownloadConditions r2 = r13.zzn     // Catch: com.google.mlkit.common.MlKitException -> L38
            java.lang.Long r0 = r13.zzo(r0, r2)     // Catch: com.google.mlkit.common.MlKitException -> L38
            if (r0 == 0) goto Lc0
            long r0 = r0.longValue()     // Catch: com.google.mlkit.common.MlKitException -> L38
            com.google.android.gms.tasks.Task r0 = r13.zzj(r0)     // Catch: com.google.mlkit.common.MlKitException -> L38
            return r0
        Lc0:
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.zza     // Catch: com.google.mlkit.common.MlKitException -> L38
            java.lang.String r2 = "ModelDownloadManager"
            java.lang.String r4 = "Didn't schedule download for the updated model"
            r0.i(r2, r4)     // Catch: com.google.mlkit.common.MlKitException -> L38
        Lc9:
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forResult(r1)     // Catch: com.google.mlkit.common.MlKitException -> L38
            return r0
        Lce:
            com.google.mlkit.common.MlKitException r1 = new com.google.mlkit.common.MlKitException
            java.lang.String r2 = "Failed to ensure the model is downloaded."
            r1.<init>(r2, r3, r0)
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.ensureModelDownloaded():com.google.android.gms.tasks.Task");
    }

    @KeepForSdk
    public int getFailureReason(@NonNull Long l6) {
        int columnIndex;
        DownloadManager downloadManager = this.zzf;
        Cursor cursor = null;
        if (downloadManager != null && l6 != null) {
            cursor = downloadManager.query(new DownloadManager.Query().setFilterById(l6.longValue()));
        }
        if (cursor == null || !cursor.moveToFirst() || (columnIndex = cursor.getColumnIndex(MediationConstant.KEY_REASON)) == -1) {
            return 0;
        }
        return cursor.getInt(columnIndex);
    }

    @KeepForSdk
    @WorkerThread
    public boolean isModelDownloadedAndValid() throws MlKitException {
        try {
            if (modelExistsLocally()) {
                return true;
            }
        } catch (MlKitException unused) {
            zza.d("ModelDownloadManager", "Failed to check if the model exist locally.");
        }
        Long downloadingId = getDownloadingId();
        String downloadingModelHash = getDownloadingModelHash();
        if (downloadingId == null || downloadingModelHash == null) {
            zza.d("ModelDownloadManager", "No new model is downloading.");
            removeOrCancelDownload();
            return false;
        }
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        zza.d("ModelDownloadManager", "Download Status code: ".concat(String.valueOf(downloadingModelStatusCode)));
        if (downloadingModelStatusCode != null) {
            return Objects.equal(downloadingModelStatusCode, 8) && zzi(downloadingModelHash) != null;
        }
        removeOrCancelDownload();
        return false;
    }

    @KeepForSdk
    public boolean modelExistsLocally() throws MlKitException {
        return this.zzk.modelExistsLocally(this.zzg.getUniqueModelNameForPersist(), this.zzh);
    }

    @KeepForSdk
    public void setDownloadConditions(@NonNull DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        this.zzn = downloadConditions;
    }

    @Nullable
    public final File zzi(@NonNull String str) throws MlKitException {
        GmsLogger gmsLogger = zza;
        gmsLogger.d("ModelDownloadManager", "Model downloaded successfully");
        this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, true, this.zzh, zzna.SUCCEEDED);
        ParcelFileDescriptor downloadedFile = getDownloadedFile();
        if (downloadedFile == null) {
            removeOrCancelDownload();
            return null;
        }
        gmsLogger.d("ModelDownloadManager", "moving downloaded model from external storage to private folder.");
        try {
            return this.zzm.moveModelToPrivateFolder(downloadedFile, str, this.zzg);
        } finally {
            removeOrCancelDownload();
        }
    }

    @VisibleForTesting
    RemoteModelDownloadManager(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop, @NonNull zzsh zzshVar) {
        this.zze = mlKitContext;
        this.zzh = remoteModel.getModelType();
        this.zzg = remoteModel;
        DownloadManager downloadManager = (DownloadManager) StubApp.getOrigApplicationContext(mlKitContext.getApplicationContext()).getSystemService("download");
        this.zzf = downloadManager;
        this.zzi = zzshVar;
        if (downloadManager == null) {
            zza.d("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.zzk = modelFileHelper;
        this.zzj = SharedPrefManager.getInstance(mlKitContext);
        this.zzl = modelInfoRetrieverInterop;
        this.zzm = remoteModelFileManager;
    }
}
