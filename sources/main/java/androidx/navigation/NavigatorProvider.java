package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"TypeParameterUnusedInFormals"})
/* loaded from: D:\Downloads\app\classes.dex */
public class NavigatorProvider {
    private static final HashMap<Class<?>, String> sAnnotationNames = new HashMap<>();
    private final HashMap<String, Navigator<? extends NavDestination>> mNavigators = new HashMap<>();

    @Nullable
    public final Navigator<? extends NavDestination> addNavigator(@NonNull Navigator<? extends NavDestination> navigator) {
        return addNavigator(getNameForNavigator(navigator.getClass()), navigator);
    }

    @NonNull
    public final <T extends Navigator<?>> T getNavigator(@NonNull Class<T> cls) {
        return (T) getNavigator(getNameForNavigator(cls));
    }

    @NonNull
    static String getNameForNavigator(@NonNull Class<? extends Navigator> cls) {
        HashMap<Class<?>, String> hashMap = sAnnotationNames;
        String str = hashMap.get(cls);
        if (str != null) {
            return str;
        }
        Navigator.Name name = (Navigator.Name) cls.getAnnotation(Navigator.Name.class);
        String value = name != null ? name.value() : null;
        if (validateName(value)) {
            hashMap.put(cls, value);
            return value;
        }
        throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
    }

    private static boolean validateName(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    Map<String, Navigator<? extends NavDestination>> getNavigators() {
        return this.mNavigators;
    }

    @Nullable
    @CallSuper
    public Navigator<? extends NavDestination> addNavigator(@NonNull String str, @NonNull Navigator<? extends NavDestination> navigator) {
        if (validateName(str)) {
            return this.mNavigators.put(str, navigator);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    @NonNull
    @CallSuper
    public <T extends Navigator<?>> T getNavigator(@NonNull String str) {
        if (validateName(str)) {
            Navigator<? extends NavDestination> navigator = this.mNavigators.get(str);
            if (navigator != null) {
                return navigator;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }
}
