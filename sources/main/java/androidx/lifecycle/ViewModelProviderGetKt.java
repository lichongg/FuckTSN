package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "ViewModelProviderGetKt")
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewModelProviderGetKt {
    @NotNull
    public static final CreationExtras defaultCreationExtras(@NotNull ViewModelStoreOwner owner) {
        g0.p(owner, "owner");
        return owner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        g0.p(viewModelProvider, "<this>");
        g0.y(4, "VM");
        return (VM) viewModelProvider.get(ViewModel.class);
    }
}
