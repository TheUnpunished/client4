package ru.kpfu.icmit.client4.util.soap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.icmit.server4.model.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Body {

    @XmlElements(value = {
            @XmlElement(name = "nomenclature", type = Nomenclature.class),
            @XmlElement(name = "items", type = XmlList.class),
            @XmlElement(name = "contract", type = Contract.class),
            @XmlElement(name = "demand", type = Demand.class),
            @XmlElement(name = "metric", type = Metric.class),
            @XmlElement(name = "offer", type = Offer.class),
            @XmlElement(name = "organization", type = Organization.class)
    })

    private Content content;


    @Override
    public String toString() {
        return "Body{" +
                "content=" + content +
                '}';
    }
}
