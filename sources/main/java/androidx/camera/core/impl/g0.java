package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class g0 {
    public static boolean a(ReadableConfig readableConfig, @NonNull Config.Option option) {
        return readableConfig.getConfig().containsOption(option);
    }

    public static void b(ReadableConfig readableConfig, @NonNull String str, @NonNull Config.OptionMatcher optionMatcher) {
        readableConfig.getConfig().findOptions(str, optionMatcher);
    }

    @NonNull
    public static Config.OptionPriority c(ReadableConfig readableConfig, @NonNull Config.Option option) {
        return readableConfig.getConfig().getOptionPriority(option);
    }

    @NonNull
    public static Set d(ReadableConfig readableConfig, @NonNull Config.Option option) {
        return readableConfig.getConfig().getPriorities(option);
    }

    @NonNull
    public static Set e(ReadableConfig readableConfig) {
        return readableConfig.getConfig().listOptions();
    }

    @Nullable
    public static Object f(ReadableConfig readableConfig, @NonNull Config.Option option) {
        return readableConfig.getConfig().retrieveOption(option);
    }

    @Nullable
    public static Object g(ReadableConfig readableConfig, @NonNull Config.Option option, @Nullable Object obj) {
        return readableConfig.getConfig().retrieveOption(option, obj);
    }

    @Nullable
    public static Object h(ReadableConfig readableConfig, @NonNull Config.Option option, @NonNull Config.OptionPriority optionPriority) {
        return readableConfig.getConfig().retrieveOptionWithPriority(option, optionPriority);
    }
}
