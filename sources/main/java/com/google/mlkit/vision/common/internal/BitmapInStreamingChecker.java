package com.google.mlkit.vision.common.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.vision.common.InputImage;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class BitmapInStreamingChecker {
    private static final GmsLogger zza = new GmsLogger("StreamingFormatChecker", "");
    private final LinkedList zzb = new LinkedList();
    private long zzc = -1;

    @KeepForSdk
    public void check(@NonNull InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzb.add(Long.valueOf(elapsedRealtime));
            if (this.zzb.size() > 5) {
                this.zzb.removeFirst();
            }
            if (this.zzb.size() == 5 && elapsedRealtime - ((Long) Preconditions.checkNotNull((Long) this.zzb.peekFirst())).longValue() < 5000) {
                long j6 = this.zzc;
                if (j6 == -1 || elapsedRealtime - j6 >= TimeUnit.SECONDS.toMillis(5L)) {
                    this.zzc = elapsedRealtime;
                    zza.w("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
                }
            }
        }
    }
}
