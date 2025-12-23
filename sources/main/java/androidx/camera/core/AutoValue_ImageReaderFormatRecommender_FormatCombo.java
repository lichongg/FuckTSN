package androidx.camera.core;

import androidx.camera.core.ImageReaderFormatRecommender;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_ImageReaderFormatRecommender_FormatCombo extends ImageReaderFormatRecommender.FormatCombo {
    private final int imageAnalysisFormat;
    private final int imageCaptureFormat;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImageReaderFormatRecommender.FormatCombo) {
            ImageReaderFormatRecommender.FormatCombo formatCombo = (ImageReaderFormatRecommender.FormatCombo) obj;
            if (this.imageCaptureFormat == formatCombo.imageCaptureFormat() && this.imageAnalysisFormat == formatCombo.imageAnalysisFormat()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.imageCaptureFormat ^ 1000003) * 1000003) ^ this.imageAnalysisFormat;
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    int imageAnalysisFormat() {
        return this.imageAnalysisFormat;
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    int imageCaptureFormat() {
        return this.imageCaptureFormat;
    }

    public String toString() {
        return "FormatCombo{imageCaptureFormat=" + this.imageCaptureFormat + ", imageAnalysisFormat=" + this.imageAnalysisFormat + "}";
    }

    AutoValue_ImageReaderFormatRecommender_FormatCombo(int i6, int i7) {
        this.imageCaptureFormat = i6;
        this.imageAnalysisFormat = i7;
    }
}
