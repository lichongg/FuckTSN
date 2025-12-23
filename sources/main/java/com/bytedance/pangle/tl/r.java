package com.bytedance.pangle.tl;

import android.content.pm.Signature;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.tl.cw;
import com.kuaishou.weapon.p0.t;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static az j(String str, int i6) throws i {
        int[] iArr;
        if (i6 > 3) {
            throw new i(4, "No signature found in package of version " + i6 + " or newer for package " + str);
        }
        RandomAccessFile randomAccessFile = null;
        Signature[] signatureArr = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, t.f36150k);
                try {
                    try {
                        m.j(str, randomAccessFile2, -262969152, 1896449818);
                        try {
                            try {
                                cw.C0392cw j6 = cw.j(randomAccessFile2, str);
                                Signature[] j7 = j(new Certificate[][]{j6.f25521j});
                                cw.xt xtVar = j6.xt;
                                if (xtVar != null) {
                                    int size = xtVar.f25522j.size();
                                    Signature[] signatureArr2 = new Signature[size];
                                    iArr = new int[j6.xt.xt.size()];
                                    for (int i7 = 0; i7 < size; i7++) {
                                        signatureArr2[i7] = new Signature(j6.xt.f25522j.get(i7).getEncoded());
                                        iArr[i7] = j6.xt.xt.get(i7).intValue();
                                    }
                                    signatureArr = signatureArr2;
                                } else {
                                    iArr = null;
                                }
                                az azVar = new az(j7, 3, signatureArr, iArr);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception unused) {
                                }
                                return azVar;
                            } catch (Exception e6) {
                                throw new i(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e6);
                            }
                        } catch (ws e7) {
                            if (i6 >= 3) {
                                throw new i(4, "No APK Signature Scheme v3 signature in package ".concat(String.valueOf(str)), e7);
                            }
                            if (i6 > 2) {
                                throw new i(4, "No signature found in package of version " + i6 + " or newer for package " + str);
                            }
                            try {
                                az azVar2 = new az(j(xt.j(randomAccessFile2, str)), 2);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception unused2) {
                                }
                                return azVar2;
                            } catch (ws e8) {
                                if (i6 >= 2) {
                                    throw new i(4, "No APK Signature Scheme v2 signature in package ".concat(String.valueOf(str)), e8);
                                }
                                if (i6 <= 1) {
                                    az j8 = j.j(str, true);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused3) {
                                    }
                                    return j8;
                                }
                                throw new i(4, "No signature found in package of version " + i6 + " or newer for package " + str);
                            } catch (Exception e9) {
                                throw new i(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e9);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e10) {
                    throw new i(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e10);
                }
            } catch (Exception unused5) {
                throw new i(6, "failed to read apk file, minSignatureSchemeVersion : " + i6 + ", apkPath : " + str);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Signature[] j(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i6 = 0; i6 < certificateArr.length; i6++) {
            if (com.bytedance.pangle.util.g.r()) {
                Constructor j6 = com.bytedance.pangle.xt.xt.j.j((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (j6 != null) {
                    j6.setAccessible(true);
                }
                if (j6 != null && j6.isAccessible()) {
                    try {
                        signatureArr[i6] = (Signature) j6.newInstance(certificateArr[i6]);
                    } catch (IllegalAccessException e6) {
                        com.bytedance.sdk.openadsdk.api.m.j(e6);
                    } catch (InstantiationException e7) {
                        com.bytedance.sdk.openadsdk.api.m.j(e7);
                    } catch (InvocationTargetException e8) {
                        com.bytedance.sdk.openadsdk.api.m.j(e8);
                    }
                }
            } else {
                signatureArr[i6] = new Signature(certificateArr[i6][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
