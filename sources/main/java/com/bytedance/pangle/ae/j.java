package com.bytedance.pangle.ae;

import android.os.RemoteException;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.cw;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.oq;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.r;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends cw.j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f25376j;

    public static j xt() {
        if (f25376j == null) {
            synchronized (j.class) {
                try {
                    if (f25376j == null) {
                        f25376j = new j();
                    }
                } finally {
                }
            }
        }
        return f25376j;
    }

    @Override // com.bytedance.pangle.cw
    public boolean j(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.cw
    public boolean j(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start install pkg:" + str + ", path:" + str2);
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.cw
    public void j(int i6, r rVar) throws RemoteException {
        Zeus.registerPluginStateListener(new cw(rVar, i6));
    }

    @Override // com.bytedance.pangle.cw
    public void j(int i6) throws RemoteException {
        ZeusPluginStateListener zeusPluginStateListener;
        List<ZeusPluginStateListener> cw = oq.j().cw();
        Iterator<ZeusPluginStateListener> it = cw.iterator();
        while (true) {
            if (!it.hasNext()) {
                zeusPluginStateListener = null;
                break;
            }
            zeusPluginStateListener = it.next();
            if ((zeusPluginStateListener instanceof cw) && ((cw) zeusPluginStateListener).j() == i6) {
                break;
            }
        }
        if (zeusPluginStateListener != null) {
            cw.remove(zeusPluginStateListener);
        }
    }

    @Override // com.bytedance.pangle.cw
    public int xt(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
