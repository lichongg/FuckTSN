package androidx.customview.poolingcontainer;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import java.util.Iterator;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "PoolingContainer")
/* loaded from: D:\Downloads\app\classes.dex */
public final class PoolingContainer {
    private static final int PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;
    private static final int IsPoolingContainerTag = R.id.is_pooling_container_tag;

    @SuppressLint({"ExecutorRegistration"})
    public static final void addPoolingContainerListener(@NotNull View view, @NotNull PoolingContainerListener listener) {
        g0.p(view, "<this>");
        g0.p(listener, "listener");
        getPoolingContainerListenerHolder(view).addListener(listener);
    }

    public static final void callPoolingContainerOnRelease(@NotNull View view) {
        g0.p(view, "<this>");
        Iterator<View> it = ViewKt.getAllViews(view).iterator();
        while (it.hasNext()) {
            getPoolingContainerListenerHolder(it.next()).onRelease();
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(@NotNull ViewGroup viewGroup) {
        g0.p(viewGroup, "<this>");
        Iterator<View> it = ViewGroupKt.getChildren(viewGroup).iterator();
        while (it.hasNext()) {
            getPoolingContainerListenerHolder(it.next()).onRelease();
        }
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View view) {
        int i6 = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i6);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i6, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final boolean isPoolingContainer(@NotNull View view) {
        g0.p(view, "<this>");
        Object tag = view.getTag(IsPoolingContainerTag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isWithinPoolingContainer(@NotNull View view) {
        g0.p(view, "<this>");
        for (Object obj : ViewKt.getAncestors(view)) {
            if ((obj instanceof View) && isPoolingContainer((View) obj)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void removePoolingContainerListener(@NotNull View view, @NotNull PoolingContainerListener listener) {
        g0.p(view, "<this>");
        g0.p(listener, "listener");
        getPoolingContainerListenerHolder(view).removeListener(listener);
    }

    public static final void setPoolingContainer(@NotNull View view, boolean z5) {
        g0.p(view, "<this>");
        view.setTag(IsPoolingContainerTag, Boolean.valueOf(z5));
    }
}
