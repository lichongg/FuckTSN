package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.Quality;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_Quality_ConstantQuality extends Quality.ConstantQuality {
    private final String name;
    private final int value;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Quality.ConstantQuality) {
            Quality.ConstantQuality constantQuality = (Quality.ConstantQuality) obj;
            if (this.value == constantQuality.getValue() && this.name.equals(constantQuality.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    @NonNull
    String getName() {
        return this.name;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    int getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((this.value ^ 1000003) * 1000003) ^ this.name.hashCode();
    }

    public String toString() {
        return "ConstantQuality{value=" + this.value + ", name=" + this.name + "}";
    }

    AutoValue_Quality_ConstantQuality(int i6, String str) {
        this.value = i6;
        if (str != null) {
            this.name = str;
            return;
        }
        throw new NullPointerException("Null name");
    }
}
