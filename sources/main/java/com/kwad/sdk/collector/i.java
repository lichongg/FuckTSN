package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i {
    public static void a(Context context, AppStatusRules.Strategy strategy, long j6) {
        if (context == null || strategy == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(b(strategy), j6).apply();
    }

    public static List<AppStatusRules.Strategy> c(@Nullable AppStatusRules appStatusRules) {
        return appStatusRules == null ? new ArrayList() : appStatusRules.obtainNamedStrategyList();
    }

    @NonNull
    public static AppStatusRules.Strategy d(@Nullable AppStatusRules appStatusRules) {
        return appStatusRules == null ? AppStatusRules.Strategy.LOCAL_DEFAULT : appStatusRules.obtainDefaultStrategy();
    }

    private static String b(AppStatusRules.Strategy strategy) {
        String name;
        if (strategy.getName() == null) {
            name = "defaultStrategy";
        } else {
            name = strategy.getName();
        }
        return "appstatus_strategy_pref_" + name;
    }

    public static boolean a(Context context, @NonNull AppStatusRules.Strategy strategy) {
        if (context == null) {
            return false;
        }
        long j6 = context.getSharedPreferences("ksadsdk_pref", 0).getLong(b(strategy), -1L);
        if (j6 < 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long minLaunchIntervalWithMS = strategy.getMinLaunchIntervalWithMS();
        return minLaunchIntervalWithMS <= 0 || j6 + minLaunchIntervalWithMS < currentTimeMillis;
    }
}
