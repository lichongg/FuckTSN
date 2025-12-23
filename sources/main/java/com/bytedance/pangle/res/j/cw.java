package com.bytedance.pangle.res.j;

import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    public int j(File file, boolean z5, StringBuilder sb) {
        String byteArrayOutputStream;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/ZeusResMapping");
                if (entry == null) {
                    com.bytedance.pangle.util.ae.j(zipFile2);
                    return 200;
                }
                if (z5) {
                    File file2 = new File(file.getParentFile(), "resMappingBak");
                    if (!file2.exists()) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "resMappingBakFile is not exists. " + file2.getAbsolutePath());
                        sb.append("resMappingBakFile is not exists. ");
                        sb.append(file2.getAbsolutePath());
                        com.bytedance.pangle.util.ae.j(zipFile2);
                        return 300;
                    }
                    byteArrayOutputStream = com.bytedance.pangle.util.tl.j(file2);
                } else {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    com.bytedance.pangle.util.tl.j(zipFile2.getInputStream(entry), byteArrayOutputStream2);
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                }
                if (TextUtils.isEmpty(byteArrayOutputStream)) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, useBakFile:".concat(String.valueOf(z5)));
                    sb.append("zeusResMappingContent isEmpty. useBakFile:");
                    sb.append(z5);
                    com.bytedance.pangle.util.ae.j(zipFile2);
                    return 300;
                }
                JSONObject jSONObject = new JSONObject(byteArrayOutputStream);
                JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream);
                JSONArray jSONArray = (JSONArray) jSONObject.get("fileNames");
                final HashSet<String> hashSet = new HashSet<>();
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    hashSet.add((String) jSONArray.get(i6));
                }
                final JSONObject jSONObject3 = (JSONObject) jSONObject.get("resMapping");
                final JSONObject jSONObject4 = (JSONObject) jSONObject2.get("resMapping");
                final int[] iArr = {0};
                try {
                    j(file, hashSet, new tl() { // from class: com.bytedance.pangle.res.j.cw.1
                        @Override // com.bytedance.pangle.res.j.tl
                        public int j(int i7) {
                            String str = "0x" + Integer.toHexString(i7);
                            String str2 = (String) jSONObject3.opt(str);
                            if (str2 == null) {
                                return i7;
                            }
                            int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                            if (identifier == 0) {
                                identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll("_", "."), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                            }
                            if (identifier == 0) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(str2));
                                return i7;
                            }
                            String str3 = "0x" + Integer.toHexString(identifier);
                            if (TextUtils.equals(jSONObject4.optString(str), str2)) {
                                jSONObject4.remove(str);
                            }
                            try {
                                jSONObject4.put(str3, str2);
                            } catch (Throwable th) {
                                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th);
                            }
                            if (identifier != i7) {
                                int[] iArr2 = iArr;
                                iArr2[0] = iArr2[0] + 1;
                            }
                            return identifier;
                        }

                        @Override // com.bytedance.pangle.res.j.tl
                        public boolean j(String str) {
                            return hashSet.contains(str);
                        }
                    });
                    ZeusLogger.d(ZeusLogger.TAG_INSTALL, "modifyRes count = " + iArr[0]);
                    if (com.bytedance.pangle.util.tl.j(jSONObject2.toString(), new File(file.getParentFile(), "resMappingBak"), sb)) {
                        com.bytedance.pangle.util.ae.j(zipFile2);
                        return 100;
                    }
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "writeText failed." + sb.toString());
                    sb.append("writeText failed.");
                    com.bytedance.pangle.util.ae.j(zipFile2);
                    return 300;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    try {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "modifyRes failed. catch: " + th.getMessage(), th);
                        sb.append("modifyRes failed. catch: ");
                        sb.append(th.getMessage());
                        return 300;
                    } finally {
                        if (zipFile != null) {
                            com.bytedance.pangle.util.ae.j(zipFile);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void j(File file, HashSet<String> hashSet, tl tlVar) throws Throwable {
        MappedByteBuffer j6 = j(file);
        int j7 = j(j6);
        if (j7 != -1) {
            int i6 = j6.getInt(j7 + 12);
            int i7 = j6.getInt(j7 + 16);
            int i8 = i6 + i7;
            while (i7 < i8) {
                if (j6.getInt(i7) == 33639248) {
                    int i9 = j6.getShort(i7 + 28);
                    short s5 = j6.getShort(i7 + 30);
                    byte[] bArr = new byte[i9];
                    for (int i10 = 0; i10 < i9; i10++) {
                        bArr[i10] = j6.get(i7 + 46 + i10);
                    }
                    String str = new String(bArr);
                    int i11 = j6.getInt(i7 + 20);
                    int i12 = j6.getInt(i7 + 24);
                    if (hashSet.contains(str)) {
                        if (i11 == i12) {
                            com.bytedance.pangle.util.up<Integer, byte[]> j8 = j(j6, j6.getInt(i7 + 42), str);
                            try {
                                qv.j(str, j8.xt, tlVar);
                                for (int i13 = 0; i13 < j8.xt.length; i13++) {
                                    j6.put(j8.f25547j.intValue() + i13, j8.xt[i13]);
                                }
                            } catch (Throwable th) {
                                throw new RuntimeException(th);
                            }
                        } else {
                            throw new Throwable(str + " is compressed.");
                        }
                    }
                    i7 += i9 + 46 + s5;
                } else {
                    throw new RuntimeException("Expected: 0x02014b50, got: " + j6.getInt(i7));
                }
            }
            return;
        }
        throw new Throwable("endOfCentralPosition == -1");
    }

    private static com.bytedance.pangle.util.up<Integer, byte[]> j(MappedByteBuffer mappedByteBuffer, int i6, String str) {
        if (mappedByteBuffer.getInt(i6) == 67324752) {
            int i7 = mappedByteBuffer.getInt(i6 + 18);
            int i8 = mappedByteBuffer.getInt(i6 + 22);
            if (i7 == i8) {
                byte[] bArr = new byte[i8];
                int i9 = i6 + 30 + mappedByteBuffer.getShort(i6 + 26) + mappedByteBuffer.getShort(i6 + 28);
                for (int i10 = 0; i10 < i8; i10++) {
                    bArr[i10] = mappedByteBuffer.get(i9 + i10);
                }
                return new com.bytedance.pangle.util.up<>(Integer.valueOf(i9), bArr);
            }
            throw new RuntimeException(str + " is compressed. compressSize:" + i7 + " size:" + i8);
        }
        throw new RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i6) + " FileName:" + str);
    }

    private int j(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i6 = capacity - 22;
        int min = Math.min(i6, 65535);
        for (int i7 = 0; i7 < min; i7++) {
            int i8 = i6 - i7;
            if (byteBuffer.getInt(i8) == 101010256 && byteBuffer.getShort(i8 + 20) == i7) {
                return i8;
            }
        }
        return -1;
    }

    public MappedByteBuffer j(File file) throws IOException {
        Throwable th;
        RandomAccessFile randomAccessFile = null;
        try {
            ZeusLogger.d("temp-pxr", "mappedByteBuffer " + file.canWrite());
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            try {
                FileChannel channel = randomAccessFile2.getChannel();
                long size = channel.size();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
                byte[] bArr = new byte[4194304];
                long j6 = size / 4194304;
                int i6 = (int) (size % 4194304);
                for (int i7 = 0; i7 < j6; i7++) {
                    map.get(bArr);
                }
                if (i6 > 0) {
                    map.get(new byte[i6]);
                }
                map.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile2.close();
                return map;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile == null) {
                    throw th;
                }
                randomAccessFile.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
