package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import pl.droidsonroids.gif.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class GifTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private k.b f51779a;

    public GifTextView(Context context) {
        super(context);
    }

    private static void d(Drawable[] drawableArr, boolean z5) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(z5, false);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.f51779a.f51840a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            drawableArr[4] = compoundDrawablesRelative[0];
            drawableArr[5] = compoundDrawablesRelative[2];
            drawableArr[6] = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet, 0, 0);
    }

    private void a() {
        if (this.f51779a.f51841b < 0) {
            return;
        }
        for (Drawable drawable : getCompoundDrawables()) {
            k.a(this.f51779a.f51841b, drawable);
        }
        for (Drawable drawable2 : getCompoundDrawablesRelative()) {
            k.a(this.f51779a.f51841b, drawable2);
        }
        k.a(this.f51779a.f51841b, getBackground());
    }

    private Drawable b(int i6) {
        if (i6 == 0) {
            return null;
        }
        Resources resources = getResources();
        String resourceTypeName = resources.getResourceTypeName(i6);
        if (!isInEditMode() && k.f51837b.contains(resourceTypeName)) {
            try {
                return new e(resources, i6);
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return resources.getDrawable(i6, getContext().getTheme());
    }

    private void c(AttributeSet attributeSet, int i6, int i7) {
        if (attributeSet != null) {
            Drawable b6 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable b7 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable b8 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable b9 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable b10 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable b11 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (getLayoutDirection() == 0) {
                if (b10 != null) {
                    b6 = b10;
                }
                if (b11 == null) {
                    b11 = b8;
                }
            } else {
                if (b10 != null) {
                    b8 = b10;
                }
                if (b11 == null) {
                    b11 = b6;
                }
                b6 = b8;
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(b6, b7, b11, b9);
            setBackground(b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
            this.f51779a = new k.b(this, attributeSet, i6, i7);
            a();
        }
        this.f51779a = new k.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.a(compoundDrawables[0], 0);
        gifViewSavedState.a(compoundDrawables[1], 1);
        gifViewSavedState.a(compoundDrawables[2], 2);
        gifViewSavedState.a(compoundDrawables[3], 3);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        gifViewSavedState.a(compoundDrawablesRelative[0], 4);
        gifViewSavedState.a(compoundDrawablesRelative[2], 5);
        gifViewSavedState.a(getBackground(), 6);
    }

    public void setFreezesAnimation(boolean z5) {
        this.f51779a.f51840a = z5;
    }

    private void setCompoundDrawablesVisible(boolean z5) {
        d(getCompoundDrawables(), z5);
        d(getCompoundDrawablesRelative(), z5);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCompoundDrawablesVisible(true);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setCompoundDrawablesVisible(false);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        setBackground(b(i6));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i6, int i7, int i8, int i9) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(b(i6), b(i7), b(i8), b(i9));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i6, int i7, int i8, int i9) {
        setCompoundDrawablesWithIntrinsicBounds(b(i6), b(i7), b(i8), b(i9));
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        c(attributeSet, i6, 0);
    }

    @RequiresApi(21)
    public GifTextView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        c(attributeSet, i6, i7);
    }
}
