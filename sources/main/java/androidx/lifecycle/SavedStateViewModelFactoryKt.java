package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SavedStateViewModelFactoryKt {

    @NotNull
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = f0.Q(Application.class, SavedStateHandle.class);

    @NotNull
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = f0.l(SavedStateHandle.class);

    @Nullable
    public static final <T> Constructor<T> findMatchingConstructor(@NotNull Class<T> modelClass, @NotNull List<? extends Class<?>> signature) {
        g0.p(modelClass, "modelClass");
        g0.p(signature, "signature");
        Object[] constructors = modelClass.getConstructors();
        g0.o(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            g0.o(parameterTypes, "constructor.parameterTypes");
            List dz = n.dz(parameterTypes);
            if (g0.g(signature, dz)) {
                g0.n(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == dz.size() && dz.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(@NotNull Class<T> modelClass, @NotNull Constructor<T> constructor, @NotNull Object... params) {
        g0.p(modelClass, "modelClass");
        g0.p(constructor, "constructor");
        g0.p(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Failed to access " + modelClass, e6);
        } catch (InstantiationException e7) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e7);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e8.getCause());
        }
    }
}
