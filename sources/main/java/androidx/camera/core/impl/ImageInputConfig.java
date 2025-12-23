package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.Config;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface ImageInputConfig extends ReadableConfig {
    public static final Config.Option<Integer> OPTION_INPUT_FORMAT = Config.Option.create("camerax.core.imageInput.inputFormat", Integer.TYPE);
    public static final Config.Option<DynamicRange> OPTION_INPUT_DYNAMIC_RANGE = Config.Option.create("camerax.core.imageInput.inputDynamicRange", DynamicRange.class);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Builder<B> {
        @NonNull
        B setDynamicRange(@NonNull DynamicRange dynamicRange);
    }

    @NonNull
    DynamicRange getDynamicRange();

    int getInputFormat();

    boolean hasDynamicRange();
}
