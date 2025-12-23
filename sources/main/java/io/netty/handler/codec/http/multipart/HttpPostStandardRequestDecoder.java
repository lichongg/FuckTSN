package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpPostStandardRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private final Charset charset;
    private Attribute currentAttribute;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    public HttpPostStandardRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384L), httpRequest, HttpConstants.DEFAULT_CHARSET);
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
    /* renamed from: io.netty.handler.codec.http.multipart.HttpPostStandardRequestDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus;

        static {
            int[] iArr = new int[HttpPostRequestDecoder.MultiPartStatus.values().length];
            $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus = iArr;
            try {
                iArr[HttpPostRequestDecoder.MultiPartStatus.DISPOSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            throw new IllegalStateException(HttpPostStandardRequestDecoder.class.getSimpleName() + " was destroyed already");
        }
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyAttributes();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyAttributes() {
        int i6;
        boolean z5;
        Attribute attribute;
        Attribute attribute2;
        int i7;
        if (!this.undecodedChunk.hasArray()) {
            parseBodyAttributesStandard();
            return;
        }
        HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
        int readerIndex = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
        }
        loop0: while (true) {
            i6 = readerIndex;
            while (true) {
                try {
                    int i8 = seekAheadOptimize.pos;
                    z5 = true;
                    if (i8 >= seekAheadOptimize.limit) {
                        break loop0;
                    }
                    byte[] bArr = seekAheadOptimize.bytes;
                    seekAheadOptimize.pos = i8 + 1;
                    char c6 = (char) (bArr[i8] & 255);
                    i7 = readerIndex + 1;
                    int i9 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
                    if (i9 != 1) {
                        if (i9 != 2) {
                            seekAheadOptimize.setReadPosition(0);
                            readerIndex = i7;
                            break loop0;
                        }
                        if (c6 == '&') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                            setFinalBuffer(this.undecodedChunk.copy(i6, readerIndex - i6));
                            break;
                        }
                        if (c6 == '\r') {
                            int i10 = seekAheadOptimize.pos;
                            int i11 = seekAheadOptimize.limit;
                            if (i10 < i11) {
                                byte[] bArr2 = seekAheadOptimize.bytes;
                                seekAheadOptimize.pos = i10 + 1;
                                char c7 = (char) (bArr2[i10] & 255);
                                i7 = readerIndex + 2;
                                if (c7 != '\n') {
                                    seekAheadOptimize.setReadPosition(0);
                                    throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                                }
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                seekAheadOptimize.setReadPosition(0);
                                setFinalBuffer(this.undecodedChunk.copy(i6, readerIndex - i6));
                            } else if (i11 <= 0) {
                                readerIndex = i7;
                            }
                        } else {
                            if (c6 == '\n') {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                seekAheadOptimize.setReadPosition(0);
                                setFinalBuffer(this.undecodedChunk.copy(i6, readerIndex - i6));
                                break loop0;
                            }
                            readerIndex = i7;
                        }
                    } else {
                        if (c6 == '=') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                            this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i6, readerIndex - i6, this.charset), this.charset));
                            break;
                        }
                        if (c6 == '&') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                            Attribute createAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i6, readerIndex - i6, this.charset), this.charset));
                            this.currentAttribute = createAttribute;
                            createAttribute.setValue("");
                            addHttpData(this.currentAttribute);
                            this.currentAttribute = null;
                            break;
                        }
                        readerIndex = i7;
                    }
                } catch (HttpPostRequestDecoder.ErrorDataDecoderException e6) {
                    e = e6;
                } catch (IOException e7) {
                    e = e7;
                } catch (IllegalArgumentException e8) {
                    e = e8;
                }
            }
            readerIndex = i7;
        }
        readerIndex = i7;
        i6 = readerIndex;
        z5 = false;
        if (!this.isLastChunk || (attribute2 = this.currentAttribute) == null) {
            if (z5 && (attribute = this.currentAttribute) != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
                attribute.addContent(this.undecodedChunk.copy(i6, readerIndex - i6), false);
            }
            this.undecodedChunk.readerIndex(i6);
        }
        if (readerIndex > i6) {
            setFinalBuffer(this.undecodedChunk.copy(i6, readerIndex - i6));
        } else if (!attribute2.isCompleted()) {
            setFinalBuffer(Unpooled.EMPTY_BUFFER);
        }
        try {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        } catch (HttpPostRequestDecoder.ErrorDataDecoderException e9) {
            e = e9;
            i6 = readerIndex;
            this.undecodedChunk.readerIndex(i6);
            throw e;
        } catch (IOException e10) {
            e = e10;
            i6 = readerIndex;
            this.undecodedChunk.readerIndex(i6);
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
        } catch (IllegalArgumentException e11) {
            e = e11;
            i6 = readerIndex;
            this.undecodedChunk.readerIndex(i6);
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
        }
        i6 = readerIndex;
        this.undecodedChunk.readerIndex(i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ef, code lost:
    
        if (r10.isLastChunk == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f1, code lost:
    
        r1 = r10.currentAttribute;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f3, code lost:
    
        if (r1 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f5, code lost:
    
        if (r0 <= r2) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f7, code lost:
    
        setFinalBuffer(r10.undecodedChunk.copy(r2, r0 - r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x010e, code lost:
    
        r10.currentStatus = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0134, code lost:
    
        r10.undecodedChunk.readerIndex(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0139, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0117, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0118, code lost:
    
        r2 = r0;
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0145, code lost:
    
        r10.undecodedChunk.readerIndex(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x014a, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0113, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0114, code lost:
    
        r2 = r0;
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x013a, code lost:
    
        r10.undecodedChunk.readerIndex(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0144, code lost:
    
        throw new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.ErrorDataDecoderException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0107, code lost:
    
        if (r1.isCompleted() != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0109, code lost:
    
        setFinalBuffer(io.netty.buffer.Unpooled.EMPTY_BUFFER);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x011b, code lost:
    
        if (r3 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x011d, code lost:
    
        r1 = r10.currentAttribute;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011f, code lost:
    
        if (r1 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0125, code lost:
    
        if (r10.currentStatus != io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.FIELD) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0127, code lost:
    
        r1.addContent(r10.undecodedChunk.copy(r2, r0 - r2), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0133, code lost:
    
        r0 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseBodyAttributesStandard() {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostStandardRequestDecoder.parseBodyAttributesStandard():void");
    }

    private void setFinalBuffer(ByteBuf byteBuf) throws IOException {
        this.currentAttribute.addContent(byteBuf, true);
        this.currentAttribute.setValue(decodeAttribute(this.currentAttribute.getByteBuf().toString(this.charset), this.charset));
        addHttpData(this.currentAttribute);
        this.currentAttribute = null;
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
        return this.currentAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.discardThreshold;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public HttpPostStandardRequestDecoder offer(HttpContent httpContent) {
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

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) {
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = 10485760;
        this.request = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        if (httpRequest instanceof HttpContent) {
            offer((HttpContent) httpRequest);
        } else {
            this.undecodedChunk = Unpooled.buffer();
            parseBody();
        }
    }

    private static String decodeAttribute(String str, Charset charset) {
        try {
            return QueryStringDecoder.decodeComponent(str, charset);
        } catch (IllegalArgumentException e6) {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad string: '" + str + '\'', e6);
        }
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void cleanFiles() {
        checkDestroyed();
        this.factory.cleanRequestHttpData(this.request);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void destroy() {
        cleanFiles();
        this.destroyed = true;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf != null && byteBuf.refCnt() > 0) {
            this.undecodedChunk.release();
            this.undecodedChunk = null;
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
        return false;
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
