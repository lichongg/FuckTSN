package androidx.lifecycle;

import android.app.Application;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class AndroidViewModel extends ViewModel {

    @NotNull
    private final Application application;

    public AndroidViewModel(@NotNull Application application) {
        g0.p(application, "application");
        this.application = application;
    }

    @NotNull
    public <T extends Application> T getApplication() {
        T t5 = (T) this.application;
        g0.n(t5, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t5;
    }
}
