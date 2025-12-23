package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.EncoderProfilesProxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class x {
    public static int b(int i6) {
        if (i6 == 3) {
            return 2;
        }
        if (i6 != 4) {
            return i6 != 5 ? -1 : 39;
        }
        return 5;
    }

    @NonNull
    public static String a(int i6) {
        switch (i6) {
            case 1:
                return "audio/3gpp";
            case 2:
                return "audio/amr-wb";
            case 3:
            case 4:
            case 5:
                return "audio/mp4a-latm";
            case 6:
                return "audio/vorbis";
            case 7:
                return "audio/opus";
            default:
                return EncoderProfilesProxy.AudioProfileProxy.MEDIA_TYPE_NONE;
        }
    }

    @NonNull
    public static String c(int i6) {
        switch (i6) {
            case 1:
                return "video/3gpp";
            case 2:
                return "video/avc";
            case 3:
                return "video/mp4v-es";
            case 4:
                return "video/x-vnd.on2.vp8";
            case 5:
                return "video/hevc";
            case 6:
                return "video/x-vnd.on2.vp9";
            case 7:
                return "video/dolby-vision";
            case 8:
                return "video/av01";
            default:
                return EncoderProfilesProxy.VideoProfileProxy.MEDIA_TYPE_NONE;
        }
    }
}
