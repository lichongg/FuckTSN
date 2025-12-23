package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FragmentTransactionKt {
    @NotNull
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(@NotNull FragmentTransaction add, @IdRes int i6, @Nullable String str, @Nullable Bundle bundle) {
        g0.q(add, "$this$add");
        g0.y(4, "F");
        FragmentTransaction add2 = add.add(i6, Fragment.class, bundle, str);
        g0.h(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, int i6, String str, Bundle bundle, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str = null;
        }
        if ((i7 & 4) != 0) {
            bundle = null;
        }
        g0.q(add, "$this$add");
        g0.y(4, "F");
        FragmentTransaction add2 = add.add(i6, Fragment.class, bundle, str);
        g0.h(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    @NotNull
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(@NotNull FragmentTransaction add, @NotNull String tag, @Nullable Bundle bundle) {
        g0.q(add, "$this$add");
        g0.q(tag, "tag");
        g0.y(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        g0.h(add2, "add(F::class.java, args, tag)");
        return add2;
    }

    @NotNull
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(@NotNull FragmentTransaction replace, @IdRes int i6, @Nullable String str, @Nullable Bundle bundle) {
        g0.q(replace, "$this$replace");
        g0.y(4, "F");
        FragmentTransaction replace2 = replace.replace(i6, Fragment.class, bundle, str);
        g0.h(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction replace, int i6, String str, Bundle bundle, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str = null;
        }
        if ((i7 & 4) != 0) {
            bundle = null;
        }
        g0.q(replace, "$this$replace");
        g0.y(4, "F");
        FragmentTransaction replace2 = replace.replace(i6, Fragment.class, bundle, str);
        g0.h(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, String tag, Bundle bundle, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            bundle = null;
        }
        g0.q(add, "$this$add");
        g0.q(tag, "tag");
        g0.y(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        g0.h(add2, "add(F::class.java, args, tag)");
        return add2;
    }
}
