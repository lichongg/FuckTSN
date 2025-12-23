package com.bytedance.adsdk.ugeno.m;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: com.bytedance.adsdk.ugeno.m.j$j, reason: collision with other inner class name */
    public static class C0322j {
        public float[] cw;

        /* renamed from: j, reason: collision with root package name */
        public GradientDrawable.Orientation f23709j;
        public int[] xt;
    }

    public static int j(String str) {
        return j(str, ViewCompat.MEASURED_STATE_MASK);
    }

    public static int j(String str, int i6) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("transparent")) {
                return 0;
            }
            if (str.charAt(0) == '#' && str.length() == 4) {
                StringBuilder sb = new StringBuilder("#");
                char[] charArray = str.toCharArray();
                for (int i7 = 1; i7 < charArray.length; i7++) {
                    sb.append(charArray[i7]);
                    sb.append(charArray[i7]);
                }
                return Color.parseColor(sb.toString());
            }
            if (str.charAt(0) == '#' && str.length() == 7) {
                return Color.parseColor(str);
            }
            if (str.charAt(0) == '#' && str.length() == 9) {
                return Color.parseColor(str);
            }
            if (!str.startsWith("rgba")) {
                return ViewCompat.MEASURED_STATE_MASK;
            }
            String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
            if (split != null && split.length == 4) {
                return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2]));
            }
        }
        return i6;
    }

    public static GradientDrawable.Orientation r(String str) {
        try {
            int parseInt = str.contains("deg") ? Integer.parseInt(str.substring(0, str.length() - 3).trim()) : Integer.parseInt(str);
            return parseInt == 90 ? GradientDrawable.Orientation.LEFT_RIGHT : parseInt == 180 ? GradientDrawable.Orientation.TOP_BOTTOM : parseInt == 270 ? GradientDrawable.Orientation.RIGHT_LEFT : parseInt == 135 ? GradientDrawable.Orientation.TL_BR : parseInt == 45 ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public static C0322j xt(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String substring = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            int j6 = j(substring, '%');
            int indexOf = substring.indexOf(",");
            String substring2 = substring.substring(0, indexOf);
            C0322j c0322j = new C0322j();
            c0322j.f23709j = r(substring2);
            String substring3 = substring.substring(indexOf + 1);
            int[] iArr = new int[j6];
            float[] fArr = new float[j6];
            for (int i6 = 0; i6 < j6; i6++) {
                int indexOf2 = substring3.indexOf("%");
                String trim = substring3.substring(0, indexOf2 + 1).trim();
                int indexOf3 = (trim.contains("rgba") ? trim.indexOf(")") : trim.indexOf(" ")) + 1;
                iArr[i6] = j(trim.substring(0, indexOf3).trim());
                fArr[i6] = cw.j(trim.substring(indexOf3, trim.indexOf("%")).trim(), 0.0f) / 100.0f;
                int i7 = indexOf2 + 2;
                if (substring3.length() <= i7) {
                    break;
                }
                substring3 = substring3.substring(i7);
            }
            if (j6 < 2) {
                return null;
            }
            c0322j.xt = iArr;
            c0322j.cw = fArr;
            return c0322j;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean cw(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("linear-gradient")) {
            return false;
        }
        return true;
    }

    public static int j(String str, char c6) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < str.length(); i7++) {
            if (str.charAt(i7) == c6) {
                i6++;
            }
        }
        return i6;
    }

    public static int j(int i6, int i7) {
        if (i7 < 0 || i7 > 255) {
            vl.r("ColorUtils", "alpha must be between 0 and 255. ");
            i7 = 255;
        }
        return (i6 & 16777215) | (i7 << 24);
    }
}
