package com.kwad.sdk.export.proxy;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DownloadParams;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface AdDownloadProxy {
    void cancelDownload(Context context, String str, DownloadParams downloadParams);

    @Nullable
    String getDownloadFilePath(DownloadParams downloadParams);

    void pauseDownload(Context context, String str, DownloadParams downloadParams);

    void startDownload(Context context, String str, DownloadParams downloadParams);
}
