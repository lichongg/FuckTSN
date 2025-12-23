package com.google.android.material.drawable;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class DrawableUtils {
    public static final int INTRINSIC_SIZE = -1;
    private static final int UNSPECIFIED_HEIGHT = -1;
    private static final int UNSPECIFIED_WIDTH = -1;

    @Nullable
    public static Drawable compositeTwoLayeredDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        return compositeTwoLayeredDrawable(drawable, drawable2, -1, -1);
    }

    @Nullable
    public static Drawable createTintableDrawableIfNeeded(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return createTintableMutatedDrawableIfNeeded(drawable, colorStateList, mode, false);
    }

    @Nullable
    public static Drawable createTintableMutatedDrawableIfNeeded(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return createTintableMutatedDrawableIfNeeded(drawable, colorStateList, mode, Build.VERSION.SDK_INT < 23);
    }

    @NonNull
    public static int[] getCheckedState(@NonNull int[] iArr) {
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            if (i7 == 16842912) {
                return iArr;
            }
            if (i7 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i6] = 16842912;
                return iArr2;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[iArr.length] = 16842912;
        return copyOf;
    }

    @NonNull
    public static int[] getUncheckedState(@NonNull int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i6 = 0;
        for (int i7 : iArr) {
            if (i7 != 16842912) {
                iArr2[i6] = i7;
                i6++;
            }
        }
        return iArr2;
    }

    @Nullable
    public static Drawable compositeTwoLayeredDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Px int i6, @Px int i7) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        if (i6 == -1) {
            i6 = getTopLayerIntrinsicWidth(drawable, drawable2);
        }
        if (i7 == -1) {
            i7 = getTopLayerIntrinsicHeight(drawable, drawable2);
        }
        if (i6 > drawable.getIntrinsicWidth() || i7 > drawable.getIntrinsicHeight()) {
            float f6 = i6 / i7;
            if (f6 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                i7 = (int) (intrinsicWidth / f6);
                i6 = intrinsicWidth;
            } else {
                i7 = drawable.getIntrinsicHeight();
                i6 = (int) (f6 * i7);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            layerDrawable.setLayerSize(1, i6, i7);
            layerDrawable.setLayerGravity(1, 17);
            return layerDrawable;
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawable, new ScaledDrawableWrapper(drawable2, i6, i7).getDrawable()});
        int max = Math.max((drawable.getIntrinsicWidth() - i6) / 2, 0);
        int max2 = Math.max((drawable.getIntrinsicHeight() - i7) / 2, 0);
        layerDrawable2.setLayerInset(1, max, max2, max, max2);
        return layerDrawable2;
    }

    @Nullable
    private static Drawable createTintableMutatedDrawableIfNeeded(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, boolean z5) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList == null) {
            if (z5) {
                drawable.mutate();
            }
            return drawable;
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        if (mode != null) {
            DrawableCompat.setTintMode(mutate, mode);
        }
        return mutate;
    }

    public static void setOutlineToPath(@NonNull Outline outline, @NonNull Path path) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            outline.setPath(path);
            return;
        }
        if (i6 >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    @TargetApi(21)
    public static void setRippleDrawableRadius(@Nullable RippleDrawable rippleDrawable, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i6);
            return;
        }
        try {
            try {
                RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE).invoke(rippleDrawable, Integer.valueOf(i6));
            } catch (IllegalAccessException e6) {
                e = e6;
                throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
            } catch (InvocationTargetException e7) {
                e = e7;
                throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e8) {
            e = e8;
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
        }
    }

    public static void setTint(@NonNull Drawable drawable, @ColorInt int i6) {
        boolean z5 = i6 != 0;
        if (Build.VERSION.SDK_INT == 21) {
            if (z5) {
                drawable.setColorFilter(i6, PorterDuff.Mode.SRC_IN);
                return;
            } else {
                drawable.setColorFilter(null);
                return;
            }
        }
        if (z5) {
            DrawableCompat.setTint(drawable, i6);
        } else {
            DrawableCompat.setTintList(drawable, null);
        }
    }

    @Nullable
    public static PorterDuffColorFilter updateTintFilter(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    private DrawableUtils() {
    }

    private static int getTopLayerIntrinsicHeight(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        if (intrinsicHeight != -1) {
            return intrinsicHeight;
        }
        return drawable.getIntrinsicHeight();
    }

    private static int getTopLayerIntrinsicWidth(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        if (intrinsicWidth != -1) {
            return intrinsicWidth;
        }
        return drawable.getIntrinsicWidth();
    }

    @NonNull
    public static AttributeSet parseDrawableXml(@NonNull Context context, @XmlRes int i6, @NonNull CharSequence charSequence) {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i6);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                if (TextUtils.equals(xml.getName(), charSequence)) {
                    return Xml.asAttributeSet(xml);
                }
                throw new XmlPullParserException("Must have a <" + ((Object) charSequence) + "> start tag");
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e6) {
            e = e6;
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i6));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (XmlPullParserException e7) {
            e = e7;
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i6));
            notFoundException2.initCause(e);
            throw notFoundException2;
        }
    }
}
