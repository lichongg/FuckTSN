package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ADActivity extends Activity {
    public static final String NOTCH_CONTAINER_TAG = "NOTCH_CONTAINER";

    /* renamed from: a, reason: collision with root package name */
    protected ACTD f36542a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout f36543b;

    static {
        StubApp.interface11(40690);
    }

    private void b() {
        String str = null;
        try {
            POFactory pOFactory = a.b().c().getPOFactory();
            if (pOFactory == null) {
                return;
            }
            Intent intent = getIntent();
            intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return;
            }
            str = extras.getString(ACTD.DELEGATE_NAME_KEY);
            String string = extras.getString("appid");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(string) || !a.b().d()) {
                return;
            }
            ACTD activityDelegate = pOFactory.getActivityDelegate(str, this);
            this.f36542a = activityDelegate;
            if (activityDelegate == null) {
                GDTLogger.e("创建 ADActivity Delegate " + str + " 失败");
            }
        } catch (Throwable th) {
            GDTLogger.e("创建ADActivity Delegate" + str + "发生异常", th);
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void setContentView(int i6) {
        a();
        LayoutInflater.from(this).inflate(i6, (ViewGroup) this.f36543b, true);
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        super.setContentView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setTag(NOTCH_CONTAINER_TAG);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(frameLayout);
        this.f36543b = new FrameLayout(this);
        this.f36543b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(this.f36543b);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.f36542a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.f36542a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onStop() {
        ACTD actd = this.f36542a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        a();
        this.f36543b.addView(view);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
        ACTD actd = this.f36542a;
        if (actd != null) {
            actd.onActivityResult(i6, i7, intent);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.f36542a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ACTD actd = this.f36542a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ACTD actd = this.f36542a;
        if (actd != null) {
            actd.onResume();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a();
        this.f36543b.addView(view, layoutParams);
    }
}
