package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface TintableCompoundDrawablesView {
    @Nullable
    ColorStateList getSupportCompoundDrawablesTintList();

    @Nullable
    PorterDuff.Mode getSupportCompoundDrawablesTintMode();

    void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList);

    void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode);
}
