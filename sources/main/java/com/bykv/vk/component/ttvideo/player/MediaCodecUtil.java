package com.bykv.vk.component.ttvideo.player;

import android.util.Pair;
import com.bytedance.sdk.component.utils.vl;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class MediaCodecUtil {
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE;
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final String TAG = "MediaCodecUtil";

    public static String getDolbyCodecs(int i6, int i7) {
        String str;
        if (i6 == 4 || i6 == 5 || i6 == 7) {
            str = "dvhe";
        } else if (i6 == 8) {
            str = "hev1";
        } else {
            if (i6 != 9) {
                return null;
            }
            str = "avc3";
        }
        return str + ".0" + i6 + ".0" + i7;
    }

    public static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            vl.xt(TAG, "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            vl.xt(TAG, "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String group = matcher.group(1);
        Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(group);
        if (num == null) {
            vl.xt(TAG, "Unknown Dolby Vision profile string: ".concat(String.valueOf(group)));
            return null;
        }
        String str2 = strArr[2];
        Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(str2);
        if (num2 != null) {
            return new Pair<>(num, num2);
        }
        vl.xt(TAG, "Unknown Dolby Vision level string: ".concat(String.valueOf(str2)));
        return null;
    }

    static {
        HashMap hashMap = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = hashMap;
        hashMap.put("01", 1);
        hashMap.put("02", 2);
        hashMap.put("03", 4);
        hashMap.put("04", 8);
        hashMap.put("05", 16);
        hashMap.put("06", 32);
        hashMap.put("07", 64);
        hashMap.put("08", 128);
        hashMap.put("09", 256);
        HashMap hashMap2 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = hashMap2;
        hashMap2.put("00", 1);
        hashMap2.put("01", 2);
        hashMap2.put("02", 4);
        hashMap2.put("03", 8);
        hashMap2.put("04", 16);
        hashMap2.put("05", 32);
        hashMap2.put("06", 64);
        hashMap2.put("07", 128);
        hashMap2.put("08", 256);
        hashMap2.put("09", 512);
    }
}
