package ru.kpfu.icmit.client4;

import ru.kpfu.icmit.client4.model.Nomenclature;
import ru.kpfu.icmit.client4.util.soap.Envelope;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class SOAPSender {

    public void send(InputStream inputStream) {
        try {
            URL url = new URL("http://185.20.227.163:8080/server4/nomenclature/add");
//            URL url = new URL("http://localhost:8080/server4/nomenclature/add");
//            разприбаздан (на английском)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/xml");
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] buf = new byte[2048];
                int r = 0;
                while ((r = inputStream.read(buf)) != -1) {
                    os.write(buf,0,r);
                }
                os.flush();
            }
            int rcode = connection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String env = "";
            while (bufferedReader.ready()){
                env += bufferedReader.readLine();
            }
            System.out.println(env);
            JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Envelope envelope = (Envelope) unmarshaller.unmarshal(new ByteArrayInputStream(env.getBytes(Charset.defaultCharset())));
            Nomenclature nomenclature = (Nomenclature) envelope.getBody().getContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
