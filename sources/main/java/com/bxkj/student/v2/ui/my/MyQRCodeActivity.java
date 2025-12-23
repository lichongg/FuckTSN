package com.bxkj.student.v2.ui.my;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V2MyQrcodeBinding;
import kotlin.jvm.internal.SourceDebugExtension;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMyQRCodeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyQRCodeActivity.kt\ncom/bxkj/student/v2/ui/my/MyQRCodeActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class MyQRCodeActivity extends BaseActivity<V2MyQrcodeBinding, BaseViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MyQRCodeActivity myQRCodeActivity, View view) {
        myQRCodeActivity.startActivity(new Intent(myQRCodeActivity.H(), (Class<?>) FullScreenCodeActivity.class).putExtra("type", 1));
        myQRCodeActivity.overridePendingTransition(R.anim.qr_code_zoom_in, R.anim.qr_code_zoom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MyQRCodeActivity myQRCodeActivity, View view) {
        myQRCodeActivity.startActivity(new Intent(myQRCodeActivity.H(), (Class<?>) FullScreenCodeActivity.class).putExtra("type", 2));
        myQRCodeActivity.overridePendingTransition(R.anim.bar_code_zoom_in, R.anim.qr_code_zoom_out);
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        i(this, -1.0f);
        super.onDestroy();
    }

    private final void i(Activity activity, float f6) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f6;
        window.setAttributes(attributes);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        L().ivCode.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyQRCodeActivity.g(MyQRCodeActivity.this, view);
            }
        });
        L().ivBar.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyQRCodeActivity.h(MyQRCodeActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        MyQRCodeActivity myQRCodeActivity;
        if (getIntent().hasExtra("title")) {
            myQRCodeActivity = this;
        } else {
            myQRCodeActivity = null;
        }
        if (myQRCodeActivity != null) {
            L().setTitle(getIntent().getStringExtra("title"));
        }
        L().setBackEvent(this);
        i(this, 1.0f);
        TextView textView = L().tvName;
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        textView.setText(aVar.a().S());
        L().ivCode.setImageBitmap(new com.bxkj.base.v2.common.qrcode.b(r()).d(aVar.a().S(), 2131689689));
        L().ivBar.setImageBitmap(new com.bxkj.base.v2.common.qrcode.b(r()).b(aVar.a().S()));
    }
}
