package androidx.navigation;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NavDestinationDsl
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavActionBuilder {

    @NotNull
    private final Map<String, Object> defaultArguments = new LinkedHashMap();
    private int destinationId;
    private NavOptions navOptions;

    @NotNull
    public final NavAction build$navigation_common_ktx_release() {
        Bundle bundleOf;
        int i6 = this.destinationId;
        NavOptions navOptions = this.navOptions;
        if (this.defaultArguments.isEmpty()) {
            bundleOf = null;
        } else {
            Object[] array = i1.J1(this.defaultArguments).toArray(new Pair[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Pair[] pairArr = (Pair[]) array;
            bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        }
        return new NavAction(i6, navOptions, bundleOf);
    }

    @NotNull
    public final Map<String, Object> getDefaultArguments() {
        return this.defaultArguments;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final void navOptions(@NotNull Function1<? super NavOptionsBuilder, n1> optionsBuilder) {
        g0.q(optionsBuilder, "optionsBuilder");
        NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
        optionsBuilder.invoke(navOptionsBuilder);
        this.navOptions = navOptionsBuilder.build$navigation_common_ktx_release();
    }

    public final void setDestinationId(int i6) {
        this.destinationId = i6;
    }
}
