package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public interface RemoteModelLoaderHelper {
    @NonNull
    @KeepForSdk
    MappedByteBuffer loadModelAtPath(@NonNull String str) throws MlKitException;
}
