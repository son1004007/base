package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mapper.Board1Mapper;
import org.example.model.Board1;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class Board1ServiceImpl implements Board1Service {

    private final Board1Mapper board1Mapper;

    private static final int PAGE_SIZE = 5;

    /**
     * 게시판1(Board1) 등록 처리를 위한 핸들러 메서드
     *
     * @param board1 등록할 Board1 객체
     * @throws Exception 등록 중 예외 발생 시
     */
    @Override
    public void setRegister(Board1 board1) throws Exception {
        board1Mapper.create(board1); // 게시물 등록. 게시물 id를 생성하여 저장합니다.
    }

    /**
     * 게시판1(Board1)의 목록을 페이지별로 조회하는 메서드
     *
     * @param pageNumber 조회할 페이지 번호
     * @return Board1 엔티티의 목록
     * @throws Exception 조회 중 예외 발생 시
     */
    @Override
    public List<Board1> getList(int pageNumber) throws Exception {
        // 페이징 처리
        int offset = (pageNumber - 1) * PAGE_SIZE;
        List<Board1> board1List = board1Mapper.getList(offset, PAGE_SIZE);
        return board1List;
    }

    /**
     * 게시판1(Board1)의 전체 페이지 수를 조회하는 메서드
     *
     * @return 전체 페이지 수
     * @throws Exception 조회 중 예외 발생 시
     */
    @Override
    public int getTotalPageCount() throws Exception {
        // 전체 데이터 수 조회
        int totalDataCount = board1Mapper.count();
        // 전체 페이지 수 계산
        return (totalDataCount + PAGE_SIZE - 1) / PAGE_SIZE;
    }


    /**
     * 특정 ID의 게시물을 조회하는 메서드
     *
     * @param id 조회할 게시물의 ID
     * @return 조회된 Board1 객체
     * @throws Exception 조회 중 예외 발생 시
     */
    @Override
    public Board1 getModify(Long id) throws Exception {
        return board1Mapper.read(id);
    }

    /**
     * 게시물을 수정하는 메서드
     *
     * @param board1 수정할 게시물 정보가 담긴 Board1 객체
     * @throws Exception 수정 중 예외 발생 시
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setModify(Board1 board1) throws Exception {
        board1Mapper.update(board1);
    }

    /**
     * 특정 ID의 게시물을 삭제하는 메서드
     *
     * @param id 삭제할 게시물의 ID
     * @throws Exception 삭제 중 예외 발생 시
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) throws Exception {
        board1Mapper.delete(id);
    }

}
