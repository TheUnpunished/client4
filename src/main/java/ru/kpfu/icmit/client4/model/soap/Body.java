package ru.kpfu.icmit.client4.model.soap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.icmit.client4.model.Contract;
import ru.kpfu.icmit.client4.model.Nomenclature;
import ru.kpfu.icmit.client4.model.NomenclatureList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Body {

    @XmlElements({
            @XmlElement(name = "nomenclature", type = Nomenclature.class),
            @XmlElement(name = "nomenclatures", type = NomenclatureList.class),
            @XmlElement(name = "contract", type = Contract.class)
    })

    private Content content;

    @Override
    public String toString() {
        return "Body{" +
                "content=" + content +
                '}';
    }
}
