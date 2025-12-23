package androidx.camera.video.internal.encoder;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface VideoEncoderInfo extends EncoderInfo {
    int getHeightAlignment();

    @NonNull
    Range<Integer> getSupportedBitrateRange();

    @NonNull
    Range<Integer> getSupportedHeights();

    @NonNull
    Range<Integer> getSupportedHeightsFor(int i6);

    @NonNull
    Range<Integer> getSupportedWidths();

    @NonNull
    Range<Integer> getSupportedWidthsFor(int i6);

    int getWidthAlignment();

    boolean isSizeSupported(int i6, int i7);
}
