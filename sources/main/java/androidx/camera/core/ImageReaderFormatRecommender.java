package androidx.camera.core;

import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class ImageReaderFormatRecommender {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class FormatCombo {
        abstract int imageAnalysisFormat();

        abstract int imageCaptureFormat();

        static FormatCombo create(int i6, int i7) {
            return new AutoValue_ImageReaderFormatRecommender_FormatCombo(i6, i7);
        }

        FormatCombo() {
        }
    }

    static FormatCombo chooseCombo() {
        return FormatCombo.create(256, 35);
    }

    private ImageReaderFormatRecommender() {
    }
}
