package cn.jiguang.u;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.w;
import cn.jiguang.internal.JConstants;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    public static cn.jiguang.t.a a(Context context) {
        if (JConstants.isAndroidQ(context, false, "need get getDefaultApiSimInfo")) {
            return null;
        }
        cn.jiguang.t.a aVar = new cn.jiguang.t.a();
        aVar.f3247b = "";
        aVar.f3247b = cn.jiguang.bz.a.a().e(context, "");
        aVar.f3248c = "";
        aVar.f3248c = cn.jiguang.bz.a.a().c(context, "");
        aVar.f3246a = "";
        aVar.f3246a = cn.jiguang.bz.a.a().d(context, "");
        return aVar;
    }

    private static String b(Context context, String[] strArr) {
        StringBuilder sb;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        String a6 = a(context, cn.jiguang.s.a.a(3, 0));
        if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
            a6 = a(context, cn.jiguang.s.a.a(3, 1)) + "," + a(context, cn.jiguang.s.a.a(3, 2));
            if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                a6 = a(context, cn.jiguang.s.a.a(3, 4)) + "," + a(context, cn.jiguang.s.a.a(3, 5));
                if ((a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) && ((a6 = a(context, cn.jiguang.s.a.a(3, 6))) == null || TextUtils.isEmpty(a6.trim().replace(",", "")))) {
                    a6 = a(context, cn.jiguang.s.a.a(3, 7)) + "," + a(context, cn.jiguang.s.a.a(3, 8));
                    if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                        a6 = a(context, cn.jiguang.s.a.a(3, 9)) + "," + a(context, cn.jiguang.s.a.a(3, 10));
                        if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                            a6 = a(context, cn.jiguang.s.a.a(3, 12)) + "," + a(context, cn.jiguang.s.a.a(3, 12));
                            if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                a6 = a(context, cn.jiguang.s.a.a(3, 13)) + "," + a(context, cn.jiguang.s.a.a(3, 14));
                                if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                    String a7 = a(context, cn.jiguang.s.a.a(3, 3));
                                    if (length == 1) {
                                        a6 = a7;
                                    } else {
                                        if ("ABSENT".equalsIgnoreCase(strArr[1]) && !"ABSENT".equalsIgnoreCase(strArr[0])) {
                                            sb = new StringBuilder();
                                            sb.append(a7);
                                            sb.append(",");
                                        } else if (!"ABSENT".equalsIgnoreCase(strArr[1])) {
                                            sb = new StringBuilder();
                                            sb.append(",");
                                            sb.append(a7);
                                        }
                                        a6 = sb.toString();
                                    }
                                    if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                        return a6;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return a6.replace("null", "").replace("N/A", "");
    }

    public static String a(Context context, String str) {
        return w.m(str);
    }

    public static ArrayList<cn.jiguang.t.a> b(Context context) {
        String a6 = a(context, cn.jiguang.s.a.a(4, 1));
        String a7 = a(context, cn.jiguang.s.a.a(4, 0));
        if (a6 != null && !TextUtils.isEmpty(a6)) {
            a7 = a7 + "," + a6;
        }
        String[] split = TextUtils.isEmpty(a7) ? null : a7.split(",");
        int length = split == null ? 1 : split.length;
        if (length == 0) {
            return null;
        }
        ArrayList<cn.jiguang.t.a> arrayList = new ArrayList<>();
        String a8 = cn.jiguang.g.a.a().e(1024) ? a(context, split) : null;
        String b6 = cn.jiguang.g.a.a().e(1023) ? b(context, split) : null;
        String c6 = cn.jiguang.g.a.a().e(1025) ? c(context, split) : null;
        if (length == 1) {
            cn.jiguang.t.a aVar = new cn.jiguang.t.a();
            aVar.f3246a = a(a8 == null ? null : a8.trim());
            if (!"ABSENT".equalsIgnoreCase(a7)) {
                aVar.f3248c = b6 == null ? null : b6.trim();
                aVar.f3247b = c6 != null ? c6.trim() : null;
            }
            arrayList.add(aVar);
            return arrayList;
        }
        String[] split2 = a8 != null ? a8.split(",") : null;
        String[] split3 = c6 != null ? c6.split(",") : null;
        String[] split4 = b6 != null ? b6.split(",") : null;
        for (int i6 = 0; i6 < 2; i6++) {
            cn.jiguang.t.a aVar2 = new cn.jiguang.t.a();
            if (split2 != null && i6 < split2.length) {
                aVar2.f3246a = a(split2[i6]);
            }
            if (!"ABSENT".equalsIgnoreCase(split[i6])) {
                if (split3 != null && i6 < split3.length) {
                    aVar2.f3247b = split3[i6];
                }
                if (split4 != null && i6 < split4.length) {
                    aVar2.f3248c = split4[i6];
                }
            }
            arrayList.add(aVar2);
        }
        return arrayList;
    }

    private static String c(Context context, String[] strArr) {
        String replace;
        StringBuilder sb;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        String a6 = a(context, cn.jiguang.s.a.a(1, 0));
        String a7 = a(context, cn.jiguang.s.a.a(1, 1));
        if (!TextUtils.isEmpty(a7)) {
            a6 = a6 + "," + a7;
        }
        if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
            String a8 = a(context, cn.jiguang.s.a.a(1, 2));
            if ((a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) && ((a8 = a(context, cn.jiguang.s.a.a(1, 3))) == null || TextUtils.isEmpty(a8.trim().replace(",", "")) || !a8.contains(","))) {
                String a9 = a(context, cn.jiguang.s.a.a(1, 4));
                if (a9 == null || TextUtils.isEmpty(a9.trim().replace(",", "")) || !a9.contains(",")) {
                    return a9;
                }
                replace = a9.replace("null", "");
            } else {
                replace = a8.replace("null", "");
            }
        } else {
            if (length > 1 && !a6.contains(",")) {
                if ("ABSENT".equalsIgnoreCase(strArr[0])) {
                    sb = new StringBuilder();
                    sb.append(",");
                    sb.append(a6);
                } else {
                    sb = new StringBuilder();
                    sb.append(a6);
                    sb.append(",");
                }
                a6 = sb.toString();
            }
            replace = a6.replace("null", "");
        }
        return replace.replace("N/A", "");
    }

    private static String a(Context context, String[] strArr) {
        String a6;
        StringBuilder sb;
        String replace;
        String a7;
        StringBuilder sb2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        String a8 = a(context, cn.jiguang.s.a.a(0, 0));
        if (TextUtils.isEmpty(a8)) {
            a8 = a(context, cn.jiguang.s.a.a(0, 2));
        }
        if (length > 1) {
            a8 = a8 + "," + a(context, cn.jiguang.s.a.a(0, 1));
        }
        if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
            a8 = a(context, cn.jiguang.s.a.a(0, 3)) + "," + a(context, cn.jiguang.s.a.a(0, 4));
            if ((a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) && ((a8 = a(context, cn.jiguang.s.a.a(0, 6))) == null || TextUtils.isEmpty(a8.trim().replace(",", "")))) {
                String a9 = a(context, cn.jiguang.s.a.a(0, 8));
                String a10 = a(context, cn.jiguang.s.a.a(0, 9));
                String a11 = a(context, cn.jiguang.s.a.a(0, 10));
                if (TextUtils.isEmpty(a10)) {
                    a8 = a9 + "," + a(context, cn.jiguang.s.a.a(0, 10));
                } else if (TextUtils.isEmpty(a11)) {
                    a8 = a9 + "," + a10;
                } else {
                    a8 = a10 + "," + a11;
                }
                if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                    a8 = a(context, cn.jiguang.s.a.a(0, 36)) + "," + a(context, cn.jiguang.s.a.a(0, 37));
                    if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                        a8 = a(context, cn.jiguang.s.a.a(0, 21));
                        if (!TextUtils.isEmpty(a8)) {
                            String a12 = a(context, cn.jiguang.s.a.a(0, 20));
                            if (TextUtils.isEmpty(a12)) {
                                a8 = a(context, cn.jiguang.s.a.a(0, 22)) + "," + a8;
                            } else {
                                a8 = a12 + "," + a8;
                            }
                        }
                        if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                            a8 = a(context, cn.jiguang.s.a.a(0, 11));
                            if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                String a13 = a(context, cn.jiguang.s.a.a(0, 14));
                                if (TextUtils.isEmpty(a13)) {
                                    a13 = a(context, cn.jiguang.s.a.a(0, 13));
                                }
                                a8 = a13 + "," + a(context, cn.jiguang.s.a.a(0, 15));
                                if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                    a8 = a(context, cn.jiguang.s.a.a(0, 17)) + "," + a(context, cn.jiguang.s.a.a(0, 18));
                                    if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                        a8 = a(context, cn.jiguang.s.a.a(0, 22));
                                        if (TextUtils.isEmpty(a8)) {
                                            a8 = a(context, cn.jiguang.s.a.a(0, 23));
                                        }
                                        if (a8 == null || TextUtils.isEmpty(a8)) {
                                            a8 = a(context, cn.jiguang.s.a.a(0, 26));
                                            if (a8 == null || TextUtils.isEmpty(a8.trim())) {
                                                a8 = a(context, cn.jiguang.s.a.a(0, 27)) + "," + a(context, cn.jiguang.s.a.a(0, 28));
                                                if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                    a8 = a(context, cn.jiguang.s.a.a(0, 29)) + "," + a(context, cn.jiguang.s.a.a(0, 30));
                                                    if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                        a8 = a(context, cn.jiguang.s.a.a(0, 31)) + "," + a(context, cn.jiguang.s.a.a(0, 32));
                                                        if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                            a8 = a(context, cn.jiguang.s.a.a(0, 33)) + "," + a(context, cn.jiguang.s.a.a(0, 34));
                                                            if ((a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) && ((a8 = a(context, cn.jiguang.s.a.a(0, 35))) == null || TextUtils.isEmpty(a8.trim().replace(",", "")))) {
                                                                a8 = a(context, cn.jiguang.s.a.a(0, 42)) + "," + a(context, cn.jiguang.s.a.a(0, 43));
                                                                if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                                    a8 = a(context, cn.jiguang.s.a.a(0, 44)) + "," + a(context, cn.jiguang.s.a.a(0, 45));
                                                                    if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                                        String a14 = a(context, cn.jiguang.s.a.a(0, 16));
                                                                        if (a14 == null || TextUtils.isEmpty(a14.trim())) {
                                                                            a8 = a(context, cn.jiguang.s.a.a(0, 19));
                                                                            if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                                                a8 = a(context, cn.jiguang.s.a.a(0, 39)) + "," + a(context, cn.jiguang.s.a.a(0, 40));
                                                                                if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                                                    a8 = a(context, cn.jiguang.s.a.a(0, 38));
                                                                                    if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                                                        a8 = a(context, cn.jiguang.s.a.a(0, 7));
                                                                                        if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                                                            a8 = a(context, cn.jiguang.s.a.a(0, 5));
                                                                                            if (a8 == null || TextUtils.isEmpty(a8.trim().replace(",", ""))) {
                                                                                                a6 = a(context, cn.jiguang.s.a.a(0, 41));
                                                                                                if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                                                                    return a6;
                                                                                                }
                                                                                            } else if (length > 1) {
                                                                                                sb = new StringBuilder();
                                                                                                sb.append(",");
                                                                                                sb.append(a8);
                                                                                                a8 = sb.toString();
                                                                                            }
                                                                                        }
                                                                                    } else if (length > 1) {
                                                                                        sb = new StringBuilder();
                                                                                        sb.append(a8);
                                                                                        sb.append(",");
                                                                                        a8 = sb.toString();
                                                                                    }
                                                                                } else if (length > 1) {
                                                                                    sb = new StringBuilder();
                                                                                    sb.append(a8);
                                                                                    sb.append(",");
                                                                                    a8 = sb.toString();
                                                                                }
                                                                            }
                                                                        } else {
                                                                            a6 = a14 + ",";
                                                                        }
                                                                        replace = a6.replace("null", "");
                                                                        return replace.replace("N/A", "");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            String a15 = a(context, cn.jiguang.s.a.a(0, 24));
                                            a7 = a(context, cn.jiguang.s.a.a(0, 25));
                                            if (TextUtils.isEmpty(a15) || TextUtils.isEmpty(a7)) {
                                                if (!TextUtils.isEmpty(a15)) {
                                                    sb = new StringBuilder();
                                                    sb.append(a8);
                                                    sb.append(",");
                                                    sb.append(a15);
                                                } else if (!TextUtils.isEmpty(a7)) {
                                                    sb2 = new StringBuilder();
                                                    sb2.append(a8);
                                                } else if (length > 1 && !a8.contains(",")) {
                                                    sb = new StringBuilder();
                                                    sb.append(a8);
                                                    sb.append(",");
                                                }
                                                a8 = sb.toString();
                                            } else {
                                                sb2 = new StringBuilder();
                                                sb2.append(a15);
                                            }
                                            sb2.append(",");
                                            sb2.append(a7);
                                            a8 = sb2.toString();
                                        }
                                    }
                                }
                            } else {
                                a7 = a(context, cn.jiguang.s.a.a(0, 12));
                                if (!TextUtils.isEmpty(a7)) {
                                    sb2 = new StringBuilder();
                                    sb2.append(a8);
                                    sb2.append(",");
                                    sb2.append(a7);
                                    a8 = sb2.toString();
                                }
                            }
                        }
                    }
                }
            }
        }
        replace = a8.replace("null", "");
        return replace.replace("N/A", "");
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() < 14) {
            return null;
        }
        return str;
    }
}
