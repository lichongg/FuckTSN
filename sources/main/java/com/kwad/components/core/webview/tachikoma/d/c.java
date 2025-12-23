package com.kwad.components.core.webview.tachikoma.d;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.utils.br;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends a {
    private String AI;
    private FrameLayout Yp;
    private e afi;
    private p ahv;
    private az ahw;
    private com.kwad.components.core.webview.tachikoma.f.e ahx = new com.kwad.components.core.webview.tachikoma.f.e() { // from class: com.kwad.components.core.webview.tachikoma.d.c.2
        @Override // com.kwad.components.core.webview.tachikoma.f.e
        public final void ha() {
            if (c.this.ahw != null) {
                c.this.ahw.uF();
                c.this.ahw.uG();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.e
        public final void hi() {
            if (c.this.ahw != null) {
                c.this.ahw.uH();
                c.this.ahw.uI();
            }
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0637a c0637a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF() {
        e.a aVar = this.ahp.ahu;
        if (aVar != null) {
            aVar.hc();
        }
        com.kwad.components.core.webview.tachikoma.e.c.vO().t(getTkTemplateId(), getTKReaderScene());
        l lVar = this.ahp.ahr;
        if (lVar != null) {
            lVar.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        l lVar = this.ahp.ahr;
        if (lVar != null) {
            lVar.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.Yp;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_dialog";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        StyleTemplate styleTemplate = this.ahp.Yf;
        return styleTemplate != null ? styleTemplate.templateId : this.AI;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a
    protected final void a(b bVar) {
        super.a(bVar);
        b bVar2 = this.ahp;
        this.AI = bVar2.AI;
        this.afi = bVar2.afi;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void aA() {
        super.aA();
        b bVar = this.ahp;
        if (bVar.aht) {
            com.kwad.components.core.webview.tachikoma.f.c cVar = bVar.Yd;
            if (cVar != null) {
                cVar.G(true);
                return;
            }
            return;
        }
        e eVar = this.afi;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.f.c cVar2 = this.ahp.Yd;
        if (cVar2 != null) {
            cVar2.hj();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        e eVar = this.afi;
        if (eVar != null) {
            eVar.a(this.ahx);
        }
        if (this.ahp.ahr != null) {
            this.fU.a(new g() { // from class: com.kwad.components.core.webview.tachikoma.d.c.1
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    c.this.ahp.ahr.callTKBridge(str);
                }
            });
            this.ahp.ahr.a(this.fU);
            this.fU.a("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Yp = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float f6;
        float f7;
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        FrameLayout frameLayout = this.Yp;
        if (frameLayout != null) {
            f6 = frameLayout.getHeight();
            f7 = this.Yp.getWidth();
        } else {
            f6 = 0.0f;
            f7 = 0.0f;
        }
        if (f6 != 0.0f && f7 != 0.0f) {
            aVar.width = (int) ((f7 / bj) + 0.5f);
            aVar.height = (int) ((f6 / bj) + 0.5f);
        } else {
            aVar.width = (int) ((br.getScreenWidth(getContext()) / bj) + 0.5f);
            aVar.height = (int) ((br.getScreenHeight(getContext()) / bj) + 0.5f);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
        this.ahv = pVar;
        long j6 = this.ahp.AO;
        if (pVar == null || j6 <= 0) {
            return;
        }
        z zVar = new z();
        zVar.qz = (int) ((j6 / 1000.0f) + 0.5f);
        this.ahv.a(zVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.ahw = azVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aB() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        super.a(uVar);
        e eVar = this.afi;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.ahp.Yd;
        if (cVar != null) {
            cVar.G(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        l lVar = this.ahp.ahr;
        if (lVar != null) {
            lVar.callbackDialogDismiss();
        }
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.afi;
        if (eVar != null) {
            if (eVar.isShowing()) {
                this.afi.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.tachikoma.d.c.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        c.this.afi.e(this);
                        c.this.vF();
                    }
                });
            } else {
                vF();
            }
            this.afi.dismiss();
            return;
        }
        vF();
    }
}
