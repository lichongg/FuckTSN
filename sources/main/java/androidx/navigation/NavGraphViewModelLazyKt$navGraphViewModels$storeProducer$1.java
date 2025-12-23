package androidx.navigation;

import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.reflect.n;
import kotlin.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ s $backStackEntry;
    final /* synthetic */ n $backStackEntry$metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(s sVar, n nVar) {
        super(0);
        this.$backStackEntry = sVar;
        this.$backStackEntry$metadata = nVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewModelStore invoke() {
        NavBackStackEntry backStackEntry = (NavBackStackEntry) this.$backStackEntry.getValue();
        g0.h(backStackEntry, "backStackEntry");
        ViewModelStore viewModelStore = backStackEntry.getViewModelStore();
        g0.h(viewModelStore, "backStackEntry.viewModelStore");
        return viewModelStore;
    }
}
