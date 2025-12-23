package androidx.camera.core.impl.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CompareSizesByArea implements Comparator<Size> {
    private boolean mReverse;

    public CompareSizesByArea() {
        this(false);
    }

    public CompareSizesByArea(boolean z5) {
        this.mReverse = z5;
    }

    @Override // java.util.Comparator
    public int compare(@NonNull Size size, @NonNull Size size2) {
        int signum = Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        return this.mReverse ? signum * (-1) : signum;
    }
}
