/**SbootRepositoty**/
package com.springdata.demo.repository;


import com.springdata.demo.popj.Sboot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by atben
 * 2018-01-24 15:11
 */
@Repository
public interface SbootRepositoty extends JpaRepository<Sboot,Integer>{
    /**
     * 非原生sql 查询
     * eg 1 查询直接使用 占位符传参， ?1代表传过来的第一个参数（如下的test1）  ?2代表传过来的第二个参数（如下的test2）
     *eg 2  查询直接使用 占位符传参， ?1代表传过来的第一个参数（如下的test1）  ?2代表传过来的第二个参数（如下的test2）
     */
    @Query(value = "select s from Sboot s where  s.test1 = ?1 AND s.test2 = ?2")
    List<Sboot> findList1(String test1,String test2);

    @Query(value = "select s from Sboot s where  s.test1 = :test1 AND s.test2 = :test2")
    List<Sboot> findList2(@Param("test1")String test1, @Param("test2")String test2);

    //模糊查询
    @Query("SELECT p FROM Person p WHERE p.lastName LIKE ?1 OR p.email LIKE ?2")
    List<Sboot> findList3(String test1,String test2);//test1 和test2 传过来的时候 就带有百分号

    @Query(value = "select s from Sboot s where  s.test1 LIKE %:test1% AND s.test2 LIKE %:test2%")
    List<Sboot> findList4(@Param("test1")String test1, @Param("test2")String test2);

    /**
     *  非原生查询结束
     */


    /**
     *  原生查询开始  后面需要带上参数 nativeQuery 并且值为true
     *  注释：当设置nativeQuery=true即可以使用原生SQL进行查询
     */
    @Query(value = "select * from sboot where test1 = ?1 AND test2 = ?2", nativeQuery = true)
    List<Sboot> findList5(String test1,String test2);

    @Query(value = "select * from sboot s where  s.test1 = :test1 AND s.test2 = :test2", nativeQuery = true)
    List<Sboot> findList6(@Param("test1")String test1, @Param("test2")String test2);
    /**
     *  原生查询结束
     */

//@modifying注解
//在@Query注解中编写JPQL实现DELETE和UPDATE操作的时候必须加上@modifying注解，以通知Spring Data 这是一个DELETE或UPDATE操作。
// 2、UPDATE或者DELETE操作需要使用事务，此时需要 定义Service层，在Service层的方法上添加事务操作。
// 3、注意JPQL不支持INSERT操作。　　
     @Transactional
     @Modifying
     @Query("UPDATE Sboot p SET p.test1 = :test1 WHERE p.id = :id")
     void updatePersonEmail(@Param("id") Integer id,@Param("test1")String test1);
//也可以直接使用原生sql 进行修改
    @Transactional
    @Modifying
    @Query(value = "update sboot set  test1 = :test1 where  id = :id", nativeQuery = true)
    void updatePersonEmail2(@Param("id") Integer id,@Param("test1")String test1);
}
