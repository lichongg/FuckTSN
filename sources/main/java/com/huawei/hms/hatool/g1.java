package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class g1 {
    protected static p a(String str, String str2, String str3, String str4) {
        p pVar = new p();
        pVar.a(str);
        pVar.b(y0.k());
        pVar.e(str2);
        pVar.c(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        pVar.d(stringBuffer.toString());
        return pVar;
    }

    protected static l0 b(String str, String str2) {
        l0 l0Var = new l0();
        l0Var.a(c0.a().b(str, str2));
        return l0Var;
    }

    protected static o1 c(String str, String str2, String str3) {
        o1 o1Var = new o1();
        o1Var.c(y0.r());
        o1Var.e(y0.t());
        o1Var.a(str3);
        o1Var.b(c0.a().e(str2, str));
        return o1Var;
    }

    protected static x d(String str, String str2) {
        j1.h("hmsSdk", "generate UploadData EventModelHandlerBase");
        n0.f().c(str, str2);
        if (!TextUtils.isEmpty(n0.f().b())) {
            return new x(n0.f().e());
        }
        j1.m("hmsSdk", "event chifer is empty");
        return null;
    }

    protected static Map<String, String> e(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", y0.k());
        hashMap.put("App-Ver", y0.m());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.314");
        hashMap.put("Device-Type", Build.MODEL);
        hashMap.put("servicetag", str);
        j1.c("hmsSdk", "sendData RequestId : %s", str2);
        hashMap.put("Request-Id", str2);
        return hashMap;
    }
}
