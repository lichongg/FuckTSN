package com.umeng.socialize.editorpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ShareActivity extends Activity implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    private static final String f42336c = "ShareActivity";

    /* renamed from: d, reason: collision with root package name */
    private static int f42337d = 140;

    /* renamed from: a, reason: collision with root package name */
    protected ImageView f42338a;

    /* renamed from: f, reason: collision with root package name */
    private String f42341f;

    /* renamed from: g, reason: collision with root package name */
    private String f42342g;

    /* renamed from: h, reason: collision with root package name */
    private String f42343h;

    /* renamed from: i, reason: collision with root package name */
    private ResContainer f42344i;

    /* renamed from: j, reason: collision with root package name */
    private EditText f42345j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f42346k;

    /* renamed from: l, reason: collision with root package name */
    private Context f42347l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f42348m;

    /* renamed from: n, reason: collision with root package name */
    private SHARE_MEDIA f42349n;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f42351p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f42352q;

    /* renamed from: e, reason: collision with root package name */
    private String f42340e = "7.3.2";

    /* renamed from: o, reason: collision with root package name */
    private boolean f42350o = false;

    /* renamed from: b, reason: collision with root package name */
    TextWatcher f42339b = new TextWatcher() { // from class: com.umeng.socialize.editorpage.ShareActivity.1
        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            ShareActivity shareActivity = ShareActivity.this;
            shareActivity.f42348m = shareActivity.e();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }
    };

    private String b(String str) {
        return str.equals("TENCENT") ? getResources().getString(this.f42344i.string("umeng_socialize_sharetotencent")) : str.equals("RENREN") ? getResources().getString(this.f42344i.string("umeng_socialize_sharetorenren")) : str.equals("DOUBAN") ? getResources().getString(this.f42344i.string("umeng_socialize_sharetodouban")) : str.equals("TWITTER") ? getResources().getString(this.f42344i.string("umeng_socialize_sharetotwitter")) : str.equals("LINKEDIN") ? getResources().getString(this.f42344i.string("umeng_socialize_sharetolinkin")) : getResources().getString(this.f42344i.string("umeng_socialize_sharetosina"));
    }

    private void d() {
        this.f42343h = null;
        findViewById(this.f42344i.id("root")).setBackgroundColor(Color.parseColor("#D4E0E5"));
        findViewById(this.f42344i.id("umeng_socialize_share_bottom_area")).setVisibility(8);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 == 4 && keyEvent.getRepeatCount() == 0) {
            setResult(1000);
        }
        return super.onKeyDown(i6, keyEvent);
    }

    private void c() {
        SHARE_MEDIA share_media;
        String obj = this.f42345j.getText().toString();
        if (TextUtils.isEmpty(obj.trim()) && this.f42349n == SHARE_MEDIA.SINA && (TextUtils.isEmpty(this.f42343h) || this.f42343h.equals("web") || this.f42343h.equals("video") || this.f42343h.equals("music"))) {
            Toast.makeText(this.f42347l, UmengText.SHARE.CONTEXT_EMPTY, 0).show();
            return;
        }
        if (SocializeUtils.countContentLength(obj) <= f42337d || (share_media = this.f42349n) == SHARE_MEDIA.TWITTER || share_media == SHARE_MEDIA.LINKEDIN) {
            if (this.f42348m && this.f42349n != SHARE_MEDIA.TWITTER) {
                Toast.makeText(this.f42347l, UmengText.SHARE.CONTEXT_LONG, 0).show();
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(SocializeConstants.KEY_TEXT, obj);
            bundle.putString("pic", this.f42343h);
            intent.putExtras(bundle);
            setResult(-1, intent);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int countContentLength = f42337d - SocializeUtils.countContentLength(this.f42345j.getText().toString());
        this.f42346k.setText(SocializeUtils.countContentLength(this.f42345j.getText().toString()) + "/" + f42337d);
        return countContentLength < 0;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!SocializeConstants.BACKKEY_COMPLETE_CLOSE || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.umeng.socialize.editorpage.ShareActivity.2
            @Override // java.lang.Runnable
            public void run() {
                ShareActivity.this.setResult(1000);
                ShareActivity.this.finish();
            }
        }, 400L);
        return true;
    }

    public void onCancel(View view) {
        setResult(1000);
        a();
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.f42345j.requestFocus();
        super.onResume();
    }

    private SHARE_MEDIA a(String str) {
        if (str.equals("DOUBAN")) {
            return SHARE_MEDIA.DOUBAN;
        }
        if (str.equals("TWITTER")) {
            return SHARE_MEDIA.TWITTER;
        }
        if (str.equals("LINKEDIN")) {
            return SHARE_MEDIA.LINKEDIN;
        }
        return SHARE_MEDIA.SINA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == this.f42344i.id("umeng_back")) {
            onCancel(view);
        } else if (id == this.f42344i.id("umeng_share_btn")) {
            c();
        } else if (id == this.f42344i.id("umeng_del")) {
            d();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f42344i = ResContainer.get(this);
        this.f42350o = SocializeUtils.isFloatWindowStyle(this);
        super.onCreate(bundle);
        this.f42347l = this;
        setContentView(this.f42344i.layout("umeng_socialize_share"));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.softInputMode = 32;
        if (this.f42350o) {
            int[] floatWindowSize = SocializeUtils.getFloatWindowSize(this.f42347l);
            attributes.width = floatWindowSize[0];
            attributes.height = floatWindowSize[1];
        }
        getWindow().setAttributes(attributes);
        SLog.E(UmengText.SHARE.SHAREVIEWV + this.f42340e);
        Bundle extras = getIntent().getExtras();
        this.f42349n = a(extras.getString(SocializeConstants.KEY_PLATFORM));
        f42337d = 140;
        this.f42341f = extras.getString(SocializeConstants.KEY_TEXT);
        this.f42343h = extras.getString("pic");
        this.f42342g = extras.getString("title");
        b();
        this.f42351p = (ImageView) findViewById(this.f42344i.id("umeng_del"));
        this.f42345j.addTextChangedListener(this.f42339b);
        ((TextView) findViewById(this.f42344i.id("umeng_title"))).setText(b(extras.getString(SocializeConstants.KEY_PLATFORM)));
        findViewById(this.f42344i.id("umeng_back")).setOnClickListener(this);
        findViewById(this.f42344i.id("umeng_share_btn")).setOnClickListener(this);
        this.f42351p.setOnClickListener(this);
        this.f42346k = (TextView) findViewById(this.f42344i.id("umeng_socialize_share_word_num"));
        this.f42348m = e();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i6, KeyEvent keyEvent) {
        return super.onKeyUp(i6, keyEvent);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    protected void a() {
        finish();
    }

    private void b() {
        this.f42345j = (EditText) findViewById(this.f42344i.id("umeng_socialize_share_edittext"));
        if (!TextUtils.isEmpty(this.f42341f)) {
            this.f42345j.setText(this.f42341f);
            this.f42345j.setSelection(this.f42341f.length());
        }
        this.f42352q = (TextView) findViewById(this.f42344i.id("umeng_web_title"));
        this.f42338a = (ImageView) findViewById(this.f42344i.id("umeng_share_icon"));
        if (this.f42343h != null) {
            findViewById(this.f42344i.id("umeng_socialize_share_bottom_area")).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(this.f42344i.id("umeng_share_icon"));
            this.f42338a = imageView;
            imageView.setVisibility(0);
            if (this.f42343h.equals("video")) {
                this.f42338a.setImageResource(ResContainer.getResourceId(this.f42347l, ResIdentify.RES_TYPE_DRAWABLE, "umeng_socialize_share_video"));
            } else if (this.f42343h.equals("music")) {
                this.f42338a.setImageResource(ResContainer.getResourceId(this.f42347l, ResIdentify.RES_TYPE_DRAWABLE, "umeng_socialize_share_music"));
            } else if (this.f42343h.equals("web")) {
                this.f42338a.setImageResource(ResContainer.getResourceId(this.f42347l, ResIdentify.RES_TYPE_DRAWABLE, "umeng_socialize_share_web"));
            } else {
                this.f42338a.setImageURI(Uri.fromFile(new File(this.f42343h)));
            }
            if (!TextUtils.isEmpty(this.f42342g)) {
                this.f42352q.setVisibility(0);
                this.f42352q.setText(this.f42342g);
            }
            findViewById(this.f42344i.id("root")).setBackgroundColor(-1);
            return;
        }
        if (TextUtils.isEmpty(this.f42342g)) {
            return;
        }
        this.f42338a.setImageResource(ResContainer.getResourceId(this.f42347l, ResIdentify.RES_TYPE_DRAWABLE, "umeng_socialize_share_web"));
        this.f42352q.setVisibility(0);
        this.f42352q.setText(this.f42342g);
    }
}
