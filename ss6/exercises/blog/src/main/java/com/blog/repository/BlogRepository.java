package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("from Blog", Blog.class);
        return query.getResultList();
    }

    @Override
    public void add(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public Blog read(int id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void update(Blog blog, int id) {
        Blog blogUpdate = read(id);
        BeanUtils.copyProperties(blog, blogUpdate);
        entityManager.merge(blogUpdate);
    }

    @Override
    public void delete(int id) {
        Blog blog = read(id);
        entityManager.remove(blog);
    }
}
