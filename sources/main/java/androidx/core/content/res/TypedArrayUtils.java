package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    public static int getAttr(@NonNull Context context, int i6, int i7) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i6, typedValue, true);
        return typedValue.resourceId != 0 ? i6 : i7;
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        return xmlPullParser.getAttributeValue(NAMESPACE, str) != null;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private TypedArrayUtils() {
    }

    public static boolean getBoolean(@NonNull TypedArray typedArray, @StyleableRes int i6, @StyleableRes int i7, boolean z5) {
        return typedArray.getBoolean(i6, typedArray.getBoolean(i7, z5));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray typedArray, @StyleableRes int i6, @StyleableRes int i7) {
        Drawable drawable = typedArray.getDrawable(i6);
        if (drawable == null) {
            return typedArray.getDrawable(i7);
        }
        return drawable;
    }

    public static int getInt(@NonNull TypedArray typedArray, @StyleableRes int i6, @StyleableRes int i7, int i8) {
        return typedArray.getInt(i6, typedArray.getInt(i7, i8));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i6, boolean z5) {
        if (!hasAttribute(xmlPullParser, str)) {
            return z5;
        }
        return typedArray.getBoolean(i6, z5);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i6, @ColorInt int i7) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i7;
        }
        return typedArray.getColor(i6, i7);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i6) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i6, typedValue);
            int i7 = typedValue.type;
            if (i7 != 2) {
                if (i7 >= 28 && i7 <= 31) {
                    return getNamedColorStateListFromInt(typedValue);
                }
                return ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i6, 0), theme);
            }
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i6 + ": " + typedValue);
        }
        return null;
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i6, @ColorInt int i7) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i6, typedValue);
            int i8 = typedValue.type;
            if (i8 >= 28 && i8 <= 31) {
                return ComplexColorCompat.from(typedValue.data);
            }
            ComplexColorCompat inflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i6, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return ComplexColorCompat.from(i7);
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i6, float f6) {
        if (!hasAttribute(xmlPullParser, str)) {
            return f6;
        }
        return typedArray.getFloat(i6, f6);
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i6, int i7) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i7;
        }
        return typedArray.getInt(i6, i7);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i6, @AnyRes int i7) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i7;
        }
        return typedArray.getResourceId(i6, i7);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i6) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i6);
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray typedArray, @StyleableRes int i6, @StyleableRes int i7, @AnyRes int i8) {
        return typedArray.getResourceId(i6, typedArray.getResourceId(i7, i8));
    }

    @Nullable
    public static String getString(@NonNull TypedArray typedArray, @StyleableRes int i6, @StyleableRes int i7) {
        String string = typedArray.getString(i6);
        if (string == null) {
            return typedArray.getString(i7);
        }
        return string;
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray typedArray, @StyleableRes int i6, @StyleableRes int i7) {
        CharSequence text = typedArray.getText(i6);
        if (text == null) {
            return typedArray.getText(i7);
        }
        return text;
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray typedArray, @StyleableRes int i6, @StyleableRes int i7) {
        CharSequence[] textArray = typedArray.getTextArray(i6);
        if (textArray == null) {
            return typedArray.getTextArray(i7);
        }
        return textArray;
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i6) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i6);
    }
}
