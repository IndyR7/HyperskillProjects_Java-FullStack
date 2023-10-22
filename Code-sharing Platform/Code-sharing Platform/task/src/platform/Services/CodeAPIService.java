package platform.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import platform.DTO.CodeCreationSuccessResponse;
import platform.DTO.CreateCodeRequest;
import platform.DTO.GetCodeResponse;
import platform.Entities.Code;
import platform.Repositories.CodeRepository;

import java.util.List;

@Service
public class CodeAPIService {
    private final CodeRepository codeRepository;
    private final CodeUpdaterService codeUpdaterService;

    @Autowired
    public CodeAPIService(CodeRepository codeRepository, CodeUpdaterService codeUpdaterService) {
        this.codeRepository = codeRepository;
        this.codeUpdaterService = codeUpdaterService;
    }

    public ResponseEntity<GetCodeResponse> getCodeApi(String uuid) {
        Code code = codeUpdaterService.getCodeUpdated(uuid);

        return ResponseEntity.ok(new GetCodeResponse(code));
    }

    public ResponseEntity<CodeCreationSuccessResponse> postNewCode(CreateCodeRequest request) {
        Code code = codeUpdaterService.getInitialCode(request);

        codeRepository.save(code);

        return ResponseEntity.ok(new CodeCreationSuccessResponse(code));
    }

    public ResponseEntity<List<GetCodeResponse>> getLast10UploadedCode() {
        List<GetCodeResponse> last10 = codeRepository.findTop10BySecretFalseOrderByDateDesc().stream()
                .map(GetCodeResponse::new)
                .toList();

        return ResponseEntity.ok(last10);
    }
}