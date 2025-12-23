package com.bytedance.sdk.openadsdk.mediation.bridge;

import a1.b;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.j.j;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationAdClassLoader extends j implements Bridge {

    /* renamed from: j, reason: collision with root package name */
    private static volatile MediationAdClassLoader f31674j;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Boolean j(java.lang.String r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L6
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L6
            return r1
        L6:
            r2 = move-exception
            com.bytedance.sdk.openadsdk.api.m.j(r2)
            java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L10 java.lang.NoClassDefFoundError -> L12 java.lang.ClassNotFoundException -> L14
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L10 java.lang.NoClassDefFoundError -> L12 java.lang.ClassNotFoundException -> L14
            return r1
        L10:
            r1 = move-exception
            goto L16
        L12:
            r2 = move-exception
            goto L1a
        L14:
            r2 = move-exception
            goto L1a
        L16:
            com.bytedance.sdk.openadsdk.api.m.j(r1)
            goto L2a
        L1a:
            com.bytedance.sdk.openadsdk.api.m.j(r2)
            boolean r1 = r0.j(r1)
            if (r1 == 0) goto L2a
            java.lang.String r1 = "TTMediationSDK"
            java.lang.String r2 = "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确"
            com.bytedance.sdk.openadsdk.api.m.up(r1, r2)
        L2a:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader.j(java.lang.String, java.lang.String):java.lang.Boolean");
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public static MediationAdClassLoader getInstance() {
        if (f31674j == null) {
            synchronized (MediationAdClassLoader.class) {
                f31674j = new MediationAdClassLoader();
            }
        }
        return f31674j;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public <T> T applyFunction(int i6, ValueSet valueSet, Class<T> cls) {
        if (i6 == 8106) {
            j(MediationLoaderConfig.create(valueSet), valueSet);
        } else if (i6 == 8229) {
            return (T) j(valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, null), valueSet.stringValue(8560, null));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i6, ValueSet valueSet, Class<T> cls) {
        if (i6 == 8106) {
            j(MediationLoaderConfig.create(valueSet), valueSet);
            return null;
        }
        if (i6 == 8229) {
            return (T) j(valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow), valueSet.stringValue(8560));
        }
        return null;
    }

    private MediationAdClassLoader() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public SparseArray<Object> get() {
        ValueSet values = values();
        if (values != null) {
            return values.sparseArray();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig r5, com.bykv.vk.openvk.api.proto.ValueSet r6) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r5.getADNName()     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            java.util.function.Function r1 = com.bytedance.sdk.openadsdk.mediation.bridge.init.AdnManagerConfig.getAdapterManager(r1)     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            if (r1 == 0) goto L36
            android.util.SparseArray r2 = new android.util.SparseArray     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            r2.<init>()     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            int r5 = r5.getManagerLoaderType()     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            r3 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            r2.put(r3, r5)     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            r3 = -99999985(0xfffffffffa0a1f0f, float:-1.7929173E35)
            r2.put(r3, r5)     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            java.lang.Object r5 = com.bytedance.msdk.core.ae.a.a(r1, r2)     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            r4.j(r5, r6)     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            return
        L2e:
            r5 = move-exception
            goto L46
        L30:
            r5 = move-exception
            goto L46
        L32:
            r5 = move-exception
            goto L57
        L34:
            r5 = move-exception
            goto L57
        L36:
            java.lang.String r0 = r5.getClassName()     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            java.lang.Class r5 = java.lang.Class.forName(r0)     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            java.lang.Object r5 = r5.newInstance()     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            r4.j(r5, r6)     // Catch: java.lang.NoClassDefFoundError -> L2e java.lang.ClassNotFoundException -> L30 java.lang.InstantiationException -> L32 java.lang.IllegalAccessException -> L34
            return
        L46:
            com.bytedance.sdk.openadsdk.api.m.j(r5)
            boolean r5 = r4.j(r0)
            if (r5 == 0) goto L56
            java.lang.String r5 = "TTMediationSDK"
            java.lang.String r6 = "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确"
            com.bytedance.sdk.openadsdk.api.m.up(r5, r6)
        L56:
            return
        L57:
            r5.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader.j(com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig, com.bykv.vk.openvk.api.proto.ValueSet):void");
    }

    private void j(Object obj, ValueSet valueSet) {
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        if (f.a(obj)) {
            Function a6 = b.a(obj);
            SparseArray sparseArray2 = new SparseArray();
            SparseArray<Object> sparseArray3 = null;
            sparseArray2.put(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, (Context) j.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold), Context.class, null));
            Object objectValue = j.objectValue(sparseArray.get(8424), Object.class, null);
            if (objectValue instanceof ValueSet) {
                sparseArray3 = ((ValueSet) objectValue).sparseArray();
            } else if (objectValue instanceof SparseArray) {
                sparseArray3 = (SparseArray) objectValue;
            }
            if (sparseArray3 != null) {
                sparseArray2.put(8424, sparseArray3);
            } else {
                sparseArray2.put(8424, sparseArray);
            }
            sparseArray2.put(-99999987, 8241);
            sparseArray2.put(-99999985, Void.class);
            a6.apply(sparseArray2);
        }
    }

    private boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("com.bytedance.msdk.adapter.");
    }
}
