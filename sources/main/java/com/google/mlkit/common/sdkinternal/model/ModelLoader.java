package com.google.mlkit.common.sdkinternal.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
@WorkerThread
/* loaded from: D:\Downloads\app\classes5.dex */
public class ModelLoader {
    private static final GmsLogger zza = new GmsLogger("ModelLoader", "");

    @Nullable
    @KeepForSdk
    public final LocalModelLoader localModelLoader;

    @NonNull
    @KeepForSdk
    protected ModelLoadingState modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;

    @Nullable
    @KeepForSdk
    @VisibleForTesting
    public final RemoteModelLoader remoteModelLoader;

    @NonNull
    private final ModelLoadingLogger zzb;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface ModelContentHandler {
        @KeepForSdk
        void constructModel(@NonNull MappedByteBuffer mappedByteBuffer) throws MlKitException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface ModelLoadingLogger {
        @KeepForSdk
        void logErrorCodes(@NonNull List<Integer> list);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    protected enum ModelLoadingState {
        NO_MODEL_LOADED,
        REMOTE_MODEL_LOADED,
        LOCAL_MODEL_LOADED
    }

    private final synchronized boolean zzb(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        MappedByteBuffer load;
        LocalModelLoader localModelLoader = this.localModelLoader;
        if (localModelLoader == null || (load = localModelLoader.load()) == null) {
            return false;
        }
        try {
            modelContentHandler.constructModel(load);
            zza.d("ModelLoader", "Local model source is loaded successfully");
            return true;
        } catch (RuntimeException e6) {
            list.add(18);
            throw e6;
        }
    }

    private final synchronized boolean zzc(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
        if (remoteModelLoader != null) {
            try {
                MappedByteBuffer load = remoteModelLoader.load();
                if (load != null) {
                    try {
                        modelContentHandler.constructModel(load);
                        zza.d("ModelLoader", "Remote model source is loaded successfully");
                        return true;
                    } catch (RuntimeException e6) {
                        list.add(19);
                        throw e6;
                    }
                }
                zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(21);
            } catch (MlKitException e7) {
                zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(20);
                throw e7;
            }
        }
        return false;
    }

    @KeepForSdk
    public synchronized boolean isRemoteModelLoaded() {
        return this.modelLoadingState == ModelLoadingState.REMOTE_MODEL_LOADED;
    }

    @KeepForSdk
    public synchronized void loadWithModelContentHandler(@NonNull ModelContentHandler modelContentHandler) throws MlKitException {
        Exception exc;
        boolean z5;
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        Exception e6 = null;
        try {
            z5 = zzc(modelContentHandler, arrayList);
            exc = null;
        } catch (Exception e7) {
            exc = e7;
            z5 = false;
        }
        if (z5) {
            this.zzb.logErrorCodes(arrayList);
            this.modelLoadingState = ModelLoadingState.REMOTE_MODEL_LOADED;
            return;
        }
        try {
            z6 = zzb(modelContentHandler, arrayList);
        } catch (Exception e8) {
            e6 = e8;
        }
        if (z6) {
            this.zzb.logErrorCodes(arrayList);
            this.modelLoadingState = ModelLoadingState.LOCAL_MODEL_LOADED;
            return;
        }
        arrayList.add(17);
        this.zzb.logErrorCodes(arrayList);
        this.modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
        if (exc != null) {
            throw new MlKitException("Remote model load failed with the model options: ".concat(String.valueOf(zza())), 14, exc);
        }
        if (e6 == null) {
            throw new MlKitException("Cannot load any model with the model options: ".concat(String.valueOf(zza())), 14);
        }
        throw new MlKitException("Local model load failed with the model options: ".concat(String.valueOf(zza())), 14, e6);
    }

    private final String zza() {
        LocalModelLoader localModelLoader = this.localModelLoader;
        String str = null;
        if (localModelLoader != null) {
            if (localModelLoader.getLocalModel().getAssetFilePath() != null) {
                str = this.localModelLoader.getLocalModel().getAssetFilePath();
            } else if (this.localModelLoader.getLocalModel().getAbsoluteFilePath() != null) {
                str = this.localModelLoader.getLocalModel().getAbsoluteFilePath();
            } else if (this.localModelLoader.getLocalModel().getUri() != null) {
                str = ((Uri) Preconditions.checkNotNull(this.localModelLoader.getLocalModel().getUri())).toString();
            }
        }
        RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
        return String.format("Local model path: %s. Remote model name: %s. ", str, remoteModelLoader == null ? "unspecified" : remoteModelLoader.getRemoteModel().getUniqueModelNameForPersist());
    }

    @KeepForSdk
    public ModelLoader(@Nullable RemoteModelLoader remoteModelLoader, @Nullable LocalModelLoader localModelLoader, @NonNull ModelLoadingLogger modelLoadingLogger) {
        boolean z5 = true;
        if (remoteModelLoader == null && localModelLoader == null) {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        Preconditions.checkNotNull(modelLoadingLogger);
        this.remoteModelLoader = remoteModelLoader;
        this.localModelLoader = localModelLoader;
        this.zzb = modelLoadingLogger;
    }
}
