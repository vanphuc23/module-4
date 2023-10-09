package com.example.repository;

import com.example.model.Music;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@org.springframework.transaction.annotation.Transactional
public class MusicRepository implements IMusicRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = entityManager.createQuery("from Music", Music.class);
        return query.getResultList();
    }


    @Override
    @Transactional
    public void add(Music music) {
        if (music.getId() == null) {
            entityManager.persist(music);
        } else {
            entityManager.merge(music);
        }
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class, id);
    }

    @Transactional
    @Override
    public void update(Music musicUpdate, int id) {
        Music music = findById(id);
        BeanUtils.copyProperties(musicUpdate, music);
        entityManager.merge(music);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Music music = findById(id);
        entityManager.remove(music);
    }
}
