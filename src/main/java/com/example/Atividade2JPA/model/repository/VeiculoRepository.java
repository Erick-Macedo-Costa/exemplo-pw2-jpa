package com.example.Atividade2JPA.model.repository;

import com.example.Atividade2JPA.model.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VeiculoRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Veiculo veiculo){
        em.persist(veiculo);
    }

    public Veiculo veiculo(Long id){
        return em.find(Veiculo.class, id);
    }

    public List<Veiculo> veiculos(){
        Query query = em.createQuery("from Veiculo");
        return query.getResultList();
    }

    public void remove(Long id){
        Veiculo p = em.find(Veiculo.class, id);
        em.remove(p);
    }

    public void update(Veiculo veiculo){
        em.merge(veiculo);
    }
}
