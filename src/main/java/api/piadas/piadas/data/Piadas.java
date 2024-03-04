package api.piadas.piadas.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class Piadas {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<PiadaDAO> loadPiadas() throws IOException {
        TypeReference<List<PiadaDAO>> typeReference = new TypeReference<List<PiadaDAO>>() {};
        InputStream inputStream = new FileInputStream(new File("src/main/resources/jokes.json")){};
        return mapper.readValue(inputStream, typeReference);
    }
}
