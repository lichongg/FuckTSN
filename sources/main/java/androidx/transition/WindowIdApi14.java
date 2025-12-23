package androidx.transition;

import android.os.IBinder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).mToken.equals(this.mToken);
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }

    WindowIdApi14(IBinder iBinder) {
        this.mToken = iBinder;
    }
}
