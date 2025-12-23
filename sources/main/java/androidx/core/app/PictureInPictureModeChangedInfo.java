package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PictureInPictureModeChangedInfo {
    private final boolean isInPictureInPictureMode;

    @RequiresApi(26)
    @Nullable
    private Configuration newConfiguration;

    public PictureInPictureModeChangedInfo(boolean z5) {
        this.isInPictureInPictureMode = z5;
    }

    @RequiresApi(26)
    @NotNull
    public final Configuration getNewConfig() {
        Configuration configuration = this.newConfiguration;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("PictureInPictureModeChangedInfo must be constructed with the constructor that takes a Configuration to access the newConfig. Are you running on an API 26 or higher device that makes this information available?");
    }

    public final boolean isInPictureInPictureMode() {
        return this.isInPictureInPictureMode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public PictureInPictureModeChangedInfo(boolean z5, @NotNull Configuration newConfig) {
        this(z5);
        g0.p(newConfig, "newConfig");
        this.newConfiguration = newConfig;
    }
}
