package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, Function1<? super CreationExtras, ? extends VM> initializer) {
        g0.p(initializerViewModelFactoryBuilder, "<this>");
        g0.p(initializer, "initializer");
        g0.y(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(o0.d(ViewModel.class), initializer);
    }

    @NotNull
    public static final ViewModelProvider.Factory viewModelFactory(@NotNull Function1<? super InitializerViewModelFactoryBuilder, n1> builder) {
        g0.p(builder, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        builder.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
