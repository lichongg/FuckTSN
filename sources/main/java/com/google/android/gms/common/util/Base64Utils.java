package com.google.android.gms.common.util;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Base64Utils {
    @NonNull
    @KeepForSdk
    public static byte[] decode(@NonNull String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    @NonNull
    @KeepForSdk
    public static byte[] decodeUrlSafe(@NonNull String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 10);
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static byte[] decodeUrlSafeNoPadding(@NonNull String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 11);
    }

    @NonNull
    @KeepForSdk
    public static String encode(@NonNull byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    @NonNull
    @KeepForSdk
    public static String encodeUrlSafe(@NonNull byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }

    @NonNull
    @KeepForSdk
    public static String encodeUrlSafeNoPadding(@NonNull byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }
}
