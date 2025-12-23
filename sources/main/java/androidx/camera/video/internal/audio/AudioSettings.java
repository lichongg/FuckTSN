package androidx.camera.video.internal.audio;

import android.annotation.SuppressLint;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.video.internal.audio.AutoValue_AudioSettings;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class AudioSettings {
    public static final List<Integer> COMMON_SAMPLE_RATES = Collections.unmodifiableList(Arrays.asList(48000, 44100, 22050, 11025, Integer.valueOf(AVMDLDataLoader.KeyIsLiveSetLoaderType), 4800));

    public abstract int getAudioFormat();

    public abstract int getAudioSource();

    @IntRange(from = 1)
    public abstract int getChannelCount();

    @IntRange(from = 1)
    public abstract int getSampleRate();

    @NonNull
    public abstract Builder toBuilder();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue.Builder
    public static abstract class Builder {
        abstract AudioSettings autoBuild();

        @NonNull
        public abstract Builder setAudioFormat(int i6);

        @NonNull
        public abstract Builder setAudioSource(int i6);

        @NonNull
        public abstract Builder setChannelCount(@IntRange(from = 1) int i6);

        @NonNull
        public abstract Builder setSampleRate(@IntRange(from = 1) int i6);

        Builder() {
        }

        @NonNull
        public final AudioSettings build() {
            AudioSettings autoBuild = autoBuild();
            String str = "";
            if (autoBuild.getAudioSource() == -1) {
                str = " audioSource";
            }
            if (autoBuild.getSampleRate() <= 0) {
                str = str + " sampleRate";
            }
            if (autoBuild.getChannelCount() <= 0) {
                str = str + " channelCount";
            }
            if (autoBuild.getAudioFormat() == -1) {
                str = str + " audioFormat";
            }
            if (str.isEmpty()) {
                return autoBuild;
            }
            throw new IllegalArgumentException("Required settings missing or non-positive:" + str);
        }
    }

    @NonNull
    @SuppressLint({"Range"})
    public static Builder builder() {
        return new AutoValue_AudioSettings.Builder().setAudioSource(-1).setSampleRate(-1).setChannelCount(-1).setAudioFormat(-1);
    }

    AudioSettings() {
    }

    public int getBytesPerFrame() {
        return AudioUtils.getBytesPerFrame(getAudioFormat(), getChannelCount());
    }
}
