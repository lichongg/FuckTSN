package xyz.adscope.amps.ad.unified.inter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSUnifiedDownloadListener {
    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadPaused(int i6);

    void onDownloadProgressUpdate(int i6);

    void onDownloadStarted();

    void onInstalled();
}
