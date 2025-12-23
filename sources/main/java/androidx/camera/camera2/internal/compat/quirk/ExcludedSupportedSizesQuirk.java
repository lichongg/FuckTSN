package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ExcludedSupportedSizesQuirk implements Quirk {
    private static final String TAG = "ExcludedSupportedSizesQuirk";
    private static final int UNKNOWN_IMAGE_FORMAT = -1;

    @NonNull
    public List<Size> getExcludedSizes(@NonNull String str, int i6) {
        if (isOnePlus6()) {
            return getOnePlus6ExcludedSizes(str, i6);
        }
        if (isOnePlus6T()) {
            return getOnePlus6TExcludedSizes(str, i6);
        }
        if (isHuaweiP20Lite()) {
            return getHuaweiP20LiteExcludedSizes(str, i6, null);
        }
        if (isSamsungJ7PrimeApi27Above()) {
            return getSamsungJ7PrimeApi27AboveExcludedSizes(str, i6, null);
        }
        if (isSamsungJ7Api27Above()) {
            return getSamsungJ7Api27AboveExcludedSizes(str, i6, null);
        }
        if (isRedmiNote9Pro()) {
            return getRedmiNote9ProExcludedSizes(str, i6);
        }
        Logger.w(TAG, "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.EMPTY_LIST;
    }

    @NonNull
    private List<Size> getHuaweiP20LiteExcludedSizes(@NonNull String str, int i6, @Nullable Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && (i6 == 34 || i6 == 35 || cls != null)) {
            arrayList.add(new Size(PredefinedCaptureConfigurations.f35647n, PredefinedCaptureConfigurations.f35647n));
            arrayList.add(new Size(400, 400));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getOnePlus6ExcludedSizes(@NonNull String str, int i6) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && i6 == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(4000, 3000));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getOnePlus6TExcludedSizes(@NonNull String str, int i6) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && i6 == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(4000, 3000));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getRedmiNote9ProExcludedSizes(@NonNull String str, int i6) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && i6 == 256) {
            arrayList.add(new Size(9280, 6944));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getSamsungJ7Api27AboveExcludedSizes(@NonNull String str, int i6, @Nullable Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0")) {
            if (i6 == 34 || cls != null) {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s));
                return arrayList;
            }
            if (i6 == 35) {
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s));
                return arrayList;
            }
        } else if (str.equals("1") && (i6 == 34 || i6 == 35 || cls != null)) {
            arrayList.add(new Size(2576, 1932));
            arrayList.add(new Size(PredefinedCaptureConfigurations.f35658y, PredefinedCaptureConfigurations.f35657x));
            arrayList.add(new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35653t));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getSamsungJ7PrimeApi27AboveExcludedSizes(@NonNull String str, int i6, @Nullable Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0")) {
            if (i6 == 34 || cls != null) {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s));
                return arrayList;
            }
            if (i6 == 35) {
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s));
                return arrayList;
            }
        } else if (str.equals("1") && (i6 == 34 || i6 == 35 || cls != null)) {
            arrayList.add(new Size(3264, 2448));
            arrayList.add(new Size(3264, 1836));
            arrayList.add(new Size(2448, 2448));
            arrayList.add(new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35653t));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s));
        }
        return arrayList;
    }

    private static boolean isHuaweiP20Lite() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "HWANE".equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean isOnePlus6() {
        return "OnePlus".equalsIgnoreCase(Build.BRAND) && "OnePlus6".equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean isOnePlus6T() {
        return "OnePlus".equalsIgnoreCase(Build.BRAND) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean isRedmiNote9Pro() {
        return "REDMI".equalsIgnoreCase(Build.BRAND) && "joyeuse".equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean isSamsungJ7Api27Above() {
        return "SAMSUNG".equalsIgnoreCase(Build.BRAND) && "J7XELTE".equalsIgnoreCase(Build.DEVICE) && Build.VERSION.SDK_INT >= 27;
    }

    private static boolean isSamsungJ7PrimeApi27Above() {
        return "SAMSUNG".equalsIgnoreCase(Build.BRAND) && "ON7XELTE".equalsIgnoreCase(Build.DEVICE) && Build.VERSION.SDK_INT >= 27;
    }

    static boolean load() {
        if (!isOnePlus6() && !isOnePlus6T() && !isHuaweiP20Lite() && !isSamsungJ7PrimeApi27Above() && !isSamsungJ7Api27Above() && !isRedmiNote9Pro()) {
            return false;
        }
        return true;
    }

    @NonNull
    public List<Size> getExcludedSizes(@NonNull String str, @NonNull Class<?> cls) {
        if (isHuaweiP20Lite()) {
            return getHuaweiP20LiteExcludedSizes(str, -1, cls);
        }
        if (isSamsungJ7PrimeApi27Above()) {
            return getSamsungJ7PrimeApi27AboveExcludedSizes(str, -1, cls);
        }
        if (isSamsungJ7Api27Above()) {
            return getSamsungJ7Api27AboveExcludedSizes(str, -1, cls);
        }
        Logger.w(TAG, "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.EMPTY_LIST;
    }
}
