package com.bxkj.student.v2.ui.my;

import android.view.View;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.databinding.V2DialogQrCodeBinding;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FullScreenCodeActivity extends BaseActivity<V2DialogQrCodeBinding, BaseViewModel> {
    private int U = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FullScreenCodeActivity fullScreenCodeActivity, View view) {
        fullScreenCodeActivity.finish();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        L().root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullScreenCodeActivity.f(FullScreenCodeActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        if (getIntent().hasExtra("type")) {
            this.U = getIntent().getIntExtra("type", 1);
        }
        if (this.U == 1) {
            L().iv.setImageBitmap(new com.bxkj.base.v2.common.qrcode.b(r()).f(com.bxkj.base.v2.data.b.f16998d.a().S(), 2131689689));
        } else {
            L().iv.setImageBitmap(new com.bxkj.base.v2.common.qrcode.b(r()).c(com.bxkj.base.v2.data.b.f16998d.a().S()));
        }
    }
}
