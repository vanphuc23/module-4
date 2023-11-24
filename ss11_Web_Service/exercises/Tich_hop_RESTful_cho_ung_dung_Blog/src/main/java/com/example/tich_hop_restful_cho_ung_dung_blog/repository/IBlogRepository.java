package com.example.tich_hop_restful_cho_ung_dung_blog.repository;




import com.example.tich_hop_restful_cho_ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByTitleContaining(Pageable pageable,String searchTitle);
    @Query(value = "select * from Blog  where category_id = :categoryId", nativeQuery = true)
    Page<Blog> showListCategoryId(Pageable pageable,@Param("categoryId") int categoryId);
    @Query(value = "select * from Blog where category_id = :categoryId", nativeQuery = true)
    List<Blog> showListBlog(@Param("categoryId") int categoryId);
}
