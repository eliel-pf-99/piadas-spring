package api.piadas.piadas.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

@Component
public class Piadas {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<PiadaDAO> loadPiadas(){
        try{
            TypeReference<List<PiadaDAO>> typeReference = new TypeReference<List<PiadaDAO>>() {};
            ClassPathResource resource = new ClassPathResource("jokes.json");
            InputStream inputStream = resource.getInputStream();
            return mapper.readValue(inputStream, typeReference);
        } catch (IOException e){
            System.out.println("Error:: "+ e.getMessage());
        }
        return null;
    }
}
