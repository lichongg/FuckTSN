package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements s<VM> {

    @Nullable
    private VM cached;

    @NotNull
    private final Function0<CreationExtras> extrasProducer;

    @NotNull
    private final Function0<ViewModelProvider.Factory> factoryProducer;

    @NotNull
    private final Function0<ViewModelStore> storeProducer;

    @NotNull
    private final kotlin.reflect.d<VM> viewModelClass;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewModelLazy(@NotNull kotlin.reflect.d<VM> viewModelClass, @NotNull Function0<? extends ViewModelStore> storeProducer, @NotNull Function0<? extends ViewModelProvider.Factory> factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        g0.p(viewModelClass, "viewModelClass");
        g0.p(storeProducer, "storeProducer");
        g0.p(factoryProducer, "factoryProducer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ViewModelLazy(@NotNull kotlin.reflect.d<VM> viewModelClass, @NotNull Function0<? extends ViewModelStore> storeProducer, @NotNull Function0<? extends ViewModelProvider.Factory> factoryProducer, @NotNull Function0<? extends CreationExtras> extrasProducer) {
        g0.p(viewModelClass, "viewModelClass");
        g0.p(storeProducer, "storeProducer");
        g0.p(factoryProducer, "factoryProducer");
        g0.p(extrasProducer, "extrasProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
        this.extrasProducer = extrasProducer;
    }

    @Override // kotlin.s
    @NotNull
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke(), this.extrasProducer.invoke()).get(l3.a.e(this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }

    @Override // kotlin.s
    public boolean isInitialized() {
        return this.cached != null;
    }

    public /* synthetic */ ViewModelLazy(kotlin.reflect.d dVar, Function0 function0, Function0 function02, Function0 function03, int i6, v vVar) {
        this(dVar, function0, function02, (i6 & 8) != 0 ? new Function0<CreationExtras.Empty>() { // from class: androidx.lifecycle.ViewModelLazy.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras.Empty invoke() {
                return CreationExtras.Empty.INSTANCE;
            }
        } : function03);
    }
}
