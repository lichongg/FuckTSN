package com.bytedance.adsdk.ugeno.up.cw;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.m.g;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends xt implements g.j {
    private Handler jy;
    private int qv;
    private int vl;
    private int ws;

    @Override // com.bytedance.adsdk.ugeno.up.cw.xt
    public boolean j(Object... objArr) {
        Map<String, String> map = this.up;
        if (map != null) {
            int j6 = com.bytedance.adsdk.ugeno.m.cw.j(map.get("loop"), 0);
            this.qv = j6;
            if (j6 <= 0) {
                this.ws = -1;
            } else {
                this.ws = j6;
            }
            this.vl = com.bytedance.adsdk.ugeno.m.cw.j(this.up.get("duration"), 0);
        }
        this.jy.sendEmptyMessageDelayed(1001, this.vl);
        return true;
    }

    public m(Context context) {
        super(context);
        this.vl = 0;
        this.jy = new g(Looper.getMainLooper(), this);
        this.ws = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.m.g.j
    public void j(Message message) {
        int i6;
        int i7;
        if (message.what != 1001) {
            return;
        }
        this.f23743j.j(this.xt, this.f23744m, this.cw.xt());
        int i8 = this.ws - 1;
        this.ws = i8;
        if (i8 < 0 && (i7 = this.vl) != 0) {
            this.jy.sendEmptyMessageDelayed(1001, i7);
        } else if (i8 > 0 && (i6 = this.vl) != 0) {
            this.jy.sendEmptyMessageDelayed(1001, i6);
        } else {
            this.jy.removeMessages(1001);
        }
    }
}
