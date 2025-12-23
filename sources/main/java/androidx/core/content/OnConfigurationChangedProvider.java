package androidx.core.content;

import android.content.res.Configuration;
import androidx.core.util.Consumer;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface OnConfigurationChangedProvider {
    void addOnConfigurationChangedListener(@NotNull Consumer<Configuration> consumer);

    void removeOnConfigurationChangedListener(@NotNull Consumer<Configuration> consumer);
}
