package io.netty.handler.codec.http.multipart;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class FileUploadUtil {
    private FileUploadUtil() {
    }

    static int compareTo(FileUpload fileUpload, FileUpload fileUpload2) {
        return fileUpload.getName().compareToIgnoreCase(fileUpload2.getName());
    }

    static boolean equals(FileUpload fileUpload, FileUpload fileUpload2) {
        return fileUpload.getName().equalsIgnoreCase(fileUpload2.getName());
    }

    static int hashCode(FileUpload fileUpload) {
        return fileUpload.getName().hashCode();
    }
}
