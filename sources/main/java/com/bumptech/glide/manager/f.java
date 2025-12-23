package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f implements d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15800a = "ConnectivityMonitor";

    /* renamed from: b, reason: collision with root package name */
    private static final String f15801b = "android.permission.ACCESS_NETWORK_STATE";

    @Override // com.bumptech.glide.manager.d
    @NonNull
    public c a(@NonNull Context context, @NonNull c.a aVar) {
        boolean z5 = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        Log.isLoggable(f15800a, 3);
        return z5 ? new e(context, aVar) : new n();
    }
}
