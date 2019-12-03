package ru.kpfu.icmit.client4.model.soap;

import ru.kpfu.icmit.client4.model.Contract;
import ru.kpfu.icmit.client4.model.Nomenclature;
import ru.kpfu.icmit.client4.model.NomenclatureList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class Body {
    private Content content;

    @XmlElements({
            @XmlElement(name = "nomenclature", type = Nomenclature.class),
            @XmlElement(name = "nomenclatures", type = NomenclatureList.class),
            @XmlElement(name = "contract", type = Contract.class)
    })
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Body{" +
                "content=" + content +
                '}';
    }
}
