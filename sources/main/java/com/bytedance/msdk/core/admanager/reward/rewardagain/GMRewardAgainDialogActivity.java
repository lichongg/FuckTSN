package com.bytedance.msdk.core.admanager.reward.rewardagain;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes3.dex */
public class GMRewardAgainDialogActivity extends Activity {

    /* renamed from: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GMRewardAgainDialogActivity.this.finish();
            Runnable runnable = cw.cw().xt;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GMRewardAgainDialogActivity.this.finish();
            Runnable runnable = cw.cw().cw;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    static {
        StubApp.interface11(19663);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 == 4) {
            return true;
        }
        return super.onKeyDown(i6, keyEvent);
    }
}
