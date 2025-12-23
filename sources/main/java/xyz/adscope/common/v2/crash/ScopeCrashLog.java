package xyz.adscope.common.v2.crash;

import android.text.TextUtils;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ScopeCrashLog extends xyz.adscope.common.a {
    private static final String CRASH_AFFILIATE_AMPS = "AdScope-Mediation";
    private static final String CRASH_AFFILIATE_ANSP = "AdScope-Adn";
    private static final String CRASH_AFFILIATE_FOUNDATION = "AdScope-Foundation";

    @JsonParseNode(key = "affiliated")
    private String mAffiliated;

    @JsonParseNode(key = "exception")
    private String mException;
    private final long mTime;

    private String belong(String str) {
        return str.contains("xyz.adscope.common") ? CRASH_AFFILIATE_FOUNDATION : str.contains("xyz.adscope.ad") ? CRASH_AFFILIATE_ANSP : str.contains("xyz.adscope.amps") ? CRASH_AFFILIATE_AMPS : "";
    }

    public ScopeCrashLog(String str, String str2, long j6) {
        this.mException = str2;
        this.mTime = j6 == 0 ? System.currentTimeMillis() : j6;
        if (TextUtils.isEmpty(str)) {
            this.mAffiliated = belong(this.mException);
        } else {
            this.mAffiliated = str;
        }
    }
}
