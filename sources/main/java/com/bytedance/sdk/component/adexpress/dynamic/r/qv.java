package com.bytedance.sdk.component.adexpress.dynamic.r;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.r.xt;
import com.bytedance.sdk.component.utils.vl;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv {

    /* renamed from: j, reason: collision with root package name */
    private static final Set<String> f25794j = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", "close", "close-fill", "webview-close")));
    private static String xt;

    /* JADX WARN: Can't wrap try/catch for region: R(9:(3:181|(1:184)|185)(2:209|(1:211)(4:212|187|(5:196|197|198|(3:200|(1:206)(1:203)|204)|207)|195))|186|187|(3:189|191|193)|196|197|198|(0)|207) */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0488 A[Catch: Exception -> 0x049a, TryCatch #1 {Exception -> 0x049a, blocks: (B:198:0x047d, B:200:0x0488, B:204:0x0492), top: B:197:0x047d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.adexpress.dynamic.r.xt.cw j(java.lang.String r25, java.lang.String r26, java.lang.String r27, boolean r28, boolean r29, int r30, com.bytedance.sdk.component.adexpress.dynamic.cw.tl r31, double r32, int r34, double r35, java.lang.String r37, com.bytedance.sdk.component.adexpress.xt.jy r38) {
        /*
            Method dump skipped, instructions count: 1355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.r.qv.j(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.cw.tl, double, int, double, java.lang.String, com.bytedance.sdk.component.adexpress.xt.jy):com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw");
    }

    public static double xt(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] xt(String str, float f6, boolean z5) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.r.getContext());
            textView.setTextSize(f6);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z5) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static boolean xt() {
        return !TextUtils.isEmpty(xt);
    }

    public static String j(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split("adx:")) == null || split.length < 2) ? "" : split[1];
    }

    private static xt.cw j(xt.cw cwVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            cwVar.f25802j = 0.0f;
            cwVar.xt = 0.0f;
            return cwVar;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = j(str);
        }
        if (TextUtils.isEmpty(str3)) {
            cwVar.f25802j = 0.0f;
            cwVar.xt = 0.0f;
            return cwVar;
        }
        return j(str3, str2);
    }

    public static xt.cw j(String str, String str2) {
        return j(str, str2, false);
    }

    public static xt.cw j(String str, String str2, boolean z5) {
        xt.cw cwVar = new xt.cw();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] j6 = j(str, (float) xt(str2), z5);
            cwVar.f25802j = j6[0];
            cwVar.xt = j6[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) != 0.0d) {
                return cwVar;
            }
            cwVar.xt = 0.0f;
            return cwVar;
        } catch (Exception e6) {
            vl.j(e6);
            return cwVar;
        }
    }

    public static int[] j(String str, float f6, boolean z5) {
        int[] xt2 = xt(str, f6, z5);
        return new int[]{com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), xt2[0]), com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), xt2[1])};
    }

    public static String j() {
        return xt;
    }
}
