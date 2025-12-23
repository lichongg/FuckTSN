package com.acse.ottn.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.g0;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WXActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public EditText f4181a;

    /* renamed from: b, reason: collision with root package name */
    public EditText f4182b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WXActivity.this.a();
        }
    }

    static {
        StubApp.interface11(9038);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    public final void a() {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, g0.a().a((Context) this), false);
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = this.f4182b.getText().toString();
        req.path = this.f4181a.getText().toString();
        req.miniprogramType = 0;
        createWXAPI.sendReq(req);
    }
}
