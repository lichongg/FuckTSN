package cn.jiguang.commons.b;

import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kuaishou.weapon.p0.t;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    public static void c(String str) {
        try {
            JCoreManager.onEvent(null, null, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET, null, null, str);
        } catch (Exception unused) {
        }
    }

    public static String convertMapToString(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                return jSONObject.toString();
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static void u(String str) {
        JCoreManager.onEvent(null, null, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, null, null, str);
    }

    public static Object h(String str, String str2, Map<String, String> map, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putString(t.f36152m, str);
        bundle.putString("u", str2);
        bundle.putString("h", map != null ? convertMapToString(map).toString() : null);
        bundle.putByteArray("b", bArr);
        return JCoreManager.onEvent(null, null, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS, null, bundle, new Object[0]);
    }

    public static void r(int i6) {
        try {
            JCoreManager.onEvent(null, null, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, null, null, Integer.valueOf(i6));
        } catch (Exception unused) {
        }
    }
}
