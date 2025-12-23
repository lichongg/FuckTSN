package o2;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static String a(Context context) {
        String b6 = b.b(context, SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        if (!TextUtils.isEmpty(b6)) {
            return b6;
        }
        String a6 = b.a(context, SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        return !TextUtils.isEmpty(a6) ? a6 : Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
    }
}
