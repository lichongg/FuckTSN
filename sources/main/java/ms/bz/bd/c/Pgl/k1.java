package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class k1 {

    static class pgla implements Comparator<Object> {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int abs = Math.abs(((ScanResult) obj).level);
            int abs2 = Math.abs(((ScanResult) obj2).level);
            if (abs > abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }

        pgla() {
        }
    }

    public static String a(Context context) {
        List list;
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            return jSONArray.toString();
        }
        String str = null;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            Method declaredMethod = wifiManager.getClass().getDeclaredMethod(new String(pbla.a("6765745363616e526573756c7473")), null);
            list = declaredMethod != null ? (List) declaredMethod.invoke(wifiManager, null) : null;
        } catch (Throwable unused) {
        }
        if (list == null || list.size() <= 0) {
            return jSONArray.toString();
        }
        Collections.sort(list, new pgla());
        for (int i6 = 0; i6 < list.size() && i6 < 10; i6++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ss", q1.a(((ScanResult) list.get(i6)).SSID));
                jSONObject.put("bs", q1.a(((ScanResult) list.get(i6)).BSSID));
                jSONArray.put(jSONObject);
            } catch (JSONException unused2) {
            }
        }
        str = jSONArray.toString();
        return str == null ? "[]" : str.trim();
    }
}
