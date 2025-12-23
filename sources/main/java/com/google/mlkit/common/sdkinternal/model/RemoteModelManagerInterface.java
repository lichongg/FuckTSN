package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public interface RemoteModelManagerInterface<RemoteT extends RemoteModel> {
    @NonNull
    @KeepForSdk
    Task<Void> deleteDownloadedModel(@NonNull RemoteT remotet);

    @NonNull
    @KeepForSdk
    Task<Void> download(@NonNull RemoteT remotet, @NonNull DownloadConditions downloadConditions);

    @NonNull
    @KeepForSdk
    Task<Set<RemoteT>> getDownloadedModels();

    @NonNull
    @KeepForSdk
    Task<Boolean> isModelDownloaded(@NonNull RemoteT remotet);
}
