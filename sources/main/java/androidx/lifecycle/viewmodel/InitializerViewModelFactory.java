package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.l;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nInitializerViewModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,115:1\n13579#2,2:116\n*S KotlinDebug\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n*L\n105#1:116,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {

    @NotNull
    private final ViewModelInitializer<?>[] initializers;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(Class cls) {
        return l.a(this, cls);
    }

    public InitializerViewModelFactory(@NotNull ViewModelInitializer<?>... initializers) {
        g0.p(initializers, "initializers");
        this.initializers = initializers;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass, @NotNull CreationExtras extras) {
        g0.p(modelClass, "modelClass");
        g0.p(extras, "extras");
        T t5 = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.initializers) {
            if (g0.g(viewModelInitializer.getClazz$lifecycle_viewmodel_release(), modelClass)) {
                Object invoke = viewModelInitializer.getInitializer$lifecycle_viewmodel_release().invoke(extras);
                t5 = invoke instanceof ViewModel ? (T) invoke : null;
            }
        }
        if (t5 != null) {
            return t5;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
