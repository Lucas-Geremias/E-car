package com.ecar.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public Iterable<Carro> getCarros(){
        return rep.findAll();
    }

    public Optional<Carro> getCarroById(Long id) {
    return rep.findById(id);
    }

    public List<Carro> getCarroByTipo(String tipo) {
        return rep.findByTipo(tipo);
    }

    public Carro save(Carro carro) {
        return rep.save(carro);
    }

    public Carro update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        //Buscar o carro no banco de dados
        Optional<Carro> optional = getCarroById(id);
        if (optional.isPresent()){
            Carro db = optional.get();
            //copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            rep.save(db);

            return db;
        }else {
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }
    }

    public void delete(Long id) {
        Optional<Carro> carro = getCarroById(id);
        if (carro.isPresent()){
            rep.deleteById(id);
        }
    }
}