package minsang.mingmo.service;

import minsang.mingmo.domain.Memo;
import minsang.mingmo.repository.MemoryMemoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class MemoServiceTest {
    MemoService memoService;
    MemoryMemoRepository memoRepository;

    @BeforeEach
    public void beforeEach(){
        memoRepository = new MemoryMemoRepository();
        memoService = new MemoService(memoRepository);
    }

    @AfterEach
    public void afterEach(){
        memoRepository.clearStore();
    }

    @Test
    public void 글쓰기() throws Exception{
        //Given
        Memo memo = new Memo();
        memo.setContent("hello");

        //When
        Long saveId = memoService.join(memo);

        //Then
        Memo findMemo = memoRepository.findById(saveId).get();
        assertEquals(memo.getContent(),findMemo.getContent());
    }
/*
    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
   */


}
