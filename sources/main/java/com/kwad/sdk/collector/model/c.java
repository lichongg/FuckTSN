package com.kwad.sdk.collector.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static void a(@NonNull AppStatusRules.Strategy strategy, @NonNull List<a> list) {
        ArrayList<d> target = strategy.getTarget();
        if (target == null || target.size() == 0) {
            return;
        }
        for (d dVar : target) {
            if (b(dVar) != null && b(dVar).size() != 0) {
                String a6 = a(dVar);
                HashSet hashSet = new HashSet(b(dVar));
                long startTimeWithMS = strategy.getStartTimeWithMS();
                AppRunningInfoNative a7 = a(a6, strategy);
                if (a7 != null) {
                    list.add(new AnalyseTaskNative(a7, hashSet, startTimeWithMS));
                }
            }
        }
    }

    private static List<String> b(d dVar) {
        if (dVar instanceof RulesTargetNative) {
            return Arrays.asList(AppStatusNative.rulesTargetGetPaths((RulesTargetNative) dVar));
        }
        return null;
    }

    public static long c(b bVar) {
        if (bVar instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetLastRunningTime((AppRunningInfoNative) bVar);
        }
        return 0L;
    }

    public static ArrayList<d> d(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return e(jSONArray);
    }

    private static ArrayList<d> e(@NonNull JSONArray jSONArray) {
        JSONObject jSONObject;
        ArrayList<d> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i6 = 0; i6 < length; i6++) {
            try {
                jSONObject = jSONArray.getJSONObject(i6);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                RulesTargetNative rulesTargetNative = new RulesTargetNative();
                rulesTargetNative.parseJson(jSONObject);
                arrayList.add(rulesTargetNative);
            }
        }
        return arrayList;
    }

    public static String b(b bVar) {
        if (bVar instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetPackageName((AppRunningInfoNative) bVar);
        }
        return null;
    }

    private static AppRunningInfoNative a(String str, @Nullable AppStatusRules.Strategy strategy) {
        try {
            return new AppRunningInfoNative(strategy == null ? -1L : strategy.getHistoryGranularity(), "", str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static String a(d dVar) {
        if (dVar instanceof RulesTargetNative) {
            return AppStatusNative.rulesTargetGetPackageName((RulesTargetNative) dVar);
        }
        return null;
    }

    public static String a(b bVar) {
        if (bVar instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetName((AppRunningInfoNative) bVar);
        }
        return null;
    }

    public static void a(b bVar, long j6) {
        AppStatusNative.appRunningInfoSetLastRunningTime((AppRunningInfoNative) bVar, j6);
    }
}
