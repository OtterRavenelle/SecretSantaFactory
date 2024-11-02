package main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Human;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class mainApp {

    public static void main(String[] args) throws IOException {
        File humanfile = new File("src/main/resources/HumanList.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Human> humanList = objectMapper.readValue(humanfile, new TypeReference<>() {
        });
        List<Human> santaList = objectMapper.readValue(humanfile, new TypeReference<>() {
        });
        System.out.println("Number of humans " + humanList.size());

        if (humanList.size() % 2 != 0) {
            System.out.println("HumanList.json size is odd, we need one more human to run the Secret Santa Factory ");
            return;
        }
        Map<Human, Human> offPrint = new HashMap<>();
        santaList
                .forEach(santa -> {
                    Collections.shuffle(humanList);
                    Optional<Human> selected = humanList.stream()
                            .filter(human -> !human.getFirstName().equals(santa.getFirstName()) &&// NOT SELF
                                    human.getLabel().equals(santa.getLabel()) &&
                                    !human.getLastName().equals(santa.getLastName()))
                            .findAny();

                    selected.ifPresent(human -> {
                        offPrint.put(santa, human);
                        humanList.remove(human);
                    });
                });

        offPrint.forEach((key, value) -> System.out.println("Santa " + key.getFirstName() + " -> " + value.getFirstName()));


    }


}
