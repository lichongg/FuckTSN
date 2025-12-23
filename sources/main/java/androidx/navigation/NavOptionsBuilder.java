package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.navigation.NavOptions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NavOptionsDsl
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavOptionsBuilder {
    private boolean inclusive;
    private boolean launchSingleTop;
    private final NavOptions.Builder builder = new NavOptions.Builder();

    @IdRes
    private int popUpTo = -1;

    public final void anim(@NotNull Function1<? super AnimBuilder, n1> animBuilder) {
        g0.q(animBuilder, "animBuilder");
        AnimBuilder animBuilder2 = new AnimBuilder();
        animBuilder.invoke(animBuilder2);
        this.builder.setEnterAnim(animBuilder2.getEnter()).setExitAnim(animBuilder2.getExit()).setPopEnterAnim(animBuilder2.getPopEnter()).setPopExitAnim(animBuilder2.getPopExit());
    }

    @NotNull
    public final NavOptions build$navigation_common_ktx_release() {
        NavOptions.Builder builder = this.builder;
        builder.setLaunchSingleTop(this.launchSingleTop);
        builder.setPopUpTo(this.popUpTo, this.inclusive);
        NavOptions build = builder.build();
        g0.h(build, "builder.apply {\n        … inclusive)\n    }.build()");
        return build;
    }

    public final boolean getLaunchSingleTop() {
        return this.launchSingleTop;
    }

    public final int getPopUpTo() {
        return this.popUpTo;
    }

    public final void popUpTo(@IdRes int i6, @NotNull Function1<? super PopUpToBuilder, n1> popUpToBuilder) {
        g0.q(popUpToBuilder, "popUpToBuilder");
        setPopUpTo(i6);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.inclusive = popUpToBuilder2.getInclusive();
    }

    public final void setLaunchSingleTop(boolean z5) {
        this.launchSingleTop = z5;
    }

    public final void setPopUpTo(int i6) {
        this.popUpTo = i6;
        this.inclusive = false;
    }
}
