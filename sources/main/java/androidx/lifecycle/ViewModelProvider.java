package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nViewModelProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewModelProvider.kt\nandroidx/lifecycle/ViewModelProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n1#2:376\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public class ViewModelProvider {

    @NotNull
    private final CreationExtras defaultCreationExtras;

    @NotNull
    private final Factory factory;

    @NotNull
    private final ViewModelStore store;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class AndroidViewModelFactory extends NewInstanceFactory {

        @NotNull
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";

        @Nullable
        private static AndroidViewModelFactory sInstance;

        @Nullable
        private final Application application;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        @NotNull
        public static final CreationExtras.Key<Application> APPLICATION_KEY = Companion.ApplicationKeyImpl.INSTANCE;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            private static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {

                @NotNull
                public static final ApplicationKeyImpl INSTANCE = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }

            private Companion() {
            }

            @NotNull
            public final Factory defaultFactory$lifecycle_viewmodel_release(@NotNull ViewModelStoreOwner owner) {
                g0.p(owner, "owner");
                return owner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelProviderFactory() : NewInstanceFactory.Companion.getInstance();
            }

            @JvmStatic
            @NotNull
            public final AndroidViewModelFactory getInstance(@NotNull Application application) {
                g0.p(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.sInstance;
                g0.m(androidViewModelFactory);
                return androidViewModelFactory;
            }
        }

        private AndroidViewModelFactory(Application application, int i6) {
            this.application = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass, @NotNull CreationExtras extras) {
            g0.p(modelClass, "modelClass");
            g0.p(extras, "extras");
            if (this.application != null) {
                return (T) create(modelClass);
            }
            Application application = (Application) extras.get(APPLICATION_KEY);
            if (application != null) {
                return (T) create(modelClass, application);
            }
            if (AndroidViewModel.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.create(modelClass);
        }

        @JvmStatic
        @NotNull
        public static final AndroidViewModelFactory getInstance(@NotNull Application application) {
            return Companion.getInstance(application);
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(@NotNull Application application) {
            this(application, 0);
            g0.p(application, "application");
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            g0.p(modelClass, "modelClass");
            Application application = this.application;
            if (application != null) {
                return (T) create(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private final <T extends ViewModel> T create(Class<T> cls, Application application) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    T newInstance = cls.getConstructor(Application.class).newInstance(application);
                    g0.o(newInstance, "{\n                try {\n…          }\n            }");
                    return newInstance;
                } catch (IllegalAccessException e6) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e6);
                } catch (InstantiationException e7) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e7);
                } catch (NoSuchMethodException e8) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e8);
                } catch (InvocationTargetException e9) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e9);
                }
            }
            return (T) super.create(cls);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Factory {

        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @JvmStatic
            @NotNull
            public final Factory from(@NotNull ViewModelInitializer<?>... initializers) {
                g0.p(initializers, "initializers");
                return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(initializers, initializers.length));
            }

            private Companion() {
            }
        }

        @NotNull
        <T extends ViewModel> T create(@NotNull Class<T> cls);

        @NotNull
        <T extends ViewModel> T create(@NotNull Class<T> cls, @NotNull CreationExtras creationExtras);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NewInstanceFactory implements Factory {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        @NotNull
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = Companion.ViewModelKeyImpl.INSTANCE;

        @Nullable
        private static NewInstanceFactory sInstance;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            private static final class ViewModelKeyImpl implements CreationExtras.Key<String> {

                @NotNull
                public static final ViewModelKeyImpl INSTANCE = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }

            private Companion() {
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            @NotNull
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory.sInstance;
                g0.m(newInstanceFactory);
                return newInstanceFactory;
            }

            @JvmStatic
            public static /* synthetic */ void getInstance$annotations() {
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return l.b(this, cls, creationExtras);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            g0.p(modelClass, "modelClass");
            try {
                T newInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
                g0.o(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e6);
            } catch (InstantiationException e7) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e7);
            } catch (NoSuchMethodException e8) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e8);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewModelProvider(@NotNull ViewModelStore store, @NotNull Factory factory) {
        this(store, factory, null, 4, null);
        g0.p(store, "store");
        g0.p(factory, "factory");
    }

    @MainThread
    @NotNull
    public <T extends ViewModel> T get(@NotNull Class<T> modelClass) {
        g0.p(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class OnRequeryFactory {
        public void onRequery(@NotNull ViewModel viewModel) {
            g0.p(viewModel, "viewModel");
        }
    }

    @JvmOverloads
    public ViewModelProvider(@NotNull ViewModelStore store, @NotNull Factory factory, @NotNull CreationExtras defaultCreationExtras) {
        g0.p(store, "store");
        g0.p(factory, "factory");
        g0.p(defaultCreationExtras, "defaultCreationExtras");
        this.store = store;
        this.factory = factory;
        this.defaultCreationExtras = defaultCreationExtras;
    }

    @MainThread
    @NotNull
    public <T extends ViewModel> T get(@NotNull String key, @NotNull Class<T> modelClass) {
        T t5;
        g0.p(key, "key");
        g0.p(modelClass, "modelClass");
        T t6 = (T) this.store.get(key);
        if (modelClass.isInstance(t6)) {
            Object obj = this.factory;
            OnRequeryFactory onRequeryFactory = obj instanceof OnRequeryFactory ? (OnRequeryFactory) obj : null;
            if (onRequeryFactory != null) {
                g0.m(t6);
                onRequeryFactory.onRequery(t6);
            }
            g0.n(t6, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return t6;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultCreationExtras);
        mutableCreationExtras.set(NewInstanceFactory.VIEW_MODEL_KEY, key);
        try {
            t5 = (T) this.factory.create(modelClass, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t5 = (T) this.factory.create(modelClass);
        }
        this.store.put(key, t5);
        return t5;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i6, v vVar) {
        this(viewModelStore, factory, (i6 & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@NotNull ViewModelStoreOwner owner) {
        this(owner.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(owner), ViewModelProviderGetKt.defaultCreationExtras(owner));
        g0.p(owner, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@NotNull ViewModelStoreOwner owner, @NotNull Factory factory) {
        this(owner.getViewModelStore(), factory, ViewModelProviderGetKt.defaultCreationExtras(owner));
        g0.p(owner, "owner");
        g0.p(factory, "factory");
    }
}
