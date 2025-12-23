package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class Navigator<D extends NavDestination> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Extras {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Name {
        String value();
    }

    @NonNull
    public abstract D createDestination();

    @Nullable
    public abstract NavDestination navigate(@NonNull D d6, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Extras extras);

    @Nullable
    public Bundle onSaveState() {
        return null;
    }

    public abstract boolean popBackStack();

    public void onRestoreState(@NonNull Bundle bundle) {
    }
}
