package androidx.navigation;

import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.ActivityNavigator;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ActivityNavigatorExtrasKt {
    @NotNull
    public static final ActivityNavigator.Extras ActivityNavigatorExtras(@Nullable ActivityOptionsCompat activityOptionsCompat, int i6) {
        ActivityNavigator.Extras.Builder builder = new ActivityNavigator.Extras.Builder();
        if (activityOptionsCompat != null) {
            builder.setActivityOptions(activityOptionsCompat);
        }
        builder.addFlags(i6);
        ActivityNavigator.Extras build = builder.build();
        g0.h(build, "ActivityNavigator.Extras…(flags)\n        }.build()");
        return build;
    }

    public static /* synthetic */ ActivityNavigator.Extras ActivityNavigatorExtras$default(ActivityOptionsCompat activityOptionsCompat, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            activityOptionsCompat = null;
        }
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return ActivityNavigatorExtras(activityOptionsCompat, i6);
    }
}
