package xyz.adscope.common.v2.tool.str;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import xyz.adscope.common.v2.model.IJsonMappingModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StringUtil {
    public static final String EMPTY_LIST_STRING = "[]";
    private static final String PATTERN_CRASH_DATE = "yyyy-MM-dd HH:MM:SS";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class StringStyleBean extends ClickableSpan {
        private final String color;
        private final String str;

        @Override // android.text.style.ClickableSpan
        public abstract void onClick(@NonNull View view);

        public StringStyleBean(String str, String str2) {
            this.str = str;
            this.color = str2;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor(this.color));
            textPaint.setUnderlineText(false);
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String escapeJsonAsString(String str) {
        return str.replace("\"", "\\\"");
    }

    public static String formatCrashLogDate(long j6) {
        return formatDate(j6, PATTERN_CRASH_DATE);
    }

    public static String formatDate(long j6, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j6));
    }

    public static String getFileNameFromURL(String str) {
        try {
            String path = new URL(str).getPath();
            return path.substring(path.lastIndexOf("/") + 1);
        } catch (MalformedURLException unused) {
            if (!str.contains("?")) {
                return str.substring(str.lastIndexOf("/") + 1);
            }
            String substring = str.substring(0, str.indexOf("?"));
            return substring.substring(substring.lastIndexOf("/") + 1);
        }
    }

    public static boolean isValidURL(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public static String jsonMappingListToString(List<? extends IJsonMappingModel> list, String str) {
        if (list == null || list.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<? extends IJsonMappingModel> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toJsonString());
            sb.append(",");
        }
        if (sb.length() > 1) {
            sb.setCharAt(sb.length() - 1, ']');
        } else {
            sb.append("]");
        }
        return sb.toString();
    }

    public static Set<String> jsonMappingListToStringSet(List<? extends IJsonMappingModel> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Iterator<? extends IJsonMappingModel> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toJsonString());
        }
        return hashSet;
    }

    public static SpannableString parseSpannableString(String str, StringStyleBean... stringStyleBeanArr) {
        SpannableString spannableString = new SpannableString(str);
        if (stringStyleBeanArr != null) {
            for (StringStyleBean stringStyleBean : stringStyleBeanArr) {
                int indexOf = str.indexOf(stringStyleBean.str);
                spannableString.setSpan(stringStyleBean, indexOf, stringStyleBean.str.length() + indexOf, 33);
            }
        }
        return spannableString;
    }

    private StringUtil() {
    }

    public static String getFileSuffixFromURL(String str) {
        String fileNameFromURL = getFileNameFromURL(str);
        if (fileNameFromURL.contains(".")) {
            return fileNameFromURL.substring(fileNameFromURL.lastIndexOf(".") + 1);
        }
        return fileNameFromURL;
    }

    public static byte[] hexStringToBytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i6 = 0; i6 < length; i6 += 2) {
            bArr[i6 / 2] = (byte) ((Character.digit(str.charAt(i6), 16) << 4) + Character.digit(str.charAt(i6 + 1), 16));
        }
        return bArr;
    }

    public static boolean isValidColor(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!RegexUtil.match(str, RegexUtil.REGEX_RGB) && !RegexUtil.match(str, RegexUtil.REGEX_RGBA)) {
            return false;
        }
        return true;
    }

    public static boolean modelSizeByPercent(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("%")) {
            return true;
        }
        return false;
    }

    public static double parseDouble(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                return 0.0d;
            }
        }
        return 0.0d;
    }

    public static double parseDoubleOrDefault(String str, double d6) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException unused) {
            }
        }
        return d6;
    }

    public static float parseFloat(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public static int parseInt(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return 0;
    }

    public static long parseLong(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    public static float parseSizePercent(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("%")) {
            return parseFloat(str.substring(0, str.indexOf("%")).trim()) / 100.0f;
        }
        return 0.0f;
    }
}
