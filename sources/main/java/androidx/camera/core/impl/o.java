package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.ResolutionSelectorUtil;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class o {
    public static boolean a(@NonNull Config.OptionPriority optionPriority, @NonNull Config.OptionPriority optionPriority2) {
        Config.OptionPriority optionPriority3 = Config.OptionPriority.ALWAYS_OVERRIDE;
        if (optionPriority == optionPriority3 && optionPriority2 == optionPriority3) {
            return true;
        }
        Config.OptionPriority optionPriority4 = Config.OptionPriority.REQUIRED;
        return optionPriority == optionPriority4 && optionPriority2 == optionPriority4;
    }

    @NonNull
    public static Config b(@Nullable Config config, @Nullable Config config2) {
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        MutableOptionsBundle from = config2 != null ? MutableOptionsBundle.from(config2) : MutableOptionsBundle.create();
        if (config != null) {
            Iterator<Config.Option<?>> it = config.listOptions().iterator();
            while (it.hasNext()) {
                c(from, config2, config, it.next());
            }
        }
        return OptionsBundle.from(from);
    }

    public static void c(@NonNull MutableOptionsBundle mutableOptionsBundle, @NonNull Config config, @NonNull Config config2, @NonNull Config.Option<?> option) {
        if (!Objects.equals(option, ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)) {
            mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), config2.retrieveOption(option));
            return;
        }
        ResolutionSelector resolutionSelector = (ResolutionSelector) config2.retrieveOption(option, null);
        mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), ResolutionSelectorUtil.overrideResolutionSelectors((ResolutionSelector) config.retrieveOption(option, null), resolutionSelector));
    }
}
