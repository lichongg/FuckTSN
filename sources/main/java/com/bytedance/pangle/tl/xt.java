package com.bytedance.pangle.tl;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private static boolean j(int i6) {
        if (i6 == 513 || i6 == 514 || i6 == 769 || i6 == 1057 || i6 == 1059 || i6 == 1061) {
            return true;
        }
        switch (i6) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return true;
            default:
                return false;
        }
    }

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        public final X509Certificate[][] f25534j;
        public final byte[] xt;

        public j(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.f25534j = x509CertificateArr;
            this.xt = bArr;
        }
    }

    public static X509Certificate[][] j(RandomAccessFile randomAccessFile, String str) throws ws, SecurityException, IOException {
        jy jyVar = m.f25528j.get(str).get(1896449818);
        if (jyVar != null) {
            return j(randomAccessFile, jyVar, true).f25534j;
        }
        throw new ws("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
    }

    private static j j(RandomAccessFile randomAccessFile, jy jyVar, boolean z5) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f33254b);
            try {
                ByteBuffer j6 = m.j(jyVar.f25526j);
                int i6 = 0;
                while (j6.hasRemaining()) {
                    i6++;
                    try {
                        arrayList.add(j(m.j(j6), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e6) {
                        throw new SecurityException("Failed to parse/verify signer #" + i6 + " block", e6);
                    }
                }
                if (i6 > 0) {
                    if (!arrayMap.isEmpty()) {
                        if (z5) {
                            m.j(arrayMap, randomAccessFile, jyVar);
                        }
                        return new j((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? m.j((byte[]) arrayMap.get(3), randomAccessFile.length(), jyVar) : null);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e7) {
                throw new SecurityException("Failed to read list of signers", e7);
            }
        } catch (CertificateException e8) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e8);
        }
    }

    private static X509Certificate[] j(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        ByteBuffer j6 = m.j(byteBuffer);
        ByteBuffer j7 = m.j(byteBuffer);
        byte[] xt = m.xt(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i6 = -1;
        int i7 = 0;
        while (j7.hasRemaining()) {
            i7++;
            try {
                ByteBuffer j8 = m.j(j7);
                if (j8.remaining() >= 8) {
                    int i8 = j8.getInt();
                    arrayList.add(Integer.valueOf(i8));
                    if (j(i8)) {
                        if (i6 != -1 && m.j(i8, i6) <= 0) {
                        }
                        bArr2 = m.xt(j8);
                        i6 = i8;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException e6) {
                e = e6;
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i7)), e);
            } catch (BufferUnderflowException e7) {
                e = e7;
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i7)), e);
            }
        }
        if (i6 == -1) {
            if (i7 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String cw = m.cw(i6);
        Pair<String, ? extends AlgorithmParameterSpec> r5 = m.r(i6);
        String str = (String) r5.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) r5.second;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(cw).generatePublic(new X509EncodedKeySpec(xt));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(generatePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(j6);
            if (signature.verify(bArr2)) {
                j6.clear();
                ByteBuffer j9 = m.j(j6);
                ArrayList arrayList2 = new ArrayList();
                int i9 = 0;
                while (j9.hasRemaining()) {
                    i9++;
                    try {
                        ByteBuffer j10 = m.j(j9);
                        if (j10.remaining() >= 8) {
                            int i10 = j10.getInt();
                            arrayList2.add(Integer.valueOf(i10));
                            if (i10 == i6) {
                                bArr = m.xt(j10);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException e8) {
                        e = e8;
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i9)), e);
                    } catch (BufferUnderflowException e9) {
                        e = e9;
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i9)), e);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    int j11 = m.j(i6);
                    byte[] put = map.put(Integer.valueOf(j11), bArr);
                    if (put != null && !MessageDigest.isEqual(put, bArr)) {
                        throw new SecurityException(m.xt(j11) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer j12 = m.j(j6);
                    ArrayList arrayList3 = new ArrayList();
                    int i11 = 0;
                    while (j12.hasRemaining()) {
                        i11++;
                        byte[] xt2 = m.xt(j12);
                        try {
                            arrayList3.add(new av((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(xt2)), xt2));
                        } catch (CertificateException e10) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i11)), e10);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(xt, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            j(m.j(j6));
                            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                        }
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    }
                    throw new SecurityException("No certificates listed");
                }
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            throw new SecurityException(str + " signature did not verify");
        } catch (InvalidAlgorithmParameterException e11) {
            e = e11;
            throw new SecurityException("Failed to verify " + str + " signature", e);
        } catch (InvalidKeyException e12) {
            e = e12;
            throw new SecurityException("Failed to verify " + str + " signature", e);
        } catch (NoSuchAlgorithmException e13) {
            e = e13;
            throw new SecurityException("Failed to verify " + str + " signature", e);
        } catch (SignatureException e14) {
            e = e14;
            throw new SecurityException("Failed to verify " + str + " signature", e);
        } catch (InvalidKeySpecException e15) {
            e = e15;
            throw new SecurityException("Failed to verify " + str + " signature", e);
        }
    }

    private static void j(ByteBuffer byteBuffer) throws SecurityException, IOException {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer j6 = m.j(byteBuffer);
            if (j6.remaining() >= 4) {
                if (j6.getInt() == -1091571699) {
                    if (j6.remaining() >= 4) {
                        if (j6.getInt() == 3) {
                            throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                        }
                    } else {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + j6.remaining());
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + j6.remaining());
            }
        }
    }
}
