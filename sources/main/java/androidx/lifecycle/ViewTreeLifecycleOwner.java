package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import com.acse.ottn.l3;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.sequences.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "ViewTreeLifecycleOwner")
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewTreeLifecycleOwner {
    @JvmName(name = l3.f4736f)
    @Nullable
    public static final LifecycleOwner get(@NotNull View view) {
        g0.p(view, "<this>");
        return (LifecycleOwner) p.i1(p.S1(p.t(view, new Function1<View, View>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final View invoke(@NotNull View currentView) {
                g0.p(currentView, "currentView");
                Object parent = currentView.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Function1<View, LifecycleOwner>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final LifecycleOwner invoke(@NotNull View viewParent) {
                g0.p(viewParent, "viewParent");
                Object tag = viewParent.getTag(R.id.view_tree_lifecycle_owner);
                if (tag instanceof LifecycleOwner) {
                    return (LifecycleOwner) tag;
                }
                return null;
            }
        }));
    }

    @JvmName(name = l3.f4738h)
    public static final void set(@NotNull View view, @Nullable LifecycleOwner lifecycleOwner) {
        g0.p(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
