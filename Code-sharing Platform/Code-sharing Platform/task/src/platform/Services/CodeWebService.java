package platform.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import platform.DTO.GetCodeResponse;
import platform.Entities.Code;
import platform.Repositories.CodeRepository;

import java.util.List;

@Service
public class CodeWebService {
    private final CodeRepository codeRepository;
    private final CodeUpdaterService codeUpdaterService;

    @Autowired
    public CodeWebService(CodeRepository codeRepository, CodeUpdaterService codeUpdaterService) {
        this.codeRepository = codeRepository;
        this.codeUpdaterService = codeUpdaterService;
    }

    public String getCodePage(Model model, String uuid) {
        Code code = codeUpdaterService.getCodeUpdated(uuid);

        GetCodeResponse response = new GetCodeResponse(code);

        model.addAttribute("code", response.getCode());
        model.addAttribute("date", response.getDate());
        model.addAttribute("has_views_restriction", code.getInitialViews() > 0);
        model.addAttribute("has_time_restriction", code.getInitialTime() > 0);
        model.addAttribute("time_restriction", response.getTime());
        model.addAttribute("views_restriction", response.getViews());

        return "code";
    }

    public String getNewCodePage() {
        return "new_code";
    }

    public String getLast10UploadedCode(Model model) {
        List<GetCodeResponse> codeResponses = codeRepository.findTop10BySecretFalseOrderByDateDesc().stream()
                .map(GetCodeResponse::new)
                .toList();

        model.addAttribute("codeResponses", codeResponses);

        return "latest_codes";
    }
}