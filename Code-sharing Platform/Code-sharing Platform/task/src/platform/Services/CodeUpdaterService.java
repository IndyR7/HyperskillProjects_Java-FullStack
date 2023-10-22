package platform.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.DTO.CreateCodeRequest;
import platform.Entities.Code;
import platform.Exceptions.CodeNotFoundException;
import platform.Repositories.CodeRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CodeUpdaterService {
    private final CodeRepository codeRepository;

    @Autowired
    public CodeUpdaterService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    protected Code getInitialCode(CreateCodeRequest request) {
        Code code = new Code();

        code.setCode(request.getCode());
        code.setDate(LocalDateTime.now());
        code.setUuid(UUID.randomUUID().toString());
        code.setInitialTime(request.getTime());
        code.setTimeLeft(request.getTime());
        code.setViewsLeft(request.getViews());
        code.setInitialViews(request.getViews());
        code.setSecret(request.getTime() > 0 || request.getViews() > 0);

        return code;
    }

    protected Code getCodeUpdated(String uuid) {
        Code code = codeRepository.findByUuid(uuid);

        if (code == null) {
            throw new CodeNotFoundException();
        }

        if (code.isSecret()) {
            code.setTimeLeft(code.getInitialTime() - Duration.between(code.getDate(), LocalDateTime.now()).toSeconds());
            code.setViewsLeft(code.getViewsLeft() - 1);

            codeRepository.save(code);

            if ((code.getTimeLeft() <= 0 && code.getInitialTime() > 0)
                    || (code.getViewsLeft() < 0 && code.getInitialViews() > 0)) {
                codeRepository.delete(code);

                throw new CodeNotFoundException();
            }
        }

        return code;
    }
}