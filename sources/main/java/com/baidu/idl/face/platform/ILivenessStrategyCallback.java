package com.baidu.idl.face.platform;

import com.baidu.idl.face.platform.model.ImageInfo;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface ILivenessStrategyCallback {
    public static final String IMAGE_KEY_BEST_CROP_IMAGE = "bestCropImage_";
    public static final String IMAGE_KEY_BEST_SRC_IMAGE = "bestSrcImage_";

    void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i6);
}
