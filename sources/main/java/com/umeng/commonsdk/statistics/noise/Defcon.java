package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import androidx.work.PeriodicWorkRequest;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Defcon implements d {
    private static final int LEVEL_0 = 0;
    private static final int LEVEL_1 = 1;
    private static final int LEVEL_2 = 2;
    private static final int LEVEL_3 = 3;
    private static final long MILLIS_24_HOURS = 86400000;
    private static final long MILLIS_4_HOURS = 14400000;
    private static final long MILLIS_8_HOURS = 28800000;
    private static Defcon instanse;
    private int mLevel = 0;

    @Override // com.umeng.commonsdk.statistics.internal.d
    public void onImprintChanged(ImprintHandler.a aVar) {
        setLevel(Integer.valueOf(aVar.a("defcon", String.valueOf(0))).intValue());
    }

    public static synchronized Defcon getService(Context context) {
        Defcon defcon;
        synchronized (Defcon.class) {
            try {
                if (instanse == null) {
                    instanse = new Defcon();
                    instanse.setLevel(Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", "0")).intValue());
                }
                defcon = instanse;
            } catch (Throwable th) {
                throw th;
            }
        }
        return defcon;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public long getReqInterval() {
        int i6 = this.mLevel;
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? 0L : 86400000L : MILLIS_8_HOURS : MILLIS_4_HOURS;
    }

    public long getRetryInterval() {
        if (this.mLevel == 0) {
            return 0L;
        }
        return PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    public boolean isOpen() {
        return this.mLevel != 0;
    }

    public void setLevel(int i6) {
        if (i6 < 0 || i6 > 3) {
            return;
        }
        this.mLevel = i6;
    }

    private Defcon() {
    }
}
