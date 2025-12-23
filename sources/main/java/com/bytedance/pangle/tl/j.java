package com.bytedance.pangle.tl;

import android.content.pm.Signature;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicReference<byte[]> f25524j = new AtomicReference<>();

    public static az j(String str, boolean z5) throws i {
        GeneralSecurityException generalSecurityException;
        Throwable th;
        Throwable th2;
        JarFile jarFile = null;
        try {
            try {
                JarFile jarFile2 = new JarFile(str);
                try {
                    ArrayList<JarEntry> arrayList = new ArrayList();
                    JarEntry jarEntry = jarFile2.getJarEntry("AndroidManifest.xml");
                    if (jarEntry == null) {
                        throw new i(1, "Package " + str + " has no manifest");
                    }
                    Certificate[][] j6 = j(jarFile2, jarEntry);
                    if (com.bytedance.pangle.util.r.j(j6)) {
                        throw new i(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
                    }
                    Signature[] j7 = r.j(j6);
                    if (z5) {
                        Enumeration<JarEntry> entries = jarFile2.entries();
                        while (entries.hasMoreElements()) {
                            JarEntry nextElement = entries.nextElement();
                            if (!nextElement.isDirectory()) {
                                String name = nextElement.getName();
                                if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                                    arrayList.add(nextElement);
                                }
                            }
                        }
                        for (JarEntry jarEntry2 : arrayList) {
                            Certificate[][] j8 = j(jarFile2, jarEntry2);
                            if (com.bytedance.pangle.util.r.j(j8)) {
                                throw new i(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                            }
                            if (!az.j(j7, r.j(j8))) {
                                throw new i(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                            }
                        }
                    }
                    az azVar = new az(j7, 1, null, null, null);
                    try {
                        jarFile2.close();
                    } catch (Exception unused) {
                    }
                    return azVar;
                } catch (IOException e6) {
                    e = e6;
                    th = e;
                    throw new i(4, "Failed to collect certificates from ".concat(String.valueOf(str)), th);
                } catch (RuntimeException e7) {
                    e = e7;
                    th = e;
                    throw new i(4, "Failed to collect certificates from ".concat(String.valueOf(str)), th);
                } catch (GeneralSecurityException e8) {
                    generalSecurityException = e8;
                    throw new i(2, "Failed to collect certificates from ".concat(String.valueOf(str)), generalSecurityException);
                } catch (Throwable th3) {
                    th2 = th3;
                    jarFile = jarFile2;
                    if (jarFile == null) {
                        throw th2;
                    }
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Exception unused2) {
                        throw th2;
                    }
                }
            } catch (IOException e9) {
                e = e9;
                th = e;
                throw new i(4, "Failed to collect certificates from ".concat(String.valueOf(str)), th);
            } catch (RuntimeException e10) {
                e = e10;
                th = e;
                throw new i(4, "Failed to collect certificates from ".concat(String.valueOf(str)), th);
            } catch (GeneralSecurityException e11) {
                generalSecurityException = e11;
            }
        } catch (Throwable th4) {
            th2 = th4;
        }
    }

    private static Certificate[][] j(JarFile jarFile, JarEntry jarEntry) throws i {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                j(inputStream2);
                Certificate[][] certificateArr = {jarEntry.getCertificates()};
                if (inputStream2 == null) {
                    return certificateArr;
                }
                try {
                    inputStream2.close();
                } catch (RuntimeException e6) {
                    throw e6;
                } catch (Exception unused) {
                }
                return certificateArr;
            } catch (IOException | RuntimeException e7) {
                throw new i(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e7);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (RuntimeException e8) {
                    throw e8;
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private static void j(InputStream inputStream) throws IOException {
        byte[] andSet = f25524j.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (inputStream.read(andSet, 0, andSet.length) != -1) {
        }
        f25524j.set(andSet);
    }
}
