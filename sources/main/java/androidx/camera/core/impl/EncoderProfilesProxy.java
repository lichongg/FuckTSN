package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface EncoderProfilesProxy {
    public static final int CODEC_PROFILE_NONE = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    public static abstract class AudioProfileProxy {
        public static final String MEDIA_TYPE_NONE = "audio/none";

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface AudioEncoder {
        }

        public abstract int getBitrate();

        public abstract int getChannels();

        public abstract int getCodec();

        @NonNull
        public abstract String getMediaType();

        public abstract int getProfile();

        public abstract int getSampleRate();

        @NonNull
        public static AudioProfileProxy create(int i6, @NonNull String str, int i7, int i8, int i9, int i10) {
            return new AutoValue_EncoderProfilesProxy_AudioProfileProxy(i6, str, i7, i8, i9, i10);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    public static abstract class ImmutableEncoderProfilesProxy implements EncoderProfilesProxy {
        @NonNull
        public static ImmutableEncoderProfilesProxy create(int i6, int i7, @NonNull List<AudioProfileProxy> list, @NonNull List<VideoProfileProxy> list2) {
            return new AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy(i6, i7, Collections.unmodifiableList(new ArrayList(list)), Collections.unmodifiableList(new ArrayList(list2)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    public static abstract class VideoProfileProxy {
        public static final int BIT_DEPTH_10 = 10;
        public static final int BIT_DEPTH_8 = 8;
        public static final String MEDIA_TYPE_NONE = "video/none";

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface VideoEncoder {
        }

        public abstract int getBitDepth();

        public abstract int getBitrate();

        public abstract int getChromaSubsampling();

        public abstract int getCodec();

        public abstract int getFrameRate();

        public abstract int getHdrFormat();

        public abstract int getHeight();

        @NonNull
        public abstract String getMediaType();

        public abstract int getProfile();

        public abstract int getWidth();

        @NonNull
        public static VideoProfileProxy create(int i6, @NonNull String str, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            return new AutoValue_EncoderProfilesProxy_VideoProfileProxy(i6, str, i7, i8, i9, i10, i11, i12, i13, i14);
        }
    }

    @NonNull
    List<AudioProfileProxy> getAudioProfiles();

    int getDefaultDurationSeconds();

    int getRecommendedFileFormat();

    @NonNull
    List<VideoProfileProxy> getVideoProfiles();
}
