package com.bytedance.pangle.m;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.jy;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {

    interface j {
        boolean j(String str, int i6);
    }

    public static synchronized void xt() {
        synchronized (m.class) {
            try {
                Map<String, ?> all = xt.j(Zeus.getAppApplication()).getAll();
                if (all.size() > 0) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                        if (cw().j(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                            xt.j(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                            ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                            jy.j().cw(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                            ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                        } else {
                            ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static j cw() {
        if (g.g()) {
            return new up();
        }
        if (g.ae()) {
            return new r();
        }
        if (g.cw()) {
            return new cw();
        }
        return new j() { // from class: com.bytedance.pangle.m.m.2
            @Override // com.bytedance.pangle.m.m.j
            public boolean j(String str, int i6) {
                return true;
            }
        };
    }

    public static void j() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "start");
        if (!GlobalParam.getInstance().isCloseBgDex2oat()) {
            if ((g.ae() || g.g() || g.cw()) && com.bytedance.pangle.up.r.xt(Zeus.getAppApplication())) {
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "post");
                com.bytedance.pangle.up.up.xt(new Runnable() { // from class: com.bytedance.pangle.m.m.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "exec");
                        SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                        m.xt();
                    }
                });
            }
        }
    }
}
