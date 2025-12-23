package com.ss.android.socialbase.downloader.az;

import io.netty.util.internal.StringUtil;

/* loaded from: D:\Downloads\app\classes6.dex */
public class g {
    public static StringBuilder j(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder xt(StringBuilder sb, String[] strArr) {
        for (int i6 = 0; i6 < strArr.length; i6++) {
            j(sb, strArr[i6]).append("=?");
            if (i6 < strArr.length - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        return sb;
    }

    public static StringBuilder j(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder j(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            sb.append('\"');
            sb.append(strArr[i6]);
            sb.append('\"');
            if (i6 < length - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        return sb;
    }

    public static String xt(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append("\"" + str + '\"');
        sb.append(" (");
        j(sb, strArr);
        sb.append(") VALUES (");
        j(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static StringBuilder j(StringBuilder sb, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 < i6 - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder j(StringBuilder sb, String str, String[] strArr) {
        for (int i6 = 0; i6 < strArr.length; i6++) {
            j(sb, str, strArr[i6]).append("=?");
            if (i6 < strArr.length - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        return sb;
    }

    public static String j(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        j(sb, strArr);
        sb.append(") VALUES (");
        j(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String j(String str, String[] strArr) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            j(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String j(String str, String[] strArr, String[] strArr2) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        xt(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            j(sb, str2, strArr2);
        }
        return sb.toString();
    }
}
