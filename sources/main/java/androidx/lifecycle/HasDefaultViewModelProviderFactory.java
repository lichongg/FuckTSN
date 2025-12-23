package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface HasDefaultViewModelProviderFactory {
    @NotNull
    CreationExtras getDefaultViewModelCreationExtras();

    @NotNull
    ViewModelProvider.Factory getDefaultViewModelProviderFactory();
}
