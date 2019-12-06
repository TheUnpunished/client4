package ru.kpfu.icmit.client4.model;

import lombok.*;
import ru.kpfu.icmit.client4.model.soap.Content;
import ru.kpfu.icmit.client4.util.TimestampAdapter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class Nomenclature extends Content {
    private Long id;
    private UUID uid;
    private String productName;
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp createDate;
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp modifyDate;
    private Metric metric;
    private Boolean relevant;

    public Nomenclature(String productName, Metric metric) {
        this.uid = UUID.randomUUID();
        this.createDate = new Timestamp(System.currentTimeMillis());
        this.modifyDate = new Timestamp(System.currentTimeMillis());
        this.productName = productName;
        this.metric = metric;
        this.relevant = true;
    }
}
