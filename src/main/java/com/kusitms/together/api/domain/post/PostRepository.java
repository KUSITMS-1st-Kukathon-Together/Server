package com.kusitms.together.api.domain.post;

import com.kusitms.together.api.service.distance.DistanceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT DATA.post_id,DATA.title,DATA.location,DATA.content,DATA.created_date FROM (SELECT  post_id,title,location,content,created_date ,( 6371 * acos( cos( radians(:latitude) ) * cos( radians(o.latitude) ) * cos( radians( o.longitude ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians(o.latitude) ) ) ) AS distance FROM og_post as o ) DATA WHERE DATA.distance < 2", nativeQuery = true)
    List<String> getPostByDistance(@Param("latitude") double latitude, @Param("longitude") double longitude);


    List<DistanceDto> findAllByCategoryAndTypeOrderByCreatedDateDesc(Category category, Type type);


    @Query("select new com.kusitms.together.api.service.distance.DistanceDto(p.id,p.title,p.location,p.content,p.createdDate) from Post p where p.category =:category and p.type =:type order by p.createdDate desc")
    List<DistanceDto> getAllPostByCategoryAndType(@Param("category") Category category, @Param("type") Type type);

    @Query("select new com.kusitms.together.api.service.distance.DistanceDto(p.id,p.title,p.location,p.content,p.createdDate) from Post p where p.title like %:keyword% order by p.createdDate desc")
    List<DistanceDto> getAllPostByKeyword(@Param("keyword") String keyword);
}

//

//    SELECT DATA.title
//        FROM (
//        SELECT  title , ( 6371 * acos( cos( radians(37.49573530262187 ) ) * cos( radians(o.latitude) ) * cos( radians( o.longitude ) - radians(127.03876300500951) ) + sin( radians(37.49573530262187) ) * sin( radians(o.latitude) ) ) ) AS distance
//        FROM og_post as o
//        ) DATA
//        WHERE DATA.distance < 2