package com.bytedance.sdk.openadsdk.core.tj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class la {
    private static int av;
    private static int az;
    private static int cw;

    /* renamed from: g, reason: collision with root package name */
    private static int f30318g;

    /* renamed from: i, reason: collision with root package name */
    private static int f30319i;

    /* renamed from: j, reason: collision with root package name */
    private static int f30320j;
    private static int jy;
    private static int oq;
    private static int qv;

    /* renamed from: r, reason: collision with root package name */
    private static int f30322r;
    private static int vl;

    /* renamed from: w, reason: collision with root package name */
    private static int f30323w;
    private static int ws;
    private static int xt;

    /* renamed from: f, reason: collision with root package name */
    private final int f30324f;
    private final int kt;
    private final int mi;
    private final int tj;

    /* renamed from: v, reason: collision with root package name */
    private final int f30325v;

    /* renamed from: x, reason: collision with root package name */
    private final String f30326x;
    private static final ArrayList<int[]> up = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private static final ArrayList<int[]> f30321m = new ArrayList<>();
    private static final ArrayList<int[]> ae = new ArrayList<>();
    private static final ArrayList<int[]> tl = new ArrayList<>();

    public static int ae() {
        return az;
    }

    public static boolean cw() {
        return ws == 1;
    }

    public static void j(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            try {
                int optInt = optJSONObject.optInt("insert_ad_control", 1);
                f30320j = optInt;
                if (optInt < 0 || optInt > 1) {
                    f30320j = 1;
                }
                int optInt2 = optJSONObject.optInt("insert_ad_control_fs", 1);
                xt = optInt2;
                if (optInt2 < 0 || optInt2 > 1) {
                    xt = 1;
                }
                cw = optJSONObject.optInt("insert_ad_req_num", 3);
                f30322r = optJSONObject.optInt("insert_ad_req_num_fs", 2);
                f30318g = optJSONObject.optInt("insert_ad_toast_max_time", 5);
                oq = optJSONObject.optInt("insert_ad_tip_max_time", 0);
                qv = optJSONObject.optInt("insert_ad_tip_max_time_fs", 3);
                vl = optJSONObject.optInt("refresh_ad_tip_max_time", 3);
                jy = optJSONObject.optInt("refresh_ad_tip_max_time_fs", 3);
                int optInt3 = optJSONObject.optInt("refresh_ad_control", 1);
                ws = optInt3;
                if (optInt3 < 0 || optInt3 > 1) {
                    ws = 1;
                }
                az = optJSONObject.optInt("refresh_ad_req_num", 3);
                int optInt4 = optJSONObject.optInt("force_refresh_ad_control", 1);
                av = optInt4;
                if (optInt4 < 0 || optInt4 > 1) {
                    av = 1;
                }
                f30319i = optJSONObject.optInt("force_refresh_ad_pause_over_time", 5000);
                f30323w = optJSONObject.optInt("refresh_ad_reduce_time", 0);
                JSONArray optJSONArray = optJSONObject.optJSONArray("insert_ad_pt_show_time");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    up.add(new int[]{0, 500});
                } else {
                    up.clear();
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i6);
                        if (optJSONArray2 != null && optJSONArray2.length() == 2) {
                            up.add(new int[]{optJSONArray2.optInt(0), optJSONArray2.optInt(1)});
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("insert_ad_vd_show_time");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    f30321m.add(new int[]{0, 500});
                } else {
                    f30321m.clear();
                    for (int i7 = 0; i7 < optJSONArray3.length(); i7++) {
                        JSONArray optJSONArray4 = optJSONArray3.optJSONArray(i7);
                        if (optJSONArray4 != null && optJSONArray4.length() == 2) {
                            f30321m.add(new int[]{optJSONArray4.optInt(0), optJSONArray4.optInt(1)});
                        }
                    }
                }
                JSONArray optJSONArray5 = optJSONObject.optJSONArray("insert_ad_pt_show_time_fs");
                if (optJSONArray5 == null || optJSONArray5.length() <= 0) {
                    ae.add(new int[]{0, 500});
                } else {
                    ae.clear();
                    for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                        JSONArray optJSONArray6 = optJSONArray5.optJSONArray(i8);
                        if (optJSONArray6 != null && optJSONArray6.length() == 2) {
                            ae.add(new int[]{optJSONArray6.optInt(0), optJSONArray6.optInt(1)});
                        }
                    }
                }
                JSONArray optJSONArray7 = optJSONObject.optJSONArray("insert_ad_vd_show_time_fs");
                if (optJSONArray7 == null || optJSONArray7.length() <= 0) {
                    tl.add(new int[]{0, 500});
                    return;
                }
                tl.clear();
                for (int i9 = 0; i9 < optJSONArray7.length(); i9++) {
                    JSONArray optJSONArray8 = optJSONArray7.optJSONArray(i9);
                    if (optJSONArray8 != null && optJSONArray8.length() == 2) {
                        tl.add(new int[]{optJSONArray8.optInt(0), optJSONArray8.optInt(1)});
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static int m() {
        return f30322r;
    }

    public static boolean r() {
        return av == 1;
    }

    public static int up() {
        return cw;
    }

    public static boolean xt() {
        return xt == 1;
    }

    private static la ae(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.z();
    }

    public static int cw(n nVar) {
        la ae2 = ae(nVar);
        if (ae2 == null) {
            return 0;
        }
        return ae2.tj;
    }

    public static int g() {
        return f30319i;
    }

    public static String m(n nVar) {
        la ae2 = ae(nVar);
        return ae2 == null ? "秒后将继续播放下一个" : ae2.f30326x;
    }

    public static int oq() {
        return f30323w / 1000;
    }

    public static int r(n nVar) {
        la ae2 = ae(nVar);
        if (ae2 == null) {
            return -1;
        }
        return ae2.f30325v;
    }

    public static int tl() {
        return f30318g;
    }

    public static int up(n nVar) {
        la ae2 = ae(nVar);
        if (ae2 == null) {
            return 0;
        }
        return ae2.f30324f;
    }

    public static int xt(boolean z5) {
        return z5 ? vl : jy;
    }

    public la(JSONObject jSONObject) {
        this.f30325v = jSONObject.optInt("carousel_pos", -1);
        this.mi = jSONObject.optInt("insert_ad_control", 0);
        this.kt = jSONObject.optInt("refresh_ad_control", 0);
        this.f30324f = jSONObject.optInt("refresh_ad_imp_max_time", 0);
        this.tj = jSONObject.optInt("force_refresh_ad_control", 0);
        this.f30326x = jSONObject.optString("carousel_tip_content", "秒后将继续播放下一个");
    }

    private static boolean cw(n nVar, boolean z5) {
        return (!z5 || f30320j == 1) && j(nVar) == 1 && r(nVar) > 0;
    }

    private static boolean r(n nVar, boolean z5) {
        return (!z5 || xt == 1) && j(nVar) == 1 && r(nVar) > 0;
    }

    private static boolean xt(boolean z5, int i6) {
        if (z5) {
            Iterator<int[]> it = tl.iterator();
            while (it.hasNext()) {
                int[] next = it.next();
                if (i6 >= next[0] && i6 <= next[1]) {
                    return true;
                }
            }
        } else {
            Iterator<int[]> it2 = ae.iterator();
            while (it2.hasNext()) {
                int[] next2 = it2.next();
                if (i6 >= next2[0] && i6 <= next2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void xt(com.bytedance.sdk.component.r.j.xt xtVar) {
        try {
            xtVar.j("insert_ad_control", f30320j);
            xtVar.j("insert_ad_control_fs", xt);
            xtVar.j("insert_ad_req_num", cw);
            xtVar.j("insert_ad_req_num_fs", f30322r);
            xtVar.j("insert_ad_toast_max_time", f30318g);
            xtVar.j("insert_ad_tip_max_time", oq);
            xtVar.j("insert_ad_tip_max_time_fs", qv);
            xtVar.j("refresh_ad_tip_max_time", vl);
            xtVar.j("refresh_ad_tip_max_time_fs", jy);
            xtVar.j("refresh_ad_control", ws);
            xtVar.j("refresh_ad_req_num", az);
            xtVar.j("force_refresh_ad_control", av);
            xtVar.j("force_refresh_ad_pause_over_time", f30319i);
            xtVar.j("refresh_ad_reduce_time", f30323w);
            ArrayList<int[]> arrayList = up;
            if (!arrayList.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator<int[]> it = arrayList.iterator();
                while (it.hasNext()) {
                    int[] next = it.next();
                    if (next != null && next.length == 2) {
                        hashSet.add(next[0] + "," + next[1]);
                    }
                }
                xtVar.j("insert_ad_pt_show_time", hashSet);
            }
            ArrayList<int[]> arrayList2 = f30321m;
            if (!arrayList2.isEmpty()) {
                HashSet hashSet2 = new HashSet();
                Iterator<int[]> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    int[] next2 = it2.next();
                    if (next2 != null && next2.length == 2) {
                        hashSet2.add(next2[0] + "," + next2[1]);
                    }
                }
                xtVar.j("insert_ad_vd_show_time", hashSet2);
            }
            ArrayList<int[]> arrayList3 = ae;
            if (!arrayList3.isEmpty()) {
                HashSet hashSet3 = new HashSet();
                Iterator<int[]> it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    int[] next3 = it3.next();
                    if (next3 != null && next3.length == 2) {
                        hashSet3.add(next3[0] + "," + next3[1]);
                    }
                }
                xtVar.j("insert_ad_pt_show_time_fs", hashSet3);
            }
            ArrayList<int[]> arrayList4 = tl;
            if (arrayList4.isEmpty()) {
                return;
            }
            HashSet hashSet4 = new HashSet();
            Iterator<int[]> it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                int[] next4 = it4.next();
                if (next4 != null && next4.length == 2) {
                    hashSet4.add(next4[0] + "," + next4[1]);
                }
            }
            xtVar.j("insert_ad_vd_show_time_fs", hashSet4);
        } catch (Exception unused) {
        }
    }

    public void xt(JSONObject jSONObject) {
        try {
            jSONObject.put("carousel_pos", this.f30325v);
            jSONObject.put("insert_ad_control", this.mi);
            jSONObject.put("refresh_ad_control", this.kt);
            jSONObject.put("refresh_ad_imp_max_time", this.f30324f);
            jSONObject.put("force_refresh_ad_control", this.tj);
            jSONObject.put("carousel_tip_content", this.f30326x);
        } catch (JSONException unused) {
        }
    }

    public static int xt(n nVar) {
        la ae2 = ae(nVar);
        if (ae2 == null) {
            return 0;
        }
        return ae2.kt;
    }

    public static boolean xt(n nVar, boolean z5) {
        return (!z5 || av == 1) && cw(nVar) == 1 && r(nVar) > 0;
    }

    public static boolean xt(boolean z5, n nVar, boolean z6) {
        return j(z5, nVar, z6) || j(nVar, z6) || xt(nVar, z6);
    }

    public static boolean j() {
        return f30320j == 1;
    }

    public static int j(boolean z5) {
        if (z5) {
            return oq;
        }
        return qv;
    }

    public static boolean j(boolean z5, boolean z6, int i6) {
        return z5 ? j(z6, i6) : xt(z6, i6);
    }

    private static boolean j(boolean z5, int i6) {
        if (z5) {
            Iterator<int[]> it = f30321m.iterator();
            while (it.hasNext()) {
                int[] next = it.next();
                if (i6 >= next[0] && i6 <= next[1]) {
                    return true;
                }
            }
        } else {
            Iterator<int[]> it2 = up.iterator();
            while (it2.hasNext()) {
                int[] next2 = it2.next();
                if (i6 >= next2[0] && i6 <= next2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean j(int i6, n nVar, boolean z5) {
        return up(nVar) > 0 && i6 * 1000 >= up(nVar) - (xt(z5) * 1000);
    }

    public static boolean j(int i6, n nVar) {
        return up(nVar) > 0 && i6 * 1000 >= up(nVar);
    }

    public static void j(com.bytedance.sdk.component.r.j.xt xtVar) {
        try {
            f30320j = xtVar.getInt("insert_ad_control", 1);
            xt = xtVar.getInt("insert_ad_control_fs", 1);
            cw = xtVar.getInt("insert_ad_req_num", 3);
            f30322r = xtVar.getInt("insert_ad_req_num_fs", 2);
            f30318g = xtVar.getInt("insert_ad_toast_max_time", 5);
            oq = xtVar.getInt("insert_ad_tip_max_time", 0);
            qv = xtVar.getInt("insert_ad_tip_max_time_fs", 3);
            vl = xtVar.getInt("refresh_ad_tip_max_time", 3);
            jy = xtVar.getInt("refresh_ad_tip_max_time_fs", 3);
            ws = xtVar.getInt("refresh_ad_control", 1);
            az = xtVar.getInt("refresh_ad_req_num", 3);
            av = xtVar.getInt("force_refresh_ad_control", 1);
            f30319i = xtVar.getInt("force_refresh_ad_pause_over_time", 5000);
            f30323w = xtVar.getInt("refresh_ad_reduce_time", 0);
            Set<String> stringSet = xtVar.getStringSet("insert_ad_pt_show_time", null);
            if (stringSet != null && !stringSet.isEmpty()) {
                up.clear();
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    String[] split = it.next().split(",");
                    if (split.length == 2) {
                        up.add(new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])});
                    }
                }
            }
            Set<String> stringSet2 = xtVar.getStringSet("insert_ad_vd_show_time", null);
            if (stringSet2 != null && !stringSet2.isEmpty()) {
                f30321m.clear();
                Iterator<String> it2 = stringSet2.iterator();
                while (it2.hasNext()) {
                    String[] split2 = it2.next().split(",");
                    if (split2.length == 2) {
                        f30321m.add(new int[]{Integer.parseInt(split2[0]), Integer.parseInt(split2[1])});
                    }
                }
            }
            Set<String> stringSet3 = xtVar.getStringSet("insert_ad_pt_show_time_fs", null);
            if (stringSet3 != null && !stringSet3.isEmpty()) {
                ae.clear();
                Iterator<String> it3 = stringSet3.iterator();
                while (it3.hasNext()) {
                    String[] split3 = it3.next().split(",");
                    if (split3.length == 2) {
                        ae.add(new int[]{Integer.parseInt(split3[0]), Integer.parseInt(split3[1])});
                    }
                }
            }
            Set<String> stringSet4 = xtVar.getStringSet("insert_ad_vd_show_time_fs", null);
            if (stringSet4 == null || stringSet4.isEmpty()) {
                return;
            }
            tl.clear();
            Iterator<String> it4 = stringSet4.iterator();
            while (it4.hasNext()) {
                String[] split4 = it4.next().split(",");
                if (split4.length == 2) {
                    tl.add(new int[]{Integer.parseInt(split4[0]), Integer.parseInt(split4[1])});
                }
            }
        } catch (Exception unused) {
        }
    }

    public static int j(n nVar) {
        la ae2 = ae(nVar);
        if (ae2 == null) {
            return 0;
        }
        return ae2.mi;
    }

    public static boolean j(boolean z5, n nVar, boolean z6) {
        return z5 ? cw(nVar, z6) : r(nVar, z6);
    }

    public static boolean j(n nVar, boolean z5) {
        return (!z5 || ws == 1) && xt(nVar) == 1 && r(nVar) > 0;
    }
}
