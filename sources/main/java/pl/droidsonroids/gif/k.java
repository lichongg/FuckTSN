package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    static final String f51836a = "http://schemas.android.com/apk/res/android";

    /* renamed from: b, reason: collision with root package name */
    static final List<String> f51837b = Arrays.asList(ResIdentify.RES_TYPE_RAW, ResIdentify.RES_TYPE_DRAWABLE, ResIdentify.RES_TYPE_MIPMAP);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends b {

        /* renamed from: c, reason: collision with root package name */
        final int f51838c;

        /* renamed from: d, reason: collision with root package name */
        final int f51839d;

        a(ImageView imageView, AttributeSet attributeSet, int i6, int i7) {
            super(imageView, attributeSet, i6, i7);
            this.f51838c = a(imageView, attributeSet, true);
            this.f51839d = a(imageView, attributeSet, false);
        }

        private static int a(ImageView imageView, AttributeSet attributeSet, boolean z5) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue(k.f51836a, z5 ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (k.f51837b.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !k.e(imageView, z5, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }

        a() {
            this.f51838c = 0;
            this.f51839d = 0;
        }
    }

    static void a(int i6, Drawable drawable) {
        if (drawable instanceof e) {
            ((e) drawable).F(i6);
        }
    }

    static float b(@NonNull Resources resources, @DrawableRes @RawRes int i6) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i6, typedValue, true);
        int i7 = typedValue.density;
        if (i7 == 0) {
            i7 = 160;
        } else if (i7 == 65535) {
            i7 = 0;
        }
        int i8 = resources.getDisplayMetrics().densityDpi;
        if (i7 <= 0 || i8 <= 0) {
            return 1.0f;
        }
        return i8 / i7;
    }

    static a c(ImageView imageView, AttributeSet attributeSet, int i6, int i7) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new a();
        }
        a aVar = new a(imageView, attributeSet, i6, i7);
        int i8 = aVar.f51841b;
        if (i8 >= 0) {
            a(i8, imageView.getDrawable());
            a(i8, imageView.getBackground());
        }
        return aVar;
    }

    static boolean d(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new e(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private k() {
    }

    static boolean e(ImageView imageView, boolean z5, int i6) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!f51837b.contains(resources.getResourceTypeName(i6))) {
                    return false;
                }
                e eVar = new e(resources, i6);
                if (z5) {
                    imageView.setImageDrawable(eVar);
                    return true;
                }
                imageView.setBackground(eVar);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        boolean f51840a;

        /* renamed from: b, reason: collision with root package name */
        final int f51841b;

        b(View view, AttributeSet attributeSet, int i6, int i7) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.GifView, i6, i7);
            this.f51840a = obtainStyledAttributes.getBoolean(R.styleable.GifView_freezesAnimation, false);
            this.f51841b = obtainStyledAttributes.getInt(R.styleable.GifView_loopCount, -1);
            obtainStyledAttributes.recycle();
        }

        b() {
            this.f51840a = false;
            this.f51841b = -1;
        }
    }
}
