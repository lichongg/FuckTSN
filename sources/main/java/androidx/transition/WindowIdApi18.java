package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(18)
/* loaded from: D:\Downloads\app\classes.dex */
class WindowIdApi18 implements WindowIdImpl {
    private final WindowId mWindowId;

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).mWindowId.equals(this.mWindowId);
    }

    public int hashCode() {
        return this.mWindowId.hashCode();
    }

    WindowIdApi18(@NonNull View view) {
        this.mWindowId = view.getWindowId();
    }
}
