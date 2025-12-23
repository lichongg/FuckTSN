package com.kwad.components.core.e.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.kwad.components.core.e.c.a;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends g {

    @Nullable
    private static b OG;

    @NonNull
    private final C0615b OH;
    private com.kwad.components.core.e.c.a OL;
    private boolean OM;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        @Nullable
        private DialogInterface.OnShowListener OO;

        @Nullable
        private DialogInterface.OnDismissListener OP;
        private AdTemplate adTemplate;
        private String url;

        public final a a(@Nullable DialogInterface.OnShowListener onShowListener) {
            this.OO = onShowListener;
            return this;
        }

        public final a aA(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final a ak(String str) {
            this.url = str;
            return this;
        }

        public final a c(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            this.OP = onDismissListener;
            return this;
        }

        public final C0615b oZ() {
            if (com.kwad.components.core.a.oz.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0615b(this, (byte) 0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.e.c.b$b, reason: collision with other inner class name */
    public static class C0615b {

        @Nullable
        protected DialogInterface.OnShowListener OO;

        @Nullable
        protected DialogInterface.OnDismissListener OP;
        protected final AdTemplate adTemplate;
        protected String url;

        /* synthetic */ C0615b(a aVar, byte b6) {
            this(aVar);
        }

        private C0615b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.OO = aVar.OO;
            this.OP = aVar.OP;
        }
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.g
    public final boolean oX() {
        return true;
    }

    public static boolean a(Context context, C0615b c0615b) {
        Activity ej;
        b bVar = OG;
        if ((bVar == null || !bVar.isShowing()) && context != null && (ej = m.ej(context)) != null && !ej.isFinishing()) {
            com.kwad.sdk.a.a.c.CU().dismiss();
            try {
                b bVar2 = new b(ej, c0615b);
                OG = bVar2;
                bVar2.show();
                com.kwad.sdk.core.adlog.c.b(c0615b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
        return false;
    }

    public static boolean oW() {
        b bVar = OG;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public final void al(boolean z5) {
        this.OM = z5;
        dismiss();
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup dw() {
        com.kwad.components.core.e.c.a aVar = new com.kwad.components.core.e.c.a(this.mContext, this, this.OH);
        this.OL = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        this.OL.setChangeListener(new a.InterfaceC0614a() { // from class: com.kwad.components.core.e.c.b.1
            @Override // com.kwad.components.core.e.c.a.InterfaceC0614a
            public final void oV() {
                b.this.dismiss();
            }
        });
    }

    public final boolean oY() {
        return this.OM;
    }

    private b(Activity activity, @NonNull C0615b c0615b) {
        super(activity);
        this.OM = false;
        this.OH = c0615b;
        if (com.kwad.sdk.c.a.a.d(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0615b.OO);
        setOnDismissListener(c0615b.OP);
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        OG = null;
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.adlog.c.cb(this.OH.adTemplate);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OG = null;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = OG;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        int i6;
        Resources resources;
        int identifier;
        try {
            super.show();
            try {
                if (getContext() != null && (resources = getContext().getResources()) != null && (identifier = resources.getIdentifier("navigation_bar_height", "dimen", FaceEnvironment.OS)) > 0) {
                    i6 = getContext().getResources().getDimensionPixelSize(identifier);
                } else {
                    i6 = 0;
                }
                if (i6 > 0) {
                    getWindow().getDecorView().setSystemUiVisibility(5382);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }
}
