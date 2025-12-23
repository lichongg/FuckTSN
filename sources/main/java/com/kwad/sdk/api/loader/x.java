package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class x {
    public static boolean k(File file) {
        return file != null && file.exists() && file.length() > 0 && file.getName().endsWith(".apk");
    }

    public static boolean a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(y.getFileMD5(file).toLowerCase());
    }
}
