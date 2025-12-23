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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    private static class j extends Exception {
    }

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

    /* renamed from: com.bytedance.pangle.tl.cw$cw, reason: collision with other inner class name */
    public static class C0392cw {
        public byte[] cw;

        /* renamed from: j, reason: collision with root package name */
        public final X509Certificate[] f25521j;
        public final xt xt;

        public C0392cw(X509Certificate[] x509CertificateArr, xt xtVar) {
            this.f25521j = x509CertificateArr;
            this.xt = xtVar;
        }
    }

    public static class xt {

        /* renamed from: j, reason: collision with root package name */
        public final List<X509Certificate> f25522j;
        public final List<Integer> xt;

        public xt(List<X509Certificate> list, List<Integer> list2) {
            this.f25522j = list;
            this.xt = list2;
        }
    }

    public static C0392cw j(RandomAccessFile randomAccessFile, String str) throws IOException, ws {
        jy jyVar = m.f25528j.get(str).get(-262969152);
        if (jyVar != null) {
            return j(randomAccessFile, jyVar, true);
        }
        throw new ws("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
    }

    private static C0392cw j(RandomAccessFile randomAccessFile, jy jyVar, boolean z5) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f33254b);
            try {
                ByteBuffer j6 = m.j(jyVar.f25526j);
                int i6 = 0;
                C0392cw c0392cw = null;
                while (j6.hasRemaining()) {
                    try {
                        c0392cw = j(m.j(j6), arrayMap, certificateFactory);
                        i6++;
                    } catch (j unused) {
                    } catch (IOException e6) {
                        e = e6;
                        throw new SecurityException("Failed to parse/verify signer #" + i6 + " block", e);
                    } catch (SecurityException e7) {
                        e = e7;
                        throw new SecurityException("Failed to parse/verify signer #" + i6 + " block", e);
                    } catch (BufferUnderflowException e8) {
                        e = e8;
                        throw new SecurityException("Failed to parse/verify signer #" + i6 + " block", e);
                    }
                }
                if (i6 <= 0 || c0392cw == null) {
                    throw new SecurityException("No signers found");
                }
                if (i6 == 1) {
                    if (!arrayMap.isEmpty()) {
                        if (z5) {
                            m.j(arrayMap, randomAccessFile, jyVar);
                        }
                        if (arrayMap.containsKey(3)) {
                            c0392cw.cw = m.j((byte[]) arrayMap.get(3), randomAccessFile.length(), jyVar);
                        }
                        return c0392cw;
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
            } catch (IOException e9) {
                throw new SecurityException("Failed to read list of signers", e9);
            }
        } catch (CertificateException e10) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e10);
        }
    }

    private static C0392cw j(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException, j {
        ByteBuffer j6 = m.j(byteBuffer);
        int i6 = byteBuffer.getInt();
        int i7 = byteBuffer.getInt();
        ByteBuffer j7 = m.j(byteBuffer);
        byte[] xt2 = m.xt(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i8 = -1;
        int i9 = 0;
        while (j7.hasRemaining()) {
            i9++;
            try {
                ByteBuffer j8 = m.j(j7);
                if (j8.remaining() >= 8) {
                    int i10 = j8.getInt();
                    arrayList.add(Integer.valueOf(i10));
                    if (j(i10)) {
                        if (i8 != -1 && m.j(i10, i8) <= 0) {
                        }
                        bArr2 = m.xt(j8);
                        i8 = i10;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException e6) {
                e = e6;
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i9)), e);
            } catch (BufferUnderflowException e7) {
                e = e7;
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i9)), e);
            }
        }
        if (i8 == -1) {
            if (i9 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String cw = m.cw(i8);
        Pair<String, ? extends AlgorithmParameterSpec> r5 = m.r(i8);
        String str = (String) r5.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) r5.second;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(cw).generatePublic(new X509EncodedKeySpec(xt2));
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
                int i11 = 0;
                while (j9.hasRemaining()) {
                    i11++;
                    try {
                        ByteBuffer j10 = m.j(j9);
                        if (j10.remaining() >= 8) {
                            int i12 = j10.getInt();
                            arrayList2.add(Integer.valueOf(i12));
                            if (i12 == i8) {
                                bArr = m.xt(j10);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException e8) {
                        e = e8;
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i11)), e);
                    } catch (BufferUnderflowException e9) {
                        e = e9;
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i11)), e);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    int j11 = m.j(i8);
                    byte[] put = map.put(Integer.valueOf(j11), bArr);
                    if (put != null && !MessageDigest.isEqual(put, bArr)) {
                        throw new SecurityException(m.xt(j11) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer j12 = m.j(j6);
                    ArrayList arrayList3 = new ArrayList();
                    int i13 = 0;
                    while (j12.hasRemaining()) {
                        i13++;
                        byte[] xt3 = m.xt(j12);
                        try {
                            arrayList3.add(new av((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(xt3)), xt3));
                        } catch (CertificateException e10) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i13)), e10);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(xt2, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            if (j6.getInt() == i6) {
                                if (j6.getInt() == i7) {
                                    return j(m.j(j6), arrayList3, certificateFactory);
                                }
                                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                            }
                            throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
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

    private static C0392cw j(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        xt xtVar = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer j6 = m.j(byteBuffer);
            if (j6.remaining() >= 4) {
                if (j6.getInt() == 1000370060) {
                    if (xtVar == null) {
                        xtVar = j(j6, certificateFactory);
                        try {
                            if (xtVar.f25522j.size() > 0) {
                                if (!Arrays.equals(xtVar.f25522j.get(r1.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e6) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e6);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + j6.remaining());
            }
        }
        return new C0392cw(x509CertificateArr, xtVar);
    }

    private static xt j(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws SecurityException, IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i6 = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i7 = -1;
            av avVar = null;
            while (byteBuffer.hasRemaining()) {
                i6++;
                ByteBuffer j6 = m.j(byteBuffer);
                ByteBuffer j7 = m.j(j6);
                int i8 = j6.getInt();
                int i9 = j6.getInt();
                byte[] xt2 = m.xt(j6);
                if (avVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> r5 = m.r(i7);
                    PublicKey publicKey = avVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) r5.first);
                    signature.initVerify(publicKey);
                    Object obj = r5.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(j7);
                    if (!signature.verify(xt2)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i6 + " using " + ((String) r5.first) + " when verifying Proof-of-rotation record");
                    }
                }
                j7.rewind();
                byte[] xt3 = m.xt(j7);
                int i10 = j7.getInt();
                if (avVar != null && i7 != i10) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i6 + " when verifying Proof-of-rotation record");
                }
                avVar = new av((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(xt3)), xt3);
                if (!hashSet.contains(avVar)) {
                    hashSet.add(avVar);
                    arrayList.add(avVar);
                    arrayList2.add(Integer.valueOf(i8));
                    i7 = i9;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i6 + ".  All signing certificates should be unique");
                }
            }
            return new xt(arrayList, arrayList2);
        } catch (IOException | BufferUnderflowException e6) {
            throw new IOException("Failed to parse Proof-of-rotation record", e6);
        } catch (InvalidAlgorithmParameterException e7) {
            e = e7;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e8) {
            e = e8;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e9) {
            e = e9;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e10) {
            e = e10;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e11) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e11);
        }
    }
}
