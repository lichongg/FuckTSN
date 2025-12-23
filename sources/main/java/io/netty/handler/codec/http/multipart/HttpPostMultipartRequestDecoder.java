package io.netty.handler.codec.http.multipart;

import com.huawei.hms.framework.common.ContainerUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpPostMultipartRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private static final String FILENAME_ENCODED = HttpHeaderValues.FILENAME.toString() + '*';
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private Charset charset;
    private Attribute currentAttribute;
    private Map<CharSequence, Attribute> currentFieldAttributes;
    private FileUpload currentFileUpload;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private String multipartDataBoundary;
    private String multipartMixedBoundary;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    public HttpPostMultipartRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384L), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private Attribute getContentDispositionAttribute(String... strArr) {
        String cleanString = cleanString(strArr[0]);
        String str = strArr[1];
        AsciiString asciiString = HttpHeaderValues.FILENAME;
        if (asciiString.contentEquals(cleanString)) {
            int length = str.length() - 1;
            if (length > 0 && str.charAt(0) == '\"' && str.charAt(length) == '\"') {
                str = str.substring(1, length);
            }
        } else if (FILENAME_ENCODED.equals(cleanString)) {
            try {
                cleanString = asciiString.toString();
                String[] split = str.split("'", 3);
                str = QueryStringDecoder.decodeComponent(split[2], Charset.forName(split[0]));
            } catch (ArrayIndexOutOfBoundsException e6) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e6);
            } catch (UnsupportedCharsetException e7) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e7);
            }
        } else {
            str = cleanString(str);
        }
        return this.factory.createAttribute(this.request, cleanString, str);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas() {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyListHttpData;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus;

        static {
            int[] iArr = new int[HttpPostRequestDecoder.MultiPartStatus.values().length];
            $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus = iArr;
            try {
                iArr[HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.PREAMBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.DISPOSITION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.FIELD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.MIXEDDISPOSITION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.MIXEDFILEUPLOAD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.EPILOGUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public HttpPostMultipartRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            throw new IllegalStateException(HttpPostMultipartRequestDecoder.class.getSimpleName() + " was destroyed already");
        }
    }

    private void cleanMixedAttributes() {
        this.currentFieldAttributes.remove(HttpHeaderValues.CHARSET);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_LENGTH);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TYPE);
        this.currentFieldAttributes.remove(HttpHeaderValues.FILENAME);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0090 A[Catch: IOException -> 0x00a3, IllegalArgumentException -> 0x00a5, NullPointerException -> 0x00a7, TRY_ENTER, TryCatch #4 {IOException -> 0x00a3, IllegalArgumentException -> 0x00a5, NullPointerException -> 0x00a7, blocks: (B:26:0x0090, B:30:0x00a9), top: B:24:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9 A[Catch: IOException -> 0x00a3, IllegalArgumentException -> 0x00a5, NullPointerException -> 0x00a7, TRY_LEAVE, TryCatch #4 {IOException -> 0x00a3, IllegalArgumentException -> 0x00a5, NullPointerException -> 0x00a7, blocks: (B:26:0x0090, B:30:0x00a9), top: B:24:0x008e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.netty.handler.codec.http.multipart.InterfaceHttpData decodeMultipart(io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus r8) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder.decodeMultipart(io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus):io.netty.handler.codec.http.multipart.InterfaceHttpData");
    }

    private InterfaceHttpData findMultipartDelimiter(String str, HttpPostRequestDecoder.MultiPartStatus multiPartStatus, HttpPostRequestDecoder.MultiPartStatus multiPartStatus2) {
        int readerIndex = this.undecodedChunk.readerIndex();
        try {
            skipControlCharacters(this.undecodedChunk);
            skipOneLine();
            try {
                String readDelimiter = readDelimiter(this.undecodedChunk, str);
                if (readDelimiter.equals(str)) {
                    this.currentStatus = multiPartStatus;
                    return decodeMultipart(multiPartStatus);
                }
                if (!readDelimiter.equals(str + "--")) {
                    this.undecodedChunk.readerIndex(readerIndex);
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException("No Multipart delimiter found");
                }
                this.currentStatus = multiPartStatus2;
                HttpPostRequestDecoder.MultiPartStatus multiPartStatus3 = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
                if (multiPartStatus2 != multiPartStatus3) {
                    return null;
                }
                this.currentFieldAttributes = null;
                return decodeMultipart(multiPartStatus3);
            } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused) {
                this.undecodedChunk.readerIndex(readerIndex);
                return null;
            }
        } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused2) {
            this.undecodedChunk.readerIndex(readerIndex);
            return null;
        }
    }

    private InterfaceHttpData findMultipartDisposition() {
        int readerIndex = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
            this.currentFieldAttributes = new TreeMap(CaseIgnoringComparator.INSTANCE);
        }
        while (!skipOneLine()) {
            try {
                skipControlCharacters(this.undecodedChunk);
                String[] splitMultipartHeader = splitMultipartHeader(readLine(this.undecodedChunk, this.charset));
                if (HttpHeaderNames.CONTENT_DISPOSITION.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                    if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION ? HttpHeaderValues.FORM_DATA.contentEqualsIgnoreCase(splitMultipartHeader[1]) : HttpHeaderValues.ATTACHMENT.contentEqualsIgnoreCase(splitMultipartHeader[1]) || HttpHeaderValues.FILE.contentEqualsIgnoreCase(splitMultipartHeader[1])) {
                        for (int i6 = 2; i6 < splitMultipartHeader.length; i6++) {
                            try {
                                Attribute contentDispositionAttribute = getContentDispositionAttribute(splitMultipartHeader[i6].split(ContainerUtils.KEY_VALUE_DELIMITER, 2));
                                this.currentFieldAttributes.put(contentDispositionAttribute.getName(), contentDispositionAttribute);
                            } catch (IllegalArgumentException e6) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e6);
                            } catch (NullPointerException e7) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e7);
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    AsciiString asciiString = HttpHeaderNames.CONTENT_TRANSFER_ENCODING;
                    if (asciiString.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                        try {
                            this.currentFieldAttributes.put(asciiString, this.factory.createAttribute(this.request, asciiString.toString(), cleanString(splitMultipartHeader[1])));
                        } catch (IllegalArgumentException e8) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e8);
                        } catch (NullPointerException e9) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e9);
                        }
                    } else {
                        AsciiString asciiString2 = HttpHeaderNames.CONTENT_LENGTH;
                        if (asciiString2.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                            try {
                                this.currentFieldAttributes.put(asciiString2, this.factory.createAttribute(this.request, asciiString2.toString(), cleanString(splitMultipartHeader[1])));
                            } catch (IllegalArgumentException e10) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e10);
                            } catch (NullPointerException e11) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e11);
                            }
                        } else if (!HttpHeaderNames.CONTENT_TYPE.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                            continue;
                        } else {
                            if (HttpHeaderValues.MULTIPART_MIXED.contentEqualsIgnoreCase(splitMultipartHeader[1])) {
                                if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
                                    throw new HttpPostRequestDecoder.ErrorDataDecoderException("Mixed Multipart found in a previous Mixed Multipart");
                                }
                                this.multipartMixedBoundary = "--" + StringUtil.substringAfter(splitMultipartHeader[2], '=');
                                HttpPostRequestDecoder.MultiPartStatus multiPartStatus = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
                                this.currentStatus = multiPartStatus;
                                return decodeMultipart(multiPartStatus);
                            }
                            for (int i7 = 1; i7 < splitMultipartHeader.length; i7++) {
                                AsciiString asciiString3 = HttpHeaderValues.CHARSET;
                                String asciiString4 = asciiString3.toString();
                                if (splitMultipartHeader[i7].regionMatches(true, 0, asciiString4, 0, asciiString4.length())) {
                                    try {
                                        this.currentFieldAttributes.put(asciiString3, this.factory.createAttribute(this.request, asciiString4, cleanString(StringUtil.substringAfter(splitMultipartHeader[i7], '='))));
                                    } catch (IllegalArgumentException e12) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e12);
                                    } catch (NullPointerException e13) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e13);
                                    }
                                } else {
                                    try {
                                        Attribute createAttribute = this.factory.createAttribute(this.request, cleanString(splitMultipartHeader[0]), splitMultipartHeader[i7]);
                                        this.currentFieldAttributes.put(createAttribute.getName(), createAttribute);
                                    } catch (IllegalArgumentException e14) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e14);
                                    } catch (NullPointerException e15) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e15);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused) {
                this.undecodedChunk.readerIndex(readerIndex);
                return null;
            }
        }
        Attribute attribute = this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
        if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
            if (attribute == null) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Filename not found");
            }
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus2 = HttpPostRequestDecoder.MultiPartStatus.MIXEDFILEUPLOAD;
            this.currentStatus = multiPartStatus2;
            return decodeMultipart(multiPartStatus2);
        }
        if (attribute != null) {
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus3 = HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD;
            this.currentStatus = multiPartStatus3;
            return decodeMultipart(multiPartStatus3);
        }
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus4 = HttpPostRequestDecoder.MultiPartStatus.FIELD;
        this.currentStatus = multiPartStatus4;
        return decodeMultipart(multiPartStatus4);
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyMultipart();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyMultipart() {
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null || byteBuf.readableBytes() == 0) {
            return;
        }
        InterfaceHttpData decodeMultipart = decodeMultipart(this.currentStatus);
        while (decodeMultipart != null) {
            addHttpData(decodeMultipart);
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
            if (multiPartStatus == HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE || multiPartStatus == HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
                return;
            } else {
                decodeMultipart = decodeMultipart(multiPartStatus);
            }
        }
    }

    private boolean skipOneLine() {
        if (!this.undecodedChunk.isReadable()) {
            return false;
        }
        byte readByte = this.undecodedChunk.readByte();
        if (readByte != 13) {
            if (readByte == 10) {
                return true;
            }
            ByteBuf byteBuf = this.undecodedChunk;
            byteBuf.readerIndex(byteBuf.readerIndex() - 1);
            return false;
        }
        if (!this.undecodedChunk.isReadable()) {
            ByteBuf byteBuf2 = this.undecodedChunk;
            byteBuf2.readerIndex(byteBuf2.readerIndex() - 1);
            return false;
        }
        if (this.undecodedChunk.readByte() == 10) {
            return true;
        }
        this.undecodedChunk.readerIndex(r0.readerIndex() - 2);
        return false;
    }

    private static String[] splitMultipartHeader(String str) {
        char charAt;
        ArrayList arrayList = new ArrayList(1);
        int findNonWhitespace = HttpPostBodyUtil.findNonWhitespace(str, 0);
        int i6 = findNonWhitespace;
        while (i6 < str.length() && (charAt = str.charAt(i6)) != ':' && !Character.isWhitespace(charAt)) {
            i6++;
        }
        int i7 = i6;
        while (true) {
            if (i7 >= str.length()) {
                break;
            }
            if (str.charAt(i7) == ':') {
                i7++;
                break;
            }
            i7++;
        }
        int findNonWhitespace2 = HttpPostBodyUtil.findNonWhitespace(str, i7);
        int findEndOfString = HttpPostBodyUtil.findEndOfString(str);
        arrayList.add(str.substring(findNonWhitespace, i6));
        String substring = findNonWhitespace2 >= findEndOfString ? "" : str.substring(findNonWhitespace2, findEndOfString);
        for (String str2 : substring.indexOf(59) >= 0 ? splitMultipartHeaderValues(substring) : substring.split(",")) {
            arrayList.add(str2.trim());
        }
        String[] strArr = new String[arrayList.size()];
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            strArr[i8] = (String) arrayList.get(i8);
        }
        return strArr;
    }

    protected void addHttpData(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData == null) {
            return;
        }
        List<InterfaceHttpData> list = this.bodyMapHttpData.get(interfaceHttpData.getName());
        if (list == null) {
            list = new ArrayList<>(1);
            this.bodyMapHttpData.put(interfaceHttpData.getName(), list);
        }
        list.add(interfaceHttpData);
        this.bodyListHttpData.add(interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData currentPartialHttpData() {
        FileUpload fileUpload = this.currentFileUpload;
        return fileUpload != null ? fileUpload : this.currentAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.discardThreshold;
    }

    protected InterfaceHttpData getFileUpload(String str) {
        String value;
        Attribute attribute = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
        Charset charset = this.charset;
        HttpPostBodyUtil.TransferEncodingMechanism transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BIT7;
        if (attribute != null) {
            try {
                String lowerCase = attribute.getValue().toLowerCase();
                if (lowerCase.equals(transferEncodingMechanism.value())) {
                    charset = CharsetUtil.US_ASCII;
                } else {
                    transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BIT8;
                    if (lowerCase.equals(transferEncodingMechanism.value())) {
                        charset = CharsetUtil.ISO_8859_1;
                    } else {
                        transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BINARY;
                        if (!lowerCase.equals(transferEncodingMechanism.value())) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException("TransferEncoding Unknown: " + lowerCase);
                        }
                    }
                }
            } catch (IOException e6) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e6);
            }
        }
        Attribute attribute2 = this.currentFieldAttributes.get(HttpHeaderValues.CHARSET);
        if (attribute2 != null) {
            try {
                charset = Charset.forName(attribute2.getValue());
            } catch (IOException e7) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e7);
            } catch (UnsupportedCharsetException e8) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e8);
            }
        }
        Charset charset2 = charset;
        if (this.currentFileUpload == null) {
            Attribute attribute3 = this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
            Attribute attribute4 = this.currentFieldAttributes.get(HttpHeaderValues.NAME);
            Attribute attribute5 = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TYPE);
            Attribute attribute6 = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_LENGTH);
            long j6 = 0;
            if (attribute6 != null) {
                try {
                    j6 = Long.parseLong(attribute6.getValue());
                } catch (IOException e9) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e9);
                } catch (NumberFormatException unused) {
                }
            }
            long j7 = j6;
            if (attribute5 != null) {
                try {
                    value = attribute5.getValue();
                } catch (IOException e10) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e10);
                } catch (IllegalArgumentException e11) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e11);
                } catch (NullPointerException e12) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e12);
                }
            } else {
                value = "application/octet-stream";
            }
            this.currentFileUpload = this.factory.createFileUpload(this.request, cleanString(attribute4.getValue()), cleanString(attribute3.getValue()), value, transferEncodingMechanism.value(), charset2, j7);
        }
        if (!loadDataMultipart(this.undecodedChunk, str, this.currentFileUpload) || !this.currentFileUpload.isCompleted()) {
            return null;
        }
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
            this.currentFieldAttributes = null;
        } else {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
            cleanMixedAttributes();
        }
        FileUpload fileUpload = this.currentFileUpload;
        this.currentFileUpload = null;
        return fileUpload;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public HttpPostMultipartRequestDecoder offer(HttpContent httpContent) {
        checkDestroyed();
        ByteBuf content = httpContent.content();
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null) {
            this.undecodedChunk = content.copy();
        } else {
            byteBuf.writeBytes(content);
        }
        if (httpContent instanceof LastHttpContent) {
            this.isLastChunk = true;
        }
        parseBody();
        ByteBuf byteBuf2 = this.undecodedChunk;
        if (byteBuf2 != null && byteBuf2.writerIndex() > this.discardThreshold) {
            this.undecodedChunk.discardReadBytes();
        }
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void setDiscardThreshold(int i6) {
        this.discardThreshold = ObjectUtil.checkPositiveOrZero(i6, "discardThreshold");
    }

    public HttpPostMultipartRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) {
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = 10485760;
        HttpRequest httpRequest2 = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.request = httpRequest2;
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        setMultipart(httpRequest2.headers().get(HttpHeaderNames.CONTENT_TYPE));
        if (httpRequest instanceof HttpContent) {
            offer((HttpContent) httpRequest);
        } else {
            this.undecodedChunk = Unpooled.buffer();
            parseBody();
        }
    }

    private static String cleanString(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt != '\t') {
                if (charAt != '\"') {
                    if (charAt != ',' && charAt != '=' && charAt != ':' && charAt != ';') {
                        sb.append(charAt);
                    }
                }
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    private static boolean loadDataMultipart(ByteBuf byteBuf, String str, HttpData httpData) {
        if (!byteBuf.hasArray()) {
            return loadDataMultipartStandard(byteBuf, str, httpData);
        }
        HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(byteBuf);
        int readerIndex = byteBuf.readerIndex();
        int length = str.length();
        int i6 = seekAheadOptimize.pos;
        boolean z5 = false;
        byte b6 = 10;
        int i7 = 0;
        while (true) {
            int i8 = seekAheadOptimize.pos;
            if (i8 >= seekAheadOptimize.limit) {
                break;
            }
            byte[] bArr = seekAheadOptimize.bytes;
            seekAheadOptimize.pos = i8 + 1;
            byte b7 = bArr[i8];
            int i9 = 1;
            if (b6 == 10 && b7 == str.codePointAt(i7)) {
                i7++;
                if (length == i7) {
                    z5 = true;
                    break;
                }
            } else {
                i6 = seekAheadOptimize.pos;
                if (b7 == 10) {
                    if (b6 == 13) {
                        i9 = 2;
                    }
                    i6 -= i9;
                    i7 = 0;
                }
                b6 = b7;
            }
        }
        if (b6 == 13) {
            i6--;
        }
        int readPosition = seekAheadOptimize.getReadPosition(i6);
        try {
            httpData.addContent(byteBuf.copy(readerIndex, readPosition - readerIndex), z5);
            byteBuf.readerIndex(readPosition);
            return z5;
        } catch (IOException e6) {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e6);
        }
    }

    private static boolean loadDataMultipartStandard(ByteBuf byteBuf, String str, HttpData httpData) {
        int readerIndex = byteBuf.readerIndex();
        int length = str.length();
        boolean z5 = false;
        int i6 = readerIndex;
        byte b6 = 10;
        int i7 = 0;
        while (true) {
            if (!byteBuf.isReadable()) {
                break;
            }
            byte readByte = byteBuf.readByte();
            int i8 = 1;
            if (b6 == 10 && readByte == str.codePointAt(i7)) {
                i7++;
                if (length == i7) {
                    z5 = true;
                    break;
                }
            } else {
                i6 = byteBuf.readerIndex();
                if (readByte == 10) {
                    if (b6 == 13) {
                        i8 = 2;
                    }
                    i6 -= i8;
                    i7 = 0;
                }
                b6 = readByte;
            }
        }
        if (b6 == 13) {
            i6--;
        }
        try {
            httpData.addContent(byteBuf.copy(readerIndex, i6 - readerIndex), z5);
            byteBuf.readerIndex(i6);
            return z5;
        } catch (IOException e6) {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e6);
        }
    }

    private static String readDelimiter(ByteBuf byteBuf, String str) {
        int i6;
        int i7;
        if (!byteBuf.hasArray()) {
            return readDelimiterStandard(byteBuf, str);
        }
        HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(byteBuf);
        int readerIndex = byteBuf.readerIndex();
        int length = str.length();
        try {
            StringBuilder sb = new StringBuilder(64);
            int i8 = 0;
            while (true) {
                i6 = seekAheadOptimize.pos;
                i7 = seekAheadOptimize.limit;
                if (i6 >= i7 || i8 >= length) {
                    break;
                }
                byte[] bArr = seekAheadOptimize.bytes;
                seekAheadOptimize.pos = i6 + 1;
                byte b6 = bArr[i6];
                if (b6 == str.charAt(i8)) {
                    i8++;
                    sb.append((char) b6);
                } else {
                    byteBuf.readerIndex(readerIndex);
                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                }
            }
            if (i6 < i7) {
                byte[] bArr2 = seekAheadOptimize.bytes;
                int i9 = i6 + 1;
                seekAheadOptimize.pos = i9;
                byte b7 = bArr2[i6];
                if (b7 == 13) {
                    if (i9 < i7) {
                        seekAheadOptimize.pos = i6 + 2;
                        if (bArr2[i9] == 10) {
                            seekAheadOptimize.setReadPosition(0);
                            return sb.toString();
                        }
                        byteBuf.readerIndex(readerIndex);
                        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                    }
                    byteBuf.readerIndex(readerIndex);
                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                }
                if (b7 == 10) {
                    seekAheadOptimize.setReadPosition(0);
                    return sb.toString();
                }
                if (b7 == 45) {
                    sb.append('-');
                    int i10 = seekAheadOptimize.pos;
                    if (i10 < seekAheadOptimize.limit) {
                        byte[] bArr3 = seekAheadOptimize.bytes;
                        seekAheadOptimize.pos = i10 + 1;
                        if (bArr3[i10] == 45) {
                            sb.append('-');
                            int i11 = seekAheadOptimize.pos;
                            int i12 = seekAheadOptimize.limit;
                            if (i11 < i12) {
                                byte[] bArr4 = seekAheadOptimize.bytes;
                                int i13 = i11 + 1;
                                seekAheadOptimize.pos = i13;
                                byte b8 = bArr4[i11];
                                if (b8 == 13) {
                                    if (i13 < i12) {
                                        seekAheadOptimize.pos = i11 + 2;
                                        if (bArr4[i13] == 10) {
                                            seekAheadOptimize.setReadPosition(0);
                                            return sb.toString();
                                        }
                                        byteBuf.readerIndex(readerIndex);
                                        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                                    }
                                    byteBuf.readerIndex(readerIndex);
                                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                                }
                                if (b8 == 10) {
                                    seekAheadOptimize.setReadPosition(0);
                                    return sb.toString();
                                }
                                seekAheadOptimize.setReadPosition(1);
                                return sb.toString();
                            }
                            seekAheadOptimize.setReadPosition(0);
                            return sb.toString();
                        }
                    }
                }
            }
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        } catch (IndexOutOfBoundsException e6) {
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e6);
        }
    }

    private static String readDelimiterStandard(ByteBuf byteBuf, String str) {
        int readerIndex = byteBuf.readerIndex();
        try {
            StringBuilder sb = new StringBuilder(64);
            int length = str.length();
            int i6 = 0;
            while (byteBuf.isReadable() && i6 < length) {
                char readByte = byteBuf.readByte();
                if (readByte == str.charAt(i6)) {
                    i6++;
                    sb.append(readByte);
                } else {
                    byteBuf.readerIndex(readerIndex);
                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                }
            }
            if (byteBuf.isReadable()) {
                byte readByte2 = byteBuf.readByte();
                if (readByte2 == 13) {
                    if (byteBuf.readByte() == 10) {
                        return sb.toString();
                    }
                    byteBuf.readerIndex(readerIndex);
                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                }
                if (readByte2 == 10) {
                    return sb.toString();
                }
                if (readByte2 == 45) {
                    sb.append('-');
                    if (byteBuf.readByte() == 45) {
                        sb.append('-');
                        if (byteBuf.isReadable()) {
                            byte readByte3 = byteBuf.readByte();
                            if (readByte3 == 13) {
                                if (byteBuf.readByte() == 10) {
                                    return sb.toString();
                                }
                                byteBuf.readerIndex(readerIndex);
                                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                            }
                            if (readByte3 == 10) {
                                return sb.toString();
                            }
                            byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                            return sb.toString();
                        }
                        return sb.toString();
                    }
                }
            }
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        } catch (IndexOutOfBoundsException e6) {
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e6);
        }
    }

    private static String readLine(ByteBuf byteBuf, Charset charset) {
        if (!byteBuf.hasArray()) {
            return readLineStandard(byteBuf, charset);
        }
        HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(byteBuf);
        int readerIndex = byteBuf.readerIndex();
        try {
            ByteBuf buffer = Unpooled.buffer(64);
            while (true) {
                int i6 = seekAheadOptimize.pos;
                int i7 = seekAheadOptimize.limit;
                if (i6 < i7) {
                    byte[] bArr = seekAheadOptimize.bytes;
                    int i8 = i6 + 1;
                    seekAheadOptimize.pos = i8;
                    byte b6 = bArr[i6];
                    if (b6 == 13) {
                        if (i8 < i7) {
                            seekAheadOptimize.pos = i6 + 2;
                            if (bArr[i8] == 10) {
                                seekAheadOptimize.setReadPosition(0);
                                return buffer.toString(charset);
                            }
                            seekAheadOptimize.pos = i6 + 1;
                            buffer.writeByte(13);
                        } else {
                            buffer.writeByte(b6);
                        }
                    } else {
                        if (b6 == 10) {
                            seekAheadOptimize.setReadPosition(0);
                            return buffer.toString(charset);
                        }
                        buffer.writeByte(b6);
                    }
                } else {
                    byteBuf.readerIndex(readerIndex);
                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                }
            }
        } catch (IndexOutOfBoundsException e6) {
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e6);
        }
    }

    private static String readLineStandard(ByteBuf byteBuf, Charset charset) {
        int readerIndex = byteBuf.readerIndex();
        try {
            ByteBuf buffer = Unpooled.buffer(64);
            while (byteBuf.isReadable()) {
                byte readByte = byteBuf.readByte();
                if (readByte == 13) {
                    if (byteBuf.getByte(byteBuf.readerIndex()) == 10) {
                        byteBuf.readByte();
                        return buffer.toString(charset);
                    }
                    buffer.writeByte(13);
                } else {
                    if (readByte == 10) {
                        return buffer.toString(charset);
                    }
                    buffer.writeByte(readByte);
                }
            }
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        } catch (IndexOutOfBoundsException e6) {
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e6);
        }
    }

    private void setMultipart(String str) {
        String str2;
        String[] multipartDataBoundary = HttpPostRequestDecoder.getMultipartDataBoundary(str);
        if (multipartDataBoundary != null) {
            this.multipartDataBoundary = multipartDataBoundary[0];
            if (multipartDataBoundary.length > 1 && (str2 = multipartDataBoundary[1]) != null) {
                this.charset = Charset.forName(str2);
            }
        } else {
            this.multipartDataBoundary = null;
        }
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
    }

    private static void skipControlCharacters(ByteBuf byteBuf) {
        if (!byteBuf.hasArray()) {
            try {
                skipControlCharactersStandard(byteBuf);
                return;
            } catch (IndexOutOfBoundsException e6) {
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e6);
            }
        }
        HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(byteBuf);
        while (true) {
            int i6 = seekAheadOptimize.pos;
            if (i6 < seekAheadOptimize.limit) {
                byte[] bArr = seekAheadOptimize.bytes;
                seekAheadOptimize.pos = i6 + 1;
                char c6 = (char) (bArr[i6] & 255);
                if (!Character.isISOControl(c6) && !Character.isWhitespace(c6)) {
                    seekAheadOptimize.setReadPosition(1);
                    return;
                }
            } else {
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException("Access out of bounds");
            }
        }
    }

    private static void skipControlCharactersStandard(ByteBuf byteBuf) {
        while (true) {
            char readUnsignedByte = (char) byteBuf.readUnsignedByte();
            if (!Character.isISOControl(readUnsignedByte) && !Character.isWhitespace(readUnsignedByte)) {
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return;
            }
        }
    }

    private static String[] splitMultipartHeaderValues(String str) {
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList(1);
        int i6 = 0;
        boolean z5 = false;
        boolean z6 = false;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char charAt = str.charAt(i7);
            if (z5) {
                if (z6) {
                    z6 = false;
                } else if (charAt == '\\') {
                    z6 = true;
                } else if (charAt == '\"') {
                    z5 = false;
                }
            } else if (charAt == '\"') {
                z5 = true;
            } else if (charAt == ';') {
                arrayList.add(str.substring(i6, i7));
                i6 = i7 + 1;
            }
        }
        arrayList.add(str.substring(i6));
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void cleanFiles() {
        checkDestroyed();
        this.factory.cleanRequestHttpData(this.request);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void destroy() {
        checkDestroyed();
        cleanFiles();
        this.destroyed = true;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf != null && byteBuf.refCnt() > 0) {
            this.undecodedChunk.release();
            this.undecodedChunk = null;
        }
        for (int i6 = this.bodyListHttpDataRank; i6 < this.bodyListHttpData.size(); i6++) {
            this.bodyListHttpData.get(i6).release();
        }
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData getBodyHttpData(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            List<InterfaceHttpData> list = this.bodyMapHttpData.get(str);
            if (list != null) {
                return list.get(0);
            }
            return null;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean hasNext() {
        checkDestroyed();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.EPILOGUE && this.bodyListHttpDataRank >= this.bodyListHttpData.size()) {
            throw new HttpPostRequestDecoder.EndOfDataDecoderException();
        }
        if (!this.bodyListHttpData.isEmpty() && this.bodyListHttpDataRank < this.bodyListHttpData.size()) {
            return true;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean isMultipart() {
        checkDestroyed();
        return true;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData next() {
        checkDestroyed();
        if (hasNext()) {
            List<InterfaceHttpData> list = this.bodyListHttpData;
            int i6 = this.bodyListHttpDataRank;
            this.bodyListHttpDataRank = i6 + 1;
            return list.get(i6);
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData) {
        checkDestroyed();
        this.factory.removeHttpDataFromClean(this.request, interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyMapHttpData.get(str);
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }
}
