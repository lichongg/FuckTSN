package com.bxkj.student.run.app.face.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.baidu.idl.face.platform.ui.BaseFaceLivenessActivity;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity;
import com.bxkj.student.run.app.face.widget.a;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FaceDetect5ExpActivity extends BaseFaceLivenessActivity {
    private Context M;
    private com.bxkj.student.run.app.face.widget.a N;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            FaceDetect5ExpActivity.this.M();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            FaceDetect5ExpActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            new iOSOneButtonDialog(FaceDetect5ExpActivity.this.M).setMessage("上传失败，请重新再试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetect5ExpActivity.a.this.c(view);
                }
            }).show();
            super.netOnFailure(ex);
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            new iOSOneButtonDialog(FaceDetect5ExpActivity.this.M).setMessage("上传成功").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetect5ExpActivity.a.this.d(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            LoginUser.getLoginUser().getBitmapList().clear();
            super.netOnFinish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(FaceDetect5ExpActivity.this.M).setMessage(msg).show();
        }
    }

    static {
        StubApp.interface11(16611);
    }

    private Bitmap base64ToBitmap(String base64Data) {
        byte[] decode = Base64Utils.decode(base64Data, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public File j(Context context, Bitmap bmp) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (bmp != null && !bmp.isRecycled()) {
            j.c("bmp.getWidth()=" + bmp.getWidth() + "bmp.getHeight()" + bmp.getHeight());
            File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
            if (externalCacheDir == null || !externalCacheDir.exists()) {
                externalCacheDir = context.getCacheDir();
            }
            File file = new File(externalCacheDir, "avatar");
            boolean exists = file.exists();
            if (!exists) {
                exists = file.mkdirs();
            }
            if (exists) {
                File file2 = new File(file, "avatar" + System.currentTimeMillis() + ".jpg");
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (FileNotFoundException unused) {
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bmp.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    return file2;
                } catch (FileNotFoundException unused3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.idl.face.platform.ui.FaceLivenessActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);

    private void k(String title, String message, String base64ImageMap) {
        if (this.N == null) {
            a.C0265a c0265a = new a.C0265a(this);
            c0265a.h(title).d(message).f("本次需要采集1张，请采集第" + (LoginUser.getLoginUser().getBitmapList().size() + 1) + "张", new DialogInterface.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i6) {
                    dialogInterface.dismiss();
                }
            });
            com.bxkj.student.run.app.face.widget.a b6 = c0265a.b();
            this.N = b6;
            b6.setCancelable(true);
        }
        this.N.dismiss();
        this.N.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int size = LoginUser.getLoginUser().getBitmapList().size();
        String[] strArr = new String[size];
        for (int i6 = 0; i6 < LoginUser.getLoginUser().getBitmapList().size(); i6++) {
            strArr[i6] = com.bxkj.base.util.c.a(LoginUser.getLoginUser().getBitmapList().get(i6));
        }
        if (size <= 0) {
            startActivity(new Intent(this.M, (Class<?>) FaceDetect5ExpActivity.class));
            finish();
        } else {
            File j6 = j(this.M, base64ToBitmap(strArr[0]));
            Http.with(this.M).setObservable(((e0.a) Http.getApiService(e0.a.class)).F1(MultipartBody.Part.createFormData("userId", LoginUser.getLoginUser().getUserId()), MultipartBody.Part.createFormData(master.flame.danmaku.danmaku.parser.b.f50156c, j6.getName(), RequestBody.create(j6, MediaType.parse("image/png"))))).setDataListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        M();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.idl.face.platform.ui.BaseFaceLivenessActivity
    protected void onFace(String bmpStr) {
        super.onFace(bmpStr);
        LoginUser.getLoginUser().getBitmapList().add(base64ToBitmap(bmpStr));
        this.mImageLayout.removeAllViews();
        for (Bitmap bitmap : LoginUser.getLoginUser().getBitmapList()) {
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(bitmap);
            this.mImageLayout.addView(imageView, new LinearLayout.LayoutParams(300, 300));
        }
        if (LoginUser.getLoginUser().getBitmapList().size() < 1) {
            startActivity(new Intent(this.M, (Class<?>) FaceDetect5ExpActivity.class));
            finish();
        } else {
            new iOSOneButtonDialog(this.M).setMessage("采集成功,点击确定开始上传").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetect5ExpActivity.this.i(view);
                }
            }).show();
        }
    }
}
