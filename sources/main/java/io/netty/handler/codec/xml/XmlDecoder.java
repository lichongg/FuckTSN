package io.netty.handler.codec.xml;

import com.fasterxml.aalto.AsyncByteArrayFeeder;
import com.fasterxml.aalto.AsyncXMLInputFactory;
import com.fasterxml.aalto.AsyncXMLStreamReader;
import com.fasterxml.aalto.stax.InputFactoryImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import javax.xml.stream.XMLStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class XmlDecoder extends ByteToMessageDecoder {
    private final AsyncByteArrayFeeder streamFeeder;
    private final AsyncXMLStreamReader<AsyncByteArrayFeeder> streamReader;
    private static final AsyncXMLInputFactory XML_INPUT_FACTORY = new InputFactoryImpl();
    private static final XmlDocumentEnd XML_DOCUMENT_END = XmlDocumentEnd.INSTANCE;

    public XmlDecoder() {
        AsyncXMLStreamReader<AsyncByteArrayFeeder> createAsyncForByteArray = XML_INPUT_FACTORY.createAsyncForByteArray();
        this.streamReader = createAsyncForByteArray;
        this.streamFeeder = createAsyncForByteArray.getInputFeeder();
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        byte[] bArr = new byte[readableBytes];
        byteBuf.readBytes(bArr);
        try {
            this.streamFeeder.feedInput(bArr, 0, readableBytes);
            while (!this.streamFeeder.needMoreInput()) {
                switch (this.streamReader.next()) {
                    case 1:
                        XmlElementStart xmlElementStart = new XmlElementStart(this.streamReader.getLocalName(), this.streamReader.getName().getNamespaceURI(), this.streamReader.getPrefix());
                        for (int i6 = 0; i6 < this.streamReader.getAttributeCount(); i6++) {
                            xmlElementStart.attributes().add(new XmlAttribute(this.streamReader.getAttributeType(i6), this.streamReader.getAttributeLocalName(i6), this.streamReader.getAttributePrefix(i6), this.streamReader.getAttributeNamespace(i6), this.streamReader.getAttributeValue(i6)));
                        }
                        for (int i7 = 0; i7 < this.streamReader.getNamespaceCount(); i7++) {
                            xmlElementStart.namespaces().add(new XmlNamespace(this.streamReader.getNamespacePrefix(i7), this.streamReader.getNamespaceURI(i7)));
                        }
                        list.add(xmlElementStart);
                        break;
                    case 2:
                        XmlElementEnd xmlElementEnd = new XmlElementEnd(this.streamReader.getLocalName(), this.streamReader.getName().getNamespaceURI(), this.streamReader.getPrefix());
                        for (int i8 = 0; i8 < this.streamReader.getNamespaceCount(); i8++) {
                            xmlElementEnd.namespaces().add(new XmlNamespace(this.streamReader.getNamespacePrefix(i8), this.streamReader.getNamespaceURI(i8)));
                        }
                        list.add(xmlElementEnd);
                        break;
                    case 3:
                        list.add(new XmlProcessingInstruction(this.streamReader.getPIData(), this.streamReader.getPITarget()));
                        break;
                    case 4:
                        list.add(new XmlCharacters(this.streamReader.getText()));
                        break;
                    case 5:
                        list.add(new XmlComment(this.streamReader.getText()));
                        break;
                    case 6:
                        list.add(new XmlSpace(this.streamReader.getText()));
                        break;
                    case 7:
                        list.add(new XmlDocumentStart(this.streamReader.getEncoding(), this.streamReader.getVersion(), this.streamReader.isStandalone(), this.streamReader.getCharacterEncodingScheme()));
                        break;
                    case 8:
                        list.add(XML_DOCUMENT_END);
                        break;
                    case 9:
                        list.add(new XmlEntityReference(this.streamReader.getLocalName(), this.streamReader.getText()));
                        break;
                    case 11:
                        list.add(new XmlDTD(this.streamReader.getText()));
                        break;
                    case 12:
                        list.add(new XmlCdata(this.streamReader.getText()));
                        break;
                }
            }
        } catch (XMLStreamException e6) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            throw e6;
        }
    }
}
