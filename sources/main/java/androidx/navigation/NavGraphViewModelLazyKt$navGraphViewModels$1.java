package androidx.navigation;

import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.reflect.n;
import kotlin.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$1 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ s $backStackEntry;
    final /* synthetic */ n $backStackEntry$metadata;
    final /* synthetic */ Function0 $factoryProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$1(Function0 function0, s sVar, n nVar) {
        super(0);
        this.$factoryProducer = function0;
        this.$backStackEntry = sVar;
        this.$backStackEntry$metadata = nVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory factory;
        Function0 function0 = this.$factoryProducer;
        if (function0 != null && (factory = (ViewModelProvider.Factory) function0.invoke()) != null) {
            return factory;
        }
        NavBackStackEntry backStackEntry = (NavBackStackEntry) this.$backStackEntry.getValue();
        g0.h(backStackEntry, "backStackEntry");
        ViewModelProvider.Factory defaultViewModelProviderFactory = backStackEntry.getDefaultViewModelProviderFactory();
        g0.h(defaultViewModelProviderFactory, "backStackEntry.defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
