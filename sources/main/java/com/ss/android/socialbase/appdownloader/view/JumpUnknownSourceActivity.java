package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.appdownloader.f;
import com.ss.android.socialbase.appdownloader.j;
import com.stub.StubApp;
import org.json.JSONObject;
import x2.g;
import x2.k;
import x2.n;

/* loaded from: D:\Downloads\app\classes6.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private n f38564a;

    /* renamed from: b, reason: collision with root package name */
    private Intent f38565b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private Intent f38566c;

    /* renamed from: d, reason: collision with root package name */
    private int f38567d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f38568e;

    class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (JumpUnknownSourceActivity.this.f38566c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                j.r(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f38566c, true);
            }
            j.B(JumpUnknownSourceActivity.this.f38567d, JumpUnknownSourceActivity.this.f38568e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            if (JumpUnknownSourceActivity.this.f38566c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                j.r(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f38566c, true);
            }
            j.B(JumpUnknownSourceActivity.this.f38567d, JumpUnknownSourceActivity.this.f38568e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
            if (j.p(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f38566c, JumpUnknownSourceActivity.this.f38567d, JumpUnknownSourceActivity.this.f38568e)) {
                j.a(JumpUnknownSourceActivity.this.f38567d, JumpUnknownSourceActivity.this.f38568e);
            } else {
                JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                j.r(jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f38566c, true);
            }
            j.h(JumpUnknownSourceActivity.this.f38567d, JumpUnknownSourceActivity.this.f38568e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(41493);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    private void e() {
        if (this.f38564a != null || this.f38565b == null) {
            return;
        }
        try {
            k X = f.L().X();
            g j6 = X != null ? X.j(this) : null;
            if (j6 == null) {
                j6 = new f.g(this);
            }
            int b6 = com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_tip");
            int b7 = com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_label_ok");
            int b8 = com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_label_cancel");
            String optString = this.f38568e.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(optString)) {
                optString = getString(com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            j6.j(b6).j(optString).b(b7, new c()).a(b8, new b()).c(new a()).j(false);
            this.f38564a = j6.j();
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void c() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        com.ss.android.socialbase.appdownloader.g.f().h(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.f38565b = intent;
        if (intent != null) {
            this.f38566c = (Intent) intent.getParcelableExtra("intent");
            this.f38567d = intent.getIntExtra("id", -1);
            try {
                this.f38568e = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        if (this.f38568e == null) {
            com.ss.android.socialbase.appdownloader.b.u(this);
            return;
        }
        e();
        n nVar = this.f38564a;
        if (nVar != null && !nVar.xt()) {
            this.f38564a.j();
        } else if (this.f38564a == null) {
            finish();
        }
    }
}
