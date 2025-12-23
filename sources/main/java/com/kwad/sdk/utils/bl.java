package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bl {
    private static String TAG = "plugin.signature";
    public static Signature[] currentSignatures = new Signature[0];

    public static String getSignMd5Str(Context context) {
        try {
            Signature[] signatures = getSignatures(context);
            if (signatures != null && signatures.length > 0) {
                return al.md5ForByte(signatures[0].toByteArray());
            }
            return "";
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w(TAG, e6);
            return "";
        }
    }

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    private static Signature[] getSignatures(Context context) {
        Signature[] signatureArr = currentSignatures;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        PackageInfo packageInfo = y.getPackageInfo(context, context.getPackageName(), 64);
        if (packageInfo != null) {
            currentSignatures = packageInfo.signatures;
        }
        return currentSignatures;
    }
}
