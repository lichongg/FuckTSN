package com.amap.api.col.p0003l;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class z5 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public static z5 f7799a = new z5();
    }

    private static JSONObject a(Thread thread) {
        if (thread == null || thread.getStackTrace() == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("threadName", thread.getName());
            jSONObject.put("threadGroup", thread.getThreadGroup());
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement);
                stringBuffer.append("<br />");
            }
            jSONObject.put("stacks", stringBuffer.toString());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|1|(17:3|(3:6|(1:108)(2:17|(7:19|(1:21)|22|23|24|(2:26|(1:(3:30|(3:32|(3:35|(1:42)(2:39|40)|33)|44)(1:46)|45)(2:48|47)))(0)|(10:53|(1:55)|56|(4:59|(4:64|65|(4:68|(2:80|81)|77|66)|85)|86|57)|89|90|91|92|93|(1:95)(3:96|97|(2:102|103)(2:100|101)))(1:51)))|4)|112|113|24|(0)(0)|(0)|53|(0)|56|(1:57)|89|90|91|92|93|(0)(0))|114|24|(0)(0)|(0)|53|(0)|56|(1:57)|89|90|91|92|93|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0140 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.util.List<com.amap.api.col.p0003l.p4> r13, boolean r14, com.amap.api.col.p0003l.p4 r15) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.z5.b(android.content.Context, java.lang.String, java.lang.String, java.util.List, boolean, com.amap.api.col.3l.p4):boolean");
    }
}
