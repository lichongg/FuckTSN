package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f15688a = true;

    public static Drawable b(Context context, Context context2, @DrawableRes int i6) {
        return c(context, context2, i6, null);
    }

    private static Drawable c(Context context, Context context2, @DrawableRes int i6, @Nullable Resources.Theme theme) {
        try {
            if (f15688a) {
                return e(context2, i6, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e6) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e6;
            }
            return ContextCompat.getDrawable(context2, i6);
        } catch (NoClassDefFoundError unused2) {
            f15688a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i6, theme);
    }

    private static Drawable e(Context context, @DrawableRes int i6, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i6);
    }

    private a() {
    }

    public static Drawable a(Context context, @DrawableRes int i6, @Nullable Resources.Theme theme) {
        return c(context, context, i6, theme);
    }

    private static Drawable d(Context context, @DrawableRes int i6, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i6, theme);
    }
}
