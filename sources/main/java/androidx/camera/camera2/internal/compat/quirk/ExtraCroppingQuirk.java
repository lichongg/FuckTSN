package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.SurfaceConfig;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ExtraCroppingQuirk implements Quirk {
    private static final Map<String, Range<Integer>> SAMSUNG_DISTORTION_MODELS_TO_API_LEVEL_MAP;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType;

        static {
            int[] iArr = new int[SurfaceConfig.ConfigType.values().length];
            $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType = iArr;
            try {
                iArr[SurfaceConfig.ConfigType.PRIV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType[SurfaceConfig.ConfigType.YUV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType[SurfaceConfig.ConfigType.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        SAMSUNG_DISTORTION_MODELS_TO_API_LEVEL_MAP = hashMap;
        hashMap.put("SM-T580", null);
        hashMap.put("SM-J710MN", new Range(21, 26));
        hashMap.put("SM-A320FL", null);
        hashMap.put("SM-G570M", null);
        hashMap.put("SM-G610F", null);
        hashMap.put("SM-G610M", new Range(21, 26));
    }

    private static boolean isSamsungDistortion() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        Map<String, Range<Integer>> map = SAMSUNG_DISTORTION_MODELS_TO_API_LEVEL_MAP;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        if (!map.containsKey(str.toUpperCase(locale))) {
            return false;
        }
        Range<Integer> range = map.get(str.toUpperCase(locale));
        if (range == null) {
            return true;
        }
        return range.contains((Range<Integer>) Integer.valueOf(Build.VERSION.SDK_INT));
    }

    static boolean load() {
        return isSamsungDistortion();
    }

    @Nullable
    public Size getVerifiedResolution(@NonNull SurfaceConfig.ConfigType configType) {
        if (!isSamsungDistortion()) {
            return null;
        }
        int i6 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$SurfaceConfig$ConfigType[configType.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    return null;
                }
                return new Size(3264, 1836);
            }
            return new Size(PredefinedCaptureConfigurations.f35648o, PredefinedCaptureConfigurations.f35647n);
        }
        return new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s);
    }
}
