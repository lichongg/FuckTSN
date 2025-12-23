package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends d {

    /* renamed from: d, reason: collision with root package name */
    private final JSONObject f38461d;

    private static void b(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject2.optString(next);
            if (optString != null) {
                c(jSONObject, next, optString, intent);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.j.k
    public Intent xt() {
        String optString = this.f38461d.optString(com.umeng.ccg.a.f41544t);
        String optString2 = this.f38461d.optString("category");
        int optInt = this.f38461d.optInt("flags", 1342210048);
        String optString3 = this.f38461d.optString("path_extra_key");
        String optString4 = this.f38461d.optString("path_data_key");
        JSONObject optJSONObject = this.f38461d.optJSONObject(JThirdPlatFormInterface.KEY_EXTRA);
        JSONObject optJSONObject2 = this.f38461d.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, this.f38466c)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.f38466c);
        }
        b(intent, optJSONObject, optJSONObject2);
        return intent;
    }

    public b(Context context, com.ss.android.socialbase.downloader.jy.j jVar, String str, JSONObject jSONObject) {
        super(context, jVar, str);
        this.f38461d = jSONObject;
    }

    private static void c(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.getClass();
        switch (str2) {
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
        }
    }
}
