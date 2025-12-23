package androidx.camera.video.internal.compat.quirk;

import android.media.MediaFormat;
import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class MediaCodecInfoReportIncorrectInfoQuirk implements Quirk {
    public static final List<String> INCORRECT_FHD_PROFILE_MODEL_LIST = Arrays.asList("lg-k430", "redmi note 4", "m2003j15sc", "rmx3231", "v2117", "sm-a032f", "moto g(20)", "sm-a035m");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class MediaFormatResolver {
        private final MediaFormat mMediaFormat;

        @Nullable
        private String getMime() {
            return this.mMediaFormat.getString(IMediaFormat.KEY_MIME);
        }

        boolean isSize(int i6, int i7) {
            return this.mMediaFormat.getInteger("width") == i6 && this.mMediaFormat.getInteger("height") == i7;
        }

        MediaFormatResolver(@NonNull MediaFormat mediaFormat) {
            this.mMediaFormat = mediaFormat;
        }

        boolean isAvc() {
            return "video/avc".equalsIgnoreCase(getMime());
        }

        boolean isMpeg4() {
            return "video/mp4v-es".equalsIgnoreCase(getMime());
        }

        boolean isVideo() {
            String mime = getMime();
            if (mime != null && mime.contains("video/")) {
                return true;
            }
            return false;
        }
    }

    private static boolean isFHDProblematicDevice() {
        return INCORRECT_FHD_PROFILE_MODEL_LIST.contains(Build.MODEL.toLowerCase(Locale.US));
    }

    private static boolean isHuaweiMate9() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isMotoC() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isNokia1() {
        return "Nokia".equalsIgnoreCase(Build.BRAND) && "Nokia 1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isPositivoTwist2Pro() {
        return "positivo".equalsIgnoreCase(Build.BRAND) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isRedmiNote8Pro() {
        return "Redmi".equalsIgnoreCase(Build.BRAND) && "Redmi Note 8 Pro".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isX230() {
        return "LGE".equalsIgnoreCase(Build.BRAND) && "LG-X230".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isX650() {
        return "infinix".equalsIgnoreCase(Build.BRAND) && "infinix x650".equalsIgnoreCase(Build.MODEL);
    }

    public boolean isUnSupportMediaCodecInfo(@NonNull MediaFormat mediaFormat) {
        MediaFormatResolver mediaFormatResolver = new MediaFormatResolver(mediaFormat);
        return (isNokia1() || isMotoC() || isX650() || isX230() || isPositivoTwist2Pro()) ? mediaFormatResolver.isMpeg4() : (isHuaweiMate9() || isRedmiNote8Pro()) ? mediaFormatResolver.isVideo() && mediaFormatResolver.isSize(PredefinedCaptureConfigurations.D, PredefinedCaptureConfigurations.C) : isFHDProblematicDevice() && mediaFormatResolver.isAvc() && mediaFormatResolver.isSize(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s);
    }

    @NonNull
    public static Set<Size> getExtraSupportedSizes() {
        if (isFHDProblematicDevice()) {
            return Collections.singleton(new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s));
        }
        return Collections.EMPTY_SET;
    }

    static boolean load() {
        if (!isNokia1() && !isMotoC() && !isX650() && !isX230() && !isHuaweiMate9() && !isRedmiNote8Pro() && !isPositivoTwist2Pro() && !isFHDProblematicDevice()) {
            return false;
        }
        return true;
    }
}
