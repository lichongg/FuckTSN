package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class BlendModeColorFilterCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    static class Api29Impl {
        @DoNotInline
        static ColorFilter createBlendModeColorFilter(int i6, Object obj) {
            return new BlendModeColorFilter(i6, (BlendMode) obj);
        }

        private Api29Impl() {
        }
    }

    @Nullable
    public static ColorFilter createBlendModeColorFilterCompat(int i6, @NonNull BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object obtainBlendModeFromCompat = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(blendModeCompat);
            if (obtainBlendModeFromCompat != null) {
                return Api29Impl.createBlendModeColorFilter(i6, obtainBlendModeFromCompat);
            }
            return null;
        }
        PorterDuff.Mode obtainPorterDuffFromCompat = BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat);
        if (obtainPorterDuffFromCompat != null) {
            return new PorterDuffColorFilter(i6, obtainPorterDuffFromCompat);
        }
        return null;
    }

    private BlendModeColorFilterCompat() {
    }
}
