package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface Config {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    public static abstract class Option<T> {
        @NonNull
        public static <T> Option<T> create(@NonNull String str, @NonNull Class<?> cls) {
            return create(str, cls, null);
        }

        @NonNull
        public abstract String getId();

        @Nullable
        public abstract Object getToken();

        @NonNull
        public abstract Class<T> getValueClass();

        @NonNull
        public static <T> Option<T> create(@NonNull String str, @NonNull Class<?> cls, @Nullable Object obj) {
            return new AutoValue_Config_Option(str, cls, obj);
        }

        Option() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OptionMatcher {
        boolean onOptionMatched(@NonNull Option<?> option);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        REQUIRED,
        OPTIONAL
    }

    boolean containsOption(@NonNull Option<?> option);

    void findOptions(@NonNull String str, @NonNull OptionMatcher optionMatcher);

    @NonNull
    OptionPriority getOptionPriority(@NonNull Option<?> option);

    @NonNull
    Set<OptionPriority> getPriorities(@NonNull Option<?> option);

    @NonNull
    Set<Option<?>> listOptions();

    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Option<ValueT> option);

    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Option<ValueT> option, @Nullable ValueT valuet);

    @Nullable
    <ValueT> ValueT retrieveOptionWithPriority(@NonNull Option<ValueT> option, @NonNull OptionPriority optionPriority);
}
