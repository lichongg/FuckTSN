package com.baidu.idl.face.platform.common;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class SharedPrefHelper {
    private static final String SHARED_PREFERENCES_NAME_FACE_VALUE = "face_sdk_value";

    private static SharedPreferences getPref(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME_FACE_VALUE, 0);
    }

    private SharedPrefHelper() {
    }
}
