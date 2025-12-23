package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface MutableConfig extends Config {
    <ValueT> void insertOption(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority, @Nullable ValueT valuet);

    <ValueT> void insertOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet);

    @Nullable
    <ValueT> ValueT removeOption(@NonNull Config.Option<ValueT> option);
}
