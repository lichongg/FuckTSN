package cn.jiguang.au;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bz.j;
import cn.jiguang.bz.y;
import cn.jpush.android.api.JPushInterface;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1752a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, cn.jiguang.as.c> f1753b;

    public static Bundle a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putString(str, hashMap.get(str));
        }
        return bundle;
    }

    public static String b(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        for (String str : hashMap.keySet()) {
            builder.appendQueryParameter(str, hashMap.get(str));
        }
        return builder.toString();
    }

    private static List<String> c(cn.jiguang.as.a aVar, List<String> list) {
        return a(aVar.f1705p, list);
    }

    public static cn.jiguang.as.c a(Context context, String str) {
        try {
            return new cn.jiguang.as.c(str, "", context.getPackageManager().getApplicationInfo(str, 0).targetSdkVersion);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JWakeHelper", "getWakeTarget throwable:" + th.getMessage());
            return null;
        }
    }

    private static List<String> b(cn.jiguang.as.a aVar, List<String> list) {
        if (!TextUtils.isEmpty(aVar.f1703n) && !aVar.f1703n.equals("disable")) {
            List<String> list2 = aVar.f1704o;
            String str = aVar.f1703n;
            str.getClass();
            if (str.equals(SocialConstants.PARAM_EXCLUDE)) {
                return a(list2, list);
            }
            if (str.equals("include")) {
                return b(list2, list);
            }
        }
        return list;
    }

    public static void c(Context context) {
        j.d("wake_cache_v2.json");
    }

    public static String a(List<cn.jiguang.as.c> list) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str = list.get(i6).f1718a;
            String str2 = list.get(i6).f1719b;
            sb.append(str);
            sb.append(Logger.f33116c);
            sb.append(str2);
            sb.append("$");
        }
        return sb.toString();
    }

    private static List<String> b(List<String> list, List<String> list2) {
        return a(list, list2, true);
    }

    public static HashMap<String, cn.jiguang.as.c> a(Context context) {
        cn.jiguang.as.c a6;
        try {
            HashMap<String, cn.jiguang.as.c> hashMap = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DaemonService");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                for (int i6 = 0; i6 < queryIntentServices.size(); i6++) {
                    ServiceInfo serviceInfo = queryIntentServices.get(i6).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && serviceInfo.exported && serviceInfo.enabled && !context.getPackageName().equals(str2) && (a6 = a.a(context, packageManager, str2, str)) != null) {
                        cn.jiguang.bb.f.c("JWakeHelper", "wakeTarget:" + a6.toString());
                        hashMap.put(a6.f1718a, a6);
                    }
                }
                return hashMap;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JWakeHelper", "getWakeTargetMap throwable:" + th.getMessage());
            return null;
        }
    }

    public static JSONArray b(Context context) {
        JSONObject a6;
        synchronized (f1752a) {
            a6 = j.a("wake_cache_v2.json");
        }
        if (a6 == null) {
            a6 = new JSONObject();
        }
        JSONArray optJSONArray = a6.optJSONArray("content");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            return a(context, optJSONArray);
        }
        cn.jiguang.bb.f.c("JWakeHelper", "no save data");
        return null;
    }

    public static HashMap<String, cn.jiguang.as.c> a(Context context, HashMap<String, cn.jiguang.as.c> hashMap) {
        try {
            HashMap<String, cn.jiguang.as.c> hashMap2 = f1753b;
            if (hashMap2 != null && !hashMap2.isEmpty()) {
                return f1753b;
            }
            HashMap<String, cn.jiguang.as.c> hashMap3 = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.PushService");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                for (int i6 = 0; i6 < queryIntentServices.size(); i6++) {
                    ServiceInfo serviceInfo = queryIntentServices.get(i6).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && ((hashMap == null || !hashMap.containsKey(str2)) && !context.getPackageName().equals(str2))) {
                        int checkPermission = packageManager.checkPermission(str2 + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, str2);
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, 128);
                        if (applicationInfo != null && applicationInfo.metaData != null) {
                            String a6 = cn.jiguang.ba.a.a(context);
                            if (checkPermission == 0 && !TextUtils.isEmpty(a6) && a6.length() == 24 && !context.getPackageName().equals(applicationInfo.packageName)) {
                                cn.jiguang.as.c cVar = new cn.jiguang.as.c(str2, "", applicationInfo.targetSdkVersion);
                                cVar.f1721d = str2 + ".DownloadProvider";
                                hashMap3.put(cVar.f1718a, cVar);
                            }
                        }
                    }
                }
                f1753b = hashMap3;
                cn.jiguang.bb.f.c("JWakeHelper", "getWakeAppListWithoutDService:" + hashMap3.toString());
                return hashMap3;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JWakeHelper", "getWakeAppListWithoutDService throwable:" + th.getMessage());
            return null;
        }
    }

    private static JSONObject b(List<cn.jiguang.as.b> list) {
        if (list == null || list.size() == 0) {
            cn.jiguang.bb.f.c("JWakeHelper", "wakeUpResult is empty, no need report");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.as.b bVar : list) {
            try {
                HashMap<Integer, Integer> hashMap = bVar.f1717b;
                if (hashMap != null && !hashMap.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, bVar.f1716a);
                    JSONArray jSONArray2 = new JSONArray();
                    HashMap<Integer, Integer> hashMap2 = bVar.f1717b;
                    for (Integer num : hashMap2.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("wake_type", num);
                        jSONObject2.put("wake_status", hashMap2.get(num));
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("data", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.l("JWakeHelper", "formatReportData:" + th);
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("target", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject3;
    }

    public static List<cn.jiguang.as.c> a(Context context, List<cn.jiguang.as.c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(list.get(i6).f1718a, 128);
                list.get(i6).f1720c = applicationInfo.targetSdkVersion;
            } catch (Throwable unused) {
            }
        }
        return list;
    }

    public static List<String> a(cn.jiguang.as.a aVar, List<String> list) {
        return aVar == null ? list : c(aVar, b(aVar, list));
    }

    public static List<cn.jiguang.as.c> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\$");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            String[] split2 = str2.split("\\|");
            if (split2.length < 2) {
                cn.jiguang.bb.f.c("JWakeHelper", "split.length < 2, data:" + str2);
            } else {
                String str3 = split2[0];
                String str4 = split2[1];
                cn.jiguang.as.c cVar = new cn.jiguang.as.c();
                cVar.f1718a = str3;
                cVar.f1719b = str4;
                cVar.f1727j = 1;
                cVar.f1724g = 4;
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private static List<String> a(List<String> list, List<String> list2) {
        return a(list, list2, false);
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private static java.util.List<java.lang.String> a(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:402)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:390)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:340)
        */

    private static JSONArray a(Context context, JSONArray jSONArray) {
        JSONArray jSONArray2;
        Integer num;
        int i6;
        Integer num2;
        int i7;
        Integer num3;
        int i8;
        HashMap hashMap;
        int i9;
        Map map;
        HashMap hashMap2;
        JSONArray jSONArray3;
        int i10;
        Map hashMap3;
        JSONArray jSONArray4 = jSONArray;
        Integer num4 = 103;
        Integer num5 = 102;
        Integer num6 = 101;
        Integer num7 = 1;
        if (jSONArray4 != null) {
            try {
                if (jSONArray4.length() > 0) {
                    HashMap hashMap4 = new HashMap();
                    int i11 = 0;
                    while (i11 < jSONArray4.length()) {
                        JSONObject jSONObject = jSONArray4.getJSONObject(i11);
                        String optString = jSONObject.optString("type");
                        if ("aa3".equals(optString)) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("target");
                            if (optJSONArray == null || optJSONArray.length() <= 0) {
                                break;
                            }
                            long optLong = jSONObject.optLong("itime");
                            Iterator it = hashMap4.entrySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    hashMap = hashMap4;
                                    i9 = i11;
                                    map = null;
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                long longValue = ((Long) entry.getKey()).longValue();
                                i9 = i11;
                                hashMap = hashMap4;
                                jSONArray2 = null;
                                try {
                                    if (y.a(optLong * 1000, longValue * 1000)) {
                                        map = (Map) entry.getValue();
                                        optLong = longValue;
                                        break;
                                    }
                                    i11 = i9;
                                    hashMap4 = hashMap;
                                } catch (Throwable th) {
                                    th = th;
                                    cn.jiguang.bb.f.j("JWakeHelper", "merge wake json failed:" + th.getMessage());
                                    return jSONArray2;
                                }
                            }
                            if (map == null) {
                                map = new HashMap();
                            }
                            int i12 = 0;
                            while (i12 < optJSONArray.length()) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i12);
                                JSONArray jSONArray5 = optJSONObject.getJSONArray("data");
                                if (jSONArray5 != null && jSONArray5.length() > 0) {
                                    String optString2 = optJSONObject.optString(WiseOpenHianalyticsData.UNION_PACKAGE);
                                    int i13 = 0;
                                    while (i13 < jSONArray5.length()) {
                                        JSONObject jSONObject2 = jSONArray5.getJSONObject(i13);
                                        if (jSONObject2 != null) {
                                            int i14 = jSONObject2.getInt("wake_type");
                                            int i15 = jSONObject2.getInt("wake_status");
                                            if (map.containsKey(optString2)) {
                                                Map map2 = (Map) map.get(optString2);
                                                if (map2.containsKey(Integer.valueOf(i14))) {
                                                    hashMap3 = (Map) map2.get(Integer.valueOf(i14));
                                                    jSONArray3 = optJSONArray;
                                                    if (hashMap3.containsKey(Integer.valueOf(i15))) {
                                                        i10 = i12;
                                                        hashMap3.put(Integer.valueOf(i15), Integer.valueOf(((Integer) hashMap3.get(Integer.valueOf(i15))).intValue() + 1));
                                                    } else {
                                                        i10 = i12;
                                                        hashMap3.put(Integer.valueOf(i15), num7);
                                                    }
                                                } else {
                                                    jSONArray3 = optJSONArray;
                                                    i10 = i12;
                                                    hashMap3 = new HashMap();
                                                    hashMap3.put(Integer.valueOf(i15), num7);
                                                }
                                                map2.put(Integer.valueOf(i14), hashMap3);
                                                map.put(optString2, map2);
                                            } else {
                                                jSONArray3 = optJSONArray;
                                                i10 = i12;
                                                HashMap hashMap5 = new HashMap();
                                                hashMap5.put(Integer.valueOf(i15), num7);
                                                HashMap hashMap6 = new HashMap();
                                                hashMap6.put(Integer.valueOf(i14), hashMap5);
                                                map.put(optString2, hashMap6);
                                            }
                                        } else {
                                            jSONArray3 = optJSONArray;
                                            i10 = i12;
                                        }
                                        i13++;
                                        optJSONArray = jSONArray3;
                                        i12 = i10;
                                    }
                                }
                                i12++;
                                optJSONArray = optJSONArray;
                            }
                            hashMap2 = hashMap;
                            hashMap2.put(Long.valueOf(optLong), map);
                        } else {
                            cn.jiguang.bb.f.i("JWakeHelper", "unkown type :" + optString);
                            hashMap2 = hashMap4;
                            i9 = i11;
                        }
                        i11 = i9 + 1;
                        jSONArray4 = jSONArray;
                        hashMap4 = hashMap2;
                    }
                    HashMap hashMap7 = hashMap4;
                    jSONArray2 = null;
                    JSONArray jSONArray6 = new JSONArray();
                    Iterator it2 = hashMap7.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it2.next();
                        JSONArray jSONArray7 = new JSONArray();
                        Iterator it3 = ((Map) entry2.getValue()).entrySet().iterator();
                        while (it3.hasNext()) {
                            Map.Entry entry3 = (Map.Entry) it3.next();
                            JSONObject jSONObject3 = new JSONObject();
                            Iterator it4 = it2;
                            Map.Entry entry4 = entry2;
                            jSONObject3.put("p", entry3.getKey());
                            JSONArray jSONArray8 = new JSONArray();
                            Iterator it5 = ((Map) entry3.getValue()).entrySet().iterator();
                            while (it5.hasNext()) {
                                Map.Entry entry5 = (Map.Entry) it5.next();
                                Iterator it6 = it5;
                                Integer num8 = (Integer) entry5.getKey();
                                Map map3 = (Map) entry5.getValue();
                                if (map3.containsKey(num7)) {
                                    num = num7;
                                    i6 = ((Integer) map3.get(num7)).intValue();
                                } else {
                                    num = num7;
                                    i6 = 0;
                                }
                                if (map3.containsKey(num6)) {
                                    num2 = num6;
                                    i7 = ((Integer) map3.get(num6)).intValue();
                                } else {
                                    num2 = num6;
                                    i7 = 0;
                                }
                                if (map3.containsKey(num5)) {
                                    num3 = num5;
                                    i8 = ((Integer) map3.get(num5)).intValue();
                                } else {
                                    num3 = num5;
                                    i8 = 0;
                                }
                                int intValue = map3.containsKey(num4) ? ((Integer) map3.get(num4)).intValue() : 0;
                                jSONArray8.put(num8 + "_" + (i6 + i7 + i8 + intValue) + "_" + i6 + "_" + i7 + "_" + i8 + "_" + intValue);
                                num7 = num;
                                it5 = it6;
                                num6 = num2;
                                num5 = num3;
                                it3 = it3;
                                num4 = num4;
                            }
                            jSONObject3.put("d", jSONArray8);
                            jSONArray7.put(jSONObject3);
                            it2 = it4;
                            entry2 = entry4;
                            num7 = num7;
                            num6 = num6;
                            num5 = num5;
                            it3 = it3;
                            num4 = num4;
                        }
                        Integer num9 = num4;
                        Integer num10 = num5;
                        Integer num11 = num6;
                        Iterator it7 = it2;
                        Integer num12 = num7;
                        Map.Entry entry6 = entry2;
                        if (jSONArray7.length() > 0) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(bi.aL, jSONArray7);
                            jSONObject4.put("itime", ((Long) entry6.getKey()).longValue());
                            jSONObject4.put("type", "aa3");
                            jSONArray6.put(jSONObject4);
                        }
                        it2 = it7;
                        num7 = num12;
                        num6 = num11;
                        num5 = num10;
                        num4 = num9;
                    }
                    return jSONArray6.length() > 0 ? jSONArray6 : jSONArray;
                }
            } catch (Throwable th2) {
                th = th2;
                jSONArray2 = null;
            }
        }
        return jSONArray;
    }

    public static void a(Context context, cn.jiguang.as.a aVar, List<cn.jiguang.as.b> list) {
        if (!aVar.f1712w) {
            cn.jiguang.bb.f.i("JWakeHelper", "server set do not report wake data,give up save");
            return;
        }
        JSONObject b6 = b(list);
        cn.jiguang.bb.f.c("JWakeHelper", "wake json:" + b6);
        a(context, b6);
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("itime", cn.jiguang.d.b.b(context));
            jSONObject.put("type", "aa3");
            synchronized (f1752a) {
                try {
                    JSONObject a6 = j.a("wake_cache_v2.json");
                    if (a6 == null) {
                        a6 = new JSONObject();
                    }
                    JSONArray optJSONArray = a6.optJSONArray("content");
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    optJSONArray.put(jSONObject);
                    a6.put("content", optJSONArray);
                    j.a("wake_cache_v2.json", a6);
                    cn.jiguang.bb.f.c("JWakeHelper", "save wake data : " + a6.toString());
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.bb.f.i("JWakeHelper", "saveWakeData failed:" + th2.getMessage());
        }
    }
}
