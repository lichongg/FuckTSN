package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.hl;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.res.up;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends AlertDialog implements l.j {
    private final String ae;
    private Context cw;

    /* renamed from: g, reason: collision with root package name */
    private long f28486g;

    /* renamed from: j, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.xt.xt f28487j;

    /* renamed from: m, reason: collision with root package name */
    private TextView f28488m;
    private boolean oq;

    /* renamed from: r, reason: collision with root package name */
    private TextView f28489r;
    private final j tl;
    private TextView up;
    protected final l xt;

    public interface j {
        void j(Dialog dialog);

        void xt(Dialog dialog);
    }

    private void j() {
        this.f28489r = (TextView) findViewById(2114387832);
        this.up = (TextView) findViewById(2114387644);
        this.f28488m = (TextView) findViewById(2114387839);
        if (this.tl == null) {
            return;
        }
        ed.j((View) this.up, (View.OnClickListener) this.f28487j, "goLiveListener");
        ed.j(this.f28488m, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.xt.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xt.this.tl.j(xt.this);
            }
        }, "cancelTv");
    }

    public xt(Context context, n nVar, j jVar) {
        super(context);
        this.xt = new l(Looper.getMainLooper(), this);
        this.oq = false;
        this.cw = context;
        if (context == null) {
            this.cw = v.getContext();
        }
        this.ae = hl.m(nVar);
        this.tl = jVar;
        if (hl.up(nVar) == 3) {
            this.oq = true;
            this.f28486g = 5L;
        } else {
            this.f28486g = hl.tl(nVar);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(up.wq(this.cw));
        setCanceledOnTouchOutside(false);
        j();
        this.xt.sendEmptyMessageDelayed(101, 1000L);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        if (z5) {
            this.xt.removeMessages(101);
            this.xt.sendEmptyMessageDelayed(101, 1000L);
        } else {
            this.xt.removeMessages(101);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        ed.j(this.f28489r, this.ae);
    }

    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        this.f28487j = xtVar;
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        j jVar;
        if (message.what == 101) {
            long j6 = this.f28486g - 1;
            this.f28486g = j6;
            if (j6 <= 0) {
                if (this.oq && (jVar = this.tl) != null) {
                    jVar.xt(this);
                }
                j jVar2 = this.tl;
                if (jVar2 != null) {
                    jVar2.j(this);
                    return;
                }
                return;
            }
            if (this.oq) {
                ed.j(this.f28488m, kt.j(this.cw, "tt_reward_live_dialog_cancel_text"));
            } else {
                ed.j(this.f28488m, String.format(kt.j(this.cw, "tt_reward_live_dialog_cancel_count_down_text"), String.valueOf(j6)));
            }
            this.xt.sendEmptyMessageDelayed(101, 1000L);
        }
    }
}
