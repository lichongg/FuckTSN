package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class wo {

    /* renamed from: j, reason: collision with root package name */
    private static wf<wi> f24094j = new wf<wi>() { // from class: com.bytedance.embedapplog.wo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.wf
        /* renamed from: cw, reason: merged with bridge method [inline-methods] */
        public wi j(Object... objArr) {
            return new wi((Context) objArr[0]);
        }
    };

    @AnyThread
    public static void j(@NonNull Context context) {
        f24094j.xt(context).xt();
    }

    @WorkerThread
    public static String j(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return ik.j(sharedPreferences);
    }

    @Nullable
    @WorkerThread
    public static Map<String, String> j(@NonNull Context context, @NonNull SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        wi xt = f24094j.xt(context);
        return xt.j(xt.j() instanceof qe ? 200 : 100);
    }

    @Nullable
    @AnyThread
    public static String j(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    @AnyThread
    public static void j(@Nullable up upVar) {
        wi.j(upVar);
    }
}
