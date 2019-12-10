package ru.kpfu.icmit.client4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.icmit.client4.util.MyDateFormat;
import ru.kpfu.icmit.client4.util.TimestampAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@SequenceGenerator(name = "idGenerator", sequenceName = "nomenclature_seq", allocationSize=1)
public class Nomenclature extends IdEntity {
    private UUID uid;
    private String productName;
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp createDate;
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp modifyDate;

    @ManyToOne
    @JoinColumns(value = {@JoinColumn(referencedColumnName = "id")},
            foreignKey = @ForeignKey(name = "fk_nomenclature_metric"))
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

    @Override
    public String toString(){
        String relevantString = relevant? "Открыта" : "Закрыта";
        return "Товар: " + productName + " - "
                + "Создан: " + MyDateFormat.format.format(createDate) + " - "
                + "Обновлён: " + MyDateFormat.format.format(modifyDate) + " - "
                + metric.toString() + " - "
                + relevantString;
    }
}
