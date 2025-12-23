package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavAction {
    private Bundle mDefaultArguments;

    @IdRes
    private final int mDestinationId;
    private NavOptions mNavOptions;

    public NavAction(@IdRes int i6) {
        this(i6, null);
    }

    public NavAction(@IdRes int i6, @Nullable NavOptions navOptions) {
        this(i6, navOptions, null);
    }

    @Nullable
    public Bundle getDefaultArguments() {
        return this.mDefaultArguments;
    }

    public int getDestinationId() {
        return this.mDestinationId;
    }

    @Nullable
    public NavOptions getNavOptions() {
        return this.mNavOptions;
    }

    public void setDefaultArguments(@Nullable Bundle bundle) {
        this.mDefaultArguments = bundle;
    }

    public void setNavOptions(@Nullable NavOptions navOptions) {
        this.mNavOptions = navOptions;
    }

    public NavAction(@IdRes int i6, @Nullable NavOptions navOptions, @Nullable Bundle bundle) {
        this.mDestinationId = i6;
        this.mNavOptions = navOptions;
        this.mDefaultArguments = bundle;
    }
}
