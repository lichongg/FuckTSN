package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes.dex */
public class ViewModelStores {
    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelStore of(@NonNull FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelStore of(@NonNull Fragment fragment) {
        return fragment.getViewModelStore();
    }

    private ViewModelStores() {
    }
}
