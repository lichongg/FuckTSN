package com.orhanobut.logger;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i implements h {

    /* renamed from: a, reason: collision with root package name */
    static final String f36482a = "NO_TAG";

    @Override // com.orhanobut.logger.h
    public void a(int i6, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        if (str == null) {
            str = f36482a;
        }
        Log.println(i6, str, str2);
    }
}
