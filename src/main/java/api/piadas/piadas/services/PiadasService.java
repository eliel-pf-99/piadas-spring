package api.piadas.piadas.services;

import api.piadas.piadas.data.PiadaDAO;
import api.piadas.piadas.data.Piadas;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class PiadasService {
    private final List<PiadaDAO> piadas;

    public PiadasService() throws IOException {
        this.piadas = Piadas.loadPiadas();
    }
    public PiadaDAO getPiadaRandom(){
        return getPiada(getRandomNumber());
    }

    public List<PiadaDAO> getMultiPiadasRandom(int times){
        List<PiadaDAO> response = new ArrayList<>();
        for(int i : generateIndexes(times)) response.add(getPiada(i));
        return response;
    }

    private PiadaDAO getPiada(int index){
        PiadaDAO response = piadas.get(index);
        response.setIndex(index);
        return response;
    }

    private int getRandomNumber(){
        return (int)(Math.random() * piadas.size());
    }

    private int[] generateIndexes(int times){
        int[] indexes = new int[times];
        int i = 0;
        while(i < times){
            int index = getRandomNumber();
            if(IntStream.of(indexes).noneMatch(x -> x == index)){
                indexes[i] = index;
                i++;
            }
        }
        return indexes;
    }
}