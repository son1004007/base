package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.Board1;

import java.util.List;

@Mapper
public interface Board1Mapper {


    /**
     * 게시판1(Board1) 등록 처리를 위한 핸들러 메서드
     *
     * @param board1 등록할 Board1 객체
     * @throws Exception 등록 중 예외 발생 시
     */
    public void create(Board1 board1) throws Exception;

    /**
     * 페이징 처리를 포함한 게시판1(Board1)의 목록을 조회하는 메서드
     *
     * @param offset   조회 시작 위치
     * @param pageSize 페이지당 데이터 수
     * @return Board1 엔티티의 목록
     * @throws Exception 조회 중 예외 발생 시
     */
    public List<Board1> getList(@Param("offset") int offset, @Param("pageSize") int pageSize) throws Exception;

    /**
     * 게시판1(Board1)의 전체 데이터 수를 조회하는 메서드
     *
     * @return 전체 데이터 수
     * @throws Exception 조회 중 예외 발생 시
     */
    public int count() throws Exception;

    /**
     * 특정 ID의 게시물을 조회하는 메서드
     *
     * @param id 조회할 게시물의 ID
     * @return 조회된 Board1 객체
     * @throws Exception 조회 중 예외 발생 시
     */
    public Board1 read(Long id) throws Exception;

    /**
     * 게시물을 수정하는 메서드
     *
     * @param board1 수정할 게시물 정보가 담긴 Board1 객체
     * @throws Exception 수정 중 예외 발생 시
     */
    public void update(Board1 board1) throws Exception;

    /**
     * 특정 ID의 게시물을 삭제하는 메서드
     *
     * @param id 삭제할 게시물의 ID
     * @throws Exception 삭제 중 예외 발생 시
     */
    public void delete(Long id) throws Exception;
}
