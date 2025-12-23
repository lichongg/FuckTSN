package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s3 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    private Context f7215b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f7216c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f7217d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f7218e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f7219f;

    /* renamed from: g, reason: collision with root package name */
    private OfflineMapManager f7220g;

    /* renamed from: h, reason: collision with root package name */
    private OfflineMapCity f7221h;

    /* renamed from: k, reason: collision with root package name */
    private View f7224k;

    /* renamed from: l, reason: collision with root package name */
    private DownloadProgressView f7225l;

    /* renamed from: a, reason: collision with root package name */
    private int f7214a = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f7222i = false;

    /* renamed from: j, reason: collision with root package name */
    private Handler f7223j = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                s3.this.c(message.arg1, message.arg2);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    private synchronized void p() {
        this.f7220g.pause();
        this.f7220g.restart();
    }

    private synchronized boolean q() {
        try {
            this.f7220g.downloadByCityName(this.f7221h.getCity());
        } catch (AMapException e6) {
            e6.printStackTrace();
            Toast.makeText(this.f7215b, e6.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i6, int i7) throws Exception {
        if (this.f7214a != 2 || i7 <= 3 || i7 >= 100) {
            this.f7225l.setVisibility(8);
        } else {
            this.f7225l.setVisibility(0);
            this.f7225l.setProgress(i7);
        }
        if (i6 == -1) {
            k();
            return;
        }
        if (i6 == 0) {
            if (this.f7214a != 1) {
                o();
                return;
            }
            this.f7218e.setVisibility(8);
            this.f7219f.setText("下载中");
            this.f7219f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        if (i6 == 1) {
            n();
            return;
        }
        if (i6 == 2) {
            j();
            return;
        }
        if (i6 == 3) {
            l();
            return;
        }
        if (i6 == 4) {
            m();
            return;
        }
        if (i6 == 6) {
            h();
        } else {
            if (i6 == 7) {
                i();
                return;
            }
            switch (i6) {
                case 101:
                case 102:
                case 103:
                    k();
                    break;
            }
        }
    }

    private void f() {
        View d6 = x3.d(this.f7215b, 2130903042);
        this.f7224k = d6;
        this.f7225l = (DownloadProgressView) d6.findViewById(2131165200);
        this.f7216c = (TextView) this.f7224k.findViewById(2131165195);
        this.f7217d = (TextView) this.f7224k.findViewById(2131165199);
        this.f7218e = (ImageView) this.f7224k.findViewById(2131165198);
        this.f7219f = (TextView) this.f7224k.findViewById(2131165197);
        this.f7218e.setOnClickListener(this);
    }

    private void g(int i6, int i7) {
        OfflineMapCity offlineMapCity = this.f7221h;
        if (offlineMapCity != null) {
            offlineMapCity.setState(i6);
            this.f7221h.setCompleteCode(i7);
        }
        Message message = new Message();
        message.arg1 = i6;
        message.arg2 = i7;
        this.f7223j.sendMessage(message);
    }

    private void h() {
        this.f7219f.setVisibility(8);
        this.f7218e.setVisibility(0);
        this.f7218e.setImageResource(2130837506);
    }

    private void i() {
        this.f7219f.setVisibility(0);
        this.f7218e.setVisibility(0);
        this.f7218e.setImageResource(2130837506);
        this.f7219f.setText("已下载-有更新");
    }

    private void j() {
        if (this.f7214a == 1) {
            this.f7218e.setVisibility(8);
            this.f7219f.setVisibility(0);
            this.f7219f.setText("等待中");
            this.f7219f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f7219f.setVisibility(0);
        this.f7218e.setVisibility(8);
        this.f7219f.setTextColor(Color.parseColor("#4287ff"));
        this.f7219f.setText("等待中");
    }

    private void k() {
        this.f7219f.setVisibility(0);
        this.f7218e.setVisibility(8);
        this.f7219f.setTextColor(SupportMenu.CATEGORY_MASK);
        this.f7219f.setText("下载出现异常");
    }

    private void l() {
        this.f7219f.setVisibility(0);
        this.f7218e.setVisibility(8);
        this.f7219f.setTextColor(-7829368);
        this.f7219f.setText("暂停");
    }

    private void m() {
        this.f7219f.setVisibility(0);
        this.f7218e.setVisibility(8);
        this.f7219f.setText("已下载");
        this.f7219f.setTextColor(Color.parseColor("#898989"));
    }

    private void n() {
        if (this.f7214a == 1) {
            return;
        }
        this.f7219f.setVisibility(0);
        this.f7218e.setVisibility(8);
        this.f7219f.setText("解压中");
        this.f7219f.setTextColor(Color.parseColor("#898989"));
    }

    private void o() {
        if (this.f7221h == null) {
            return;
        }
        this.f7219f.setVisibility(0);
        this.f7219f.setText("下载中");
        this.f7218e.setVisibility(8);
        this.f7219f.setTextColor(Color.parseColor("#4287ff"));
    }

    public final View a() {
        return this.f7224k;
    }

    public final void b(int i6) {
        this.f7214a = i6;
    }

    public final void e(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.f7221h = offlineMapCity;
            this.f7216c.setText(offlineMapCity.getCity());
            double size = ((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d;
            this.f7217d.setText(String.valueOf(size) + " M");
            g(this.f7221h.getState(), this.f7221h.getcompleteCode());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (!b3.h0(this.f7215b)) {
                Toast.makeText(this.f7215b, "无网络连接", 0).show();
                return;
            }
            OfflineMapCity offlineMapCity = this.f7221h;
            if (offlineMapCity != null) {
                int state = offlineMapCity.getState();
                this.f7221h.getcompleteCode();
                if (state == 0) {
                    p();
                    l();
                } else {
                    if (state == 1 || state == 4) {
                        return;
                    }
                    if (q()) {
                        j();
                    } else {
                        k();
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public s3(Context context, OfflineMapManager offlineMapManager) {
        this.f7215b = context;
        f();
        this.f7220g = offlineMapManager;
    }
}
