package com.picture.repository;

import com.picture.model.Picture;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PictureRepository implements IPictureRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Picture> findAll() {
        TypedQuery<Picture> query = entityManager.createQuery("from Picture", Picture.class);
        return query.getResultList();
    }

    @Override
    public boolean add(Picture picture) {
        try{
            entityManager.persist(picture);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Picture findById(int id) {
        return entityManager.find(Picture.class,id);
    }

    @Override
    public boolean updateAwesome(int id) {
        try {
            Picture picture = findById(id);
            picture.setAwesome(picture.getAwesome()+1);
            entityManager.merge(picture);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGreat(int id) {
        try {
            Picture picture = findById(id);
            picture.setGreat(picture.getGreat()+1);
            entityManager.merge(picture);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
