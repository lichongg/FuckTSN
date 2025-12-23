package com.bxkj.student.run.app.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.student.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private Activity f20350a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f20351b;

    /* renamed from: c, reason: collision with root package name */
    private iOSOneButtonDialog f20352c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements UMShareListener {
        a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(w.this.f20350a, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(w.this.f20350a, " 分享成功啦", 0).show();
            w.this.f20352c.dismiss();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t5) {
            t5.printStackTrace();
            Toast.makeText(w.this.f20350a, " 分享失败啦," + t5.getMessage(), 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        l(SHARE_MEDIA.WEIXIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        l(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        l(SHARE_MEDIA.QQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        l(SHARE_MEDIA.QZONE);
    }

    private void l(SHARE_MEDIA platform) {
        new ShareAction(this.f20350a).setPlatform(platform).setCallback(new a()).withMedia(new UMImage(this.f20350a, this.f20351b)).share();
        this.f20352c.dismiss();
    }

    public void k(Bitmap bitmap) {
        this.f20351b = bitmap;
        iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f20350a);
        this.f20352c = iosonebuttondialog;
        iosonebuttondialog.setTitle("分享到");
        this.f20352c.setTitleLineVisiBility(0);
        this.f20352c.setCenterCustomView(R.layout.dialog_share);
        this.f20352c.setMessageGrivity(17);
        this.f20352c.setOneButtonText("关闭");
        this.f20352c.show();
        LinearLayout linearLayout = (LinearLayout) this.f20352c.findViewById(2131298085);
        LinearLayout linearLayout2 = (LinearLayout) this.f20352c.findViewById(2131298053);
        LinearLayout linearLayout3 = (LinearLayout) this.f20352c.findViewById(2131298063);
        LinearLayout linearLayout4 = (LinearLayout) this.f20352c.findViewById(2131298066);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.this.g(view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.this.h(view);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.this.i(view);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.this.j(view);
            }
        });
    }

    public w(Activity mContext) {
        this.f20350a = mContext;
    }
}
