package xyz.adscope.ad.widget.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.BasicWebView;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.permission.PermissionModel;
import xyz.adscope.amps.R;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPDlInfoDetailActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private TabLayout f56074a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f56075b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f56076c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f56077d;

    /* renamed from: e, reason: collision with root package name */
    private BasicWebView f56078e;

    /* renamed from: f, reason: collision with root package name */
    private String f56079f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, b> f56080g;

    /* renamed from: h, reason: collision with root package name */
    private final String[] f56081h = {"introduction", "privacy", "permission"};

    /* renamed from: i, reason: collision with root package name */
    private int f56082i = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements TabLayout.OnTabSelectedListener {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            ASNPDlInfoDetailActivity.this.f56082i = tab.getPosition();
            ASNPDlInfoDetailActivity aSNPDlInfoDetailActivity = ASNPDlInfoDetailActivity.this;
            aSNPDlInfoDetailActivity.a(aSNPDlInfoDetailActivity.f56082i);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            int position = tab.getPosition();
            if (ASNPDlInfoDetailActivity.this.f56082i != position) {
                ASNPDlInfoDetailActivity.this.a(position);
                ASNPDlInfoDetailActivity.this.f56082i = position;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f56084a;

        /* renamed from: b, reason: collision with root package name */
        private final String f56085b;

        /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        private b(String str, String str2) {
            this.f56084a = str;
            this.f56085b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            if (TextUtils.isEmpty(this.f56085b)) {
                return false;
            }
            return this.f56085b.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a);
        }
    }

    static {
        StubApp.interface11(55518);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    private void b() {
        Intent intent = getIntent();
        if (intent == null) {
            a();
            return;
        }
        if (a(intent)) {
            a();
            return;
        }
        String stringExtra = intent.getStringExtra("whichTab");
        if (TextUtils.isEmpty(stringExtra)) {
            d();
        } else {
            a(stringExtra);
        }
    }

    private void c() {
        this.f56077d = (FrameLayout) findViewById(R.id.asnp_download_detail_layout);
        this.f56075b = (TextView) findViewById(R.id.asnp_download_detail_title);
        this.f56078e = (BasicWebView) findViewById(R.id.asnp_download_detail_web);
        this.f56076c = (TextView) findViewById(R.id.asnp_download_detail_content);
        ((ImageView) findViewById(R.id.asnp_download_detail_back)).setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.widget.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ASNPDlInfoDetailActivity.this.a(view);
            }
        });
        TabLayout tabLayout = (TabLayout) findViewById(R.id.asnp_download_detail_tab);
        this.f56074a = tabLayout;
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
    }

    private void d() {
        a("introduction");
    }

    private void a(String str) {
        int i6;
        if (!TextUtils.isEmpty(str)) {
            if ("introduction".equalsIgnoreCase(str)) {
                i6 = 0;
            } else if ("privacy".equalsIgnoreCase(str)) {
                i6 = 1;
            } else {
                i6 = "permission".equals(str) ? 2 : -1;
            }
            TabLayout tabLayout = this.f56074a;
            if (tabLayout != null && i6 != -1) {
                tabLayout.selectTab(tabLayout.getTabAt(i6));
                return;
            }
        }
        d();
    }

    private boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("dlm");
        if (!TextUtils.isEmpty(stringExtra) && JsonUtil.isValidJson(stringExtra)) {
            DownloadInfoModel downloadInfoModel = new DownloadInfoModel(JsonUtil.parseJSONObject(stringExtra));
            if (!downloadInfoModel.hasParseException()) {
                this.f56079f = downloadInfoModel.f();
                ArrayMap arrayMap = new ArrayMap();
                this.f56080g = arrayMap;
                a aVar = null;
                arrayMap.put("introduction", new b(downloadInfoModel.b(), "", aVar));
                this.f56080g.put("privacy", new b(downloadInfoModel.i(), downloadInfoModel.j(), aVar));
                this.f56080g.put("permission", new b(a(downloadInfoModel.g()), downloadInfoModel.h(), aVar));
                return false;
            }
        }
        return true;
    }

    private void a() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private String a(List<PermissionModel> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            for (PermissionModel permissionModel : list) {
                String c6 = permissionModel.c();
                String a6 = permissionModel.a();
                sb.append(c6);
                sb.append(":");
                sb.append(a6);
                sb.append(com.snail.antifake.deviceid.e.f37542d);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6) {
        b bVar;
        this.f56075b.setText(this.f56079f);
        if (i6 < 3) {
            String str = this.f56081h[i6];
            Map<String, b> map = this.f56080g;
            if (map == null || (bVar = map.get(str)) == null) {
                return;
            }
            if (bVar.a()) {
                this.f56077d.setVisibility(8);
                this.f56078e.setVisibility(4);
                this.f56078e.loadUrl(bVar.f56085b);
            } else {
                this.f56077d.setVisibility(0);
                this.f56078e.setVisibility(8);
                this.f56076c.setText(bVar.f56084a);
            }
        }
    }
}
