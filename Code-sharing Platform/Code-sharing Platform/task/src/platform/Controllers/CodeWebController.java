package platform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.Services.CodeWebService;

@Controller
@RequestMapping(value = "/code")
public class CodeWebController {
    private final CodeWebService codeService;

    @Autowired
    public CodeWebController(CodeWebService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "/{uuid}", produces = "text/html")
    public String getCodePage(Model model, @PathVariable String uuid) {
        return codeService.getCodePage(model, uuid);
    }

    @GetMapping(value ="/new", produces = "text/html")
    public String getNewCodePage() {
        return codeService.getNewCodePage();
    }

    @GetMapping(value = "/latest", produces = "text/html")
    public String getLast10UploadedCode(Model model) {
        return codeService.getLast10UploadedCode(model);
    }
}