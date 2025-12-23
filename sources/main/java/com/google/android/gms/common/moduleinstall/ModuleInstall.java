package com.google.android.gms.common.moduleinstall;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.moduleinstall.internal.zay;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ModuleInstall {
    @NonNull
    public static ModuleInstallClient getClient(@NonNull Activity activity) {
        return new zay(activity);
    }

    @NonNull
    public static ModuleInstallClient getClient(@NonNull Context context) {
        return new zay(context);
    }

    private ModuleInstall() {
    }
}
