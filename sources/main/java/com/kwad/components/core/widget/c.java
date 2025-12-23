package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.ca;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends View implements ca.a {
    private boolean ahY;
    private boolean ahZ;
    private a ais;
    private boolean ait;
    private final int aiu;
    private View bP;
    private final ca bQ;
    private final AtomicBoolean bR;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void fs();
    }

    private void vS() {
        if (this.ahZ) {
            this.bQ.removeCallbacksAndMessages(null);
            this.ahZ = false;
        }
    }

    private void vT() {
        if (!this.ait || this.ahZ) {
            return;
        }
        this.ahZ = true;
        this.bQ.sendEmptyMessage(1);
    }

    private void vX() {
        this.bR.getAndSet(false);
    }

    private void vY() {
        this.bR.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        a aVar;
        int i6 = message.what;
        if (i6 != 1) {
            if (i6 != 2) {
                return;
            }
            if (!bz.a(this.bP, this.aiu, false)) {
                if (this.ahY) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            } else {
                if (message.arg1 == 1000 && (aVar = this.ais) != null) {
                    aVar.fs();
                }
                this.bQ.sendEmptyMessageDelayed(2, 500L);
                return;
            }
        }
        com.kwad.sdk.core.d.c.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.ahZ) {
            if (!bz.a(this.bP, this.aiu, false)) {
                this.bQ.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            vS();
            Message obtainMessage = this.bQ.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.bQ.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    public final void setNeedCheckingShow(boolean z5) {
        this.ait = z5;
        if (!z5 && this.ahZ) {
            vS();
        } else {
            if (!z5 || this.ahZ) {
                return;
            }
            vT();
        }
    }

    public final void setViewCallback(a aVar) {
        this.ais = aVar;
    }

    public c(Context context, View view) {
        super(context);
        this.bQ = new ca(this);
        this.bR = new AtomicBoolean(true);
        this.aiu = (int) (com.kwad.sdk.core.config.e.FH() * 100.0f);
        this.bP = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    @Override // android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onAttachedToWindow:" + this);
        vT();
        this.ahY = false;
        vX();
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onDetachedFromWindow" + this);
        vS();
        this.ahY = true;
        vY();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onFinishTemporaryDetach:" + this.bP.getParent());
        vX();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onStartTemporaryDetach:" + this.bP.getParent());
        vY();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z5);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowVisibilityChanged visibility:" + i6);
    }
}
