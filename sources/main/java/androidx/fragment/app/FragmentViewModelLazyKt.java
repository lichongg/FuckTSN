package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.d;
import kotlin.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FragmentViewModelLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> s<VM> activityViewModels(@NotNull Fragment activityViewModels, @Nullable Function0<? extends ViewModelProvider.Factory> function0) {
        g0.q(activityViewModels, "$this$activityViewModels");
        g0.y(4, "VM");
        d d6 = o0.d(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, d6, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static /* synthetic */ s activityViewModels$default(Fragment activityViewModels, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function0 = null;
        }
        g0.q(activityViewModels, "$this$activityViewModels");
        g0.y(4, "VM");
        d d6 = o0.d(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, d6, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    @MainThread
    @NotNull
    public static final <VM extends ViewModel> s<VM> createViewModelLazy(@NotNull final Fragment createViewModelLazy, @NotNull d<VM> viewModelClass, @NotNull Function0<? extends ViewModelStore> storeProducer, @Nullable Function0<? extends ViewModelProvider.Factory> function0) {
        g0.q(createViewModelLazy, "$this$createViewModelLazy");
        g0.q(viewModelClass, "viewModelClass");
        g0.q(storeProducer, "storeProducer");
        if (function0 == null) {
            function0 = new Function0<ViewModelProvider.Factory>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ViewModelProvider.Factory invoke() {
                    ViewModelProvider.Factory defaultViewModelProviderFactory = Fragment.this.getDefaultViewModelProviderFactory();
                    g0.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, function0);
    }

    public static /* synthetic */ s createViewModelLazy$default(Fragment fragment, d dVar, Function0 function0, Function0 function02, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            function02 = null;
        }
        return createViewModelLazy(fragment, dVar, function0, function02);
    }

    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> s<VM> viewModels(@NotNull Fragment viewModels, @NotNull Function0<? extends ViewModelStoreOwner> ownerProducer, @Nullable Function0<? extends ViewModelProvider.Factory> function0) {
        g0.q(viewModels, "$this$viewModels");
        g0.q(ownerProducer, "ownerProducer");
        g0.y(4, "VM");
        return createViewModelLazy(viewModels, o0.d(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), function0);
    }

    public static /* synthetic */ s viewModels$default(final Fragment viewModels, Function0 ownerProducer, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            ownerProducer = new Function0<Fragment>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Fragment invoke() {
                    return Fragment.this;
                }
            };
        }
        if ((i6 & 2) != 0) {
            function0 = null;
        }
        g0.q(viewModels, "$this$viewModels");
        g0.q(ownerProducer, "ownerProducer");
        g0.y(4, "VM");
        return createViewModelLazy(viewModels, o0.d(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), function0);
    }
}
