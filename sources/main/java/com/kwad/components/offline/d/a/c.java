package com.kwad.components.offline.d.a;

import android.content.Intent;
import com.kwad.components.offline.api.tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.tk.IOfflineTKDialog;
import com.kwad.components.offline.api.tk.IOfflineTKNativeIntent;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.q;
import com.kwad.sdk.components.r;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements IOfflineHostActionHandler {
    private final r afT;

    private n a(final IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        return new n() { // from class: com.kwad.components.offline.d.a.c.1
            @Override // com.kwad.sdk.components.n
            public final void a(q qVar) {
                iOfflineTKNativeIntent.registerJSCallHandler(new g(qVar));
            }

            @Override // com.kwad.sdk.components.n
            public final void callTKBridge(String str) {
                iOfflineTKNativeIntent.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.n
            public final void callbackDismiss() {
                iOfflineTKNativeIntent.callbackDismiss();
            }

            @Override // com.kwad.sdk.components.n
            public final void callbackPageStatus(boolean z5, String str) {
                iOfflineTKNativeIntent.callbackPageStatus(z5, str);
            }

            @Override // com.kwad.sdk.components.n
            public final String getClassName() {
                return iOfflineTKNativeIntent.getClassName();
            }

            @Override // com.kwad.sdk.components.n
            public final Intent getIntent() {
                return iOfflineTKNativeIntent.getIntent();
            }

            @Override // com.kwad.sdk.components.n
            public final String getTemplateString() {
                return iOfflineTKNativeIntent.getTemplateString();
            }

            @Override // com.kwad.sdk.components.n
            public final String getUrl() {
                return iOfflineTKNativeIntent.getUrl();
            }

            @Override // com.kwad.sdk.components.n
            public final String getViewKey() {
                return iOfflineTKNativeIntent.getViewKey();
            }
        };
    }

    private l a(final IOfflineTKDialog iOfflineTKDialog) {
        return new l() { // from class: com.kwad.components.offline.d.a.c.2
            @Override // com.kwad.sdk.components.l
            public final void a(q qVar) {
                iOfflineTKDialog.registerJSCallHandler(new g(qVar));
            }

            @Override // com.kwad.sdk.components.l
            public final void callTKBridge(String str) {
                iOfflineTKDialog.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackDialogDismiss() {
                iOfflineTKDialog.callbackDialogDismiss();
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackPageStatus(boolean z5, String str) {
                iOfflineTKDialog.callbackPageStatus(z5, str);
            }

            @Override // com.kwad.sdk.components.l
            public final int getDialogId() {
                return iOfflineTKDialog.getDialogId();
            }

            @Override // com.kwad.sdk.components.l
            public final String getStyleTemplate() {
                return iOfflineTKDialog.getStyleTemplate();
            }

            @Override // com.kwad.sdk.components.l
            public final String getViewKey() {
                return iOfflineTKDialog.getViewKey();
            }

            @Override // com.kwad.sdk.components.l
            public final boolean isHideNavigationBar() {
                return iOfflineTKDialog.isHideNavigationBar();
            }
        };
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void dismissDialog(IOfflineTKDialog iOfflineTKDialog) {
        r rVar = this.afT;
        if (rVar != null) {
            rVar.b(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void showDialog(IOfflineTKDialog iOfflineTKDialog) {
        r rVar = this.afT;
        if (rVar != null) {
            rVar.a(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        r rVar = this.afT;
        if (rVar != null) {
            rVar.a(a(iOfflineTKNativeIntent));
        }
    }

    public c(r rVar) {
        this.afT = rVar;
    }
}
