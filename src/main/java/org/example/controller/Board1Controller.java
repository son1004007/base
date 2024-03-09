package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service.Board1Service;
import org.example.model.Board1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board1")
public class Board1Controller {

    private final Board1Service board1Service;

    /**
     * 게시판1(Board1) 등록 페이지로 이동하는 핸들러 메서드
     *
     * @param model 페이지 렌더링을 위한 모델 객체
     */
    @GetMapping("/register")
    public void getRegisterForm(Model model) {
        // 새로운 Board1 객체를 생성하여 모델에 추가하여 등록 페이지로 이동
        Board1 board1 = new Board1();
        model.addAttribute(board1);
    }

    /**
     * 게시판1(Board1) 등록 처리를 위한 핸들러 메서드
     *
     * @param board1 등록할 Board1 객체
     * @param result 입력 데이터의 유효성 검사 결과
     * @return 성공 또는 실패에 대한 응답
     * @throws Exception 예외 발생 시
     */
    @PostMapping("/register")
    public ResponseEntity<String> setRegisterForm(Board1 board1, BindingResult result) throws Exception {
        // 입력 데이터의 유효성 검사
        if (result.hasErrors()) {
            // 유효성 검사에 실패한 경우 에러 메시지를 로그에 기록하고 클라이언트에게 ERROR 응답을 전송
            log.info("Error 발생");
            // HttpStatus는 정상(200)을 던지고 메시지만 ERROR로 넘겨서 공격자가 서버 상태를 알 수 없도록함
            return ResponseEntity.ok("ERROR");
        }

        // 입력된 데이터를 이용하여 게시판1(Board1)을 등록
        board1Service.setRegister(board1);

        // 성공적으로 등록되면 SUCCESS 응답을 클라이언트에게 전송
        return ResponseEntity.ok("SUCCESS");
    }

    /**
     * 게시판1(Board1) 목록 조회 페이지로 이동하는 핸들러 메서드
     *
     * @param pageNumber 조회할 페이지 번호
     * @param model      페이지 렌더링을 위한 모델 객체
     * @throws Exception 예외 발생 시
     */
    @GetMapping("/list")
    public void getList(@RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model) throws Exception {
        // 게시판1(Board1)의 목록을 가져오는 서비스 호출
        List<Board1> list = board1Service.getList(pageNumber);

        // 전체 페이지 수를 가져오는 서비스 호출
        int totalPageCount = board1Service.getTotalPageCount();

        // 조회 결과 및 페이지 정보를 모델에 추가하여 뷰에서 사용할 수 있도록 함
        model.addAttribute("list", list);            // 전체 목록
        model.addAttribute("totalPageCount", totalPageCount);  // 전체 페이지
        model.addAttribute("page", pageNumber);     // 현재 페이지 번호
    }

    /**
     * 게시판1(Board1) 수정 페이지로 이동하는 핸들러 메서드
     *
     * @param id    수정할 게시물의 ID
     * @param model 페이지 렌더링을 위한 모델 객체
     */
    @GetMapping("/modify")
    public void getModifyForm(Long id, Model model) throws Exception {
        // 수정 대상 게시물 정보를 모델에 추가하여 수정 페이지로 이동
        model.addAttribute(board1Service.getModify(id));
    }

    /**
     * 게시판1(Board1) 수정 페이지에서 입력된 내용을 처리하는 핸들러 메서드
     *
     * @param board1 수정할 게시물 정보가 담긴 Board1 객체
     * @param model  화면에 전달할 데이터를 담은 Model 객체
     * @return 수정 결과에 따른 응답 메시지를 담은 페이지 경로
     * @throws Exception 수정 중 예외 발생 시
     */
    @PostMapping("/modify")
    public String setModifyForm(Board1 board1, Model model) {
        try {
            // 게시물 수정 처리
            board1Service.setModify(board1);

            // 성공적으로 수정되면 메시지를 모델에 추가하여 전달
            model.addAttribute("message", "수정이 완료되었습니다.");

            // 수정이 완료된 후 목록 페이지로 리다이렉트
            return "redirect:/board1/list";
        } catch (Exception e) {
            // 수정 중 예외가 발생한 경우 에러 메시지를 모델에 추가하여 전달
            model.addAttribute("message", "수정 중 오류가 발생했습니다.");

            // 수정 실패 시 다시 수정 페이지로 이동
            return "board1/modify";
        }
    }

    /**
     * 게시판1(Board1) 삭제 처리를 위한 핸들러 메서드
     *
     * @param id     삭제할 게시물의 ID
     * @param result 입력 데이터의 유효성 검사 결과
     * @return 성공 또는 실패에 대한 응답
     * @throws Exception 예외 발생 시
     */
    @PostMapping("/remove")
    public ResponseEntity<String> removeBoard1(@RequestParam Long id, BindingResult result) throws Exception {
        // 입력 데이터의 유효성 검사
        if (result.hasErrors()) {
            // 유효성 검사에 실패한 경우 에러 메시지를 로그에 기록하고 클라이언트에게 ERROR 응답을 전송
            log.info("Error 발생");
            // HttpStatus는 정상(200)을 던지고 메시지만 ERROR로 넘겨서 공격자가 서버 상태를 알 수 없도록 함
            return ResponseEntity.ok("ERROR");
        }

        // 입력된 데이터를 이용하여 게시판1(Board1) 삭제
        board1Service.remove(id);

        // 성공적으로 삭제되면 SUCCESS 응답을 클라이언트에게 전송
        return ResponseEntity.ok("SUCCESS");
    }

}
