package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface UseCaseEventConfig extends ReadableConfig {
    public static final Config.Option<UseCase.EventCallback> OPTION_USE_CASE_EVENT_CALLBACK = Config.Option.create("camerax.core.useCaseEventCallback", UseCase.EventCallback.class);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Builder<B> {
        @NonNull
        B setUseCaseEventCallback(@NonNull UseCase.EventCallback eventCallback);
    }

    @NonNull
    UseCase.EventCallback getUseCaseEventCallback();

    @Nullable
    UseCase.EventCallback getUseCaseEventCallback(@Nullable UseCase.EventCallback eventCallback);
}
