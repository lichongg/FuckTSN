package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface ReadableConfig extends Config {
    @Override // androidx.camera.core.impl.Config
    boolean containsOption(@NonNull Config.Option<?> option);

    @Override // androidx.camera.core.impl.Config
    void findOptions(@NonNull String str, @NonNull Config.OptionMatcher optionMatcher);

    @NonNull
    Config getConfig();

    @Override // androidx.camera.core.impl.Config
    @NonNull
    Config.OptionPriority getOptionPriority(@NonNull Config.Option<?> option);

    @Override // androidx.camera.core.impl.Config
    @NonNull
    Set<Config.OptionPriority> getPriorities(@NonNull Config.Option<?> option);

    @Override // androidx.camera.core.impl.Config
    @NonNull
    Set<Config.Option<?>> listOptions();

    @Override // androidx.camera.core.impl.Config
    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option);

    @Override // androidx.camera.core.impl.Config
    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet);

    @Override // androidx.camera.core.impl.Config
    @Nullable
    <ValueT> ValueT retrieveOptionWithPriority(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority);
}
