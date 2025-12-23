package xyz.adscope.common.network.download;

import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Url;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface Download {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Policy {
        public static final Policy DEFAULT = new Policy() { // from class: xyz.adscope.common.network.download.Download.Policy.1
            @Override // xyz.adscope.common.network.download.Download.Policy
            public boolean allowDownload(int i6, Headers headers) {
                return true;
            }

            @Override // xyz.adscope.common.network.download.Download.Policy
            public boolean isRange() {
                return true;
            }

            @Override // xyz.adscope.common.network.download.Download.Policy
            public boolean oldAvailable(String str, int i6, Headers headers) {
                return false;
            }
        };

        boolean allowDownload(int i6, Headers headers);

        boolean isRange();

        boolean oldAvailable(String str, int i6, Headers headers);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ProgressBar {
        public static final ProgressBar DEFAULT = new ProgressBar() { // from class: xyz.adscope.common.network.download.Download.ProgressBar.1
            @Override // xyz.adscope.common.network.download.Download.ProgressBar
            public void onProgress(int i6, long j6, long j7) {
            }
        };

        void onProgress(int i6, long j6, long j7);
    }

    String directory();

    String fileName();

    Headers headers();

    Policy policy();

    ProgressBar progressBar();

    Url url();
}
