package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface CameraConfig extends ReadableConfig {
    public static final int REQUIRED_RULE_COEXISTING_PREVIEW_AND_IMAGE_CAPTURE = 1;
    public static final int REQUIRED_RULE_NONE = 0;
    public static final Config.Option<UseCaseConfigFactory> OPTION_USECASE_CONFIG_FACTORY = Config.Option.create("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);
    public static final Config.Option<Identifier> OPTION_COMPATIBILITY_ID = Config.Option.create("camerax.core.camera.compatibilityId", Identifier.class);
    public static final Config.Option<Integer> OPTION_USE_CASE_COMBINATION_REQUIRED_RULE = Config.Option.create("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);
    public static final Config.Option<SessionProcessor> OPTION_SESSION_PROCESSOR = Config.Option.create("camerax.core.camera.SessionProcessor", SessionProcessor.class);
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.camera.isZslDisabled", Boolean.class);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Builder<B> {
        @NonNull
        B setCompatibilityId(@NonNull Identifier identifier);

        @NonNull
        B setSessionProcessor(@NonNull SessionProcessor sessionProcessor);

        @NonNull
        B setUseCaseCombinationRequiredRule(int i6);

        @NonNull
        B setUseCaseConfigFactory(@NonNull UseCaseConfigFactory useCaseConfigFactory);

        @NonNull
        B setZslDisabled(boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequiredRule {
    }

    @NonNull
    Identifier getCompatibilityId();

    @NonNull
    SessionProcessor getSessionProcessor();

    @Nullable
    SessionProcessor getSessionProcessor(@Nullable SessionProcessor sessionProcessor);

    int getUseCaseCombinationRequiredRule();

    @NonNull
    UseCaseConfigFactory getUseCaseConfigFactory();
}
