package com.baidu.idl.main.facesdk;

import android.content.Context;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceDetectListConf;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.model.BDFaceSDKConfig;
import com.baidu.idl.main.facesdk.utils.FileUitls;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceDetect {
    private static final String TAG = "FaceDetect";
    private BDFaceInstance bdFaceInstance;
    private ReentrantLock lock;

    public FaceDetect(BDFaceInstance bDFaceInstance) {
        this.lock = null;
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
        this.lock = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAlignModelInit(long j6, int i6, int i7, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAttributeModelInit(long j6, byte[] bArr);

    private native BDFaceImageInstance nativeCropFace(long j6, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    private native FaceInfo[] nativeDetect(long j6, int i6, int i7, BDFaceImageInstance bDFaceImageInstance);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeDetectModelInit(long j6, byte[] bArr, int i6);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeEmotionsModelInit(long j6, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFaceCloseModelInit(long j6, byte[] bArr, int i6);

    private native FaceInfo[] nativeFastTrack(long j6, int i6, int i7, BDFaceImageInstance bDFaceImageInstance);

    private native FaceInfo[] nativeFlexibleDetect(long j6, int i6, int i7, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf);

    private native void nativeLoadConfig(long j6, BDFaceSDKConfig bDFaceSDKConfig);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeLoadTrack(long j6, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeQualityModelInit(long j6, byte[] bArr, int i6);

    private native FaceInfo[] nativeTrack(long j6, int i6, BDFaceImageInstance bDFaceImageInstance);

    private native int nativeUninitModel(long j6);

    public BDFaceImageInstance cropFace(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (bDFaceImageInstance == null || fArr == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFace(index, bDFaceImageInstance, fArr);
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType == null || bDFaceImageInstance == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0 || !this.lock.tryLock()) {
            return null;
        }
        FaceInfo[] nativeDetect = nativeDetect(index, detectType.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), bDFaceImageInstance);
        this.lock.unlock();
        return nativeDetect;
    }

    public void initModel(final Context context, final String str, final String str2, final String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.1
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                int i7;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i8 = -1;
                if (modelContent.length != 0) {
                    i6 = FaceDetect.this.nativeDetectModelInit(index, modelContent, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal());
                    if (i6 != 0) {
                        callback.onResponse(i6, "Vis检测模型加载失败");
                        return;
                    }
                } else {
                    i6 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0) {
                    int nativeDetectModelInit = FaceDetect.this.nativeDetectModelInit(index, modelContent2, BDFaceSDKCommon.DetectType.DETECT_NIR.ordinal());
                    if (nativeDetectModelInit != 0) {
                        callback.onResponse(nativeDetectModelInit, "Nir检测模型加载失败");
                        return;
                    }
                    i7 = nativeDetectModelInit;
                } else {
                    i7 = -1;
                }
                byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                if (modelContent3.length != 0 && (i8 = FaceDetect.this.nativeAlignModelInit(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), modelContent3)) != 0) {
                    callback.onResponse(i8, "对齐模型加载失败");
                    return;
                }
                int nativeLoadTrack = FaceDetect.this.nativeLoadTrack(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal());
                if (nativeLoadTrack != 0) {
                    callback.onResponse(nativeLoadTrack, "跟踪能力加载失败");
                    return;
                }
                if ((i6 == 0 || i7 == 0) && i8 == 0) {
                    callback.onResponse(0, "检测对齐模型加载成功");
                } else {
                    callback.onResponse(1, "检测对齐模型加载失败");
                }
                String unused = FaceDetect.TAG;
            }
        });
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType == null || bDFaceImageInstance == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0 || !this.lock.tryLock()) {
            return null;
        }
        FaceInfo[] nativeTrack = nativeTrack(index, detectType.ordinal(), bDFaceImageInstance);
        this.lock.unlock();
        return nativeTrack;
    }

    public void initAttrEmo(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.4
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i7 = -1;
                if (modelContent.length != 0) {
                    i6 = FaceDetect.this.nativeAttributeModelInit(index, modelContent);
                    if (i6 != 0) {
                        callback.onResponse(i6, "属性模型加载失败");
                        return;
                    }
                } else {
                    i6 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i7 = FaceDetect.this.nativeEmotionsModelInit(index, modelContent2)) != 0) {
                    callback.onResponse(i7, "情绪模型加载失败");
                } else if (i6 == 0 || i7 == 0) {
                    callback.onResponse(0, "属性模型加载成功");
                } else {
                    callback.onResponse(1, "属性模型加载失败");
                }
            }
        });
    }

    public void initFaceClose(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.5
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i7 = -1;
                if (modelContent.length != 0) {
                    i6 = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent, 0);
                    if (i6 != 0) {
                        callback.onResponse(i6, "眼睛闭合模型加载失败");
                        return;
                    }
                } else {
                    i6 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i7 = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent2, 1)) != 0) {
                    callback.onResponse(i7, "嘴巴闭合模型加载失败");
                } else if (i6 == 0 || i7 == 0) {
                    callback.onResponse(0, "闭眼闭嘴模型加载成功");
                } else {
                    callback.onResponse(1, "闭眼闭嘴模型加载失败");
                }
            }
        });
    }

    public void initQuality(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.3
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i7 = -1;
                if (modelContent.length != 0) {
                    i6 = FaceDetect.this.nativeQualityModelInit(index, modelContent, BDFaceSDKCommon.FaceQualityType.BLUR.ordinal());
                    if (i6 != 0) {
                        callback.onResponse(i6, "模糊模型加载失败");
                        return;
                    }
                } else {
                    i6 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i7 = FaceDetect.this.nativeQualityModelInit(index, modelContent2, BDFaceSDKCommon.FaceQualityType.OCCLUSION.ordinal())) != 0) {
                    callback.onResponse(i7, "遮挡模型加载失败");
                    return;
                }
                if (i6 == 0 || i7 == 0) {
                    callback.onResponse(0, "质量模型加载成功");
                } else {
                    callback.onResponse(1, "质量模型加载失败");
                }
                String unused = FaceDetect.TAG;
            }
        });
    }

    public void loadConfig(BDFaceSDKConfig bDFaceSDKConfig) {
        BDFaceInstance bDFaceInstance = this.bdFaceInstance;
        if (bDFaceInstance == null) {
            return;
        }
        long index = bDFaceInstance.getIndex();
        if (index == 0) {
            return;
        }
        nativeLoadConfig(index, bDFaceSDKConfig);
    }

    public int uninitModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitModel(index);
    }

    public void initModel(final Context context, final String str, final String str2, final BDFaceSDKCommon.DetectType detectType, final BDFaceSDKCommon.AlignType alignType, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDetect.2
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i7 = -1;
                if (modelContent.length != 0) {
                    i6 = FaceDetect.this.nativeDetectModelInit(index, modelContent, detectType.ordinal());
                    if (i6 != 0) {
                        callback.onResponse(i6, "检测模型加载失败");
                        return;
                    }
                } else {
                    i6 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i7 = FaceDetect.this.nativeAlignModelInit(index, detectType.ordinal(), alignType.ordinal(), modelContent2)) != 0) {
                    callback.onResponse(i7, "对齐模型加载失败");
                    return;
                }
                int nativeLoadTrack = FaceDetect.this.nativeLoadTrack(index, detectType.ordinal(), alignType.ordinal());
                if (nativeLoadTrack != 0) {
                    callback.onResponse(nativeLoadTrack, "跟踪能力加载失败");
                    return;
                }
                if (i6 == 0 && i7 == 0) {
                    callback.onResponse(0, "检测对齐模型加载成功");
                } else {
                    callback.onResponse(1, "检测对齐模型加载失败");
                }
                String unused = FaceDetect.TAG;
            }
        });
    }

    public FaceDetect() {
        this.lock = null;
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
        this.lock = new ReentrantLock();
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType == null || bDFaceImageInstance == null || alignType == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeFastTrack(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance);
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf) {
        if (detectType == null || bDFaceImageInstance == null || alignType == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0 || !this.lock.tryLock()) {
            return null;
        }
        FaceInfo[] nativeFlexibleDetect = nativeFlexibleDetect(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance, faceInfoArr, bDFaceDetectListConf);
        this.lock.unlock();
        return nativeFlexibleDetect;
    }
}
