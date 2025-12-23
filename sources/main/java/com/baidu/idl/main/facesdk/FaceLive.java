package com.baidu.idl.main.facesdk;

import android.content.Context;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.utils.FileUitls;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceLive {
    private static final String TAG = "FaceLive";
    private BDFaceInstance bdFaceInstance;

    public FaceLive(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native float nativeSilentLive(long j6, int i6, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSilentLiveModelInit(long j6, byte[] bArr, int i6);

    private native int nativeUninitModel(long j6);

    public void initModel(final Context context, final String str, final String str2, final String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceLive.1
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                int i7;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceLive.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i8 = -1;
                if (modelContent.length != 0) {
                    i6 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_RGB.ordinal());
                    if (i6 != 0) {
                        callback.onResponse(i6, "Vis 活体模型加载失败");
                        return;
                    }
                } else {
                    i6 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0) {
                    i7 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent2, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_NIR.ordinal());
                    if (i7 != 0) {
                        callback.onResponse(i7, "Nir 活体模型加载失败");
                        return;
                    }
                } else {
                    i7 = -1;
                }
                byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                if (modelContent3.length != 0 && (i8 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent3, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_DEPTH.ordinal())) != 0) {
                    callback.onResponse(i8, "Deep 活体模型加载失败");
                } else if (i6 == 0 || i7 == 0 || i8 == 0) {
                    callback.onResponse(0, "活体模型加载成功");
                } else {
                    callback.onResponse(1, "活体模型加载失败");
                }
            }
        });
    }

    public float silentLive(BDFaceSDKCommon.LiveType liveType, BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (liveType == null || bDFaceImageInstance == null || fArr == null) {
            return -1.0f;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1.0f;
        }
        return nativeSilentLive(index, liveType.ordinal(), bDFaceImageInstance, fArr);
    }

    public int uninitModel() {
        if (this.bdFaceInstance.getIndex() == 0) {
            return -1;
        }
        return nativeUninitModel(this.bdFaceInstance.getIndex());
    }

    public FaceLive() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
