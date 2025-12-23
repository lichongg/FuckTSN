package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class ManufacturerUtils {
    private static final String LGE = "lge";
    private static final String MEIZU = "meizu";
    private static final String SAMSUNG = "samsung";

    @NonNull
    private static String getManufacturer() {
        String str = Build.MANUFACTURER;
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    private ManufacturerUtils() {
    }

    public static boolean isDateInputKeyboardMissingSeparatorCharacters() {
        if (!isLGEDevice() && !isSamsungDevice()) {
            return false;
        }
        return true;
    }

    public static boolean isLGEDevice() {
        return getManufacturer().equals(LGE);
    }

    public static boolean isMeizuDevice() {
        return getManufacturer().equals(MEIZU);
    }

    public static boolean isSamsungDevice() {
        return getManufacturer().equals(SAMSUNG);
    }
}
