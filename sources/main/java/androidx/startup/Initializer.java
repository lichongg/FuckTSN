package androidx.startup;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface Initializer<T> {
    @NonNull
    T create(@NonNull Context context);

    @NonNull
    List<Class<? extends Initializer<?>>> dependencies();
}
