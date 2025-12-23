package m2;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface f extends n2.f {
    int d(h hVar, boolean z5);

    SpinnerStyle getSpinnerStyle();

    @NonNull
    View getView();

    void h(h hVar, int i6, int i7);

    void i(float f6, int i6, int i7);

    boolean j();

    void q(g gVar, int i6, int i7);

    void setPrimaryColors(@ColorInt int... iArr);
}
