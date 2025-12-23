package xyz.adscope.ad.widget.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.LandingPageWebView;
import xyz.adscope.ad.b7;
import xyz.adscope.amps.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPLandingPageActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private LandingPageWebView f56106a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f56107b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f56108c;

    /* renamed from: d, reason: collision with root package name */
    private View f56109d;

    /* renamed from: e, reason: collision with root package name */
    private String f56110e = "";

    static {
        StubApp.interface11(55525);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private void b() {
        this.f56108c.setBackgroundColor(Color.parseColor(b7.a().a("#FFFFFF")));
        this.f56109d.setBackgroundColor(Color.parseColor(b7.a().a("#FFC1C1C1")));
        this.f56107b.setTextColor(Color.parseColor(b7.a().a("#000000")));
    }

    private void d() {
        this.f56108c = (LinearLayout) findViewById(R.id.landing_page_container);
        this.f56109d = findViewById(R.id.landing_page_divider);
        this.f56106a = (LandingPageWebView) findViewById(R.id.landing_page_main);
        TextView textView = (TextView) findViewById(R.id.landing_page_close);
        this.f56107b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.widget.activity.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ASNPLandingPageActivity.this.a(view);
            }
        });
        try {
            b();
        } catch (Exception unused) {
        }
    }

    private void a() {
        finish();
    }

    private void c() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f56110e = intent.getStringExtra("url");
            Bundle bundleExtra = intent.getBundleExtra(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
            if (bundleExtra != null) {
                boolean z5 = bundleExtra.getBoolean("allow", false);
                LandingPageWebView landingPageWebView = this.f56106a;
                if (landingPageWebView != null) {
                    landingPageWebView.setAllowDeeplinkDirect(z5);
                }
            }
        }
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("X-Requested-With", "");
        this.f56106a.loadUrl(str, hashMap);
    }
}
