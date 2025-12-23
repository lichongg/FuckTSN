package com.baidu.idl.main.facesdk;

import android.content.Context;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.model.Feature;
import com.baidu.idl.main.facesdk.utils.FileUitls;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceFeature {
    private static final String TAG = "FaceFeature";
    private BDFaceInstance bdFaceInstance;

    public FaceFeature(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native float nativeFeature(long j6, int i6, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr);

    private native float nativeFeatureCompare(long j6, int i6, byte[] bArr, byte[] bArr2, int i7);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFeatureModelInit(long j6, byte[] bArr, int i6);

    private native ArrayList<Feature> nativeFeatureSearch(long j6, byte[] bArr, int i6, int i7, int i8);

    private native float nativeRGBDFeature(long j6, int i6, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr);

    private native int nativeUninitModel(long j6);

    private native int nativefeaturePush(List<? extends Feature> list);

    public int featurePush(List<? extends Feature> list) {
        return -1;
    }

    public ArrayList<Feature> featureSearch(byte[] bArr, BDFaceSDKCommon.FeatureType featureType, int i6, boolean z5) {
        return null;
    }

    public void initModel(final Context context, final String str, final String str2, String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceFeature.1
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceFeature.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i7 = -1;
                if (modelContent.length != 0) {
                    i6 = FaceFeature.this.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                    if (i6 != 0) {
                        callback.onResponse(i6, "证件照识别模型加载失败");
                        return;
                    }
                } else {
                    i6 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0 && (i7 = FaceFeature.this.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal())) != 0) {
                    callback.onResponse(i7, "Vis 识别模型加载失败");
                    return;
                }
                if (i6 == 0 || i7 == 0) {
                    callback.onResponse(0, "识别模型加载成功");
                } else {
                    callback.onResponse(1, "识别模型加载失败");
                }
                String unused = FaceFeature.TAG;
            }
        });
    }

    public float feature(BDFaceSDKCommon.FeatureType featureType, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr) {
        if (featureType == null || fArr == null || bArr == null || bDFaceImageInstance == null || fArr.length < 0) {
            return -1.0f;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1.0f;
        }
        return nativeFeature(index, featureType.ordinal(), bDFaceImageInstance, fArr, bArr);
    }

    public float featureCompare(BDFaceSDKCommon.FeatureType featureType, byte[] bArr, byte[] bArr2, boolean z5) {
        if (featureType == null || bArr == null || bArr2 == null) {
            return -1.0f;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1.0f;
        }
        return nativeFeatureCompare(index, featureType.ordinal(), bArr, bArr2, z5 ? 1 : 0);
    }

    public float featureRGBD(BDFaceSDKCommon.FeatureType featureType, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr) {
        if (featureType == null || fArr == null || bArr == null || bDFaceImageInstance == null || bDFaceImageInstance2 == null || fArr.length < 0) {
            return -1.0f;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1.0f;
        }
        return nativeRGBDFeature(index, featureType.ordinal(), bDFaceImageInstance, bDFaceImageInstance2, fArr, bArr);
    }

    public int uninitModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitModel(index);
    }

    public FaceFeature() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }

    public void initModel(final Context context, final String str, final String str2, final String str3, final String str4, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceFeature.2
            @Override // java.lang.Runnable
            public void run() {
                if (str.length() == 0 && str2.length() == 0 && str3.length() == 0 && str4.length() == 0) {
                    String unused = FaceFeature.TAG;
                    callback.onResponse(1, "FaceFeature未设置模型路径");
                    return;
                }
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceFeature.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                if (str.length() != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context, str);
                    if (modelContent.length == 0) {
                        String unused2 = FaceFeature.TAG;
                        callback.onResponse(-1, "证件照识别模型读取失败");
                        return;
                    } else {
                        int nativeFeatureModelInit = FaceFeature.this.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                        if (nativeFeatureModelInit != 0) {
                            String unused3 = FaceFeature.TAG;
                            callback.onResponse(nativeFeatureModelInit, "证件照识别模型加载失败");
                            return;
                        }
                    }
                }
                if (str2.length() != 0) {
                    byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                    if (modelContent2.length == 0) {
                        String unused4 = FaceFeature.TAG;
                        callback.onResponse(-1, "生活照识别模型读取失败");
                        return;
                    } else {
                        int nativeFeatureModelInit2 = FaceFeature.this.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal());
                        if (nativeFeatureModelInit2 != 0) {
                            String unused5 = FaceFeature.TAG;
                            callback.onResponse(nativeFeatureModelInit2, "生活照识别模型加载失败");
                            return;
                        }
                    }
                }
                if (str3.length() != 0) {
                    byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                    if (modelContent3.length == 0) {
                        String unused6 = FaceFeature.TAG;
                        callback.onResponse(-1, "Nir识别模型读取失败");
                        return;
                    } else {
                        int nativeFeatureModelInit3 = FaceFeature.this.nativeFeatureModelInit(index, modelContent3, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_NIR.ordinal());
                        if (nativeFeatureModelInit3 != 0) {
                            String unused7 = FaceFeature.TAG;
                            callback.onResponse(nativeFeatureModelInit3, "Nir识别模型加载失败");
                            return;
                        }
                    }
                }
                if (str4.length() != 0) {
                    byte[] modelContent4 = FileUitls.getModelContent(context, str4);
                    if (modelContent4.length == 0) {
                        String unused8 = FaceFeature.TAG;
                        callback.onResponse(-1, "rgbd识别模型读取失败");
                        return;
                    } else {
                        int nativeFeatureModelInit4 = FaceFeature.this.nativeFeatureModelInit(index, modelContent4, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_RGBD.ordinal());
                        if (nativeFeatureModelInit4 != 0) {
                            String unused9 = FaceFeature.TAG;
                            callback.onResponse(nativeFeatureModelInit4, "rgbd识别模型加载失败");
                            return;
                        }
                    }
                }
                String unused10 = FaceFeature.TAG;
                callback.onResponse(0, "识别模型加载成功");
            }
        });
    }
}
