package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttpDataFactory implements HttpDataFactory {
    public static final long MAXSIZE = -1;
    public static final long MINSIZE = 16384;
    private Charset charset;
    private final boolean checkSize;
    private long maxSize;
    private long minSize;
    private final Map<HttpRequest, List<HttpData>> requestFileDeleteMap;
    private final boolean useDisk;

    public DefaultHttpDataFactory() {
        this.maxSize = -1L;
        this.charset = HttpConstants.DEFAULT_CHARSET;
        this.requestFileDeleteMap = Collections.synchronizedMap(new IdentityHashMap());
        this.useDisk = false;
        this.checkSize = true;
        this.minSize = 16384L;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public Attribute createAttribute(HttpRequest httpRequest, String str) {
        if (this.useDisk) {
            DiskAttribute diskAttribute = new DiskAttribute(str, this.charset);
            diskAttribute.setMaxSize(this.maxSize);
            getList(httpRequest).add(diskAttribute);
            return diskAttribute;
        }
        if (!this.checkSize) {
            MemoryAttribute memoryAttribute = new MemoryAttribute(str);
            memoryAttribute.setMaxSize(this.maxSize);
            return memoryAttribute;
        }
        MixedAttribute mixedAttribute = new MixedAttribute(str, this.minSize, this.charset);
        mixedAttribute.setMaxSize(this.maxSize);
        getList(httpRequest).add(mixedAttribute);
        return mixedAttribute;
    }

    private List<HttpData> getList(HttpRequest httpRequest) {
        List<HttpData> list = this.requestFileDeleteMap.get(httpRequest);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        this.requestFileDeleteMap.put(httpRequest, arrayList);
        return arrayList;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public void cleanAllHttpData() {
        Iterator<Map.Entry<HttpRequest, List<HttpData>>> it = this.requestFileDeleteMap.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<HttpData> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                it2.next().release();
            }
            it.remove();
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public void cleanRequestHttpData(HttpRequest httpRequest) {
        List<HttpData> remove = this.requestFileDeleteMap.remove(httpRequest);
        if (remove != null) {
            Iterator<HttpData> it = remove.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public FileUpload createFileUpload(HttpRequest httpRequest, String str, String str2, String str3, String str4, Charset charset, long j6) {
        if (this.useDisk) {
            DiskFileUpload diskFileUpload = new DiskFileUpload(str, str2, str3, str4, charset, j6);
            diskFileUpload.setMaxSize(this.maxSize);
            checkHttpDataSize(diskFileUpload);
            getList(httpRequest).add(diskFileUpload);
            return diskFileUpload;
        }
        if (!this.checkSize) {
            MemoryFileUpload memoryFileUpload = new MemoryFileUpload(str, str2, str3, str4, charset, j6);
            memoryFileUpload.setMaxSize(this.maxSize);
            checkHttpDataSize(memoryFileUpload);
            return memoryFileUpload;
        }
        MixedFileUpload mixedFileUpload = new MixedFileUpload(str, str2, str3, str4, charset, j6, this.minSize);
        mixedFileUpload.setMaxSize(this.maxSize);
        checkHttpDataSize(mixedFileUpload);
        getList(httpRequest).add(mixedFileUpload);
        return mixedFileUpload;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public void removeHttpDataFromClean(HttpRequest httpRequest, InterfaceHttpData interfaceHttpData) {
        List<HttpData> list;
        if ((interfaceHttpData instanceof HttpData) && (list = this.requestFileDeleteMap.get(httpRequest)) != null) {
            Iterator<HttpData> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == interfaceHttpData) {
                    it.remove();
                    if (list.isEmpty()) {
                        this.requestFileDeleteMap.remove(httpRequest);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public void setMaxLimit(long j6) {
        this.maxSize = j6;
    }

    private static void checkHttpDataSize(HttpData httpData) {
        try {
            httpData.checkSize(httpData.length());
        } catch (IOException unused) {
            throw new IllegalArgumentException("Attribute bigger than maxSize allowed");
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public void cleanAllHttpDatas() {
        cleanAllHttpData();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public void cleanRequestHttpDatas(HttpRequest httpRequest) {
        cleanRequestHttpData(httpRequest);
    }

    public DefaultHttpDataFactory(Charset charset) {
        this();
        this.charset = charset;
    }

    public DefaultHttpDataFactory(boolean z5) {
        this.maxSize = -1L;
        this.charset = HttpConstants.DEFAULT_CHARSET;
        this.requestFileDeleteMap = Collections.synchronizedMap(new IdentityHashMap());
        this.useDisk = z5;
        this.checkSize = false;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public Attribute createAttribute(HttpRequest httpRequest, String str, long j6) {
        if (this.useDisk) {
            DiskAttribute diskAttribute = new DiskAttribute(str, j6, this.charset);
            diskAttribute.setMaxSize(this.maxSize);
            getList(httpRequest).add(diskAttribute);
            return diskAttribute;
        }
        if (this.checkSize) {
            MixedAttribute mixedAttribute = new MixedAttribute(str, j6, this.minSize, this.charset);
            mixedAttribute.setMaxSize(this.maxSize);
            getList(httpRequest).add(mixedAttribute);
            return mixedAttribute;
        }
        MemoryAttribute memoryAttribute = new MemoryAttribute(str, j6);
        memoryAttribute.setMaxSize(this.maxSize);
        return memoryAttribute;
    }

    public DefaultHttpDataFactory(boolean z5, Charset charset) {
        this(z5);
        this.charset = charset;
    }

    public DefaultHttpDataFactory(long j6) {
        this.maxSize = -1L;
        this.charset = HttpConstants.DEFAULT_CHARSET;
        this.requestFileDeleteMap = Collections.synchronizedMap(new IdentityHashMap());
        this.useDisk = false;
        this.checkSize = true;
        this.minSize = j6;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpDataFactory
    public Attribute createAttribute(HttpRequest httpRequest, String str, String str2) {
        Attribute attribute;
        if (this.useDisk) {
            try {
                attribute = new DiskAttribute(str, str2, this.charset);
                attribute.setMaxSize(this.maxSize);
            } catch (IOException unused) {
                MixedAttribute mixedAttribute = new MixedAttribute(str, str2, this.minSize, this.charset);
                mixedAttribute.setMaxSize(this.maxSize);
                attribute = mixedAttribute;
            }
            checkHttpDataSize(attribute);
            getList(httpRequest).add(attribute);
            return attribute;
        }
        if (this.checkSize) {
            MixedAttribute mixedAttribute2 = new MixedAttribute(str, str2, this.minSize, this.charset);
            mixedAttribute2.setMaxSize(this.maxSize);
            checkHttpDataSize(mixedAttribute2);
            getList(httpRequest).add(mixedAttribute2);
            return mixedAttribute2;
        }
        try {
            MemoryAttribute memoryAttribute = new MemoryAttribute(str, str2, this.charset);
            memoryAttribute.setMaxSize(this.maxSize);
            checkHttpDataSize(memoryAttribute);
            return memoryAttribute;
        } catch (IOException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    public DefaultHttpDataFactory(long j6, Charset charset) {
        this(j6);
        this.charset = charset;
    }
}
