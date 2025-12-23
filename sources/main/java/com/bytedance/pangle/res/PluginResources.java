package com.bytedance.pangle.res;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.ae;
import com.bytedance.pangle.util.qv;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class PluginResources extends Resources {
    public String pluginPkg;

    @Override // android.content.res.Resources
    public int getColor(int i6) throws Resources.NotFoundException {
        try {
            return super.getColor(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i6) throws Resources.NotFoundException {
        try {
            return super.getColorStateList(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i6) throws Resources.NotFoundException {
        try {
            return super.getDrawable(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i6, int i7) throws Resources.NotFoundException {
        try {
            return super.getDrawableForDensity(i6, i7);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i6, int i7, Object... objArr) throws Resources.NotFoundException {
        try {
            return super.getQuantityString(i6, i7, objArr);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i6) throws Resources.NotFoundException {
        try {
            return super.getString(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getText(int i6) throws Resources.NotFoundException {
        try {
            return super.getText(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i6, TypedValue typedValue, boolean z5) throws Resources.NotFoundException {
        try {
            super.getValue(i6, typedValue, z5);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i6) throws Resources.NotFoundException {
        try {
            return super.openRawResource(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    private Resources.NotFoundException handleException(Resources.NotFoundException notFoundException) {
        return new Resources.NotFoundException(("Resources#Assets: " + qv.xt(getAssets())) + "," + notFoundException.getMessage());
    }

    public PluginResources(Resources resources, String str) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = str;
    }

    public static AssetManager appendHostRes(Resources resources) {
        String j6 = ae.j(Zeus.getAppApplication());
        String xt = ae.xt(Zeus.getAppApplication());
        List<String> xt2 = qv.xt();
        j jVar = new j();
        AssetManager assets = resources.getAssets();
        AssetManager assets2 = Zeus.getAppApplication().getAssets();
        HashSet hashSet = new HashSet(qv.j(assets));
        List<String> j7 = qv.j(assets2);
        for (String str : xt2) {
            if (!hashSet.contains(str)) {
                assets = jVar.j(assets, str, true);
            }
        }
        for (String str2 : j7) {
            if (!isOtherPlugin(str2, j6, xt) && !hashSet.contains(str2) && !xt2.contains(str2)) {
                assets = jVar.j(assets, str2, false);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_RESOURCES, "pluginAssets = " + qv.xt(assets));
        return assets;
    }

    private static boolean isOtherPlugin(String str, String str2, String str3) {
        String packageResourcePath = Zeus.getAppApplication().getPackageResourcePath();
        if (!TextUtils.isEmpty(str3)) {
            packageResourcePath = packageResourcePath.replaceFirst(str2, str3);
            str = str.replaceFirst(str2, str3);
        }
        ZeusLogger.d(ZeusLogger.TAG_RESOURCES, str + " " + packageResourcePath + " " + str2 + " " + str3);
        if (TextUtils.equals(str, packageResourcePath) || str.contains("/tinker/patch-")) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || !str.contains(str2)) {
            if (TextUtils.isEmpty(str3) || !str.contains(str3)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getAnimation(int i6) throws Resources.NotFoundException {
        try {
            return super.getAnimation(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i6) throws Resources.NotFoundException {
        try {
            return super.getBoolean(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i6, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getColor(i6, theme);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i6, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getColorStateList(i6, theme);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public float getDimension(int i6) throws Resources.NotFoundException {
        try {
            return super.getDimension(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i6) throws Resources.NotFoundException {
        try {
            return super.getDimensionPixelOffset(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i6) throws Resources.NotFoundException {
        try {
            return super.getDimensionPixelSize(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i6, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getDrawable(i6, theme);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i6, int i7, @Nullable Resources.Theme theme) {
        try {
            return super.getDrawableForDensity(i6, i7, theme);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public float getFloat(int i6) {
        try {
            return super.getFloat(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public Typeface getFont(int i6) throws Resources.NotFoundException {
        try {
            return super.getFont(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public float getFraction(int i6, int i7, int i8) {
        try {
            return super.getFraction(i6, i7, i8);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public int[] getIntArray(int i6) throws Resources.NotFoundException {
        try {
            return super.getIntArray(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public int getInteger(int i6) throws Resources.NotFoundException {
        try {
            return super.getInteger(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getLayout(int i6) throws Resources.NotFoundException {
        try {
            return super.getLayout(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i6) throws Resources.NotFoundException {
        try {
            return super.getMovie(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i6, int i7) throws Resources.NotFoundException {
        try {
            return super.getQuantityString(i6, i7);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getQuantityText(int i6, int i7) throws Resources.NotFoundException {
        try {
            return super.getQuantityText(i6, i7);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i6) throws Resources.NotFoundException {
        try {
            return super.getResourceEntryName(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i6) throws Resources.NotFoundException {
        try {
            return super.getResourceName(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i6) throws Resources.NotFoundException {
        try {
            return super.getResourcePackageName(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i6) throws Resources.NotFoundException {
        try {
            return super.getResourceTypeName(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i6, Object... objArr) throws Resources.NotFoundException {
        try {
            return super.getString(i6, objArr);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String[] getStringArray(int i6) throws Resources.NotFoundException {
        try {
            return super.getStringArray(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i6, CharSequence charSequence) {
        try {
            return super.getText(i6, charSequence);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence[] getTextArray(int i6) throws Resources.NotFoundException {
        try {
            return super.getTextArray(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z5) throws Resources.NotFoundException {
        try {
            super.getValue(str, typedValue, z5);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i6, int i7, TypedValue typedValue, boolean z5) throws Resources.NotFoundException {
        try {
            super.getValueForDensity(i6, i7, typedValue, z5);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getXml(int i6) throws Resources.NotFoundException {
        try {
            return super.getXml(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public TypedArray obtainTypedArray(int i6) throws Resources.NotFoundException {
        try {
            return super.obtainTypedArray(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i6, TypedValue typedValue) throws Resources.NotFoundException {
        try {
            return super.openRawResource(i6, typedValue);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i6) throws Resources.NotFoundException {
        try {
            return super.openRawResourceFd(i6);
        } catch (Resources.NotFoundException e6) {
            throw handleException(e6);
        }
    }
}
