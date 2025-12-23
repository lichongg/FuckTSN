package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.core.vl.m;
import com.bytedance.msdk.core.vl.up;
import com.bytedance.msdk.core.xt;
import com.bytedance.msdk.j.up.cw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.g;
import com.stub.StubApp;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class TTDelegateActivity extends Activity {

    /* renamed from: j, reason: collision with root package name */
    private Intent f24326j;

    static {
        StubApp.interface11(19545);
    }

    private void j() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i6, @NonNull String[] strArr, @NonNull int[] iArr);

    private void xt() {
        try {
            int intExtra = this.f24326j.getIntExtra("type", 0);
            if (intExtra == 1) {
                j(intExtra, this.f24326j.getIntArrayExtra("permissions"));
                return;
            }
            if (intExtra == 2) {
                j(this.f24326j.getStringExtra("permission_id_key"), this.f24326j.getStringArrayExtra("permission_content_key"));
            } else if (intExtra != 3) {
                finish();
            } else {
                j(intExtra, (int[]) null);
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (xt.getContext() == null) {
            xt.j(this);
        }
        try {
            setIntent(intent);
            this.f24326j = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            xt();
        }
    }

    private void j(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    up.j().j(this, strArr, new m() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                        @Override // com.bytedance.msdk.core.vl.m
                        public void j() {
                            com.bytedance.msdk.core.vl.j.j(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.msdk.core.vl.m
                        public void j(String str2) {
                            com.bytedance.msdk.core.vl.j.j(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            } else {
                cw.j(MediationConstant.TAG, "已经有权限");
                finish();
                return;
            }
        }
        finish();
    }

    private void j(int i6, int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ArrayList arrayList = new ArrayList();
                if (i6 != 1) {
                    if (i6 == 3) {
                        arrayList.add(g.f36048h);
                        arrayList.add(g.f36047g);
                        arrayList.add(g.f36043c);
                        arrayList.add(g.f36050j);
                    }
                } else if (iArr != null && iArr.length > 0) {
                    for (int i7 : iArr) {
                        if (i7 == 1) {
                            arrayList.add(g.f36048h);
                            arrayList.add(g.f36047g);
                        } else if (i7 == 2) {
                            arrayList.add(g.f36043c);
                        } else if (i7 == 3) {
                            arrayList.add(g.f36050j);
                        }
                    }
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                up.j().j(this, strArr, new m() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                    @Override // com.bytedance.msdk.core.vl.m
                    public void j() {
                        cw.j("TMe", "-------=----- onGranted");
                        com.bytedance.msdk.j.up.m.r(new j());
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.msdk.core.vl.m
                    public void j(String str) {
                        cw.j("TMe", "-------=----- onDenied: ".concat(String.valueOf(str)));
                        g.f36043c.equals(str);
                        com.bytedance.msdk.j.up.m.r(new j());
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        cw.j(MediationConstant.TAG, "已经有Read phone state权限");
        finish();
    }

    public static class j implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
