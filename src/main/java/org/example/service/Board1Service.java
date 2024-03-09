package org.example.service;

import org.example.model.Board1;

import java.util.List;


public interface Board1Service {

    /**
     * 게시판1(Board1) 등록 처리를 위한 핸들러 메서드
     *
     * @param board1 등록할 Board1 객체
     * @throws Exception 예외 발생 시
     */
    public void setRegister(Board1 board1) throws Exception;

    /**
     * 게시판1(Board1)의 목록을 페이지별로 조회하는 메서드
     *
     * @param pageNumber 조회할 페이지 번호
     * @return Board1 엔티티의 목록
     * @throws Exception 조회 중 예외 발생 시
     */
    public List<Board1> getList(int pageNumber) throws Exception;

    /**
     * 게시판1(Board1)의 전체 페이지 수를 조회하는 메서드
     *
     * @return 전체 페이지 수
     * @throws Exception 조회 중 예외 발생 시
     */
    public int getTotalPageCount() throws Exception;

    /**
     * 게시판1(Board1) 수정 페이지에서 입력된 내용을 처리하는 핸들러 메서드
     *
     * @param id 수정할 게시물의 ID
     * @return 수정할 게시물 정보를 담은 Board1 객체
     * @throws Exception 수정 중 예외 발생 시
     */
    public Board1 getModify(Long id) throws Exception;

    /**
     * 게시판1(Board1)의 수정 처리를 위한 핸들러 메서드
     *
     * @param board1 수정할 게시물 정보가 담긴 Board1 객체
     * @throws Exception 수정 중 예외 발생 시
     */
    public void setModify(Board1 board1) throws Exception;

    /**
     * 게시판1(Board1)의 삭제 처리를 위한 핸들러 메서드
     *
     * @param id 삭제할 게시물의 ID
     * @throws Exception 삭제 중 예외 발생 시
     */
    public void remove(Long id) throws Exception;
}
