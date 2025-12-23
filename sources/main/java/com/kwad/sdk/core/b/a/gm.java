package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.JavaBackTraceElement;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gm implements com.kwad.sdk.core.d<JavaBackTraceElement> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        a2(javaBackTraceElement, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        return b2(javaBackTraceElement, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        javaBackTraceElement.mDeclaringClass = jSONObject.optString("mDeclaringClass");
        if (JSONObject.NULL.toString().equals(javaBackTraceElement.mDeclaringClass)) {
            javaBackTraceElement.mDeclaringClass = "";
        }
        javaBackTraceElement.mIsTitle = jSONObject.optBoolean("mIsTitle");
        javaBackTraceElement.mIsCausedBy = jSONObject.optBoolean("mIsCausedBy");
        javaBackTraceElement.mIsNative = jSONObject.optBoolean("mIsNative");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(JavaBackTraceElement javaBackTraceElement, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = javaBackTraceElement.mDeclaringClass;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDeclaringClass", javaBackTraceElement.mDeclaringClass);
        }
        boolean z5 = javaBackTraceElement.mIsTitle;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsTitle", z5);
        }
        boolean z6 = javaBackTraceElement.mIsCausedBy;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsCausedBy", z6);
        }
        boolean z7 = javaBackTraceElement.mIsNative;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsNative", z7);
        }
        return jSONObject;
    }
}
