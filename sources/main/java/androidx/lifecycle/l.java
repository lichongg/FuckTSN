package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class l {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    @NotNull
    public static ViewModel a(ViewModelProvider.Factory factory, @NotNull Class modelClass) {
        g0.p(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @NotNull
    public static ViewModel b(ViewModelProvider.Factory factory, @NotNull Class modelClass, @NotNull CreationExtras extras) {
        g0.p(modelClass, "modelClass");
        g0.p(extras, "extras");
        return factory.create(modelClass);
    }

    @JvmStatic
    @NotNull
    public static ViewModelProvider.Factory c(@NotNull ViewModelInitializer<?>... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }
}
