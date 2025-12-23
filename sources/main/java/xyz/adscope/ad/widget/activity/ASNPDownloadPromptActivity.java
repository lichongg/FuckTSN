package xyz.adscope.ad.widget.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.BasicWebView;
import xyz.adscope.ad.b7;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.permission.PermissionModel;
import xyz.adscope.amps.R;
import xyz.adscope.common.v2.image.loader.ImageLoader;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPDownloadPromptActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private TextView f56086a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f56087b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f56088c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f56089d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f56090e;

    /* renamed from: f, reason: collision with root package name */
    private ExpandableListView f56091f;

    /* renamed from: g, reason: collision with root package name */
    private LinearLayout f56092g;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f56093h;

    /* renamed from: i, reason: collision with root package name */
    private DownloadInfoModel f56094i;

    /* renamed from: j, reason: collision with root package name */
    private int f56095j = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f56096a;

        /* renamed from: b, reason: collision with root package name */
        private final String f56097b;

        /* renamed from: c, reason: collision with root package name */
        private final String f56098c;

        /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }

        private b(String str, String str2, String str3) {
            this.f56096a = str2;
            this.f56097b = str3;
            this.f56098c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            if (TextUtils.isEmpty(this.f56097b)) {
                return false;
            }
            return this.f56097b.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends BaseExpandableListAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final Context f56099a;

        /* renamed from: b, reason: collision with root package name */
        private final List<b> f56100b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            TextView f56101a;

            /* renamed from: b, reason: collision with root package name */
            BasicWebView f56102b;
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            TextView f56103a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f56104b;

            /* renamed from: c, reason: collision with root package name */
            View f56105c;
        }

        /* synthetic */ c(Context context, List list, a aVar) {
            this(context, list);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i6, int i7) {
            return i7;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int i6) {
            return 1;
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i6) {
            return i6;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return false;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i6, int i7) {
            return false;
        }

        private c(Context context, List<b> list) {
            ArrayList arrayList = new ArrayList();
            this.f56100b = arrayList;
            this.f56099a = context;
            arrayList.clear();
            arrayList.addAll(list);
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i6, int i7) {
            return this.f56100b.get(i6);
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int i6, int i7, boolean z5, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f56099a).inflate(R.layout.asnp_download_dialog_expand_child_item, (ViewGroup) null);
                aVar = new a();
                aVar.f56101a = (TextView) view.findViewById(R.id.addeci_content_tv);
                aVar.f56102b = (BasicWebView) view.findViewById(R.id.addeci_content_wb);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            b bVar = this.f56100b.get(i6);
            if (bVar.a()) {
                aVar.f56101a.setVisibility(8);
                if (TextUtils.isEmpty(bVar.f56097b)) {
                    aVar.f56102b.setVisibility(8);
                    return view;
                }
                aVar.f56102b.setVisibility(0);
                aVar.f56102b.loadUrl(bVar.f56097b);
                return view;
            }
            aVar.f56102b.setVisibility(8);
            if (TextUtils.isEmpty(bVar.f56096a)) {
                aVar.f56101a.setVisibility(8);
                return view;
            }
            aVar.f56101a.setText(bVar.f56096a);
            aVar.f56101a.setVisibility(0);
            try {
                aVar.f56101a.setTextColor(Color.parseColor(b7.a().a("#8C8C8C")));
            } catch (Exception unused) {
            }
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int i6) {
            return this.f56100b.get(i6);
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return this.f56100b.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i6, boolean z5, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.f56099a).inflate(R.layout.asnp_download_dialog_expand_parent_item, (ViewGroup) null);
                bVar = new b();
                bVar.f56103a = (TextView) view.findViewById(R.id.addep_title_tv);
                bVar.f56104b = (ImageView) view.findViewById(R.id.addep_fold_iv);
                bVar.f56105c = view.findViewById(R.id.addep_item_divider_view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f56103a.setText(this.f56100b.get(i6).f56098c);
            if (z5) {
                bVar.f56103a.setTextColor(Color.parseColor("#FF8E15"));
                bVar.f56104b.setBackgroundResource(R.mipmap.asnp_icon_arrow_unfold);
            } else {
                try {
                    bVar.f56103a.setTextColor(Color.parseColor(b7.a().a("#333333")));
                } catch (Exception e6) {
                    SDKLog.stack(e6);
                }
                bVar.f56104b.setBackgroundResource(R.mipmap.asnp_icon_arrow_fold);
            }
            if (i6 == 0) {
                bVar.f56105c.setVisibility(8);
            } else {
                bVar.f56105c.setVisibility(0);
            }
            return view;
        }
    }

    static {
        StubApp.interface11(55524);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    private void a() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("download_info_key");
            if (TextUtils.isEmpty(stringExtra) || !JsonUtil.isValidJson(stringExtra)) {
                return;
            }
            DownloadInfoModel downloadInfoModel = new DownloadInfoModel(JsonUtil.parseJSONObject(stringExtra));
            if (downloadInfoModel.hasParseException()) {
                return;
            }
            this.f56094i = downloadInfoModel;
        }
    }

    private void b() {
        this.f56093h = (LinearLayout) findViewById(R.id.adscope_download_dialog_total_layout);
        View findViewById = findViewById(R.id.adscope_download_dialog_divider_view);
        this.f56089d = (ImageView) findViewById(R.id.adscope_download_dialog_close_iv);
        this.f56090e = (ImageView) findViewById(R.id.adscope_download_dialog_icon_iv);
        this.f56086a = (TextView) findViewById(R.id.adscope_download_dialog_name_tv);
        this.f56087b = (TextView) findViewById(R.id.adscope_download_dialog_version_tv);
        this.f56088c = (TextView) findViewById(R.id.adscope_download_dialog_developer_tv);
        this.f56091f = (ExpandableListView) findViewById(R.id.adscope_download_dialog_expand_lv);
        this.f56092g = (LinearLayout) findViewById(R.id.adscope_download_dialog_download_ll);
        this.f56091f.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() { // from class: xyz.adscope.ad.widget.activity.e
            @Override // android.widget.ExpandableListView.OnGroupExpandListener
            public final void onGroupExpand(int i6) {
                ASNPDownloadPromptActivity.this.a(i6);
            }
        });
        try {
            this.f56093h.setBackgroundColor(Color.parseColor(b7.a().a("#FFFFFF")));
            findViewById.setBackgroundColor(Color.parseColor(b7.a().a("#CCCCCC")));
            this.f56089d.setImageTintList(ColorStateList.valueOf(Color.parseColor(b7.a().a("#000000"))));
            this.f56086a.setTextColor(Color.parseColor(b7.a().a("#000000")));
            this.f56087b.setTextColor(Color.parseColor(b7.a().a("#8C8C8C")));
            this.f56088c.setTextColor(Color.parseColor(b7.a().a("#8C8C8C")));
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
    }

    private void c() {
        this.f56089d.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.widget.activity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ASNPDownloadPromptActivity.this.a(view);
            }
        });
        this.f56092g.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.widget.activity.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ASNPDownloadPromptActivity.this.b(view);
            }
        });
        DownloadInfoModel downloadInfoModel = this.f56094i;
        if (downloadInfoModel == null) {
            return;
        }
        if (this.f56090e != null && !TextUtils.isEmpty(downloadInfoModel.e())) {
            ImageLoader.getInstance().loadPermanentImage(this.f56090e, this.f56094i.e(), false);
        }
        if (this.f56086a != null && !TextUtils.isEmpty(this.f56094i.f())) {
            this.f56086a.setText(this.f56094i.f());
        }
        if (this.f56087b != null && !TextUtils.isEmpty(this.f56094i.l())) {
            this.f56087b.setText(String.format("%s %s", getString(R.string.adscope_version_code), this.f56094i.l()));
        }
        if (this.f56088c != null && !TextUtils.isEmpty(this.f56094i.d())) {
            this.f56088c.setText(String.format("%s %s", getString(R.string.adscope_developer), this.f56094i.d()));
        }
        ArrayList arrayList = new ArrayList();
        a aVar = null;
        arrayList.add(new b(getString(R.string.adscope_app_permission), a(this.f56094i.g()), this.f56094i.h(), aVar));
        arrayList.add(new b(getString(R.string.adscope_app_privacy_policy), this.f56094i.i(), this.f56094i.j(), aVar));
        arrayList.add(new b(getString(R.string.adscope_app_intro_info), this.f56094i.b(), "", aVar));
        this.f56091f.setAdapter(new c(this, arrayList, aVar));
    }

    private void d() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Point point = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = point.x;
        attributes.height = (int) (point.y * 0.45d);
        attributes.gravity = 80;
        window.setAttributes(attributes);
        layoutParams.width = point.x;
        layoutParams.height = (int) (point.y * 0.45d);
        layoutParams.gravity = 80;
        this.f56093h.setLayoutParams(layoutParams);
        this.f56093h.requestLayout();
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
    public /* synthetic */ void a(int i6) {
        int i7 = this.f56095j;
        if (i7 != -1) {
            this.f56091f.collapseGroup(i7);
        }
        this.f56095j = i6;
    }

    private void a(boolean z5) {
        Intent intent = new Intent();
        intent.setAction("com.asnp.ad.ACTION_DOWNLOAD_PROMPT_RESULT");
        if (z5) {
            intent.putExtra("prompt", "confirm");
        } else {
            intent.putExtra("prompt", CommonNetImpl.CANCEL);
        }
        finish();
        LocalBroadcastManager.getInstance(StubApp.getOrigApplicationContext(getApplicationContext())).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(false);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }
}
