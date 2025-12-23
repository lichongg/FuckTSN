package xyz.adscope.ad.widget.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.stub.StubApp;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPAdActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private String f56069a;

    /* renamed from: b, reason: collision with root package name */
    private String f56070b;

    /* renamed from: c, reason: collision with root package name */
    private String f56071c;

    /* renamed from: d, reason: collision with root package name */
    private String f56072d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f56073e;

    static {
        StubApp.interface11(55515);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    protected void a() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f56073e = relativeLayout;
        addContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        this.f56073e.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: xyz.adscope.ad.widget.activity.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                ASNPAdActivity.this.a(view, i6, i7, i8, i9, i10, i11, i12, i13);
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f56073e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        if (!(view instanceof RelativeLayout) || ((RelativeLayout) view).getChildCount() > 0) {
            return;
        }
        a(false, "");
    }

    private boolean a(String str, String str2, String str3) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) ? false : true;
    }

    private void a(boolean z5, String str) {
        SDKLog.e("ASNPAdActivity", "广告Activity异常..." + str);
        if (z5) {
            a(str);
        }
        finish();
    }

    private void a(String str) {
        Intent intent = new Intent();
        intent.putExtra("Result", str);
        intent.setAction("com.asnp.ad.ACTION_ACTIVITY_RESULT");
        LocalBroadcastManager.getInstance(StubApp.getOrigApplicationContext(getApplicationContext())).sendBroadcast(intent);
    }
}
