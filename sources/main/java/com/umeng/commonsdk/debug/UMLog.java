package com.umeng.commonsdk.debug;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMLog {
    private static final String AQ = "├───────────────────解决方案─────────────────────────────────────────────────────────────────────────────";
    private static final String BOTTOM_BORDER = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final char BOTTOM_LEFT_CORNER = 9492;
    private static final String DOUBLE_DIVIDER = "────────────────────────────────────────────────────────";
    private static final String DOUBLE_DIVIDER_AQ = "───────────────────问题─────────────────────";
    private static final char HORIZONTAL_LINE = 9474;
    private static final String INDENT = "     ";
    private static final int JSON_INDENT = 2;
    private static final int KEYLENGTH = 10;
    private static final String MIDDLE_BORDER = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final char MIDDLE_CORNER = 9500;
    private static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String SINGLE_DIVIDER_AQ = "───────────────────解决方案─────────────────────";
    private static final String TAG = "UMLog";
    private static final String TOP_BORDER = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String TOP_BORDER_AQ = "┌───────────────────问题─────────────────────────────────────────────────────────────────────────────";
    private static final char TOP_LEFT_CORNER = 9484;

    public static void aq(int i6, String str, String str2) {
        try {
            if (UMConfigure.isDebugLog()) {
                UInterface logger = getLogger(i6);
                logger.log(TAG, TOP_BORDER_AQ);
                logger.log(TAG, "│     " + str);
                logger.log(TAG, AQ);
                logger.log(TAG, "│     " + str2);
                logger.log(TAG, BOTTOM_BORDER);
            }
        } catch (Exception unused) {
        }
    }

    public static void bundle(int i6, Bundle bundle) {
        bundle(null, i6, bundle);
    }

    public static void jsonArry(JSONArray jSONArray) {
        try {
            if (UMConfigure.isDebugLog()) {
                jSONArray.toString(2);
            }
        } catch (Exception unused) {
        }
    }

    public static void jsonObject(JSONObject jSONObject) {
        try {
            if (UMConfigure.isDebugLog()) {
                jSONObject.toString(2);
            }
        } catch (Exception unused) {
        }
    }

    public static void mutlInfo(int i6, String... strArr) {
        try {
            if (UMConfigure.isDebugLog()) {
                int length = strArr.length;
                UInterface logger = getLogger(i6);
                if (length == 1) {
                    logger.log(TAG, strArr[0]);
                    return;
                }
                if (length >= 2) {
                    logger.log(TAG, TOP_BORDER);
                    for (int i7 = 0; i7 < length; i7++) {
                        logger.log(TAG, "│     " + strArr[i7]);
                        if (i7 != length - 1) {
                            logger.log(TAG, MIDDLE_BORDER);
                        }
                    }
                    logger.log(TAG, BOTTOM_BORDER);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void bundle(String str, int i6, Bundle bundle) {
        try {
            if (UMConfigure.isDebugLog()) {
                String str2 = TextUtils.isEmpty(str) ? TAG : "UMLog_" + str;
                if (bundle != null) {
                    UInterface logger = getLogger(i6);
                    logger.log(str2, TOP_BORDER);
                    logger.log(str2, "│key│value");
                    logger.log(str2, MIDDLE_BORDER);
                    for (String str3 : bundle.keySet()) {
                        if (!TextUtils.isEmpty(str3) && bundle.get(str3) != null) {
                            logger.log(str2, HORIZONTAL_LINE + str3 + HORIZONTAL_LINE + bundle.get(str3).toString());
                            logger.log(str2, MIDDLE_BORDER);
                        }
                    }
                    logger.log(str2, BOTTOM_BORDER);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static UInterface getLogger(int i6) {
        return i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 3 ? new D() : new D() : new I() : new W() : new E();
    }

    public static void jsonArry(String str, JSONArray jSONArray) {
        try {
            if (UMConfigure.isDebugLog()) {
                jSONArray.toString(2);
            }
        } catch (Exception unused) {
        }
    }

    public static void jsonObject(String str, JSONObject jSONObject) {
        try {
            if (UMConfigure.isDebugLog()) {
                jSONObject.toString(2);
            }
        } catch (Exception unused) {
        }
    }

    public static void aq(String str, int i6, String str2, String str3) {
        try {
            if (UMConfigure.isDebugLog()) {
                UInterface logger = getLogger(i6);
                String str4 = "UMLog_" + str;
                logger.log(str4, TOP_BORDER_AQ);
                logger.log(str4, "│     " + str2);
                logger.log(str4, AQ);
                logger.log(str4, "│     " + str3);
                logger.log(str4, BOTTOM_BORDER);
            }
        } catch (Exception unused) {
        }
    }

    public static void mutlInfo(String str, int i6, String... strArr) {
        try {
            if (UMConfigure.isDebugLog()) {
                int length = strArr.length;
                UInterface logger = getLogger(i6);
                String str2 = "UMLog_" + str;
                if (length == 1) {
                    logger.log(str2, strArr[0]);
                    return;
                }
                if (length >= 2) {
                    logger.log(str2, TOP_BORDER);
                    for (int i7 = 0; i7 < length; i7++) {
                        logger.log(str2, "│     " + strArr[i7]);
                        if (i7 != length - 1) {
                            logger.log(str2, MIDDLE_BORDER);
                        }
                    }
                    logger.log(str2, BOTTOM_BORDER);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void aq(String str, int i6, String str2) {
        aq((String) null, str, i6, str2);
    }

    public static void aq(String str, int i6, String str2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        aq(null, str, i6, str2, strArr, strArr2, strArr3, strArr4);
    }

    public static void aq(String str, String str2, int i6, String str3) {
        aq(str, str2, i6, str3, null, null, null, null);
    }

    public static void aq(String str, String str2, int i6, String str3, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        String[] split;
        try {
            if (UMConfigure.isDebugLog()) {
                String str4 = TextUtils.isEmpty(str) ? TAG : "UMLog_" + str;
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (split = str2.split(str3)) == null || split.length < 2) {
                    return;
                }
                if (strArr != null && strArr.length > 0 && strArr2 != null && strArr2.length > 0) {
                    for (int i7 = 0; i7 < strArr.length && i7 < strArr2.length; i7++) {
                        split[0] = split[0].replace(strArr[i7], strArr2[i7]);
                    }
                }
                if (strArr3 != null && strArr3.length > 0 && strArr4 != null && strArr4.length > 0) {
                    for (int i8 = 0; i8 < strArr3.length && i8 < strArr4.length; i8++) {
                        split[1] = split[1].replace(strArr3[i8], strArr4[i8]);
                    }
                }
                UInterface logger = getLogger(i6);
                logger.log(str4, TOP_BORDER_AQ);
                logger.log(str4, "│     " + split[0]);
                logger.log(str4, AQ);
                logger.log(str4, "│     " + split[1]);
                logger.log(str4, BOTTOM_BORDER);
            }
        } catch (Exception unused) {
        }
    }

    public static void mutlInfo(String str, int i6, String str2) {
        mutlInfo(null, str, i6, str2);
    }

    public static void mutlInfo(String str, int i6, String str2, String[] strArr, String[] strArr2) {
        mutlInfo(null, str, i6, str2, strArr, strArr2);
    }

    public static void mutlInfo(String str, String str2, int i6, String str3) {
        mutlInfo(str, str2, i6, str3, null, null);
    }

    public static void mutlInfo(String str, String str2, int i6, String str3, String[] strArr, String[] strArr2) {
        try {
            if (UMConfigure.isDebugLog()) {
                String str4 = TextUtils.isEmpty(str) ? TAG : "UMLog_" + str;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (strArr != null && strArr.length > 0 && strArr2 != null && strArr2.length > 0) {
                    for (int i7 = 0; i7 < strArr.length && i7 < strArr2.length; i7++) {
                        str2 = str2.replace(strArr[i7], strArr2[i7]);
                    }
                }
                UInterface logger = getLogger(i6);
                if (TextUtils.isEmpty(str3)) {
                    logger.log(str4, str2);
                    return;
                }
                String[] split = str2.split(str3);
                if (split != null) {
                    logger.log(str4, TOP_BORDER);
                    for (int i8 = 0; i8 < split.length; i8++) {
                        logger.log(str4, "│     " + split[i8]);
                        if (i8 != split.length - 1) {
                            logger.log(str4, MIDDLE_BORDER);
                        }
                    }
                    logger.log(str4, BOTTOM_BORDER);
                }
            }
        } catch (Exception unused) {
        }
    }
}
