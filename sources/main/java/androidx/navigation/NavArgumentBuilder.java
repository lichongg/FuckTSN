package androidx.navigation;

import androidx.navigation.NavArgument;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NavDestinationDsl
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavArgumentBuilder {
    private NavType<?> _type;
    private final NavArgument.Builder builder = new NavArgument.Builder();

    @Nullable
    private Object defaultValue;
    private boolean nullable;

    @NotNull
    public final NavArgument build() {
        NavArgument build = this.builder.build();
        g0.h(build, "builder.build()");
        return build;
    }

    @Nullable
    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final boolean getNullable() {
        return this.nullable;
    }

    @NotNull
    public final NavType<?> getType() {
        NavType<?> navType = this._type;
        if (navType != null) {
            return navType;
        }
        throw new IllegalStateException("NavType has not been set on this builder.");
    }

    public final void setDefaultValue(@Nullable Object obj) {
        this.defaultValue = obj;
        this.builder.setDefaultValue(obj);
    }

    public final void setNullable(boolean z5) {
        this.nullable = z5;
        this.builder.setIsNullable(z5);
    }

    public final void setType(@NotNull NavType<?> value) {
        g0.q(value, "value");
        this._type = value;
        this.builder.setType(value);
    }
}
