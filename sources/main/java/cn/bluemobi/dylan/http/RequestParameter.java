package cn.bluemobi.dylan.http;

import androidx.collection.ArrayMap;
import java.io.File;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RequestParameter {
    public static RequestBody getRequestBody(String str) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), str);
    }

    public static Map<String, RequestBody> getFilePartMap(String str, List<File> list) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i6 = 0; i6 < list.size(); i6++) {
            File file = list.get(i6);
            arrayMap.put(str + i6 + "\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
        }
        return arrayMap;
    }

    public static RequestBody getRequestBody(File file) {
        return RequestBody.create(MediaType.parse("image/png"), file);
    }

    public static RequestBody getRequestBody2(File file) {
        return RequestBody.create(MediaType.parse("json"), file);
    }

    public static MultipartBody.Part getFilePart(String str, File file) {
        return MultipartBody.Part.createFormData(str, file.getName(), getRequestBody(file));
    }
}
