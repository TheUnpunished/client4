package ru.kpfu.icmit.client4;

import ru.kpfu.icmit.client4.model.Nomenclature;
import ru.kpfu.icmit.client4.model.soap.Body;
import ru.kpfu.icmit.client4.model.soap.Envelope;
import ru.kpfu.icmit.client4.model.soap.Header;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Timestamp;

public class SOAPMain {

    public static void main(String[] args) {

        createEnvelope();

        //Envelope envelope = readEnvelope();
        //System.out.println(envelope);
        SOAPSender sender = new SOAPSender();
        sender.sendNomenclature(new File("envelope.xml"));
    }

    public static void createEnvelope() {

        Envelope envelope = new Envelope();
        Header header = new Header();
        Body body = new Body();
        envelope.setHeader(header);
        envelope.setBody(body);

        Nomenclature nomenclature = Nomenclature.builder()
                .productName("Ж/Д Вагон")
                .createDate(new Timestamp(System.currentTimeMillis()))
                .modifyDate(new Timestamp(System.currentTimeMillis()))
                .build();

        body.setContent(nomenclature);

        try {
            JAXBContext context = JAXBContext.newInstance(Envelope.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(envelope, new File("envelope.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
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
