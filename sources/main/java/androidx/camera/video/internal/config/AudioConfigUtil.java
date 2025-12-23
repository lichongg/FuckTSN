package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class AudioConfigUtil {
    static final int AUDIO_CHANNEL_COUNT_DEFAULT = 1;
    static final int AUDIO_SAMPLE_RATE_DEFAULT = 44100;
    static final int AUDIO_SOURCE_DEFAULT = 5;
    static final int AUDIO_SOURCE_FORMAT_DEFAULT = 2;
    private static final String TAG = "AudioConfigUtil";

    static int selectSampleRateOrNearestSupported(@NonNull Range<Integer> range, int i6, int i7, final int i8) {
        ArrayList arrayList = null;
        int i9 = 0;
        int i10 = i8;
        while (true) {
            if (!range.contains((Range<Integer>) Integer.valueOf(i10))) {
                Logger.d(TAG, "Sample rate " + i10 + "Hz is not in target range " + range);
            } else {
                if (AudioSource.isSettingsSupported(i10, i6, i7)) {
                    return i10;
                }
                Logger.d(TAG, "Sample rate " + i10 + "Hz is not supported by audio source with channel count " + i6 + " and source format " + i7);
            }
            if (arrayList == null) {
                Logger.d(TAG, "Trying common sample rates in proximity order to target " + i8 + "Hz");
                arrayList = new ArrayList(AudioSettings.COMMON_SAMPLE_RATES);
                Collections.sort(arrayList, new Comparator() { // from class: androidx.camera.video.internal.config.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return AudioConfigUtil.a(i8, (Integer) obj, (Integer) obj2);
                    }
                });
            }
            if (i9 >= arrayList.size()) {
                Logger.d(TAG, "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
                return AUDIO_SAMPLE_RATE_DEFAULT;
            }
            i10 = ((Integer) arrayList.get(i9)).intValue();
            i9++;
        }
    }

    static int scaleAndClampBitrate(int i6, int i7, int i8, int i9, int i10, Range<Integer> range) {
        int doubleValue = (int) (i6 * new Rational(i7, i8).doubleValue() * new Rational(i9, i10).doubleValue());
        String format = Logger.isDebugEnabled(TAG) ? String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(doubleValue)) : "";
        if (!AudioSpec.BITRATE_RANGE_AUTO.equals(range)) {
            Integer clamp = range.clamp(Integer.valueOf(doubleValue));
            doubleValue = clamp.intValue();
            if (Logger.isDebugEnabled(TAG)) {
                format = format + String.format("\nClamped to range %s -> %dbps", range, clamp);
            }
        }
        Logger.d(TAG, format);
        return doubleValue;
    }

    private AudioConfigUtil() {
    }

    public static /* synthetic */ int a(int i6, Integer num, Integer num2) {
        float signum;
        int abs = Math.abs(num.intValue() - i6) - Math.abs(num2.intValue() - i6);
        if (abs == 0) {
            signum = Math.signum(num.intValue() - num2.intValue());
        } else {
            signum = Math.signum(abs);
        }
        return (int) signum;
    }

    @NonNull
    public static AudioEncoderConfig resolveAudioEncoderConfig(@NonNull AudioMimeInfo audioMimeInfo, @NonNull Timebase timebase, @NonNull AudioSettings audioSettings, @NonNull AudioSpec audioSpec) {
        Supplier audioEncoderConfigDefaultResolver;
        EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile = audioMimeInfo.getCompatibleAudioProfile();
        if (compatibleAudioProfile != null) {
            audioEncoderConfigDefaultResolver = new AudioEncoderConfigAudioProfileResolver(audioMimeInfo.getMimeType(), audioMimeInfo.getProfile(), timebase, audioSpec, audioSettings, compatibleAudioProfile);
        } else {
            audioEncoderConfigDefaultResolver = new AudioEncoderConfigDefaultResolver(audioMimeInfo.getMimeType(), audioMimeInfo.getProfile(), timebase, audioSpec, audioSettings);
        }
        return (AudioEncoderConfig) audioEncoderConfigDefaultResolver.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00d7  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.camera.video.internal.config.AudioMimeInfo resolveAudioMimeInfo(@androidx.annotation.NonNull androidx.camera.video.MediaSpec r8, @androidx.annotation.Nullable androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy r9) {
        /*
            int r0 = r8.getOutputFormat()
            java.lang.String r0 = androidx.camera.video.MediaSpec.outputFormatToAudioMime(r0)
            int r1 = r8.getOutputFormat()
            int r1 = androidx.camera.video.MediaSpec.outputFormatToAudioProfile(r1)
            if (r9 == 0) goto Lca
            androidx.camera.core.impl.EncoderProfilesProxy$AudioProfileProxy r2 = r9.getDefaultAudioProfile()
            if (r2 == 0) goto Lca
            androidx.camera.core.impl.EncoderProfilesProxy$AudioProfileProxy r9 = r9.getDefaultAudioProfile()
            java.lang.String r2 = r9.getMediaType()
            int r3 = r9.getProfile()
            java.lang.String r4 = "audio/none"
            boolean r4 = java.util.Objects.equals(r2, r4)
            java.lang.String r5 = ")]"
            java.lang.String r6 = "AudioConfigUtil"
            java.lang.String r7 = "(profile: "
            if (r4 == 0) goto L51
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "EncoderProfiles contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: "
            r8.append(r9)
            r8.append(r0)
            r8.append(r7)
            r8.append(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
            goto Lca
        L51:
            int r8 = r8.getOutputFormat()
            r4 = -1
            if (r8 != r4) goto L78
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "MediaSpec contains OUTPUT_FORMAT_AUTO. Using EncoderProfiles to derive AUDIO settings [mime type: "
            r8.append(r0)
            r8.append(r2)
            r8.append(r7)
            r8.append(r3)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
            r0 = r2
            r1 = r3
            goto Lcb
        L78:
            boolean r8 = java.util.Objects.equals(r0, r2)
            if (r8 == 0) goto L9f
            if (r1 != r3) goto L9f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "MediaSpec audio mime/profile matches EncoderProfiles. Using EncoderProfiles to derive AUDIO settings [mime type: "
            r8.append(r0)
            r8.append(r2)
            r8.append(r7)
            r8.append(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
            r0 = r2
            goto Lcb
        L9f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "MediaSpec audio mime or profile does not match EncoderProfiles, so EncoderProfiles settings cannot be used. May rely on fallback defaults to derive AUDIO settings [EncoderProfiles mime type: "
            r8.append(r9)
            r8.append(r2)
            r8.append(r7)
            r8.append(r3)
            java.lang.String r9 = "), chosen mime type: "
            r8.append(r9)
            r8.append(r0)
            r8.append(r7)
            r8.append(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
        Lca:
            r9 = 0
        Lcb:
            androidx.camera.video.internal.config.AudioMimeInfo$Builder r8 = androidx.camera.video.internal.config.AudioMimeInfo.builder(r0)
            java.lang.Object r8 = r8.setProfile(r1)
            androidx.camera.video.internal.config.AudioMimeInfo$Builder r8 = (androidx.camera.video.internal.config.AudioMimeInfo.Builder) r8
            if (r9 == 0) goto Lda
            r8.setCompatibleAudioProfile(r9)
        Lda:
            androidx.camera.video.internal.config.AudioMimeInfo r8 = r8.build()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.config.AudioConfigUtil.resolveAudioMimeInfo(androidx.camera.video.MediaSpec, androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy):androidx.camera.video.internal.config.AudioMimeInfo");
    }

    @NonNull
    public static AudioSettings resolveAudioSettings(@NonNull AudioMimeInfo audioMimeInfo, @NonNull AudioSpec audioSpec) {
        Supplier audioSettingsDefaultResolver;
        EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile = audioMimeInfo.getCompatibleAudioProfile();
        if (compatibleAudioProfile != null) {
            audioSettingsDefaultResolver = new AudioSettingsAudioProfileResolver(audioSpec, compatibleAudioProfile);
        } else {
            audioSettingsDefaultResolver = new AudioSettingsDefaultResolver(audioSpec);
        }
        return (AudioSettings) audioSettingsDefaultResolver.get();
    }

    static int resolveAudioSource(@NonNull AudioSpec audioSpec) {
        int source = audioSpec.getSource();
        if (source == -1) {
            Logger.d(TAG, "Using default AUDIO source: 5");
            return 5;
        }
        Logger.d(TAG, "Using provided AUDIO source: " + source);
        return source;
    }

    static int resolveAudioSourceFormat(@NonNull AudioSpec audioSpec) {
        int sourceFormat = audioSpec.getSourceFormat();
        if (sourceFormat == -1) {
            Logger.d(TAG, "Using default AUDIO source format: 2");
            return 2;
        }
        Logger.d(TAG, "Using provided AUDIO source format: " + sourceFormat);
        return sourceFormat;
    }
}
