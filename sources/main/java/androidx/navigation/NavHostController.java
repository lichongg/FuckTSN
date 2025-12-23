package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class NavHostController extends NavController {
    public NavHostController(@NonNull Context context) {
        super(context);
    }

    @Override // androidx.navigation.NavController
    public final void enableOnBackPressed(boolean z5) {
        super.enableOnBackPressed(z5);
    }

    @Override // androidx.navigation.NavController
    public final void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.navigation.NavController
    public final void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher onBackPressedDispatcher) {
        super.setOnBackPressedDispatcher(onBackPressedDispatcher);
    }

    @Override // androidx.navigation.NavController
    public final void setViewModelStore(@NonNull ViewModelStore viewModelStore) {
        super.setViewModelStore(viewModelStore);
    }
}
