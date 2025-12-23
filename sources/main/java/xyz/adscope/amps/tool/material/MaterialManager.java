package xyz.adscope.amps.tool.material;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.bxkj.base.v2.common.utils.g0;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.model.config.response.LogStrategyModel;
import xyz.adscope.amps.model.config.response.MaterialManagerModel;
import xyz.adscope.amps.model.config.response.SimilarStrategyModel;
import xyz.adscope.amps.model.material.AMPSUploadMaterial;
import xyz.adscope.amps.tool.hook.AMPSHookActivity;
import xyz.adscope.amps.tool.material.inner.OnBitmapCapturedListener;
import xyz.adscope.amps.tool.thread.AMPSThreadPool;
import xyz.adscope.amps.tool.util.AMPSFileUtils;
import xyz.adscope.amps.tool.util.AMPSStringUtil;
import xyz.adscope.amps.tool.util.AMPSViewToBitmapUtil;
import xyz.adscope.common.v2.conn.IBaseEncryptRequest;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;
import xyz.adscope.common.v2.encrypt.impl.Base64Util;
import xyz.adscope.common.v2.tool.io.FileVerify;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class MaterialManager {
    private View currentView;
    private AMPSUploadMaterial mAMPSUploadMaterial;
    private Context viewContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class ImageFileFilter implements FileFilter {
        private final String[] validExtensions;

        private ImageFileFilter() {
            this.validExtensions = new String[]{".jpg", ".jpeg", g0.f16898c, ".webp", ".gif", ".bmp"};
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file != null && file.isFile()) {
                String lowerCase = file.getName().toLowerCase();
                for (String str : this.validExtensions) {
                    if (lowerCase.endsWith(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
    
        r1 = r7.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        r6.recycle();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [xyz.adscope.amps.tool.material.MaterialManager$1] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String findLikeImg(java.lang.String r12, android.graphics.Bitmap r13, float r14, long r15) {
        /*
            r11 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r12)
            boolean r12 = r0.exists()
            java.lang.String r1 = ""
            if (r12 == 0) goto L90
            boolean r12 = r0.isDirectory()
            if (r12 != 0) goto L15
            goto L90
        L15:
            xyz.adscope.amps.tool.material.MaterialManager$ImageFileFilter r12 = new xyz.adscope.amps.tool.material.MaterialManager$ImageFileFilter
            r2 = 0
            r12.<init>()
            java.io.File[] r12 = r0.listFiles(r12)
            if (r12 == 0) goto L90
            int r0 = r12.length
            if (r0 != 0) goto L26
            goto L90
        L26:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            int r0 = r12.length     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            r5 = 0
            r6 = r2
        L2d:
            if (r5 >= r0) goto L7a
            r7 = r12[r5]     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            long r8 = r7.lastModified()     // Catch: java.lang.Throwable -> L4d
            long r8 = r3 - r8
            int r10 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r10 <= 0) goto L50
            r7.delete()     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L69
        L40:
            r6.recycle()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            r6 = r2
            goto L69
        L45:
            r0 = move-exception
            r12 = r0
            r2 = r6
            goto L8a
        L49:
            r0 = move-exception
            r12 = r0
            r2 = r6
            goto L81
        L4d:
            r0 = move-exception
            r12 = r0
            goto L6c
        L50:
            android.graphics.Bitmap r6 = xyz.adscope.amps.tool.util.APMSImageUtils.decodeSampledBitmap(r7)     // Catch: java.lang.Throwable -> L4d
            if (r6 != 0) goto L59
            if (r6 == 0) goto L69
            goto L40
        L59:
            float r8 = xyz.adscope.amps.tool.util.APMSImageUtils.calculateSimilarityFast(r13, r6)     // Catch: java.lang.Throwable -> L4d
            int r8 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r8 < 0) goto L40
            java.lang.String r1 = r7.getName()     // Catch: java.lang.Throwable -> L4d
            r6.recycle()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            goto L7b
        L69:
            int r5 = r5 + 1
            goto L2d
        L6c:
            if (r6 == 0) goto L72
            r6.recycle()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            goto L73
        L72:
            r2 = r6
        L73:
            throw r12     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
        L74:
            r0 = move-exception
            r12 = r0
            goto L8a
        L77:
            r0 = move-exception
            r12 = r0
            goto L81
        L7a:
            r2 = r6
        L7b:
            if (r2 == 0) goto L80
            r2.recycle()
        L80:
            return r1
        L81:
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L89
            r2.recycle()
        L89:
            return r1
        L8a:
            if (r2 == 0) goto L8f
            r2.recycle()
        L8f:
            throw r12
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.tool.material.MaterialManager.findLikeImg(java.lang.String, android.graphics.Bitmap, float, long):java.lang.String");
    }

    public MaterialManager(Context context, View view, AMPSUploadMaterial aMPSUploadMaterial) {
        this.viewContext = context;
        this.currentView = view;
        this.mAMPSUploadMaterial = aMPSUploadMaterial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadImgFile(String str, File file, String str2, AMPSUploadMaterial aMPSUploadMaterial) {
        aMPSUploadMaterial.setEventId(AMPSStringUtil.createRequestId());
        aMPSUploadMaterial.setEventTime(String.valueOf(System.currentTimeMillis()));
        aMPSUploadMaterial.setMaterialMD5(str2);
        if (file != null && file.exists()) {
            aMPSUploadMaterial.setMaterialData(Base64Util.encodeToString(AMPSFileUtils.fileToByteArray(file)));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aMPSUploadMaterial);
        uploadService(str, arrayList);
    }

    private void uploadService(String str, List<AMPSUploadMaterial> list) {
        JSONArray emptyJSONArray = JsonUtil.emptyJSONArray();
        Iterator<AMPSUploadMaterial> it = list.iterator();
        while (it.hasNext()) {
            emptyJSONArray.put(JsonUtil.entry2JsonObject(it.next(), true));
        }
        String jSONArray = emptyJSONArray.toString();
        Context context = AMPSSDK.getContext();
        IBaseEncryptRequest iBaseEncryptRequest = new IBaseEncryptRequest(context, true);
        LogStrategyModel logStrategy = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel().getConfigureResponseModel().getLogStrategy();
        if (logStrategy != null) {
            String acceptEncrypt = logStrategy.getAcceptEncrypt();
            iBaseEncryptRequest.setEncryptPatten(acceptEncrypt);
            iBaseEncryptRequest.requestWithStreamMethod(str, LinkedEncryptManager.getInstance().getOrCreateImplement(context).encrypt(jSONArray.getBytes(), acceptEncrypt, ILinkedEncrypt.B64Model.NOT_APPEND, false), new IBaseHttpResponseCallback() { // from class: xyz.adscope.amps.tool.material.MaterialManager.2
                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void failCallback(IHttpRequestError iHttpRequestError) {
                }

                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void successCallback(IBaseHttpResponse iBaseHttpResponse) {
                }
            });
        }
    }

    public void saveMaterial() {
        Activity topActivity;
        final MaterialManagerModel materialManager = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel().getConfigureResponseModel().getMaterialManager();
        if (this.currentView == null && (topActivity = AMPSHookActivity.getTopActivity()) != null) {
            this.currentView = topActivity.getWindow().getDecorView().findViewById(R.id.content);
            this.viewContext = topActivity;
        }
        if (this.currentView == null) {
            return;
        }
        AMPSThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.amps.tool.material.MaterialManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(300L);
                    AMPSViewToBitmapUtil.getBitmapFromView(MaterialManager.this.viewContext, MaterialManager.this.currentView, new OnBitmapCapturedListener() { // from class: xyz.adscope.amps.tool.material.MaterialManager.1.1
                        @Override // xyz.adscope.amps.tool.material.inner.OnBitmapCapturedListener
                        public void onBitmapCaptured(Bitmap bitmap) {
                            Bitmap bitmap2;
                            String[] split;
                            File file = new File(MaterialManager.this.viewContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "adHub/" + MaterialManager.this.mAMPSUploadMaterial.getSeatSpaceId());
                            SimilarStrategyModel similarStrategy = materialManager.getSimilarStrategy();
                            int isOpen = similarStrategy.getIsOpen();
                            long longValue = Long.valueOf(similarStrategy.getCacheTime()).longValue();
                            int similarity = similarStrategy.getSimilarity();
                            String str = "";
                            synchronized (MaterialManager.class) {
                                try {
                                    if (isOpen == 1) {
                                        bitmap2 = bitmap;
                                        str = MaterialManager.this.findLikeImg(file.getPath(), bitmap2, similarity / 100.0f, longValue);
                                    } else {
                                        bitmap2 = bitmap;
                                        AMPSFileUtils.deleteDirectory(file);
                                    }
                                } finally {
                                }
                            }
                            String url = materialManager.getUrl();
                            if (!TextUtils.isEmpty(str)) {
                                if (similarStrategy.getIsReport() != 1 || (split = str.split("_")) == null || split.length <= 0) {
                                    return;
                                }
                                String str2 = split[0];
                                MaterialManager materialManager2 = MaterialManager.this;
                                materialManager2.uploadImgFile(url, null, str2, materialManager2.mAMPSUploadMaterial);
                                return;
                            }
                            int intValue = Integer.valueOf(materialManager.getMaxSize()).intValue();
                            String str3 = System.currentTimeMillis() + ".jpeg";
                            synchronized (MaterialManager.class) {
                                try {
                                    File saveBitmapToFile = AMPSViewToBitmapUtil.saveBitmapToFile(bitmap2, Bitmap.CompressFormat.JPEG, intValue, str3, file);
                                    if (saveBitmapToFile != null && saveBitmapToFile.exists()) {
                                        String fileMD5 = FileVerify.getFileMD5(saveBitmapToFile);
                                        File renameFile = AMPSFileUtils.renameFile(saveBitmapToFile, fileMD5 + "_" + str3);
                                        MaterialManager materialManager3 = MaterialManager.this;
                                        materialManager3.uploadImgFile(url, renameFile, fileMD5, materialManager3.mAMPSUploadMaterial);
                                    }
                                } finally {
                                }
                            }
                        }
                    });
                } catch (InterruptedException e6) {
                    throw new RuntimeException(e6);
                }
            }
        });
    }
}
