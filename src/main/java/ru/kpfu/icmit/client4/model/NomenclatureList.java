package ru.kpfu.icmit.client4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.icmit.client4.model.soap.Content;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class NomenclatureList extends Content {

    @XmlElementWrapper(name = "nomenclatures")
    @XmlElement(name = "nomenclature")
    private List<Nomenclature> nomenclatureList;


}
