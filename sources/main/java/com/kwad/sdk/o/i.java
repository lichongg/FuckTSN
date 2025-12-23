package com.kwad.sdk.o;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.InputStream;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i extends Resources {
    private final Resources bdQ;

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColor id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getColor(i6) : super.getColor(i6);
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 23)
    public final ColorStateList getColorStateList(int i6, @Nullable Resources.Theme theme) {
        ColorStateList colorStateList;
        try {
            com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i6));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("KSDY/KSResource", Log.getStackTraceString(e6));
        }
        if (!fk(i6)) {
            return super.getColorStateList(i6, theme);
        }
        colorStateList = this.bdQ.getColorStateList(i6, theme);
        return colorStateList;
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getDrawable(i6) : super.getDrawable(i6);
    }

    @Override // android.content.res.Resources
    @Nullable
    @Deprecated
    public final Drawable getDrawableForDensity(int i6, int i7) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawableForDensity id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getDrawableForDensity(i6, i7) : super.getDrawableForDensity(i6, i7);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i6, int i7) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getQuantityString(i6, i7) : super.getQuantityString(i6, i7);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getString(i6) : super.getString(i6);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getText(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getText(i6) : super.getText(i6);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i6, TypedValue typedValue, boolean z5) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(i6));
        if (fk(i6)) {
            this.bdQ.getValue(i6, typedValue, z5);
        } else {
            super.getValue(i6, typedValue, z5);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.openRawResource(i6) : super.openRawResource(i6);
    }

    private static boolean fk(int i6) {
        StringBuilder sb = new StringBuilder("0x");
        sb.append(Integer.toHexString(i6));
        return !sb.toString().startsWith("0x60");
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getAnimation(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getAnimation id: 0x#" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getAnimation(i6) : super.getAnimation(i6);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getBoolean id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getBoolean(i6) : super.getBoolean(i6);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDimension id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getDimension(i6) : super.getDimension(i6);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDimensionPixelOffset id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getDimensionPixelOffset(i6) : super.getDimensionPixelOffset(i6);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDimensionPixelSize id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getDimensionPixelSize(i6) : super.getDimensionPixelSize(i6);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 29)
    public final float getFloat(int i6) {
        float f6;
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getFloat id: #0x" + Integer.toHexString(i6));
        if (!fk(i6)) {
            return super.getFloat(i6);
        }
        f6 = this.bdQ.getFloat(i6);
        return f6;
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 26)
    public final Typeface getFont(int i6) {
        Typeface font;
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getFont id: #0x" + Integer.toHexString(i6));
        if (!fk(i6)) {
            return super.getFont(i6);
        }
        font = this.bdQ.getFont(i6);
        return font;
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i6, int i7, int i8) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getFraction id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getFraction(i6, i7, i8) : super.getFraction(i6, i7, i8);
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        return aB(str, str3) ? this.bdQ.getIdentifier(str, str2, str3) : super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final int[] getIntArray(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getIntArray id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getIntArray(i6) : super.getIntArray(i6);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getInteger id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getInteger(i6) : super.getInteger(i6);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getLayout(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getLayout id: 0x#" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getLayout(i6) : super.getLayout(i6);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getMovie(i6) : super.getMovie(i6);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getQuantityText(int i6, int i7) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getQuantityText id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getQuantityText(i6, i7) : super.getQuantityText(i6, i7);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourceEntryName id: 0x#" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getResourceEntryName(i6) : super.getResourceEntryName(i6);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourceName id: 0x#" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getResourceName(i6) : super.getResourceName(i6);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourcePackageName id: 0x#" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getResourcePackageName(i6) : super.getResourcePackageName(i6);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourceTypeName id: 0x#" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getResourceTypeName(i6) : super.getResourceTypeName(i6);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String[] getStringArray(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getStringArray id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getStringArray(i6) : super.getStringArray(i6);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence[] getTextArray(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getTextArray id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getTextArray(i6) : super.getTextArray(i6);
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i6, int i7, TypedValue typedValue, boolean z5) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getValueForDensity id: 0x#" + Integer.toHexString(i6));
        if (fk(i6)) {
            this.bdQ.getValueForDensity(i6, i7, typedValue, z5);
        } else {
            super.getValueForDensity(i6, i7, typedValue, z5);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getXml(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getXml id: 0x#" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.getXml(i6) : super.getXml(i6);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final TypedArray obtainTypedArray(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "obtainTypedArray id: #0x" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.obtainTypedArray(i6) : super.obtainTypedArray(i6);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i6) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "openRawResourceFd id: 0x#" + Integer.toHexString(i6));
        return fk(i6) ? this.bdQ.openRawResourceFd(i6) : super.openRawResourceFd(i6);
    }

    public i(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.bdQ = resources2;
    }

    private static boolean aB(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.startsWith("ksad_") && "com.kwad.dy.sdk".equals(str2)) {
            return false;
        }
        return true;
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 23)
    public final int getColor(int i6, @Nullable Resources.Theme theme) {
        int color;
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i6));
        if (fk(i6)) {
            color = this.bdQ.getColor(i6, theme);
            return color;
        }
        return super.getColor(i6, theme);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i6, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i6));
        if (fk(i6)) {
            return this.bdQ.getDrawable(i6);
        }
        return super.getDrawable(i6, theme);
    }

    @Override // android.content.res.Resources
    @Nullable
    @RequiresApi(api = 21)
    public final Drawable getDrawableForDensity(int i6, int i7, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i6));
        if (fk(i6)) {
            return this.bdQ.getDrawableForDensity(i6, i7, theme);
        }
        return super.getDrawableForDensity(i6, i7, theme);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i6, int i7, Object... objArr) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i6));
        if (fk(i6)) {
            return this.bdQ.getQuantityString(i6, i7, objArr);
        }
        return super.getQuantityString(i6, i7, objArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i6, Object... objArr) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i6));
        if (fk(i6)) {
            return this.bdQ.getString(i6, objArr);
        }
        return super.getString(i6, objArr);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i6, CharSequence charSequence) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i6));
        if (fk(i6)) {
            return this.bdQ.getText(i6, charSequence);
        }
        return super.getText(i6, charSequence);
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z5) {
        int identifier = getIdentifier(str, ResIdentify.RES_TYPE_STRING, null);
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(identifier));
        if (fk(identifier)) {
            this.bdQ.getValue(str, typedValue, z5);
        } else {
            super.getValue(str, typedValue, z5);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i6, TypedValue typedValue) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i6));
        if (fk(i6)) {
            return this.bdQ.openRawResource(i6, typedValue);
        }
        return super.openRawResource(i6, typedValue);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final ColorStateList getColorStateList(int i6) {
        try {
            com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i6));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("KSDY/KSResource", Log.getStackTraceString(e6));
        }
        if (fk(i6)) {
            return this.bdQ.getColorStateList(i6);
        }
        return super.getColorStateList(i6);
    }
}
