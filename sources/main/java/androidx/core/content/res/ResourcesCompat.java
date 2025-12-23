package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ResourcesCompat {

    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    @GuardedBy("sColorStateCacheLock")
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    private static final Object sColorStateCacheLock = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ColorStateListCacheKey.class == obj.getClass()) {
                ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
                if (this.mResources.equals(colorStateListCacheKey.mResources) && ObjectsCompat.equals(this.mTheme, colorStateListCacheKey.mTheme)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mResources, this.mTheme);
        }

        ColorStateListCacheKey(@NonNull Resources resources, @Nullable Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class FontCallback {
        public abstract void onFontRetrievalFailed(int i6);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(final int i6, @Nullable Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.b
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.onFontRetrievalFailed(i6);
                }
            });
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(@NonNull final Typeface typeface, @Nullable Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.a
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ThemeCompat {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @RequiresApi(23)
        static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = new Object();

            @SuppressLint({"BanUncheckedReflection"})
            static void rebase(@NonNull Resources.Theme theme) {
                synchronized (sRebaseMethodLock) {
                    if (!sRebaseMethodFetched) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            sRebaseMethod = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException unused) {
                        }
                        sRebaseMethodFetched = true;
                    }
                    Method method = sRebaseMethod;
                    if (method != null) {
                        try {
                            method.invoke(theme, null);
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                            sRebaseMethod = null;
                        }
                    }
                }
            }

            private Api23Impl() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @RequiresApi(29)
        static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            static void rebase(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void rebase(@NonNull Resources.Theme theme) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 29) {
                Api29Impl.rebase(theme);
            } else if (i6 >= 23) {
                Api23Impl.rebase(theme);
            }
        }

        private ThemeCompat() {
        }
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i6) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i6, new TypedValue(), 0, null, null, false, false);
    }

    private static Typeface loadFont(@NonNull Context context, int i6, @NonNull TypedValue typedValue, int i7, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z5, boolean z6) {
        Resources resources = context.getResources();
        resources.getValue(i6, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i6, i7, fontCallback, handler, z5, z6);
        if (loadFont != null || fontCallback != null || z6) {
            return loadFont;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i6) + " could not be retrieved.");
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Drawable getDrawable(Resources resources, int i6, Resources.Theme theme) {
            return resources.getDrawable(i6, theme);
        }

        @DoNotInline
        static Drawable getDrawableForDensity(Resources resources, int i6, int i7, Resources.Theme theme) {
            return resources.getDrawableForDensity(i6, i7, theme);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getColor(Resources resources, int i6, Resources.Theme theme) {
            return resources.getColor(i6, theme);
        }

        @NonNull
        @DoNotInline
        static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i6, @Nullable Resources.Theme theme) {
            return resources.getColorStateList(i6, theme);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static float getFloat(@NonNull Resources resources, @DimenRes int i6) {
            return resources.getFloat(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration, @Nullable Resources.Theme theme) {
            int hashCode;
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
            if (theme == null) {
                hashCode = 0;
            } else {
                hashCode = theme.hashCode();
            }
            this.mThemeHash = hashCode;
        }
    }

    private static void addColorStateListToCache(@NonNull ColorStateListCacheKey colorStateListCacheKey, @ColorRes int i6, @NonNull ColorStateList colorStateList, @Nullable Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
                SparseArray<ColorStateListCacheEntry> sparseArray = weakHashMap.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    weakHashMap.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i6, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void clearCachesForTheme(@NonNull Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                Iterator<ColorStateListCacheKey> it = sColorStateCaches.keySet().iterator();
                while (it.hasNext()) {
                    ColorStateListCacheKey next = it.next();
                    if (next != null && theme.equals(next.mTheme)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r2.mThemeHash == r5.hashCode()) goto L22;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.res.ColorStateList getCachedColorStateList(@androidx.annotation.NonNull androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey r5, @androidx.annotation.ColorRes int r6) {
        /*
            java.lang.Object r0 = androidx.core.content.res.ResourcesCompat.sColorStateCacheLock
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, android.util.SparseArray<androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry>> r1 = androidx.core.content.res.ResourcesCompat.sColorStateCaches     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry r2 = (androidx.core.content.res.ResourcesCompat.ColorStateListCacheEntry) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.mConfiguration     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.mResources     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.mTheme     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.mThemeHash     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.mThemeHash     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.mValue     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.getCachedColorStateList(androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, int):android.content.res.ColorStateList");
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i6, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.getColor(resources, i6, theme) : resources.getColor(i6);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i6, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList cachedColorStateList = getCachedColorStateList(colorStateListCacheKey, i6);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList inflateColorStateList = inflateColorStateList(resources, i6, theme);
        if (inflateColorStateList == null) {
            return Build.VERSION.SDK_INT >= 23 ? Api23Impl.getColorStateList(resources, i6, theme) : resources.getColorStateList(i6);
        }
        addColorStateListToCache(colorStateListCacheKey, i6, inflateColorStateList, theme);
        return inflateColorStateList;
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getFloat(resources, i6);
        }
        TypedValue typedValue = getTypedValue();
        resources.getValue(i6, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i6) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private ResourcesCompat() {
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context context, @FontRes int i6) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i6, new TypedValue(), 0, null, null, false, true);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i6, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawable(resources, i6, theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i6, int i7, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawableForDensity(resources, i6, i7, theme);
    }

    public static void getFont(@NonNull Context context, @FontRes int i6, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i6, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Resources resources, int i6, @Nullable Resources.Theme theme) {
        if (isColorInt(resources, i6)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i6), theme);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean isColorInt(@NonNull Resources resources, @ColorRes int i6) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i6, typedValue, true);
        int i7 = typedValue.type;
        if (i7 >= 28 && i7 <= 31) {
            return true;
        }
        return false;
    }

    private static Typeface loadFont(@NonNull Context context, Resources resources, @NonNull TypedValue typedValue, int i6, int i7, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z5, boolean z6) {
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            if (!charSequence2.startsWith("res/")) {
                if (fontCallback != null) {
                    fontCallback.callbackFailAsync(-3, handler);
                }
                return null;
            }
            Typeface findFromCache = TypefaceCompat.findFromCache(resources, i6, charSequence2, typedValue.assetCookie, i7);
            if (findFromCache != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(findFromCache, handler);
                }
                return findFromCache;
            }
            if (z6) {
                return null;
            }
            try {
                if (charSequence2.toLowerCase().endsWith(".xml")) {
                    FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources.getXml(i6), resources);
                    if (parse != null) {
                        return TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i6, charSequence2, typedValue.assetCookie, i7, fontCallback, handler, z5);
                    }
                    if (fontCallback != null) {
                        fontCallback.callbackFailAsync(-3, handler);
                    }
                    return null;
                }
                Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, i6, charSequence2, typedValue.assetCookie, i7);
                if (fontCallback != null) {
                    if (createFromResourcesFontFile != null) {
                        fontCallback.callbackSuccessAsync(createFromResourcesFontFile, handler);
                        return createFromResourcesFontFile;
                    }
                    fontCallback.callbackFailAsync(-3, handler);
                }
                return createFromResourcesFontFile;
            } catch (IOException | XmlPullParserException unused) {
                if (fontCallback != null) {
                    fontCallback.callbackFailAsync(-3, handler);
                }
                return null;
            }
        }
        throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i6) + "\" (" + Integer.toHexString(i6) + ") is not a Font: " + typedValue);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i6, @NonNull TypedValue typedValue, int i7, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i6, typedValue, i7, fontCallback, null, true, false);
    }
}
