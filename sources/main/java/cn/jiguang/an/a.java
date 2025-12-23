package cn.jiguang.an;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bz.d;
import cn.jiguang.bz.j;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static JSONArray a(Context context) {
        JSONObject a6;
        if (cn.jiguang.g.a.a().g(2600)) {
            return new JSONArray();
        }
        synchronized ("crs.catch") {
            a6 = j.a("crs.catch");
        }
        if (a6 == null) {
            a6 = new JSONObject();
        }
        JSONArray optJSONArray = a6.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            return a(context, optJSONArray);
        }
        f.c("JDataCollectHelper", "no save data");
        return new JSONArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static JSONArray a(Context context, JSONArray jSONArray) {
        String str;
        Integer num;
        String str2;
        Integer num2;
        String str3;
        Integer num3;
        String str4;
        Integer num4;
        String str5;
        HashMap hashMap;
        int i6;
        Integer num5;
        int i7;
        Integer num6;
        int i8;
        Integer num7;
        int i9;
        Integer num8;
        Integer num9;
        Integer num10;
        int i10;
        HashMap hashMap2;
        Integer num11;
        Integer num12;
        int i11;
        Integer num13;
        int i12;
        Integer num14;
        Integer num15;
        Integer num16;
        Integer num17;
        JSONObject jSONObject;
        String str6;
        String str7;
        int i13;
        Integer num18;
        int i14;
        Integer num19;
        int i15;
        Integer num20;
        int i16;
        int i17;
        Map map;
        Map hashMap3;
        Integer valueOf;
        JSONArray jSONArray2 = jSONArray;
        Integer num21 = 3;
        Integer num22 = -6;
        Integer num23 = -5;
        Integer num24 = -4;
        Integer num25 = -3;
        Integer num26 = -2;
        Integer num27 = -1;
        Integer num28 = 2;
        Integer num29 = 0;
        try {
            if (jSONArray2 != null) {
                try {
                    if (jSONArray2.length() > 0) {
                        f.c("JDataCollectHelper", "transfer report data, mergeData: " + jSONArray2.toString());
                        HashMap hashMap4 = new HashMap();
                        HashMap hashMap5 = new HashMap();
                        String str8 = "JDataCollectHelper";
                        try {
                            HashMap hashMap6 = new HashMap();
                            Integer num30 = 5;
                            Integer num31 = 4;
                            int i18 = 0;
                            while (true) {
                                int length = jSONArray2.length();
                                num = num21;
                                str2 = "result";
                                num2 = num28;
                                str3 = ContainerUtils.FIELD_DELIMITER;
                                num3 = num22;
                                str4 = "s_type";
                                num4 = num23;
                                str5 = "c_type";
                                if (i18 >= length) {
                                    break;
                                }
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i18);
                                String optString = jSONObject2.optString("c_type");
                                String optString2 = jSONObject2.optString("s_type");
                                if (TextUtils.equals(optString, optString2)) {
                                    optString = ContainerUtils.FIELD_DELIMITER + optString;
                                }
                                int optInt = jSONObject2.optInt("result");
                                long optLong = jSONObject2.optLong("c_time");
                                if (hashMap4.containsKey(optString)) {
                                    long longValue = hashMap5.get(optString) == null ? optLong : ((Long) hashMap5.get(optString)).longValue();
                                    long longValue2 = hashMap6.get(optString) == null ? optLong : ((Long) hashMap6.get(optString)).longValue();
                                    if (optLong <= longValue) {
                                        hashMap5.put(optString, Long.valueOf(optLong));
                                    }
                                    if (optLong >= longValue2) {
                                        hashMap6.put(optString, Long.valueOf(optLong));
                                    }
                                    map = (Map) hashMap4.get(optString);
                                    if (map.containsKey(optString2)) {
                                        hashMap3 = (Map) map.get(optString2);
                                        if (hashMap3.containsKey(Integer.valueOf(optInt))) {
                                            hashMap3.put(Integer.valueOf(optInt), Integer.valueOf(((Integer) hashMap3.get(Integer.valueOf(optInt))).intValue() + 1));
                                            map.put(optString2, hashMap3);
                                            i17 = i18;
                                        } else {
                                            valueOf = Integer.valueOf(optInt);
                                        }
                                    } else {
                                        hashMap3 = new HashMap();
                                        valueOf = Integer.valueOf(optInt);
                                    }
                                    hashMap3.put(valueOf, 1);
                                    map.put(optString2, hashMap3);
                                    i17 = i18;
                                } else {
                                    HashMap hashMap7 = new HashMap();
                                    HashMap hashMap8 = new HashMap();
                                    i17 = i18;
                                    hashMap8.put(Integer.valueOf(optInt), 1);
                                    hashMap7.put(optString2, hashMap8);
                                    hashMap5.put(optString, Long.valueOf(optLong));
                                    hashMap6.put(optString, Long.valueOf(optLong));
                                    map = hashMap7;
                                }
                                hashMap4.put(optString, map);
                                i18 = i17 + 1;
                                jSONArray2 = jSONArray;
                                num21 = num;
                                num28 = num2;
                                num22 = num3;
                                num23 = num4;
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            Iterator it = hashMap4.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                JSONObject jSONObject3 = new JSONObject();
                                Iterator it2 = it;
                                String str9 = (String) entry.getKey();
                                long longValue3 = ((Long) hashMap5.get(str9)).longValue();
                                long longValue4 = ((Long) hashMap6.get(str9)).longValue();
                                JSONArray jSONArray4 = new JSONArray();
                                String str10 = str4;
                                String str11 = str5;
                                jSONArray4.put(longValue3 / 1000);
                                jSONArray4.put(longValue4 / 1000);
                                jSONObject3.put("duration", jSONArray4);
                                if (str9.startsWith(str3)) {
                                    str9 = str9.substring(1);
                                }
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it3 = ((Map) entry.getValue()).entrySet().iterator();
                                while (it3.hasNext()) {
                                    Map.Entry entry2 = (Map.Entry) it3.next();
                                    JSONObject jSONObject4 = new JSONObject();
                                    Iterator it4 = it3;
                                    String str12 = (String) entry2.getKey();
                                    String str13 = str3;
                                    Map map2 = (Map) entry2.getValue();
                                    if (map2.containsKey(num29)) {
                                        hashMap = hashMap5;
                                        i6 = ((Integer) map2.get(num29)).intValue();
                                    } else {
                                        hashMap = hashMap5;
                                        i6 = 0;
                                    }
                                    if (map2.containsKey(num27)) {
                                        num5 = num27;
                                        i7 = ((Integer) map2.get(num27)).intValue();
                                    } else {
                                        num5 = num27;
                                        i7 = 0;
                                    }
                                    if (map2.containsKey(num26)) {
                                        num6 = num26;
                                        i8 = ((Integer) map2.get(num26)).intValue();
                                    } else {
                                        num6 = num26;
                                        i8 = 0;
                                    }
                                    if (map2.containsKey(num25)) {
                                        num7 = num25;
                                        i9 = ((Integer) map2.get(num25)).intValue();
                                    } else {
                                        num7 = num25;
                                        i9 = 0;
                                    }
                                    if (map2.containsKey(num24)) {
                                        num10 = num24;
                                        i10 = ((Integer) map2.get(num24)).intValue();
                                        Integer num32 = num4;
                                        num8 = num29;
                                        num9 = num32;
                                    } else {
                                        Integer num33 = num4;
                                        num8 = num29;
                                        num9 = num33;
                                        num10 = num24;
                                        i10 = 0;
                                    }
                                    if (map2.containsKey(num9)) {
                                        num12 = num9;
                                        i11 = ((Integer) map2.get(num9)).intValue();
                                        Integer num34 = num3;
                                        hashMap2 = hashMap6;
                                        num11 = num34;
                                    } else {
                                        Integer num35 = num3;
                                        hashMap2 = hashMap6;
                                        num11 = num35;
                                        num12 = num9;
                                        i11 = 0;
                                    }
                                    if (map2.containsKey(num11)) {
                                        num13 = num11;
                                        i12 = ((Integer) map2.get(num11)).intValue();
                                    } else {
                                        num13 = num11;
                                        i12 = 0;
                                    }
                                    int i19 = i6 + i7 + i8 + i9 + i10 + i11 + i12;
                                    String str14 = "";
                                    JSONArray jSONArray6 = jSONArray3;
                                    int hashCode = str9.hashCode();
                                    JSONObject jSONObject5 = jSONObject3;
                                    JSONArray jSONArray7 = jSONArray5;
                                    if (hashCode == 323924398) {
                                        num14 = num30;
                                        num15 = num31;
                                        num16 = num;
                                        num17 = num2;
                                        jSONObject = jSONObject4;
                                        str6 = str2;
                                        str7 = str12;
                                        i13 = i12;
                                        if (str9.equals("loc_info_v2")) {
                                            int intValue = map2.containsKey(1) ? ((Integer) map2.get(1)).intValue() : 0;
                                            int intValue2 = map2.containsKey(num17) ? ((Integer) map2.get(num17)).intValue() : 0;
                                            i19 += intValue + intValue2;
                                            str14 = "_" + intValue + "_" + intValue2;
                                        }
                                    } else if (hashCode == 753371876 && str9.equals("app_active")) {
                                        int intValue3 = map2.containsKey(1) ? ((Integer) map2.get(1)).intValue() : 0;
                                        num17 = num2;
                                        if (map2.containsKey(num17)) {
                                            Integer num36 = num;
                                            jSONObject = jSONObject4;
                                            num18 = num36;
                                            str7 = str12;
                                            i14 = ((Integer) map2.get(num17)).intValue();
                                        } else {
                                            Integer num37 = num;
                                            jSONObject = jSONObject4;
                                            num18 = num37;
                                            str7 = str12;
                                            i14 = 0;
                                        }
                                        if (map2.containsKey(num18)) {
                                            Integer num38 = num31;
                                            str6 = str2;
                                            num19 = num38;
                                            num16 = num18;
                                            i15 = ((Integer) map2.get(num18)).intValue();
                                        } else {
                                            Integer num39 = num31;
                                            str6 = str2;
                                            num19 = num39;
                                            num16 = num18;
                                            i15 = 0;
                                        }
                                        if (map2.containsKey(num19)) {
                                            Integer num40 = num30;
                                            i13 = i12;
                                            num20 = num40;
                                            num15 = num19;
                                            i16 = ((Integer) map2.get(num19)).intValue();
                                        } else {
                                            Integer num41 = num30;
                                            i13 = i12;
                                            num20 = num41;
                                            num15 = num19;
                                            i16 = 0;
                                        }
                                        int intValue4 = map2.containsKey(num20) ? ((Integer) map2.get(num20)).intValue() : 0;
                                        i19 += intValue3 + i14 + i15 + i16 + intValue4;
                                        num14 = num20;
                                        str14 = "_" + intValue3 + "_" + i14 + "_" + i15 + "_" + i16 + "_" + intValue4;
                                    } else {
                                        num14 = num30;
                                        num15 = num31;
                                        num16 = num;
                                        num17 = num2;
                                        jSONObject = jSONObject4;
                                        str6 = str2;
                                        str7 = str12;
                                        i13 = i12;
                                    }
                                    String str15 = i19 + "_" + i6 + "_" + i7 + "_" + i8 + "_" + i9 + "_" + i10 + "_" + i11 + "_" + i13 + str14;
                                    str2 = str6;
                                    JSONObject jSONObject6 = jSONObject;
                                    jSONObject6.put(str2, str15);
                                    String str16 = str10;
                                    jSONObject6.put(str16, str7);
                                    jSONArray7.put(jSONObject6);
                                    str10 = str16;
                                    num2 = num17;
                                    hashMap5 = hashMap;
                                    hashMap6 = hashMap2;
                                    num29 = num8;
                                    str3 = str13;
                                    it3 = it4;
                                    num27 = num5;
                                    num26 = num6;
                                    num25 = num7;
                                    num24 = num10;
                                    num4 = num12;
                                    num3 = num13;
                                    jSONObject3 = jSONObject5;
                                    num = num16;
                                    num31 = num15;
                                    num30 = num14;
                                    jSONArray5 = jSONArray7;
                                    jSONArray3 = jSONArray6;
                                }
                                JSONArray jSONArray8 = jSONArray3;
                                JSONArray jSONArray9 = jSONArray5;
                                Integer num42 = num24;
                                Integer num43 = num25;
                                Integer num44 = num26;
                                Integer num45 = num27;
                                String str17 = str3;
                                JSONObject jSONObject7 = jSONObject3;
                                HashMap hashMap9 = hashMap5;
                                Integer num46 = num30;
                                Integer num47 = num31;
                                Integer num48 = num;
                                Integer num49 = num2;
                                Integer num50 = num3;
                                Integer num51 = num4;
                                str5 = str11;
                                str4 = str10;
                                Integer num52 = num29;
                                HashMap hashMap10 = hashMap6;
                                jSONObject7.put(str5, str9);
                                jSONObject7.put("statistics", jSONArray9);
                                String str18 = str8;
                                f.f(str18, "merge report statistic data: " + jSONObject7.toString());
                                jSONArray3 = jSONArray8;
                                jSONArray3.put(jSONObject7);
                                str8 = str18;
                                num2 = num49;
                                hashMap5 = hashMap9;
                                hashMap6 = hashMap10;
                                num29 = num52;
                                str3 = str17;
                                num27 = num45;
                                num26 = num44;
                                num25 = num43;
                                num24 = num42;
                                num4 = num51;
                                num3 = num50;
                                num = num48;
                                num31 = num47;
                                num30 = num46;
                                it = it2;
                            }
                            return jSONArray3.length() > 0 ? jSONArray3 : new JSONArray();
                        } catch (Throwable th) {
                            th = th;
                            str = str8;
                            f.j(str, "merge report json failed:" + th.getMessage());
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str = "JDataCollectHelper";
                }
            }
            return new JSONArray();
        } catch (Throwable th3) {
            th = th3;
            str = 5;
        }
    }

    public static void b(Context context) {
        synchronized ("crs.catch") {
            j.d("crs.catch");
        }
    }

    private static JSONObject a(cn.jiguang.ao.a aVar) {
        if (aVar == null) {
            f.c("JDataCollectHelper", "collect is empty, no need cache");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("c_type", aVar.a());
            jSONObject.put("s_type", aVar.b());
            jSONObject.put("result", aVar.c());
            jSONObject.put("c_time", aVar.d());
            return jSONObject;
        } catch (Throwable th) {
            f.l("JDataCollectHelper", "formatReportData:" + th);
            return null;
        }
    }

    private static void a(Context context, cn.jiguang.ao.a aVar) {
        JSONObject a6 = a(aVar);
        f.c("JDataCollectHelper", "collect json:" + a6);
        if (a6 != null) {
            a(context, a6);
        }
    }

    public static void a(Context context, String str, int i6) {
        a(context, str, str, i6);
    }

    public static void a(Context context, String str, String str2, int i6) {
        if (cn.jiguang.g.a.a().f(2600)) {
            if (context == null) {
                context = d.a(context);
            }
            a(context, new cn.jiguang.ao.a().a(str).b(str2).a(i6).a(System.currentTimeMillis()));
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            f.c("JDataCollectHelper", "collect data is null for no data to save");
            return;
        }
        f.c("JDataCollectHelper", "save collect data: " + jSONObject.toString());
        try {
            synchronized ("crs.catch") {
                try {
                    JSONObject a6 = j.a("crs.catch");
                    if (a6 == null) {
                        a6 = new JSONObject();
                    }
                    JSONArray optJSONArray = a6.optJSONArray("data");
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    optJSONArray.put(jSONObject);
                    a6.put("data", optJSONArray);
                    j.a("crs.catch", a6);
                } finally {
                }
            }
        } catch (Throwable th) {
            f.i("JDataCollectHelper", "saveData failed: " + th.getMessage());
        }
    }
}
