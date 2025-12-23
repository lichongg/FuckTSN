package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends KSFrameLayout implements ca.a {
    private InterfaceC0647a ahX;
    private boolean ahY;
    private boolean ahZ;
    private int aia;
    private boolean aib;
    private long aic;
    private boolean aid;
    private final float aie;
    private final int aif;
    private final View bP;
    private final ca bQ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0647a {
        void aa();

        void ab();

        void ay();

        void c(View view);

        void onWindowFocusChanged(boolean z5);
    }

    private void vR() {
        InterfaceC0647a interfaceC0647a;
        if (this.aif == 0 && (interfaceC0647a = this.ahX) != null) {
            interfaceC0647a.c(this.bP);
            return;
        }
        Message obtainMessage = this.bQ.obtainMessage();
        obtainMessage.what = 2;
        this.bQ.sendMessageDelayed(obtainMessage, this.aif);
    }

    private void vS() {
        this.bQ.removeCallbacksAndMessages(null);
        this.ahZ = false;
    }

    private void vT() {
        if (this.ahZ) {
            return;
        }
        this.ahZ = true;
        this.bQ.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (this.ahY) {
            return;
        }
        int i6 = message.what;
        if (i6 != 1) {
            if (i6 != 2) {
                return;
            }
            if (!bz.a(this.bP, (int) (this.aie * 100.0f), false)) {
                this.aia = 5;
                this.bQ.sendEmptyMessage(1);
                return;
            } else {
                InterfaceC0647a interfaceC0647a = this.ahX;
                if (interfaceC0647a != null) {
                    interfaceC0647a.c(this.bP);
                    return;
                }
                return;
            }
        }
        if (!bz.a(this.bP, (int) (this.aie * 100.0f), false)) {
            InterfaceC0647a interfaceC0647a2 = this.ahX;
            if (interfaceC0647a2 != null && !this.aid) {
                interfaceC0647a2.ay();
            }
            this.aid = true;
            ca caVar = this.bQ;
            int i7 = this.aia;
            this.aia = i7 - 1;
            caVar.sendEmptyMessageDelayed(1, i7 > 0 ? 100L : 500L);
            return;
        }
        vS();
        if (this.aib) {
            InterfaceC0647a interfaceC0647a3 = this.ahX;
            if (interfaceC0647a3 != null) {
                interfaceC0647a3.c(this.bP);
            }
        } else {
            this.aib = true;
            this.aic = System.currentTimeMillis();
            vR();
        }
        this.aid = false;
        ca caVar2 = this.bQ;
        int i8 = this.aia;
        this.aia = i8 - 1;
        caVar2.sendEmptyMessageDelayed(1, i8 > 0 ? 100L : 500L);
    }

    public final void setViewCallback(InterfaceC0647a interfaceC0647a) {
        this.ahX = interfaceC0647a;
    }

    public a(Context context, View view) {
        super(context, view);
        this.bQ = new ca(this);
        this.aia = 5;
        this.bP = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float FH = com.kwad.sdk.core.config.e.FH();
        this.aie = FH;
        setVisiblePercent(FH);
        float FJ = com.kwad.sdk.core.config.e.FJ();
        this.aif = (int) ((FJ < 0.0f ? 1.0f : FJ) * 1000.0f);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.k
    public final void E(View view) {
        InterfaceC0647a interfaceC0647a;
        InterfaceC0647a interfaceC0647a2;
        super.E(view);
        if (this.aif == 0 && (interfaceC0647a2 = this.ahX) != null) {
            interfaceC0647a2.c(view);
            return;
        }
        if (!this.aib) {
            this.aib = true;
            this.aic = System.currentTimeMillis();
            vS();
            vR();
            return;
        }
        if (System.currentTimeMillis() - this.aic > this.aif && (interfaceC0647a = this.ahX) != null) {
            interfaceC0647a.c(view);
            vS();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        this.aia = 5;
        this.ahY = false;
        this.aib = false;
        vT();
        InterfaceC0647a interfaceC0647a = this.ahX;
        if (interfaceC0647a != null) {
            interfaceC0647a.aa();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        vS();
        this.aia = 0;
        this.aic = 0L;
        this.ahY = true;
        InterfaceC0647a interfaceC0647a = this.ahX;
        if (interfaceC0647a != null) {
            interfaceC0647a.ab();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        com.kwad.sdk.core.d.c.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z5);
        InterfaceC0647a interfaceC0647a = this.ahX;
        if (interfaceC0647a != null) {
            interfaceC0647a.onWindowFocusChanged(z5);
        }
    }

    public final void vU() {
        vT();
    }
}
