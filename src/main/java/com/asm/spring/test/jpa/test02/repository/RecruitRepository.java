package com.asm.spring.test.jpa.test02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asm.spring.test.jpa.test02.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer>
{
	//public List<Recruit> findById(int id); //findById는 JpaRepository안에 이미 존재하므로 굳이 작성을 할 필요가 없다
	
	public List<Recruit> findByCompanyId(int companyId);
	
	public List<Recruit> findByPositionAndType(String position, String type);
	
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	//WHERE `region` = '성남시 분당구' AND `salary` BETWEEN 7000 AND 8500
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	@Query(value="SELECT * FROM `recruit`"
			+ " WHERE `deadline` > :deadline "
			+ "AND "
			+ "`salary` >= :salary", nativeQuery=true)
	public List<Recruit> selectByList(@Param("deadline") String deadline, @Param("salary") int salary);
	
}