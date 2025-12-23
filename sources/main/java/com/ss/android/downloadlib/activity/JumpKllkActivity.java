package com.ss.android.downloadlib.activity;

import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.up.a;
import com.ss.android.socialbase.appdownloader.b;

/* loaded from: D:\Downloads\app\classes6.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    protected void d() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            a.a().c("handleIntent is null");
            b.u(this);
            return;
        }
        String stringExtra = intent.getStringExtra("p");
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            a.a().c("getPackage or id is null");
            b.u(this);
        }
        boolean z5 = false;
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if ((!TextUtils.isEmpty(stringExtra2)) & booleanExtra) {
            a.m.v(this, stringExtra, longExtra, stringExtra2, true);
            b.u(this);
            return;
        }
        int optInt = m.f().optInt("ab", 0);
        if (optInt == 1) {
            z5 = true;
        }
        a.m.w(this, stringExtra, longExtra, z5);
        if (optInt != 1) {
            b.u(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        b.u(this);
    }
}
