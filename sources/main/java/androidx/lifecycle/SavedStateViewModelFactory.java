package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    @Nullable
    private Application application;

    @Nullable
    private Bundle defaultArgs;

    @NotNull
    private final ViewModelProvider.Factory factory;

    @Nullable
    private Lifecycle lifecycle;

    @Nullable
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass, @NotNull CreationExtras extras) {
        List list;
        Constructor findMatchingConstructor;
        List list2;
        g0.p(modelClass, "modelClass");
        g0.p(extras, "extras");
        String str = (String) extras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) == null || extras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) == null) {
            if (this.lifecycle != null) {
                return (T) create(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
        if (!isAssignableFrom || application == null) {
            list = SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE;
            findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, list);
        } else {
            list2 = SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE;
            findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, list2);
        }
        return findMatchingConstructor == null ? (T) this.factory.create(modelClass, extras) : (!isAssignableFrom || application == null) ? (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, SavedStateHandleSupport.createSavedStateHandle(extras)) : (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, application, SavedStateHandleSupport.createSavedStateHandle(extras));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(@Nullable Application application, @NotNull SavedStateRegistryOwner owner) {
        this(application, owner, null);
        g0.p(owner, "owner");
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(@NotNull ViewModel viewModel) {
        g0.p(viewModel, "viewModel");
        if (this.lifecycle != null) {
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            g0.m(savedStateRegistry);
            Lifecycle lifecycle = this.lifecycle;
            g0.m(lifecycle);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
        }
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@Nullable Application application, @NotNull SavedStateRegistryOwner owner, @Nullable Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        g0.p(owner, "owner");
        this.savedStateRegistry = owner.getSavedStateRegistry();
        this.lifecycle = owner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        if (application != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.factory = androidViewModelFactory;
    }

    @NotNull
    public final <T extends ViewModel> T create(@NotNull String key, @NotNull Class<T> modelClass) {
        List list;
        Constructor findMatchingConstructor;
        T t5;
        Application application;
        List list2;
        g0.p(key, "key");
        g0.p(modelClass, "modelClass");
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
            if (!isAssignableFrom || this.application == null) {
                list = SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE;
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, list);
            } else {
                list2 = SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE;
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, list2);
            }
            if (findMatchingConstructor == null) {
                return this.application != null ? (T) this.factory.create(modelClass) : (T) ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(modelClass);
            }
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            g0.m(savedStateRegistry);
            SavedStateHandleController create = LegacySavedStateHandleController.create(savedStateRegistry, lifecycle, key, this.defaultArgs);
            if (!isAssignableFrom || (application = this.application) == null) {
                t5 = (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, create.getHandle());
            } else {
                g0.m(application);
                t5 = (T) SavedStateViewModelFactoryKt.newInstance(modelClass, findMatchingConstructor, application, create.getHandle());
            }
            t5.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
            return t5;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
        g0.p(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
