package platform.Loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import platform.Entities.Code;
import platform.Repositories.CodeRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
/*
@Component
public class DataLoader {
    private final CodeRepository codeRepository;

    @Autowired
    public DataLoader(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @PostConstruct
    public void init() {
        if (codeRepository.count() == 0) {
            Code code = new Code();
            
            code.setCode("public static void main(String[] args) {\n" +
                    "    SpringApplication.run(CodeSharingPlatform.class, args);}");
            code.setDate(LocalDateTime.now());

            codeRepository.save(code);
        }
    }
} */