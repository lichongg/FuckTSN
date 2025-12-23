package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavGraphKt {
    public static final void plusAssign(@NotNull NavGraph plusAssign, @NotNull NavDestination node) {
        g0.q(plusAssign, "$this$plusAssign");
        g0.q(node, "node");
        plusAssign.addDestination(node);
    }

    public static final boolean contains(@NotNull NavGraph contains, @IdRes int i6) {
        g0.q(contains, "$this$contains");
        return contains.findNode(i6) != null;
    }

    @NotNull
    public static final NavDestination get(@NotNull NavGraph get, @IdRes int i6) {
        g0.q(get, "$this$get");
        NavDestination findNode = get.findNode(i6);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + i6 + " was found in " + get);
    }

    public static final void minusAssign(@NotNull NavGraph minusAssign, @NotNull NavDestination node) {
        g0.q(minusAssign, "$this$minusAssign");
        g0.q(node, "node");
        minusAssign.remove(node);
    }

    public static final void plusAssign(@NotNull NavGraph plusAssign, @NotNull NavGraph other) {
        g0.q(plusAssign, "$this$plusAssign");
        g0.q(other, "other");
        plusAssign.addAll(other);
    }
}
