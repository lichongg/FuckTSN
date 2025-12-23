package com.beizi.ad.internal.view;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.core.view.ViewCompat;
import com.beizi.ad.internal.h.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h extends a {

    /* renamed from: a, reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f12705a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout f12706b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f12707c;

    /* renamed from: d, reason: collision with root package name */
    private AdViewImpl f12708d;

    /* renamed from: e, reason: collision with root package name */
    private AdWebView f12709e;

    public h(Activity activity) {
        this.f12707c = activity;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i6, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    private void a(FrameLayout frameLayout) {
        ImageButton imageButton = new ImageButton(this.f12707c);
        imageButton.setImageDrawable(this.f12707c.getResources().getDrawable(R.drawable.ic_menu_close_clear_cancel));
        imageButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.onHideCustomView();
            }
        });
        frameLayout.addView(imageButton);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        AdViewImpl adViewImpl = this.f12708d;
        if (adViewImpl == null || adViewImpl.e() || this.f12708d.a()) {
            return;
        }
        this.f12708d.getAdDispatcher().b();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
        AdWebView adWebView = this.f12709e;
        AlertDialog.Builder builder = new AlertDialog.Builder(adWebView != null ? u.b(adWebView) : this.f12707c);
        builder.setTitle(String.format(this.f12707c.getResources().getString(com.beizi.fusion.R.string.beizi_html5_geo_permission_prompt_title), str));
        builder.setMessage(com.beizi.fusion.R.string.beizi_html5_geo_permission_prompt);
        builder.setPositiveButton(com.beizi.fusion.R.string.beizi_allow, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.h.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                callback.invoke(str, true, true);
            }
        });
        builder.setNegativeButton(com.beizi.fusion.R.string.beizi_deny, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.h.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                callback.invoke(str, false, false);
            }
        });
        builder.create().show();
        AdViewImpl adViewImpl = this.f12708d;
        if (adViewImpl == null || adViewImpl.e() || this.f12708d.a()) {
            return;
        }
        this.f12708d.getAdDispatcher().c();
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
        Activity activity = this.f12707c;
        if (activity == null) {
            return;
        }
        AdWebView adWebView = this.f12709e;
        ViewGroup viewGroup = adWebView != null ? (ViewGroup) adWebView.getRootView().findViewById(R.id.content) : (ViewGroup) activity.findViewById(R.id.content);
        if (viewGroup == null) {
            return;
        }
        this.f12705a = customViewCallback;
        if (!(view instanceof FrameLayout)) {
            this.f12706b = null;
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view;
        this.f12706b = frameLayout;
        frameLayout.setClickable(true);
        this.f12706b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        try {
            a(this.f12706b);
            viewGroup.addView(this.f12706b, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception unused) {
        }
    }

    public h(AdWebView adWebView) {
        this.f12707c = (Activity) adWebView.getContextFromMutableContext();
        this.f12709e = adWebView;
        this.f12708d = adWebView.adViewImpl;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        ViewGroup viewGroup;
        super.onHideCustomView();
        Activity activity = this.f12707c;
        if (activity != null && this.f12706b != null) {
            AdWebView adWebView = this.f12709e;
            if (adWebView != null) {
                viewGroup = (ViewGroup) adWebView.getRootView().findViewById(R.id.content);
            } else {
                viewGroup = (ViewGroup) activity.findViewById(R.id.content);
            }
            if (viewGroup != null) {
                viewGroup.removeView(this.f12706b);
                WebChromeClient.CustomViewCallback customViewCallback = this.f12705a;
                if (customViewCallback != null) {
                    try {
                        customViewCallback.onCustomViewHidden();
                    } catch (NullPointerException unused) {
                    }
                }
            }
        }
    }
}
