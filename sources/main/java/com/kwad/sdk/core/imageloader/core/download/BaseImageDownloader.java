package com.kwad.sdk.core.imageloader.core.download;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.core.imageloader.core.assist.ContentLengthInputStream;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.crash.utils.b;
import com.stub.StubApp;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BaseImageDownloader implements ImageDownloader {
    protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    protected static final int BUFFER_SIZE = 32768;
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected static final int MAX_REDIRECT_COUNT = 5;
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    public BaseImageDownloader(Context context) {
        this(context, 5000, 20000);
    }

    @TargetApi(8)
    private InputStream getVideoThumbnailStream(String str) {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
        if (createVideoThumbnail == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BaseImageDownloader(Context context, int i6, int i7) {
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.connectTimeout = i6;
        this.readTimeout = i7;
    }

    private boolean isVideoContentUri(Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        return type != null && type.startsWith("video/");
    }

    protected HttpURLConnection createConnection(String str, Object obj) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, ALLOWED_URI_CHARS)).openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return httpURLConnection;
    }

    @Override // com.kwad.sdk.core.imageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return getStreamFromNetwork(str, obj);
            case 3:
                return getStreamFromFile(str, obj);
            case 4:
                return getStreamFromContent(str, obj);
            case 5:
                return getStreamFromAssets(str, obj);
            case 6:
                return getStreamFromDrawable(str, obj);
            default:
                return getStreamFromOtherSource(str, obj);
        }
    }

    protected InputStream getStreamFromAssets(String str, Object obj) {
        return this.context.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    protected InputStream getStreamFromContent(String str, Object obj) {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri parse = Uri.parse(str);
        if (!isVideoContentUri(parse) || (thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null)) == null) {
            return contentResolver.openInputStream(parse);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    protected InputStream getStreamFromDrawable(String str, Object obj) {
        return this.context.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    protected InputStream getStreamFromFile(String str, Object obj) {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        return isVideoFileUri(str) ? getVideoThumbnailStream(crop) : new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    protected InputStream getStreamFromOtherSource(String str, Object obj) {
        throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, str));
    }

    private boolean isVideoFileUri(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        if (mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/")) {
            return true;
        }
        return false;
    }

    protected InputStream getStreamFromNetwork(String str, Object obj) {
        HttpURLConnection createConnection = createConnection(str, obj);
        for (int i6 = 0; createConnection.getResponseCode() / 100 == 3 && i6 < 5; i6++) {
            createConnection = createConnection(createConnection.getHeaderField("Location"), obj);
        }
        try {
            InputStream inputStream = createConnection.getInputStream();
            if (shouldBeProcessed(createConnection)) {
                return new ContentLengthInputStream(new BufferedInputStream(inputStream, 32768), createConnection.getContentLength());
            }
            b.closeQuietly(inputStream);
            throw new IOException("Image request failed with response code " + createConnection.getResponseCode());
        } catch (IOException e6) {
            IoUtils.readAndCloseStream(createConnection.getErrorStream());
            throw e6;
        }
    }

    protected boolean shouldBeProcessed(HttpURLConnection httpURLConnection) {
        if (httpURLConnection.getResponseCode() == 200) {
            return true;
        }
        return false;
    }
}
