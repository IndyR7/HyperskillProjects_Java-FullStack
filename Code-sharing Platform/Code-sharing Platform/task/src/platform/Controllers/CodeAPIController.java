package platform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import platform.DTO.CodeCreationSuccessResponse;
import platform.DTO.CreateCodeRequest;
import platform.DTO.GetCodeResponse;
import platform.Services.CodeAPIService;

import java.util.List;

@RestController
@RequestMapping("/api/code")
public class CodeAPIController {
    private final CodeAPIService codeService;

    @Autowired
    public CodeAPIController(CodeAPIService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "/{uuid}", produces = "application/json")
    public ResponseEntity<GetCodeResponse> getCodeApi(@PathVariable String uuid) {
        return codeService.getCodeApi(uuid);
    }

    @PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity<CodeCreationSuccessResponse> postNewCode(@RequestBody CreateCodeRequest request) {
        return codeService.postNewCode(request);
    }

    @GetMapping(value = "/latest", produces = "application/json")
    public ResponseEntity<List<GetCodeResponse>> getLast10UploadedCode() {
        return codeService.getLast10UploadedCode();
    }
}