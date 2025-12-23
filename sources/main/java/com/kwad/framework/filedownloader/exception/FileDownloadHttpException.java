package com.kwad.framework.filedownloader.exception;

import com.kwad.framework.filedownloader.f.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FileDownloadHttpException extends IOException {
    private final int mCode;
    private final Map<String, List<String>> mRequestHeaderMap;
    private final Map<String, List<String>> mResponseHeaderMap;

    private static Map<String, List<String>> cloneSerializableMap(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return hashMap;
    }

    public int getCode() {
        return this.mCode;
    }

    public Map<String, List<String>> getRequestHeader() {
        return this.mRequestHeaderMap;
    }

    public Map<String, List<String>> getResponseHeader() {
        return this.mResponseHeaderMap;
    }

    public FileDownloadHttpException(int i6, Map<String, List<String>> map, Map<String, List<String>> map2) {
        super(f.c("response requestHttpCode error: %d, \n request headers: %s \n response headers: %s", Integer.valueOf(i6), map, map2));
        this.mCode = i6;
        this.mRequestHeaderMap = cloneSerializableMap(map);
        this.mResponseHeaderMap = cloneSerializableMap(map);
    }
}
