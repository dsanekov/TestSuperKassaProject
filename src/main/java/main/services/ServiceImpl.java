package main.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.dto.ObjectDTO;
import main.dto.Response;
import main.model.Entity;
import main.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Slf4j
public class ServiceImpl implements Service {
    @Autowired
    private final EntityRepository repository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Response modify(int id, int add){
        Response response = new Response();
        if(repository.findById(id) == null){
            response.setCurrent(-1);
            return response;
        }
        Entity entityFromDB = repository.findById(id);
        try {
            ObjectDTO objectDTO = objectMapper.readValue(entityFromDB.getJsonProperty(), ObjectDTO.class);
            int current = objectDTO.getNumber()+add;
            objectDTO.setNumber(current);
            String json = objectMapper.writeValueAsString(objectDTO);
            entityFromDB.setJsonProperty(json);
            repository.save(entityFromDB);
            response.setCurrent(current);
            return response;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
