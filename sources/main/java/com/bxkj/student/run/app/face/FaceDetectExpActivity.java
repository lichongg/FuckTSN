package com.bxkj.student.run.app.face;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.baidu.idl.face.platform.ui.BaseFaceDetectActivity;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.g0;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
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
public class FaceDetectExpActivity extends BaseFaceDetectActivity {
    public static final int P = 187;
    public static final int Q = 170;
    protected Context M;
    private String N = "";
    private boolean O = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements IInitCallback {
        a() {
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initFailure(int i6, String s5) {
            j.e("FaceSDKManager初始化失败i=" + i6 + "s=" + s5, new Object[0]);
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initSuccess() {
            j.c("FaceSDKManager初始化成功");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            FaceDetectExpActivity.this.N();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(View view) {
            FaceDetectExpActivity.this.N();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(View view) {
            FaceDetectExpActivity.this.N();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FaceDetectExpActivity.this.setResult(-1);
            FaceDetectExpActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccessServerError(int code, String errorMessage) {
            new iOSOneButtonDialog(FaceDetectExpActivity.this.M).setMessage(errorMessage).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExpActivity.b.this.f(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(FaceDetectExpActivity.this.M).setMessage("人脸识别失败，请重新再试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExpActivity.b.this.d(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(FaceDetectExpActivity.this.M).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExpActivity.b.this.e(view);
                }
            }).show();
        }
    }

    static {
        StubApp.interface11(16605);
    }

    public File O(Context context, Bitmap bmp) {
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
                File file2 = new File(file, "avatar" + System.currentTimeMillis() + g0.f16898c);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (FileNotFoundException unused) {
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
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

    protected Bitmap base64ToBitmap(String base64Data) {
        byte[] decode = Base64Utils.decode(base64Data, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    @Override // com.baidu.idl.face.platform.ui.FaceDetectActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);

    protected void N() {
        setResult(170, getIntent());
        finish();
    }

    protected void e(String base64ImageMap) {
        File O = O(this.M, base64ToBitmap(base64ImageMap));
        HttpRequest hideOtherStatusMessage = Http.with(this.M).hideOtherStatusMessage();
        if (!this.O) {
            hideOtherStatusMessage.hideSuccessMessage();
        }
        hideOtherStatusMessage.setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).h(MultipartBody.Part.createFormData("userId", LoginUser.getLoginUser().getUserId()), MultipartBody.Part.createFormData("identify", this.N), MultipartBody.Part.createFormData(master.flame.danmaku.danmaku.parser.b.f50156c, O.getName(), RequestBody.create(O, MediaType.parse("application/octet-stream"))))).setDataListener(new b());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        P(this, -1.0f);
        super.onDestroy();
    }

    private void M() {
        if (!FaceSDKManager.getInstance().getInitFlag()) {
            FaceSDKManager.getInstance().initialize(this, com.bxkj.student.run.app.face.a.f19804a, com.bxkj.student.run.app.face.a.f19805b, new a());
        }
    }

    private void P(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = brightness;
        window.setAttributes(attributes);
    }

    @Override // com.baidu.idl.face.platform.ui.BaseFaceDetectActivity
    protected void onFace(String bmpStr) {
        super.onFace(bmpStr);
        e(bmpStr);
    }
}
