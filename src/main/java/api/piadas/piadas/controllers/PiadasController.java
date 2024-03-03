package api.piadas.piadas.controllers;

import api.piadas.piadas.data.PiadaDAO;
import api.piadas.piadas.services.PiadasService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("piadas")
public class PiadasController {
    private final PiadasService service;

    public PiadasController(PiadasService service) {
        this.service = service;
    }

    @GetMapping("/random")
    @ResponseBody
    public PiadaDAO piadaRandom(){
        return service.getPiadaRandom();
    }

    @GetMapping("/random/ten")
    @ResponseBody
    public List<PiadaDAO> TenPiadas(){
        return service.getMultiPiadasRandom(10);
    }
}
