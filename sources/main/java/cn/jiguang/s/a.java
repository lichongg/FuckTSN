package cn.jiguang.s;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static List<String> f3240a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static List<String> f3241b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static List<String> f3242c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static List<String> f3243d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public static List<String> f3244e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public static List<String> f3245f = new ArrayList();

    static {
        List<String> list;
        List asList;
        if (TextUtils.isEmpty("")) {
            return;
        }
        for (String str : new String(Base64.decode("", 2)).split("~")) {
            String[] split = str.split("-");
            if (split[0].equals("imei")) {
                list = f3240a;
                asList = Arrays.asList(split[1].split("\\|"));
            } else if (split[0].equals(bi.aa)) {
                list = f3241b;
                asList = Arrays.asList(split[1].split("\\|"));
            } else if (split[0].equals("imsi")) {
                list = f3242c;
                asList = Arrays.asList(split[1].split("\\|"));
            } else if (split[0].equals("meid")) {
                list = f3243d;
                asList = Arrays.asList(split[1].split("\\|"));
            } else if (split[0].equals("gsm")) {
                list = f3244e;
                asList = Arrays.asList(split[1].split("\\|"));
            }
            list.addAll(asList);
        }
        f3245f.addAll(f3244e);
        f3245f.addAll(f3240a);
        f3245f.addAll(f3242c);
        f3245f.addAll(f3241b);
        f3245f.addAll(f3243d);
    }

    public static String a(int i6, int i7) {
        List<String> list;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 != 4 || i7 >= f3244e.size()) {
                            return "";
                        }
                        list = f3244e;
                    } else {
                        if (i7 >= f3241b.size()) {
                            return "";
                        }
                        list = f3241b;
                    }
                } else {
                    if (i7 >= f3243d.size()) {
                        return "";
                    }
                    list = f3243d;
                }
            } else {
                if (i7 >= f3242c.size()) {
                    return "";
                }
                list = f3242c;
            }
        } else {
            if (i7 >= f3240a.size()) {
                return "";
            }
            list = f3240a;
        }
        return list.get(i7);
    }
}
