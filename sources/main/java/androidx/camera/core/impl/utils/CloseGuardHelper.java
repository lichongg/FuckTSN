package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.CloseGuard;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CloseGuardHelper {
    private final CloseGuardImpl mImpl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(30)
    static final class CloseGuardApi30Impl implements CloseGuardImpl {
        private final CloseGuard mPlatformImpl = new CloseGuard();

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void close() {
            this.mPlatformImpl.close();
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void open(@NonNull String str) {
            this.mPlatformImpl.open(str);
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void warnIfOpen() {
            this.mPlatformImpl.warnIfOpen();
        }

        CloseGuardApi30Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface CloseGuardImpl {
        void close();

        void open(@NonNull String str);

        void warnIfOpen();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CloseGuardNoOpImpl implements CloseGuardImpl {
        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void open(@NonNull String str) {
            Preconditions.checkNotNull(str, "CloseMethodName must not be null.");
        }

        CloseGuardNoOpImpl() {
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void close() {
        }

        @Override // androidx.camera.core.impl.utils.CloseGuardHelper.CloseGuardImpl
        public void warnIfOpen() {
        }
    }

    @NonNull
    public static CloseGuardHelper create() {
        return Build.VERSION.SDK_INT >= 30 ? new CloseGuardHelper(new CloseGuardApi30Impl()) : new CloseGuardHelper(new CloseGuardNoOpImpl());
    }

    public void close() {
        this.mImpl.close();
    }

    public void open(@NonNull String str) {
        this.mImpl.open(str);
    }

    public void warnIfOpen() {
        this.mImpl.warnIfOpen();
    }

    private CloseGuardHelper(CloseGuardImpl closeGuardImpl) {
        this.mImpl = closeGuardImpl;
    }
}
