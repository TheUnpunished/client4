package ru.kpfu.icmit.client4;

import ru.kpfu.icmit.client4.model.Metric;
import ru.kpfu.icmit.client4.model.Nomenclature;
import ru.kpfu.icmit.client4.util.soap.Body;
import ru.kpfu.icmit.client4.util.soap.Envelope;
import ru.kpfu.icmit.client4.util.soap.Header;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.UUID;

public class SOAPMain {

    public static void main(String[] args) {

        String envelope = createEnvelope();

        //Envelope envelope = readEnvelope();
        //System.out.println(envelope);
        SOAPSender sender = new SOAPSender();
        sender.send(new ByteArrayInputStream(envelope.getBytes(Charset.defaultCharset())));
    }

    public static String createEnvelope() {

        Envelope envelope = new Envelope();
        Header header = new Header();
        Body body = new Body();
        envelope.setHeader(header);
        envelope.setBody(body);

        Nomenclature nomenclature = Nomenclature.builder()
                .uid(UUID.randomUUID())
                .metric(new Metric("0001", "метры"))
                .productName("Ж/Д Вагон 2")
                .build();
        body.setContent(nomenclature);
        try {
            JAXBContext context = JAXBContext.newInstance(Envelope.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(envelope, stringWriter);
            return stringWriter.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Envelope readEnvelope() {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Envelope) un.unmarshal(new File("envelope.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
   }
}
