package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FragmentViewModelLazyKt$activityViewModels$1 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewModelStore invoke() {
        FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
        g0.h(requireActivity, "requireActivity()");
        ViewModelStore viewModelStore = requireActivity.getViewModelStore();
        g0.h(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
