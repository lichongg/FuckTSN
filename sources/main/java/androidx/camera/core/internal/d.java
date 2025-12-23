package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class d {
    @NonNull
    public static Class a(TargetConfig targetConfig) {
        return (Class) targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
    }

    @Nullable
    public static Class b(TargetConfig targetConfig, @Nullable Class cls) {
        return (Class) targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, cls);
    }

    @NonNull
    public static String c(TargetConfig targetConfig) {
        return (String) targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
    }

    @Nullable
    public static String d(TargetConfig targetConfig, @Nullable String str) {
        return (String) targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_NAME, str);
    }
}
