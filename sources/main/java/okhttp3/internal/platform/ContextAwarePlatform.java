package okhttp3.internal.platform;

import android.content.Context;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface ContextAwarePlatform {
    @Nullable
    Context getApplicationContext();

    void setApplicationContext(@Nullable Context context);
}
