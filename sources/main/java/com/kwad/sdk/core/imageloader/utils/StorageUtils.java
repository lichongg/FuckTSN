package com.kwad.sdk.core.imageloader.utils;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String INDIVIDUAL_DIR_NAME = "ksad-images";

    public static File getIndividualCacheDirectory(Context context, String str) {
        return getIndividualCacheDirectory(context, str, INDIVIDUAL_DIR_NAME);
    }

    public static File getIndividualCacheDirectory(Context context, String str, String str2) {
        File file = new File(str);
        File file2 = new File(str, str2);
        return (file2.exists() || file2.mkdir()) ? file2 : file;
    }

    private StorageUtils() {
    }
}
