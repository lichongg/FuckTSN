package com.bytedance.sdk.component.m.cw.j.j;

import com.bytedance.sdk.component.m.cw.j.j.j;
import com.bytedance.sdk.component.utils.vl;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.component.m.cw {

    /* renamed from: j, reason: collision with root package name */
    private long f26568j;
    private j xt;

    @Override // com.bytedance.sdk.component.m.j
    /* renamed from: cw, reason: merged with bridge method [inline-methods] */
    public boolean xt(String str) {
        try {
            try {
                j.cw j6 = this.xt.j(str);
                boolean z5 = j6 != null;
                com.bytedance.sdk.component.m.cw.cw.xt.j(j6);
                return z5;
            } catch (IOException e6) {
                vl.xt("LruCountDiskCache", e6.getMessage());
                com.bytedance.sdk.component.m.cw.cw.xt.j(null);
                return false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.m.cw.cw.xt.j(null);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable, java.io.InputStream] */
    @Override // com.bytedance.sdk.component.m.j
    /* renamed from: xt, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] j(String str) {
        Closeable closeable;
        Closeable closeable2;
        ByteArrayOutputStream byteArrayOutputStream;
        j jVar = this.xt;
        Closeable closeable3 = null;
        if (jVar != null) {
            try {
                if (str != 0) {
                    try {
                        j.cw j6 = jVar.j((String) str);
                        if (j6 == null) {
                            com.bytedance.sdk.component.m.cw.cw.xt.j(null);
                            com.bytedance.sdk.component.m.cw.cw.xt.j(null);
                            return null;
                        }
                        str = j6.j(0);
                        if (str != 0) {
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (IOException e6) {
                                e = e6;
                                byteArrayOutputStream = null;
                                closeable2 = str;
                                vl.xt("LruCountDiskCache", e.toString());
                                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable2);
                                com.bytedance.sdk.component.m.cw.cw.xt.j(byteArrayOutputStream);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                closeable = null;
                                closeable3 = str;
                                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable3);
                                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable);
                                throw th;
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = str.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                            } catch (IOException e7) {
                                e = e7;
                                closeable2 = str;
                                vl.xt("LruCountDiskCache", e.toString());
                                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable2);
                                com.bytedance.sdk.component.m.cw.cw.xt.j(byteArrayOutputStream);
                                return null;
                            }
                        } else {
                            byteArrayOutputStream = null;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.bytedance.sdk.component.m.cw.cw.xt.j(str);
                        com.bytedance.sdk.component.m.cw.cw.xt.j(byteArrayOutputStream);
                        return byteArray;
                    } catch (IOException e8) {
                        e = e8;
                        closeable2 = null;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = null;
                        com.bytedance.sdk.component.m.cw.cw.xt.j(closeable3);
                        com.bytedance.sdk.component.m.cw.cw.xt.j(closeable);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public xt(File file, long j6, ExecutorService executorService) {
        this.f26568j = j6;
        try {
            this.xt = j.j(file, 20210302, 1, j6, executorService);
        } catch (IOException e6) {
            vl.xt("LruCountDiskCache", e6.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.m.cw
    public InputStream j(String str) {
        j jVar = this.xt;
        if (jVar == null) {
            return null;
        }
        try {
            j.cw j6 = jVar.j(str);
            if (j6 != null) {
                return j6.j(0);
            }
        } catch (IOException e6) {
            vl.xt("LruCountDiskCache", e6.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.m.j
    public boolean j(String str, byte[] bArr) {
        Closeable closeable;
        j jVar = this.xt;
        if (jVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable2 = null;
        j.C0412j c0412j = null;
        try {
            try {
                j.C0412j xt = jVar.xt(str);
                try {
                    if (xt == null) {
                        vl.xt("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.m.cw.cw.xt.j(null);
                        return false;
                    }
                    OutputStream j6 = xt.j(0);
                    if (j6 == j.cw) {
                        vl.xt("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.bytedance.sdk.component.m.cw.cw.xt.j(j6);
                        return false;
                    }
                    j6.write(bArr);
                    xt.j();
                    this.xt.j();
                    com.bytedance.sdk.component.m.cw.cw.xt.j(j6);
                    return true;
                } catch (IOException e6) {
                    e = e6;
                    closeable = null;
                    c0412j = xt;
                    try {
                        vl.xt("LruCountDiskCache", e.toString());
                        if (c0412j != null) {
                            try {
                                c0412j.xt();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.m.cw.cw.xt.j(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        com.bytedance.sdk.component.m.cw.cw.xt.j(closeable2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.m.cw.cw.xt.j(closeable2);
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            closeable = null;
        }
    }

    @Override // com.bytedance.sdk.component.m.j
    public void j(double d6) {
        this.xt.j((long) (this.f26568j * d6));
    }
}
