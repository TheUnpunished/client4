package ru.kpfu.icmit.client4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.icmit.client4.util.MyDateFormat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class NomenclatureController {

    private SimpleDateFormat simpleDateFormat = MyDateFormat.format;


    @RequestMapping(value = "/nomenclature", method = RequestMethod.GET)
    public String getNomenclatureList(@ModelAttribute("model") ModelMap model) {

        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(simpleDateFormat.parse("2019-01-01T00:00:00.0+03:00").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
//
//        List<Nomenclature> nomenclatures = nomenclatureRepository.getNomenclature(timestamp);
//
//        model.addAttribute("reqdate", "2019-01-01T00:00:00.0+03:00");
//        model.addAttribute("nomenclatures", nomenclatures);
//
//        System.out.println("nomenclatures" + nomenclatures);

        return "/dict/nomenclature";
    }


    @RequestMapping(value = "/nomenclature/add", method = RequestMethod.GET)
    public String addNomenclature(ModelMap model) {

        return "/dict/addnomenclature";
    }

    @RequestMapping(value = "/addnewnom", method = RequestMethod.POST)
    public String addNewNom(@ModelAttribute("model") ModelMap model,
                            @RequestParam Map<String,String> body) {
        System.out.println(body);
        String name = body.get("name");

        model.put("nomname", name !=null? name : "yyruytuyt");


        // отправить  в Ц БД
        // получить ответ
        // добавить в Л БД


        System.out.println(name);

        return "/dict/nomsuccess";
    }

}