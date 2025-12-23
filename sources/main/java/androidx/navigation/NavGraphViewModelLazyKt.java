package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavGraphViewModelLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> s<VM> navGraphViewModels(@NotNull Fragment navGraphViewModels, @IdRes int i6, @Nullable Function0<? extends ViewModelProvider.Factory> function0) {
        g0.q(navGraphViewModels, "$this$navGraphViewModels");
        s c6 = t.c(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(navGraphViewModels, i6));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(c6, null);
        g0.y(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(navGraphViewModels, o0.d(ViewModel.class), navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, new NavGraphViewModelLazyKt$navGraphViewModels$1(function0, c6, null));
    }

    public static /* synthetic */ s navGraphViewModels$default(Fragment navGraphViewModels, int i6, Function0 function0, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            function0 = null;
        }
        g0.q(navGraphViewModels, "$this$navGraphViewModels");
        s c6 = t.c(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(navGraphViewModels, i6));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(c6, null);
        g0.y(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(navGraphViewModels, o0.d(ViewModel.class), navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, new NavGraphViewModelLazyKt$navGraphViewModels$1(function0, c6, null));
    }
}
