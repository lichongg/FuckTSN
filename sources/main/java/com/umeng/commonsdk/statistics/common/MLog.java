package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class MLog {
    public static boolean DEBUG = false;
    private static final int LEVEL_DEBUG = 2;
    private static final int LEVEL_ERROR = 5;
    private static final int LEVEL_INFO = 3;
    private static final int LEVEL_VERBOSE = 1;
    private static final int LEVEL_WARN = 4;
    private static int LOG_MAXLENGTH = 2000;
    private static String TAG = "MobclickAgent";

    public static void d(Locale locale, String str, Object... objArr) {
        try {
            d(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void e(Locale locale, String str, Object... objArr) {
        try {
            e(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static String getStackTrace(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter = null;
        try {
            StringWriter stringWriter2 = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    stringWriter2.flush();
                    String stringWriter3 = stringWriter2.toString();
                    try {
                        stringWriter2.close();
                    } catch (Throwable unused) {
                    }
                    printWriter.close();
                    return stringWriter3;
                } catch (Throwable unused2) {
                    stringWriter = stringWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    return "";
                }
            } catch (Throwable unused4) {
                printWriter = null;
            }
        } catch (Throwable unused5) {
            printWriter = null;
        }
    }

    public static void i(Locale locale, String str, Object... objArr) {
        try {
            i(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void v(Locale locale, String str, Object... objArr) {
        try {
            v(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void w(Locale locale, String str, Object... objArr) {
        try {
            w(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    private MLog() {
    }

    private static void print(int i6, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i7 = LOG_MAXLENGTH;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i8 >= 100) {
                    break;
                }
                if (length > i7) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                if (i6 != 4) {
                                    if (i6 == 5) {
                                        str2.substring(i9, i7);
                                    }
                                } else {
                                    str2.substring(i9, i7);
                                }
                            } else {
                                str2.substring(i9, i7);
                            }
                        } else {
                            str2.substring(i9, i7);
                        }
                    } else {
                        str2.substring(i9, i7);
                    }
                    i8++;
                    i9 = i7;
                    i7 = LOG_MAXLENGTH + i7;
                } else if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            if (i6 != 4) {
                                if (i6 == 5) {
                                    str2.substring(i9, length);
                                }
                            } else {
                                str2.substring(i9, length);
                            }
                        } else {
                            str2.substring(i9, length);
                        }
                    } else {
                        str2.substring(i9, length);
                    }
                } else {
                    str2.substring(i9, length);
                }
            }
        }
        if (th != null) {
            TextUtils.isEmpty(getStackTrace(th));
        }
    }

    public static void d(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                d(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                d(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void e(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                e(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                e(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void i(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                i(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                i(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void v(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                v(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                v(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void w(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                w(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                w(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void d(Throwable th) {
        d(TAG, (String) null, th);
    }

    public static void e(Throwable th) {
        e(TAG, (String) null, th);
    }

    public static void i(Throwable th) {
        i(TAG, (String) null, th);
    }

    public static void v(Throwable th) {
        v(TAG, (String) null, th);
    }

    public static void w(Throwable th) {
        w(TAG, (String) null, th);
    }

    public static void d(String str, Throwable th) {
        d(TAG, str, th);
    }

    public static void e(String str, Throwable th) {
        e(TAG, str, th);
    }

    public static void i(String str, Throwable th) {
        i(TAG, str, th);
    }

    public static void v(String str, Throwable th) {
        v(TAG, str, th);
    }

    public static void w(String str, Throwable th) {
        w(TAG, str, th);
    }

    public static void d(String str) {
        d(TAG, str, (Throwable) null);
    }

    public static void e(String str) {
        e(TAG, str, (Throwable) null);
    }

    public static void i(String str) {
        i(TAG, str, (Throwable) null);
    }

    public static void v(String str) {
        v(TAG, str, (Throwable) null);
    }

    public static void w(String str) {
        w(TAG, str, (Throwable) null);
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }
}
